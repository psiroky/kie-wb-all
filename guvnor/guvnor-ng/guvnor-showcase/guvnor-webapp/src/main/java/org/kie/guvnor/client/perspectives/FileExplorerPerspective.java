/*
 * Copyright 2012 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.kie.guvnor.client.perspectives;

import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.container.IOCBeanDef;
import org.jboss.errai.ioc.client.container.IOCBeanManager;
import org.kie.guvnor.client.resources.i18n.Constants;
import org.kie.guvnor.commons.ui.client.handlers.NewItemWidget;
import org.kie.guvnor.commons.ui.client.handlers.NewResourceHandler;
import org.uberfire.client.annotations.Perspective;
import org.uberfire.client.annotations.WorkbenchMenu;
import org.uberfire.client.annotations.WorkbenchPerspective;
import org.uberfire.client.annotations.WorkbenchToolBar;
import org.uberfire.client.mvp.Command;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.client.workbench.Position;
import org.uberfire.client.workbench.model.PanelDefinition;
import org.uberfire.client.workbench.model.PerspectiveDefinition;
import org.uberfire.client.workbench.model.impl.PanelDefinitionImpl;
import org.uberfire.client.workbench.model.impl.PartDefinitionImpl;
import org.uberfire.client.workbench.model.impl.PerspectiveDefinitionImpl;
import org.uberfire.client.workbench.widgets.menu.MenuBar;
import org.uberfire.client.workbench.widgets.menu.impl.DefaultMenuBar;
import org.uberfire.client.workbench.widgets.menu.impl.DefaultMenuItemCommand;
import org.uberfire.client.workbench.widgets.menu.impl.DefaultMenuItemSubMenu;
import org.uberfire.client.workbench.widgets.toolbar.ToolBar;
import org.uberfire.client.workbench.widgets.toolbar.impl.DefaultToolBar;
import org.uberfire.client.workbench.widgets.toolbar.impl.DefaultToolBarItem;
import org.uberfire.shared.mvp.impl.DefaultPlaceRequest;

/**
 * A Perspective to show File Explorer
 */
@ApplicationScoped
@WorkbenchPerspective(identifier = "FileExplorerPerspective", isDefault = true)
public class FileExplorerPerspective {

    @Inject
    private IOCBeanManager iocBeanManager;

    @Inject
    private NewItemWidget newItemWidget;

    @Inject
    private PlaceManager placeManager;

    private PerspectiveDefinition perspective;
    private MenuBar menuBar;
    private ToolBar toolBar;

    @PostConstruct
    public void init() {
        buildPerspective();
        buildMenuBar();
        buildToolBar();
    }

    @Perspective
    public PerspectiveDefinition getPerspective() {
        return this.perspective;
    }

    @WorkbenchMenu
    public MenuBar getMenuBar() {
        return this.menuBar;
    }

    @WorkbenchToolBar
    public ToolBar getToolBar() {
        return this.toolBar;
    }

    private void buildPerspective() {
        this.perspective = new PerspectiveDefinitionImpl();
        this.perspective.setName( "File Explorer" );

        this.perspective.getRoot().addPart( new PartDefinitionImpl( new DefaultPlaceRequest( "RepositoriesEditor" ) ) );

        final PanelDefinition west = new PanelDefinitionImpl();
        west.setWidth( 300 );
        west.setMinWidth( 200 );
        west.addPart( new PartDefinitionImpl( new DefaultPlaceRequest( "FileExplorer" ) ) );

        this.perspective.getRoot().insertChild( Position.WEST, west );
    }

    private void buildMenuBar() {
        this.menuBar = new DefaultMenuBar();
        this.menuBar.addItem( new DefaultMenuItemCommand( "File Explorer",
                                                         new Command() {
                                                             @Override
                                                             public void execute() {
                                                                 placeManager.goTo( "FileExplorer" );
                                                             }
                                                         } ) );

        final MenuBar subMenuBar = new DefaultMenuBar();
        this.menuBar.addItem( new DefaultMenuItemSubMenu( "New",
                                                          subMenuBar ) );

        //Dynamic items
        final Collection<IOCBeanDef<NewResourceHandler>> handlerBeans = iocBeanManager.lookupBeans( NewResourceHandler.class );
        if ( handlerBeans.size() > 0 ) {
            for ( IOCBeanDef<NewResourceHandler> handlerBean : handlerBeans ) {
                final NewResourceHandler handler = handlerBean.getInstance();
                final String description = handler.getDescription();
                subMenuBar.addItem( new DefaultMenuItemCommand( description,
                                                                 new Command() {
                                                                     @Override
                                                                     public void execute() {
                                                                         newItemWidget.setActiveHandler( handler );
                                                                         newItemWidget.show();
                                                                     }
                                                                 } ) );
            }
        }

    }

    private void buildToolBar() {
        this.toolBar = new DefaultToolBar();
        final String url = "images/new_item.png";
        final String tooltip = Constants.INSTANCE.newItem();
        final Command command = new Command() {
            @Override
            public void execute() {
                newItemWidget.show();
            }
        };
        toolBar.addItem( new DefaultToolBarItem( url,
                                                 tooltip,
                                                 command ) );

    }

}
