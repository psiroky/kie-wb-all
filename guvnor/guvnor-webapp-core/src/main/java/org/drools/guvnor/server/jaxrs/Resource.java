/*
 * Copyright 2011 JBoss Inc
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

package org.drools.guvnor.server.jaxrs;


import org.drools.guvnor.client.rpc.AssetService;
import org.drools.guvnor.client.rpc.ModuleService;
import org.drools.guvnor.server.*;
import org.drools.guvnor.server.files.FileManagerService;
import org.drools.guvnor.server.repository.Preferred;
import org.drools.repository.RulesRepository;
import org.drools.repository.utils.AssetValidator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@RequestScoped
public abstract class Resource {

    @Context
    protected UriInfo uriInfo;

    @Inject
    protected ServiceImplementation serviceImplementation;
    @Inject
    protected ModuleService repositoryPackageService;
    @Inject
    protected AssetService repositoryAssetService;
    @Inject
    protected RepositoryCategoryService repositoryCategoryService;
    @Inject
    protected RepositoryModuleOperations repositoryModuleOperations;
    @Inject
    @Preferred
    protected RulesRepository rulesRepository;
    @Inject
    protected FileManagerService fileManagerService;
    @Inject
    protected AssetValidator assetValidator;


    // TODO HACK: the @Inject stuff doesn't actually work, but is faked in HackInjectCXFNonSpringJaxrsServlet
    protected void inject(ServiceImplementation serviceImplementation,
                          ModuleService repositoryPackageService, AssetService repositoryAssetService,
                          RepositoryCategoryService repositoryCategoryService, RepositoryModuleOperations repositoryModuleOperations,
                          RulesRepository rulesRepository, FileManagerService fileManagerService, AssetValidator assetValidator) {
        this.serviceImplementation = serviceImplementation;
        this.repositoryPackageService = repositoryPackageService;
        this.repositoryAssetService = repositoryAssetService;
        this.repositoryCategoryService = repositoryCategoryService;
        this.repositoryModuleOperations = repositoryModuleOperations;
        this.rulesRepository = rulesRepository;
        this.fileManagerService = fileManagerService;
        this.assetValidator = assetValidator;
    }

}
