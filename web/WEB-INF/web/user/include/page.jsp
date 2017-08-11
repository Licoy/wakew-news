<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/21 0021 13:30
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="margin-top-30 text-align-right">
    <div class="next">
        <ul class="pagination">
            <li><a href="${requestScope.page.url}">首页</a></li>
            <c:choose>
                <c:when test="${requestScope.page.nowPageNum-1<=0}">
                    <li class="disabled"><a>上一页</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${requestScope.page.url}page=${requestScope.page.nowPageNum-1}">上一页</a></li>
                </c:otherwise>
            </c:choose>
            <c:forEach begin="${requestScope.page.startPage}" end="${requestScope.page.endPage}" var="pageNum">
                <c:choose>
                    <c:when test="${pageNum==requestScope.page.nowPageNum}">
                        <li class="active"><a href="${requestScope.page.url}page=${pageNum}">${pageNum}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${requestScope.page.url}page=${pageNum}">${pageNum}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:choose>
                <c:when test="${requestScope.page.nowPageNum+1>requestScope.page.pageNum}">
                    <li class="disabled"><a>下一页</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${requestScope.page.url}page=${requestScope.page.nowPageNum+1}">下一页</a></li>
                </c:otherwise>
            </c:choose>
            <li><a href="${requestScope.page.url}page=${requestScope.page.pageNum}">尾页</a></li>
        </ul>
    </div>
</div>
