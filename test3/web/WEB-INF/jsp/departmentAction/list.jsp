
<html>
<head>
    <title>部门列表</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<title>部门列表</title>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="user"></i><em>部门列表</em></span>
    <span class="modular fr"><s:a action="department_addUI">+添加新部门</s:a></span>
  </div>
  <div class="operate">
   <s:form action="department_select" method="POST">
    <input type="text" name="strText" value="${strText}" class="textBox length-long" placeholder="输入部门昵称"/>
    <input type="submit" value="查询" class="tdBtn"/>
   </s:form>
  </div> 
  <table class="list-style Interlaced">
   <tr>
     <th>部门名称</th>
     <th>上级部门名称</th>
     <th>描述</th>
     <th>操作</th>
   </tr>
        <s:iterator value="#departmentList">
   <tr>
<td><s:a action="department_list?parentId=%{id}">${name}</s:a>&nbsp;</td>
				<td>${parent.name}&nbsp;</td>
				<td>${description}&nbsp;</td>
    <td class="center">
     <s:a action="department_editUI?id=%{id}"><img src="images/icon_edit.gif"/></s:a>
     <s:a action="department_delete?id=%{id}"><img src="images/icon_drop.gif"/></s:a>
    </td>
   </tr>
        </s:iterator> 
  </table>
  <!-- BatchOperation -->
 </div>
</body>
</html>