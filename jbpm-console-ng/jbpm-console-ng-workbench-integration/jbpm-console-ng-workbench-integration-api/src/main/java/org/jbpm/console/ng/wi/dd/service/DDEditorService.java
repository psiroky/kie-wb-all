/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.jbpm.console.ng.wi.dd.service;

import org.guvnor.common.services.shared.file.SupportsUpdate;
import org.guvnor.common.services.shared.validation.ValidationService;
import org.jboss.errai.bus.server.annotations.Remote;
import org.jbpm.console.ng.wi.dd.model.DeploymentDescriptorModel;
import org.kie.workbench.common.services.shared.source.ViewSourceService;
import org.uberfire.backend.vfs.Path;
import org.uberfire.ext.editor.commons.service.support.SupportsRead;

@Remote
public interface DDEditorService extends ViewSourceService<DeploymentDescriptorModel>,
                                         ValidationService<DeploymentDescriptorModel>,
                                         SupportsRead<DeploymentDescriptorModel>,
                                         SupportsUpdate<DeploymentDescriptorModel> {

    void createIfNotExists(Path path);
}
