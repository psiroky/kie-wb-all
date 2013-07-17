/**
 * Copyright (C) 2012 JBoss Inc
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
package org.jboss.dashboard.ui.components.panelManagement;

import org.jboss.dashboard.LocaleManager;
import org.jboss.dashboard.ui.taglib.formatter.Formatter;
import org.jboss.dashboard.ui.taglib.formatter.FormatterException;
import org.jboss.dashboard.workspace.PanelInstance;
import org.jboss.dashboard.workspace.PanelProviderParameter;
import org.jboss.dashboard.workspace.PanelInstance;
import org.jboss.dashboard.workspace.PanelProviderParameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPanelConfigComponentFormatter extends Formatter {
    private static transient org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ShowPanelConfigComponentFormatter.class.getName());

    private ShowPanelConfigComponent showPanelConfigComponent;

    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws FormatterException {
        try {
            PanelInstance instance = showPanelConfigComponent.getPanelInstance();
            if (instance != null) {
                renderFragment("outputStart");

                renderPanelParameters(httpServletRequest, instance, instance.getSystemParameters());
                renderPanelParameters(httpServletRequest, instance, instance.getCustomParameters());

                renderFragment("outputEnd");
            } else {
                log.warn("Error: panelInstance is null");
            }
        } catch (Exception e) {
            log.error("Error rendering panel properties: ", e);
        }
    }

    protected void renderPanelParameters(HttpServletRequest request, PanelInstance instance, PanelProviderParameter[] params) {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                if (params[i].getProvider().getProperties().containsKey("parameter." + params[i].getId())) {
                    continue;
                }
                setAttribute("param", params[i]);
                setAttribute("html", params[i].renderHTML(request, instance, params[i], instance.getParameterValue(params[i].getId(), LocaleManager.currentLang())));
                setAttribute("formStatus", showPanelConfigComponent.getFormStatus());
                renderFragment("outputParam");
            }
        }
    }

    public ShowPanelConfigComponent getShowPanelConfigComponent() {
        return showPanelConfigComponent;
    }

    public void setShowPanelConfigComponent(ShowPanelConfigComponent showPanelConfigComponent) {
        this.showPanelConfigComponent = showPanelConfigComponent;
    }
}
