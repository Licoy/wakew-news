package com.controller.ajax;

import com.service.ajax.CommentsDataService;
import com.utils.CookieUtils;
import com.utils.Encrypt;
import com.utils.Tools;
import org.json.JSONArray;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CommentsDataController", urlPatterns = {"/ajax/CommentsDataController.do"})
public class CommentsDataController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*创建相应JSON和Map集合*/
        Map<String,String> tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();

        String text = request.getParameter("text");
        String parentId = request.getParameter("id");
        String newsId = request.getParameter("newsId");
        Object id = request.getSession().getAttribute("id");
        String lastTime = CookieUtils.FindCookie("lastCom",request);
        /*if(lastTime!=null){
            long lastM = Long.parseLong(lastTime);
            if(System.currentTimeMillis()-lastM<30*1000){
                tipsMap.put("code","403");
                tipsMap.put("msg","你评论的太快了，休息30秒吧~");
                jsonArray.put(tipsMap);
                try {
                    response.getWriter().print(jsonArray.getString(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return;
            }
        }*/
        if(id==null || Tools.empty(text) || !Tools.isNumber(parentId) || !Tools.isNumber(newsId)){
            tipsMap.put("code","403");
            tipsMap.put("msg","缺少或错误参数,无法执行评论操作");
            jsonArray.put(tipsMap);
        }else{
            int ids = (int)id;
            tipsMap = new CommentsDataService().saveComments(response,ids,Integer.parseInt(parentId),text,Integer.parseInt(newsId));
            jsonArray.put(tipsMap);
        }
        try {
            response.getWriter().print(jsonArray.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}