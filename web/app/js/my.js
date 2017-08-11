/**
 * Created by Administrator on 2016/12/7.
 */
function W_trim(str) {
    return $.trim(str);
}
function W_empty(str) {
    if(str=="" || str==null){
        return true;
    }else{
        return false;
    }
}
function W_isLength(str,len) {
    if(str.length<len){
        return false;
    }
    return true;
}

function W_isEmail(mail) {
    var re = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (re.test(mail)) {
        return true;
    }else{
        return false;
    }

}
function W_isNumberMu(str) {
    var re = /^[a-zA-z]\w{5,14}$/;
    if(re.test(str)){
        return true;
    }else{
        return false;
    }
}

function checkPassword(str) {
    var re = /^(\w){6,15}$/;
    if(re.test(str)){
        return true;
    }else{
        return false;
    }
}

/*
* 判断是否是数字
* */
function checkIsNumber(str) {
    var re = /^[0-9]*$/;
    if(re.test(str)){
        return true;
    }else{
        return false;
    }
}
jQuery(function () {

    var ISONSIDEBAR = true;
    var ADFONT = false;

    /*
    * 搜索
    * */
    function searchStart() {
        var val = $("#searchText").val();
        location="/search/"+val;
    }
    $("#searchText").keydown(function (e) {
        if(e.which == 13) {
            searchStart();
            return false;
        }
    });
    $("#searchSubmit").click(function () {
        searchStart();
    });
    /*
    * 开启或关闭侧边栏
    * */
    $(".on-off-sidebar").on("click",function () {
        if(ISONSIDEBAR){
            $(".sidebar").hide(300);
            $("#article").width(1000);
            var obj = $(this).children(".fa-toggle-on");
            obj.attr("class","fa fa-toggle-off");
            ISONSIDEBAR = false;
        }else{
            $(".sidebar").show(300);
            $("#article").width(650);
            var obj = $(this).children(".fa-toggle-off");
            obj.attr("class","fa fa-toggle-on");
            ISONSIDEBAR = true;
        }
    });

    /*
    * 字体调整
    * */
    $(".ad-font").on("click",function () {
        var obj = $(this).children("em");
        var content = $(".article-text p");
        if(!ADFONT){
            content.attr("style","font-size:20px");
            obj.html("-");
            ADFONT = true;
        }else{
            content.removeAttr("style");
            obj.html("+");
            ADFONT = false;
        }
    });

    $("#checkImg").click(function () {
        var s = $(this).attr("src");
        $(this).attr("src",s+"?"+new Date().getTime());
    })
});
