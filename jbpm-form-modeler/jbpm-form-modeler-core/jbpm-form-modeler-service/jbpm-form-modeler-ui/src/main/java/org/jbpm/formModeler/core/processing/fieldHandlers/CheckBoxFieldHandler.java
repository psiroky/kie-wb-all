/**
 * Copyright (C) 2012 Red Hat, Inc. and/or its affiliates.
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
package org.jbpm.formModeler.core.processing.fieldHandlers;

import org.jbpm.formModeler.api.model.Field;
import org.jbpm.formModeler.core.processing.DefaultFieldHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CheckBoxFieldHandler extends DefaultFieldHandler {

    public static final String NULL_VALUE = "-1";

    public boolean isEmpty(Object value) {
        return value == null;
    }

    /**
     * Determine the list of class types this field can generate. That is, normally,
     * a field can generate multiple outputs (an input text can generate Strings,
     * Integers, ...)
     *
     * @return the set of class types that can be generated by this handler.
     */
    public String[] getCompatibleClassNames() {
        return new String[]{Boolean.class.getName()};
    }

    /**
     * Read a parameter value (normally from a request), and translate it to
     * an object with desired class (that must be one of the returned by this handler)
     *
     * @return a object with desired class
     * @throws Exception
     */
    public Object getValue(Field field, String inputName, Map parametersMap, Map filesMap, String desiredClassName, Object previousValue) throws Exception {

        if (parametersMap == null || parametersMap.size() == 0) return null;

        String[] pValues = (String[]) parametersMap.get(inputName);
        return pValues != null ? Boolean.valueOf(pValues[0]) : Boolean.FALSE;
    }

    @Override
    public Map getParamValue(Field field, String inputName, Object objectValue) {
        if (objectValue == null) return Collections.EMPTY_MAP;
        Map m = new HashMap();
        m.put(inputName + "Value", new String[]{objectValue.toString()});
        return m;
    }
}
