<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <title>用户列表</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<title>会员列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
<script src="js/jquery.js"></script>
<script src="js/public.js"></script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="user"></i><em>会员列表</em></span>
        <span class="modular fr"><s:a action="user_addUI">+添加新会员</s:a></span>
    </div>
    <div class="operate">
        <s:form action="user_select" method="POST">
            <input type="text" name="strText" value="${strText}" class="textBox length-long" placeholder="登陆名、姓名、手机号码"/>
            <input type="submit" value="查询" class="tdBtn"/>
        </s:form>
    </div>
    <table class="list-style Interlaced">
        <tr>
            <th>登录名</th>
            <th>姓名</th>
            <th>所属部门</th>
            <th>岗位</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        <s:iterator value="#users">
            <tr>
                <td>${loginName}&nbsp;</td>
                <td>${name}&nbsp;</td>
                <td>${department.name}&nbsp;</td>
                <td>
                    <s:iterator value="roles">
                        ${name}
                    </s:iterator>
                </td>
                <td>${description}&nbsp;</td>
                <td class="center">
                    <s:a action="user_editUI?id=%{id}"><img src="images/icon_edit.gif"/></s:a>
                    <s:a action="user_delete?id=%{id}"><img src="images/icon_drop.gif"/></s:a>
                </td>
            </tr>
        </s:iterator>
    </table>
    <!-- BatchOperation -->
</div>
</body>
</html>