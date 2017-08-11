/**
 * Created by Administrator on 2016/12/30 0030.
 */
$(function () {
    $("#qrcode").qrcode({
        render : "canvas",
        text : getHref(),
        width : "120",
        height : "110",
        background : "#ffffff",
        foreground : "#000000",
        src: '/app/img/weixin.jpg'
    });
    function shareOpen(m) {
        window.open(m,"","top=180,left=200,width=800,height=400");
    }
    function getHref() {
        return window.location.href;
    }
    function getTitle() {
        return document.title;
    }
    $(".share_weibo").click(function () {
        var m = "http://service.weibo.com/share/share.php?url="+getHref()
            +"&title="+getTitle();
        shareOpen(m);
    });
    $(".share_qq").click(function () {
        var m = "http://connect.qq.com/widget/shareqq/index.html?url="+getHref()
            +"&title="+getTitle()+"&source="+getTitle()+"&desc="+getTitle();
        shareOpen(m);
    });
    $(".share_tweibo").click(function () {
        var m = "http://share.v.t.qq.com/index.php?c=share&a=index&title="+getTitle()
            +"&url="+getHref();
        shareOpen(m);
    });
    $(".share_twitter").click(function () {
        var m = "https://twitter.com/intent/tweet?text="+getTitle()
            +"&url="+getHref()+"&via="+document.domain;
        shareOpen(m);
    });
    $(".share_weixin").hover(function () {
        $("#qrcode").show(200);
    },function () {
        $("#qrcode").hide(200);
    });

});