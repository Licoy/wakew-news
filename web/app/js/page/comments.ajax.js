/**
 * Created by Administrator on 2016/12/28 0028.
 */
var CommentsReplyNowObjId;
var CommentsReplyCount = 0;
$(function () {
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };
   $("a[id*=commentsReply_]").click(function () {
        if(CommentsReplyCount==0){
            CommentsReplyNowObjId = $(this).prop("id");
            ++CommentsReplyCount;
        }else{
            if($(this).prop("id")!=CommentsReplyNowObjId){
                $("#"+CommentsReplyNowObjId).children("span").children("em").html("回复");
                CommentsReplyNowObjId = $(this).prop("id");
            }
        }
       var oldObj = $("#oldCommentsReply");
       var parentObj = $("#commentsReply");
       parentObj.children("textarea").val("");
       var attrId = $(this).prop("id");
       var id = (attrId.split("_"))[1];
       var textObj = $(this).parent().parent();
       var replyObj = $(this).children("span").children("em");
       var tips = replyObj.html();
       var checkClass = textObj.children("#commentsReply").attr("class");
       if(checkClass==undefined){
           textObj.append(parentObj);
       }
       if(tips=="回复"){
           replyObj.html("取消回复");
       }else{
           oldObj.append(textObj.children("#commentsReply"));
           replyObj.html("回复");
       }
   });

    /*发送评论*/
    $(".comments-submit").click(function () {
        var oldObj = $("#oldCommentsReply");
        var textObj = $("#commentsReply");
        var idObj = $(this).parent().parent();
        var newsId = ($("#article").prop("class").split("_"))[1];
        var id = (idObj.prop("id").split("_"))[1];
        if(id==undefined){
            id = 0;
        }
        if(!checkIsNumber(id) || !checkIsNumber(newsId)){
            zeroModal.error("参数提取错误,无法执行评论操作!");
        }else{
            var text = textObj.children("textarea").val();
            text = $.trim(text);
            if(text==""){
                zeroModal.error("评论内容不能为空!");
            }else if(text.length>255){
                zeroModal.error("评论字符不能超过255个字符!");
            }else{
                $.post("/ajax/CommentsDataController.do",{text:text,id:id,newsId:newsId},function(data) {
                    if(data.code==200){
                        if(id!=0){
                            var appendStr = "<div class=\"c1\" style=\"background-color:#f7f7f7;" +
                                "border-radius:5px;padding:10px 10px\">\n" +
                                "    <div class=\"gravatar\">\n" +
                                "        <img src=\""+data.grava+"\" alt=\""+data.username+"\">\n" +
                                "    </div>\n" +
                                "    <div class=\"username\">"+data.username+"</div>\n" +
                                "    <div class=\"clear_float\"></div>\n" +
                                "    <div class=\"text\" id=\"commentsText_2\">\n" +
                                "        <p class=\"z\">"+data.text+"\n" +
                                "        </p>\n" +
                                "        <div class=\"info\">\n" +
                                "            <span><i class=\"fa fa-paper-plane-o\"></i>#0</span>\n" +
                                "            <span><i class=\"fa fa-clock-o\"></i>"+new Date().Format("yyyy-MM-dd hh:mm:ss")+"</span>\n" +
                            /*    "            <a><span><i class=\"fa fa-thumbs-o-up\"></i>0</span></a>\n" +*/
                                "        </div>\n" +
                                "        <div class=\"clear_float\"></div>\n" +
                                "    </div>\n" +
                                "</div>";
                            textObj.parent().after(appendStr);
                        }else{
                            var appendStr = "<li style=\"background-color:#f7f7f7;" +
                                "border-radius:5px;padding:10px 10px\">\n" +
                                "    <div class=\"gravatar\">\n" +
                                "        <img src=\""+data.grava+"\" alt=\""+data.username+"\">\n" +
                                "    </div>\n" +
                                "    <div class=\"username\">"+data.username+"</div>\n" +
                                "    <div class=\"clear_float\"></div>\n" +
                                "    <div class=\"text\" id=\"commentsText_2\">\n" +
                                "        <p class=\"z\">"+data.text+"\n" +
                                "        </p>\n" +
                                "        <div class=\"info\">\n" +
                                "            <span><i class=\"fa fa-paper-plane-o\"></i>#0</span>\n" +
                                "            <span><i class=\"fa fa-clock-o\"></i>"+new Date().Format("yyyy-MM-dd hh:mm:ss")+"</span>\n" +
                              /*  "            <a><span><i class=\"fa fa-thumbs-o-up\"></i>0</span></a>\n" +*/
                                "        </div>\n" +
                                "        <div class=\"clear_float\"></div>\n" +
                                "    </div>\n" +
                                "</li>";
                            $(".comments-list>.ul-list>li:first").before(appendStr);
                        }
                        $(".comments-not").hide();
                        textObj.parent().children(".info").children("a").children("span").children("em").html("回复");
                        oldObj.append(textObj);
                        textObj.children("textarea").val("");
                    }else if(data.code==403){
                        zeroModal.error(data.msg);
                    }else{
                        zeroModal.error("未知错误");
                    }
                },"json");
            }
        }
    });

});