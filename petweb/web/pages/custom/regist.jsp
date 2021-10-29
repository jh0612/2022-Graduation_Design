<%--
  Created by IntelliJ IDEA.
  User: jh
  Date: 2021/10/25
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--网页小图标link后两行换自己图片--%>
    <link rel="bookmark" type="image/x-icon" href="../../static/img/background_img/logo.jpg">
    <link rel="shortcut icon" href="../../static/img/background_img/logo.jpg">
    <meta name = "viewport" content = "initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no" >
    <%--    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />--%>
    <title>PET 🐈 ‍Web</title>
    <%-- css文件link --%>
    <link rel="stylesheet" href="../../static/css/font_themepage.css" type="text/css"><%--字体样式_1--%>
    <link rel="stylesheet" href="../../static/css/font_moji.css" type="text/css"><%--字体样式_2--%>
    <link rel="stylesheet" href="../../static/css/index_base.css" type="text/css"><%--整体页面框架--%>
    <link rel="stylesheet" href="../../static/css/login_regist.css" type="text/css"><%--表单样式--%>
    <%-- js文件link --%>
    <script src="../..//static/js/myStyle.js" type="text/javascript"></script>
    <style type="text/css">
        <%-- 下方写成body:before会覆盖下方文字等 --%>
        body{
            content: ' ';
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            background-size: cover;
        }
        .header {
            /*下方注意要放在一个目录下，要不无法解析*/
            weight: 100%;
            background: url("../../static/img/background_img/background_head.jpg") no-repeat 0;
            background-size: 100% 100%;
            -webkit-background-size: 100% 100%;
        }
    </style>


</head>

<body>
<div id="Container">
    <%--导航栏--%>
    <ul id="menu"  class="menu_li">
        <li class="menu_li"><img src="../../static/img/background_img/logo.jpg" style="margin-top: -14px"></li>
        <li class="menu_li"><a href="../../index.jsp">ホームページ</a></li>
        <li class="menu_li"><a href="../../pages/group/group.jsp">チームメンバ</a></li>
        <li class="menu_li" style="float:right"><a href="../../pages/custom/regist.jsp">会員登録</a></li>
        <li class="menu_li" style="float:right"><a href="../../pages/custom/login.jsp">会員ログイン</a></li>
    </ul>

    <%-- 顶部header --%>
    <div id="header" class="header">
    </div>
    <%-- 主体上 --%>
    <%-- 主体下 --%>
    <div id="main">
        <div id="left"></div>

        <div id="center">
            <form action="" method="get">
                <div class="input_control">
                    <input type="text" class="form_input" placeholder="ユーザーネームを入力"/>
                </div>
                <div class="input_control">
                    <input type="password" class="form_input" placeholder="パスワードを入力">
                </div>
                <div class="input_control">
                    <input type="password" class="form_input" placeholder="パスワードを確認">
                </div>
                <div class="input_control" style="text-align: -webkit-center;">
                    <input type="radio" class="form_input" checked="checked" style="vertical-align:middle"><label>男性:</label>
                    <input type="radio" class="form_input" style="vertical-align:middle; "><label>女性:</label>
                </div>
                <div class="input_control">
                    <input type="text" class="form_input" placeholder="メールアドレスを入力"/>
                </div>
                <div class="input_control">
                    <input type="date" class="form_input" placeholder="メールアドレスを入力"/>
                </div>
                <div class="input_control">
                    <input type="text" class="form_input" placeholder="住所を入力"/>
                </div>
                <div class="input_control">
                    <input type="text" class="form_input" placeholder="確認コードを入力" name="code" id="code"/>
                </div>
                <div class="input_control">
                    <img alt="" src="../../static/img/code.jpg" class="form_input" style="margin: 0;">
                </div>

                <div class="input_control">
                    <input id="btn1" type="submit" class="form-input" value="新規登録">
                </div>
            </form>
        </div>

        <div id="right"></div>
    </div>
    <%-- copyright --%>
    <div id="footer" align="center">
        <span>©2021-現在 🏠 日本工学院　卒業制作 </span><br/>
        <span>©2021-現在 🏠 ITカレッジ　情報処理科</span><br/>
        <span>©2021-現在 🏠 CD65-02_グループⅣ</span><br/>
    </div>

</div>
</body>
</html>
