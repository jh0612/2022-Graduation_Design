<%--
  此文件如果没什么特殊的本应该为html静态的即可嫌麻烦先不予以修改
  Created by IntelliJ IDEA.
  User: jh
  Date: 2021/10/30
  Time: 00:04
  To change this template use File | Settings | File Templates.
  文档字体需要修改，外加：如有时间每人头像框动态效果外加头像框link；有没有必要分两竖列？？？
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ja">
<head>
    <title>PET 🐈 ‍Web</title>
    <%@include file="/pages/common/head.jsp"%>
    <link rel="stylesheet" href="static/css/group_use.css" type="text/css"><%--group专用--%>
</head>

<body>
<div id="Container">
    <%--导航栏--%>
    <ul id="menu" class="menu_li" >
        <li class="menu_li"><img src="static/img/background_img/logo.jpg" style="margin-top: -14px"></li>
        <li class="menu_li"><a href="index.jsp">ホームページ</a></li>
        <li class="menu_li"><a href="#aboutwe">チームメンバ</a></li><%--此页跳转与否再议--%>
        <li class="menu_li" style="float:right"><a href="pages/custom/regist.jsp">会員登録</a></li>
        <li class="menu_li" style="float:right"><a href="pages/custom/login.jsp">会員ログイン</a></li><%--此页跳转与否再议--%>
    </ul>

    <%-- 顶部header --%>
    <div id="header" class="header">
    </div>
    <%-- 主体上 --%>
        <div><span id="member_title" style="margin: 0.1em auto;">メンバーリスト</span></div>

    <%-- 主体下 --%>
    <div id="main">
        <div id="left"></div>

        <div id="center">
            <div class="group" >
                <a href="http://jh0612.github.io/"><img src="static/img/group/jiang.jpg" oncontextmenu="return false;" onselect="return false;"></a>
                <h3 class="title">蒋　皓</h3>
                <Span class="post">プロジェクトリーダー</Span>
            </div>

            <div class="group">
                <a><img src="static/img/group/zhang.jpg"></a>
                <h3 class="title">張　通</h3>
                <Span class="post">進 捗 管 理</Span>
            </div>
            <div class="group">
                <a><img src="static/img/group/wang.jpg"></a>
                <h3 class="title">王  志仁</h3>
                <Span class="post">設 計 工 程</Span>
            </div>
            <div class="group">
                <a><img src="static/img/group/su.jpg"></a>
                <h3 class="title">蘇  魁</h3>
                <Span class="post">実 装 工 程</Span>
            </div>
            <div class="group">
                <a><img src="static/img/group/song.jpg"></a>
                <h3 class="title">宋 文静</h3>
                <Span class="post">テスト 工 程</Span>
            </div>
            <div class="group">
                <a><img src="static/img/group/zheng.jpg"></a>
                <h3 class="title">鄭 博今</h3>
                <Span class="post">ドキュメント 管 理</Span>
            </div>

        </div>
        <div id="right"></div>
    </div>
        <%-- copyright --%>
        <%@include file="/pages/common/copyright.jsp"%>
</div>
</body>
</html>
