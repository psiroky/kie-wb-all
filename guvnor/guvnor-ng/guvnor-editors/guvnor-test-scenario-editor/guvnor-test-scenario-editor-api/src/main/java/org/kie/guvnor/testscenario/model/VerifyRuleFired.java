/*
 * Copyright 2010 JBoss Inc
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

package org.kie.guvnor.testscenario.model;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class VerifyRuleFired
    implements
    Expectation {

    private String            ruleName;
    private Integer           expectedCount;

    /**
     * This is a natural language explanation of this verification.
     * For reporting purposes.
     */
    private String            explanation;

    /**
     * If this is true, then we expect it to fire at least once.
     * False means it should not fire at all (this is an alternative
     * to specifying an expected count).
     */
    private Boolean           expectedFire;

    private Boolean           successResult;
    private Integer           actualResult;

    public VerifyRuleFired() {
    }

    public VerifyRuleFired(String ruleName,
                           Integer expectedCount,
                           Boolean expectedFire) {
        this.setRuleName( ruleName );
        this.setExpectedCount( expectedCount );
        this.setExpectedFire( expectedFire );
    }

    public boolean wasSuccessful() {
        return getSuccessResult().booleanValue();
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setExpectedCount(Integer expectedCount) {
        this.expectedCount = expectedCount;
    }

    public Integer getExpectedCount() {
        return expectedCount;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExpectedFire(Boolean expectedFire) {
        this.expectedFire = expectedFire;
    }

    public Boolean getExpectedFire() {
        return expectedFire;
    }

    public void setSuccessResult(Boolean successResult) {
        this.successResult = successResult;
    }

    public Boolean getSuccessResult() {
        return successResult;
    }

    public void setActualResult(Integer actualResult) {
        this.actualResult = actualResult;
    }

    public Integer getActualResult() {
        return actualResult;
    }

}
