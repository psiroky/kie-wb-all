/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.projecteditor.client.forms;

import com.google.gwt.user.client.ui.IsWidget;
import org.kie.projecteditor.shared.model.KSessionModel;

import java.util.Map;

public interface KBaseFormView
        extends IsWidget {

    interface Presenter
            extends IsWidget {

        void onEqualsBehaviorEqualitySelect();

        void onEqualsBehaviorIdentitySelect();

        void onEventProcessingModeStreamSelect();

        void onEventProcessingModeCloudSelect();

    }

    void setPresenter(Presenter presenter);

    void setName(String name);

    void setEqualsBehaviorEquality();

    void setEqualsBehaviorIdentity();

    void setEventProcessingModeStream();

    void setEventProcessingModeCloud();

    void setStatefulSessions(Map<String, KSessionModel> statefulSessions);

    void setStatelessSessions(Map<String, KSessionModel> statelessSessions);
}
