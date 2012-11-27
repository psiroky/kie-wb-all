/*
 * Copyright 2012 JBoss Inc
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

package org.kie.guvnor.factmodel.model;

import java.util.ArrayList;
import java.util.List;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class FactModelContent {

    final List<FactMetaModel> currentTypes = new ArrayList<FactMetaModel>();
    final List<FactMetaModel> superTypes   = new ArrayList<FactMetaModel>();

    public List<FactMetaModel> getCurrentTypes() {
        return currentTypes;
    }

    public List<FactMetaModel> getSuperTypes() {
        return superTypes;
    }

}
