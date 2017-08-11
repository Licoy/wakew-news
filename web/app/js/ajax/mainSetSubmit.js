/**
 * Created by Administrator on 2016/12/25 0025.
 */
$(function () {
    function mainSetSendData(obj) {
        $.post("/ajax/MainSetController.do",$(obj).serialize(),function(data) {
            if(data.code==200){
                x0p(data.msg, null, 'ok', false);
            }else if(data.code==403){
                x0p(data.msg, null, 'error', false);
            }else{
                x0p('未知错误！', null, 'error', false);
            }
        },"json");
    }
   $("#columnSubmit").on("click",function () {
       mainSetSendData("#columnForm");
   });

    $("#slideSubmit").click(function () {
        mainSetSendData("#slideForm");
    });

    $("#searchSubmit").click(function () {
        mainSetSendData("#searchForm");
    });

    $("#footerSubmit").click(function () {
        mainSetSendData("#footerForm");
    });

    $("#clauseSubmit").click(function () {
        mainSetSendData("#clauseForm");
    });




});
