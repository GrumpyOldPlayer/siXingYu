<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <title>信息列表</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<title>信息列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
<script src="js/jquery.easyui.min.js"></script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="user"></i><em>信息列表</em></span>
        <span class="modular fr"><s:a action="sf_addUI" cssClass="pt-link-btn">+添加</s:a></span>
        &nbsp;
        &nbsp;
        <span class="modular fr"><s:a action="exportExcel_sfexportExcel.action" cssClass="pt-link-btn">导出报表</s:a></span>
    </div>
    <div class="operate">
        <%--2017-4-27商品分类--%>
        <form action="sf_selectCategories.action" method="post">
            分类查询：<select id="categories" name="categories">
            <s:iterator value="#categories">
                <option value="${id}">${name}</option>
            </s:iterator>
        </select>
            <input type="submit" value="查询" class="tdBtn"/>
        </form>
        <%----%>
        <form action="sf_select.action" method="POST">
            <input type="text" name="strText" value="${strText}" class="textBox length-long" placeholder="输入标题或者内容"/>
            <input type="submit" value="查询" class="tdBtn"/>
        </form>
    </div>
    <table class="list-style Interlaced">
        <tr>
            <th>信息标题</th>
            <th>分类</th>
            <th>添加时间</th>
            <th>联系人</th>
            <th>联系电话</th>
            <th>状态</th>
            <th>价格</th>
            <th>审核</th>
            <th>操作</th>
        </tr>
        <s:iterator value="ShoufeiList">
        <tr>
            <td class="center">${title}</td>
            <td class="center">${cname}</td>
            <td class="center">${addtime}</td>
            <td class="center">${user.name}</td>
            <td class="center">${tel}</td>
            <td class="center">${state}</td>
            <td class="center">${price}</td>

            <td class="center">
                <s:a action="sf_confirm?id=%{id}" onclick="return confirm('确定要审核通过吗？')"><img
                        src="images/yes.gif"/></s:a>
                <s:a action="sf_refuse?id=%{id}" onclick="return confirm('确定要驳回吗？')"><img src="images/no.gif"/></s:a>
            </td>
            <td class="center">
                <s:a action="sf_editUI?id=%{id}"><img src="images/icon_edit.gif"/></s:a>
                <s:a action="sf_delete?id=%{id}" onclick="return delConfirm()"><img src="images/icon_drop.gif"/></s:a>
            </td>
        </tr>
        </s:iterator>
</div>
</body>
</html>