<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","修改资料")}
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
                    <h5 class="row-title before-green"><i class="fa fa-tags green"></i>资料修改</h5>
                    <div class="row">
                        <div class="col-lg-6 col-sm-6 col-xs-12">
                            <div class="widget">
                                <div class="widget-header bordered-bottom bordered-palegreen">
                                    <span class="widget-caption">修改密码</span>
                                </div>
                                <div class="widget-body">
                                    <div>
                                        <form class="form-horizontal form-bordered" role="form" id="passwordForm">
                                            <input type="text" name="type" value="alterPassword" hidden>
                                            <div class="form-group">
                                                <label for="oldPassword" class="col-sm-2 control-label no-padding-right">原密码</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="oldPassword" id="oldPassword" placeholder="原密码">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="newPassword" class="col-sm-2 control-label no-padding-right">新密码</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="newPassword" id="newPassword" placeholder="新密码">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="newPasswordV" class="col-sm-2 control-label no-padding-right">确认密码</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="newPassword_V" id="newPasswordV" placeholder="确认密码">
                                                </div>
                                            </div>
                                            <div class="form-group text-align-right">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen" id="passwordSubmit">
                                                        <i class="btn-label glyphicon glyphicon-ok"></i>保存
                                                    </a>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-sm-6 col-xs-12">
                            <div class="widget">
                                <div class="widget-header bordered-bottom bordered-palegreen">
                                    <span class="widget-caption">${pageScope.title}</span>
                                </div>
                                <div class="widget-body">
                                    <div>
                                        <form class="form-horizontal form-bordered" role="form" id="infoForm">
                                            <input type="text" name="type" value="alterInfo" hidden>
                                            <div class="form-group">
                                                <label for="userName" class="col-sm-2 control-label no-padding-right">用户名</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="userName" disabled placeholder="用户名" value="${requestScope.user.username}">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="userMail" class="col-sm-2 control-label no-padding-right">邮箱</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="usermail" id="userMail" placeholder="邮箱" value="${requestScope.user.usermail}">
                                                </div>
                                            </div>
                                            <div class="form-group text-align-right">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen" id="infoSubmit">
                                                        <i class="btn-label glyphicon glyphicon-ok"></i>保存
                                                    </a>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <h5 class="row-title before-red"><i class="fa fa-tags red"></i>头像更换</h5>
                    <div class="row">
                        <div class="col-lg-6 col-sm-6 col-xs-12">
                            <div class="widget">
                                <div class="widget-header bordered-bottom bordered-palegreen">
                                    <span class="widget-caption">修改头像</span>
                                </div>
                                <div class="widget-body">
                                    <div>
                                        <form class="form-horizontal form-bordered" role="form" id="gravaForm" enctype="multipart/form-data">
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label no-padding-right">当前头像</label>
                                                <div class="col-sm-10">
                                                    <img id="nowGrava" src="${requestScope.user.grava}" width="80px" height="80px">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="userImg" class="col-sm-2 control-label no-padding-right">头像</label>
                                                <div class="col-sm-10">
                                                    <input type="file" name="grava" class="form-control" id="userImg" placeholder="头像">
                                                </div>
                                            </div>
                                            <div class="form-group text-align-right">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <a href="javascript:void(0);" class="btn btn-labeled btn-info" id="gravaSubmit">
                                                        <i class="btn-label glyphicon glyphicon-open"></i>上传头像并保存
                                                    </a>
                                                </div>
                                            </div>
                                        </form>
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
<script type="text/javascript" src="/app/assets/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="/app/js/ajax/AlterInfoSubmit.js"></script>
<%@ include file="include/footer.jsp"%>
