/**
 * Copyright (C) 2012 JBoss Inc
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
package org.jbpm.formModeler.core.config;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.xerces.parsers.DOMParser;
import org.jbpm.formModeler.core.xml.util.XMLNode;
import org.jbpm.formModeler.api.config.FieldTypeManager;
import org.jbpm.formModeler.api.config.FormManager;
import org.jbpm.formModeler.api.config.FormSerializationManager;
import org.jbpm.formModeler.api.model.DataHolder;
import org.jbpm.formModeler.api.model.Field;
import org.jbpm.formModeler.api.model.Form;
import org.jbpm.formModeler.api.model.i18n.I18nEntry;
import org.jbpm.formModeler.api.model.i18n.I18nSet;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.*;
import java.util.*;

@ApplicationScoped
public class FormSerializationManagerImpl implements FormSerializationManager {

    public static final String NODE_FORM = "form";
    public static final String NODE_FIELD = "field";
    public static final String NODE_PROPERTY = "property";
    public static final String NODE_DATA_HOLDER = "dataHolder";

    public static final String ATTR_ID = "id";
    public static final String ATTR_POSITION = "position";
    public static final String ATTR_TYPE = "type";
    public static final String ATTR_NAME = "name";
    public static final String ATTR_VALUE = "value";

    @Inject
    private org.jbpm.formModeler.integration.DataModelerService dataModelerService;

    @Inject
    protected Log log;

    @Inject
    protected FormManager formManager;

    @Inject
    protected FieldTypeManager fieldTypeManager;

    public String generateFormXML(Form form) {
        XMLNode rootNode = new XMLNode(NODE_FORM, null);

       // TestFormSerialization test = new TestFormSerialization();
       // test.saveFormToLocalDrive(form);

        try {
            return generateFormXML(form, rootNode);
        } catch (Exception e) {
            log.error("Error serializing form to XML.", e);
            return "";
        }
    }

    @Override
    public Form loadFormFromXML(String xml,Object path) throws Exception {
        if (StringUtils.isBlank(xml)) return null;
        return loadFormFromXML(new InputSource(new StringReader(xml)),path);
    }

    @Override
    public Form loadFormFromXML(String xml) throws Exception {
        if (StringUtils.isBlank(xml)) return null;
        return loadFormFromXML(new InputSource(new StringReader(xml)));
    }

    @Override
    public Form loadFormFromXML(InputStream is) throws Exception {
        return loadFormFromXML(new InputSource(is));
    }

    @Override
    public Form loadFormFromXML(InputSource source) throws Exception {
        DOMParser parser = new DOMParser();
        parser.parse(source);
        Document doc = parser.getDocument();
        NodeList nodes = doc.getElementsByTagName(NODE_FORM);
        Node rootNode = nodes.item(0); // only comes a form
        return deserializeForm(rootNode,null);
    }

    public Form loadFormFromXML(InputSource source, Object path) throws Exception {
        DOMParser parser = new DOMParser();
        parser.parse(source);
        Document doc = parser.getDocument();
        NodeList nodes = doc.getElementsByTagName(NODE_FORM);
        Node rootNode = nodes.item(0); // only comes a form
        return deserializeForm(rootNode,path);
    }
    public Form deserializeForm(Node nodeForm, Object path) throws Exception {
        if (!nodeForm.getNodeName().equals(NODE_FORM)) return null;

        Form form = formManager.createForm("");
        form.setId(Long.valueOf(StringEscapeUtils.unescapeXml(nodeForm.getAttributes().getNamedItem(ATTR_ID).getNodeValue())));

        Set<Field> fields = new TreeSet<Field>();
        NodeList childNodes = nodeForm.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeName().equals(NODE_PROPERTY)) {
                String propName = node.getAttributes().getNamedItem(ATTR_NAME).getNodeValue();
                String value = StringEscapeUtils.unescapeXml(node.getAttributes().getNamedItem(ATTR_VALUE).getNodeValue());
                if ("subject".equals(propName)) {
                    form.setSubject(value);
                } else if ("name".equals(propName)) {
                    form.setName(value);
                } else if ("displayMode".equals(propName)) {
                    form.setDisplayMode(value);
                } else if ("labelMode".equals(propName)) {
                    form.setLabelMode(value);
                } else if ("showMode".equals(propName)) {
                    form.setShowMode(value);
                } else if ("status".equals(propName)) {
                    form.setStatus(Long.valueOf(value));
                } else if ("formTemplate".equals(propName)) {
                    form.setFormTemplate(value);
                }
            } else if (node.getNodeName().equals(NODE_FIELD)) {
                Field field = deserializeField(node);
                field.setForm(form);
                fields.add(field);
            } else if (node.getNodeName().equals(NODE_DATA_HOLDER)) {

                String holderId =node.getAttributes().getNamedItem(ATTR_ID).getNodeValue();
                String holderType =node.getAttributes().getNamedItem(ATTR_TYPE).getNodeValue();
                String holderValue =node.getAttributes().getNamedItem(ATTR_VALUE).getNodeValue();
                String holderRenderColor =node.getAttributes().getNamedItem(ATTR_NAME).getNodeValue();

                if(holderId!=null && holderType!=null && holderValue!=null){
                    if(path!=null && Form.HOLDER_TYPE_CODE_POJO_DATA_MODEL.equals(holderType)){
                        form.setDataHolder(dataModelerService.createDataHolder(path,holderId, holderValue, holderRenderColor));
                    } else {
                        form.setDataHolder(holderId,holderType,holderValue,holderRenderColor);
                    }
                }
            }
        }
        if (fields != null) form.setFormFields(fields);
        return form;
    }


    private void addXMLNode(String propName, String value, XMLNode parent) {
        if (value != null) {
            XMLNode propertyNode = new XMLNode(NODE_PROPERTY, parent);
            propertyNode.addAttribute(ATTR_NAME, propName);
            propertyNode.addAttribute(ATTR_VALUE, value);
            parent.addChild(propertyNode);
        }
    }


    /**
     * Generates the xml representation and mount in rootNode the structure to be included.
     * Fills the XMLNode structure with the form representation and returns the string.
    */
    public String generateFormXML(Form form, XMLNode rootNode) throws Exception {
        rootNode.addAttribute(ATTR_ID, form.getId().toString());

        addXMLNode("subject", form.getSubject(), rootNode);
        addXMLNode("name", form.getName(), rootNode);
        addXMLNode("displayMode", form.getDisplayMode(), rootNode);
        addXMLNode("labelMode", form.getLabelMode(), rootNode);
        addXMLNode("showMode", form.getShowMode(), rootNode);
        addXMLNode("status", (form.getStatus() != null ? String.valueOf(form.getStatus()) : null), rootNode);
        addXMLNode("formTemplate", form.getFormTemplate(), rootNode);

        for (Field field: form.getFormFields()) {
            generateFieldXML(field, rootNode);
        }

        for (DataHolder dataHolder: form.getHolders()) {
            generateDataHolderXML(dataHolder, rootNode);
        }

        StringWriter sw = new StringWriter();
        rootNode.writeXML(sw, true);

        return sw.toString();
    }

    public Field deserializeField(Node nodeField) throws Exception {
        if (!nodeField.getNodeName().equals(NODE_FIELD)) return null;

        Field field = new Field();
        field.setId(Long.valueOf(nodeField.getAttributes().getNamedItem(ATTR_ID).getNodeValue()));
        field.setFieldName(nodeField.getAttributes().getNamedItem(ATTR_NAME).getNodeValue());
        field.setPosition(Integer.parseInt(nodeField.getAttributes().getNamedItem(ATTR_POSITION).getNodeValue()));
        field.setFieldType(fieldTypeManager.getTypeByCode(nodeField.getAttributes().getNamedItem(ATTR_TYPE).getNodeValue()));

        NodeList fieldPropsNodes = nodeField.getChildNodes();
        for (int j = 0; j < fieldPropsNodes.getLength(); j++) {
            Node nodeFieldProp = fieldPropsNodes.item(j);
            if (nodeFieldProp.getNodeName().equals(NODE_PROPERTY)) {
                String propName = nodeFieldProp.getAttributes().getNamedItem(ATTR_NAME).getNodeValue();
                String value = StringEscapeUtils.unescapeXml(nodeFieldProp.getAttributes().getNamedItem(ATTR_VALUE).getNodeValue());
                if (propName != null && value != null) {
                    if ("fieldName".equals(propName)) {
                        field.setFieldName(value);
                    } else if ("fieldRequired".equals(propName)) {
                        field.setFieldRequired(Boolean.valueOf(value));
                    } else if ("groupWithPrevious".equals(propName)) {
                        field.setGroupWithPrevious(Boolean.valueOf(value));
                    } else if ("height".equals(propName)) {
                        field.setHeight(value);
                    } else if ("labelCSSClass".equals(propName)) {
                        field.setLabelCSSClass(value);
                    } else if ("labelCSSStyle".equals(propName)) {
                        field.setLabelCSSStyle(value);
                    } else if ("label".equals(propName)) {
                        field.setLabel(deserializeI18nEntrySet(value));
                    } else if ("errorMessage".equals(propName)) {
                        field.setErrorMessage(deserializeI18nEntrySet(value));
                    } else if ("title".equals(propName)) {
                        field.setTitle(deserializeI18nEntrySet(value));
                    } else if ("disabled".equals(propName)) {
                        field.setDisabled(Boolean.valueOf(value));
                    } else if ("readonly".equals(propName)) {
                        field.setReadonly(Boolean.valueOf(value));
                    } else if ("size".equals(propName)) {
                        field.setSize(value);
                    } else if ("formula".equals(propName)) {
                        field.setFormula(value);
                    } else if ("rangeFormula".equals(propName)) {
                        field.setRangeFormula(value);
                    } else if ("pattern".equals(propName)) {
                        field.setPattern(value);
                    } else if ("maxlength".equals(propName)) {
                        field.setMaxlength(Long.valueOf(value));
                    } else if ("styleclass".equals(propName)) {
                        field.setStyleclass(value);
                    } else if ("cssStyle".equals(propName)) {
                        field.setCssStyle(value);
                    } else if ("tabindex".equals(propName)) {
                        field.setTabindex(Long.valueOf(value));
                    } else if ("accesskey".equals(propName)) {
                        field.setAccesskey(value);
                    }  else if ("htmlContainer".equals(propName)) {
                        field.setHtmlContainer(value);
                    } else if ("isHTML".equals(propName)) {
                        field.setIsHTML(Boolean.valueOf(value));
                    } else if ("htmlContent".equals(propName)) {
                        field.setHtmlContent(deserializeI18nEntrySet(value));
                    } else if ("hideContent".equals(propName)) {
                        field.setHideContent(Boolean.valueOf(value));
                    }  else if ("defaultValueFormula".equals(propName)) {
                        field.setDefaultValueFormula(value);
                    }  else if ("bindingStr".equals(propName)) {
                        field.setBindingStr(value);
                    }
                }
            }
        }
        return field;
    }

    public void generateFieldXML(Field field, XMLNode parent) {
        XMLNode rootNode = new XMLNode(NODE_FIELD, parent);
        rootNode.addAttribute(ATTR_ID, String.valueOf(field.getId()));
        rootNode.addAttribute(ATTR_POSITION, String.valueOf(field.getPosition()));
        rootNode.addAttribute(ATTR_NAME, field.getFieldName());
        if (field.getFieldType() != null) {
            rootNode.addAttribute(ATTR_TYPE, field.getFieldType().getCode());
        }

        addXMLNode("fieldName", field.getFieldName(), rootNode);
        addXMLNode("fieldRequired", (field.getFieldRequired() != null ? String.valueOf(field.getFieldRequired()) : null), rootNode);
        addXMLNode("groupWithPrevious", (field.getGroupWithPrevious() != null ? String.valueOf(field.getGroupWithPrevious()) : null), rootNode);
        addXMLNode("height", field.getHeight(), rootNode);
        addXMLNode("labelCSSClass", field.getLabelCSSClass(), rootNode);
        addXMLNode("labelCSSStyle", field.getLabelCSSStyle(), rootNode);
        addXMLNode("label", (field.getLabel() != null ? serializeI18nSet(field.getLabel()) : null), rootNode);
        addXMLNode("errorMessage", (field.getErrorMessage() != null ? serializeI18nSet(field.getErrorMessage()) : null), rootNode);
        addXMLNode("title", (field.getTitle() != null ? serializeI18nSet(field.getTitle()) : null), rootNode);
        addXMLNode("disabled", (field.getDisabled() != null ? String.valueOf(field.getDisabled()) : null), rootNode);
        addXMLNode("readonly", (field.getReadonly() != null ? String.valueOf(field.getReadonly()) : null), rootNode);
        addXMLNode("size", field.getSize(), rootNode);
        addXMLNode("formula", field.getFormula(), rootNode);
        addXMLNode("rangeFormula", field.getRangeFormula(), rootNode);
        addXMLNode("pattern", field.getPattern(), rootNode);
        addXMLNode("maxlength", (field.getMaxlength() != null ? String.valueOf(field.getMaxlength()) : null), rootNode);
        addXMLNode("styleclass", field.getStyleclass(), rootNode);
        addXMLNode("cssStyle", field.getCssStyle(), rootNode);
        addXMLNode("tabindex", (field.getTabindex() != null ? String.valueOf(field.getTabindex()) : null), rootNode);
        addXMLNode("accesskey", field.getAccesskey(), rootNode);
        addXMLNode("isHTML", (field.getIsHTML() != null ? String.valueOf(field.getIsHTML()) : null), rootNode);
        addXMLNode("hideContent", (field.getHideContent() != null ? String.valueOf(field.getHideContent()) : null), rootNode);
        addXMLNode("htmlContainer", field.getHtmlContainer(), rootNode);
        addXMLNode("defaultValueFormula", field.getDefaultValueFormula(), rootNode);
        addXMLNode("bindingStr", field.getBindingStr(), rootNode);
        addXMLNode("htmlContent", (field.getHtmlContent() != null ? serializeI18nSet(field.getHtmlContent()) : null), rootNode);

        parent.addChild(rootNode);
    }

    public void generateDataHolderXML(DataHolder dataHolder, XMLNode parent) {
        XMLNode rootNode = new XMLNode(NODE_DATA_HOLDER, parent);
        rootNode.addAttribute(ATTR_ID, String.valueOf(dataHolder.getId()));
        rootNode.addAttribute(ATTR_TYPE, String.valueOf(dataHolder.getTypeCode()));
        rootNode.addAttribute(ATTR_VALUE, String.valueOf(dataHolder.getInfo()));
        rootNode.addAttribute(ATTR_NAME, String.valueOf(dataHolder.getRenderColor()));

        parent.addChild(rootNode);
    }

    protected String[] decodeStringArray(String textValue) {
        if (textValue == null || textValue.trim().length() == 0) return new String[0];
        String[] lista;
        lista = textValue.split("quot;");
        return lista;
    }

    protected String encodeStringArray(String[] value) {
        String cad = "";
        for (int i = 0; i < value.length; i++) {
            cad += "quot;" + value[i] + "quot;";
            i++;
            cad += ",quot;" + value[i] + "quot;";
        }
        return cad;
    }

    public String serializeI18nSet(I18nSet i18nSet) {
        String[] values = new String[i18nSet.entrySet().size() * 2];
        int i = 0;
        for (Iterator it = i18nSet.entrySet().iterator(); it.hasNext(); ) {
            I18nEntry entry = (I18nEntry) it.next();
            values[i] = entry.getLang();
            i++;
            values[i] = (String) entry.getValue();
            i++;
        }
        return encodeStringArray(values);
    }

    public I18nSet deserializeI18nEntrySet(String cadena) {
        String[] values = decodeStringArray(cadena);
        Map mapValues = new HashMap();
        for (int i = 0; i < values.length;i=i+4) {
            String key = values[i + 1];
            String value="";
            if( i+3 < values.length){
                value = values[i + 3];
            }
            if(key.length()==2){
                mapValues.put(key, value);
            }

        }
        return new I18nSet(mapValues);
    }
}
