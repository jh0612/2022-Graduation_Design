<%--
  最后更新：2021-11-10毕设提交前此文件不再给予修改
  除了验证码的美化
  Created by IntelliJ IDEA.
  User: jh
  Date: 2021/10/25
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ja">
<head>
    <title>PET 🐈 ‍Web</title>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            //验证码
            $("#c2ode").click(function(){
                this.src = "${basePath}kaptcha.jpg?a=" + new Date();
            });

            $("#btn1").click(function () {
                //用户名：必须由字母，数字下划线组成，且长度为5到16位
                var nameText = $("#name").val();
                var namePatt = /^\w{5,16}$/;
                if (!namePatt.test(nameText)) {
                    $("span.errorMsg").text("ユーザーネームが使用不可");
                    return false;
                }
                //密码：必须由字母，数字下划线组成，且长度为5到16位
                var passwordText = $("#password1").val();
                var passwordPatt = /^\w{5,16}$/;
                if (!passwordPatt.test(passwordText)) {
                    $("span.errorMsg").text("パスワードが使用不可");
                    return false;
                }
                //确认密码：和密码相同
                var repwdText = $("#password2").val();
                if (repwdText != passwordText) {
                    $("span.errorMsg").text("同じパスワードを入力してください");
                    return false;
                }
                //邮箱：xxxxx@xxx.com
                var emailText = $("#email").val();
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPatt.test(emailText)) {
                    $("span.errorMsg").text("メールアドレスがちがう");
                    return false;
                }
                $("span.errorMsg").text("");
            });
        });
    </script>
</head>
<body>
<div id="Container">
    <%--导航栏--%>
    <ul id="menu"  class="menu_li">
        <li class="menu_li"><img src="static/img/background_img/logo.jpg" style="margin-top: -14px"></li>
        <li class="menu_li"><a href="index.jsp">ホームページ</a></li>
        <li class="menu_li"><a href="pages/group/group.jsp">チームメンバ</a></li>
        <li class="menu_li" style="float:right"><a href="pages/custom/regist.jsp">会員登録</a></li>
        <li class="menu_li" style="float:right"><a href="pages/custom/login.jsp">会員ログイン</a></li>
    </ul>
    <%-- 顶部header --%>
    <div id="header" class="header">
    </div>
    <%-- 主体上 --%>
    <%-- 主体下 --%>
    <div id="main">
        <div id="left"></div>

        <div id="center">
            <div id="center_up_regist">
                <img id="image" src="data:image/png;base64,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" >
            </div>
            <div id="zhuce" style="display: block;">
                <span class="errorMsg">
<%--                    ${requestScope.msg}--%>
                    ${empty requestScope.msg ? "ご登録！ありがとう":requestScope.msg}<%--EL表达式--%>
                </span>
                <form action="customerServlet" method="post">
                    <br>
                    <input type="hidden" name="action" value="regist"/>
                    <%--由于上方的隐藏域知道是注册--%>
                    <div class="input_control">
                        <input id="name" name="custname" type="text" class="form_input" placeholder="ユーザーネームを入力"/>
                    </div>
                    <div class="input_control">
                        <input id="password1" name="custpassword" type="password" class="form_input" placeholder="パスワードを入力">
                    </div>
                    <div class="input_control">
                        <input id="password2" name="pwdagain" type="password" class="form_input" placeholder="パスワードを確認">
                    </div>
                    <div class="input_control" style="text-align: -webkit-center;">
                        <label class="sex_set">男:<input name="custsex" value="1" type="radio" class="form_input" checked="checked" style="vertical-align:middle"></label>
                        <label class="sex_set" style="margin-top: 2px;">女:<input name="custsex" value="0"  type="radio" class="form_input" style="vertical-align:middle; "></label>
                    </div>
                    <div class="input_control">
                        <input id="email" name="custemail" type="text" class="form_input" placeholder="メールアドレスを入力"
                               value="${requestScope.custemail}"/>
                    </div>
                    <div class="input_control">
                        <input id="date" name="custbirth" type="date" class="form_input"
                               value="${requestScope.custbirth}"/>
                    </div>
                    <div class="input_control">
                        <input id="address" name="custaddress" type="text" class="form_input" placeholder="住所を入力"
                               value="${requestScope.custaddress}"/>
                    </div>
                    <div class="input_control">
                        <input id="code" name="code" type="text" class="form_input" placeholder="確認コードを入力"  />
                    </div>
                    <div class="input_control">
                        <%--宽度越大验证码越丑，有改进空间--%>
                        <img id="c2ode" class="form_input" src="kaptcha.jpg" alt="" style="margin: 0; width: 100%;">
                    </div>
                    <div class="input_control">
                        <input id="btn1" type="submit" class="form-input" value="新規登録">
                    </div>
                </form>
            </div>
            <script type="text/javascript">
                let name = document.getElementById("name");
                let password1 = document.getElementById("password1");
                let password2 = document.getElementById("password2");
                let email = document.getElementById("email");
                let date = document.getElementById("date");
                let address = document.getElementById("address");
                let code = document.getElementById("code");
                let btn1 = document.getElementById("btn1");
                let image = document.getElementById("image");
                //使用透明度属性，form不会走形
                //有没有循环的可能？？？
                name.onclick = function() {
                    image.style.opacity = "1";
                }
                email.onclick = function() {
                    image.style.opacity = "1";
                }
                address.onclick = function() {
                    image.style.opacity = "1";
                }
                code.onclick = function() {
                    image.style.opacity = "1";
                }
                btn1.onclick = function() {
                    image.style.opacity = "1";
                }
                password1.onclick = function() {
                    image.style.opacity = "0";
                }
                password2.onclick = function() {
                    image.style.opacity = "0";
                }
            </script>
            <div id="center_down_regist"></div>
        </div>
        <div id="right"></div>
    </div>
    <%-- copyright --%>
    <%@include file="/pages/common/copyright.jsp"%>
</div>
</body>
</html>