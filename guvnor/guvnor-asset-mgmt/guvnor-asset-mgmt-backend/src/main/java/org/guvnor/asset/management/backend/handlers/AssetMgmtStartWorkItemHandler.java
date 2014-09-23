/*
 * Copyright 2014 JBoss Inc
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

package org.guvnor.asset.management.backend.handlers;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

public class AssetMgmtStartWorkItemHandler implements WorkItemHandler {

    @Override
    public void executeWorkItem( WorkItem workItem, WorkItemManager manager ) {
        System.out.println("Start process: " + new java.util.Date());
        //TODO send the social event.
        if ( manager != null ) {
            manager.completeWorkItem( workItem.getId(), null );
        }
    }

    @Override public void abortWorkItem( WorkItem workItem, WorkItemManager manager ) {
        //do nothing
    }
}
