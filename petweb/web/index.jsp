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
    <link rel="bookmark" type="image/x-icon" href="static/img/background_img/logo.jpg">
    <link rel="shortcut icon" href="static/img/background_img/logo.jpg">

    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>PET 🐈 ‍Web</title>
<%-- css文件link --%>
    <link rel="stylesheet" href="static/css/font_themepage.css" type="text/css"><%--字体样式_1--%>
    <link rel="stylesheet" href="static/css/font_moji.css" type="text/css"><%--字体样式_2--%>
    <link rel="stylesheet" href="static/css/index_base.css" type="text/css"><%--整体页面框架--%>
<%-- js文件link --%>
    <script src="static/js/myStyle.js" type="text/javascript"></script>
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
            background: url("static/img/background_img/background_head.jpg") no-repeat;
            background-size: 100% 100%;
            -webkit-background-size: 100% 100%;
      }
    </style>


  </head>

  <body>
  <div id="Container">
<%--导航栏--%>
    <div id="navigation">

    </div>
<%-- 顶部header --%>
    <div id="header" class="header">
        <p>顶部</p>
    </div>
<%-- 主体 --%>
    <div id="main">
      <div id="left">1<br>1<br>1<br>1<br>11111111<br>1<br>1<br>1<br>1<br>1br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>11<br>1<br>1<br>1<br>1<br>1<br>br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>11<br>1<br>1<br>1<br>1<br>1<br><br>1<br>1<br>11<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br></div>
      <div id="center">2222</div>
      <div id="right">3333</div>
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
