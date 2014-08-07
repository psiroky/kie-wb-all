package org.drools.workbench.screens.dtablexls.client.editor;

import org.kie.workbench.common.widgets.client.editor.GuvnorEditorView;
import org.uberfire.backend.vfs.ObservablePath;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.mvp.UberView;

public interface DecisionTableXLSEditorView
        extends GuvnorEditorView, UberView<DecisionTableXLSEditorView.Presenter> {

    interface Presenter {

        void reload();

    }

    void setPath( final Path path );

    void setReadOnly( final boolean isReadOnly );

    void setConcurrentUpdateSessionInfo( final ObservablePath.OnConcurrentUpdateEvent eventInfo );
}
