<%--
  Created by IntelliJ IDEA.
  User: Licoy
  Date: 2016/12/16 0016 14:49
  Url: https://www.licoy.cn
  Remarks: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${pageContext.setAttribute("title","注册 - 瓦客新闻网")}
${pageContext.setAttribute("type","reg")}
<%@ include file="header.jsp"%>
<%@ include file="isLogin.jsp"%>

<!--内容区域-->
<div id="main">
    <div class="box">
        <div class="box_lo_reg">
            <div class="zc">
                <div class="bj_bai">
                    <h3>注册-Register</h3>
                    <form action="" method="get">
                        <input name="username" type="text" class="kuang_txt phone" placeholder="用户名">
                        <input name="email" type="email" class="kuang_txt email" placeholder="邮箱">
                        <input name="password" type="password" class="kuang_txt possword" placeholder="密码">
                        <input name="password_v" type="password" class="kuang_txt possword" placeholder="确认密码">
                        <img src="/CheckImg.do" alt="验证码" width="270px" height="60px" style="margin-bottom: 5px;
                            cursor: pointer" title="验证码" id="checkImg"/>
                        <input name="verCode" type="text" class="kuang_txt yanzm" placeholder="验证码">
                        <div>
                            <label for="saveMe"  style="cursor: pointer"><span style="font-size: 13px;">
                                <a href="#" style="font-size: 13px;color:#1dabf8">同意注册条款</a></span>
                            </label>
                            <input id="saveMe" name="is" type="checkbox" value="" checked>
                        </div>
                        <input type="button" class="btn_sub register_btn" value="立即注册">

                    </form>
                </div>
                <div class="bj_right">
                    <p>使用以下账号直接登录</p>
                    <a onclick="zeroModal.alert('暂未开放！')" class="zhuce_qq">QQ注册</a>
                    <a onclick="zeroModal.alert('暂未开放！')" class="zhuce_wb">微博注册</a>
                    <a onclick="zeroModal.alert('暂未开放！')" class="zhuce_wx">微信注册</a>
                    <p>已有账号？<a href="login.html">立即登录</a></p>
                </div>
            </div>
        </div>

    </div>
</div>

<%@ include file="footer.jsp"%>
