<%@ taglib uri="http://jakarta.apache.org/taglibs/i18n-1.0" prefix="i18n" %>
<i18n:bundle id="bundle" baseName="org.jbpm.designer.resources.i18n.DesignerConstants"
             locale='<%=request.getLocale()%>' />
<script type="text/javascript">
/**
 * @author nicolas.peters
 * 
 * Contains all strings for the default language (en-us).
 * Version 1 - 08/29/08
 */
if(!ORYX) var ORYX = {};

if(!ORYX.I18N) ORYX.I18N = {};

ORYX.I18N.Language = '<i18n:message key="ORYX.I18N.Language">en_us</i18n:message>';

if(!ORYX.I18N.Oryx) ORYX.I18N.Oryx = {};

ORYX.I18N.Oryx.title		= ORYX.TITLE;
ORYX.I18N.Oryx.noBackendDefined	= '<i18n:message key="ORYX.I18N.Oryx.noBackendDefined">Caution! \nNo Backend defined.\n The requested model cannot be loaded. Try to load a configuration with a save plugin.</i18n:message>';
//ORYX.I18N.Oryx.pleaseWait 	= "Please wait while loading...";
ORYX.I18N.Oryx.pleaseWait  = '<center>  <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAMPklEQVR4nGL8////f4YhDAAAAAD//2IaaAdQCgAAAAD//xryHgAAAAD//xryHgAAAAD//xryHgAAAAD//xryHgAAAAD//2IZGGv/QxC8AITRjHA5BiZGBkZGwuELAAAA//+0lKENACAAw9r9fzJkCIJAoZhv0pr5/UZbeqQAFPWNAZ0DCiYY2YH3FgAAAP//rNAxEkAwFEXRm6iMyozC6HQWYP9bEgmGn4yvSFRaG7jzzvsZoOSalq3fB1UhyUU8POIXZHNIcMR9JQbHLSfNMNJOM3XXY19MShgDxlalnTEPAAAA//+kkrEKwjAUAI8OXUoFpeDSraOCYyf//09aiMGUak1C8nwOWdz7Awd33O6Fir8CpWzhFnjOibg6wmLZHhPezgRn8E9DejnEv5GwIfGD5gQiaI4gQt0eOQxXutud02WkOfdUwFcV/pr/AAAA//+ckjsKwkAUACdp0giJSO5gGUhqG+9/DBWMEljNavZ91iLYWHqAgYGZvwp8kd8V0vtFnEYe1xPzeCbeLizhjjzDKiYJ3ClwcAMzcAVTsgquilvCRclLRGMgq1A1Ldt9z6470A5Hqk291ihKPgAAAP//jNFLCgIxEAbhSoeAMOIxPID3v4orGRFGFB+ome4/cSW69AYfVX8f+EV/4OHO43rmfjxwm8Zv2fqEcFIX1kQpBSXoyZDPKJymTg/RFUQI1MgSpiBrBkvYsKJ5pU479uOW1+XEcr0hLwZyNswSbwAAAP//fNMxCsJAEEDRv8uIiZ3gGSwsLexyCO/fi2BYiJqgOzszFrbiFf7j/xX4VVrrm3kqPG5X7uOF11SoyxOrFW2NZo65oWpoa1gkIiWc9D0jZTwC84BwiMDcaVqhKbnOdEuhn0e6pSA5s9kf2Q1ntocTkmAlwrrrERE+AAAA//9slEsKwlAQwDIzzmu1ILrt1vufS0W0rVKo7fu4EEHBKyQkfw2UUn5Jx4VHf6M7H+mvJ8ahY56eZKCIIdUebQLqgToEVh7wUOHuqBmqhpogCKYK8rXQ8g4/p0jOmZgSKWXiPMH9QrPdUbcHTJVlHND1Btz5jOIFAAD//3SUwQqDQAxEX5IlW/3/r9QKLbYeRJMeFlwvvQ/MMMO8vwtEBOv65jlPvJaZ7fvB1Che8WHkMYxXSFNBRVBtzMgI8o7PTLpJO3wmIB2v18oiSJOQapxnwLFjpeBe8Vp7OWr8AAAA//98lb0OgzAMhD87TpFaeP+3pIUpEandwTCw9KTb70enuxnwCFrvrJ83+7Zx9EY1Y37NTNOD7zhQgtEb4YPwgGLU53KK9kxcFFFFrxYlT0kkBf5HgJPm3TnXSiklaRUzy1ZV+QEAAP//bJQ5DkBQFEXPe8ZIJDRWoLX/5SgUGhGF8QtfQYSwgZt7cocXwGQMTdviO0oUBHiej6owjgN1VWL6jm2ezpGaBbvOgCVKM9K8IIwTxO647lWdJwAC8n2uf4YrsUc3RAUVPU2r3joHAAAA//+MlbkNgEAQA4c/JEUipAQaoP8ykKAB3rs9dgmAACKcOLNkayS/CpjZdeaq+CCEIHjnGYcedQvrPGOyU5ii4lBxmN841ok0L6jajrJuSExJs5w4ie/lozcmP/Ql+5vx+AkAAP//YkLX9OfvX4bf0AzFxMTM8OnLZ4Zfv34y3Lj7kOHK7QcM7IISDBxCYpDkA0nIDExsHAx/vn9leHxwA8P7+9cY/jOzMPz79xcix8QEx7CCAVkMG8amBiaGXLgwMDAwAAAAAP//QvEAQiMzAysrK8OfP38Zvnz9wnDt5h2GZy9eMRgaGjIIi4gwsAqIMvDIKMGjm+H/PwZGZhYGhv//GZ4cWM/w5vYlhj//GRj+/P7J8A+aoWHmExMLMHXoGBsAAAAA///CaKwwQjMcMxMzw7efPxjuP3jI8OLFSwZdXR0GcXExhl+/fjGwMDEy8IhJM/DLqzH8h4Y0w///0HbKf4Yn+9YwvHtwg+HPP0aG379+MPz794+go8kFAAAAAP//rNKxDcIwEEDRf45kiJKO0FAZKlbPDpnGyAUiFeXZvmOAtPwV3j8IAIQgmDvvfSfnF9dl4ZESqkqMJ8Zx4hwjl/Rkvt2xpiCCuyHDgPdK2Va+n0LtTquKWT98/Y9+AAAA//+s1j0SQDAUAOGNEUkotFpKrVu7g8swWoXCXx5RqMwo7Rm2+D7A/YBsF6HvB7Z1o6pKtNYoFWGMxTqHcynWGIq6IclywikoFOEKRLHGzxNj17KvC94fiMhrp7+6AQAA///C4gFIxvzw6TPDy5cvGXj5eBkkxcUZ/v79y8DKxsrAysaOqFBYWBi4+YUYRDWNGf7//8cAa4X+//efgZmDi+Hrg2sMz49tYfj9n4Hh988fDP/+QmKBmp4AAAAA//+s1z0OQEAUAOGRt0/Y6CSoJEr3L11Bo3UCJEu9WX/ddjpHmORr5nN5lm1ld466qrA2B0A1RVNFjCIiGKMID2XXUzQtV/CR4XNfSGZx48AxT5wkhOAjpb8iXgAAAP//wuqB/wwMDN++fmUQFRZmUJCTY2BgYGBgZmFhYGFlgziaCVq+Q0ssNjZ2BjFtMwZGZmYG1NqHkYHh3z+GF/tXMXz7+J7h9+8/DH9+/6ZqDAAAAAD//6SYsRGCQBAA15//OSAktwxrcGzC+miBMoihAxKMfO4PzsBhDAxpYZPd2b8WOuiUoqiurDljRYkpIVIjVUWM6UfanX3bMHfGvmOZBgIXdn3jJeNm2Gumvd25Pp5IAKmbr63D+afwAQAA///CWowyMDBAqm1GZgZmaNOVnZ2TgZWVjYGZiRmlbIZV7SwsLAziOmYMjCyskHYMLD/8/8vAzMHN8P7MHoYP9y5Dk9Ivhn9//1KleAUAAAD//8IaBDCHsbKyMHCwczCwc3AysLKxM7CwsDAwYgk1JiYmBoZ/fxn4ZZQZ+GRUUPICxC9MDP9+/WR4tXcVw4/v3xj+/PrN8PfvH6rkBQAAAAD//6zVsRFAUBAG4b3/7h4j14RY+zqQyLUgE2EQC16mhm92tmpoEh5JZqGUhsxA7tUryoyIpB9GzPRR4LnxtmNfF7Z54jJxHv8E/QIAAP//whkDsFhgZmFhYIZ2SnA5npGREVIL//vDICCvzsAjLsvw7/cvlKbzf4b/DEwsLAxvDq1j+Pr2JcPvv/8Y/vz+TXEyAgAAAP//wh0DJLRHkAEbByeDsIYxtImBBP7/Y2Bk5WD4+eoRw5tjmxn+MEBjgcK6AQAAAP//otrQIqwNxfDvH4OQqj4DO78wpHZG9vT/fwxMbJwM745tYfjy7B6kwfcHFgvkeQAAAAD//6Lq2CgkM/9j4BIQZhBQ1mX4i5aMGP7/Z2BkYWX48/E1w+uDayE19K+fDH///mX4R2YsAAAAAP//ovrgLqS3xMAgomnCwMzKhumof/8YmDm4GT6c2snw5eENhj8MjAx/f/9i+PeXvHYSAAAA//+ivgcYGRn+//3LwCejzMAtqcDw7/dPjMzMwMzC8Pfre4bXh9Yy/PnHQFGJBAAAAP//ookHGBn+M7CysUEy89+/kBIKeZz03z8GJg5uho+ndzF8eXid4Q8jE7SJQXqJBAAAAP//osn8ACMjEwPD//8MQmqGDCycPAy/v3xg+P/7FwN0qBnSQWdhZ/j75SPD64NrIJn51y+Gv3//Mvz/T1pSAgAAAP//os0EB7QRxykkyqAeVcQgZuXDwC4ux8DAxMzw/+dXhr/fPjP8/faJgeHfX4Z3h9czfH1yh+EvIxPD3z9/SE5CAAAAAP//oskEByMjI2Rs8x8jg4CCFgOHlDLD1/dvGL68eMTw/dl9hl+vHjL8fv+K4f/vnwwcsuoMTJy8DH///GL4z8oCzwfEjmAAAAAA//+0mbsRACAMQrmLJ/vPGyIWfmobmYCOB3w7OI4RbarNzJW+NkqFUYIBRDSEBXJV1U7e0epFEwAA//+i2RQTLASZWVgZ2BgZGZiZWRhYoGNN/xj+M/xjYoFm2n8MzGwcDKxsbHibK7gAAAAA//+i6RQTzGhIbPxj+PcPgf8j9Y9hYz/MzPgbjNgAAAAA//+i+RwZsvGwwV5ISQMRYWBggA47ktbmggEAAAAA//+i/SQfGiBkHSmOZ2BgYAAAAAD//6L7NCupDiQEAAAAAP//GvIT3QAAAAD//xryHgAAAAD//wMAIbECF8xAqXsAAAAASUVORK5CYII=" width="24px" height="24px"> <b><i18n:message key="ORYX.I18N.Oryx.pleaseWait"></i18n:message></b></center>';
ORYX.I18N.Oryx.notLoggedOn = '<i18n:message key="ORYX.I18N.Oryx.notLoggedOn">Not logged on</i18n:message>';
ORYX.I18N.Oryx.editorOpenTimeout = '<i18n:message key="ORYX.I18N.Oryx.editorOpenTimeout">The editor does not seem to be started yet. Please check, whether you have a popup blocker enabled and disable it or allow popups for this site. We will never display any commercials on this site.</i18n:message>';

if(!ORYX.I18N.AddDocker) ORYX.I18N.AddDocker = {};

ORYX.I18N.AddDocker.group = '<i18n:message key="ORYX.I18N.AddDocker.group">Docker</i18n:message>';
ORYX.I18N.AddDocker.add = '<i18n:message key="ORYX.I18N.AddDocker.add">Add Docker</i18n:message>';
ORYX.I18N.AddDocker.addDesc = '<i18n:message key="ORYX.I18N.AddDocker.addDesc">Add a Docker to an edge, by clicking on it</i18n:message>';
ORYX.I18N.AddDocker.del = '<i18n:message key="ORYX.I18N.AddDocker.del">Delete Docker</i18n:message>';
ORYX.I18N.AddDocker.delDesc = '<i18n:message key="ORYX.I18N.AddDocker.delDesc">Delete a Docker</i18n:message>';

if(!ORYX.I18N.ShapeConnector) ORYX.I18N.ShapeConnector = {};

ORYX.I18N.ShapeConnector.group = '<i18n:message key="ORYX.I18N.ShapeConnector.group">Connector</i18n:message>';
ORYX.I18N.ShapeConnector.add = '<i18n:message key="ORYX.I18N.ShapeConnector.add">Connect Shapes</i18n:message>';
ORYX.I18N.ShapeConnector.addDesc = '<i18n:message key="ORYX.I18N.ShapeConnector.addDesc">Connect several nodes by marking them in the desired order</i18n:message>';

if(!ORYX.I18N.SSExtensionLoader) ORYX.I18N.SSExtensionLoader = {};

ORYX.I18N.SSExtensionLoader.group = '<i18n:message key="ORYX.I18N.SSExtensionLoader.group">Stencil Set</i18n:message>';
ORYX.I18N.SSExtensionLoader.add = '<i18n:message key="ORYX.I18N.SSExtensionLoader.add">Add Stencil Set Extension</i18n:message>';
ORYX.I18N.SSExtensionLoader.addDesc = '<i18n:message key="ORYX.I18N.SSExtensionLoader.addDesc">Add a stencil set extension</i18n:message>';
ORYX.I18N.SSExtensionLoader.loading = '<i18n:message key="ORYX.I18N.SSExtensionLoader.loading">Loading Stencil Set Extension</i18n:message>';
ORYX.I18N.SSExtensionLoader.noExt = '<i18n:message key="ORYX.I18N.SSExtensionLoader.noExt">There are no extensions available or all available extensions are already loaded.</i18n:message>';
ORYX.I18N.SSExtensionLoader.failed1 = '<i18n:message key="ORYX.I18N.SSExtensionLoader.failed1">Loading stencil set extensions configuration failed. The response is not a valid configuration file.</i18n:message>';
ORYX.I18N.SSExtensionLoader.failed2 = '<i18n:message key="ORYX.I18N.SSExtensionLoader.failed2">Loading stencil set extension configuration file failed. The request returned an error.</i18n:message>';
ORYX.I18N.SSExtensionLoader.panelTitle = '<i18n:message key="ORYX.I18N.SSExtensionLoader.panelTitle">Stencil Set Extensions</i18n:message>';
ORYX.I18N.SSExtensionLoader.panelText = '<i18n:message key="ORYX.I18N.SSExtensionLoader.panelText">Select the stencil set extensions you want to load.</i18n:message>';

if(!ORYX.I18N.AdHocCC) ORYX.I18N.AdHocCC = {};

ORYX.I18N.AdHocCC.group = '<i18n:message key="ORYX.I18N.AdHocCC.group">Ad Hoc</i18n:message>';
ORYX.I18N.AdHocCC.compl = '<i18n:message key="ORYX.I18N.AdHocCC.compl">Edit Completion Condition</i18n:message>';
ORYX.I18N.AdHocCC.complDesc = '<i18n:message key="ORYX.I18N.AdHocCC.complDesc">Edit an Ad Hoc Activity\'s Completion Condition</i18n:message>';
ORYX.I18N.AdHocCC.notOne = '<i18n:message key="ORYX.I18N.AdHocCC.notOne">Not exactly one element selected!</i18n:message>';
ORYX.I18N.AdHocCC.nodAdHocCC = '<i18n:message key="ORYX.I18N.AdHocCC.nodAdHocCC">Selected element has no ad hoc completion condition!</i18n:message>';
ORYX.I18N.AdHocCC.selectTask = '<i18n:message key="ORYX.I18N.AdHocCC.selectTask">Select a task...</i18n:message>';
ORYX.I18N.AdHocCC.selectState = '<i18n:message key="ORYX.I18N.AdHocCC.selectState">Select a state...</i18n:message>';
ORYX.I18N.AdHocCC.addExp = '<i18n:message key="ORYX.I18N.AdHocCC.addExp">Add Expression</i18n:message>';
ORYX.I18N.AdHocCC.selectDataField = '<i18n:message key="ORYX.I18N.AdHocCC.selectDataField">Select a data field...</i18n:message>';
ORYX.I18N.AdHocCC.enterEqual = '<i18n:message key="ORYX.I18N.AdHocCC.enterEqual">Enter a value that must equal...</i18n:message>';
ORYX.I18N.AdHocCC.and = '<i18n:message key="ORYX.I18N.AdHocCC.and">and</i18n:message>';
ORYX.I18N.AdHocCC.or = '<i18n:message key="ORYX.I18N.AdHocCC.or">or</i18n:message>';
ORYX.I18N.AdHocCC.not = '<i18n:message key="ORYX.I18N.AdHocCC.not">not</i18n:message>';
ORYX.I18N.AdHocCC.clearCC = '<i18n:message key="ORYX.I18N.AdHocCC.clearCC">Clear Completion Condition</i18n:message>';
ORYX.I18N.AdHocCC.editCC = '<i18n:message key="ORYX.I18N.AdHocCC.editCC">Edit Ad-Hoc Completion Condtions</i18n:message>';
ORYX.I18N.AdHocCC.addExecState = '<i18n:message key="ORYX.I18N.AdHocCC.addExecState">Add Execution State Expression: </i18n:message>';
ORYX.I18N.AdHocCC.addDataExp = '<i18n:message key="ORYX.I18N.AdHocCC.addDataExp">Add Data Expression: </i18n:message>';
ORYX.I18N.AdHocCC.addLogOp = '<i18n:message key="ORYX.I18N.AdHocCC.addLogOp">Add Logical Operators: </i18n:message>';
ORYX.I18N.AdHocCC.curCond = '<i18n:message key="ORYX.I18N.AdHocCC.curCond">Current Completion Condition: </i18n:message>';

