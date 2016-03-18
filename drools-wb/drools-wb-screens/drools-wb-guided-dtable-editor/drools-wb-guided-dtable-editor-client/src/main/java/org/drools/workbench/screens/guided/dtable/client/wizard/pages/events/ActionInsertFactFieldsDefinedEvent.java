/*
 * Copyright 2011 Red Hat, Inc. and/or its affiliates.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.drools.workbench.screens.guided.dtable.client.wizard.pages.events;

/**
 * An event representing whether Action Insert Fact Fields are correctly defined
 */
public class ActionInsertFactFieldsDefinedEvent {

    private boolean areActionInsertFactFieldsDefined;

    public ActionInsertFactFieldsDefinedEvent( final boolean areActionInsertFactFieldsDefined ) {
        this.areActionInsertFactFieldsDefined = areActionInsertFactFieldsDefined;
    }

    public boolean getAreActionInsertFactFieldsDefined() {
        return this.areActionInsertFactFieldsDefined;
    }

}
