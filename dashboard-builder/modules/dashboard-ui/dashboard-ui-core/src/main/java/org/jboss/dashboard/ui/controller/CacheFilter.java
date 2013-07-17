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
package org.jboss.dashboard.ui.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CacheFilter implements Filter {
    private static transient org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CacheFilter.class.getName());

    private FilterConfig filterConfig;
    private SimpleDateFormat sdf = new SimpleDateFormat("EE, dd MMM yyyy KK:mm:ss", Locale.ENGLISH);
    public static final long expiryMilliSeconds = 1000l * 3600l * 48; // 48 hours

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ((HttpServletResponse) servletResponse).addHeader("Last-Modified", "Wed, 15 Nov 1995 04:58:08 GMT");
        String expiryDate = sdf.format(new Date(System.currentTimeMillis() + expiryMilliSeconds));
        ((HttpServletResponse) servletResponse).addHeader("Expires", expiryDate+" GMT");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