if(!ORYX.I18N.AMLSupport) ORYX.I18N.AMLSupport = {};

ORYX.I18N.AMLSupport.group = '<i18n:message key="ORYX.I18N.AMLSupport.group">EPC</i18n:message>';
ORYX.I18N.AMLSupport.imp = '<i18n:message key="ORYX.I18N.AMLSupport.imp">Import AML file</i18n:message>';
ORYX.I18N.AMLSupport.impDesc = '<i18n:message key="ORYX.I18N.AMLSupport.impDesc">Import an Aris 7 AML file</i18n:message>';
ORYX.I18N.AMLSupport.failed = '<i18n:message key="ORYX.I18N.AMLSupport.failed">Importing AML file failed. Please check, if the selected file is a valid AML file. Error message: </i18n:message>';
ORYX.I18N.AMLSupport.failed2 = '<i18n:message key="ORYX.I18N.AMLSupport.failed2">Importing AML file failed: </i18n:message>';
ORYX.I18N.AMLSupport.noRights = '<i18n:message key="ORYX.I18N.AMLSupport.noRights">You have no rights to import multiple EPC-Diagrams (Login required).</i18n:message>';
ORYX.I18N.AMLSupport.panelText = '<i18n:message key="ORYX.I18N.AMLSupport.panelText">Select an AML (.xml) file to import.</i18n:message>';
ORYX.I18N.AMLSupport.file = '<i18n:message key="ORYX.I18N.AMLSupport.file">File</i18n:message>';
ORYX.I18N.AMLSupport.importBtn = '<i18n:message key="ORYX.I18N.AMLSupport.importBtn">Import AML-File</i18n:message>';
ORYX.I18N.AMLSupport.get = '<i18n:message key="ORYX.I18N.AMLSupport.get">Get diagrams...</i18n:message>';
ORYX.I18N.AMLSupport.close = '<i18n:message key="ORYX.I18N.AMLSupport.close">Close</i18n:message>';
ORYX.I18N.AMLSupport.title = '<i18n:message key="ORYX.I18N.AMLSupport.title">Title</i18n:message>';
ORYX.I18N.AMLSupport.selectDiagrams = '<i18n:message key="ORYX.I18N.AMLSupport.selectDiagrams">Select the diagram(s) you want to import. <br/> If one model is selected, it will be imported in the current editor, if more than one is selected, those models will directly be stored in the repository.</i18n:message>';
ORYX.I18N.AMLSupport.impText = '<i18n:message key="ORYX.I18N.AMLSupport.impText">Import</i18n:message>';
ORYX.I18N.AMLSupport.impProgress = '<i18n:message key="ORYX.I18N.AMLSupport.impProgress">Importing...</i18n:message>';
ORYX.I18N.AMLSupport.cancel = '<i18n:message key="ORYX.I18N.AMLSupport.cancel">Cancel</i18n:message>';
ORYX.I18N.AMLSupport.name = '<i18n:message key="ORYX.I18N.AMLSupport.name">Name</i18n:message>';
ORYX.I18N.AMLSupport.allImported = '<i18n:message key="ORYX.I18N.AMLSupport.allImported">All imported diagrams.</i18n:message>';
ORYX.I18N.AMLSupport.ok = '<i18n:message key="ORYX.I18N.AMLSupport.ok">Ok</i18n:message>';

if(!ORYX.I18N.Arrangement) ORYX.I18N.Arrangement = {};


ORYX.I18N.Arrangement.groupZ = '<i18n:message key="ORYX.I18N.Arrangement.groupZ">Z-Order</i18n:message>';
ORYX.I18N.Arrangement.btf = '<i18n:message key="ORYX.I18N.Arrangement.btf">Bring To Front</i18n:message>';
ORYX.I18N.Arrangement.btfDesc = '<i18n:message key="ORYX.I18N.Arrangement.btfDesc">Bring to Front</i18n:message>';
ORYX.I18N.Arrangement.btb = '<i18n:message key="ORYX.I18N.Arrangement.btb">Bring To Back</i18n:message>';
ORYX.I18N.Arrangement.btbDesc = '<i18n:message key="ORYX.I18N.Arrangement.btbDesc">Bring To Back</i18n:message>';
ORYX.I18N.Arrangement.bf = '<i18n:message key="ORYX.I18N.Arrangement.bf">Bring Forward</i18n:message>';
ORYX.I18N.Arrangement.bfDesc = '<i18n:message key="ORYX.I18N.Arrangement.bfDesc">Bring Forward</i18n:message>';
ORYX.I18N.Arrangement.bb = '<i18n:message key="ORYX.I18N.Arrangement.bb">Bring Backward</i18n:message>';
ORYX.I18N.Arrangement.bbDesc = '<i18n:message key="ORYX.I18N.Arrangement.bbDesc">Bring Backward</i18n:message>';
ORYX.I18N.Arrangement.groupA = '<i18n:message key="ORYX.I18N.Arrangement.groupA">Alignment</i18n:message>';
ORYX.I18N.Arrangement.ab = '<i18n:message key="ORYX.I18N.Arrangement.ab">Alignment Bottom</i18n:message>';
ORYX.I18N.Arrangement.abDesc = '<i18n:message key="ORYX.I18N.Arrangement.abDesc">Bottom</i18n:message>';
ORYX.I18N.Arrangement.am = '<i18n:message key="ORYX.I18N.Arrangement.am">Alignment Middle</i18n:message>';
ORYX.I18N.Arrangement.amDesc = '<i18n:message key="ORYX.I18N.Arrangement.amDesc">Middle</i18n:message>';
ORYX.I18N.Arrangement.at = '<i18n:message key="ORYX.I18N.Arrangement.at">Alignment Top</i18n:message>';
ORYX.I18N.Arrangement.atDesc = '<i18n:message key="ORYX.I18N.Arrangement.atDesc">Top</i18n:message>';
ORYX.I18N.Arrangement.al = '<i18n:message key="ORYX.I18N.Arrangement.al">Alignment Left</i18n:message>';
ORYX.I18N.Arrangement.alDesc = '<i18n:message key="ORYX.I18N.Arrangement.alDesc">Left</i18n:message>';
ORYX.I18N.Arrangement.ac = '<i18n:message key="ORYX.I18N.Arrangement.ac">Alignment Center</i18n:message>';
ORYX.I18N.Arrangement.acDesc = '<i18n:message key="ORYX.I18N.Arrangement.acDesc">Center</i18n:message>';
ORYX.I18N.Arrangement.ar = '<i18n:message key="ORYX.I18N.Arrangement.ar">Alignment Right</i18n:message>';
ORYX.I18N.Arrangement.arDesc = '<i18n:message key="ORYX.I18N.Arrangement.arDesc">Right</i18n:message>';
ORYX.I18N.Arrangement.as = '<i18n:message key="ORYX.I18N.Arrangement.as">Alignment Same Size</i18n:message>';
ORYX.I18N.Arrangement.asDesc = '<i18n:message key="ORYX.I18N.Arrangement.asDesc">Same Size</i18n:message>';

if(!ORYX.I18N.BPELSupport) ORYX.I18N.BPELSupport = {};


ORYX.I18N.BPELSupport.group = '<i18n:message key="ORYX.I18N.BPELSupport.group">BPEL</i18n:message>';
ORYX.I18N.BPELSupport.exp = '<i18n:message key="ORYX.I18N.BPELSupport.exp">Export BPEL</i18n:message>';
ORYX.I18N.BPELSupport.expDesc = '<i18n:message key="ORYX.I18N.BPELSupport.expDesc">Export diagram to BPEL</i18n:message>';
ORYX.I18N.BPELSupport.imp = '<i18n:message key="ORYX.I18N.BPELSupport.imp">Import BPEL</i18n:message>';
ORYX.I18N.BPELSupport.impDesc = '<i18n:message key="ORYX.I18N.BPELSupport.impDesc">Import a BPEL file</i18n:message>';
ORYX.I18N.BPELSupport.selectFile = '<i18n:message key="ORYX.I18N.BPELSupport.selectFile">Select a BPEL file to import</i18n:message>';
ORYX.I18N.BPELSupport.file = '<i18n:message key="ORYX.I18N.BPELSupport.file">file</i18n:message>';
ORYX.I18N.BPELSupport.impPanel = '<i18n:message key="ORYX.I18N.BPELSupport.impPanel">Import BPEL file</i18n:message>';
ORYX.I18N.BPELSupport.impBtn = '<i18n:message key="ORYX.I18N.BPELSupport.impBtn">Import</i18n:message>';
ORYX.I18N.BPELSupport.content = '<i18n:message key="ORYX.I18N.BPELSupport.content">content</i18n:message>';
ORYX.I18N.BPELSupport.close = '<i18n:message key="ORYX.I18N.BPELSupport.close">Close</i18n:message>';
ORYX.I18N.BPELSupport.error = '<i18n:message key="ORYX.I18N.BPELSupport.error">Error</i18n:message>';
ORYX.I18N.BPELSupport.progressImp = '<i18n:message key="ORYX.I18N.BPELSupport.progressImp">Import...</i18n:message>';
ORYX.I18N.BPELSupport.progressExp = '<i18n:message key="ORYX.I18N.BPELSupport.progressExp">Export...</i18n:message>';
ORYX.I18N.BPELSupport.impFailed = '<i18n:message key="ORYX.I18N.BPELSupport.impFailed">An error while importing occurs! <br/>Please check error message: <br/><br/></i18n:message>';

if(!ORYX.I18N.BPELLayout) ORYX.I18N.BPELLayout = {};

ORYX.I18N.BPELLayout.group = '<i18n:message key="ORYX.I18N.BPELLayout.group">BPELLayout</i18n:message>';
ORYX.I18N.BPELLayout.disable = '<i18n:message key="ORYX.I18N.BPELLayout.disable">disable layout</i18n:message>';
ORYX.I18N.BPELLayout.disDesc = '<i18n:message key="ORYX.I18N.BPELLayout.disDesc">disable auto layout plug-in</i18n:message>';
ORYX.I18N.BPELLayout.enable = '<i18n:message key="ORYX.I18N.BPELLayout.enable">enable layout</i18n:message>';
ORYX.I18N.BPELLayout.enDesc = '<i18n:message key="ORYX.I18N.BPELLayout.enDesc">enable auto layout plug-in</i18n:message>';

if(!ORYX.I18N.BPEL4Chor2BPELSupport) ORYX.I18N.BPEL4Chor2BPELSupport = {};

ORYX.I18N.BPEL4Chor2BPELSupport.group = '<i18n:message key="ORYX.I18N.BPEL4Chor2BPELSupport.group">BPEL4Chor</i18n:message>';
ORYX.I18N.BPEL4Chor2BPELSupport.exp = '<i18n:message key="ORYX.I18N.BPEL4Chor2BPELSupport.exp">Export to BPEL</i18n:message>';
ORYX.I18N.BPEL4Chor2BPELSupport.expDesc = '<i18n:message key="ORYX.I18N.BPEL4Chor2BPELSupport.expDesc">Export diagram to BPEL</i18n:message>';

if(!ORYX.I18N.BPEL4ChorSupport) ORYX.I18N.BPEL4ChorSupport = {};

ORYX.I18N.BPEL4ChorSupport.group = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.group">BPEL4Chor</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.exp = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.exp">Export BPEL4Chor</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.expDesc = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.expDesc">Export diagram to BPEL4Chor</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.imp = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.imp">Import BPEL4Chor</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.impDesc = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.impDesc">Import a BPEL4Chor file</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.gen = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.gen">BPEL4Chor generator</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.genDesc = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.genDesc">generate values of some BPEL4Chor properties if they are already known(e.g. sender of messageLink)</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.selectFile = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.selectFile">Select a BPEL4Chor file to import</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.file = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.file">file</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.impPanel = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.impPanel">Import BPEL4Chor file</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.impBtn = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.impBtn">Import</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.content = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.content">content</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.close = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.close">Close</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.error = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.error">Error</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.progressImp = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.progressImp">Import...</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.progressExp = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.progressExp">Export...</i18n:message>';
ORYX.I18N.BPEL4ChorSupport.impFailed = '<i18n:message key="ORYX.I18N.BPEL4ChorSupport.impFailed">An error while importing occurs! <br/>Please check error message: <br/><br/></i18n:message>';

if(!ORYX.I18N.Bpel4ChorTransformation) ORYX.I18N.Bpel4ChorTransformation = {};

ORYX.I18N.Bpel4ChorTransformation.group = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.group">Export</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.exportBPEL = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.exportBPEL">Export BPEL4Chor</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.exportBPELDesc = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.exportBPELDesc">Export diagram to BPEL4Chor</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.exportXPDL = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.exportXPDL">Export XPDL4Chor</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.exportXPDLDesc = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.exportXPDLDesc">Export diagram to XPDL4Chor</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.warning = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.warning">Warning</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.wrongValue = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.wrongValue">The changed name must have the value \"1\" to avoid errors during the transformation to BPEL4Chor</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.loopNone = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.loopNone">The loop type of the receive task must be \"None\" to be transformable to BPEL4Chor</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.error = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.error">Error</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.noSource = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.noSource">1 with id 2 has no source object.</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.noTarget = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.noTarget">1 with id 2 has no target object.</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.transCall = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.transCall">An error occured during the transformation call. 1:2</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.loadingXPDL4ChorExport = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.loadingXPDL4ChorExport">Export to XPDL4Chor</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.loadingBPEL4ChorExport = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.loadingBPEL4ChorExport">Export to BPEL4Chor</i18n:message>';
ORYX.I18N.Bpel4ChorTransformation.noGen = '<i18n:message key="ORYX.I18N.Bpel4ChorTransformation.noGen">The transformation input could not be generated: 1<br>n2<br></i18n:message>';

ORYX.I18N.BPMN2PNConverter = {
  name: '<i18n:message key="ORYX.I18N.BPMN2PNConverter_name">Convert to Petri net</i18n:message>',
  desc: '<i18n:message key="ORYX.I18N.BPMN2PNConverter_desc">Converts BPMN diagrams to Petri nets</i18n:message>',
  group: '<i18n:message key="ORYX.I18N.BPMN2PNConverter_group">Export</i18n:message>',
  error: '<i18n:message key="ORYX.I18N.BPMN2PNConverter_error">Error</i18n:message>',
  errors: {
    server: '<i18n:message key="ORYX.I18N.BPMN2PNConverter_server">Couldn\\\'t import BPNM diagram.</i18n:message>',
    noRights: '<i18n:message key="ORYX.I18N.BPMN2PNConverter_noRights">Don\\\'t you have read permissions on given model?</i18n:message>',
    notSaved: '<i18n:message key="ORYX.I18N.BPMN2PNConverter_notSaved">Model must be saved and reopened for using Petri net exporter!</i18n:message>'
  },
  progress: {
      status: '<i18n:message key="ORYX.I18N.BPMN2PNConverter_status">Status</i18n:message>',
      importingModel: '<i18n:message key="ORYX.I18N.BPMN2PNConverter_importingModel">Importing BPMN Model</i18n:message>',
      fetchingModel: '<i18n:message key="ORYX.I18N.BPMN2PNConverter_fetchingModel">Fetching</i18n:message>',
      convertingModel: '<i18n:message key="ORYX.I18N.BPMN2PNConverter_convertingModel">Converting</i18n:message>',
      renderingModel: '<i18n:message key="ORYX.I18N.BPMN2PNConverter_renderingModel">Rendering</i18n:message>'
  }
}

if(!ORYX.I18N.TransformationDownloadDialog) ORYX.I18N.TransformationDownloadDialog = {};

