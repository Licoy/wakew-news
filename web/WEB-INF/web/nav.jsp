<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/16 0016 14:38
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div id="banner">
        <div class="topBar">
            <ul>
                <li><a href="/">瓦客新闻网</a></li>
                <li><a target="_blank" href="/newest.html">最新榜</a></li>
                <li><a target="_blank" href="/hotsearch.html">热搜榜</a></li>
                <li><a target="_blank" href="/luck.html">试试手气</a></li>
            </ul>
        </div>
        <span class="l">|</span>
        <div class="tools">
            <ul>
                <li><a href="#">网站地图</a></li>
                <li><a href="#">在线帮助</a></li>
                <li><a href="#">反馈建议</a></li>
            </ul>
        </div>
        <div class="reg_login">
            <ul>
                <c:choose>
                    <c:when test="${!empty sessionScope.id}">
                        <li><a href="/u/index.html"><i class="fa fa-user"></i>${sessionScope.name}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/register.html"><i class="fa fa-user-plus"></i>注册</a></li>
                        <li><a href="/login.html"><i class="fa fa-user"></i>登录</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
    <div class="clear_float"></div>
    <div id="brand">
        <div class="logo">
            <a href="/" title="瓦客新闻">
                <img src="${requestScope.map.header.logourlSet}" title="瓦客新闻" alt="瓦客新闻" class=""/>
            </a>
        </div>
        <div class="search">
            <form method="get">
                <input id="searchText" value="${param.s}" name="s" type="text" placeholder="${requestScope.map.header.searchSet}">
                <button id="searchSubmit" type="button"><i class="fa fa-search"></i>搜索</button>
            </form>
        </div>
    </div>
    <div class="clear_float"></div>
</header>
<nav>
    <div id="navBar">
        <ul>
            <li><a href="/" <c:if test="${pageScope.type=='index'}">class="active"</c:if>>首页</a></li>
            <c:forEach items="${requestScope.map.header.nav}" var="nav" begin="0" end="13">
                <li><a href="/category/${nav.alias}" <c:if test="${nav.alias==param.category}">class="active"</c:if>>${nav.name}</a></li>
            </c:forEach>
        </ul>
    </div>
</nav>
