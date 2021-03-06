<%--

    Copyright (C) 2012 Red Hat, Inc. and/or its affiliates.

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
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<%
		ExportHandler handler = ExportHandler.lookup();
	%>
    <tr class="skn-odd_row">
		<%
			if (handler.isExportMode()) {
		%>
        <td width="250px" valign="top" class="skn-table_border">
            <%@ include file="dashboardsSelectionForm.jsp" %>
        </td>
        <td style="width:1px;">&nbsp;</td>
        <td valign="top" class="skn-table_border" style="padding:1px">
           <%@ include file="previewKPIsPerProvider.jsp" %>
        </td>
		<%
			} else if (handler.isImportMode()) {
		%>
		<td valign="top">
			<%@ include file="kpiImport.jsp" %>
		</td>
		<%
			}
		%>
    </tr>
</table>