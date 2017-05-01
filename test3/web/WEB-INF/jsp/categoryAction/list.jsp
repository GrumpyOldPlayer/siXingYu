<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>类别列表</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<title>类别列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="user"></i><em>信息类别列表</em></span>
    <span class="modular fr"><s:a action="ct_addUI">+添加新类别</s:a></span>
  </div>

 <div class="operate">
   <s:form action="ct_select.action" method="POST">
    <input type="text" name="strText" value="${strText}" class="textBox length-long" placeholder="输入分类名称"/>
    <input type="submit" value="查询" class="tdBtn"/>
   </s:form>
  </div> 
  <table class="list-style Interlaced">
   <tr>
     <th>名称</th>
     <th>操作</th>
   </tr>
<s:iterator value="CategoryList">
   <tr>
		<td class="center">${name}</td>
    <td class="center">
     <s:a action="ct_editUI?id=%{id}"><img src="images/icon_edit.gif"/></s:a>
     <s:a action="ct_delete?id=%{id}"><img src="images/icon_drop.gif"/></s:a>
    </td>
   </tr>
        </s:iterator> 
  </table>
  <!-- BatchOperation -->
 </div>
</body>
</html>