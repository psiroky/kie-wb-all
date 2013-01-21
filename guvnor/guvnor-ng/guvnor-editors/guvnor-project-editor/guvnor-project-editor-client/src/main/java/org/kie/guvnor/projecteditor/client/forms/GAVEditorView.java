package org.kie.guvnor.projecteditor.client.forms;

import com.google.gwt.user.client.ui.IsWidget;

public interface GAVEditorView
        extends IsWidget {

    interface Presenter {

        void onGroupIdChange(String groupId);

        void onArtifactIdChange(String artifactId);

        void onVersionIdChange(String versionId);

    }

    void setPresenter(Presenter presenter);

    void setGroupId(String id);

    void setArtifactId(String id);

    void setVersionId(String versionId);
}
