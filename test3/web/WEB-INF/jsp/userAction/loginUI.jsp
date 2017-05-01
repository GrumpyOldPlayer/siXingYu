<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
    <title>后台管理系统</title>

    <meta name="robots" content="nofollow"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
    <style>
        body {
            width: 100%;
            height: 100%;
            overflow: hidden;
            background: url(images/pc_loginBg.jpg) no-repeat;
            background-size: cover;
            position: absolute;
        }
    </style>
    <script src="js/jquery.js"></script>

</head>
<body>
<section class="loginform">
    <h1>后台管理系统</h1>
    <s:form action="user_login" focusElement="loginNameInput" id="login_tijiao">
        <ul>
            <li>
                <label>账号：</label>
                <s:textfield name="loginName" size="20" tabindex="1" cssClass="textBox"/>
            </li>
            <li>
                <label>密码：</label>
                <s:password name="password" id="aa" size="20" tabindex="2" showPassword="false" cssClass="textBox"/>
            </li>
            <li><font color="red"><s:fielderror/></font>


                <div id="v_container" style="width: 100px;height: 50px; float:left">
                    <canvas id="verifyCanvas" width="100" height="50" style="cursor: pointer;">您的浏览器版本不支持canvas</canvas>
                </div>
                <div style="float:right;margin-right:20px">
                    <input type="text" id="code_input" style="height: 50px;" value="" placeholder="请输入验证码">
                </div>
            </li>
            <div>
                <input id="my_button" class="layui-btn" style="width: 90%;" value="立即登陆"/>
            </div>
        </ul>
    </s:form>
</section>
</body>


<script>
    $("#v_container").click(function () {
        var verifyCode = new GVerify("v_container");
    })

    var verifyCode = new GVerify("v_container");

    $("#my_button").click(function () {
        var res = verifyCode.validate(document.getElementById("code_input").value);
        if (res) {
            $("#login_tijiao").submit();
        } else {
            alert("验证码错误");
        }

    })
</script>


</html>