/**
 * Created by Administrator on 2016/12/25 0025.
 */
$(function () {
    function alterInfoSendData(obj) {
        $.post("/ajax/AlterInfoController.do",$(obj).serialize(),function(data) {
            if(data.code==200){
                x0p(data.msg, null, 'ok', false);
            }else if(data.code==403){
                x0p(data.msg, null, 'error', false);
            }else{
                x0p('未知错误！', null, 'error', false);
            }
        },"json").error(function () {
            x0p("请求异常或服务端未作出任何响应", null, 'error', false);
        });
    }

    $("#passwordSubmit").click(function () {
       alterInfoSendData("#passwordForm");
    });

    $("#infoSubmit").click(function () {
       alterInfoSendData("#infoForm");
    });

    /*
    * 头像上传
    * */
    $("#gravaSubmit").click(function () {
        x0p({
            title: '是否将头像替换为已选择文件？',
            text: '将头像替换成功之后，之前的头像将会被替换掉并无法找回。',
            icon: 'info',
            animationType: 'fadeIn',
            buttons: [
                {
                    type: 'info',
                    text: '确认',
                    showLoading: true

                },
                {
                    type: 'cancel',
                    text: '取消'
                }
            ]
        }, function(button) {
            if(button == 'info') {
                $.ajaxFileUpload({
                        url:'/user/U_uploadImagesController?type=grava',
                        secureuri:false,
                        fileElementId:'userImg',
                        dataType: 'text',
                        success: function(data)
                        {
                            datas = eval('('+data+')');
                            if(datas.code==200){
                                $("#nowGrava").prop("src",datas.url);
                                x0p(datas.msg, null, 'ok', false);
                            }else{
                                x0p(datas.msg, null, 'error', false);
                            }

                        },
                        error: function ()
                        {
                            x0p('上传失败！', null, 'error', false);
                        }
                    }
                );
            }
        });

    });
});