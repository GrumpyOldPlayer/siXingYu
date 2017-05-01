<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>55同城网</title>
<link href="css/cssn_whir.css" rel="stylesheet" type="text/css"/>
<script src="script/time.js" type="text/javascript"></script>
<script src="script/jquery-1.8.2.min.js" type="text/javascript"></script>
<script src="script/common.js" type="text/javascript"></script>
</head>
<body>
<!--头部-->
<div id="headern">
    <!--搜索-->
    <div class="topM">
        <div class="logo"><a href="index_index.action"><img src="images/logo.jpg"/></a></div>
        <div class="searchbox">
            <div class="search_box"><span class="left l_bg"></span> <span class="right r_bg"></span>
                <div class="search">
                    <form action="user_form.action" name=search_form onSubmit="return bottomForm(this);" target="_blank" method=post>
                        <select id="catid" class="enter" name="catid" type="hidden">
                            <option value="shoufei">收费</option>
                            <option value="free">免费</option>
                        </select>

                        <input id="q" class="enter1" name="infos"
                               onFocus="if(this.value==''){this.value='';}else{this.select();}this.style.color='black';"
                               value=""/>
                        <input class="sb" name="Input" type="submit" value=""/>
                    </form>
                </div>
            </div>
            <div class="hotkeywords">热点：<a href="#" target="_blank">广告资讯</a><a href="#" target="_blank">分类广告</a><a
                    href="#" target="_blank">供求广告</a></div>
        </div>
    </div>
    <!--顶部导航-->
    <div class="topB">
        <div class="nav">
            <ul>
                <li><a href="index_index.action" target="_blank">首页</a></li>
                <li><a href="mf_indexAddUI.action">发布免费信息</a></li>
                <li><a href="user_mfinfos.action" target="_blank">免费信息</a></li>
                <li><a href="user_sfinfos.action" target="_blank">收费信息</a></li>
            </ul>
        </div>
    </div>
</div>
<!--广告-->
<div class="ad"><img src="images/about.jpg"/></div>
<div class="clear_0"></div>
<!--中间内容-->
<div class="about">
    <div class="about_con">
        <s:form action="mf_uadd">
            <table width="100%" class="tab2" height="300">
                <tr>
                    <td valign="top">咨询标题：
                            <s:textfield name="title" cssClass="input2"/>
                </tr>
                <tr>
                    <td valign="top">咨询类别：
                            <s:select name="cid" cssClass="input2" list="#CategoryList" listKey="id" listValue="name"/>
                </tr>

                <tr>
                    <td valign="top">联系电话：
                            <s:textfield name="tel" cssClass="input2"/>
                </tr>
                <tr>
                    <td valign="top">信息内容：
                        <textarea name="text" class="input3" style="width:725px; height:199px;"></textarea></td>
                </tr>
            </table>
            <div class="button4">
                <input type="submit" class="button6"/>
                <input type="reset" class="button5" value="重置"/>
            </div>
        </s:form>
    </div>
</div>
<div class="clear_0"></div>
<!--底部-->
<div id="footer">
    <div class="link"><a href="#">关于我们</a>　|　<a href="#">联系我们</a>　|　<a href="#">加盟代理</a>　|　<a href="#">法律声明</a>　|　<a
            href="#">广告投放</a>　|　<a href="#">电子期刊</a>　|　<a href="#">在线留言</a></div>
    <div class="copyright">Copyright 2014 55同城网 All Rights Reserved. 皖ICP备07040713号 Designed</div>
</div>
</body>
</html>
