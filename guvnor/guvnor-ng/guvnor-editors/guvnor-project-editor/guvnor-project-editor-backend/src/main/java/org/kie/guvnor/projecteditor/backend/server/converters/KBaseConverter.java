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

package org.kie.guvnor.projecteditor.backend.server.converters;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.kie.guvnor.projecteditor.model.AssertBehaviorOption;
import org.kie.guvnor.projecteditor.model.EventProcessingOption;
import org.kie.guvnor.projecteditor.model.KBaseModel;
import org.kie.guvnor.projecteditor.model.KSessionModel;

import java.util.HashMap;
import java.util.Map;

public class KBaseConverter
        extends AbstractXStreamConverter {

    public KBaseConverter() {
        super(KBaseModel.class);
    }

    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        KBaseModel kBase = (KBaseModel) value;
        writer.addAttribute("name", kBase.getName());
        if (kBase.getEventProcessingMode() != null) {
            writer.addAttribute("eventProcessingMode", kBase.getEventProcessingMode().getMode());
        }
        if (kBase.getEqualsBehavior() != null) {
            writer.addAttribute("equalsBehavior", kBase.getEqualsBehavior().toString());
        }
        // writeList(writer, "files", "file", kBase.getFiles());
        writeList(writer, "includes", "include", kBase.getIncludes());
        Map<String, KSessionModel> join = new HashMap<String, KSessionModel>();
        setTypes("stateful", kBase.getStatefulSessions());
        setTypes("stateless", kBase.getStatelessSessions());
        join.putAll(kBase.getStatefulSessions());
        join.putAll(kBase.getStatelessSessions());
        writeObjectList(writer, context, "ksessions", "ksession", join.values());
    }

    private void setTypes(String stateful, Map<String, KSessionModel> sessions) {
        for (String key : sessions.keySet()) {
            sessions.get(key).setType(stateful);
        }
    }

    public Object unmarshal(HierarchicalStreamReader reader, final UnmarshallingContext context) {
        final KBaseModel kBase = new KBaseModel();
        kBase.setName(reader.getAttribute("name"));

        String eventMode = reader.getAttribute("eventProcessingMode");
        if (eventMode != null) {
            kBase.setEventProcessingMode(EventProcessingOption.determineEventProcessingMode(eventMode));
        }
        String equalsBehavior = reader.getAttribute("equalsBehavior");
        if (equalsBehavior != null) {
            kBase.setEqualsBehavior(AssertBehaviorOption.valueOf(equalsBehavior));
        }

        readNodes(reader, new AbstractXStreamConverter.NodeReader() {
            public void onNode(HierarchicalStreamReader reader, String name, String value) {
                if ("ksessions".equals(name)) {
                    for (KSessionModel kSession : readObjectList(reader, context, KSessionModel.class)) {
                        if (kSession.getType().equals("stateless")) {
                            kBase.getStatelessSessions().put(kSession.getName(), kSession);
                        } else {
                            kBase.getStatefulSessions().put(kSession.getName(), kSession);
                        }
                    }

                } else if ("includes".equals(name)) {
                    for (String include : readList(reader)) {
                        kBase.addInclude(include);
                    }
                }
            }
        });
        return kBase;
    }
}
