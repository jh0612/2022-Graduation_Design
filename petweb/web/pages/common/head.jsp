<%--
  Created by IntelliJ IDEA.
  User: jh
  Date: 2021/10/31
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--base路径是否使用看最后调试情况--%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%--<%=basePath%>--%>
<base href="<%=basePath%>">
<%--网页小图标link后两行换自己图片--%>
<link rel="bookmark" type="image/x-icon" href="/static/img/background_img/logo.jpg">
<link rel="shortcut icon" href="static/img/background_img/logo.jpg">
<meta name = "viewport" content = "initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no" >
<%-- css文件link --%>
<link rel="stylesheet" href="static/css/font_themepage.css" type="text/css"><%--字体样式_1--%>
<link rel="stylesheet" href="static/css/font_moji.css" type="text/css"><%--字体样式_2--%>
<link rel="stylesheet" href="static/css/index_base.css" type="text/css"><%--整体页面框架--%>
<link rel="stylesheet" href="static/css/login_regist.css" type="text/css"><%--表单样式--%>
<%-- js文件link --%>
<script src="static/js/myStyle.js" type="text/javascript"></script>
