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
<%--后两行换自己图片--%>
    <link rel="bookmark" type="image/x-icon" href="static/img/background_img/logo.jpg">
    <link rel="shortcut icon" href="static/img/background_img/logo.jpg">
    <title>PET 🐈 ‍Web</title>
    <link rel="stylesheet" href="static/css/font_themepage.css" type="text/css"><%--字体样式_1--%>
    <link rel="stylesheet" href="static/css/font_moji.css" type="text/css"><%--字体样式_2--%>

    <style type="text/css">
<%-- 下方写成body:before会覆盖下方文字等 --%>
      body {
        content: ' ';
        position: fixed;
        top: 0;
        /*下方注意要放在一个目录下，要不无法解析*/
        background: url("static/img/background_img/background.jpg") center 0 no-repeat;
        right: 0;
        bottom: 0;
        left: 0;
        background-size: cover;
      }
    </style>

  </head>

  <body>
  <h1 class="neuesDemo">Hello world,アイウエオ:あいうえお.毎日ログイン登録かわいい可愛い</h1>
  <h2 class="neuesDemo">1234567890pet,cat,PET,CAT,DOG,dog,毎日ログイン登録かわいい可愛い</h2>
      <div id="main">
        <!-- Main first s-->
        <article id="me" class="panel">
          <header style="color: #000000">
            <h1>Reiwa Xr#令和星人</h1>
            <p class="font_instruction">日本は太平洋に浮かぶ島国で、人口が密集した都市、皇室の宮殿や御所、山岳地帯の国立公園、数千もの神社仏閣があります。沖縄の亜熱帯ビーチがある九州、東京や広島平和記念公園がある本州、スキーで有名な北海道を新幹線で行き来できます。首都の東京は、</p>
          </header>
          <a href="" class="jumplink pic">
            <span class="arrow icon fa-chevron-right"><span></span></span>
            <img src="static/img/cat/index_cat.jpg" alt="" />
          </a>
        </article>
        <!-- Main first e-->
      </div>

    <header>
      <form>
        <div class="neuesDemo">
          <input type="email" value="abcd@gmail.com" name="email" id="email">
          <input type="button" value="提交" name="button" id="button1" class="neuesDemo">
          <input type="button" value="提交" name="button" id="button2">
        </div>
      </form>
      <div>
        <span>アイウエオ</span>
        <span>あいうえお</span>
        <span>mirr毎日ログイン登録かわいい可愛いer</span>
      </div>
    </header>

    <footer>
      <div>
        <table>
          <tr>
            <td><button style="border: none;background-color: #ffffff;" class="neuesDemo">提交</button></td>
            <td>⬅️去过外线与颜色</td>
            <td><input type="button" value="提交" name="button" id="button4"></td>
            <td><input type="button" value="提交" name="button" id="button5"></td>
          </tr>
          <tr>
            <td><a href="index.jsp" class="under_line">第一个超链接标签<br/>(去过下划线,设置颜色_很基本)</a></td>
            <td><a href="index.jsp">第二个超链接标签</a></td>
            <td>2.3</td>
            <td>2.4</td>
          </tr>
          <tr>
            <td>3.1</td>
            <td>3.2</td>
            <td>3.3</td>
            <td>3.4</td>
          </tr>
          <tr>
            <td>4.1</td>
            <td>4.2</td>
            <td>4.3</td>
            <td>4.4</td>
          </tr>
        </table>
      </div>
    </footer>
    <div>
      <ul>
        <li>©2021 - 2022🏠日本工学院</li>
        <li></li>
        <li></li>
      </ul>
    </div>


  </body>
</html>
