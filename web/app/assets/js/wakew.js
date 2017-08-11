/**
 * Created by Administrator on 2016/12/14 0014.
 */
$(function () {
    var ADD_CATS_START = false;
    $(".prope-index-img").click(function () {
       var is = $(this).is(':checked');
        if(is==true){
            $(".index-img").show(300);
        }else{
            $(".index-img").hide(300);
        }
    });
    $(".submitNewsAdd").click(function () {
        changeContentAndDisable($(this),"正在发布...");
        setTimeout("changeContentAndStart($('.submitNewsAdd'),'发布完成')",3000);
    });

    $(".addCatsStart").click(function () {
        var obj = $(".addCatsRow");
        if(ADD_CATS_START==false){
            toolTips("正在拉起添加模块，请稍等...","default");
            obj.show(500);
            ADD_CATS_START = true;
            $(this).children("span").html("关闭添加分类");
        }else{
            obj.hide(500);
            ADD_CATS_START = false;
            $(this).children("span").html("添加分类");
        }
    });

    $(".addNavStart").click(function () {
        var obj = $(".addNavRow");
        if(ADD_CATS_START==false){
            toolTips("正在拉起添加模块，请稍等...","default");
            obj.show(500);
            ADD_CATS_START = true;
            $(this).children("span").html("关闭添加导航");
        }else{
            obj.hide(500);
            ADD_CATS_START = false;
            $(this).children("span").html("添加导航");
        }
    });

    /**
    * 大栏导航-添加导航-选择分类目录
    * */
    $("#addNavBigCheckedCats").click(function () {
        var is = $(this).is(':checked');
        if(is==true){
            $(".addNavBigCats").show(300);
            $(".addNavBigUrl").hide(300);
            clearHtml($("#addNavBigName"));
            clearHtml($("#addNavBigDesc"));
            clearHtml($("#addNavBigUrlAddress"));
            clearHtml($("#addNavBigUrlNames"));
        }
    });

    /**
     * 大栏导航-添加导航-选择链接
     * */
    $("#addNavBigCheckedUrl").click(function () {
        var is = $(this).is(':checked');
        if(is==true){
            $(".addNavBigCats").hide(300);
            $(".addNavBigUrl").show(300);
            clearHtml($("#addNavBigName"));
            clearHtml($("#addNavBigDesc"));
        }
    });

    /**
     * 小栏导航-添加导航-选择分类目录
     * */
    $("#addNavSmallCheckedCats").click(function () {
        var is = $(this).is(':checked');
        if(is==true){
            $(".addNavSmallCats").show(300);
            $(".addNavSmallUrl").hide(300);
            clearHtml($("#addNavSmallName"));
            clearHtml($("#addNavSmallDesc"));
            clearHtml($("#addNavSmallUrlAddress"));
            clearHtml($("#addNavSmallUrlNames"));
        }
    });

    /**
     * 小栏导航-添加导航-选择链接
     * */
    $("#addNavSmallCheckedUrl").click(function () {
        var is = $(this).is(':checked');
        if(is==true){
            $(".addNavSmallCats").hide(300);
            $(".addNavSmallUrl").show(300);
            clearHtml($("#addNavSmallName"));
            clearHtml($("#addNavSmallDesc"));
        }
    });

    /*取消修改*/
    $(".alterCanal").click(function () {
        var obj = $(this).parents(".row");
        obj.hide(500);
    });

    /*打开修改框*/
    $("[class*='edit_']").click(function () {
        var s = $(this).attr("name");
        var str = "row_"+s;
        $("."+str).show(500);
    });

    /*打开添加框*/
    $("[class*='add_']").click(function () {
        var s = $(this).attr("name");
        var str = "row_"+s;
        $("."+str).show(500);
    });
});

/*改变内容并且禁用*/
function changeContentAndDisable(obj,content) {
    var btn_span = obj.children("span");
    btn_span.html(content);
    obj.attr("disabled","true");
}

/*改变内容并且启用*/
function changeContentAndStart(obj,content) {
    var btn_span = obj.children("span");
    btn_span.html(content);
    obj.removeAttr("disabled");
}

/*TIPS*/
function toolTips(msg,type){
    if(type=="default"){
        Notify(msg,'top-right','3000',"info","fa-bell-o",true);
    }else if(type=="error"){
        Notify(msg,'top-right','3000',"danger","fa-flash",true);
    }else if(type=="warning"){
        Notify(msg,'top-right','3000',"warning","fa-warning",true);
    }else if(type=="success"){
        Notify(msg,'top-right','3000',"success","fa-check",false);
    }else{
        Notify(msg,'top-right','3000',"darkorange","fa-frown-o",true);
    }
}
/*清空输入框内容*/
function clearHtml(obj) {
    obj.val("");
}

