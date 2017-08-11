<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/16 0016 14:49
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","最新新闻")}
${pageContext.setAttribute("type","newest")}
<%@ include file="header.jsp"%>

<!--内容区域-->
<div id="main">
    <div class="areas" style="background-image: url('/app/img/blue-bg.png')">
        <p>最新新闻 - Latest news</p>
    </div>
    <c:forEach items="${requestScope.map.data}" var="d">
        <div class="rank">
            <div class="title">
                <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category, d.category.id)}">
                    ${m:getCategoryNameById(requestScope.map.header.category, d.category.id)}
                </a>
            </div>
            <ul>
                ${pageContext.setAttribute("newestNum",1)}
                <c:forEach items="${d.news}" var="n">
                    <li><span class="top">${pageScope.newestNum}</span>
                        <a target="_blank" href="/category/${m:getCategoryAliasById(requestScope.map.header.category, d.category.id)}/${n.id}.html" title="<c:out value="${n.title}"/>">
                            <c:out value="${n.title}"/>
                        </a>
                    </li>
                    ${pageContext.setAttribute("newestNum",pageScope.newestNum+1)}
                </c:forEach>

            </ul>
        </div>
    </c:forEach>

</div>

<%@ include file="footer.jsp"%>
