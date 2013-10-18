/**
 * Copyright (C) 2013 JBoss Inc
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
package org.jboss.dashboard.ui.controller.requestChain;

import org.jboss.dashboard.ui.components.URLMarkupGenerator;
import org.jboss.dashboard.workspace.Parameters;

import javax.servlet.ServletException;

/**
 * The CSRF processor validates a security token inside the URLs.
 * The token is generated by the application itself and it's added to every URL generated.
 * That way the application prevents the processing of malicious CSRF requests.
 */
public class CSRFTokenProcessor extends RequestChainProcessor {

    @Override
    protected boolean processRequest() throws Exception {
        if (SessionInitializer.isNewSession(getRequest())) {
            // If the session is being created then the CSRF control it makes no sense.
            return true;
        }
        CSRFTokenGenerator csrfTokenGenerator = CSRFTokenGenerator.lookup();
        String token = getRequest().getParameter(csrfTokenGenerator.getTokenName());
        if (token != null) {
            if (csrfTokenGenerator.isValidToken(token)) {
                // If the current token is valid then generate a new one and continue.
                csrfTokenGenerator.generateToken();
            } else {
                // Throw an exception aborting the request flow.
                throw new ServletException("CSRF token validation broken.");
            }
        } else {
            // CSRF protection is guaranteed for AJAX & non-friendly URL based requests.
            String ajaxParam = getRequest().getParameter(Parameters.AJAX_ACTION);
            String servletPath = getRequest().getServletPath();
            boolean isAjax = (ajaxParam != null && Boolean.parseBoolean(ajaxParam));
            boolean isFriendly = servletPath.startsWith(FriendlyUrlProcessor.FRIENDLY_MAPPING);
            if (isAjax || !isFriendly) {
                // Throw an exception aborting the request flow.
                throw new ServletException("CSRF token missing.");
            }
        }
        return true;
    }
}
