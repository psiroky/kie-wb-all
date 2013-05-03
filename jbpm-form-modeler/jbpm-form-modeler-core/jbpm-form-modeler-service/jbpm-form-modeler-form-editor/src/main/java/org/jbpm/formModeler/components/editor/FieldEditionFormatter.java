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
package org.jbpm.formModeler.components.editor;

import org.apache.commons.logging.Log;
import org.jbpm.formModeler.service.bb.mvc.taglib.formatter.FormatterException;
import org.jbpm.formModeler.api.model.Field;
import org.jbpm.formModeler.api.model.Form;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FieldEditionFormatter extends FormFieldEditionFormatter {

    @Inject
    private Log log;

    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws FormatterException {
        try {
            Field field = getEditor().getCurrentEditField();
            if (field == null) {
                renderFragment("empty");
            } else {
                Form formToEdit = getEditor().getFormForFieldEdition(field);
                if (formToEdit != null) {
                    renderFieldUsingForm(field, formToEdit);
                } else {
                    renderField(field);
                }
            }
        } catch (Exception e) {
            log.error("Error:", e);
        }
    }
}
