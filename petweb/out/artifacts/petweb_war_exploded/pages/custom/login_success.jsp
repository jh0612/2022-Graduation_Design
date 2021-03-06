<%--
  样式需要修改（3秒跳转？）
  Created by IntelliJ IDEA.
  User: jh
  Date: 2021/10/31
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ja">
<head>
    <title>PET 🐈 ‍Web</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
<div id="Container">
    <%--导航栏--%>
    <ul id="menu" class="menu_li">
        <li class="menu_li"><img src="static/img/background_img/logo.jpg" style="margin-top: -14px"></li>
        <li class="menu_li"><a href="index.jsp">ホームページ</a></li>
        <li class="menu_li"><a href="pages/group/group.jsp">チームメンバ</a></li>
        <li class="menu_li" style="float:right"><a href="pages/custom/regist.jsp">会員登録</a></li>
        <li class="menu_li" style="float:right"><a href="pages/custom/login.jsp">会員ログイン</a></li>
        <div class="clear"></div>
    </ul>

    <%-- 顶部header(页面最上方背景) --%>
    <div id="header" class="header">
        <br>
        <br>
        <br>

        <h1 style="text-align: center;margin: 0;">ログインしました！</h1>
    </div>


        <div id="header_under">
<%--～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～--%>
            <div id="header_under_left" class="header_underImg">
                <a href="showcase/petsServlet?dogorcat=dog&&action=page" dogorcat="dog">
                    <img src="static/img/dog/index_dog.jpg" width="200em">
                </a>
                <p style="">ワンちゃん</p>
            </div>
<%--～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～--%>
            <div id="header_under_right" class="header_underImg">
                <%-- 单纯黑色竖线 --%>
                <li class="menu_li" id="Layer1" style=" list-style-type: none; width:2px; height:170px; z-index:1; background-color: #8b8b8b; border: 1px none #000000; right: 143px; top: 263px"></li>
<%--                <a href="showcase/petsServlet?action=listForcat" dogorcat="cat">--%>
                <a href="showcase/petsServlet?dogorcat=cat&&action=page" dogorcat="cat">
                    <img src="static/img/cat/index_cat.png" width="200em">
                </a>
                <p>ネコちゃん</p>
            </div>
<%--～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～--%>
        </div>
        <div id="main">
            <div id="left"></div>
            <div id="center">

            </div>
            <div id="right"></div>
        </div>


<%-- copyright --%>
    <%@include file="/pages/common/copyright.jsp"%>
</div>
</body>
</html>
