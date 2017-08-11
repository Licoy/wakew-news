/**
 * Created by Administrator on 2016/12/25 0025.
 */
$(function () {
    function siteSetSendData(obj) {
        $.post("/ajax/SiteSetController.do",$(obj).serialize(),function(data) {
            if(data.code==200){
                x0p(data.msg, null, 'ok', false);
            }else if(data.code==403){
                x0p(data.msg, null, 'error', false);
            }else{
                x0p('未知错误！', null, 'error', false);
            }
        },"json");
    }
    $("#noticeSubmit").on("click",function () {
        siteSetSendData("#noticeForm");
    });
    $("#siteSubmit").on("click",function () {
        siteSetSendData("#siteForm");
    });
    $("#logoSubmit").on("click",function () {
        siteSetSendData("#logoForm");
    });
    $("#icoSubmit").on("click",function () {
        siteSetSendData("#icoForm");
    });
});