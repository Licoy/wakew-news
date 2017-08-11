<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/13 0013 18:23
  Url: https://www.licoy.cn
  Remarks: 侧边栏
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--侧边栏-->
<div class="page-sidebar" id="sidebar">
    <!-- Page Sidebar Header-->
    <div class="sidebar-header-wrapper">
        <input type="text" class="searchinput" placeholder="搜索文章"/>
        <i class="searchicon fa fa-search"></i>
    </div>
    <!-- /Page Sidebar Header -->
    <!-- Sidebar Menu -->
    <ul class="nav sidebar-menu">
        <!--Dashboard-->
            <!--用户中心-->
            <c:if test="${m:issetContainValue(sessionScope.level,'1',',' )}">
                <li <c:if test="${pageScope.tier==1}">class="active"</c:if>>
                    <a href="index.html">
                        <i class="menu-icon glyphicon glyphicon-home"></i>
                        <span class="menu-text"> 用户中心 </span>
                    </a>
                </li>
            </c:if>

        <!--新闻管理-->
            <c:if test="${m:issetContainValue(sessionScope.level,'2',',' ) || m:issetContainValue(sessionScope.level,'3',',' )}">
                <li <c:if test="${pageScope.tier==2 || pageScope.tier==3}">class="open"</c:if>>
                    <a href="#" class="menu-dropdown">
                        <i class="menu-icon fa fa-newspaper-o"></i>
                        <span class="menu-text"> 新闻管理 </span>

                        <i class="menu-expand"></i>
                    </a>
                    <ul class="submenu">
                        <c:if test="${m:issetContainValue(sessionScope.level,'2',',' )}">
                            <li <c:if test="${pageScope.tier==2}">class="active"</c:if>>
                                <a href="newsAll.html">
                                    <span class="menu-text">所有新闻</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${m:issetContainValue(sessionScope.level,'3',',' )}">
                            <li <c:if test="${pageScope.tier==3}">class="active"</c:if>>
                                <a href="editor.html">
                                    <span class="menu-text">撰写新闻</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </li>
            </c:if>


        <c:if test="${m:issetContainValue(sessionScope.level,'4',',' )}">
            <!--评论管理-->
            <li <c:if test="${pageScope.tier==4}">class="active"</c:if>>
                <a href="comments.html">
                    <i class="menu-icon fa  fa-comments-o"></i>
                    <span class="menu-text"> 评论管理 </span>
                </a>
            </li>
        </c:if>

        <c:if test="${m:issetContainValue(sessionScope.level,'5',',' )}">
            <!--分类管理-->
            <li <c:if test="${pageScope.tier==5}">class="active"</c:if>>
                <a href="category.html">
                    <i class="menu-icon fa fa-folder-open-o"></i>
                    <span class="menu-text"> 分类管理 </span>
                </a>
            </li>
        </c:if>

        <c:if test="${m:issetContainValue(sessionScope.level,'6',',' )}">
            <!--用户管理-->
            <li <c:if test="${pageScope.tier==6}">class="active"</c:if>>
                <a href="user.html">
                    <i class="menu-icon fa fa-user"></i>
                    <span class="menu-text"> 用户管理 </span>
                </a>
            </li>
        </c:if>

        <c:if test="${m:issetContainValue(sessionScope.level,'7',',' )}">
            <!--用户组管理-->
            <li <c:if test="${pageScope.tier==7}">class="active"</c:if>>
                <a href="userGroup.html">
                    <i class="menu-icon fa fa-users"></i>
                    <span class="menu-text"> 用户组管理 </span>
                </a>
            </li>
        </c:if>
        <c:if test="${m:issetContainValue(sessionScope.level,'10',',' )}">
            <!--首页设置-->
            <li <c:if test="${pageScope.tier==10}">class="active"</c:if>>
                <a href="mainSet.html">
                    <i class="menu-icon fa fa-leaf"></i>
                    <span class="menu-text"> 基本设置 </span>
                </a>
            </li>
        </c:if>

        <c:if test="${m:issetContainValue(sessionScope.level,'11',',' )}">
            <!--站点设置-->
            <li <c:if test="${pageScope.tier==11}">class="active"</c:if>>
                <a href="siteSet.html">
                    <i class="menu-icon fa fa-gears"></i>
                    <span class="menu-text"> 站点设置 </span>
                </a>
            </li>
        </c:if>


<!--导航管理-->
        <%--<li <c:if test="${pageScope.tier==8 || pageScope.tier==9}">class="open"</c:if>>
            <a href="#" class="menu-dropdown">
                <i class="menu-icon fa fa-cloud"></i>
                <span class="menu-text"> 导航管理 </span>

                <i class="menu-expand"></i>
            </a>

            <ul class="submenu">
                <li <c:if test="${pageScope.tier==8}">class="active"</c:if>>
                    <a href="nav-big.html" class="menu-dropdown">
                        <span class="menu-text">顶部大栏</span>
                    </a>
                </li>
                <li <c:if test="${pageScope.tier==9}">class="active"</c:if>>
                    <a href="nav-small.html" class="menu-dropdown">
                        <span class="menu-text">顶部小栏</span>
                    </a>
                </li>
            </ul>
        </li>--%>


    </ul>
    <!-- /Sidebar Menu -->
</div>