ORYX.I18N.TransformationDownloadDialog.error = '<i18n:message key="ORYX.I18N.TransformationDownloadDialog.error">Error</i18n:message>';
ORYX.I18N.TransformationDownloadDialog.noResult = '<i18n:message key="ORYX.I18N.TransformationDownloadDialog.noResult">The transformation service did not return a result.</i18n:message>';
ORYX.I18N.TransformationDownloadDialog.errorParsing = '<i18n:message key="ORYX.I18N.TransformationDownloadDialog.errorParsing">Error During the Parsing of the Diagram.</i18n:message>';
ORYX.I18N.TransformationDownloadDialog.transResult = '<i18n:message key="ORYX.I18N.TransformationDownloadDialog.transResult">Transformation Results</i18n:message>';
ORYX.I18N.TransformationDownloadDialog.showFile = '<i18n:message key="ORYX.I18N.TransformationDownloadDialog.showFile">Show the result file</i18n:message>';
ORYX.I18N.TransformationDownloadDialog.downloadFile = '<i18n:message key="ORYX.I18N.TransformationDownloadDialog.downloadFile">Download the result file</i18n:message>';
ORYX.I18N.TransformationDownloadDialog.downloadAll = '<i18n:message key="ORYX.I18N.TransformationDownloadDialog.downloadAll">Download all result files</i18n:message>';

if(!ORYX.I18N.DesynchronizabilityOverlay) ORYX.I18N.DesynchronizabilityOverlay = {};
//TODO desynchronizability is not a correct term
ORYX.I18N.DesynchronizabilityOverlay.group = '<i18n:message key="ORYX.I18N.DesynchronizabilityOverlay.group">Overlay</i18n:message>';
ORYX.I18N.DesynchronizabilityOverlay.name = '<i18n:message key="ORYX.I18N.DesynchronizabilityOverlay.name">Desynchronizability Checker</i18n:message>';
ORYX.I18N.DesynchronizabilityOverlay.desc = '<i18n:message key="ORYX.I18N.DesynchronizabilityOverlay.desc">Desynchronizability Checker</i18n:message>';
ORYX.I18N.DesynchronizabilityOverlay.sync = '<i18n:message key="ORYX.I18N.DesynchronizabilityOverlay.sync">The net is desynchronizable.</i18n:message>';
ORYX.I18N.DesynchronizabilityOverlay.error = '<i18n:message key="ORYX.I18N.DesynchronizabilityOverlay.error">The net has 1 syntax errors.</i18n:message>';
ORYX.I18N.DesynchronizabilityOverlay.invalid = '<i18n:message key="ORYX.I18N.DesynchronizabilityOverlay.invalid">Invalid answer from server.</i18n:message>';

if(!ORYX.I18N.Edit) ORYX.I18N.Edit = {};

ORYX.I18N.Edit.group = '<i18n:message key="ORYX.I18N.Edit.group">Edit</i18n:message>';
ORYX.I18N.Edit.cut = '<i18n:message key="ORYX.I18N.Edit.cut">Cut</i18n:message>';
ORYX.I18N.Edit.cutDesc = '<i18n:message key="ORYX.I18N.Edit.cutDesc">Cut the selection into a Designer clipboard</i18n:message>';
ORYX.I18N.Edit.copy = '<i18n:message key="ORYX.I18N.Edit.copy">Copy</i18n:message>';
ORYX.I18N.Edit.copyDesc = '<i18n:message key="ORYX.I18N.Edit.copyDesc">Copy the selection into an Designer clipboard</i18n:message>';
ORYX.I18N.Edit.paste = '<i18n:message key="ORYX.I18N.Edit.paste">Paste</i18n:message>';
ORYX.I18N.Edit.pasteDesc = '<i18n:message key="ORYX.I18N.Edit.pasteDesc">Paste the Designer clipboard to the canvas</i18n:message>';
ORYX.I18N.Edit.del = '<i18n:message key="ORYX.I18N.Edit.del">Delete</i18n:message>';
ORYX.I18N.Edit.delDesc = '<i18n:message key="ORYX.I18N.Edit.delDesc">Delete all selected shapes</i18n:message>';

if(!ORYX.I18N.EPCSupport) ORYX.I18N.EPCSupport = {};

ORYX.I18N.EPCSupport.group = '<i18n:message key="ORYX.I18N.EPCSupport.group">EPC</i18n:message>';
ORYX.I18N.EPCSupport.exp = '<i18n:message key="ORYX.I18N.EPCSupport.exp">Export EPC</i18n:message>';
ORYX.I18N.EPCSupport.expDesc = '<i18n:message key="ORYX.I18N.EPCSupport.expDesc">Export diagram to EPML</i18n:message>';
ORYX.I18N.EPCSupport.imp = '<i18n:message key="ORYX.I18N.EPCSupport.imp">Import EPC</i18n:message>';
ORYX.I18N.EPCSupport.impDesc = '<i18n:message key="ORYX.I18N.EPCSupport.impDesc">Import an EPML file</i18n:message>';
ORYX.I18N.EPCSupport.progressExp = '<i18n:message key="ORYX.I18N.EPCSupport.progressExp">Exporting model</i18n:message>';
ORYX.I18N.EPCSupport.selectFile = '<i18n:message key="ORYX.I18N.EPCSupport.selectFile">Select an EPML (.empl) file to import.</i18n:message>';
ORYX.I18N.EPCSupport.file = '<i18n:message key="ORYX.I18N.EPCSupport.file">File</i18n:message>';
ORYX.I18N.EPCSupport.impPanel = '<i18n:message key="ORYX.I18N.EPCSupport.impPanel">Import EPML File</i18n:message>';
ORYX.I18N.EPCSupport.impBtn = '<i18n:message key="ORYX.I18N.EPCSupport.impBtn">Import</i18n:message>';
ORYX.I18N.EPCSupport.close = '<i18n:message key="ORYX.I18N.EPCSupport.close">Close</i18n:message>';
ORYX.I18N.EPCSupport.error = '<i18n:message key="ORYX.I18N.EPCSupport.error">Error</i18n:message>';
ORYX.I18N.EPCSupport.progressImp = '<i18n:message key="ORYX.I18N.EPCSupport.progressImp">Import...</i18n:message>';

if(!ORYX.I18N.ERDFSupport) ORYX.I18N.ERDFSupport = {};

ORYX.I18N.ERDFSupport.exp = '<i18n:message key="ORYX.I18N.ERDFSupport.exp">Export to ERDF</i18n:message>';
ORYX.I18N.ERDFSupport.expDesc = '<i18n:message key="ORYX.I18N.ERDFSupport.expDesc">Export to ERDF</i18n:message>';
ORYX.I18N.ERDFSupport.imp = '<i18n:message key="ORYX.I18N.ERDFSupport.imp">Import from ERDF</i18n:message>';
ORYX.I18N.ERDFSupport.impDesc = '<i18n:message key="ORYX.I18N.ERDFSupport.impDesc">Import from ERDF</i18n:message>';
ORYX.I18N.ERDFSupport.impFailed = '<i18n:message key="ORYX.I18N.ERDFSupport.impFailed">"Request for import of ERDF failed.</i18n:message>';
ORYX.I18N.ERDFSupport.impFailed2 = '<i18n:message key="ORYX.I18N.ERDFSupport.impFailed2">An error while importing occurs! <br/>Please check error message: <br/><br/></i18n:message>';
ORYX.I18N.ERDFSupport.error = '<i18n:message key="ORYX.I18N.ERDFSupport.error">Error</i18n:message>';
ORYX.I18N.ERDFSupport.noCanvas = '<i18n:message key="ORYX.I18N.ERDFSupport.noCanvas">The xml document has no Oryx canvas node included!</i18n:message>';
ORYX.I18N.ERDFSupport.noSS = '<i18n:message key="ORYX.I18N.ERDFSupport.noSS">The Oryx canvas node has no stencil set definition included!</i18n:message>';
ORYX.I18N.ERDFSupport.wrongSS = '<i18n:message key="ORYX.I18N.ERDFSupport.wrongSS">The given stencil set does not fit to the current editor!</i18n:message>';
ORYX.I18N.ERDFSupport.selectFile = '<i18n:message key="ORYX.I18N.ERDFSupport.selectFile">Select an ERDF (.xml) file or type in the ERDF to import it!</i18n:message>';
ORYX.I18N.ERDFSupport.file = '<i18n:message key="ORYX.I18N.ERDFSupport.file">File</i18n:message>';
ORYX.I18N.ERDFSupport.impERDF = '<i18n:message key="ORYX.I18N.ERDFSupport.impERDF">Import ERDF</i18n:message>';
ORYX.I18N.ERDFSupport.impBtn = '<i18n:message key="ORYX.I18N.ERDFSupport.impBtn">Import</i18n:message>';
ORYX.I18N.ERDFSupport.impProgress = '<i18n:message key="ORYX.I18N.ERDFSupport.impProgress">Importing...</i18n:message>';
ORYX.I18N.ERDFSupport.close = '<i18n:message key="ORYX.I18N.ERDFSupport.close">Close</i18n:message>';
ORYX.I18N.ERDFSupport.deprTitle = '<i18n:message key="ORYX.I18N.ERDFSupport.deprTitle">Really export to eRDF?</i18n:message>';
ORYX.I18N.ERDFSupport.deprText = '<i18n:message key="ORYX.I18N.ERDFSupport.deprText">Exporting to eRDF is not recommended anymore because the support will be stopped in future versions of the Oryx editor. If possible, export the model to JSON. Do you want to export anyway?</i18n:message>';

if(!ORYX.I18N.jPDLSupport) ORYX.I18N.jPDLSupport = {};

ORYX.I18N.jPDLSupport.group = '<i18n:message key="ORYX.I18N.jPDLSupport.group">Export</i18n:message>';
ORYX.I18N.jPDLSupport.exp = '<i18n:message key="ORYX.I18N.jPDLSupport.exp">Export to jPDL</i18n:message>';
ORYX.I18N.jPDLSupport.expDesc = '<i18n:message key="ORYX.I18N.jPDLSupport.expDesc">Export to jPDL</i18n:message>';
ORYX.I18N.jPDLSupport.imp = '<i18n:message key="ORYX.I18N.jPDLSupport.imp">Import from jPDL</i18n:message>';
ORYX.I18N.jPDLSupport.impDesc = '<i18n:message key="ORYX.I18N.jPDLSupport.impDesc">Migrate a jPDL File to BPMN2</i18n:message>';
ORYX.I18N.jPDLSupport.impFailedReq = '<i18n:message key="ORYX.I18N.jPDLSupport.impFailedReq">Request for migration of jPDL failed.</i18n:message>';
//ORYX.I18N.jPDLSupport.impFailedJson = "Transformation of jPDL failed.";
ORYX.I18N.jPDLSupport.impFailedJsonAbort = '<i18n:message key="ORYX.I18N.jPDLSupport.impFailedJsonAbort">Migration aborted.</i18n:message>';
ORYX.I18N.jPDLSupport.loadSseQuestionTitle = '<i18n:message key="ORYX.I18N.jPDLSupport.loadSseQuestionTitle">jBPM stencil set extension needs to be loaded</i18n:message>';
ORYX.I18N.jPDLSupport.loadSseQuestionBody = '<i18n:message key="ORYX.I18N.jPDLSupport.loadSseQuestionBody">In order to migrate jPDL, the stencil set extension has to be loaded. Do you want to proceed?</i18n:message>';
ORYX.I18N.jPDLSupport.expFailedReq = '<i18n:message key="ORYX.I18N.jPDLSupport.expFailedReq">Request for export of model failed.</i18n:message>';
ORYX.I18N.jPDLSupport.expFailedXml = '<i18n:message key="ORYX.I18N.jPDLSupport.expFailedXml">Export to jPDL failed. Exporter reported: </i18n:message>';
ORYX.I18N.jPDLSupport.error = '<i18n:message key="ORYX.I18N.jPDLSupport.error">Error</i18n:message>';
ORYX.I18N.jPDLSupport.selectFile = '<i18n:message key="ORYX.I18N.jPDLSupport.selectFile">1. Select a jPDL processdefinition.xml file (or type it in)</i18n:message>';
ORYX.I18N.jPDLSupport.selectGpdFile = '<i18n:message key="ORYX.I18N.jPDLSupport.selectGpdFile">2. Select a jPDL gpd.xml file (or type it in)</i18n:message>';
ORYX.I18N.jPDLSupport.file = '<i18n:message key="ORYX.I18N.jPDLSupport.file">Definition file</i18n:message>';
ORYX.I18N.jPDLSupport.gpdfile = '<i18n:message key="ORYX.I18N.jPDLSupport.gpdfile">GPD file</i18n:message>';
ORYX.I18N.jPDLSupport.impJPDL = '<i18n:message key="ORYX.I18N.jPDLSupport.impJPDL">Migrate to BPMN2</i18n:message>';
ORYX.I18N.jPDLSupport.impBtn = '<i18n:message key="ORYX.I18N.jPDLSupport.impBtn">Migrate</i18n:message>';
ORYX.I18N.jPDLSupport.impProgress = '<i18n:message key="ORYX.I18N.jPDLSupport.impProgress">Migrating...</i18n:message>';
ORYX.I18N.jPDLSupport.close = '<i18n:message key="ORYX.I18N.jPDLSupport.close">Close</i18n:message>';

if(!ORYX.I18N.FromBPMN2Support) ORYX.I18N.FromBPMN2Support = {};

ORYX.I18N.FromBPMN2Support.selectFile = '<i18n:message key="ORYX.I18N.FromBPMN2Support.selectFile">Select an BPMN2 file or type in the BPMN2 to import it!</i18n:message>';
ORYX.I18N.FromBPMN2Support.file = '<i18n:message key="ORYX.I18N.FromBPMN2Support.file">File</i18n:message>';
ORYX.I18N.FromBPMN2Support.impBPMN2 = '<i18n:message key="ORYX.I18N.FromBPMN2Support.impBPMN2">Import BPMN2</i18n:message>';
ORYX.I18N.FromBPMN2Support.impBtn = '<i18n:message key="ORYX.I18N.FromBPMN2Support.impBtn">Import</i18n:message>';
ORYX.I18N.FromBPMN2Support.impProgress = '<i18n:message key="ORYX.I18N.FromBPMN2Support.impProgress">Importing...</i18n:message>';
ORYX.I18N.FromBPMN2Support.close = '<i18n:message key="ORYX.I18N.FromBPMN2Support.close">Close</i18n:message>';

if(!ORYX.I18N.FromJSONSupport) ORYX.I18N.FromJSONSupport = {};
ORYX.I18N.FromJSONSupport.selectFile = '<i18n:message key="ORYX.I18N.FromJSONSupport.selectFile">Select an JSON file or type in the JSON to import it!</i18n:message>';
ORYX.I18N.FromJSONSupport.file = '<i18n:message key="ORYX.I18N.FromJSONSupport.file">File</i18n:message>';
ORYX.I18N.FromJSONSupport.impBPMN2 = '<i18n:message key="ORYX.I18N.FromJSONSupport.impBPMN2">Import JSON</i18n:message>';
ORYX.I18N.FromJSONSupport.impBtn = '<i18n:message key="ORYX.I18N.FromJSONSupport.impBtn">Import</i18n:message>';
ORYX.I18N.FromJSONSupport.impProgress = '<i18n:message key="ORYX.I18N.FromJSONSupport.impProgress">Importing...</i18n:message>';
ORYX.I18N.FromJSONSupport.close = '<i18n:message key="ORYX.I18N.FromJSONSupport.close">Close</i18n:message>';

if(!ORYX.I18N.Bpmn2Bpel) ORYX.I18N.Bpmn2Bpel = {};

ORYX.I18N.Bpmn2Bpel.group = '<i18n:message key="ORYX.I18N.Bpmn2Bpel.group">ExecBPMN</i18n:message>';
ORYX.I18N.Bpmn2Bpel.show = '<i18n:message key="ORYX.I18N.Bpmn2Bpel.show">Show transformed BPEL</i18n:message>';
ORYX.I18N.Bpmn2Bpel.download = '<i18n:message key="ORYX.I18N.Bpmn2Bpel.download">Download transformed BPEL</i18n:message>';
ORYX.I18N.Bpmn2Bpel.deploy = '<i18n:message key="ORYX.I18N.Bpmn2Bpel.deploy">Deploy transformed BPEL</i18n:message>';
ORYX.I18N.Bpmn2Bpel.showDesc = '<i18n:message key="ORYX.I18N.Bpmn2Bpel.showDesc">Transforms BPMN to BPEL and shows the result in a new window.</i18n:message>';
ORYX.I18N.Bpmn2Bpel.downloadDesc = '<i18n:message key="ORYX.I18N.Bpmn2Bpel.downloadDesc">Transforms BPMN to BPEL and offers to download the result.</i18n:message>';
ORYX.I18N.Bpmn2Bpel.deployDesc = '<i18n:message key="ORYX.I18N.Bpmn2Bpel.deployDesc">Transforms BPMN to BPEL and deploys the business process on the BPEL-Engine Apache ODE</i18n:message>';
ORYX.I18N.Bpmn2Bpel.transfFailed = '<i18n:message key="ORYX.I18N.Bpmn2Bpel.transfFailed">Request for transformation to BPEL failed.</i18n:message>';
ORYX.I18N.Bpmn2Bpel.ApacheOdeUrlInputTitle = '<i18n:message key="ORYX.I18N.Bpmn2Bpel.ApacheOdeUrlInputTitle">Apache ODE URL</i18n:message>';
ORYX.I18N.Bpmn2Bpel.ApacheOdeUrlInputLabelDeploy = '<i18n:message key="ORYX.I18N.Bpmn2Bpel.ApacheOdeUrlInputLabelDeploy">Deploy Process</i18n:message>';
ORYX.I18N.Bpmn2Bpel.ApacheOdeUrlInputLabelCancel = '<i18n:message key="ORYX.I18N.Bpmn2Bpel.ApacheOdeUrlInputLabelCancel">Cancel</i18n:message>';
ORYX.I18N.Bpmn2Bpel.ApacheOdeUrlInputPanelText = '<i18n:message key="ORYX.I18N.Bpmn2Bpel.ApacheOdeUrlInputPanelText">Please type-in the URL to the Apache ODE BPEL-Engine. E.g.: http://myserver:8080/ode</i18n:message>';


