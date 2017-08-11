<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/16 0016 14:44
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","瓦客新闻网 - 关注你所想")}
${pageContext.setAttribute("type","index")}
<%@ include file="header.jsp"%>
<!--内容区块-->
<div id="main">
    <!--幻灯片-->
    <div class="slide_container">
        <ul class="rslides" id="slider">
            <c:forEach items="${requestScope.map.slideNews}" var="news">
                <li>
                    <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,news.category)}/${news.id}.html"><img src="${news.slideImg}" title="<c:out value="${news.title}"/>" alt="<c:out value="${news.title}"/>"></a>
                    <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,news.category)}/${news.id}.html" class="caption" title="<c:out value="${news.title}"/>"><c:out value="${news.title}"/></a>
                </li>
            </c:forEach>

        </ul>
    </div>
    <!--要闻-->
    <div class="focusNews">
        <div class="NewsBoxTitle">
            <span><i class="fa fa-newspaper-o"></i> 今日要闻</span>
            <div class="clear_float"></div>
        </div>
        <div class="content">
            <c:forEach items="${requestScope.map.focusNews}" var="foc" begin="0" end="0">
                <div class="firstImgNews">
                    <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,foc.news.category)}/${foc.news.id}.html">
                        <img src="${foc.imgSrc}" title="<c:out value="${foc.news.title}"/>" alt="<c:out value="${foc.news.title}"/>"/>
                    </a>
                    <span class="abstract">
                    <a target="_blank" title="<c:out value="${foc.news.title}"/>" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,foc.news.category)}/${foc.news.id}.html" class="title">${m:getAbstract(foc.news.title,10)}</a>
                    <p>${m:getAbstract(foc.news.text,42)}</p>
                </span>
                    <div class="clear_float"></div>
                </div>
            </c:forEach>

            <ul class="listNews">
                ${pageContext.setAttribute("listNewsNumber",2)}
                <c:forEach items="${requestScope.map.focusNews}" var="foc" begin="1">
                <li><span class="xu">${pageScope.listNewsNumber}</span>
                    <a target="_blank" title="<c:out value="${foc.news.title}"/>" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,foc.news.category)}/${foc.news.id}.html">${foc.news.title}</a>
                </li>${pageContext.setAttribute("listNewsNumber",pageScope.listNewsNumber+1)}
                </c:forEach>
            </ul>
        </div>



    </div>
    <div class="clear_float"></div>
    <!--推荐新闻-->
    <div class="recommendNews">
        <ul>
            <c:forEach items="${requestScope.map.newNews}" var="news">
                <li>
                    <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,news.news.category)}/${news.news.id}.html">
                        <img src="${news.imgSrc}" title="<c:out value="${news.news.title}"/>" alt="<c:out value="${news.news.title}"/>">
                    </a>
                    <div class="con">
                        <div class="title">
                            <a target="_blank" title="<c:out value="${news.news.title}"/>" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,news.news.category)}/${news.news.id}.html">
                                <em>${m:getAbstract(news.news.title,22)}</em>
                            </a>
                        </div>
                        <p>${m:getAbstract(news.news.text,60)}</p>
                        <div class="newsInfo">
                        <a class="cat" target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,news.news.category)}">
                            ${m:getCategoryNameById(requestScope.map.header.category,news.news.category)}
                        </a>
                        <span>
                            <i class="fa fa-clock-o"></i>${m:dateFormat(news.news.created)}
                        </span>
                            <span>
                            <i class="fa fa-eye"></i>${news.news.views}
                        </span>
                            <span>
                            <i class="fa fa-comments-o"></i>${news.count}
                        </span>
                        </div>
                    </div>
                </li>
            </c:forEach>

        </ul>
    </div>
    <!--侧边-->
    <div class="sidebar">
        <c:forEach items="${requestScope.map.Cisn}" var="cNews">

            <div class="row">
                <div class="title">
                    <span><i class="fa fa-newspaper-o"></i>${m:getCategoryNameById(requestScope.map.header.category,cNews.catId)}</span>
                    <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,cNews.catId)}">更多 <i class="fa fa-caret-right"></i></a>
                    <div class="clear_float"></div>
                </div>
                <div class="content">
                    <ul>
                        <c:forEach items="${cNews.list}" var="news" begin="0" end="0">
                            <li>
                                <a href="/category/${m:getCategoryAliasById(requestScope.map.header.category,cNews.catId)}/${news.news.id}.html" target="_blank">
                                    <img src="${news.imgSrc}" alt="${news.news.title}" title="${news.news.title}">
                                </a>
                                <div class="desc">
                                    <a href="/category/${m:getCategoryAliasById(requestScope.map.header.category,cNews.catId)}/${news.news.id}.html" target="_blank">
                                        <h4>${news.news.title}</h4>
                                    </a>
                                    <p>${m:getAbstract(news.news.text,30)}</p>
                                </div>
                                <div class="clear_float"></div>
                            </li>
                        </c:forEach>
                        <c:forEach items="${cNews.list}" begin="1" var="news">
                            <li class="lists"><a href="/category/${m:getCategoryAliasById(requestScope.map.header.category,cNews.catId)}/${news.news.id}.html" target="_blank" title="${news.news.title}">${news.news.title}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

        </c:forEach>

    </div>
    <!--内容区域底部板块-->
    <div class="footCms">
        <c:forEach items="${requestScope.map.Cifn}" var="ci">
            <div class="row">
                <div class="title">
                    <span><i class="fa fa-newspaper-o"></i> ${m:getCategoryNameById(requestScope.map.header.category,ci.catId)}</span>
                    <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,ci.catId)}">更多 <i class="fa fa-caret-right"></i></a>
                </div>
                <div class="content">
                    <ul>
                        <c:forEach items="${ci.list}" var="news" begin="0" end="0">
                            <li>
                                <a href="/category/${m:getCategoryAliasById(requestScope.map.header.category,ci.catId)}/${news.news.id}.html" target="_blank">
                                    <img src="${news.imgSrc}" alt="<c:out value="${news.news.title}"/>" title="<c:out value="${news.news.title}"/>">
                                </a>
                                <div class="desc">
                                    <a title="<c:out value="${news.news.title}"/>" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,ci.catId)}/${news.news.id}.html" target="_blank">
                                        <h4>${news.news.title}</h4>
                                    </a>
                                    <p>${m:getAbstract(news.news.text,95)}</p>
                                </div>
                                <div class="clear_float"></div>
                            </li>
                        </c:forEach>
                        <c:forEach items="${ci.list}" begin="1" var="news">
                            <li class="lists"><a tabindex="<c:out value="${news.news.title}"/>" href="/category/${m:getCategoryAliasById(requestScope.map.header.category,ci.catId)}/${news.news.id}.html" target="_blank" title="${news.news.title}">${news.news.title}</a></li>
                        </c:forEach>

                    </ul>
                </div>
            </div>
        </c:forEach>

    </div>
</div>

<%@ include file="footer.jsp"%>
