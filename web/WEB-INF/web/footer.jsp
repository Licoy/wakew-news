<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/16 0016 14:43
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="clear_float"></div>
<!--返回顶部组件-->
<div id="reTop">
    <a id="totop" title="返回顶部">返回顶部</a>
</div>
<!--底部版权-->
<footer>
    <div id="footer">
        ${requestScope.map.footer.footerSet}
    </div>
</footer>

<c:if test="${pageScope.type=='index'}">
    <!--幻灯片-->
    <script type="text/javascript" src="/app/js/responsiveslides.min.js"></script>
</c:if>
<!--固定-->
<script type="text/javascript" src="/app/js/stickUp.min.js"></script>
<script type="text/javascript" src="/app/js/my.js"></script>
<c:if test="${pageScope.type=='login'||pageScope.type=='reg'||pageScope.type=='retpswd'}">
    <script type="text/javascript" src="/app/js/zeroModal.min.js"></script>
    <script type="text/javascript" src="/app/js/ajax/loginReg.js"></script>
</c:if>
<c:if test="${pageScope.type=='page'}">
    <script type="text/javascript" src="/app/js/zeroModal.min.js"></script>
    <script type="text/javascript" src="/app/js/page/comments.ajax.js"></script>
    <script type="text/javascript" src="/app/js/jquery.qrcode.js"></script>
    <script type="text/javascript" src="/app/js/utf.js"></script>
    <script type="text/javascript" src="/app/js/viewer-jquery.min.js"></script>
    <script type="text/javascript" src="/app/js/page/share.js"></script>
</c:if>
<%--<script type="text/javascript" src="/app/js/instantclick.min.js"></script>
<script data-no-instant>InstantClick.init();</script>--%>
<script type="text/javascript">
    <c:if test="${pageScope.type=='page'}">
        $('.article-text').viewer();
    </c:if>
    $("#totop").hide();
    $(function() {
        <c:if test="${pageScope.type=='index'}">
        $("#slider").responsiveSlides({
            auto: true,
            pager: false,
            nav: true,
            speed: 500,
            // 对应外层div的class : slide_container
            namespace: "slide"
        });
        </c:if>
        $(document).ready( function() {
            $("nav").stickUp();
        });

        $(window).scroll(function(){
            if ($(window).scrollTop()>100){
                $("#totop").fadeIn();
            }else{
                $("#totop").fadeOut();
            }
        });
        //当点击跳转链接后，回到页面顶部位置
        $("#totop").click(function(){
            $('body,html').animate({scrollTop:0},500);
            return false;
        });
    });
</script>
</body>
</html>
