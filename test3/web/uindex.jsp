<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>55同城网</title>
    <link href="css/css_whir.css" rel="stylesheet" type="text/css"/>
    <script src="script/time.js" type="text/javascript"></script>
    <script src="script/jquery-1.8.2.min.js" type="text/javascript"></script>
    <script src="script/common.js" type="text/javascript"></script>
    <script src="script/regist.js" type="text/javascript"></script>
    <script type="text/javascript" src="script/jquery1.42.min.js"></script>
    <script type="text/javascript" src="script/jquery.SuperSlide.2.1.1.js"></script>
    <script type="text/javascript" src="script/column.js"></script>
    <script type="text/javascript" src="script/min_contentslider.js"></script>
</head>
<body>
<!--头部-->
<div id="header">
    <!--搜索-->
    <div class="topM">
        <div class="logo"><a href="#"><img src="images/logo.jpg"/></a></div>
        <div class="searchbox">
            <div class="search_box"><span class="left l_bg"></span> <span class="right r_bg"></span>
                <div class="search">
                    <form action="user_form.action" onSubmit="return bottomForm(this);" target="_blank" method=post>
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
            <!-- <div class="hotkeywords">热点：<a href="#" target="_blank">广告资讯</a><a href="#" target="_blank">分类广告</a><a href="#" target="_blank">供求广告</a></div> -->
        </div>
    </div>
</div>
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
<!--广告-->
<!--中间内容-->
<div id="container">
    <div class="left205">
        <!--会员登录-->
        <div class="hylogoin">
            <div class="memberh">
                <div id="registration">
                    <a href="user_loginUI.action" target="_blank"><img src="images/bmrk.jpg" width="200px"
                                                                       height="240px"/></a>
                </div>
                <!--    <ul class="list">
                     <li>·<a href="#" target="_blank">A</a></li>
                     <li>·<a href="#" target="_blank">B</a></li>
                     <li>·<a href="#" target="_blank">C</a></li>
                     <li>·<a href="#" target="_blank">D</a></li>
                   </ul>-->
            </div>
        </div>
        <!--推荐企业-->
        <div class="tjqy">
            <div class="title1">
                <h1>友情链接</h1>
            </div>
            <ul class="list1">
                <li><a href="http://www.baidu.com/">百度</a></li>
                <li><a href="http://www.tmall.com">天猫</a></li>
                <li><a href="http://www.mi.com">小米</a></li>
                <li><a href="http://www.sina.com.cn/">新浪</a></li>
            </ul>
        </div>
    </div>
    <!--右侧内容-->
    <div class="right775">
        <div class="news">
            <IMG src="images/2_1.jpg" width=770
                 height=270>
        </div>
        <!--相关信息-->
        <div class="con">
            <div class="column">
                <div class="title4">
                    <h1>免费信息</h1>
                </div>
                <ul class="list2">
                    <s:iterator value="MianfeiList">
                        <li><span>${addtime }</span><a href="#">${title }</a></li>
                    </s:iterator>
                </ul>
            </div>
            <div class="column" style="float:right">
                <div class="title4">
                    <h1>收费信息</h1>
                </div>
                <ul class="list2">
                    <s:iterator value="slist">

                        <li><span>${addtime }</span><a href="#">${title }</a></li>
                    </s:iterator>
                </ul>
            </div>
        </div>
        <!--广告-->
    </div>
</div>
</div>
<div class="clear_0"></div>
<!--底部-->
<div id="footer">
    <div class="link"><a href="#">关于我们</a>　|　<a href="#">联系我们</a>　|　<a href="#">加盟代理</a>　|　<a href="#">法律声明</a>　|　<a
            href="#">广告投放</a>　|　<a href="#">电子期刊</a>　|　<a href="#">在线留言</a></div>
    <div class="copyright">Copyright 2014 55同城网 All Rights Reserved. 皖ICP备07040713号 Designed</div>
</div>
<!--在线客服-->

</body>
</html>