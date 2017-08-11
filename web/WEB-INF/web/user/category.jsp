<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/13 0013 19:25
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","分类管理")}
${pageContext.setAttribute("tier",5)}
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
                <div class="row row_add_Cats">
                    <div class="col-lg-12 col-sm-12 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-bottom bordered-palegreen">
                                <span class="widget-caption">添加分类</span>
                            </div>
                            <div class="widget-body">
                                <div>
                                    <form class="form-horizontal form-bordered" role="form">
                                        <div class="form-group">
                                            <label for="addCatName" class="col-sm-2 control-label no-padding-right">分类名称</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="addCatName" placeholder="分类名称">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="addCatAlias" class="col-sm-2 control-label no-padding-right">分类别名</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="addCatAlias" placeholder="分类别名">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="addCatDesc" class="col-sm-2 control-label no-padding-right">分类描述</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="addCatDesc" placeholder="分类描述">
                                            </div>
                                        </div>
                                        <div class="form-group text-align-right">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen category_Save">
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
                <%--修改分类--%>
                <div class="row row_edit_Cats">
                    <div class="col-lg-12 col-sm-12 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-bottom bordered-palegreen">
                                <span class="widget-caption">修改分类</span>
                            </div>
                            <div class="widget-body">
                                <div>
                                    <form class="form-horizontal form-bordered" role="form">
                                        <div class="form-group">
                                            <label for="updateCatName" class="col-sm-2 control-label no-padding-right">分类名称</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="updateCatName" placeholder="分类名称">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="updateCatAlias" class="col-sm-2 control-label no-padding-right">分类别名</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="updateCatAlias" placeholder="分类别名">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="updateCatDesc" class="col-sm-2 control-label no-padding-right">分类描述</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="updateCatDesc" placeholder="分类描述">
                                            </div>
                                        </div>
                                        <div class="form-group text-align-right">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen category_Update">
                                                    <i class="btn-label glyphicon glyphicon-ok"></i>修改
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
                <%--添加分类END--%>
                <div class="row">
                    <div class="col-xs-12 col-md-12">
                        <div class="well with-header with-footer">
                            <div class="header bordered-sky">
                                ${pageScope.title}
                            </div>
                            <div class="text-align-right">
                                <a class="btn btn-success btn-xs add_Cats" name="add_Cats">
                                    <i class="fa fa-plus"></i>
                                    <span>添加分类</span>
                                </a>
                            </div>
                            <form class="search" method="get">
                                <div style="float:left;margin-right:2px;">
                                    <div class="form-group">
                                        <select name="search">
                                            <option value="id" <c:if test="${param.search=='id'}">selected="selected"</c:if>>ID</option>
                                            <option value="name" <c:if test="${param.search=='name'}">selected="selected"</c:if>>分类名</option>
                                            <option value="alias" <c:if test="${param.search=='alias'}">selected="selected"</c:if>>分类别名</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                            <span class="input-icon icon-right">
                                                <input type="text" value="${param.searchText}" name="searchText" class="form-control" placeholder="搜索分类">
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
                                        名称
                                    </th>
                                    <th>
                                        别名
                                    </th>
                                    <th>
                                        文章总数
                                    </th>
                                    <th>
                                        操作
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.page.list}" var="category">
                                        <tr id="data_category_${category.id}">
                                            <td>
                                                ${category.id}
                                            </td>
                                            <td class="col-md-2 category_name">
                                                ${category.name}
                                            </td>
                                            <td class="category_alias">
                                                ${category.alias}
                                            </td>
                                            <td class="col-md-2">
                                                <a href="#">${category.attr.newsCount}</a>
                                            </td>
                                            <td>
                                                <a class="btn btn-info btn-xs edit_category"><i class="fa fa-edit"></i> 编辑</a>
                                                <a class="btn btn-danger btn-xs" id="delete_category_${category.id}"><i class="fa fa-edit"></i> 删除</a>
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
<script type="text/javascript" src="/app/js/ajax/CategoryOpert.js"></script>
<%@ include file="include/footer.jsp"%>