if(!ORYX.I18N.Save) ORYX.I18N.Save = {};

ORYX.I18N.Save.group = '<i18n:message key="ORYX.I18N.Save.group">File</i18n:message>';
ORYX.I18N.Save.save = '<i18n:message key="ORYX.I18N.Save.save">Save</i18n:message>';
ORYX.I18N.Save.autosave = '<i18n:message key="ORYX.I18N.Save.autosave">Autosave</i18n:message>';
ORYX.I18N.Save.saveDesc = '<i18n:message key="ORYX.I18N.Save.saveDesc">Save</i18n:message>';
ORYX.I18N.Save.autosaveDesc='<i18n:message key="ORYX.I18N.Save.autosaveDesc">Autosave</i18n:message>';
ORYX.I18N.Save.autosaveDesc_on = '<i18n:message key="ORYX.I18N.Save.autosaveDesc_on">Autosave (on)</i18n:message>';
ORYX.I18N.Save.autosaveDesc_off = '<i18n:message key="ORYX.I18N.Save.autosaveDesc_off">Autosave (off)</i18n:message>';
ORYX.I18N.Save.saveAs = '<i18n:message key="ORYX.I18N.Save.saveAs">Save As...</i18n:message>';
ORYX.I18N.Save.saveAsDesc = '<i18n:message key="ORYX.I18N.Save.saveAsDesc">Save As...</i18n:message>';
ORYX.I18N.Save.unsavedData = '<i18n:message key="ORYX.I18N.Save.unsavedData">There are unsaved data, please save before you leave, otherwise your changes get lost!</i18n:message>';
ORYX.I18N.Save.newProcess = '<i18n:message key="ORYX.I18N.Save.newProcess">New Process</i18n:message>';
ORYX.I18N.Save.saveAsTitle = '<i18n:message key="ORYX.I18N.Save.saveAsTitle">Save as...</i18n:message>';
ORYX.I18N.Save.saveBtn = '<i18n:message key="ORYX.I18N.Save.saveBtn">Save</i18n:message>';
ORYX.I18N.Save.close = '<i18n:message key="ORYX.I18N.Save.close">Close</i18n:message>';
ORYX.I18N.Save.savedAs = '<i18n:message key="ORYX.I18N.Save.savedAs">Saved As</i18n:message>';
ORYX.I18N.Save.saved = '<i18n:message key="ORYX.I18N.Save.saved">Saved!</i18n:message>';
ORYX.I18N.Save.failed = '<i18n:message key="ORYX.I18N.Save.failed">Saving failed.</i18n:message>';
ORYX.I18N.Save.noRights = '<i18n:message key="ORYX.I18N.Save.noRights">You have no rights to save changes.</i18n:message>';
ORYX.I18N.Save.saving = '<i18n:message key="ORYX.I18N.Save.saving">Saving</i18n:message>';
ORYX.I18N.Save.saveAsHint = '<i18n:message key="ORYX.I18N.Save.saveAsHint">The process diagram is stored under:</i18n:message>';

if(!ORYX.I18N.File) ORYX.I18N.File = {};

ORYX.I18N.File.group = '<i18n:message key="ORYX.I18N.File.group">File</i18n:message>';
ORYX.I18N.File.print = '<i18n:message key="ORYX.I18N.File.print">Print</i18n:message>';
ORYX.I18N.File.printDesc = '<i18n:message key="ORYX.I18N.File.printDesc">Print current model</i18n:message>';
ORYX.I18N.File.pdf = '<i18n:message key="ORYX.I18N.File.pdf">Export as PDF</i18n:message>';
ORYX.I18N.File.pdfDesc = '<i18n:message key="ORYX.I18N.File.pdfDesc">Export as PDF</i18n:message>';
ORYX.I18N.File.info = '<i18n:message key="ORYX.I18N.File.info">Info</i18n:message>';
ORYX.I18N.File.infoDesc = '<i18n:message key="ORYX.I18N.File.infoDesc">Info</i18n:message>';
ORYX.I18N.File.genPDF = '<i18n:message key="ORYX.I18N.File.genPDF">Generating PDF</i18n:message>';
ORYX.I18N.File.genPDFFailed = '<i18n:message key="ORYX.I18N.File.genPDFFailed">Generating PDF failed.</i18n:message>';
ORYX.I18N.File.printTitle = '<i18n:message key="ORYX.I18N.File.printTitle">Print</i18n:message>';
ORYX.I18N.File.printMsg = '<i18n:message key="ORYX.I18N.File.printMsg">We are currently experiencing problems with the printing function. We recommend using the PDF Export to print the diagram. Do you really want to continue printing?</i18n:message>';

if(!ORYX.I18N.Grouping) ORYX.I18N.Grouping = {};

ORYX.I18N.Grouping.grouping = '<i18n:message key="ORYX.I18N.Grouping.grouping">Grouping</i18n:message>';
ORYX.I18N.Grouping.group = '<i18n:message key="ORYX.I18N.Grouping.group">Group</i18n:message>';
ORYX.I18N.Grouping.groupDesc = '<i18n:message key="ORYX.I18N.Grouping.groupDesc">Groups all selected shapes</i18n:message>';
ORYX.I18N.Grouping.ungroup = '<i18n:message key="ORYX.I18N.Grouping.ungroup">Ungroup</i18n:message>';
ORYX.I18N.Grouping.ungroupDesc = '<i18n:message key="ORYX.I18N.Grouping.ungroupDesc">Deletes the group of all selected Shapes</i18n:message>';

if(!ORYX.I18N.IBPMN2BPMN) ORYX.I18N.IBPMN2BPMN = {};

ORYX.I18N.IBPMN2BPMN.group = '<i18n:message key="ORYX.I18N.IBPMN2BPMN.group">Export</i18n:message>';
ORYX.I18N.IBPMN2BPMN.name = '<i18n:message key="ORYX.I18N.IBPMN2BPMN.name">IBPMN 2 BPMN Mapping</i18n:message>';
ORYX.I18N.IBPMN2BPMN.desc = '<i18n:message key="ORYX.I18N.IBPMN2BPMN.desc">Convert IBPMN to BPMN</i18n:message>';

if(!ORYX.I18N.Loading) ORYX.I18N.Loading = {};

ORYX.I18N.Loading.waiting = '<i18n:message key="ORYX.I18N.Loading.waiting">Please wait...</i18n:message>';

if(!ORYX.I18N.Pnmlexport) ORYX.I18N.Pnmlexport = {};

ORYX.I18N.Pnmlexport.group = '<i18n:message key="ORYX.I18N.Pnmlexport.group">Export</i18n:message>';
ORYX.I18N.Pnmlexport.name = '<i18n:message key="ORYX.I18N.Pnmlexport.name">BPMN to PNML</i18n:message>';
ORYX.I18N.Pnmlexport.desc = '<i18n:message key="ORYX.I18N.Pnmlexport.desc">Export as executable PNML and deploy</i18n:message>';

if(!ORYX.I18N.PropertyWindow) ORYX.I18N.PropertyWindow = {};

ORYX.I18N.PropertyWindow.name = '<i18n:message key="ORYX.I18N.PropertyWindow.name">Name</i18n:message>';
ORYX.I18N.PropertyWindow.value = '<i18n:message key="ORYX.I18N.PropertyWindow.value">Value</i18n:message>';
ORYX.I18N.PropertyWindow.selected = '<i18n:message key="ORYX.I18N.PropertyWindow.selected">selected</i18n:message>';
ORYX.I18N.PropertyWindow.clickIcon = '<i18n:message key="ORYX.I18N.PropertyWindow.clickIcon">Click Icon</i18n:message>';
ORYX.I18N.PropertyWindow.add = '<i18n:message key="ORYX.I18N.PropertyWindow.add">Add</i18n:message>';
ORYX.I18N.PropertyWindow.rem = '<i18n:message key="ORYX.I18N.PropertyWindow.rem">Remove</i18n:message>';
ORYX.I18N.PropertyWindow.complex = '<i18n:message key="ORYX.I18N.PropertyWindow.complex">Editor for a Complex Type</i18n:message>';
ORYX.I18N.PropertyWindow.text = '<i18n:message key="ORYX.I18N.PropertyWindow.text">Editor for a Text Type</i18n:message>';
ORYX.I18N.PropertyWindow.ok = '<i18n:message key="ORYX.I18N.PropertyWindow.ok">Ok</i18n:message>';
ORYX.I18N.PropertyWindow.cancel = '<i18n:message key="ORYX.I18N.PropertyWindow.cancel">Cancel</i18n:message>';
ORYX.I18N.PropertyWindow.dateFormat = '<i18n:message key="ORYX.I18N.PropertyWindow.dateFormat">m/d/y</i18n:message>';

if (!ORYX.I18N.ConditionExpressionEditorField) ORYX.I18N.ConditionExpressionEditorField = {};

ORYX.I18N.ConditionExpressionEditorField.simpleTitle = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.simpleTitle">Expression Editor - Press [Ctrl-Z] to activate auto-completion</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.sequenceFlowTitle = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.sequenceFlowTitle">Sequence Flow Conditions</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.sequenceFlowFullTitle = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.sequenceFlowFullTitle">Sequence Flow Conditions - Press [Ctrl-Z] to activate auto-completion</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.scriptTab = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.scriptTab">Script</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.editorTab = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.editorTab">Editor</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.editorDescription = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.editorDescription">Run sequence flow if the following conditions are met.</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.processVariable = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.processVariable">Process variable:</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.condition = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.condition">Condition:</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.between = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.between">between</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.contains = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.contains">contains</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.endsWith = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.endsWith">ends with</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.equalsTo = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.equalsTo">is equal to</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.greaterThan = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.greaterThan">is greater than</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.greaterThanOrEqual = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.greaterThanOrEqual">is greater than or equal to</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.isEmpty = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.isEmpty">is empty</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.isFalse = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.isFalse">is false</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.isNull = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.isNull">is null</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.isTrue = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.isTrue">is true</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.lessThan = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.lessThan">is less than</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.lessThanOrEqual = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.lessThanOrEqual">is less than or equal to</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.startsWith = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.startsWith">starts with</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.paramsError = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.paramsError">Unable to generate Script expression, please fill correctly the form params.</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.saveError = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.saveError">Unable to save property value, please check the value and try again.</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.scriptParseError = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.scriptParseError">Error found parsing script: <br/>{0}<br/><br/>Press OK to go to the Expression Editor screen and loose the current Script or Cancel to go back to the Script Editor.</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.scriptGenerationError = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.scriptGenerationError">Error found generating script: <br/>{0}<br/><br/>Please check the data entered on the Expression Editor.</i18n:message>';
ORYX.I18N.ConditionExpressionEditorField.nonExistingVariable = '<i18n:message key="ORYX.I18N.ConditionExpressionEditorField.nonExistingVariable">The process does not contain any variable called \"{0}\".</i18n:message>';

if(!ORYX.I18N.ShapeMenuPlugin) ORYX.I18N.ShapeMenuPlugin = {};

ORYX.I18N.ShapeMenuPlugin.drag = '<i18n:message key="ORYX.I18N.ShapeMenuPlugin.drag">Drag</i18n:message>';
ORYX.I18N.ShapeMenuPlugin.clickDrag = '<i18n:message key="ORYX.I18N.ShapeMenuPlugin.clickDrag">Click or drag</i18n:message>';
ORYX.I18N.ShapeMenuPlugin.morphMsg = '<i18n:message key="ORYX.I18N.ShapeMenuPlugin.morphMsg">Morph shape</i18n:message>';

if(!ORYX.I18N.SimplePnmlexport) ORYX.I18N.SimplePnmlexport = {};

ORYX.I18N.SimplePnmlexport.group = '<i18n:message key="ORYX.I18N.SimplePnmlexport.group">Export</i18n:message>';
ORYX.I18N.SimplePnmlexport.name = '<i18n:message key="ORYX.I18N.SimplePnmlexport.name">Export to PNML</i18n:message>';
ORYX.I18N.SimplePnmlexport.desc = '<i18n:message key="ORYX.I18N.SimplePnmlexport.desc">Export to PNML</i18n:message>';

if(!ORYX.I18N.StepThroughPlugin) ORYX.I18N.StepThroughPlugin = {};

ORYX.I18N.StepThroughPlugin.group = '<i18n:message key="ORYX.I18N.StepThroughPlugin.group">Step Through</i18n:message>';
ORYX.I18N.StepThroughPlugin.stepThrough = '<i18n:message key="ORYX.I18N.StepThroughPlugin.stepThrough">Step Through</i18n:message>';
ORYX.I18N.StepThroughPlugin.stepThroughDesc = '<i18n:message key="ORYX.I18N.StepThroughPlugin.stepThroughDesc">Step through your model</i18n:message>';
ORYX.I18N.StepThroughPlugin.undo = '<i18n:message key="ORYX.I18N.StepThroughPlugin.undo">Undo</i18n:message>';
ORYX.I18N.StepThroughPlugin.undoDesc = '<i18n:message key="ORYX.I18N.StepThroughPlugin.undoDesc">Undo one Step</i18n:message>';
ORYX.I18N.StepThroughPlugin.error = '<i18n:message key="ORYX.I18N.StepThroughPlugin.error">Can\'t step through this diagram.</i18n:message>';
ORYX.I18N.StepThroughPlugin.executing = '<i18n:message key="ORYX.I18N.StepThroughPlugin.executing">Executing</i18n:message>';

if(!ORYX.I18N.SyntaxChecker) ORYX.I18N.SyntaxChecker = {};

ORYX.I18N.SyntaxChecker.group = '<i18n:message key="ORYX.I18N.SyntaxChecker.group">Verification</i18n:message>';
ORYX.I18N.SyntaxChecker.name = '<i18n:message key="ORYX.I18N.SyntaxChecker.name">Validate Process</i18n:message>';
ORYX.I18N.SyntaxChecker.desc = '<i18n:message key="ORYX.I18N.SyntaxChecker.desc">Validate Process</i18n:message>';
ORYX.I18N.SyntaxChecker.noErrors = '<i18n:message key="ORYX.I18N.SyntaxChecker.noErrors">There are no validation errors.</i18n:message>';
ORYX.I18N.SyntaxChecker.hasErrors = '<i18n:message key="ORYX.I18N.SyntaxChecker.hasErrors">Validation error(s) found.</i18n:message>';
ORYX.I18N.SyntaxChecker.invalid = '<i18n:message key="ORYX.I18N.SyntaxChecker.invalid">Invalid answer from server.</i18n:message>';
ORYX.I18N.SyntaxChecker.checkingMessage = '<i18n:message key="ORYX.I18N.SyntaxChecker.checkingMessage">Validating ...</i18n:message>';

if(!ORYX.I18N.Undo) ORYX.I18N.Undo = {};

ORYX.I18N.Undo.group = '<i18n:message key="ORYX.I18N.Undo.group">Undo</i18n:message>';
ORYX.I18N.Undo.undo = '<i18n:message key="ORYX.I18N.Undo.undo">Undo</i18n:message>';
ORYX.I18N.Undo.undoDesc = '<i18n:message key="ORYX.I18N.Undo.undoDesc">Undo the last action</i18n:message>';
ORYX.I18N.Undo.redo = '<i18n:message key="ORYX.I18N.Undo.redo">Redo</i18n:message>';
ORYX.I18N.Undo.redoDesc = '<i18n:message key="ORYX.I18N.Undo.redoDesc">Redo the last undone action</i18n:message>';

if(!ORYX.I18N.Validator) ORYX.I18N.Validator = {};
ORYX.I18N.Validator.checking = '<i18n:message key="ORYX.I18N.Validator.checking">Checking</i18n:message>';

if(!ORYX.I18N.View) ORYX.I18N.View = {};

