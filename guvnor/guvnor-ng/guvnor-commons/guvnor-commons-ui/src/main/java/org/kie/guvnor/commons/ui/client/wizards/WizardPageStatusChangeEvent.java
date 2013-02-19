/*
 * Copyright 2011 JBoss Inc
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
package org.kie.guvnor.commons.ui.client.wizards;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

/**
 * An event representing the change in status (i.e. completed, not-completed) of
 * a page within a Wizard.
 */
public class WizardPageStatusChangeEvent extends GwtEvent<WizardPageStatusChangeEvent.Handler> {

    public static interface Handler
            extends
            EventHandler {

        void onStatusChange( WizardPageStatusChangeEvent event );
    }

    public static final Type<Handler> TYPE = new Type<Handler>();

    private final WizardPage page;

    public WizardPageStatusChangeEvent( final WizardPage page ) {
        this.page = page;
    }

    public WizardPage getPage() {
        return page;
    }

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch( final WizardPageStatusChangeEvent.Handler handler ) {
        handler.onStatusChange( this );
    }

}
