<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","用户中心")}
${pageContext.setAttribute("tier",1)}
<!-- /Head -->
<%@ include file="include/header.jsp"%>
<!-- /Head -->
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
                    <!--公告区-->
                    <div class="row">
                        <div class="col-lg-12 col-sm-12 col-xs-12">
                            <div class="widget">
                                <div class="widget-header bordered-bottom bordered-sky">
                                    <span class="widget-caption"><i class="fa  fa-volume-up"></i>
                                        公告
                                    </span>
                                    <div class="widget-buttons">
                                        <a>
                                            <i class="fa fa-clock-o blue"><span
                                                    style="font-size: 12px !important;letter-spacing: normal">
                                                <m:dateFormat time="${requestScope.map.notice.updated}">

                                                </m:dateFormat>
                                                <%--${requestScope.map.notice.updated}--%>
                                            </span>&nbsp;
                                            </i>
                                        </a>
                                        <a href="#" data-toggle="dispose">
                                            <i class="fa fa-times darkorange"></i>
                                        </a>
                                    </div>
                                </div><!--Widget Header-->
                                <div class="widget-body">
                                    <p>${requestScope.map.notice.value}</p>
                                </div><!--Widget Body-->
                            </div><!--Widget-->
                        </div>
                    </div>
                    <!--首页四栏-->
                    <div class="row">
                        <div class="col-lg-3 col-sm-6 col-xs-12">
                            <div class="databox radius-bordered databox-shadowed databox-graded databox-vertical">
                                <div class="databox-top bg-blue">
                                    <div class="databox-icon">
                                        <i class="fa fa-clock-o"></i>
                                    </div>
                                </div>
                                <div class="databox-bottom text-align-center">
                                    <span class="databox-text">当前时间</span>
                                    <span class="databox-text">
                                        ${requestScope.map.nowTime}
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6 col-xs-12">
                            <div class="databox radius-bordered databox-shadowed databox-graded databox-vertical">
                                <div class="databox-top bg-red">
                                    <div class="databox-icon">
                                        <i class="fa fa-tasks"></i>
                                    </div>
                                </div>
                                <div class="databox-bottom text-align-center">
                                    <span class="databox-text">新闻总数</span>
                                    <span class="databox-text">${requestScope.map.newsCount}篇</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6 col-xs-12">
                            <div class="databox radius-bordered databox-shadowed databox-graded databox-vertical">
                                <div class="databox-top bg-green">
                                    <div class="databox-icon">
                                        <i class="fa fa-comments-o"></i>
                                    </div>
                                </div>
                                <div class="databox-bottom text-align-center">
                                    <span class="databox-text">总评论数</span>
                                    <span class="databox-text">${requestScope.map.commentsCount}条</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6 col-xs-12">
                            <div class="databox radius-bordered databox-shadowed databox-graded databox-vertical">
                                <div class="databox-top bg-warning">
                                    <div class="databox-icon">
                                        <i class="fa fa-tachometer"></i>
                                    </div>
                                </div>
                                <div class="databox-bottom text-align-center">
                                    <span class="databox-text">分录目录数</span>
                                    <span class="databox-text">${requestScope.map.categoryCount}类</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--四栏结束-->

                </div>
                <!-- /Page Body -->
            </div>
            <!-- /Page Content -->
        </div>
        <!-- /Page Container -->
        <!-- Main Container -->

    </div>
<%@ include file="include/footerScript.jsp"%>
<%@ include file="include/footer.jsp"%>
