<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/13 0013 19:25
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","用户管理")}
${pageContext.setAttribute("tier",6)}
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
                <div class="row row_edit_user">
                    <div class="col-lg-12 col-sm-12 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-bottom bordered-palegreen">
                                <span class="widget-caption">修改用户</span>
                            </div>
                            <div class="widget-body">
                                <div>
                                    <form class="form-horizontal form-bordered" role="form">
                                        <div class="form-group">
                                            <label for="userID" class="col-sm-2 control-label no-padding-right">ID</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="userID" placeholder="ID" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="userName" class="col-sm-2 control-label no-padding-right">用户名</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="userName" placeholder="用户名">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="userMail" class="col-sm-2 control-label no-padding-right">邮箱</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="userMail" placeholder="邮箱">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="userGroup" class="col-sm-2 control-label no-padding-right">用户组</label>
                                            <div class="col-sm-10">
                                                <select id="userGroup" style="width: 100%">
                                                    <c:forEach items="${requestScope.page.list}" var="list" begin="0" end="0">
                                                        <c:forEach items="${list.attr.groups}" var="groups">
                                                            <option class="optionGroup_${groups.id}" value="${groups.id}">${groups.name}</option>
                                                        </c:forEach>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="userCreated" class="col-sm-2 control-label no-padding-right">注册时间</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="userCreated" placeholder="注册时间" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="userLastLogin" class="col-sm-2 control-label no-padding-right">上次登录时间</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="userLastLogin" placeholder="上次登录时间" disabled>
                                            </div>
                                        </div>
                                        <div class="form-group text-align-right">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen" id="update_Save">
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
                                            <option value="id" <c:if test="${param.search=='id'}">selected="selected"</c:if>>ID</option>
                                            <option value="username" <c:if test="${param.search=='username'}">selected="selected"</c:if>>用户名</option>
                                            <option value="usermail" <c:if test="${param.search=='usermail'}">selected="selected"</c:if>>邮箱</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                            <span class="input-icon icon-right">
                                                <input type="text" value="${param.searchText}" name="searchText" class="form-control" placeholder="搜索用户">
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
                                        用户名
                                    </th>
                                    <th>
                                        邮箱
                                    </th>
                                    <th>
                                        用户组
                                    </th>
                                    <th>
                                        评论总数
                                    </th>
                                    <th>
                                        操作
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.page.list}" var="user">
                                    <tr id="data_user_${user.id}">
                                        <td>
                                            ${user.id}
                                        </td>
                                        <td>
                                            ${user.username}
                                        </td>
                                        <td>
                                            ${user.usermail}
                                        </td>
                                        <td>
                                            ${user.attr.group.name}
                                        </td>
                                        <td>
                                            <a target="_blank" href="comments.html?search=user&searchText=${user.id}">${user.attr.commentsNum}</a>
                                        </td>
                                        <td>
                                            <a href="#" class="btn btn-info btn-xs edit_user_${user.id}"><i class="fa fa-edit"></i> 编辑</a>
                                            <a href="#" class="btn btn-danger btn-xs edit" id="delete_user_${user.id}"><i class="fa fa-edit"></i> 删除</a>
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
<%@ include file="include/selectTagScript.jsp"%>
<script type="text/javascript" src="/app/js/ajax/UserOpter.js"></script>
<%@ include file="include/footer.jsp"%>

