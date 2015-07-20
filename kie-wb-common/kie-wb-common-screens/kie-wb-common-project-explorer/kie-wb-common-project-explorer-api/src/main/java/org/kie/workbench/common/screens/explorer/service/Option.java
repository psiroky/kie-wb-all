/*
 * Copyright 2015 JBoss Inc
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

package org.kie.workbench.common.screens.explorer.service;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public enum Option {
    BUSINESS_CONTENT, TECHNICAL_CONTENT, GROUPED_CONTENT,
    TREE_NAVIGATOR, BREADCRUMB_NAVIGATOR,
    FLATTEN_DIR, COMPACT_EMPTY_DIR,
    INCLUDE_HIDDEN_ITEMS, EXCLUDE_HIDDEN_ITEMS,
    NO_CONTEXT_NAVIGATION
}