package org.guvnor.m2repo.client.editor;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.github.gwtbootstrap.client.ui.ButtonCell;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RequiresResize;
import org.guvnor.m2repo.client.widgets.ArtifactListPresenter;
import org.guvnor.m2repo.model.JarListPageRow;
import org.uberfire.security.Identity;

import static org.guvnor.m2repo.security.AppRole.*;

@Dependent
public class MavenRepositoryPagedJarTable
        extends Composite
        implements RequiresResize {

    @Inject
    private ArtifactListPresenter presenter;

    @Inject
    protected Identity identity;

    @Override
    public void onResize() {
        if ( ( getParent().getOffsetHeight() - 120 ) > 0 ) {
            presenter.getView().setContentHeight( getParent().getOffsetHeight() - 120 + "px" );
        }
    }

    @PostConstruct
    public void init() {
        //If the current user is not an Administrator do not include the download button
        if ( identity.hasRole( ADMIN ) ) {
            final Column<JarListPageRow, String> downloadColumn = new Column<JarListPageRow, String>( new ButtonCell() {{
                setSize( ButtonSize.MINI );
            }} ) {
                public String getValue( JarListPageRow row ) {
                    return "Download";
                }
            };

            downloadColumn.setFieldUpdater( new FieldUpdater<JarListPageRow, String>() {
                public void update( int index,
                                    JarListPageRow row,
                                    String value ) {
                    Window.open( getFileDownloadURL( row.getPath() ),
                                 "downloading",
                                 "resizable=no,scrollbars=yes,status=no" );
                }
            } );

            presenter.getView().addColumn( downloadColumn, null, "Download" );
        }

        initWidget( presenter.getView().asWidget() );
    }

    private String getFileDownloadURL( final String path ) {
        String url = getGuvnorM2RepoBaseURL() + path;
        return url;
    }

    private String getGuvnorM2RepoBaseURL() {
        final String url = GWT.getModuleBaseURL();
        final String baseUrl = url.replace( GWT.getModuleName() + "/", "" );
        return baseUrl + "maven2/";
    }

    public void search( String filter ) {
        presenter.search( filter );
    }

    public void refresh() {
        presenter.refresh();
    }
}
