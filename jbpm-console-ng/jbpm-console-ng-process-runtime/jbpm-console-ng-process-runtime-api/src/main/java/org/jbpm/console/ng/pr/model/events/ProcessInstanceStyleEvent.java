/*
 * Copyright 2013 JBoss by Red Hat.
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

package org.jbpm.console.ng.pr.model.events;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class ProcessInstanceStyleEvent {
    
    private Long processInstanceId;
    private String processDefName;
    private String processDefVersion;
    private String processInstanceStartDate;
    
    public ProcessInstanceStyleEvent(){
        
    }

    public ProcessInstanceStyleEvent(Long processInstanceId, String processDefName, String processDefVersion, String processInstanceStartDate) {
        this.processInstanceId = processInstanceId;
        this.processDefName = processDefName;
        this.processDefVersion = processDefVersion;
        this.processInstanceStartDate = processInstanceStartDate;
    }

    public Long getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(Long processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessDefName() {
        return processDefName;
    }

    public void setProcessDefName(String processDefName) {
        this.processDefName = processDefName;
    }

    public String getProcessDefVersion() {
        return processDefVersion;
    }

    public void setProcessDefVersion(String processDefVersion) {
        this.processDefVersion = processDefVersion;
    }

    public String getProcessInstanceStartDate() {
        return processInstanceStartDate;
    }

    public void setProcessInstanceStartDate(String processInstanceStartDate) {
        this.processInstanceStartDate = processInstanceStartDate;
    }

    
}