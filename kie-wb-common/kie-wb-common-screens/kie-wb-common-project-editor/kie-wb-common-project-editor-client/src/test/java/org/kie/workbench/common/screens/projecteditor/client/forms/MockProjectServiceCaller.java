package org.kie.workbench.common.screens.projecteditor.client.forms;

import org.guvnor.common.services.project.service.ProjectService;
import org.jboss.errai.bus.client.api.ErrorCallback;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;

public class MockProjectServiceCaller
        implements Caller<ProjectService> {
    @Override
    public ProjectService call(RemoteCallback<?> remoteCallback) {
        return null;  //TODO: -Rikkola-
    }

    @Override
    public ProjectService call(RemoteCallback<?> remoteCallback, ErrorCallback errorCallback) {
        return null;  //TODO: -Rikkola-
    }
}
