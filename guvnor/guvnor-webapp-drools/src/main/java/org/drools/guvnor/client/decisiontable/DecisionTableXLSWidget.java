/*
 * Copyright 2011 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.drools.guvnor.client.decisiontable;

import org.drools.guvnor.client.asseteditor.AssetAttachmentFileWidget;
import org.drools.guvnor.client.asseteditor.RuleViewer;
import org.drools.guvnor.client.common.AssetFormats;
import org.drools.guvnor.client.common.GenericCallback;
import org.drools.guvnor.client.common.LoadingPopup;
import org.drools.guvnor.client.explorer.AssetEditorPlace;
import org.drools.guvnor.client.explorer.ClientFactory;
import org.drools.guvnor.client.explorer.RefreshModuleEditorEvent;
import org.drools.guvnor.client.messages.Constants;
import org.drools.guvnor.client.resources.Images;
import org.drools.guvnor.client.rpc.Asset;
import org.drools.guvnor.client.rpc.ConversionResult;
import org.drools.guvnor.client.rpc.ConversionResult.ConversionMessage;
import org.drools.guvnor.client.widgets.PopupListWidget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * This widget deals with XLS files in "classic" decision tables.
 */
public class DecisionTableXLSWidget extends AssetAttachmentFileWidget {

    public DecisionTableXLSWidget(Asset asset,
                                  RuleViewer viewer,
                                  ClientFactory clientFactory,
                                  EventBus eventBus) {
        super( asset,
               viewer,
               clientFactory,
               eventBus );

        //Set-up supplementary widgets
        if ( !asset.isReadonly() ) {
            //TODO {manstis} Uncomment - super.addSupplementaryWidget( makeConvertToGuidedDecisionTableWidget( asset ) );
        }
        super.addSupplementaryWidget( makeDescriptionWidget() );
    }

    //Button to convert XLS- to Guided Decision Table
    private Widget makeConvertToGuidedDecisionTableWidget(Asset asset) {
        Button convertButton = new Button( Constants.INSTANCE.ConvertTo0( Constants.INSTANCE.DecisionTableWebGuidedEditor() ) );
        convertButton.setEnabled( asset.versionNumber > 0 );
        convertButton.addClickHandler( getConvertButtonClickHandler() );
        return convertButton;
    }

    private ClickHandler getConvertButtonClickHandler() {
        return new ClickHandler() {

            public void onClick(ClickEvent event) {
                LoadingPopup.showMessage( Constants.INSTANCE.SavingPleaseWait() );
                clientFactory.getAssetService().convertAsset( asset.getUuid(),
                                                              AssetFormats.DECISION_TABLE_GUIDED,
                                                              new GenericCallback<ConversionResult>() {

                                                                  public void onSuccess(ConversionResult result) {
                                                                      postConversion( result );
                                                                  }

                                                              } );
            }

        };
    }

    //Handle post-conversion operations.
    private void postConversion(final ConversionResult result) {
        LoadingPopup.close();

        if ( result.getMessages().size() > 0 ) {

            //Show messages to user
            PopupListWidget popup = new PopupListWidget( 400,
                                                         200 );
            for ( ConversionMessage message : result.getMessages() ) {
                popup.addListItem( new ConversionMessageWidget( message ) );
            }

            //When closed open the new asset
            popup.addCloseHandler( new CloseHandler<PopupPanel>() {

                @Override
                public void onClose(CloseEvent<PopupPanel> event) {
                    openEditor( result );
                }

            } );
            popup.show();

        } else {
            //Otherwise just show the new asset
            openEditor( result );
        }
    }

    private void openEditor(ConversionResult result) {
        if ( result.isConverted() ) {
            clientFactory.getPlaceController().goTo( new AssetEditorPlace( result.getUUID() ) );
            eventBus.fireEvent( new RefreshModuleEditorEvent( asset.getMetaData().getModuleUUID() ) );
        }
    }

    private Widget makeDescriptionWidget() {
        return new HTML( Constants.INSTANCE.DecisionTableWidgetDescription() );
    }

    public ImageResource getIcon() {
        return Images.INSTANCE.decisionTable();
    }

    public String getOverallStyleName() {
        return "decision-Table-upload"; //NON-NLS
    }

}
