<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
	<title>部门管理</title>
   	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<title>部门管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add_user"></i><em>部门管理</em></span>
  </div>
    <s:form action="department_%{id == null ? 'add' : 'edit'}">
        <s:hidden name="id"></s:hidden>
  <table class="list-style">
   <tr>
    <td style="width:15%;text-align:right;">上级部门：</td>
    <td><s:select name="parentId" cssClass="textBox length-middle"
                        		list="#departmentList" listKey="id" listValue="name"
                        		headerKey="" headerValue="==请选择部门=="
                        	/></td>
   </tr>
   <tr>
    <td style="text-align:right;">部门名称：</td>
    <td><s:textfield name="name" cssClass="textBox length-middle"/></td>
   </tr>
      <tr>
    <td style="text-align:right;">备注：</td>
    <td><s:textarea name="description" cssClass="textarea"/></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" class="tdBtn" value="添加新部门"/></td>
   </tr>
  </table>
  </s:form>
 </div>
</body>
</html>