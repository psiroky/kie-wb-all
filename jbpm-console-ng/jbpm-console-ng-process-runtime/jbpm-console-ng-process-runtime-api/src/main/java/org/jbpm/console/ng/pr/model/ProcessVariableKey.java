/*
 * Copyright 2014 JBoss by Red Hat.
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
package org.jbpm.console.ng.pr.model;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jbpm.console.ng.ga.service.ItemKey;

/**
 *
 * @author salaboy
 */
@Portable
public class ProcessVariableKey implements ItemKey {

  private String processVariableId;

  public ProcessVariableKey() {
  }

  public ProcessVariableKey(String processVariableId) {
    this.processVariableId = processVariableId;
  }

  public String getProcessVariableId() {
    return processVariableId;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 13 * hash + (this.processVariableId != null ? this.processVariableId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final ProcessVariableKey other = (ProcessVariableKey) obj;
    if ((this.processVariableId == null) ? (other.processVariableId != null) : !this.processVariableId.equals(other.processVariableId)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ProcessVariableKey{" + "processVariableId=" + processVariableId + '}';
  }

}
