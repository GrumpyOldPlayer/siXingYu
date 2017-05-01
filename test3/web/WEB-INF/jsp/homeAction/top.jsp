<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>header</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="header">
    <div class="logo">
        <img src="images/admin_logo.png" title="在哪儿"/>
    </div>
    <div class="fr top-link">
        <%--<a href="#" target="_blank" title="访问站点"><i class="shopLinkIcon"></i><span>访问站点</span></a>--%>
        <a href="#" target="mainCont" title="DeathGhost"><i class="adminIcon"></i><span>您好，${user.name }</span></a>
        <a href="${pageContext.request.contextPath}/user_logout.action" target="_parent" title="安全退出"
           style="background:rgb(60,60,60);"><i class="quitIcon"></i><span>安全退出</span></a>
    </div>
</div>
</body>
</html>