package org.kie.guvnor.projecteditor.client.forms;

import com.google.gwt.event.logical.shared.SelectionHandler;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.kie.guvnor.m2repo.service.M2RepoService;
import org.kie.guvnor.project.model.GroupArtifactVersionModel;

import javax.inject.Inject;
import java.util.ArrayList;

public class DependencySelectorPopup
        implements DependencySelectorPopupView.Presenter {

    private final DependencySelectorPopupView view;
    private final Caller<M2RepoService> m2RepoService;
    private ArrayList<SelectionHandler<GroupArtifactVersionModel>> selectionHandlers = new ArrayList<SelectionHandler<GroupArtifactVersionModel>>();

    @Inject
    public DependencySelectorPopup(DependencySelectorPopupView view,
                                   Caller<M2RepoService> m2RepoService) {
        this.view = view;
        this.m2RepoService = m2RepoService;
        view.setPresenter(this);
    }


    public void show() {
        view.show();
    }

    @Override
    public void onPathSelection(String pathToDependency) {
        m2RepoService.call(new RemoteCallback<Object>() {
            @Override
            public void callback(Object o) {
                //TODO -Rikkola-
            }
        }

        ).loadPOMFromJar(pathToDependency);
    }

    public void addSelectionHandler(SelectionHandler<GroupArtifactVersionModel> selectionHandler) {
        selectionHandlers.add(selectionHandler);
    }
}
