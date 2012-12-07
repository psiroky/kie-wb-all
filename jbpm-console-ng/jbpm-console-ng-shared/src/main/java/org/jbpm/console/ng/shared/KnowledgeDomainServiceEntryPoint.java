/*
 * Copyright 2012 JBoss by Red Hat.
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
package org.jbpm.console.ng.shared;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.jboss.errai.bus.server.annotations.Remote;
import org.jbpm.console.ng.shared.model.NodeInstanceSummary;
import org.jbpm.console.ng.shared.model.ProcessInstanceSummary;
import org.jbpm.console.ng.shared.model.ProcessSummary;
import org.jbpm.console.ng.shared.model.StatefulKnowledgeSessionSummary;
import org.jbpm.console.ng.shared.model.TaskDefSummary;
import org.jbpm.console.ng.shared.model.VariableSummary;
import org.kie.commons.java.nio.file.Path;


/**
 *
 * @author salaboy
 */
@Remote
public interface KnowledgeDomainServiceEntryPoint {
    
    
    
    StatefulKnowledgeSessionSummary getSessionSummaryByName(String kSessionName);
    
    Collection<String> getSessionsNames();
    
    int getAmountOfSessions();
    
    Collection<ProcessInstanceSummary> getProcessInstances();
    
    Collection<ProcessInstanceSummary> getProcessInstances(List<Integer> states, String filterText,
            int filterType, String initiator);

    Collection<ProcessInstanceSummary> getProcessInstancesBySessionId(String sessionId);
    
    Collection<ProcessSummary> getProcessesBySessionId(String sessionId);
    
    ProcessInstanceSummary getProcessInstanceById(int sessionId, long processInstanceId);
    
    Collection<ProcessSummary> getProcesses();
    
    Collection<TaskDefSummary> getAllTasksDef(String processId);
    
    Map<String, String> getAvailableProcesses();
    
    Map<String, String> getRequiredInputData(String processId);
    
    Map<String, String> getAssociatedEntities(String processId);
    
    Collection<NodeInstanceSummary> getProcessInstanceHistory(int sessionId, long id); 
    
    Collection<NodeInstanceSummary> getProcessInstanceHistory(int sessionId, long processId, boolean completed);

    Collection<NodeInstanceSummary> getProcessInstanceFullHistory(int sessionId, long processId);

    Collection<NodeInstanceSummary> getProcessInstanceActiveNodes(int sessionId, long processId);
    
    ProcessSummary getProcessDesc(String processId);
    
    Collection<VariableSummary> getVariablesCurrentState(long processInstanceId, String processId);
    
    public Map<String, String> getTaskInputMappings(String processId, String taskName);

    public Map<String, String> getTaskOutputMappings(String processId, String taskName);
    
    void abortProcessInstance(String businessKey, long processInstanceId);
    
    void signalProcessInstance(String businessKey, String signalName, Object event, long processInstanceId);
    
    Collection<String> getAvailableSignals(String businessKey, long processInstanceId);
    
    void setProcessVariable(String businessKey, long processInstanceId, String variableId, Object value);

    Collection<VariableSummary> getVariableHistory(long processInstanceId, String variableId);
    
    Collection<String> getReusableSubProcesses(String  processId);

    public void checkFileSystem();

    public void fetchChanges();

    public byte[] loadFile(Path file);

    public Iterable<Path> loadFilesByType(String path, String fileType);
    
    public void createDomain();

}
