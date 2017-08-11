/**
 * Created by Administrator on 2016/12/22 0022.
 */
$(function () {
    var CommentsEditId = 0;
    $(".edit_comments").on("click",function () {
        $("#editCommentsText").html("");
        $(".row_edit_comments").hide(300);
        var obj = $(this).parents("tr[id*=data_]");
        var ids = obj.attr("id");
        var s = ids.split("_");
        CommentsEditId = s[2];
        if($.trim(CommentsEditId)==""){
            x0p('警告',
                '无法获取到目标类型数据，无法继续操作！',
                'error', false);
        }else{
            $.post("/ajax/CommentsUpdateController.do",{id:CommentsEditId,type:"select"},function(data) {
                if(data.code==200){
                    $("#editCommentsText").html(data.text);
                    $(".row_edit_comments").show(300);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p('未知错误！', null, 'error', false);
                }
            },"json");
        }
    });
    $(".editSave").on("click",function () {
        var text = $("#editCommentsText").val();
        if($.trim(CommentsEditId)==""){
            x0p('警告',
                '无法获取到目标类型数据，无法继续操作！',
                'error', false);
        }else if(text==""){
            x0p('警告',
                '内容不能为空！',
                'error', false);
        }else{
            $.post("/ajax/CommentsUpdateController.do",{id:CommentsEditId,type:"update",text:text},function(data) {
                if(data.code==200){
                    x0p(data.msg, null, 'ok', false);
                    $(".row_edit_comments").hide(300);
                    if(text.length>25){
                        text = text.substr(0,21)+"...";
                    }
                    $("#data_comments_"+CommentsEditId).children("td.commentsText").html(text);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p('未知错误！', null, 'error', false);
                }
            },"json");
        }
    });
});