<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/29 0029 20:12
  Url: https://www.licoy.cn
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","搜索")}
${pageContext.setAttribute("type","search")}
<%@ include file="header.jsp"%>

<!--内容区域-->
<div id="main">
    <div class="areas" style="background-image: url('/app/img/22.png')">
        <p>搜索 - [ ${param.s} ] 共检索到${requestScope.map.count}条记录，当前为第${requestScope.map.page.nowPageNum}页</p>
    </div>
    <div class="search">
        <ul>
            ${pageContext.setAttribute("searchNumber",1)}
            <c:forEach items="${requestScope.map.page.list}" var="n">
                <li><span class="top">${pageScope.searchNumber}</span>
                    <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category, n.category)}/${n.id}.html" title="<c:out value="${n.title}"/>">
                        <c:out value="${n.title}"/>
                    </a>
                </li>
                ${pageContext.setAttribute("searchNumber",pageScope.searchNumber+1)}
            </c:forEach>
        </ul>
    </div>
    <c:if test="${requestScope.map.count>30}">
        <div id="splitPage">
            <ul class="page">
                <li><a href="${requestScope.map.page.url}">首页</a></li>
                <c:choose>
                    <c:when test="${requestScope.map.page.nowPageNum-1<=0}">
                        <li disabled="disabled"><a><</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${requestScope.map.page.url}page=${requestScope.map.page.nowPageNum-1}"><</a></li>
                    </c:otherwise>
                </c:choose>
                <c:forEach begin="${requestScope.map.page.startPage}" end="${requestScope.map.page.endPage}" var="pageNum">
                    <c:choose>
                        <c:when test="${pageNum==requestScope.map.page.nowPageNum}">
                            <li class="pageActive"><a href="${requestScope.map.page.url}page=${pageNum}">${pageNum}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${requestScope.map.page.url}page=${pageNum}">${pageNum}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${requestScope.map.page.nowPageNum+1>requestScope.map.page.pageNum}">
                        <li disabled="disabled"><a>></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${requestScope.map.page.url}page=${requestScope.map.page.nowPageNum+1}">></a></li>
                    </c:otherwise>
                </c:choose>
                <li><a href="${requestScope.map.page.url}page=${requestScope.map.page.pageNum}">共${requestScope.map.page.pageNum}页</a></li>
            </ul>

        </div>
    </c:if>

</div>

<%@ include file="footer.jsp"%>
