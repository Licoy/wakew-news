<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/16 0016 14:49
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","登录 - 瓦客新闻网")}
${pageContext.setAttribute("type","login")}
<%@ include file="header.jsp"%>
<%@ include file="isLogin.jsp"%>
<!--内容区域-->
<div id="main">
    <div class="box">
        <div class="box_lo_reg">
            <div class="zc">
                <div class="bj_bai">
                    <h3>登录-Login</h3>
                    <form action="" method="get">
                        <input name="username" type="text" class="kuang_txt phone" placeholder="用户名/邮箱">
                        <input name="password" type="password" class="kuang_txt possword" placeholder="密码">
                        <img src="/CheckImg.do" alt="验证码" width="270px" height="60px" style="margin-bottom: 5px;
                            cursor: pointer" title="验证码" id="checkImg"/>
                        <input name="verCode" type="text" class="kuang_txt yanzm" placeholder="验证码">
                        <div>
                            <label for="saveMe"  style="cursor: pointer"><span style="font-size: 13px;">自动登录</span></label>
                            <input id="saveMe" name="saveMe" type="checkbox" value="">
                        </div>
                        <input type="button" class="btn_sub login_btn" value="立即登录">
                    </form>
                </div>
                <div class="bj_right">
                    <p>使用以下账号直接登录</p>
                    <a onclick="zeroModal.alert('暂未开放！')" class="zhuce_qq">QQ注册</a>
                    <a onclick="zeroModal.alert('暂未开放！')" class="zhuce_wb">微博注册</a>
                    <a onclick="zeroModal.alert('暂未开放！')" class="zhuce_wx">微信注册</a>
                    <p>忘记密码？<a href="retpassword.html">找回密码</a></p>
                    <p>没有账号？<a href="register.html">立即注册</a></p>


                </div>
            </div>
        </div>

    </div>
</div>

<%@ include file="footer.jsp"%>
