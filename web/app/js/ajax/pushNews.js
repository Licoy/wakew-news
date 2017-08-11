/**
 * Created by Administrator on 2016/12/21 0021.
 */
$(function () {
    $(".push_news").on("click",function () {
        var info = [];
        info[0] = $("input[name=news_title]").val();
        info[1] = $("input[name=tags]").val();
        info[2] = $("input[name=slideImg]").val();
        info[3] = $("input[name=impnews]").is(":checked");
        info[4] = $("input[name=slide]").is(":checked");
        info[5] = $("select[name=new_category]").val();
        info[6] = $("textarea[name=content]").val();
        for(var i=0;i<info.length;i++){
            info[i] = $.trim(info[i]);
        }
        info[3] = info[3]=="true" ? 1 : 0;
        info[4] = info[4]=="true" ? 1 : 0;
        if(info[0]==""){
            x0p("新闻标题不能为空", null, 'error', false);
            return false;
        }else if(info[5]==""){
            x0p("新闻分类不能为空", null, 'error', false);
            return false;
        }else if(info[6]==""){
            x0p("内容不能为空", null, 'error', false);
            return false;
        }else{
            var infos = {title:info[0],category:info[5],text:info[6],tag:info[1],slide:info[4],impnews:info[3],
                slideImg:info[2],type:"add"};
            $.post("/ajax/EditorController.do",infos,function(data) {
                if(data.code==200){
                    x0p(data.msg+"<br>即将转至新闻管理页", null, 'ok', false);
                    setTimeout('location="newsAll.html"',1500);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p("未知错误", null, 'error', false);
                }
            },"json");
        }
    });
    $(".update_news").on("click",function () {
        var info = [];
        info[0] = $("input[name=news_title]").val();
        info[1] = $("input[name=tags]").val();
        info[2] = $("input[name=slideImg]").val();
        info[3] = $("input[name=impnews]").is(":checked");
        info[4] = $("input[name=slide]").is(":checked");
        info[5] = $("select[name=new_category]").val();
        info[6] = $("textarea[name=content]").val();
        info[7] = $("input[name=news_id]").val();
        for(var i=0;i<info.length;i++){
            info[i] = $.trim(info[i]);
        }
        info[3] = info[3]=="true" ? 1 : 0;
        info[4] = info[4]=="true" ? 1 : 0;
        if(info[0]==""){
            x0p("新闻标题不能为空", null, 'error', false);
            return false;
        }else if(info[5]==""){
            x0p("新闻分类不能为空", null, 'error', false);
            return false;
        }else if(info[6]==""){
            x0p("内容不能为空", null, 'error', false);
            return false;
        }else if(info[7]==""){
            x0p("标识为空,不能进行修改", null, 'error', false);
            return false;
        }else{
            var infos = {title:info[0],category:info[5],text:info[6],tag:info[1],slide:info[4],impnews:info[3],
                        slideImg:info[2],id:info[7],type:"up"};
            $.post("/ajax/EditorController.do",infos,function(data) {
                if(data.code==200){
                    x0p(data.msg+"<br>即将转至新闻管理页", null, 'ok', false);
                    setTimeout('location="newsAll.html"',1500);
                }else if(data.code==403){
                    x0p(data.msg, null, 'error', false);
                }else{
                    x0p("未知错误", null, 'error', false);
                }
            },"json");
        }
    });
});
