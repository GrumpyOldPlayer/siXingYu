<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>左侧导航</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
</head>
<body style="background:#313131">
<div class="menu-list">
    <a href="main.html" target="mainCont" class="block menu-list-title center"
       style="border:none;margin-bottom:8px;color:#fff;">起始页</a>
    <ul>
        <s:iterator value="#application.topPrivilegeList">
            <s:if test="#session.user.hasPrivilegeByName(name)">
                <li class="menu-list-title">
                    <span>${name}</span>
                    <i>◢</i>
                </li>
                <li>
                    <ul class="menu-children">
                        <s:iterator value="children">
                            <s:if test="#session.user.hasPrivilegeByName(name)">
                                <li><a href="${pageContext.request.contextPath}${url}.action" title="${name}"
                                       target="mainCont">${name}</a></li>
                            </s:if>
                        </s:iterator>
                    </ul>
                </li>
            </s:if>
        </s:iterator>
    </ul>
</div>
<div class="menu-footer">© 版权所有 2017</div>
</body>
</html>