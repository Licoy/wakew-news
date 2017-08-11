<%@ page import="com.utils.Tools" %><%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/20 0020 21:21
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${!empty sessionScope.id}">
        <script type="text/javascript">
            <%
                String referer = request.getHeader("referer");
                if(Tools.empty(referer)){
                    referer = "u/index.html";
                }
            %>
            location=<%=referer%>;
        </script>
    </c:when>
    <c:when test="${!empty cookie.get('IS') && cookie.get('IS')!=null}">
        <c:redirect url="/controller/AutoLoginController.do">

        </c:redirect>
    </c:when>
</c:choose>