ORYX.I18N.View.group = '<i18n:message key="ORYX.I18N.View.group">Zoom</i18n:message>';
ORYX.I18N.View.zoomIn = '<i18n:message key="ORYX.I18N.View.zoomIn">Zoom In</i18n:message>';
ORYX.I18N.View.zoomInDesc = '<i18n:message key="ORYX.I18N.View.zoomInDesc">Zoom into the model</i18n:message>';
ORYX.I18N.View.zoomOut = '<i18n:message key="ORYX.I18N.View.zoomOut">Zoom Out</i18n:message>';
ORYX.I18N.View.zoomOutDesc = '<i18n:message key="ORYX.I18N.View.zoomOutDesc">Zoom out of the model</i18n:message>';
ORYX.I18N.View.zoomStandard = '<i18n:message key="ORYX.I18N.View.zoomStandard">Zoom Standard</i18n:message>';
ORYX.I18N.View.zoomStandardDesc = '<i18n:message key="ORYX.I18N.View.zoomStandardDesc">Zoom to the standard level</i18n:message>';
ORYX.I18N.View.zoomFitToModel = '<i18n:message key="ORYX.I18N.View.zoomFitToModel">Zoom fit to model</i18n:message>';
ORYX.I18N.View.zoomFitToModelDesc = '<i18n:message key="ORYX.I18N.View.zoomFitToModelDesc">Zoom to fit the model size</i18n:message>';
ORYX.I18N.View.showInPopout = '<i18n:message key="ORYX.I18N.View.showInPopout">Popout</i18n:message>';
ORYX.I18N.View.showInPopoutDesc = '<i18n:message key="ORYX.I18N.View.showInPopoutDesc">Show in pop out window</i18n:message>';
ORYX.I18N.View.convertToPDF = '<i18n:message key="ORYX.I18N.View.convertToPDF">PDF</i18n:message>';
ORYX.I18N.View.convertToPDFDesc = '<i18n:message key="ORYX.I18N.View.convertToPDFDesc">Convert to PDF</i18n:message>';
ORYX.I18N.View.convertToPNG = '<i18n:message key="ORYX.I18N.View.convertToPNG">PNG</i18n:message>';
ORYX.I18N.View.convertToPNGDesc = '<i18n:message key="ORYX.I18N.View.convertToPNGDesc">Convert to PNG</i18n:message>';
ORYX.I18N.View.generateTaskForms = '<i18n:message key="ORYX.I18N.View.generateTaskForms">Generate Task Form Templates</i18n:message>';
ORYX.I18N.View.editProcessForm = '<i18n:message key="ORYX.I18N.View.editProcessForm">Edit Process Form</i18n:message>';
ORYX.I18N.View.editTaskForm = '<i18n:message key="ORYX.I18N.View.editTaskForm">Edit Task Form</i18n:message>';
ORYX.I18N.View.generateTaskFormsDesc = '<i18n:message key="ORYX.I18N.View.generateTaskFormsDesc">Generate Task Form Templates</i18n:message>';
ORYX.I18N.View.editProcessFormDesc = '<i18n:message key="ORYX.I18N.View.editProcessFormDesc">Edit Process Form</i18n:message>';
ORYX.I18N.View.editTaskFormDesc = '<i18n:message key="ORYX.I18N.View.editTaskFormDesc">Edit Task Form</i18n:message>';
ORYX.I18N.View.showInfo = '<i18n:message key="ORYX.I18N.View.showInfo">Info</i18n:message>';
ORYX.I18N.View.showInfoDesc = '<i18n:message key="ORYX.I18N.View.showInfoDesc">Info</i18n:message>';
ORYX.I18N.View.jbpmgroup = '<i18n:message key="ORYX.I18N.View.jbpmgroup">jBPM</i18n:message>';
ORYX.I18N.View.migratejPDL = '<i18n:message key="ORYX.I18N.View.migratejPDL">Migrate jPDL 3.2 to BPMN2</i18n:message>';
ORYX.I18N.View.migratejPDLDesc = '<i18n:message key="ORYX.I18N.View.migratejPDLDesc">Migrate jPDL 3.2 to BPMN2</i18n:message>';
ORYX.I18N.View.viewDiff = '<i18n:message key="ORYX.I18N.View.viewDiff">View diff</i18n:message>';
ORYX.I18N.View.viewDiffDesc = '<i18n:message key="ORYX.I18N.View.viewDiffDesc">View diff between different versions of the process</i18n:message>';
ORYX.I18N.View.viewDiffLoadingVersions = '<i18n:message key="ORYX.I18N.View.viewDiffLoadingVersions">Loading process versions...</i18n:message>';
ORYX.I18N.View.connectServiceRepo = '<i18n:message key="ORYX.I18N.View.connectServiceRepo">Connect to jBPM service repository</i18n:message>';
ORYX.I18N.View.connectServiceRepoDesc = '<i18n:message key="ORYX.I18N.View.connectServiceRepoDesc">Connect to a Service Repository</i18n:message>';
ORYX.I18N.View.connectServiceRepoDataTitle = '<i18n:message key="ORYX.I18N.View.connectServiceRepoDataTitle">Service Repository Connection</i18n:message>';
ORYX.I18N.View.connectServiceRepoConnecting = '<i18n:message key="ORYX.I18N.View.connectServiceRepoConnecting">Connecting to a Service Repository...</i18n:message>';
ORYX.I18N.View.installingRepoItem = '<i18n:message key="ORYX.I18N.View.installingRepoItem">Instaling assets from the Service Repository...</i18n:message>';
ORYX.I18N.View.shareProcess = '<i18n:message key="ORYX.I18N.View.shareProcess">Share your process</i18n:message>';
ORYX.I18N.View.shareProcessDesc = '<i18n:message key="ORYX.I18N.View.shareProcessDesc">Share your process</i18n:message>';
ORYX.I18N.View.infogroup = '<i18n:message key="ORYX.I18N.View.infogroup">info</i18n:message>';

if(!ORYX.I18N.View.tabs) ORYX.I18N.View.tabs = {};
ORYX.I18N.View.tabs.modelling = '<i18n:message key="ORYX.I18N.View.tabs.modelling">Process Modelling</i18n:message>';
ORYX.I18N.View.tabs.simResults = '<i18n:message key="ORYX.I18N.View.tabs.simResults">Simulation Results</i18n:message>';

if(!ORYX.I18N.View.sim) ORYX.I18N.View.sim = {};
ORYX.I18N.View.sim.processPaths = '<i18n:message key="ORYX.I18N.View.sim.processPaths">Display Process Paths</i18n:message>';
ORYX.I18N.View.sim.runSim = '<i18n:message key="ORYX.I18N.View.sim.runSim">Run Process Simulation</i18n:message>';
ORYX.I18N.View.sim.calculatingPaths = '<i18n:message key="ORYX.I18N.View.sim.calculatingPaths">Calculating process paths.</i18n:message>';
ORYX.I18N.View.sim.dispColor = '<i18n:message key="ORYX.I18N.View.sim.dispColor">Display Color</i18n:message>';
ORYX.I18N.View.sim.numElements = '<i18n:message key="ORYX.I18N.View.sim.numElements">Number of Elements</i18n:message>';
ORYX.I18N.View.sim.processPathsTitle = '<i18n:message key="ORYX.I18N.View.sim.processPathsTitle">Process Paths</i18n:message>';
ORYX.I18N.View.sim.subProcessPathsTitle = '<i18n:message key="ORYX.I18N.View.sim.subProcessPathsTitle">Subprocess Paths</i18n:message>';
ORYX.I18N.View.sim.select = '<i18n:message key="ORYX.I18N.View.sim.select">Select </i18n:message>';
ORYX.I18N.View.sim.display = '<i18n:message key="ORYX.I18N.View.sim.display"> and click Show Path to display it.</i18n:message>';
ORYX.I18N.View.sim.showPath = '<i18n:message key="ORYX.I18N.View.sim.showPath">Show Path</i18n:message>';
ORYX.I18N.View.sim.selectPath = '<i18n:message key="ORYX.I18N.View.sim.selectPath">Please select a process path.</i18n:message>';
ORYX.I18N.View.sim.numInstances = '<i18n:message key="ORYX.I18N.View.sim.numInstances">Number of instances</i18n:message>';
ORYX.I18N.View.sim.interval = '<i18n:message key="ORYX.I18N.View.sim.interval">Interval</i18n:message>';
ORYX.I18N.View.sim.intervalUnits = '<i18n:message key="ORYX.I18N.View.sim.intervalUnits">Interval units</i18n:message>';
ORYX.I18N.View.sim.runSim = '<i18n:message key="ORYX.I18N.View.sim.runSim">Run Process Simulation</i18n:message>';
ORYX.I18N.View.sim.runningSim = '<i18n:message key="ORYX.I18N.View.sim.runningSim">Running Process Simulation...</i18n:message>';
ORYX.I18N.View.sim.simNoResults = '<i18n:message key="ORYX.I18N.View.sim.simNoResults">Simulation engine did not return results: </i18n:message>';
ORYX.I18N.View.sim.unableToPerform = '<i18n:message key="ORYX.I18N.View.sim.unableToPerform">Unable to perform simulation:</i18n:message>';
ORYX.I18N.View.sim.resultsInfo = '<i18n:message key="ORYX.I18N.View.sim.resultsInfo">Simulation Info</i18n:message>';
ORYX.I18N.View.sim.resultsGraphs = '<i18n:message key="ORYX.I18N.View.sim.resultsGraphs">Simulation Graphs</i18n:message>';
ORYX.I18N.View.sim.resultsProcessId = '<i18n:message key="ORYX.I18N.View.sim.resultsProcessId">Process id: </i18n:message>';
ORYX.I18N.View.sim.resultsProcessName = '<i18n:message key="ORYX.I18N.View.sim.resultsProcessName">Process name: </i18n:message>';
ORYX.I18N.View.sim.resultsProcessVersion = '<i18n:message key="ORYX.I18N.View.sim.resultsProcessVersion">Process version: </i18n:message>';
ORYX.I18N.View.sim.resultsSimStartTime = '<i18n:message key="ORYX.I18N.View.sim.resultsSimStartTime">Simulation start: </i18n:message>';
ORYX.I18N.View.sim.resultsSimEndTime = '<i18n:message key="ORYX.I18N.View.sim.resultsSimEndTime">Simulation end: </i18n:message>';
ORYX.I18N.View.sim.resultsNumOfExecutions = '<i18n:message key="ORYX.I18N.View.sim.resultsNumOfExecutions">Num. of Executions: </i18n:message>';
ORYX.I18N.View.sim.resultsInterval = '<i18n:message key="ORYX.I18N.View.sim.resultsInterval">Interval </i18n:message>';
ORYX.I18N.View.sim.resultsGroupProcess = '<i18n:message key="ORYX.I18N.View.sim.resultsGroupProcess">Process</i18n:message>';
ORYX.I18N.View.sim.resultsGroupProcessElements = '<i18n:message key="ORYX.I18N.View.sim.resultsGroupProcessElements">Process Elements</i18n:message>';
ORYX.I18N.View.sim.resultsGroupProcessPaths = '<i18n:message key="ORYX.I18N.View.sim.resultsGroupProcessPaths">Paths</i18n:message>';
ORYX.I18N.View.sim.resultsTitlesProcessSimResults = '<i18n:message key="ORYX.I18N.View.sim.resultsTitlesProcessSimResults">Process Simulation Results</i18n:message>';
ORYX.I18N.View.sim.resultsTitlesTaskSimResults = '<i18n:message key="ORYX.I18N.View.sim.resultsTitlesTaskSimResults">Task Simulation Results</i18n:message>';
ORYX.I18N.View.sim.resultsTitlesHumanTaskSimResults = '<i18n:message key="ORYX.I18N.View.sim.resultsTitlesHumanTaskSimResults">Human Task Simulation Results</i18n:message>';
ORYX.I18N.View.sim.resultsTitlesPathExecutionInfo = '<i18n:message key="ORYX.I18N.View.sim.resultsTitlesPathExecutionInfo">Path Execution Info</i18n:message>';
ORYX.I18N.View.sim.chartsExecutionTimes = '<i18n:message key="ORYX.I18N.View.sim.chartsExecutionTimes">Execution Times</i18n:message>';
ORYX.I18N.View.sim.chartsActivityInstances = '<i18n:message key="ORYX.I18N.View.sim.chartsActivityInstances">Activity Instances</i18n:message>';
ORYX.I18N.View.sim.chartsTotalCost = '<i18n:message key="ORYX.I18N.View.sim.chartsTotalCost">Total Cost</i18n:message>';
ORYX.I18N.View.sim.chartsTotalResourceUtilization = '<i18n:message key="ORYX.I18N.View.sim.chartsTotalResourceUtilization">Total Resource Utilization</i18n:message>';
ORYX.I18N.View.sim.chartsResourceUtilization = '<i18n:message key="ORYX.I18N.View.sim.chartsResourceUtilization">Resource Utilization</i18n:message>';
ORYX.I18N.View.sim.chartsResourceCost = '<i18n:message key="ORYX.I18N.View.sim.chartsResourceCost">Resource Cost</i18n:message>';
ORYX.I18N.View.sim.chartsPathImage = '<i18n:message key="ORYX.I18N.View.sim.chartsPathImage">Path Image</i18n:message>';
ORYX.I18N.View.sim.chartsPathInstanceExecution = '<i18n:message key="ORYX.I18N.View.sim.chartsPathInstanceExecution">Path Instance Execution</i18n:message>';

if(!ORYX.I18N.XFormsSerialization) ORYX.I18N.XFormsSerialization = {};

ORYX.I18N.XFormsSerialization.group = '<i18n:message key="ORYX.I18N.XFormsSerialization.group">XForms Serialization</i18n:message>';
ORYX.I18N.XFormsSerialization.exportXForms = '<i18n:message key="ORYX.I18N.XFormsSerialization.exportXForms">XForms Export</i18n:message>';
ORYX.I18N.XFormsSerialization.exportXFormsDesc = '<i18n:message key="ORYX.I18N.XFormsSerialization.exportXFormsDesc">Export XForms+XHTML markup</i18n:message>';
ORYX.I18N.XFormsSerialization.importXForms = '<i18n:message key="ORYX.I18N.XFormsSerialization.importXForms">XForms Import</i18n:message>';
ORYX.I18N.XFormsSerialization.importXFormsDesc = '<i18n:message key="ORYX.I18N.XFormsSerialization.importXFormsDesc">Import XForms+XHTML markup</i18n:message>';
ORYX.I18N.XFormsSerialization.noClientXFormsSupport = '<i18n:message key="ORYX.I18N.XFormsSerialization.noClientXFormsSupport">No XForms support</i18n:message>';
ORYX.I18N.XFormsSerialization.noClientXFormsSupportDesc = '<i18n:message key="ORYX.I18N.XFormsSerialization.noClientXFormsSupportDesc"><h2>Your browser does not support XForms. Please install the <a href=\"https://addons.mozilla.org/firefox/addon/824\" target=\"_blank\">Mozilla XForms Add-on</a> for Firefox.</h2></i18n:message>';
ORYX.I18N.XFormsSerialization.ok = '<i18n:message key="ORYX.I18N.XFormsSerialization.ok">Ok</i18n:message>';
ORYX.I18N.XFormsSerialization.selectFile = '<i18n:message key="ORYX.I18N.XFormsSerialization.selectFile">Select a XHTML (.xhtml) file or type in the XForms+XHTML markup to import it!</i18n:message>';
ORYX.I18N.XFormsSerialization.selectCss = '<i18n:message key="ORYX.I18N.XFormsSerialization.selectCss">Please insert url of css file</i18n:message>';
ORYX.I18N.XFormsSerialization.file = '<i18n:message key="ORYX.I18N.XFormsSerialization.file">File</i18n:message>';
ORYX.I18N.XFormsSerialization.impFailed = '<i18n:message key="ORYX.I18N.XFormsSerialization.impFailed">Request for import of document failed.</i18n:message>';
ORYX.I18N.XFormsSerialization.impTitle = '<i18n:message key="ORYX.I18N.XFormsSerialization.impTitle">Import XForms+XHTML document</i18n:message>';
ORYX.I18N.XFormsSerialization.expTitle = '<i18n:message key="ORYX.I18N.XFormsSerialization.expTitle">Export XForms+XHTML document</i18n:message>';
ORYX.I18N.XFormsSerialization.impButton = '<i18n:message key="ORYX.I18N.XFormsSerialization.impButton">Import</i18n:message>';
ORYX.I18N.XFormsSerialization.impProgress = '<i18n:message key="ORYX.I18N.XFormsSerialization.impProgress">Importing...</i18n:message>';
ORYX.I18N.XFormsSerialization.close = '<i18n:message key="ORYX.I18N.XFormsSerialization.close">Close</i18n:message>';


if(!ORYX.I18N.TreeGraphSupport) ORYX.I18N.TreeGraphSupport = {};

