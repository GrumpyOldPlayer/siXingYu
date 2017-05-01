<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>信息列表</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<title>信息列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="user"></i><em>信息列表</em></span>
    <span class="modular fr"><s:a action="mf_addUI" cssClass="pt-link-btn">+添加</s:a></span>
  </div>
 <!--  <div class="operate">
   <form>
    <select class="inline-select">
     <option>选择岗位等级</option>
     <option>白金岗位</option>
     <option>黄金岗位</option>
    </select>
    <input type="text" class="textBox length-long" placeholder="输入岗位昵称、姓名、手机号码..."/>
    <input type="button" value="查询" class="tdBtn"/>
   </form>
  </div> -->
  <table class="list-style Interlaced">
   <tr>
     <th>信息标题</th>
     <th>添加时间</th>
     <th>联系人</th>
     <th>联系电话</th>
     <th>状态</th>
     <th>详情</th>
   </tr>
   <s:iterator value="MianfeiList">
	   <tr>
			<td class="center">${title}</td>
			<td class="center">${addtime}</td>
			<td class="center">${user.name}</td>
			<td class="center">${tel}</td>
			<td class="center">${state}</td>

	    <td class="center">
	     <s:a action="user_oneeditUI?id=%{id}"><img src="images/icon_edit.gif"/></s:a>
	    </td>
	   </tr>
   </s:iterator> 
  </table>
  <!-- BatchOperation -->
 </div>
</body>
</html>