<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("tier",3)}
${pageContext.setAttribute("title","撰写新闻")}
<%@ include file="include/header.jsp"%>

<c:if test="${!empty param.id}">
    ${pageContext.setAttribute("title","修改新闻")}
</c:if>
<!-- Body -->
<body>
    <!-- Navbar -->
    <%@ include file="include/nav.jsp"%>
    <!-- /Navbar -->
    <!-- Main Container -->
    <div class="main-container container-fluid">
        <!-- Page Container -->
        <div class="page-container">
            <!-- Page Sidebar -->
            <%@ include file="include/sidebar.jsp"%>
            <!-- /Page Sidebar -->
            <!-- Page Content -->
            <div class="page-content">
                <!-- Page Breadcrumb -->
                <div class="page-breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="fa fa-home"></i>
                            <a href="#">首页</a>
                        </li>
                        <li>
                            <a href="#">${pageScope.title}</a>
                        </li>
                    </ul>
                </div>
                <!-- /Page Breadcrumb -->
                <!-- Page Header -->
                <div class="page-header position-relative">
                    <div class="header-title">
                        <h1>${pageScope.title}</h1>
                    </div>
                    <!--Header Buttons-->
                    <div class="header-buttons">
                        <a class="sidebar-toggler" href="#">
                            <i class="fa fa-arrows-h"></i>
                        </a>
                        <a class="refresh" id="refresh-toggler" href="">
                            <i class="glyphicon glyphicon-refresh"></i>
                        </a>
                        <a class="fullscreen" id="fullscreen-toggler" href="#">
                            <i class="glyphicon glyphicon-fullscreen"></i>
                        </a>
                    </div>
                    <!--Header Buttons End-->
                </div>
                <!-- /Page Header -->
                <!-- Page Body -->
                <div class="page-body">
                    <div class="row">
                        <div class="col-lg-12 col-sm-12 col-xs-12">
                                <div class="widget">
                                    <div class="widget-header bordered-bottom bordered-sky">
                                        <span class="widget-caption">${pageScope.title}</span>
                                    </div><!--Widget Header-->
                                    <div class="widget-body">
                                        <form action="" method="post">
                                            <input type="text" name="news_id" style="display:none" value="${requestScope.map.news.id}">
                                        <div class="margin-bottom-10">
                                            <span>新闻标题：</span>
                                            <input type="text" value="<c:out value="${requestScope.map.news.title}"></c:out>" class="form-control" name="news_title" placeholder="新闻标题">
                                        </div>
                                        <%--分类选择框--%>
                                        <div class="margin-bottom-10">
                                            <span>新闻分类：</span>
                                            <select name="new_category" id="e1" style="width:100%;">
                                                <c:forEach items="${requestScope.map.cat}" var="cat">
                                                    <c:choose>
                                                        <c:when test="${requestScope.map.news.category==cat.id}">
                                                            <option value="${cat.id}" selected="selected">${cat.name}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${cat.id}">${cat.name}</option>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </c:forEach>
                                            </select>
                                        </div>
                                        <textarea id="editorContent" name="content">${requestScope.map.news.text}</textarea>
                                        <div class="margin-top-10">
                                            <input type="text" value="${requestScope.map.news.tag}" name="tags" data-role="tagsinput" placeholder="键入内容回车添加标签">
                                        </div>
                                        <div class="margin-top-10 index-img">
                                            <input type="text" value="${requestScope.map.news.slideImg}" name="slideImg" placeholder="首页幻灯预览图（650*307）" class="form-control">
                                        </div>
                                        <div class="margin-top-10">
                                            <label>
                                                <input type="checkbox" name="impnews" <c:if test="${requestScope.map.news.impnews==1}">
                                                    checked="checked"
                                                </c:if>>
                                                <span class="text">推送到今日要闻</span>
                                            </label>
                                            <label>
                                                <input type="checkbox" name="slide" class="prope-index-img"
                                                <c:if test="${requestScope.map.news.slide==1}">
                                                       checked="checked"
                                                </c:if>>
                                                <span class="text">推送到首页幻灯</span>
                                            </label>
                                        </div>
                                        <div class="margin-top-5 text-align-right">
                                            <c:choose>
                                                <c:when test="${!empty param.id}">
                                                    <button type="button" class="btn btn-labeled btn-palegreen update_news">
                                                        <i class="btn-label glyphicon glyphicon-retweet"></i>
                                                        <span>确认修改</span>
                                                    </button>
                                                </c:when>
                                                <c:otherwise>
                                                    <button type="button" class="btn btn-labeled btn-palegreen push_news">
                                                        <i class="btn-label glyphicon glyphicon-retweet"></i>
                                                        <span>发布新闻</span>
                                                    </button>
                                                </c:otherwise>
                                            </c:choose>

                                        </div>

                                        </form>
                                    </div><!--Widget Body-->
                                </div><!--Widget-->
                        </div>
                    </div>
                </div>
                <!-- /Page Body -->
            </div>
            <!-- /Page Content -->
        </div>
        <!-- /Page Container -->
        <!-- Main Container -->
    </div>

<%@ include file="include/footerScript.jsp"%>
<%@ include file="include/editorLib.jsp"%>
<%@ include file="include/selectTagScript.jsp"%>
<script type="text/javascript" src="/app/js/ajax/pushNews.js"></script>
<%@ include file="include/footer.jsp"%>
