<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/13 0013 19:25
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","所有新闻")}
${pageContext.setAttribute("tier",2)}
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
                <div class="row">
                    <div class="col-xs-12 col-md-12">
                        <div class="well with-header with-footer">
                            <div class="header bordered-sky">
                                ${pageScope.title}
                            </div>
                            <form class="searchNews" method="get">
                                <div style="float:left;margin-right:2px;">
                                    <div class="form-group">
                                        <select name="search">
                                            <option value="id" <c:if test="${param.search=='id'}">selected="selected"</c:if>>ID</option>
                                            <option value="title" <c:if test="${param.search=='title'}">selected="selected"</c:if>>新闻标题</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                            <span class="input-icon icon-right">
                                                <input type="text" name="searchText" value="${param.searchText}" class="form-control" placeholder="搜索新闻">
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
                                        标题
                                    </th>
                                    <th>
                                        作者
                                    </th>
                                    <th>
                                        评论
                                    </th>
                                    <th>
                                        浏览量
                                    </th>
                                    <th>
                                        最后修改时间
                                    </th>

                                    <th>
                                        操作
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.page.list}" var="news">
                                    <tr id="data_news_${news.id}">
                                        <td>
                                            ${news.id}
                                        </td>
                                        <td class="col-md-4">
                                            ${news.title}
                                        </td>
                                        <td>
                                            ${news.attr.author}
                                        </td>
                                        <td>
                                            <a href="#">${news.attr.commentsCount}</a>
                                        </td>
                                        <td>
                                            ${news.views}
                                        </td>
                                        <td>
                                            <m:dateFormat time="${news.updated}">

                                            </m:dateFormat>
                                        </td>
                                        <td>
                                            <a href="editor.html?id=${news.id}" class="btn btn-info btn-xs"><i class="fa fa-edit"></i> 编辑</a>
                                            <a href="/category/${news.attr.cat.alias}/${news.id}.html" target="_blank" class="btn btn-success btn-xs"><i class="fa fa-eye"></i> 查看</a>
                                            <a class="btn btn-danger btn-xs" id="delete_news_${news.id}"><i class="fa fa-trash"></i> 删除</a>
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
<%@ include file="include/footer.jsp"%>

