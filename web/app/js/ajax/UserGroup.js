/**
 * Created by Administrator on 2016/12/23 0023.
 */
$(function () {
    /*添加数据*/
    $("#GorupAddSubMit").on("click",function () {
        $.post("/ajax/UserGroupController.do",$('#userGroupAddForm').serialize(),function(data) {
            if(data.code==200){
                x0p(data.msg, null, 'ok', false);
                $(".row_edit_user").hide(300);
                setTimeout(function () {
                    history.go(0)
                },1000);
            }else if(data.code==403){
                x0p(data.msg, null, 'error', false);
            }else{
                x0p('未知错误！', null, 'error', false);
            }
        },"json");
    });

    $("[class*=edit_group_]").on("click",function () {
        $("input[name=level]:checkbox").prop("checked", false);
        var trObj = $(this).parents("tr[id*=data_group_]");
        var idText = trObj.attr("id");
        var s = idText.split("_");
        var id = s[2];
        if($.trim(id)==""){
            x0p("无法获取标识参数,无法继续操作", null, 'error', false);
        }else{
            $.post("/ajax/UserGroupController.do",{id:id,type:"select"},function(data) {
                if(data.code==200){
                    $("#updateGroupId").val(data.id);
                    $("#updateGroupName").val(data.name);
                    var levels = (data.level).split(",");
                    for(var i=0;i<levels.length;i++){
                        $(".level_"+levels[i]).prop("checked",true);
                    }
                    $(".row_edit_userGroup").show(300);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p('未知错误！', null, 'error', false);
                }
            },"json");
        }
    });
    
    $("#SaveUpdate").on("click",function () {
        var id = $("#updateGroupId").val();
        var name = $("#updateGroupName").val();
        var level = [];
        $('[class*=level_]:checked').each(function(){
            level.push($(this).val());
        });
        var le = "";
        for(var i=0;i<level.length;i++){
            if(i==level.length-1){
                le = le+level[i];
            }else{
                le = le+level[i]+",";
            }
        }
        $.post("/ajax/UserGroupController.do",{id:id,name:name,le:le,type:"update"},function(data) {
            if(data.code==200){
                x0p(data.msg, null, 'ok', false);
                $(".row_edit_user").hide(300);
                setTimeout(function () {
                    history.go(0)
                },1000);
            }else if(data.code==403){
                x0p(data.msg, null, 'error', false);
            }else{
                x0p('未知错误！', null, 'error', false);
            }
        },"json");
    })
});