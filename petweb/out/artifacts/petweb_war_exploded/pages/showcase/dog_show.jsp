<%--
  此jsp文件毕设前再做修改也就是
  ①添加收藏按钮
  ②每个单独宠物的详细信息跳转页面（使用${pets.petsname}属性来确定）
  cat_show.jsp一样
  Created by IntelliJ IDEA.
  User: jh
  Date: 2021/11/09
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ja">
<head>
    <title>PET 🐈 ‍Web</title>
    <%@include file="/pages/common/head.jsp" %>

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
    </div>

    <div id="main">
        <div id="left"></div>
        <div id="center">
            <%--遍历所有的dog--%>
            <c:forEach items="${requestScope.page.items}" var="pets"><%--这里的var下方使用调用各个值--%>
                <div class="show_animal">
            <span>
                <img class="imgforanimal" src="${pets.picture}" alt="">
            </span>
                    <br>
                    <span class="instructtext">
                <span><a class="animalname" href="#">${pets.petsname}</a><br>
                    <p class="animaltext">------------------------------<br>
                    ${pets.instruction}
                    </p>
                </span>
            </span>
                </div>
            </c:forEach>

            <%--〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜页码〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜--%>
            <div id="page_nav">
                <%-- 非首页才显示 --%>
                <c:if test="${requestScope.page.pageNo > 1}">
                    <a href="showcase/petsServlet?dogorcat=dog&&action=page&pageNo=1">Top</a>
                    <a href="showcase/petsServlet?dogorcat=dog&&action=page&pageNo=${requestScope.page.pageNo-1}">Last</a>
                </c:if>

                <%--页码输出的开始--%>
                <c:choose>
                    <%--情况1：如果总页码小于等于5的情况，页码的范围是：1-总页码--%>
                    <c:when test="${ requestScope.page.pageTotal <= 5 }">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="${requestScope.page.pageTotal}"/>
                    </c:when>
                    <%--情况2：总页码大于5的情况--%>
                    <c:when test="${requestScope.page.pageTotal > 5}">
                        <c:choose>
                            <%--小情况1：当前页码为前面3个：1，2，3的情况，页码范围是：1-5.--%>
                            <c:when test="${requestScope.page.pageNo <= 3}">
                                <c:set var="begin" value="1"/>
                                <c:set var="end" value="5"/>
                            </c:when>
                            <%--小情况2：当前页码为最后3个，8，9，10，页码范围是：总页码减4 - 总页码--%>
                            <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
                                <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                                <c:set var="end" value="${requestScope.page.pageTotal}"/>
                            </c:when>
                            <%--小情况3：4，5，6，7，页码范围是：当前页码减2 - 当前页码加2--%>
                            <c:otherwise>
                                <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                                <c:set var="end" value="${requestScope.page.pageNo+2}"/>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                </c:choose>

                <c:forEach begin="${begin}" end="${end}" var="i">
                    <c:if test="${i == requestScope.page.pageNo}">
                        【${i}】
                    </c:if>
                    <c:if test="${i != requestScope.page.pageNo}">
                        <a href="showcase/petsServlet?dogorcat=dog&&action=page&&pageNo=${i}">${i}</a>
                    </c:if>
                </c:forEach>
                <%--页码输出的结束--%>

                <%-- 如果是最后一页则不显示末页和下一页 --%>
                <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
                    <a href="showcase/petsServlet?dogorcat=dog&&action=page&pageNo=${requestScope.page.pageNo+1}">Next</a>
                    <a href="showcase/petsServlet?dogorcat=dog&&action=page&pageNo=${requestScope.page.pageTotal}">End</a>
                </c:if>

                ${requestScope.page.pageNo}/${requestScope.page.pageTotal} total:${requestScope.page.pageTotalCount}
                To<input value="${param.pageNo}" name="pn" id="pn_input" style="width: 40px"/>
                <input id="searchPageBtn" type="button" value="確認">

                <script type="text/javascript">
                    $(function () {
                        //跳到指定页码
                        $("#searchPageBtn").click(function () {
                            var pageNo = $("#pn_input").val();
                            if (pageNo < 1 && pageNo > ${requestScope.page.pageTotal}) {
                            } else {
                                window.location.href = "${pageScope.basePath}showcase/petsServlet?dogorcat=dog&&action=page&pageNo=" + pageNo;
                            }
                        });
                    });
                </script>
            </div>
        </div>
        <%--〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜--%>


        <div id="right"></div>
    </div>
    <%-- copyright --%>
    <%@include file="/pages/common/copyright.jsp" %>

</div>
</body>
</html>