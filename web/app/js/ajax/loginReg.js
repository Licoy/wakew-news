$(function () {
    function changgeBtn(str,disabled) {
        var obj = $("[class*=_btn]");
        if(disabled){
            obj.attr("disabled","disabled");
        }else{
            obj.removeAttr("disabled");
        }
        obj.attr("value",str);
    }
    function getCheckCode() {
        var obj = $("#checkImg");
        var s = obj.attr("src");
        obj.attr("src",s+"?"+new Date().getTime());
    }
    $(".register_btn").click(function () {
        var username = $("input[name=username]").val();
        var usermail = $("input[name=email]").val();
        var password = $("input[name=password]").val();
        var password_v = $("input[name=password_v]").val();
        var checkCode = $("input[name=verCode]").val();
        username = W_trim(username);
        usermail = W_trim(usermail);
        password = W_trim(password);
        password_v = W_trim(password_v);
        checkCode = W_trim(checkCode);
        var is = $("input[name=is]").is(":checked");
        if(!is){
            zeroModal.alert("请勾选注册条款再进行注册");
            return false;
        }else if(W_empty(username) || W_empty(usermail) || W_empty(password) || W_empty(password_v) || W_empty(checkCode)){
            zeroModal.alert("所有选项都不可以为空!");
            return false;
        }else if(!W_isNumberMu(username)){
            zeroModal.alert("用户名只能是由字母、数字、下划线组成，字母或下划线开头,6-15位!");
            return false;
        }else if(!W_isEmail(usermail)){
            zeroModal.alert("邮箱不合法！");
            return false;
        }else if(!checkPassword(password)){
            zeroModal.alert("密码应为a-Z|0-9以及下划线组成的6-15个字符!");
            return false;
        }else if(password_v!=password){
            zeroModal.alert("两次密码输入不一致!");
            return false;
        }else{
            changgeBtn("正在注册",true);
            var info = "username="+username+"&usermail="+usermail+"&password="+password+"&checkCode="+checkCode+"&is="+is;
            $.ajax({
                type:"post",
                url:"/ajax/RegisterController.do",
                async:true,
                data:info,
                dataType:'text',
                success:function(data){
                    changgeBtn("立即注册",false);
                    getCheckCode();
                    var datas = eval('('+data+')');
                    if(datas.code==200){
                        zeroModal.success("注册成功，即将跳转至登录页...");
                        setTimeout('location="login.html"',1200);
                    }else if(datas.code==403){
                        zeroModal.error(datas.msg);
                    }else{
                        zeroModal.error("未知错误");
                    }
                }
            });
        }
    });

    $(".login_btn").click(function () {
        var username = $("input[name=username]").val();
        var password = $("input[name=password]").val();
        var checkCode = $("input[name=verCode]").val();
        var is = $("input[name=saveMe]").is(":checked");
        username = W_trim(username);
        password = W_trim(password);
        checkCode = W_trim(checkCode);
        if(W_empty(username) || W_empty(password) || W_empty(checkCode)){
            zeroModal.alert("所有选项都不可以为空!");
            return false;
        }else{
            changgeBtn("正在登录",true);
            var info = "username="+username+"&password="+password+"&checkCode="+checkCode+"&is="+is;
            $.ajax({
                type:"post",
                url:"/ajax/LoginController.do",
                async:true,
                data:info,
                dataType:'text',
                success:function(data){
                    changgeBtn("立即登录",false);
                    getCheckCode();
                    var datas = eval('('+data+')');
                    if(datas.code==200){
                        zeroModal.success("登录成功，即将跳转至用户中心...");
                        setTimeout('location="u/index.html"',1200);
                    }else if(datas.code==403){
                        zeroModal.error(datas.msg);
                    }else{
                        zeroModal.error("未知错误");
                    }
                }
            });
        }
    })
});
