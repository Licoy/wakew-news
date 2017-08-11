package com.controller.ajax;

import com.service.ajax.DeleteDataService;
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

@WebServlet(name = "DeleteDataController", urlPatterns = {"/ajax/DeleteDataController.do"})
public class DeleteDataController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*创建相应JSON和Map集合*/
        Map<String,String> tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();
        /*判断是否存在类型*/
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        if(Tools.empty(type) && Tools.empty(id)){
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
        if("news".equals(type)){
            tipsMap = new DeleteDataService().deleteNewsById(Integer.parseInt(id));
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
        if("comments".equals(type)){
            tipsMap = new DeleteDataService().deleteCommentsById(Integer.parseInt(id));
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
        if("category".equals(type)){
            tipsMap = new DeleteDataService().deleteCategoryById(Integer.parseInt(id));
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
        if("user".equals(type)){
            tipsMap = new DeleteDataService().deleteUserById(Integer.parseInt(id));
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
        if("group".equals(type)){
            tipsMap = new DeleteDataService().deleteUserGroupById(Integer.parseInt(id));
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
    }
}