ORYX.I18N.TreeGraphSupport.syntaxCheckName = '<i18n:message key="ORYX.I18N.TreeGraphSupport.syntaxCheckName">Syntax Check</i18n:message>';
ORYX.I18N.TreeGraphSupport.group = '<i18n:message key="ORYX.I18N.TreeGraphSupport.group">Tree Graph Support</i18n:message>';
ORYX.I18N.TreeGraphSupport.syntaxCheckDesc = '<i18n:message key="ORYX.I18N.TreeGraphSupport.syntaxCheckDesc">Check the syntax of an tree graph structure</i18n:message>';

if(!ORYX.I18N.QueryEvaluator) ORYX.I18N.QueryEvaluator = {};

ORYX.I18N.QueryEvaluator.name = '<i18n:message key="ORYX.I18N.QueryEvaluator.name">Query Evaluator</i18n:message>';
ORYX.I18N.QueryEvaluator.group = '<i18n:message key="ORYX.I18N.QueryEvaluator.group">Verification</i18n:message>';
ORYX.I18N.QueryEvaluator.desc = '<i18n:message key="ORYX.I18N.QueryEvaluator.desc">Evaluate query</i18n:message>';
ORYX.I18N.QueryEvaluator.noResult = '<i18n:message key="ORYX.I18N.QueryEvaluator.noResult">Query resulted in no match.</i18n:message>';
ORYX.I18N.QueryEvaluator.invalidResponse = '<i18n:message key="ORYX.I18N.QueryEvaluator.invalidResponse">Invalid answer from server.</i18n:message>';

// if(!ORYX.I18N.QueryResultHighlighter) ORYX.I18N.QueryResultHighlighter = {};
// 
// ORYX.I18N.QueryResultHighlighter.name = "Query Result Highlighter";

/** New Language Properties: 08.12.2008 */

ORYX.I18N.PropertyWindow.title = '<i18n:message key="ORYX.I18N.PropertyWindow.title">Properties</i18n:message>';

if(!ORYX.I18N.ShapeRepository) ORYX.I18N.ShapeRepository = {};
ORYX.I18N.ShapeRepository.title = '<i18n:message key="ORYX.I18N.ShapeRepository.title">Object Library</i18n:message>';

ORYX.I18N.Save.dialogDesciption = '<i18n:message key="ORYX.I18N.Save.dialogDesciption">Please enter a name, a description and a comment.</i18n:message>';
ORYX.I18N.Save.dialogLabelTitle = '<i18n:message key="ORYX.I18N.Save.dialogLabelTitle">Title</i18n:message>';
ORYX.I18N.Save.dialogLabelDesc = '<i18n:message key="ORYX.I18N.Save.dialogLabelDesc">Description</i18n:message>';
ORYX.I18N.Save.dialogLabelType = '<i18n:message key="ORYX.I18N.Save.dialogLabelType">Type</i18n:message>';
ORYX.I18N.Save.dialogLabelComment = '<i18n:message key="ORYX.I18N.Save.dialogLabelComment">Revision comment</i18n:message>';

ORYX.I18N.Validator.name = '<i18n:message key="ORYX.I18N.Validator.name">BPMN Validator</i18n:message>';
ORYX.I18N.Validator.description = '<i18n:message key="ORYX.I18N.Validator.description">Validation for BPMN</i18n:message>';

ORYX.I18N.SSExtensionLoader.labelImport = '<i18n:message key="ORYX.I18N.SSExtensionLoader.labelImport">Import</i18n:message>';
ORYX.I18N.SSExtensionLoader.labelCancel = '<i18n:message key="ORYX.I18N.SSExtensionLoader.labelCancel">Cancel</i18n:message>';

Ext.MessageBox.buttonText.yes = '<i18n:message key="Ext.MessageBox.buttonText.yes">Yes</i18n:message>';
Ext.MessageBox.buttonText.no = '<i18n:message key="Ext.MessageBox.buttonText.no">No</i18n:message>';
Ext.MessageBox.buttonText.cancel = '<i18n:message key="Ext.MessageBox.buttonText.cancel">Cancel</i18n:message>';
Ext.MessageBox.buttonText.ok = '<i18n:message key="Ext.MessageBox.buttonText.ok">OK</i18n:message>';


/** New Language Properties: 28.01.2009 */
if(!ORYX.I18N.BPMN2XPDL) ORYX.I18N.BPMN2XPDL = {};
ORYX.I18N.BPMN2XPDL.group = '<i18n:message key="ORYX.I18N.BPMN2XPDL.group">Export</i18n:message>';
ORYX.I18N.BPMN2XPDL.xpdlExport = '<i18n:message key="ORYX.I18N.BPMN2XPDL.xpdlExport">Export to XPDL</i18n:message>';
ORYX.I18N.BPMN2XPDL.xpdlImport = '<i18n:message key="ORYX.I18N.BPMN2XPDL.xpdlImport">Import from XPDL</i18n:message>';
ORYX.I18N.BPMN2XPDL.importGroup = '<i18n:message key="ORYX.I18N.BPMN2XPDL.importGroup">Import</i18n:message>';
ORYX.I18N.BPMN2XPDL.selectFile = '<i18n:message key="ORYX.I18N.BPMN2XPDL.selectFile">Select a XPDL (.xml) file or type in the XPDL to import it!</i18n:message>';
ORYX.I18N.BPMN2XPDL.file = '<i18n:message key="ORYX.I18N.BPMN2XPDL.file">File</i18n:message>';
ORYX.I18N.BPMN2XPDL.impXPDL = '<i18n:message key="ORYX.I18N.BPMN2XPDL.impXPDL">Import XPDL</i18n:message>';
ORYX.I18N.BPMN2XPDL.impBtn = '<i18n:message key="ORYX.I18N.BPMN2XPDL.impBtn">Import</i18n:message>';
ORYX.I18N.BPMN2XPDL.impProgress = '<i18n:message key="ORYX.I18N.BPMN2XPDL.impProgress">Importing...</i18n:message>';
ORYX.I18N.BPMN2XPDL.close = '<i18n:message key="ORYX.I18N.BPMN2XPDL.close">Close</i18n:message>';


/** Resource Perspective Additions: 24 March 2009 */
if(!ORYX.I18N.ResourcesSoDAdd) ORYX.I18N.ResourcesSoDAdd = {};

ORYX.I18N.ResourcesSoDAdd.name = '<i18n:message key="ORYX.I18N.ResourcesSoDAdd.name">Define Separation of Duties Contraint</i18n:message>';
ORYX.I18N.ResourcesSoDAdd.group = '<i18n:message key="ORYX.I18N.ResourcesSoDAdd.group">Resource Perspective</i18n:message>';
ORYX.I18N.ResourcesSoDAdd.desc = '<i18n:message key="ORYX.I18N.ResourcesSoDAdd.desc">Define a Separation of Duties constraint for the selected tasks</i18n:message>';

if(!ORYX.I18N.ResourcesSoDShow) ORYX.I18N.ResourcesSoDShow = {};

ORYX.I18N.ResourcesSoDShow.name = '<i18n:message key="ORYX.I18N.ResourcesSoDShow.name">Show Separation of Duties Constraints</i18n:message>';
ORYX.I18N.ResourcesSoDShow.group = '<i18n:message key="ORYX.I18N.ResourcesSoDShow.group">Resource Perspective</i18n:message>';
ORYX.I18N.ResourcesSoDShow.desc = '<i18n:message key="ORYX.I18N.ResourcesSoDShow.desc">Show Separation of Duties constraints of the selected task</i18n:message>';

if(!ORYX.I18N.ResourcesBoDAdd) ORYX.I18N.ResourcesBoDAdd = {};

ORYX.I18N.ResourcesBoDAdd.name = '<i18n:message key="ORYX.I18N.ResourcesBoDAdd.name">Define Binding of Duties Constraint</i18n:message>';
ORYX.I18N.ResourcesBoDAdd.group = '<i18n:message key="ORYX.I18N.ResourcesBoDAdd.group">Resource Perspective</i18n:message>';
ORYX.I18N.ResourcesBoDAdd.desc = '<i18n:message key="ORYX.I18N.ResourcesBoDAdd.desc">Define a Binding of Duties Constraint for the selected tasks</i18n:message>';

if(!ORYX.I18N.ResourcesBoDShow) ORYX.I18N.ResourcesBoDShow = {};

ORYX.I18N.ResourcesBoDShow.name = '<i18n:message key="ORYX.I18N.ResourcesBoDShow.name">Show Binding of Duties Constraints</i18n:message>';
ORYX.I18N.ResourcesBoDShow.group = '<i18n:message key="ORYX.I18N.ResourcesBoDShow.group">Resource Perspective</i18n:message>';
ORYX.I18N.ResourcesBoDShow.desc = '<i18n:message key="ORYX.I18N.ResourcesBoDShow.desc">Show Binding of Duties constraints of the selected task</i18n:message>';

if(!ORYX.I18N.ResourceAssignment) ORYX.I18N.ResourceAssignment = {};

ORYX.I18N.ResourceAssignment.name = '<i18n:message key="ORYX.I18N.ResourceAssignment.name">Resource Assignment</i18n:message>';
ORYX.I18N.ResourceAssignment.group = '<i18n:message key="ORYX.I18N.ResourceAssignment.group">Resource Perspective</i18n:message>';
ORYX.I18N.ResourceAssignment.desc = '<i18n:message key="ORYX.I18N.ResourceAssignment.desc">Assign resources to the selected task(s)</i18n:message>';

if(!ORYX.I18N.ClearSodBodHighlights) ORYX.I18N.ClearSodBodHighlights = {};

ORYX.I18N.ClearSodBodHighlights.name = '<i18n:message key="ORYX.I18N.ClearSodBodHighlights.name">Clear Highlights and Overlays</i18n:message>';
ORYX.I18N.ClearSodBodHighlights.group = '<i18n:message key="ORYX.I18N.ClearSodBodHighlights.group">Resource Perspective</i18n:message>';
ORYX.I18N.ClearSodBodHighlights.desc = '<i18n:message key="ORYX.I18N.ClearSodBodHighlights.desc">Remove all Separation and Binding of Duties Highlights/ Overlays</i18n:message>';


if(!ORYX.I18N.Perspective) ORYX.I18N.Perspective = {};
ORYX.I18N.Perspective.no = '<i18n:message key="ORYX.I18N.Perspective.no">No Perspective</i18n:message>';
ORYX.I18N.Perspective.noTip = '<i18n:message key="ORYX.I18N.Perspective.noTip">Unload the current perspective</i18n:message>';


/** New Language Properties: 21.04.2009 */
ORYX.I18N.JSONSupport = {
    imp: {
        name: '<i18n:message key="ORYX.I18N.JSONSupport_imp_name">Import from JSON</i18n:message>',
        desc: '<i18n:message key="ORYX.I18N.JSONSupport_imp_desc">Imports a model from JSON</i18n:message>',
        group: '<i18n:message key="ORYX.I18N.JSONSupport_imp_group">Export</i18n:message>',
        selectFile: '<i18n:message key="ORYX.I18N.JSONSupport_imp_selectFile">Select an JSON (.json) file or type in JSON to import it!</i18n:message>',
        file: '<i18n:message key="ORYX.I18N.JSONSupport_imp_file">File</i18n:message>',
        btnImp: '<i18n:message key="ORYX.I18N.JSONSupport_imp_btnImp">Import</i18n:message>',
        btnClose: '<i18n:message key="ORYX.I18N.JSONSupport_imp_btnClose">Close</i18n:message>',
        progress: '<i18n:message key="ORYX.I18N.JSONSupport_imp_progress">Importing ...</i18n:message>',
        syntaxError: '<i18n:message key="ORYX.I18N.JSONSupport_imp_syntaxError">Syntax error</i18n:message>'
    },
    exp: {
        name: '<i18n:message key="ORYX.I18N.JSONSupport_exp_name">Export to JSON</i18n:message>',
        desc: '<i18n:message key="ORYX.I18N.JSONSupport_exp_desc">Exports current model to JSON</i18n:message>',
        group: '<i18n:message key="ORYX.I18N.JSONSupport_exp_group">Export</i18n:message>'
    }
};

ORYX.I18N.TBPMSupport = {
		imp: {
        name: '<i18n:message key="ORYX.I18N.TBPMSupport_name">Import from PNG/JPEG</i18n:message>',
        desc: '<i18n:message key="ORYX.I18N.TBPMSupport_desc">Imports a model from a TPBM photo</i18n:message>',
        group: '<i18n:message key="ORYX.I18N.TBPMSupport_group">Export</i18n:message>',
        selectFile: '<i18n:message key="ORYX.I18N.TBPMSupport_selectFile">Select an image (.png/.jpeg) file!</i18n:message>',
        file: '<i18n:message key="ORYX.I18N.TBPMSupport_file">File</i18n:message>',
        btnImp: '<i18n:message key="ORYX.I18N.TBPMSupport_btnImp">Import</i18n:message>',
        btnClose: '<i18n:message key="ORYX.I18N.TBPMSupport_btnClose">Close</i18n:message>',
        progress: '<i18n:message key="ORYX.I18N.TBPMSupport_progress">Importing ...</i18n:message>',
        syntaxError: '<i18n:message key="ORYX.I18N.TBPMSupport_syntaxError">Syntax error</i18n:message>',
        impFailed: '<i18n:message key="ORYX.I18N.TBPMSupport_impFailed">Request for import of document failed.</i18n:message>',
        confirm: '<i18n:message key="ORYX.I18N.TBPMSupport_confirm">Confirm import of highlighted shapes!</i18n:message>'
    }
};

/** New Language Properties: 08.05.2009 */
if(!ORYX.I18N.BPMN2XHTML) ORYX.I18N.BPMN2XHTML = {};
ORYX.I18N.BPMN2XHTML.group = '<i18n:message key="ORYX.I18N.BPMN2XHTML.group">Export</i18n:message>';
ORYX.I18N.BPMN2XHTML.XHTMLExport = '<i18n:message key="ORYX.I18N.BPMN2XHTML.XHTMLExport">Export XHTML Documentation</i18n:message>';

/** New Language Properties: 09.05.2009 */
if(!ORYX.I18N.JSONImport) ORYX.I18N.JSONImport = {};

ORYX.I18N.JSONImport.title = '<i18n:message key="ORYX.I18N.JSONImport.title">JSON Import</i18n:message>';
ORYX.I18N.JSONImport.wrongSS = '<i18n:message key="ORYX.I18N.JSONImport.wrongSS">The stencil set of the imported file ({0}) does not match to the loaded stencil set ({1}).</i18n:message>';
ORYX.I18N.JSONImport.invalidJSON = '<i18n:message key="ORYX.I18N.JSONImport.invalidJSON">The JSON to import is invalid.</i18n:message>';

if(!ORYX.I18N.Feedback) ORYX.I18N.Feedback = {};

ORYX.I18N.Feedback.name = '<i18n:message key="ORYX.I18N.Feedback.name">Feedback</i18n:message>';
ORYX.I18N.Feedback.desc = '<i18n:message key="ORYX.I18N.Feedback.desc">Contact us for any kind of feedback!</i18n:message>';
ORYX.I18N.Feedback.pTitle = '<i18n:message key="ORYX.I18N.Feedback.pTitle">Contact us for any kind of feedback!</i18n:message>';
ORYX.I18N.Feedback.pName = '<i18n:message key="ORYX.I18N.Feedback.pName">Name</i18n:message>';
ORYX.I18N.Feedback.pEmail = '<i18n:message key="ORYX.I18N.Feedback.pEmail">E-Mail</i18n:message>';
ORYX.I18N.Feedback.pSubject = '<i18n:message key="ORYX.I18N.Feedback.pSubject">Subject</i18n:message>';
ORYX.I18N.Feedback.pMsg = '<i18n:message key="ORYX.I18N.Feedback.pMsg">Description/Message</i18n:message>';
ORYX.I18N.Feedback.pEmpty = '<i18n:message key="ORYX.I18N.Feedback.pEmpty">* Please provide as detailed information as possible so that we can understand your request.\n* For bug reports, please list the steps how to reproduce the problem and describe the output you expected.</i18n:message>';
ORYX.I18N.Feedback.pAttach = '<i18n:message key="ORYX.I18N.Feedback.pAttach">Attach current model</i18n:message>';
ORYX.I18N.Feedback.pAttachDesc = '<i18n:message key="ORYX.I18N.Feedback.pAttachDesc">This information can be helpful for debugging purposes. If your model contains some sensitive data, remove it before or uncheck this behavior.</i18n:message>';
ORYX.I18N.Feedback.pBrowser = '<i18n:message key="ORYX.I18N.Feedback.pBrowser">Information about your browser and environment</i18n:message>';
ORYX.I18N.Feedback.pBrowserDesc = '<i18n:message key="ORYX.I18N.Feedback.pBrowserDesc">This information has been auto-detected from your browser. It can be helpful if you encountered a bug associated with browser-specific behavior.</i18n:message>';
ORYX.I18N.Feedback.submit = '<i18n:message key="ORYX.I18N.Feedback.submit">Send Message</i18n:message>';
ORYX.I18N.Feedback.sending = '<i18n:message key="ORYX.I18N.Feedback.sending">Sending message ...</i18n:message>';
ORYX.I18N.Feedback.success = '<i18n:message key="ORYX.I18N.Feedback.success">Success</i18n:message>';
ORYX.I18N.Feedback.successMsg = '<i18n:message key="ORYX.I18N.Feedback.successMsg">Thank you for your feedback!</i18n:message>';
ORYX.I18N.Feedback.failure = '<i18n:message key="ORYX.I18N.Feedback.failure">Failure</i18n:message>';
ORYX.I18N.Feedback.failureMsg = '<i18n:message key="ORYX.I18N.Feedback.failureMsg">Unfortunately, the message could not be sent. This is our fault! Please try again or contact someone at http://code.google.com/p/oryx-editor/</i18n:message>';


