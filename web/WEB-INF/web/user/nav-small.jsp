<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/13 0013 19:25
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","小栏导航")}
${pageContext.setAttribute("tier",9)}
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
                <div class="row row_add_Nav">
                    <div class="col-lg-12 col-sm-12 col-xs-12">
                        <div class="widget">
                            <div class="widget-header bordered-bottom bordered-palegreen">
                                <span class="widget-caption">添加导航</span>
                            </div>
                            <div class="widget-body">
                                <div>
                                    <form class="form-horizontal form-bordered" role="form">
                                        <div class="control-group text-align-center">
                                            <label>
                                                <input name="addNavSmallChecked" id="addNavSmallCheckedCats" type="radio" checked="checked">
                                                <span class="text">分类目录</span>
                                            </label>
                                            <label>
                                                <input name="addNavSmallChecked" id="addNavSmallCheckedUrl" type="radio" class="inverted">
                                                <span class="text">链接</span>
                                            </label>
                                        </div>
                                        <%--分类选择框--%>
                                        <div class="form-group addNavSmallCats">
                                            <label for="e1" class="col-sm-2 control-label no-padding-right">分类目录</label>
                                            <div class="col-sm-10">
                                                <select id="e1" style="width: 100%">
                                                    <option value="">国内</option>
                                                    <option value="">军事</option>
                                                    <option value="">财经</option>
                                                    <option value="">社会</option>
                                                    <option value="">体育</option>
                                                    <option value="">娱乐</option>
                                                </select>
                                            </div>
                                        </div>
                                        <span class="addNavSmallUrl">
                                            <div class="form-group margin-bottom-10">
                                                <label for="addNavSmallUrlNames" class="col-sm-2 control-label no-padding-right">链接标题</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="addNavSmallUrlNames" placeholder="链接标题">
                                                </div>
                                            </div>
                                            <div class="form-group margin-bottom-10">
                                                <label for="addNavSmallUrlAddress" class="col-sm-2 control-label no-padding-right">链接地址</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="addNavSmallUrlAddress" placeholder="链接地址">
                                                </div>
                                            </div>
                                        </span>
                                        <div class="form-group">
                                            <label for="addNavSmallName" class="col-sm-2 control-label no-padding-right">导航名称</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="addNavSmallName" placeholder="导航名称">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="addNavSmallDesc" class="col-sm-2 control-label no-padding-right">优先级</label>
                                            <div class="col-sm-10">
                                                <input type="number" class="form-control" id="addNavSmallDesc" placeholder="优先级">
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
                <%--添加分类END--%>
                <div class="row">
                    <div class="col-xs-12 col-md-12">
                        <div class="well with-header with-footer">
                            <div class="header bordered-sky">
                                ${pageScope.title}
                            </div>
                            <div class="text-align-right">
                                <a class="btn btn-success btn-xs add_Nav" name="add_Nav">
                                    <i class="fa fa-plus"></i>
                                    <span>添加导航</span>
                                </a>
                            </div>
                            <form class="searchCats" method="get">
                                <div style="float:left;margin-right:2px;">
                                    <div class="form-group">
                                        <select name="searchCats">
                                            <option value="id">ID</option>
                                            <option value="title">名称</option>
                                            <option value="title">别名</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                            <span class="input-icon icon-right">
                                                <input type="text" name="searchContent" class="form-control" placeholder="搜索导航">
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
                                        优先级
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
                                    <td class="col-md-2">
                                        军事
                                    </td>
                                    <td>
                                        1
                                    </td>
                                    <td>
                                        <a href="#" class="btn btn-info btn-xs edit"><i class="fa fa-edit"></i> 编辑</a>
                                        <a href="#" class="btn btn-success btn-xs edit"><i class="fa fa-edit"></i> 查看</a>
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

