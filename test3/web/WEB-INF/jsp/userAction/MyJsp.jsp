<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
	<title>岗位管理</title>
   	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<title>岗位管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add_user"></i><em>岗位管理</em></span>
  </div>
    <s:form action="role_%{ id == null ? 'add' : 'edit' }">
    	<s:hidden name="id"></s:hidden>
  <table class="list-style">
   <tr>
    <td style="text-align:right;">岗位名称：</td>
    <td><s:textfield name="name" cssClass="textBox length-middle"/></td>
   </tr>
      <tr>
    <td style="text-align:right;">备注：</td>
    <td><s:textfield name="description" cssClass="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" class="tdBtn" value="添加新岗位"/></td>
   </tr>
  </table>
  </s:form>
 </div>
</body>
</html>