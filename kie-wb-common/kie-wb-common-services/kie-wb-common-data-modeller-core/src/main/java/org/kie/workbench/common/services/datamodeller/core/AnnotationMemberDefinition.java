/**
 * Copyright 2012 JBoss Inc
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

package org.kie.workbench.common.services.datamodeller.core;

public interface AnnotationMemberDefinition extends HasClassName {

    /**
     * Annotation member identifier e.g. name, size, quantity
     *
     * @return
     */
    String getName();

    /**
     *
     * @return Annotation's short description.
     */
    String getShortDescription();

    /**
     *
     * @return Annotation's long description.
     *
     */
    String getDescription();

    Object defaultValue();

    boolean isArray();

    /**
     * When a member is primitive, it will be wrapped by the corresponding java.lang type.
     * e.g. int primitive type for manipulation purposes is wrapped by java.lang.Integer.
     * getClassName() in this case will return "java.lang.Integer".
     *
     */
    boolean isPrimitiveType();

    boolean isString();

    /**
     * When a member is an enumeration value, the getClassName returns the name of the enumeration class.
     * and the value is wrapped with a String in the form "EnumerationClass.Value"
     *
     * e.g.
     *
     * If we have a member "retention" of type RetentionPolicy
     *
     * isEnum() returns true.
     *
     * getClassName() returns "java.lang.annotation.RetentionPolicy"
     *
     * and the values will be wrapped by strings like this.
     *  "RUNTIME", "CLASS" or "RUNTIME"
     *
     * @return
     */
    boolean isEnum();

}
