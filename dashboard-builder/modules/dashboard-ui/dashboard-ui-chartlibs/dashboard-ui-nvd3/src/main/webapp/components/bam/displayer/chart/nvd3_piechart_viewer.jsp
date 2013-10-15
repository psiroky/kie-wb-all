<%--

    Copyright (C) 2012 JBoss Inc

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

          http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%@ page import="org.jboss.dashboard.factory.Factory" %>
<%@ page import="org.jboss.dashboard.ui.UIServices" %>
<%@ page import="org.jboss.dashboard.ui.components.chart.NVD3ChartViewer" %>
<%@ page import="org.jboss.dashboard.displayer.chart.AbstractChartDisplayer" %>
<%
    NVD3ChartViewer viewer = (NVD3ChartViewer) Factory.lookup("org.jboss.dashboard.ui.components.PieChartViewer_nvd3");
    AbstractChartDisplayer displayer = (AbstractChartDisplayer) viewer.getDataDisplayer();
%>
<%@include file="nvd3_chart_common.jspi"%>

<%-- EDIT MODE --%>

<% if( editor != null ) {
    session.setAttribute("chartId_iframe_viewer"+chartId, viewer);
    String basehref = UIServices.lookup().getUrlMarkupGenerator().getBaseHref(request);
%>
     <%-- Editing preview will be performed inside an IFRAME due to library problems with AJAX --%>
     <iframe
         width="680px" height="450px"
         style="border:0px;overflow: auto;"
          src="<%=basehref %>components/bam/displayer/chart/nvd3_piechart_viewer_iframe.jsp?chartId=<%=chartId%>">
     </iframe>
<% }
   else {
%>

<%-- DISPLAY MODE --%>

<% if( enableDrillDown ) { %>
<!-- Form for drill down action -->
<form method="post" action='<factory:formUrl friendly="false"/>' id='<%="form"+chartId%>'>
  <factory:handler bean="<%=viewer.getComponentName()%>" action="<%= NVD3ChartViewer.PARAM_ACTION %>"/>
  <input type="hidden" name="<%= NVD3ChartViewer.PARAM_NSERIE %>" value="0" />
</form>
<script defer="true">
    setAjax('<%="form"+chartId%>');
</script>
<% } %>
<%@include file="nvd3_chart_wrapper.jspi"%>
<%@include file="nvd3_piechart_script.jspi"%>
<%
   }
%>