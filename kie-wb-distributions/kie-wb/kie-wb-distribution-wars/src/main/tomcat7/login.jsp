<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.Locale" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/i18n-1.0" prefix="i18n" %>
<%
    Locale locale= null;
    try{
        locale = new Locale(request.getParameter("locale"));
    } catch(Exception e){
        locale= request.getLocale();
    }
%>
<i18n:bundle id="bundle" baseName="org.kie.workbench.client.resources.i18n.LoginConstants"
             locale='<%= locale%>' />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><i18n:message key="LoginTitle">KIE Workbench</i18n:message></title>

    <style type="text/css">
        * {
            font-family: Helvetica, Arial, sans-serif;
        }

        body {
            margin: 0;
            pading: 0;
            color: #fff;
            background: url('<%=request.getContextPath()%>/images/bg-login.png') repeat #1b1b1b;
            font-size: 14px;
            text-shadow: #050505 0 -1px 0;
            font-weight: bold;
        }

        li {
            list-style: none;
        }

        #dummy {
            position: absolute;
            top: 0;
            left: 0;
            border-bottom: solid 3px #777973;
            height: 250px;
            width: 100%;
            background: url('<%=request.getContextPath()%>/images/bg-login-top.png') repeat #fff;
            z-index: 1;
        }

        #dummy2 {
            position: absolute;
            top: 0;
            left: 0;
            border-bottom: solid 2px #545551;
            height: 252px;
            width: 100%;
            background: transparent;
            z-index: 2;
        }

        #login-wrapper {
            margin: 0 0 0 -160px;
            width: 370px;
            text-align: center;
            z-index: 99;
            position: absolute;
            top: 0;
            left: 50%;
        }

        #login-top {
            height: 120px;
            width: 401px;
            padding-top: 20px;
            text-align: center;
        }

        #login-content {
            margin-top: 120px;
        }

        label {
            width: 70px;
            float: left;
            padding: 8px;
            line-height: 14px;
            margin-top: -4px;
        }

        input.text-input {
            width: 200px;
            float: right;
            -moz-border-radius: 4px;
            -webkit-border-radius: 4px;
            border-radius: 4px;
            background: #fff;
            border: solid 1px transparent;
            color: #555;
            padding: 8px;
            font-size: 13px;
        }

        input.button {
            float: right;
            padding: 6px 10px;
            color: #fff;
            font-size: 14px;
            background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#a4d04a), to(#459300));
            text-shadow: #050505 0 -1px 0;
            background-color: #459300;
            -moz-border-radius: 4px;
            -webkit-border-radius: 4px;
            border-radius: 4px;
            border: solid 1px transparent;
            font-weight: bold;
            cursor: pointer;
            letter-spacing: 1px;
        }

        input.button:hover {
            background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#a4d04a), to(#a4d04a), color-stop(80%, #76b226));
            text-shadow: #050505 0 -1px 2px;
            background-color: #a4d04a;
            color: #fff;
        }

        div.error {
            padding: 8px;
            background: rgba(52, 4, 0, 0.4);
            -moz-border-radius: 8px;
            -webkit-border-radius: 8px;
            border-radius: 8px;
            border: solid 1px transparent;
            margin: 6px 0;
        }
    </style>
</head>

<body id="login">

<div id="login-wrapper" class="png_bg">
    <div id="login-top">
        <img src="<%=request.getContextPath()%>/images/kie-ide.png" alt="KIE IDE Logo" title="Powered By Drools/jBPM"/>
    </div>

    <div id="login-content">
        <c:if test="${param.message != null}">
            <h3><i18n:message key="loginFailed">Login failed: Not Authorized</i18n:message></h3>
        </c:if>
        <form action="j_security_check" method="POST">
            <p>
                <label style="white-space: nowrap;"><i18n:message key="UserName">Username</i18n:message></label>
                <input value="" name="j_username" class="text-input" type="text"/>
            </p>
            <br style="clear: both;"/>

            <p>
                <label style="white-space: nowrap;"><i18n:message key="Password">Password</i18n:message></label>
                <input name="j_password" class="text-input" type="password"/>
            </p>
            <br style="clear: both;"/>

            <p>
                <input class="button" type="submit" value='<i18n:message key="SignIn">Sign In</i18n:message>'/>
            </p>

        </form>
    </div>
</div>
<div id="dummy"></div>
<div id="dummy2"></div>
</body>
</html>
