package org.drools.workbench.screens.guided.dtree.client.editor;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree;
import org.drools.workbench.screens.guided.dtree.client.widget.GuidedDecisionTreeWidget;
import org.drools.workbench.screens.guided.dtree.client.widget.palette.GuidedDecisionTreePalette;
import org.jboss.errai.common.client.api.Caller;
import org.kie.workbench.common.services.shared.rulename.RuleNamesService;
import org.kie.workbench.common.widgets.client.datamodel.AsyncPackageDataModelOracle;
import org.kie.workbench.common.widgets.client.resources.i18n.CommonConstants;
import org.kie.workbench.common.widgets.metadata.client.KieEditorViewImpl;
import org.uberfire.backend.vfs.Path;

/**
 * The Guided Decision Tree Editor View implementation
 */
public class GuidedDecisionTreeEditorViewImpl
        extends KieEditorViewImpl
        implements GuidedDecisionTreeEditorView {

    private static GuidedDecisionTreeEditorViewBinder uiBinder = GWT.create( GuidedDecisionTreeEditorViewBinder.class );

    interface GuidedDecisionTreeEditorViewBinder
            extends
            UiBinder<Widget, GuidedDecisionTreeEditorViewImpl> {

    }

    @UiField
    SimplePanel holderCanvas;

    @UiField
    SimplePanel holderPalette;

    @Inject
    private GuidedDecisionTreeWidget canvas;

    @Inject
    private GuidedDecisionTreePalette palette;

    private boolean isDirty = false;
    private boolean isReadOnly = false;
    private GuidedDecisionTree model;

    public GuidedDecisionTreeEditorViewImpl() {
        initWidget( uiBinder.createAndBindUi( this ) );
    }

    @PostConstruct
    public void setup() {
        holderCanvas.setWidget( canvas );
        holderPalette.setWidget( palette );
    }

    @Override
    public void init( final GuidedDecisionTreeEditorPresenter presenter ) {
        canvas.init( presenter );
    }

    @Override
    public void setContent( final Path path,
                            final GuidedDecisionTree model,
                            final AsyncPackageDataModelOracle oracle,
                            final Caller<RuleNamesService> ruleNamesService,
                            final boolean isReadOnly ) {
        this.model = model;
        this.isReadOnly = isReadOnly;

        setNotDirty();

        //Initialise canvas
        if ( Canvas.isSupported() ) {
            canvas.setModel( model,
                             isReadOnly );
            palette.setDataModelOracle( oracle,
                                        isReadOnly );
        }
    }

    @Override
    public boolean isDirty() {
        return isDirty;
    }

    @Override
    public void setNotDirty() {
        isDirty = false;
    }

    @Override
    public boolean confirmClose() {
        return Window.confirm( CommonConstants.INSTANCE.DiscardUnsavedData() );
    }

}
