/**
 * Created by Administrator on 2016/12/22 0022.
 */
$(function () {
    $(".category_Save").on("click",function () {
        var obj = $("#addCatName");
        var obj1 = $("#addCatAlias");
        var obj2 = $("#addCatDesc");
        var name = obj.val();
        var alias = obj1.val();
        var desc = obj2.val();
        name = $.trim(name);
        alias = $.trim(alias);
        desc = $.trim(desc);
        if(name=="" || alias==""){
            x0p("分类名称与别名不可以为空", null, 'error', false);
        }else{
            $.post("/ajax/CategoryController.do",{name:name,alias:alias,describe:desc,type:"insert"},function(data) {
                if(data.code==200){
                    x0p(data.msg, null, 'ok', false);
                    obj.val("");
                    obj1.val("");
                    obj2.val("");
                    $(".category_Save").parents(".row").hide(300);
                    setTimeout(function () {
                        history.go(0)
                    },1000);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p('未知错误！', null, 'error', false);
                }
            },"json");
        }
    });
    /*拉起修改框*/
    var EditCategoryId = 0;
    $(".edit_category").on("click",function () {
        var obj0 = $("#updateCatName");
        var obj1 = $("#updateCatAlias");
        var obj2 = $("#updateCatDesc");
        obj0.val("");
        obj1.val("");
        obj2.val("");
        var obj = $(this).parents("tr[id*=data_]");
        var ids = obj.attr("id");
        var s = ids.split("_");
        EditCategoryId = s[2];
        if($.trim(EditCategoryId)==""){
            x0p('警告',
                '无法获取到目标数据，无法继续操作！',
                'error', false);
        }else{
            $.post("/ajax/CategoryController.do",{id:EditCategoryId,type:"select"},function(data) {
                if(data.code==200){
                    obj0.val(data.name);
                    obj1.val(data.alias);
                    obj2.val(data.desc);
                    $(".row_edit_Cats").show(500);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p('未知错误！', null, 'error', false);
                }
            },"json");
        }
    });
    /*确认修改*/
    $(".category_Update").on("click",function () {
        var obj = $("#updateCatName");
        var obj1 = $("#updateCatAlias");
        var obj2 = $("#updateCatDesc");
        var name = obj.val();
        var alias = obj1.val();
        var desc = obj2.val();
        name = $.trim(name);
        alias = $.trim(alias);
        desc = $.trim(desc);
        if(name=="" || alias==""){
            x0p("分类名称与别名不可以为空", null, 'error', false);
        }else if($.trim(EditCategoryId)==""){
            x0p("获取标识数据异常,无法继续操作", null, 'error', false);
        }else{
            $.post("/ajax/CategoryController.do",{name:name,alias:alias,describe:desc,id:EditCategoryId,type:"update"},function(data) {
                if(data.code==200){
                    x0p(data.msg, null, 'ok', false);
                    obj.val("");
                    obj1.val("");
                    obj2.val("");
                    var dataobj = $("#data_category_"+EditCategoryId);
                    dataobj.children(".category_name").html(name);
                    dataobj.children(".category_alias").html(alias);
                    $(".category_Update").parents(".row").hide(300);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p('未知错误！', null, 'error', false);
                }
            },"json");
        }
    })
});