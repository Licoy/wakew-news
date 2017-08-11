<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/14 0014 20:21
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","基本设置")}
${pageContext.setAttribute("tier",10)}
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
                <h5 class="row-title before-green"><i class="fa fa-tags green"></i>首页设置</h5>
                <div class="row">
                    <div class="col-lg-6 col-sm-6 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-top bordered-palegreen">
                                <span class="widget-caption">栏目设置</span>
                            </div>
                            <div class="widget-body">
                                <div class="collapse in">
                                    <div class="well margin-bottom-10">
                                        <span>分类目录ID对应列表：</span>
                                        <span class="label label-info">9-军事</span>
                                        <span class="label label-info">8-财经</span>
                                        <span class="label label-info">5-社会</span>
                                        <span class="label label-info">1-财富</span>
                                        <span class="label label-info">3-娱乐</span>
                                    </div>
                                    <div class="alert-success margin-bottom-10">
                                        <button class="close" data-dismiss="alert">
                                            ×
                                        </button>
                                        <i class="fa-fw fa fa-warning"></i>
                                        <strong>注意：</strong>请在下方填写对应的ID号，多个分类目录之间用“,”进行分隔。
                                    </div>
                                    <form role="form">
                                        <div class="form-group">
                                            <span class="input-icon">
                                                <input type="text" class="form-control" placeholder="首页底部栏目">
                                                <i class="fa fa-maxcdn blue"></i>
                                            </span>
                                        </div>
                                        <div class="form-group">
                                            <span class="input-icon">
                                                <input type="text" class="form-control" placeholder="首页侧边栏目">
                                                <i class="fa fa-maxcdn blue"></i>
                                            </span>
                                        </div>
                                        <div class="form-group">
                                            <span class="input-icon">
                                                <input type="text" class="form-control" placeholder="文章侧边栏目">
                                                <i class="fa fa-maxcdn blue"></i>
                                            </span>
                                        </div>
                                        <div class="sub text-align-right">
                                            <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen">
                                                <i class="btn-label glyphicon glyphicon-ok"></i>
                                                <span>保存</span>
                                            </a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-sm-6 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-top bordered-palegreen">
                                <span class="widget-caption">幻灯设置</span>
                            </div>
                            <div class="widget-body">
                                <div class="collapse in">
                                    <form role="form">
                                        <div class="form-group">
                                            <span class="input-icon">
                                                <input type="text" class="form-control" placeholder="最多显示数量">
                                                <i class="fa fa-eye blue"></i>
                                            </span>
                                        </div>
                                        <div class="sub text-align-right">
                                            <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen">
                                                <i class="btn-label glyphicon glyphicon-ok"></i>
                                                <span>保存</span>
                                            </a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-sm-6 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-top bordered-palegreen">
                                <span class="widget-caption">搜索框预留文字</span>
                            </div>
                            <div class="widget-body">
                                <div class="collapse in">
                                    <form role="form">
                                        <div class="form-group">
                                            <span class="input-icon">
                                                <input type="text" class="form-control" placeholder="顶部搜索框预留文字">
                                                <i class="fa fa-search blue"></i>
                                            </span>
                                        </div>
                                        <div class="sub text-align-right">
                                            <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen">
                                                <i class="btn-label glyphicon glyphicon-ok"></i>
                                                <span>保存</span>
                                            </a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <h5 class="row-title before-red"><i class="fa fa-tags red"></i>底部设置</h5>
                <div class="row">
                    <div class="col-lg-6 col-sm-6 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-top bordered-palegreen">
                                <span class="widget-caption">底部设置</span>
                            </div>
                            <div class="widget-body">
                                <div class="collapse in">
                                    <div class="well margin-bottom-10">
                                        底部版权内容设置，可填写HTML与JavaScript。
                                    </div>
                                    <div class="alert-warning margin-bottom-10">
                                        <button class="close" data-dismiss="alert">
                                            ×
                                        </button>
                                        <i class="fa-fw fa fa-warning"></i>
                                        <strong>注意：</strong>请尽量少使用JavaScript代码。
                                    </div>
                                    <form role="form">
                                        <div class="form-group">
                                            <span class="input-icon icon-right">
                                                <textarea class="form-control" rows="10" style="resize: none"></textarea>
                                            </span>
                                            <p class="help-block"><i class="fa fa-info"></i>
                                                请填写好内容及时保存，以防数据丢失。
                                            </p>
                                        </div>
                                        <div class="sub text-align-right">
                                            <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen">
                                                <i class="btn-label glyphicon glyphicon-ok"></i>
                                                <span>保存</span>
                                            </a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-sm-6 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-top bordered-palegreen">
                                <span class="widget-caption">用户设置</span>
                            </div>
                            <div class="widget-body">
                                <div class="collapse in">
                                    <form role="form">
                                        <div class="form-group ">
                                            <label for="e1" class="col-sm-2 control-label no-padding-right" style="line-height: 28px;">
                                                默认用户组
                                            </label>
                                            <div class="col-sm-10 margin-bottom-10">
                                                <select id="e1" style="width: 100%">
                                                    <option value="">普通用户</option>
                                                    <option value="">编辑</option>
                                                    <option value="">主编</option>
                                                    <option value="">超级管理员</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="sub text-align-right">
                                            <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen">
                                                <i class="btn-label glyphicon glyphicon-ok"></i>
                                                <span>保存</span>
                                            </a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-sm-6 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-top bordered-palegreen">
                                <span class="widget-caption">条款设置</span>
                            </div>
                            <div class="widget-body">
                                <div class="collapse in">
                                    <p>注册时【注册条款】设置，可填写HTML与JavaScript。</p>
                                    <div class="alert-warning margin-bottom-10">
                                        <button class="close" data-dismiss="alert">
                                            ×
                                        </button>
                                        <i class="fa-fw fa fa-warning"></i>
                                        <strong>注意：</strong>请尽量少使用JavaScript代码。
                                    </div>
                                    <form role="form">
                                        <div class="form-group">
                                            <span class="input-icon icon-right">
                                                <textarea class="form-control" rows="10" style="resize: none"></textarea>
                                            </span>
                                            <p class="help-block"><i class="fa fa-info"></i>
                                                请填写好内容及时保存，以防数据丢失。
                                            </p>
                                        </div>
                                        <div class="sub text-align-right">
                                            <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen">
                                                <i class="btn-label glyphicon glyphicon-ok"></i>
                                                <span>保存</span>
                                            </a>
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
<%@ include file="include/selectTagScript.jsp"%>
<%@ include file="include/footer.jsp"%>