ORYX.I18N.Feedback.name = '<i18n:message key="ORYX.I18N.Feedback.name">Feedback</i18n:message>';
ORYX.I18N.Feedback.failure = '<i18n:message key="ORYX.I18N.Feedback.failure">Failure</i18n:message>';
ORYX.I18N.Feedback.failureMsg = '<i18n:message key="ORYX.I18N.Feedback.failureMsg">Unfortunately, the message could not be sent. This is our fault! Please try again or contact someone at http://code.google.com/p/oryx-editor/</i18n:message>';
ORYX.I18N.Feedback.submit = '<i18n:message key="ORYX.I18N.Feedback.submit">Send Message</i18n:message>';

ORYX.I18N.Feedback.emailDesc = '<i18n:message key="ORYX.I18N.Feedback.emailDesc">Your e-mail address?</i18n:message>';
ORYX.I18N.Feedback.titleDesc = '<i18n:message key="ORYX.I18N.Feedback.titleDesc">Summarize your message with a short title</i18n:message>';
ORYX.I18N.Feedback.descriptionDesc = '<i18n:message key="ORYX.I18N.Feedback.descriptionDesc">Describe your idea, question, or problem.</i18n:message>';
ORYX.I18N.Feedback.info = '<i18n:message key="ORYX.I18N.Feedback.info"><p>Oryx is a research platform intended to support scientists in the field of business process management and beyond with a flexible, extensible tool to validate research theses and conduct experiments.</p><p>We are happy to provide you with the <a href=\"http://bpt.hpi.uni-potsdam.de/Oryx/ReleaseNotes\" target=\"_blank\"> latest technology and advancements</a> of our platform. <a href=\"http://bpt.hpi.uni-potsdam.de/Oryx/DeveloperNetwork\" target=\"_blank\">We</a> work hard to provide you with a reliable system, even though you may experience small hiccups from time to time.</p><p>If you have ideas how to improve Oryx, have a question related to the platform, or want to report a problem: <strong>Please, let us know. Here.</strong></p></i18n:message>'; // general info will be shown, if no subject specific info is given
// list subjects in reverse order of appearance!
ORYX.I18N.Feedback.subjects = [
    {
    	id: '<i18n:message key="ORYX.I18N.Feedback.subjects_first_id">question</i18n:message>',   // ansi-compatible name
    	name: '<i18n:message key="ORYX.I18N.Feedback.subjects_first_name">Question</i18n:message>', // natural name
    	description: '<i18n:message key="ORYX.I18N.Feedback.subjects_first_description">Ask your question here! \\nPlease give us as much information as possible, so we don\'t have to bother you with more questions, before we can give an answer.</i18n:message>', // default text for the description text input field
    	info: '<i18n:message key="ORYX.I18N.Feedback.subjects_first_info"/>' // optional field to give more info
    },
    {
    	id: '<i18n:message key="ORYX.I18N.Feedback.subjects_second_id">problem</i18n:message>',   // ansi-compatible name
    	name: '<i18n:message key="ORYX.I18N.Feedback.subjects_second_name">Problem</i18n:message>', // natural name
    	description: '<i18n:message key="ORYX.I18N.Feedback.subjects_second_description">We\'re sorry for the inconvenience. Give us feedback on the problem, and we\'ll try to solve it for you. Describe it as detailed as possible, please.</i18n:message>', // default text for the description text input field
    	info: '<i18n:message key="ORYX.I18N.Feedback.subjects_second_info"/>' // optional field to give more info
    },
    {
    	id: '<i18n:message key="ORYX.I18N.Feedback.subjects_third_id">idea</i18n:message>',   // ansi-compatible name
    	name: '<i18n:message key="ORYX.I18N.Feedback.subjects_third_name">Idea</i18n:message>', // natural name
    	description: '<i18n:message key="ORYX.I18N.Feedback.subjects_third_description">Share your ideas and thoughts here!</i18n:message>', // default text for the description text input field
    	info: '<i18n:message key="ORYX.I18N.Feedback.subjects_third_info"/>' // optional field to give more info
    }
];

/** New Language Properties: 11.05.2009 */
if(!ORYX.I18N.BPMN2DTRPXMI) ORYX.I18N.BPMN2DTRPXMI = {};
ORYX.I18N.BPMN2DTRPXMI.group = '<i18n:message key="ORYX.I18N.BPMN2DTRPXMI.group">Export</i18n:message>';
ORYX.I18N.BPMN2DTRPXMI.DTRPXMIExport = '<i18n:message key="ORYX.I18N.BPMN2DTRPXMI.DTRPXMIExport">Export to XMI (Design Thinking)</i18n:message>';
ORYX.I18N.BPMN2DTRPXMI.DTRPXMIExportDescription = '<i18n:message key="ORYX.I18N.BPMN2DTRPXMI.DTRPXMIExportDescription">Exports current model to XMI (requires stencil set extension \'BPMN Subset for Design Thinking\')</i18n:message>';

/** New Language Properties: 14.05.2009 */
if(!ORYX.I18N.RDFExport) ORYX.I18N.RDFExport = {};
ORYX.I18N.RDFExport.group = '<i18n:message key="ORYX.I18N.RDFExport.group">Export</i18n:message>';
ORYX.I18N.RDFExport.rdfExport = '<i18n:message key="ORYX.I18N.RDFExport.rdfExport">Export to RDF</i18n:message>';
ORYX.I18N.RDFExport.rdfExportDescription = '<i18n:message key="ORYX.I18N.RDFExport.rdfExportDescription">Exports current model to the XML serialization defined for the Resource Description Framework (RDF)</i18n:message>';

/** New Language Properties: 15.05.2009*/
if(!ORYX.I18N.SyntaxChecker.BPMN) ORYX.I18N.SyntaxChecker.BPMN={};
ORYX.I18N.SyntaxChecker.BPMN_NO_SOURCE = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_NO_SOURCE">An edge must have a source.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_NO_TARGET = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_NO_TARGET">An edge must have a target.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_DIFFERENT_PROCESS = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_DIFFERENT_PROCESS">Source and target node must be contained in the same process.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_SAME_PROCESS = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_SAME_PROCESS">Source and target node must be contained in different pools.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_FLOWOBJECT_NOT_CONTAINED_IN_PROCESS = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_FLOWOBJECT_NOT_CONTAINED_IN_PROCESS">A flow object must be contained in a process.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_ENDEVENT_WITHOUT_INCOMING_CONTROL_FLOW = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_ENDEVENT_WITHOUT_INCOMING_CONTROL_FLOW">An end event must have an incoming sequence flow.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_STARTEVENT_WITHOUT_OUTGOING_CONTROL_FLOW = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_STARTEVENT_WITHOUT_OUTGOING_CONTROL_FLOW">A start event must have an outgoing sequence flow.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_STARTEVENT_WITH_INCOMING_CONTROL_FLOW = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_STARTEVENT_WITH_INCOMING_CONTROL_FLOW">Start events must not have incoming sequence flows.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_ATTACHEDINTERMEDIATEEVENT_WITH_INCOMING_CONTROL_FLOW = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_ATTACHEDINTERMEDIATEEVENT_WITH_INCOMING_CONTROL_FLOW">Attached intermediate events must not have incoming sequence flows.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_ATTACHEDINTERMEDIATEEVENT_WITHOUT_OUTGOING_CONTROL_FLOW = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_ATTACHEDINTERMEDIATEEVENT_WITHOUT_OUTGOING_CONTROL_FLOW">Attached intermediate events must have exactly one outgoing sequence flow.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_ENDEVENT_WITH_OUTGOING_CONTROL_FLOW = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_ENDEVENT_WITH_OUTGOING_CONTROL_FLOW">End events must not have outgoing sequence flows.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_EVENTBASEDGATEWAY_BADCONTINUATION = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_EVENTBASEDGATEWAY_BADCONTINUATION">Event-based gateways must not be followed by gateways or subprocesses.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_NODE_NOT_ALLOWED = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_NODE_NOT_ALLOWED">Node type is not allowed.</i18n:message>';

if(!ORYX.I18N.SyntaxChecker.IBPMN) ORYX.I18N.SyntaxChecker.IBPMN={};
ORYX.I18N.SyntaxChecker.IBPMN_NO_ROLE_SET = '<i18n:message key="ORYX.I18N.SyntaxChecker.IBPMN_NO_ROLE_SET">Interactions must have a sender and a receiver role set</i18n:message>';
ORYX.I18N.SyntaxChecker.IBPMN_NO_INCOMING_SEQFLOW = '<i18n:message key="ORYX.I18N.SyntaxChecker.IBPMN_NO_INCOMING_SEQFLOW">This node must have incoming sequence flow.</i18n:message>';
ORYX.I18N.SyntaxChecker.IBPMN_NO_OUTGOING_SEQFLOW = '<i18n:message key="ORYX.I18N.SyntaxChecker.IBPMN_NO_OUTGOING_SEQFLOW">This node must have outgoing sequence flow.</i18n:message>';

if(!ORYX.I18N.SyntaxChecker.InteractionNet) ORYX.I18N.SyntaxChecker.InteractionNet={};
ORYX.I18N.SyntaxChecker.InteractionNet_SENDER_NOT_SET = '<i18n:message key="ORYX.I18N.SyntaxChecker.InteractionNet_SENDER_NOT_SET">Sender not set</i18n:message>';
ORYX.I18N.SyntaxChecker.InteractionNet_RECEIVER_NOT_SET = '<i18n:message key="ORYX.I18N.SyntaxChecker.InteractionNet_RECEIVER_NOT_SET">Receiver not set</i18n:message>';
ORYX.I18N.SyntaxChecker.InteractionNet_MESSAGETYPE_NOT_SET = '<i18n:message key="ORYX.I18N.SyntaxChecker.InteractionNet_MESSAGETYPE_NOT_SET">Message type not set</i18n:message>';
ORYX.I18N.SyntaxChecker.InteractionNet_ROLE_NOT_SET = '<i18n:message key="ORYX.I18N.SyntaxChecker.InteractionNet_ROLE_NOT_SET">Role not set</i18n:message>';

if(!ORYX.I18N.SyntaxChecker.EPC) ORYX.I18N.SyntaxChecker.EPC={};
ORYX.I18N.SyntaxChecker.EPC_NO_SOURCE = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_NO_SOURCE">Each edge must have a source.</i18n:message>';
ORYX.I18N.SyntaxChecker.EPC_NO_TARGET = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_NO_TARGET">Each edge must have a target.</i18n:message>';
ORYX.I18N.SyntaxChecker.EPC_NOT_CONNECTED = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_NOT_CONNECTED">Node must be connected with edges.</i18n:message>';
ORYX.I18N.SyntaxChecker.EPC_NOT_CONNECTED_2 = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_NOT_CONNECTED_2">Node must be connected with more edges.</i18n:message>';
ORYX.I18N.SyntaxChecker.EPC_TOO_MANY_EDGES = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_TOO_MANY_EDGES">Node has too many connected edges.</i18n:message>';
ORYX.I18N.SyntaxChecker.EPC_NO_CORRECT_CONNECTOR = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_NO_CORRECT_CONNECTOR">Node is no correct connector.</i18n:message>';
ORYX.I18N.SyntaxChecker.EPC_MANY_STARTS = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_MANY_STARTS">There must be only one start event.</i18n:message>';
ORYX.I18N.SyntaxChecker.EPC_FUNCTION_AFTER_OR = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_FUNCTION_AFTER_OR">There must be no functions after a splitting OR/XOR.</i18n:message>';
ORYX.I18N.SyntaxChecker.EPC_PI_AFTER_OR = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_PI_AFTER_OR">There must be no process interface after a splitting OR/XOR.</i18n:message>';
ORYX.I18N.SyntaxChecker.EPC_FUNCTION_AFTER_FUNCTION = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_FUNCTION_AFTER_FUNCTION">There must be no function after a function.</i18n:message>';
ORYX.I18N.SyntaxChecker.EPC_EVENT_AFTER_EVENT = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_EVENT_AFTER_EVENT">There must be no event after an event.</i18n:message>';
ORYX.I18N.SyntaxChecker.EPC_PI_AFTER_FUNCTION = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_PI_AFTER_FUNCTION">There must be no process interface after a function.</i18n:message>';
ORYX.I18N.SyntaxChecker.EPC_FUNCTION_AFTER_PI = '<i18n:message key="ORYX.I18N.SyntaxChecker.EPC_FUNCTION_AFTER_PI">There must be no function after a process interface.</i18n:message>';

if(!ORYX.I18N.SyntaxChecker.PetriNet) ORYX.I18N.SyntaxChecker.PetriNet={};
ORYX.I18N.SyntaxChecker.PetriNet_NOT_BIPARTITE = '<i18n:message key="ORYX.I18N.SyntaxChecker.PetriNet_NOT_BIPARTITE">The graph is not bipartite</i18n:message>';
ORYX.I18N.SyntaxChecker.PetriNet_NO_LABEL = '<i18n:message key="ORYX.I18N.SyntaxChecker.PetriNet_NO_LABEL">Label not set for a labeled transition</i18n:message>';
ORYX.I18N.SyntaxChecker.PetriNet_NO_ID = '<i18n:message key="ORYX.I18N.SyntaxChecker.PetriNet_NO_ID">There is a node without id</i18n:message>';
ORYX.I18N.SyntaxChecker.PetriNet_SAME_SOURCE_AND_TARGET = '<i18n:message key="ORYX.I18N.SyntaxChecker.PetriNet_SAME_SOURCE_AND_TARGET">Two flow relationships have the same source and target</i18n:message>';
ORYX.I18N.SyntaxChecker.PetriNet_NODE_NOT_SET = '<i18n:message key="ORYX.I18N.SyntaxChecker.PetriNet_NODE_NOT_SET">A node is not set for a flowrelationship</i18n:message>';

/** New Language Properties: 02.06.2009*/
ORYX.I18N.Edge = '<i18n:message key="ORYX.I18N.Edge">Edge</i18n:message>';
ORYX.I18N.Node = '<i18n:message key="ORYX.I18N.Node">Node</i18n:message>';

/** New Language Properties: 03.06.2009*/
ORYX.I18N.SyntaxChecker.notice = '<i18n:message key="ORYX.I18N.SyntaxChecker.notice">Move the mouse over a red cross icon to see the error message.</i18n:message>';

ORYX.I18N.Validator.result = '<i18n:message key="ORYX.I18N.Validator.result">Validation Result</i18n:message>';
ORYX.I18N.Validator.noErrors = '<i18n:message key="ORYX.I18N.Validator.noErrors">No validation errors found.</i18n:message>';
ORYX.I18N.Validator.bpmnDeadlockTitle = '<i18n:message key="ORYX.I18N.Validator.bpmnDeadlockTitle">Deadlock</i18n:message>';
ORYX.I18N.Validator.bpmnDeadlock = '<i18n:message key="ORYX.I18N.Validator.bpmnDeadlock">This node results in a deadlock. There are situations where not all incoming branches are activated.</i18n:message>';
ORYX.I18N.Validator.bpmnUnsafeTitle = '<i18n:message key="ORYX.I18N.Validator.bpmnUnsafeTitle">Lack of synchronization</i18n:message>';
ORYX.I18N.Validator.bpmnUnsafe = '<i18n:message key="ORYX.I18N.Validator.bpmnUnsafe">This model suffers from lack of synchronization. The marked element is activated from multiple incoming branches.</i18n:message>';
ORYX.I18N.Validator.bpmnLeadsToNoEndTitle = '<i18n:message key="ORYX.I18N.Validator.bpmnLeadsToNoEndTitle">Validation Result</i18n:message>';
ORYX.I18N.Validator.bpmnLeadsToNoEnd = '<i18n:message key="ORYX.I18N.Validator.bpmnLeadsToNoEnd">The process will never reach a final state.</i18n:message>';

