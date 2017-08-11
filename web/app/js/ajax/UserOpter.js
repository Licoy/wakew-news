/**
 * Created by Administrator on 2016/12/22 0022.
 */
$(function () {
    $("[class*=edit_user]").on("click",function () {
        var userIDObj = $("#userID");
        var userNameObj = $("#userName");
        var userMailObj = $("#userMail");
        var userCreatedObj = $("#userCreated");
        var userLastLoginObj = $("#userLastLogin");
        var obj = $(this).parents("tr[id*=data_]");
        var ids = obj.attr("id");
        var s = ids.split("_");
        ids = s[2];
        if($.trim(ids)==""){
            x0p('警告',
                '无法获取到目标类型数据，无法继续操作！',
                'error', false);
        }else{
            $.post("/ajax/UserOpterUpdateController.do",{id:ids,type:"select"},function(data) {
                if(data.code==200){
                    userIDObj.val(data.id);
                    userNameObj.val(data.username);
                    userMailObj.val(data.usermail);
                    $(".optionGroup_"+data.usergroup).prop("selected","selected");
                    userCreatedObj.val(data.created);
                    userLastLoginObj.val(data.lastlogin);
                    $(".row_edit_user").show(300);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p('未知错误！', null, 'error', false);
                }
            },"json");
        }
    });
    $("#update_Save").on("click",function () {
        var userIDObj = $("#userID");
        var userNameObj = $("#userName");
        var userMailObj = $("#userMail");
        var userGroupObj = $("#userGroup");
        var id = userIDObj.val();
        var username = userNameObj.val();
        var usermail = userMailObj.val();
        var group = userGroupObj.val();
        id = $.trim(id);
        username = $.trim(username);
        usermail = $.trim(usermail);
        group = $.trim(group);
        if(id=="" || username=="" || usermail=="" || group==""){
            x0p('警告',
                '用户可改信息不可以为空值！',
                'error', false);
        }else{
            $.post("/ajax/UserOpterUpdateController.do",{id:id,username:username,usermail:usermail,usergroup:group,type:"update"},function(data) {
                if(data.code==200){
                    x0p(data.msg, null, 'ok', false);
                    $(".row_edit_user").hide(300);
                    setTimeout(function () {
                        history.go(0)
                    },1200);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p('未知错误！', null, 'error', false);
                }
            },"json");
        }
    });
});