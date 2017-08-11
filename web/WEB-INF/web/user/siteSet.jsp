<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/14 0014 20:21
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","站点设置")}
${pageContext.setAttribute("tier",11)}
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
                    <div class="col-lg-12 col-sm-12 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-top bordered-palegreen">
                                <span class="widget-caption">公告设置</span>
                            </div>
                            <div class="widget-body">
                                <div class="collapse in">
                                    <form role="form" id="noticeForm">
                                        <input type="text" name="type" value="notice" hidden>
                                        <div class="form-group">
                                            <span class="input-icon icon-right">
                                                <textarea name="${requestScope.data['notice'].key}" class="form-control" rows="5" style="resize: none">${requestScope.data['notice'].value}</textarea>
                                            </span>
                                            <p class="help-block"><i class="fa fa-info"></i>
                                                请填写好内容及时保存，以防数据丢失。
                                            </p>
                                        </div>
                                        <div class="sub text-align-right">
                                            <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen" id="noticeSubmit">
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
                <h5 class="row-title before-green"><i class="fa fa-tags green"></i>SEO设置</h5>
                <div class="row">
                    <div class="col-lg-6 col-sm-6 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-top bordered-palegreen">
                                <span class="widget-caption">基本设置</span>
                            </div>
                            <div class="widget-body">
                                <div class="collapse in">
                                    <form role="form" id="siteForm">
                                        <input type="text" name="type" value="site" hidden>
                                        <div class="alert-success">
                                            <button class="close" data-dismiss="alert">
                                                ×
                                            </button>
                                            <i class="fa-fw fa fa-info"></i>
                                            <strong>提示：</strong>站点Title，一般不超过80个字符。
                                        </div>
                                        <div class="form-group">
                                            <span class="input-icon">
                                                <input type="text" name="${requestScope.data['site-title'].key}" value="${requestScope.data['site-title'].value}" class="form-control" placeholder="站点标题">
                                                <i class="fa fa-sitemap blue"></i>
                                            </span>
                                        </div>
                                        <div class="alert-success">
                                            <button class="close" data-dismiss="alert">
                                                ×
                                            </button>
                                            <i class="fa-fw fa fa-info"></i>
                                            <strong>提示：</strong>多个关键词之间请使用“,”进行分隔，一般不超过100个字符。
                                        </div>
                                        <div class="form-group">
                                            <span class="input-icon">
                                                <input name="${requestScope.data['site-keyword'].key}" value="${requestScope.data['site-keyword'].value}" type="text" class="form-control" placeholder="站点关键词">
                                                <i class="fa fa-sitemap blue"></i>
                                            </span>
                                        </div>
                                        <div class="alert-success">
                                            <button class="close" data-dismiss="alert">
                                                ×
                                            </button>
                                            <i class="fa-fw fa fa-info"></i>
                                            <strong>提示：</strong>网站的描述信息，一般不超过200个字符。
                                        </div>
                                        <div class="form-group">
                                            <span class="input-icon">
                                                <input name="${requestScope.data['site-describe'].key}" type="text" value="${requestScope.data['site-describe'].value}" class="form-control" placeholder="站点描述">
                                                <i class="fa fa-sitemap blue"></i>
                                            </span>
                                        </div>
                                        <div class="sub text-align-right">
                                            <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen" id="siteSubmit">
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
                                <span class="widget-caption">LOGO设置</span>
                            </div>
                            <div class="widget-body">
                                <div class="collapse in">
                                    <form role="form" id="logoForm">
                                        <input type="text" name="type" value="logo" hidden>
                                        <div class="form-group">
                                            <span class="input-icon">
                                                <input name="${requestScope.data['logo-url'].key}" type="text" value="${requestScope.data['logo-url'].value}" class="form-control" placeholder="LOGO链接">
                                                <i class="glyphicon glyphicon-dashboard"></i>
                                            </span>
                                        </div>
                                        <div class="sub text-align-right">
                                            <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen" id="logoSubmit">
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
                                <span class="widget-caption">ICO设置</span>
                            </div>
                            <div class="widget-body">
                                <div class="collapse in">
                                    <form role="form" id="icoForm">
                                        <input type="text" name="type" value="ico" hidden>
                                        <div class="form-group">
                                            <span class="input-icon">
                                                <input name="${requestScope.data['ico-url'].key}" type="text" value="${requestScope.data['ico-url'].value}" class="form-control" placeholder="ICO链接">
                                                <i class="fa fa-star-o blue"></i>
                                            </span>
                                        </div>
                                        <div class="sub text-align-right">
                                            <a href="javascript:void(0);" class="btn btn-labeled btn-palegreen" id="icoSubmit">
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
<script type="text/javascript" src="/app/js/ajax/SiteSetSubmit.js"></script>
<%@ include file="include/footer.jsp"%>
