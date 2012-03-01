/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.guvnor.client.explorer.navigation.qa.testscenarios;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import org.drools.guvnor.client.common.DirtyableFlexTable;
import org.drools.guvnor.client.messages.Constants;
import org.drools.guvnor.client.resources.DroolsGuvnorImages;
import org.drools.ide.common.client.modeldriven.SuggestionCompletionEngine;
import org.drools.ide.common.client.modeldriven.testing.*;

public class DataInputWidget extends DirtyableFlexTable implements ScenarioParentWidget {

    private final Scenario                   scenario;
    private final SuggestionCompletionEngine suggestionCompletionEngine;
    protected final String type;
    private final ScenarioParentWidget parent;
    private final ExecutionTrace executionTrace;
    private final FixtureList definitionList;
    private final String headerText;

    public DataInputWidget(String factType,
                           FixtureList definitionList,
                           Scenario scenario,
                           SuggestionCompletionEngine suggestionCompletionEngine,
                           ScenarioParentWidget parent,
                           ExecutionTrace executionTrace,
                           String headerText) {

        this.scenario = scenario;
        this.suggestionCompletionEngine = suggestionCompletionEngine;
        this.type = factType;

        this.parent = parent;
        this.executionTrace = executionTrace;
        this.definitionList = definitionList;
        this.headerText = headerText;

        setStyles();

        renderEditor();

    }

    private void setStyles() {
        getCellFormatter().setStyleName( 0,
                                         0,
                                         "modeller-fact-TypeHeader" ); //NON-NLS
        getCellFormatter().setAlignment( 0,
                                         0,
                                         HasHorizontalAlignment.ALIGN_CENTER,
                                         HasVerticalAlignment.ALIGN_MIDDLE );
        setStyleName( "modeller-fact-pattern-Widget" ); //NON-NLS
    }


    public void renderEditor() {

        clear();

        if (definitionList.size() == 0) {
            parent.renderEditor();
        }

        //This will work out what row is for what field, adding labels and remove icons
        FactDataWidgetFactory factDataWidgetFactory = new FactDataWidgetFactory(
                scenario,
                suggestionCompletionEngine,
                definitionList,
                executionTrace,
                this,
                this);
        for (Fixture fixture : definitionList) {
            if (fixture instanceof FactData) {
                factDataWidgetFactory.build(headerText, (FactData) fixture);
            }
        }

        getFlexCellFormatter().setHorizontalAlignment(factDataWidgetFactory.amountOrRows() + 1,
                0,
                HasHorizontalAlignment.ALIGN_RIGHT);

        if (factDataWidgetFactory.amountOrRows() == 0) {
            Button b = new Button(Constants.INSTANCE.AddAField());
            b.addClickHandler(new FieldClickHandler(getFactData(), suggestionCompletionEngine, definitionList, this));

            setWidget(1,
                    1,
                    b);
        }
    }

    private FactData getFactData() {
        for (Fixture fixture : definitionList) {
            if (fixture instanceof FactData) {
                return (FactData) fixture;
            }
        }
        return null;
    }
}
