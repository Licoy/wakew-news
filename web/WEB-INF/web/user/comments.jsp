<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/13 0013 19:25
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","所有评论")}
${pageContext.setAttribute("tier",4)}
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
                <div class="row row_edit_comments">
                    <div class="col-lg-12 col-sm-12 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-bottom bordered-palegreen">
                                <span class="widget-caption">修改评论</span>
                            </div>
                            <div class="widget-body">
                                <div>
                                    <form class="form-horizontal form-bordered" role="form">
                                        <div class="form-group">
                                            <span class="input-icon icon-right">
                                                <textarea id="editCommentsText" style="width: 80%;margin: 0 auto;resize: none" class="form-control" rows="5"></textarea>
                                            </span>
                                        </div>
                                        <div class="form-group text-align-right">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen editSave">
                                                    <i class="btn-label glyphicon glyphicon-ok"></i>保存
                                                </a>
                                                <a href="javascript:void(0);" class="btn btn-labeled btn-yellow alterCanal">
                                                    <i class="btn-label glyphicon glyphicon-remove"></i>取消
                                                </a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-md-12">
                        <div class="well with-header with-footer">
                            <div class="header bordered-sky">
                                ${pageScope.title}
                            </div>
                            <form class="search" method="get">
                                <div style="float:left;margin-right:2px;">
                                    <div class="form-group">
                                        <select name="search">
                                            <option value="id" <c:if test="${param.search=='id'}">selected="selected"</c:if>>评论ID</option>
                                            <option value="user" <c:if test="${param.search=='user'}">selected="selected"</c:if>>作者ID</option>
                                            <option value="news" <c:if test="${param.search=='news'}">selected="selected"</c:if>>新闻ID</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                            <span class="input-icon icon-right">
                                                <input type="text" value="${param.searchText}" name="searchText" class="form-control" placeholder="搜索评论">
                                                <i class="fa fa-search"></i>
                                            </span>
                                    </div>
                                </div>
                            </form>
                            <table class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>
                                        ID
                                    </th>
                                    <th>
                                        内容
                                    </th>
                                    <th>
                                        作者
                                    </th>
                                    <th>
                                        对应文章
                                    </th>
                                    <th>
                                        时间
                                    </th>
                                    <th>
                                        操作
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.page.list}" var="comments">
                                    <tr id="data_comments_${comments.id}">
                                        <td>
                                            ${comments.id}
                                        </td>
                                        <td class="commentsText">
                                            ${comments.text}
                                        </td>
                                        <td>
                                            ${comments.attr.author}
                                        </td>
                                        <td class="newsTitle">
                                            <a target="_blank" href="newsAll.html?search=id&searchText=${comments.attr.news.id}">《${comments.attr.news.title}》</a>
                                        </td>
                                        <td>
                                            <m:dateFormat time="${comments.issuedate}">

                                            </m:dateFormat>
                                        </td>
                                        <td>
                                            <a href="#" class="btn btn-info btn-xs edit_comments"><i class="fa fa-edit"></i> 编辑</a>
                                            <a class="btn btn-danger btn-xs edit" id="delete_comments_${comments.id}"><i class="fa fa-edit"></i> 删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                            <%@include file="include/page.jsp"%>
                        </div>
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
<script type="text/javascript" src="/app/js/ajax/CommentsUpdate.js"></script>
<%@ include file="include/footer.jsp"%>

