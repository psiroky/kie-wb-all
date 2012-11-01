/*
 * Copyright 2005 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.guvnor.client.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.event.shared.EventBus;

import com.google.gwt.user.client.ui.*;
import org.drools.guvnor.client.asseteditor.RuleViewerWrapper;
import org.drools.guvnor.client.common.FormStylePopup;
import org.drools.guvnor.client.common.GenericCallback;
import org.drools.guvnor.client.common.LoadingPopup;
import org.drools.guvnor.client.explorer.ClientFactory;
import org.drools.guvnor.client.messages.ConstantsCore;
import org.drools.guvnor.client.resources.ImagesCore;
import org.drools.guvnor.client.rpc.*;
import org.drools.guvnor.client.rpc.Path;
import org.drools.guvnor.client.rpc.PathImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;


/**
 * This widget shows a list of versions.
 *
 */
public class VersionChooser extends Composite {

    private ConstantsCore constants = GWT.create( ConstantsCore.class );
    private static ImagesCore images    = GWT.create( ImagesCore.class );
    private AssetServiceAsync assetService = GWT.create(AssetService.class);

    private String        packageUUID;
    private String        assetName;
    private ListBox versionChooser;
    private List<TableDataRow> versionInfo = new ArrayList<TableDataRow>();
    private String currentVersion;
    private final ClientFactory clientFactory;
    private final EventBus eventBus;

    public VersionChooser( ClientFactory clientFactory,
                           EventBus eventBus,
                           String currentVersion,
                           String pacakgeUUID,
                           String assetName,
                           Command ref ) {
        this.clientFactory = clientFactory;
        this.eventBus = eventBus;
        this.packageUUID = pacakgeUUID;
        this.assetName = assetName;
        this.currentVersion = currentVersion;

        VerticalPanel verticalPanel = new VerticalPanel();
        versionChooser = new ListBox();
        loadHistoryData();
        verticalPanel.add(versionChooser);

        Button open = new Button( "View selected version" );
        open.addClickHandler( new ClickHandler() {
            public void onClick(ClickEvent event) {
            	if(!constants.NoHistory().equalsIgnoreCase(versionChooser.getValue(versionChooser.getSelectedIndex()))) {
                    showVersion( versionChooser.getValue( versionChooser.getSelectedIndex() ) );
            	} 
            }

        } );
        verticalPanel.add(open);       

        initWidget( verticalPanel );
    }

    /**
     * Actually load the history data, as demanded.
     */
    protected void loadHistoryData() {
        assetService.loadAssetHistory( packageUUID,
        		                                                assetName,
                                                                new GenericCallback<TableDataResult>() {
                                                                    public void onSuccess(TableDataResult table) {
                                                                        if ( table == null || table.data.length ==0) {
                                                                            versionChooser.addItem(constants.NoHistory());
                                                                            versionInfo.add(null);
                                                                            return;
                                                                        }
                                                                        TableDataRow[] rows = table.data;
                                                                        Arrays.sort( rows,
                                                                                     new Comparator<TableDataRow>() {
                                                                                         public int compare(TableDataRow r1,
                                                                                                            TableDataRow r2) {                                                                                         
                                                                                             Integer v2 = Integer.valueOf( r2.values[0] );
                                                                                             Integer v1 = Integer.valueOf( r1.values[0] );

                                                                                             return v2.compareTo( v1 );
                                                                                         }
                                                                                     } );

                                                                        for (TableDataRow row : rows) {
                                                                            String s = constants.property0ModifiedOn1By23(
                                                                                    row.values[0],
                                                                                    row.values[2],
                                                                                    row.values[4],
                                                                                    row.values[1]);
                                                                            versionChooser.addItem(s,
                                                                                    row.id);
                                                                            versionInfo.add(row);
                                                                        }
                                                                        selectCurrentVersion(currentVersion);
                                                                    }
                                                                } );

    }
    
    public String getSelectedVersionUUID() {
    	if(versionChooser != null) {
    	    return versionChooser.getValue(versionChooser.getSelectedIndex());
    	} else {
    		return null;
    	}
    }
    
    private void selectCurrentVersion(String currentVersion) {
        for(int i=0;i<versionInfo.size(); i++) {
            TableDataRow row = versionInfo.get(i);
            if(row.values[0].equals(currentVersion)) {
                versionChooser.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public String getSelectedVersionName() {
        if(versionChooser != null) {
        	TableDataRow t = versionInfo.get(versionChooser.getSelectedIndex());
        	if(t != null) {
        		return t.values[0];
        	} 
        } 
        return null;        
    }

    /**
     * This should popup a view of the chosen historical version.
     */
    private void showVersion(final String versionUUID) {
        LoadingPopup.showMessage( constants.LoadingVersionFromHistory() );
    	Path path = new PathImpl();
    	path.setUUID(versionUUID);
        assetService.loadRuleAsset( path,
                                                             new GenericCallback<Asset>() {

                                                                 public void onSuccess(Asset asset) {
                                                                     asset.setReadonly( true );
                                                                     Image image = new Image(images.snapshot());
                                                                     image.setAltText(ConstantsCore.INSTANCE.Snapshot());
                                                                     final FormStylePopup pop = new FormStylePopup(image,
                                                                                                                    constants.VersionNumber0Of1(
                                                                                                                                   asset.getVersionNumber(),
                                                                                                                                   asset.getName() ),
                                                                             800);

                                                                     RuleViewerWrapper viewer = new RuleViewerWrapper(
                                                                             clientFactory,
                                                                             eventBus,
                                                                             asset,
                                                                             true
                                                                                                                                                          );
                                                                     viewer.setWidth( "100%" );
                                                                     viewer.setHeight( "100%" );

                                                                     pop.addRow( viewer );
                                                                     pop.show();
                                                                 }
                                                             } );
    }

}
