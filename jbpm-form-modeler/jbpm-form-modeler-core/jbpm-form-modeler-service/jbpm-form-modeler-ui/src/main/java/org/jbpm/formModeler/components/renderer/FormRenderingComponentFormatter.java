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
package org.jbpm.formModeler.components.renderer;

import org.apache.commons.lang.StringUtils;
import org.jbpm.formModeler.service.bb.mvc.taglib.formatter.Formatter;
import org.jbpm.formModeler.service.bb.mvc.taglib.formatter.FormatterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormRenderingComponentFormatter extends Formatter {
    private FormRenderingComponent formRenderingComponent;

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws FormatterException {
        if (formRenderingComponent.getForm() == null || StringUtils.isEmpty(formRenderingComponent.getCtxUID())) return;

        setAttribute("ctxUID", formRenderingComponent.getCtxUID());
        setAttribute("form", formRenderingComponent.getForm());
        renderFragment("output");
    }

    public FormRenderingComponent getFormRenderingComponent() {
        return formRenderingComponent;
    }

    public void setFormRenderingComponent(FormRenderingComponent formRenderingComponent) {
        this.formRenderingComponent = formRenderingComponent;
    }
}
