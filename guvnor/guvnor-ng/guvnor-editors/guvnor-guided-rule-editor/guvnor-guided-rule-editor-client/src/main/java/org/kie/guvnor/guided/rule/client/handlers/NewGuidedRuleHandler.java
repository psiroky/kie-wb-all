package org.kie.guvnor.guided.rule.client.handlers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.kie.guvnor.commons.ui.client.handlers.DefaultNewResourceHandler;
import org.kie.guvnor.guided.rule.client.resources.DroolsGuvnorImageResources;
import org.kie.guvnor.guided.rule.client.resources.i18n.Constants;
import org.kie.guvnor.guided.rule.model.RuleModel;
import org.kie.guvnor.guided.rule.service.GuidedRuleEditorService;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.shared.mvp.PlaceRequest;
import org.uberfire.shared.mvp.impl.DefaultPlaceRequest;

/**
 * Handler for the creation of new DRL Text Rules
 */
@ApplicationScoped
public class NewGuidedRuleHandler extends DefaultNewResourceHandler {

    private static String FILE_TYPE = "brl";

    @Inject
    private PlaceManager placeManager;

    @Inject
    private Caller<GuidedRuleEditorService> service;

    @Override
    public String getFileType() {
        return FILE_TYPE;
    }

    @Override
    public String getDescription() {
        return Constants.INSTANCE.NewGuidedRuleDescription();
    }

    @Override
    public IsWidget getIcon() {
        return new Image( DroolsGuvnorImageResources.INSTANCE.guidedRuleIcon() );
    }

    @Override
    public void create( final String fileName ) {
        final Path path = buildFullPathName( fileName );
        final RuleModel ruleModel = new RuleModel();
        service.call( new RemoteCallback<Path>() {
            @Override
            public void callback( Path response ) {
                notifySuccess();
                final PlaceRequest place = new DefaultPlaceRequest( "GuidedRuleEditor" );
                place.addParameter( "path:uri",
                                    path.toURI() );
                place.addParameter( "path:name",
                                    path.getFileName() );
                placeManager.goTo( place );
            }
        } ).save( path,
                  ruleModel );
    }

}
