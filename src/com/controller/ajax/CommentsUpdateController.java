package com.controller.ajax;

import com.service.ajax.CommentsUpdateService;
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

@WebServlet(name = "CommentsUpdateController", urlPatterns = {"/ajax/CommentsUpdateController.do"})
public class CommentsUpdateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         /*创建相应JSON和Map集合*/
        Map<String,String> tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();

        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String text = request.getParameter("text");
        if(Tools.empty(id) || Tools.empty(type)){
            tipsMap.put("code","403");
            tipsMap.put("msg","非法请求!");
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
        if("select".equals(type)){
            tipsMap = new CommentsUpdateService().getCommentsTextById(Integer.parseInt(id));
        }else if("update".equals(type)){
            if(Tools.empty(text)){
                tipsMap.put("code","403");
                tipsMap.put("msg","评论内容不可以为空值!");
                jsonArray.put(tipsMap);
                try {
                    response.getWriter().print(jsonArray.getString(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return;
            }
            tipsMap = new CommentsUpdateService().updateCommentsTextById(Integer.parseInt(id),text);
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","无效请求!");
        }
        jsonArray.put(tipsMap);
        try {
            response.getWriter().print(jsonArray.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}