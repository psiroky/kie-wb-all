/*
 * Copyright 2015 JBoss Inc
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

package org.kie.workbench.common.screens.datamodeller.client.widgets.advanceddomain.valuepaireditor.numeric;

import com.google.gwt.core.client.GWT;
import org.kie.workbench.common.screens.datamodeller.client.widgets.advanceddomain.valuepaireditor.ValuePairEditor;
import org.kie.workbench.common.screens.datamodeller.client.widgets.advanceddomain.valuepaireditor.multiple.MultipleValuePairEditor;
import org.kie.workbench.common.services.datamodeller.core.AnnotationValuePairDefinition;

public class MultipleNumericValuePairEditor extends MultipleValuePairEditor {

    public MultipleNumericValuePairEditor() {
    }

    @Override
    public ValuePairEditor<?> createValuePairEditor( AnnotationValuePairDefinition valuePairDefinition ) {
        ValuePairEditor<?> valuePairEditor = GWT.create( NumericValuePairEditor.class );
        valuePairEditor.init( valuePairDefinition );
        return valuePairEditor;
    }

    @Override
    public void setEditorValue( ValuePairEditor<?> valuePairEditor, Object value ) {
        ((NumericValuePairEditor )valuePairEditor).setValue( value );
    }
}
