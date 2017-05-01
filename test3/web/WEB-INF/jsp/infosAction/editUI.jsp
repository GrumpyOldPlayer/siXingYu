<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
	<title>信息管理</title>
   	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<title>信息管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="add_user"></i><em>信息类别管理</em></span>
  </div>
    <s:form action="infos_edit">
    	<s:hidden name="id"></s:hidden>
  <table class="list-style">
   <tr>
    <td style="text-align:right;">标题：</td>
    	<td><s:textfield name="title" cssClass="textBox length-middle"/></td>
   </tr>
   <tr>
    <td style="width:15%;text-align:right;">类别：</td>
    <td>
    	<s:select name="cid" cssClass="textBox length-middle" list="#plist" listKey="id" listValue="name" />
    </td>
   </tr>
     <tr>
    <td style="text-align:right;">联系人：</td>
    	<td><s:textfield name="user" cssClass="textBox length-middle"/></td>
   </tr>
     <tr>
    <td style="text-align:right;">联系电话：</td>
    	<td><s:textfield name="tel" cssClass="textBox length-middle"/></td>
   </tr>
   
        <tr>
    <td style="text-align:right;">备注：</td>
    <td><s:textarea name="infos" cssClass="textarea"/></td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" class="tdBtn" value="添加"/></td>
   </tr>
  </table>
  </s:form>
 </div>
</body>
</html>