package org.kie.guvnor.testscenario.client.reporting;

import com.google.gwt.user.client.ui.IsWidget;
import org.kie.guvnor.testscenario.model.TestResultMessage;

public interface TestRunnerReportingView
        extends IsWidget {

    interface Presenter {
        void onMessageSelected(TestResultMessage message);
    }

    void setPresenter(Presenter presenter);

    void setExplanation(String explanation);

}
