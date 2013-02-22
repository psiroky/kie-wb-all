package org.kie.guvnor.defaulteditor.client.editor;

import com.google.gwt.user.client.ui.IsWidget;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.kie.guvnor.commons.service.metadata.model.Metadata;
import org.kie.guvnor.commons.ui.client.menu.FileMenuBuilder;
import org.kie.guvnor.commons.ui.client.resources.i18n.CommonConstants;
import org.kie.guvnor.commons.ui.client.save.CommandWithCommitMessage;
import org.kie.guvnor.commons.ui.client.save.SaveOperationService;
import org.kie.guvnor.defaulteditor.service.DefaultEditorService;
import org.kie.guvnor.metadata.client.widget.MetadataWidget;
import org.kie.guvnor.services.metadata.MetadataService;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.annotations.IsDirty;
import org.uberfire.client.annotations.OnClose;
import org.uberfire.client.annotations.OnReveal;
import org.uberfire.client.annotations.OnSave;
import org.uberfire.client.annotations.OnStart;
import org.uberfire.client.annotations.WorkbenchEditor;
import org.uberfire.client.annotations.WorkbenchMenu;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.common.MultiPageEditor;
import org.uberfire.client.common.Page;
import org.uberfire.client.editors.texteditor.TextEditorPresenter;
import org.uberfire.client.editors.texteditor.TextResourceType;
import org.uberfire.client.mvp.Command;
import org.uberfire.client.workbench.widgets.menu.Menus;
import org.uberfire.shared.mvp.PlaceRequest;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.New;
import javax.inject.Inject;

@Dependent
@WorkbenchEditor(identifier = "GuvnorTextEditor", supportedTypes = { TextResourceType.class }, priority = -1)
public class GuvnorTextEditorPresenter
        extends TextEditorPresenter {

    @Inject
    private MultiPageEditor multiPage;

    @Inject
    private Caller<DefaultEditorService> defaultEditorService;

    @Inject
    @New
    private FileMenuBuilder menuBuilder;

    @Inject
    private Caller<MetadataService> metadataService;

    private Menus menus;

    private final MetadataWidget metadataWidget = new MetadataWidget();
    private boolean isReadOnly;
    private Path    path;

    @OnStart
    public void onStart( final Path path,
                         final PlaceRequest place ) {
        super.onStart( path );

        this.path = path;

        isReadOnly = place.getParameter( "readOnly", null ) == null ? false : true;

        makeMenuBar();
    }

    private void makeMenuBar() {
        if ( isReadOnly ) {
            menus = menuBuilder.addRestoreVersion( path ).build();
        } else {
            menus = menuBuilder
                    .addSave(
                            new Command() {
                                @Override
                                public void execute() {
                                    onSave();
                                }
                            } )
                    .addCopy( path )
                    .addRename( path )
                    .addDelete( path )
                    .build();
        }
    }

    @OnSave
    public void onSave() {
        new SaveOperationService().save( path, new CommandWithCommitMessage() {
            @Override
            public void execute( final String comment ) {
                if ( metadataWidget.isDirty() ) {
                    defaultEditorService.call(
                            new RemoteCallback<Void>() {
                                @Override
                                public void callback( Void o ) {
                                    metadataWidget.resetDirty();
                                    view.setDirty( false );
                                }
                            }
                                             ).save( path, view.getContent(), metadataWidget.getContent(), comment );
                } else {
                    defaultEditorService.call(
                            new RemoteCallback<Void>() {
                                @Override
                                public void callback( Void o ) {
                                    view.setDirty( false );
                                }
                            }
                                             ).save( path, view.getContent(), comment );
                }
            }
        } );
    }

    @WorkbenchMenu
    public Menus getMenus() {
        return menus;
    }

    @IsDirty
    public boolean isDirty() {
        return super.isDirty();
    }

    @OnClose
    public void onClose() {
        super.onClose();
    }

    @OnReveal
    public void onReveal() {
        super.onReveal();
    }

    @WorkbenchPartTitle
    public String getTitle() {
        return super.getTitle();
    }

    @WorkbenchPartView
    public IsWidget getWidget() {
        multiPage.addWidget( super.getWidget(),
                             CommonConstants.INSTANCE.EditTabTitle() );

        multiPage.addPage( new Page( metadataWidget, CommonConstants.INSTANCE.MetadataTabTitle() ) {
            @Override
            public void onFocus() {
                metadataService.call( new RemoteCallback<Metadata>() {
                    @Override
                    public void callback( final Metadata metadata ) {
                        metadataWidget.setContent( metadata,
                                                   isReadOnly );
                    }
                } ).getMetadata( path );
            }

            @Override
            public void onLostFocus() {

            }
        } );

        return multiPage;
    }
}