<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/13 0013 19:25
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","用户组管理")}
${pageContext.setAttribute("tier",7)}
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
                <div class="row row_add_userGroup">
                    <div class="col-lg-12 col-sm-12 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-bottom bordered-palegreen">
                                <span class="widget-caption">添加用户组</span>
                            </div>
                            <div class="widget-body">
                                <div>
                                    <form class="form-horizontal form-bordered" role="form">
                                        <div class="form-group">
                                            <label for="userGroupNameAdd" class="col-sm-2 control-label no-padding-right">名称：</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="userGroupNameAdd" placeholder="名称">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label no-padding-right">权限：</label>
                                            <div class="col-sm-10">
                                                <div class="col-lg-2 col-sm-2 col-xs-2">
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" name="" value="">
                                                            <span class="text">新闻管理</span>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-lg-2 col-sm-2 col-xs-2">
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" name="" value="">
                                                            <span class="text">撰写新闻</span>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-lg-2 col-sm-2 col-xs-2">
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" name="" value="">
                                                            <span class="text">评论管理</span>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-lg-2 col-sm-2 col-xs-2">
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" name="" value="">
                                                            <span class="text">分类管理</span>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group text-align-right">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen">
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
                <div class="row row_edit_userGroup">
                    <div class="col-lg-12 col-sm-12 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-bottom bordered-palegreen">
                                <span class="widget-caption">修改用户组</span>
                            </div>
                            <div class="widget-body">
                                <div>
                                    <form class="form-horizontal form-bordered" role="form">
                                        <div class="form-group">
                                            <label for="userGroupId" class="col-sm-2 control-label no-padding-right">ID：</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="userGroupId" placeholder="ID" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="userMail" class="col-sm-2 control-label no-padding-right">名称：</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="userMail" placeholder="名称">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label no-padding-right">权限：</label>
                                            <div class="col-sm-10">
                                                <div class="col-lg-2 col-sm-2 col-xs-2">
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" name="" value="" checked>
                                                            <span class="text">新闻管理</span>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-lg-2 col-sm-2 col-xs-2">
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" name="" value="">
                                                            <span class="text">撰写新闻</span>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-lg-2 col-sm-2 col-xs-2">
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" name="" value="" checked>
                                                            <span class="text">评论管理</span>
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col-lg-2 col-sm-2 col-xs-2">
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" name="" value="">
                                                            <span class="text">分类管理</span>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group text-align-right">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen">
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
                            <div class="text-align-right">
                                <a class="btn btn-success btn-xs add_userGroup" name="add_userGroup">
                                    <i class="fa fa-plus"></i>
                                    <span>添加用户组</span>
                                </a>
                            </div>
                            <form class="searchCats" method="get">
                                <div style="float:left;margin-right:2px;">
                                    <div class="form-group">
                                        <select name="searchCats">
                                            <option value="id">ID</option>
                                            <option value="title">名称</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                            <span class="input-icon icon-right">
                                                <input type="text" name="searchContent" class="form-control" placeholder="搜索分类">
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
                                        用户组名称
                                    </th>
                                    <th>
                                        权限
                                    </th>
                                    <th>
                                        操作
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                    <td>
                                        1
                                    </td>
                                    <td>
                                        普通用户
                                    </td>
                                    <td class="col-lg-4">
                                        新闻管理、撰写新闻、评论管理
                                    </td>
                                    <td>
                                        <a href="#" class="btn btn-info btn-xs edit_userGroup" name="edit_userGroup"><i class="fa fa-edit"></i> 编辑</a>
                                        <a href="#" class="btn btn-danger btn-xs edit"><i class="fa fa-edit"></i> 删除</a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="margin-top-30 text-align-right">
                                <div class="next">
                                    <ul class="pagination">
                                        <li class="disabled"><a href="#">«</a></li>
                                        <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">»</a></li>
                                    </ul>
                                </div>
                            </div>
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
<%@ include file="include/selectTagScript.jsp"%>
<%@ include file="include/footer.jsp"%>

