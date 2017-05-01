<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<frameset rows="76,*" framespacing="0" border="0">
  <frame src="${pageContext.request.contextPath}/home_top.action" id="header-frame" name="header-frame" frameborder="no" scrolling="no">
  <frameset cols="180,  *" framespacing="0" border="0" id="frame-body">
    <frame src="${pageContext.request.contextPath}/home_left.action" frameborder="no" scrolling="yes">
    <frame src="${pageContext.request.contextPath}/home_right.action" name="mainCont" frameborder="no" scrolling="yes">
  </frameset>
</frameset><noframes></noframes>
</head>
<body>
</body>
</html>