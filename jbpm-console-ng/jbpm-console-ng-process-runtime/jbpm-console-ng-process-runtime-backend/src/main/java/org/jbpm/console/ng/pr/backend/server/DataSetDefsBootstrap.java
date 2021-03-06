/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
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
package org.jbpm.console.ng.pr.backend.server;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.dashbuilder.dataset.def.DataSetDef;
import org.dashbuilder.dataset.def.DataSetDefFactory;
import org.dashbuilder.dataset.def.DataSetDefRegistry;
import org.jbpm.persistence.settings.JpaSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.uberfire.commons.services.cdi.Startup;

import static org.jbpm.console.ng.pr.model.ProcessInstanceDataSetConstants.*;

@Startup
@ApplicationScoped
public class DataSetDefsBootstrap {

    private static final Logger logger = LoggerFactory.getLogger(DataSetDefsBootstrap.class);

    @Inject
    DataSetDefRegistry dataSetDefRegistry;

    @Inject
    DeploymentIdsPreprocessor deploymentIdsPreprocessor;

    JpaSettings jpaSettings = JpaSettings.get();

    @PostConstruct
    protected void registerDataSetDefinitions() {
        String jbpmDataSource = jpaSettings.getDataSourceJndiName();

        DataSetDef processInstancesDef = DataSetDefFactory.newSQLDataSetDef()
                .uuid(PROCESS_INSTANCE_DATASET)
                .name("Process Instances")
                .dataSource(jbpmDataSource)
                .dbTable("ProcessInstanceLog", false)
                .number(COLUMN_PROCESS_INSTANCE_ID)
                .label(COLUMN_PROCESS_ID)
                .date(COLUMN_START)
                .date(COLUMN_END)
                .number(COLUMN_STATUS)
                .number(COLUMN_PARENT_PROCESS_INSTANCE_ID)
                .label(COLUMN_OUTCOME)
                .number(COLUMN_DURATION)
                .label(COLUMN_IDENTITY)
                .label(COLUMN_PROCESS_VERSION)
                .label(COLUMN_PROCESS_NAME)
                .label(COLUMN_CORRELATION_KEY)
                .label(COLUMN_EXTERNAL_ID)
                .label(COLUMN_PROCESS_INSTANCE_DESCRIPTION)
                .buildDef();


        DataSetDef processWithVariablesDef = DataSetDefFactory.newSQLDataSetDef()
                .uuid(PROCESS_INSTANCE_WITH_VARIABLES_DATASET)
                .name("Domain Specific Process Instances")
                .dataSource(jbpmDataSource)
                .dbSQL("select " +
                            "vil.processInstanceId, " +
                            "vil.processId, " +
                            "vil.id, " +
                            "vil.variableId, " +
                            "vil.value " +
                        "from VariableInstanceLog vil " +
                        "where " +
                            "vil.id = " +
                                "(select MAX(v.id) " +
                                "from VariableInstanceLog v " +
                                "where " +
                                "V.variableId = vil.variableId and " +
                                "V.processInstanceId = vil.processInstanceId)" , false )
                .number(PROCESS_INSTANCE_ID)
                .label(PROCESS_NAME)
                .number(VARIABLE_ID)
                .label(VARIABLE_NAME)
                .label(VARIABLE_VALUE)
                .buildDef();

        // Hide all these internal data set from end user view
        processInstancesDef.setPublic(false);
        processWithVariablesDef.setPublic(false);

        // Register the data set definitions
        dataSetDefRegistry.registerDataSetDef(processInstancesDef);
        dataSetDefRegistry.registerDataSetDef(processWithVariablesDef);
        logger.info("Process instance datasets registered");

        // Attach a preprocessor to ensure the user only sees the right process instances
        dataSetDefRegistry.registerPreprocessor(PROCESS_INSTANCE_DATASET, deploymentIdsPreprocessor);
    }
}
