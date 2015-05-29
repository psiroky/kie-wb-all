package org.kie.workbench.common.screens.server.management.client.artifact;

import javax.enterprise.context.Dependent;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ButtonCell;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import org.guvnor.m2repo.client.widgets.ArtifactListView;
import org.guvnor.m2repo.model.JarListPageRow;

@Dependent
public class DependencyListWidgetView
        extends Composite implements DependencyListWidgetPresenter.View {

    interface Binder
            extends
            UiBinder<Widget, DependencyListWidgetView> {

    }

    private static Binder uiBinder = GWT.create( Binder.class );

    @UiField
    FlowPanel panel;

    @UiField
    TextBox filter;

    @UiField
    Button search;

    private DependencyListWidgetPresenter presenter;

    public DependencyListWidgetView() {
        initWidget( uiBinder.createAndBindUi( this ) );
    }

    @Override
    public void init( final DependencyListWidgetPresenter presenter ) {
        this.presenter = presenter;

        search.addClickHandler( new ClickHandler() {
            @Override
            public void onClick( ClickEvent event ) {
                presenter.search( filter.getText() );
            }
        } );

        final ArtifactListView artifactListView = presenter.getArtifactListPresenter().getView();

        artifactListView.addColumn( buildSelectColumn(), "Select" );

        artifactListView.setContentHeight( "200px" );

        panel.add( artifactListView );
    }

    private Column<JarListPageRow, String> buildSelectColumn() {
        return new Column<JarListPageRow, String>( new ButtonCell() {{
            setSize( ButtonSize.MINI );
        }} ) {
            public String getValue( final JarListPageRow row ) {
                return "Select";
            }

            {
                setFieldUpdater( new FieldUpdater<JarListPageRow, String>() {
                    public void update( final int index,
                                        final JarListPageRow row,
                                        final String value ) {
                        presenter.onSelect( row.getPath() );
                    }
                } );
            }
        };
    }
}