ORYX.I18N.Validator.syntaxErrorsTitle = '<i18n:message key="ORYX.I18N.Validator.syntaxErrorsTitle">Syntax Error</i18n:message>';
ORYX.I18N.Validator.syntaxErrorsMsg = '<i18n:message key="ORYX.I18N.Validator.syntaxErrorsMsg">The process cannot be validated because it contains syntax errors.</i18n:message>';

ORYX.I18N.Validator.error = '<i18n:message key="ORYX.I18N.Validator.error">Validation failed</i18n:message>';
ORYX.I18N.Validator.errorDesc = '<i18n:message key="ORYX.I18N.Validator.errorDesc">We are sorry, but the validation of your process failed. It would help us identifying the problem, if you sent us your process model via the \"Send Feedback\" function.</i18n:message>';

ORYX.I18N.Validator.epcIsSound = '<i18n:message key="ORYX.I18N.Validator.epcIsSound"><p><b>The EPC is sound, no problems found!</b></p></i18n:message>';
ORYX.I18N.Validator.epcNotSound = '<i18n:message key="ORYX.I18N.Validator.epcNotSound"><p><b>The EPC is <i>NOT</i> sound!</b></p></i18n:message>';

/** New Language Properties: 05.06.2009*/
if(!ORYX.I18N.RESIZE) ORYX.I18N.RESIZE = {};
ORYX.I18N.RESIZE.tipGrow = '<i18n:message key="ORYX.I18N.RESIZE.tipGrow">Increase canvas size:</i18n:message>';
ORYX.I18N.RESIZE.tipShrink = '<i18n:message key="ORYX.I18N.RESIZE.tipShrink">Decrease canvas size:</i18n:message>';
ORYX.I18N.RESIZE.N = '<i18n:message key="ORYX.I18N.RESIZE.N">Top</i18n:message>';
ORYX.I18N.RESIZE.W = '<i18n:message key="ORYX.I18N.RESIZE.W">Left</i18n:message>';
ORYX.I18N.RESIZE.S = '<i18n:message key="ORYX.I18N.RESIZE.S">Down</i18n:message>';
ORYX.I18N.RESIZE.E = '<i18n:message key="ORYX.I18N.RESIZE.E">Right</i18n:message>';
/** New Language Properties: 14.08.2009*/
if(!ORYX.I18N.PluginLoad) ORYX.I18N.PluginLoad = {};
ORYX.I18N.PluginLoad.AddPluginButtonName = '<i18n:message key="ORYX.I18N.PluginLoad.AddPluginButtonName">Add Plugins</i18n:message>';
ORYX.I18N.PluginLoad.AddPluginButtonDesc = '<i18n:message key="ORYX.I18N.PluginLoad.AddPluginButtonDesc">Add additional Plugins dynamically</i18n:message>';
ORYX.I18N.PluginLoad.loadErrorTitle = '<i18n:message key="ORYX.I18N.PluginLoad.loadErrorTitle">Loading Error</i18n:message>';
ORYX.I18N.PluginLoad.loadErrorDesc = '<i18n:message key="ORYX.I18N.PluginLoad.loadErrorDesc">Unable to load Plugin. \n Error:\n</i18n:message>';
ORYX.I18N.PluginLoad.WindowTitle = '<i18n:message key="ORYX.I18N.PluginLoad.WindowTitle">Add additional Plugins</i18n:message>';

ORYX.I18N.PluginLoad.NOTUSEINSTENCILSET = '<i18n:message key="ORYX.I18N.PluginLoad.NOTUSEINSTENCILSET">Not allowed in this Stencilset!</i18n:message>';
ORYX.I18N.PluginLoad.REQUIRESTENCILSET = '<i18n:message key="ORYX.I18N.PluginLoad.REQUIRESTENCILSET">Require another Stencilset!</i18n:message>';
ORYX.I18N.PluginLoad.NOTFOUND = '<i18n:message key="ORYX.I18N.PluginLoad.NOTFOUND">Pluginname not found!</i18n:message>';
ORYX.I18N.PluginLoad.YETACTIVATED = '<i18n:message key="ORYX.I18N.PluginLoad.YETACTIVATED">Plugin is yet activated!</i18n:message>';

/** New Language Properties: 15.07.2009*/
if(!ORYX.I18N.Layouting) ORYX.I18N.Layouting ={};
ORYX.I18N.Layouting.doing = '<i18n:message key="ORYX.I18N.Layouting.doing">Layouting...</i18n:message>';

/** New Language Properties: 18.08.2009*/
ORYX.I18N.SyntaxChecker.MULT_ERRORS = '<i18n:message key="ORYX.I18N.SyntaxChecker.MULT_ERRORS">Multiple Errors</i18n:message>';

/** New Language Properties: 08.09.2009*/
if(!ORYX.I18N.PropertyWindow) ORYX.I18N.PropertyWindow = {};
ORYX.I18N.PropertyWindow.oftenUsed = '<i18n:message key="ORYX.I18N.PropertyWindow.oftenUsed">Core Properties</i18n:message>';
ORYX.I18N.PropertyWindow.moreProps = '<i18n:message key="ORYX.I18N.PropertyWindow.moreProps">Extra Properties</i18n:message>';
ORYX.I18N.PropertyWindow.simulationProps = '<i18n:message key="ORYX.I18N.PropertyWindow.simulationProps">Simulation Properties</i18n:message>';
ORYX.I18N.PropertyWindow.displayProps = '<i18n:message key="ORYX.I18N.PropertyWindow.displayProps">Graphical Settings</i18n:message>';

/** New Language Properties: 17.09.2009*/
if(!ORYX.I18N.Bpmn2_0Serialization) ORYX.I18N.Bpmn2_0Serialization = {};
ORYX.I18N.Bpmn2_0Serialization.show = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.show">Show BPMN 2.0 DI XML</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.showDesc = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.showDesc">Show BPMN 2.0 DI XML of the current BPMN 2.0 model</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.download = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.download">Download BPMN 2.0 DI XML</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.downloadDesc = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.downloadDesc">Download BPMN 2.0 DI XML of the current BPMN 2.0 model</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.serialFailed = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.serialFailed">An error occurred while generating the BPMN 2.0 DI XML Serialization.</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.group = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.group">BPMN 2.0</i18n:message>';

/** New Language Properties 01.10.2009 */
if(!ORYX.I18N.SyntaxChecker.BPMN2) ORYX.I18N.SyntaxChecker.BPMN2 = {};

ORYX.I18N.SyntaxChecker.BPMN2_DATA_INPUT_WITH_INCOMING_DATA_ASSOCIATION = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_DATA_INPUT_WITH_INCOMING_DATA_ASSOCIATION">A Data Input must not have any incoming Data Associations.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_DATA_OUTPUT_WITH_OUTGOING_DATA_ASSOCIATION = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_DATA_OUTPUT_WITH_OUTGOING_DATA_ASSOCIATION">A Data Output must not have any outgoing Data Associations.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_TARGET_WITH_TOO_MANY_INCOMING_SEQUENCE_FLOWS = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_TARGET_WITH_TOO_MANY_INCOMING_SEQUENCE_FLOWS">Targets of Event-based Gateways may only have one incoming Sequence Flow.</i18n:message>';


/** New Language Properties 02.10.2009 */
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_WITH_TOO_LESS_OUTGOING_SEQUENCE_FLOWS = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_WITH_TOO_LESS_OUTGOING_SEQUENCE_FLOWS">An Event-based Gateway must have two or more outgoing Sequence Flows.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_EVENT_TARGET_CONTRADICTION = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_EVENT_TARGET_CONTRADICTION">If Message Intermediate Events are used in the configuration, then Receive Tasks must not be used and vice versa.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_WRONG_TRIGGER = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_WRONG_TRIGGER">Only the following Intermediate Event triggers are valid: Message, Signal, Timer, Conditional and Multiple.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_WRONG_CONDITION_EXPRESSION = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_WRONG_CONDITION_EXPRESSION">The outgoing Sequence Flows of the Event Gateway must not have a condition expression.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_NOT_INSTANTIATING = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_NOT_INSTANTIATING">The Gateway does not meet the conditions to instantiate the process. Please use a start event or an instantiating attribute for the gateway.</i18n:message>';

/** New Language Properties 05.10.2009 */
ORYX.I18N.SyntaxChecker.BPMN2_GATEWAYDIRECTION_MIXED_FAILURE = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_GATEWAYDIRECTION_MIXED_FAILURE">The Gateway must have both multiple incoming and outgoing Sequence Flows.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_GATEWAYDIRECTION_CONVERGING_FAILURE = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_GATEWAYDIRECTION_CONVERGING_FAILURE">The Gateway must have multiple incoming but most NOT have multiple outgoing Sequence Flows.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_GATEWAYDIRECTION_DIVERGING_FAILURE = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_GATEWAYDIRECTION_DIVERGING_FAILURE">The Gateway must NOT have multiple incoming but must have multiple outgoing Sequence Flows.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_GATEWAY_WITH_NO_OUTGOING_SEQUENCE_FLOW = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_GATEWAY_WITH_NO_OUTGOING_SEQUENCE_FLOW">A Gateway must have a minimum of one outgoing Sequence Flow.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_RECEIVE_TASK_WITH_ATTACHED_EVENT = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_RECEIVE_TASK_WITH_ATTACHED_EVENT">Receive Tasks used in Event Gateway configurations must not have any attached Intermediate Events.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_SUBPROCESS_BAD_CONNECTION = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_EVENT_SUBPROCESS_BAD_CONNECTION">An Event Subprocess must not have any incoming or outgoing Sequence Flow.</i18n:message>';

/** New Language Properties 13.10.2009 */
ORYX.I18N.SyntaxChecker.BPMN_MESSAGE_FLOW_NOT_CONNECTED = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_MESSAGE_FLOW_NOT_CONNECTED">At least one side of the Message Flow has to be connected.</i18n:message>';

/** New Language Properties 19.10.2009 */
ORYX.I18N.Bpmn2_0Serialization['import'] = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization__import__">Import from BPMN 2.0 DI XML</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.importDesc = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.importDesc">Import a BPMN 2.0 model from a file or XML String</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.selectFile = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.selectFile">Select a (*.bpmn) file or type in BPMN 2.0 DI XML to import it!</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.file = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.file">File:</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.name = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.name">Import from BPMN 2.0 DI XML</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.btnImp = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.btnImp">Import</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.progress = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.progress">Importing BPMN 2.0 DI XML ...</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.btnClose = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.btnClose">Close</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.error = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.error">An error occurred while importing BPMN 2.0 DI XML</i18n:message>';

/** New Language Properties 24.11.2009 */
ORYX.I18N.SyntaxChecker.BPMN2_TOO_MANY_INITIATING_MESSAGES = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_TOO_MANY_INITIATING_MESSAGES">A Choreography Activity may only have one initiating message.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN_MESSAGE_FLOW_NOT_ALLOWED = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN_MESSAGE_FLOW_NOT_ALLOWED">A Message Flow is not allowed here.</i18n:message>';

/** New Language Properties 27.11.2009 */
ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_WITH_TOO_LESS_INCOMING_SEQUENCE_FLOWS = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_EVENT_BASED_WITH_TOO_LESS_INCOMING_SEQUENCE_FLOWS">An Event-based Gateway that is not instantiating must have a minimum of one incoming Sequence Flow.</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_TOO_FEW_INITIATING_PARTICIPANTS = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_TOO_FEW_INITIATING_PARTICIPANTS">A Choreography Activity must have one initiating Participant (white).</i18n:message>';
ORYX.I18N.SyntaxChecker.BPMN2_TOO_MANY_INITIATING_PARTICIPANTS = '<i18n:message key="ORYX.I18N.SyntaxChecker.BPMN2_TOO_MANY_INITIATING_PARTICIPANTS">A Choreography Acitivity must not have more than one initiating Participant (white).</i18n:message>';

ORYX.I18N.SyntaxChecker.COMMUNICATION_AT_LEAST_TWO_PARTICIPANTS = '<i18n:message key="ORYX.I18N.SyntaxChecker.COMMUNICATION_AT_LEAST_TWO_PARTICIPANTS">The communication must be connected to at least two participants.</i18n:message>';
ORYX.I18N.SyntaxChecker.MESSAGEFLOW_START_MUST_BE_PARTICIPANT = '<i18n:message key="ORYX.I18N.SyntaxChecker.MESSAGEFLOW_START_MUST_BE_PARTICIPANT">The message flow\'s source must be a participant.</i18n:message>';
ORYX.I18N.SyntaxChecker.MESSAGEFLOW_END_MUST_BE_PARTICIPANT = '<i18n:message key="ORYX.I18N.SyntaxChecker.MESSAGEFLOW_END_MUST_BE_PARTICIPANT">The message flow\'s target must be a participant.</i18n:message>';
ORYX.I18N.SyntaxChecker.CONV_LINK_CANNOT_CONNECT_CONV_NODES = '<i18n:message key="ORYX.I18N.SyntaxChecker.CONV_LINK_CANNOT_CONNECT_CONV_NODES">The conversation link must connect a communication or sub conversation node with a participant.</i18n:message>';

/** New Language Properties 30.12.2009 */
ORYX.I18N.Bpmn2_0Serialization.xpdlShow = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.xpdlShow">Show XPDL 2.2</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.xpdlShowDesc = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.xpdlShowDesc">Shows the XPDL 2.2 based on BPMN 2.0 XML (by XSLT)</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.xpdlDownload = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.xpdlDownload">Download as XPDL 2.2</i18n:message>';
ORYX.I18N.Bpmn2_0Serialization.xpdlDownloadDesc = '<i18n:message key="ORYX.I18N.Bpmn2_0Serialization.xpdlDownloadDesc">Download the XPDL 2.2 based on BPMN 2.0 XML (by XSLT)</i18n:message>';


if(!ORYX.I18N.cpntoolsSupport) ORYX.I18N.cpntoolsSupport = {};

ORYX.I18N.cpntoolsSupport.serverConnectionFailed = '<i18n:message key="ORYX.I18N.cpntoolsSupport.serverConnectionFailed">Connection to server failed.</i18n:message>';
ORYX.I18N.cpntoolsSupport.importTask = '<i18n:message key="ORYX.I18N.cpntoolsSupport.importTask">Select an CPN file (.cpn) or type in the CPN XML structure in order to import it!</i18n:message>';
ORYX.I18N.cpntoolsSupport.File = '<i18n:message key="ORYX.I18N.cpntoolsSupport.File">File:</i18n:message>';
ORYX.I18N.cpntoolsSupport.cpn = '<i18n:message key="ORYX.I18N.cpntoolsSupport.cpn">CPN</i18n:message>';
ORYX.I18N.cpntoolsSupport.title = '<i18n:message key="ORYX.I18N.cpntoolsSupport.title">CPN Oryx</i18n:message>';
ORYX.I18N.cpntoolsSupport.importLable = '<i18n:message key="ORYX.I18N.cpntoolsSupport.importLable">Import</i18n:message>';
ORYX.I18N.cpntoolsSupport.close = '<i18n:message key="ORYX.I18N.cpntoolsSupport.close">Close</i18n:message>';
ORYX.I18N.cpntoolsSupport.wrongCPNFile = '<i18n:message key="ORYX.I18N.cpntoolsSupport.wrongCPNFile">Not chosen correct CPN - File.</i18n:message>';
ORYX.I18N.cpntoolsSupport.noPageSelection = '<i18n:message key="ORYX.I18N.cpntoolsSupport.noPageSelection">No page has been selected.</i18n:message>';
ORYX.I18N.cpntoolsSupport.group = '<i18n:message key="ORYX.I18N.cpntoolsSupport.group">Export</i18n:message>';
ORYX.I18N.cpntoolsSupport.importProgress = '<i18n:message key="ORYX.I18N.cpntoolsSupport.importProgress">Importing ...</i18n:message>';
ORYX.I18N.cpntoolsSupport.exportProgress = '<i18n:message key="ORYX.I18N.cpntoolsSupport.exportProgress">Exporting ...</i18n:message>';
ORYX.I18N.cpntoolsSupport.exportDescription = '<i18n:message key="ORYX.I18N.cpntoolsSupport.exportDescription">Export to CPN Tools</i18n:message>';
ORYX.I18N.cpntoolsSupport.importDescription = '<i18n:message key="ORYX.I18N.cpntoolsSupport.importDescription">Import from CPN Tools</i18n:message>';

if(!ORYX.I18N.BPMN2YAWLMapper) ORYX.I18N.BPMN2YAWLMapper = {};

ORYX.I18N.BPMN2YAWLMapper.group = '<i18n:message key="ORYX.I18N.BPMN2YAWLMapper.group">Export</i18n:message>';
ORYX.I18N.BPMN2YAWLMapper.name = '<i18n:message key="ORYX.I18N.BPMN2YAWLMapper.name">YAWL Export</i18n:message>';
ORYX.I18N.BPMN2YAWLMapper.desc = '<i18n:message key="ORYX.I18N.BPMN2YAWLMapper.desc">Map this diagram to YAWL and export it, please ensure \"BPMN Subset for mapping to YAWL\" is loaded</i18n:message>';
</script>