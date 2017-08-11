package com.controller.ajax;

import com.service.ajax.UserGroupService;
import com.utils.Tools;
import org.json.JSONArray;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UserGroupController", urlPatterns = {"/ajax/UserGroupController.do"})
public class UserGroupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         /*创建相应JSON和Map集合*/
        Map tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();

        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String le = request.getParameter("le");
        String[] s = request.getParameterValues("level");
        if(Tools.empty(type)){
            tipsMap.put("code","403");
            tipsMap.put("msg","缺少用户组名或其他必要参数!");
        }else if("insert".equals(type)){
            if(s==null){
                tipsMap.put("code","403");
                tipsMap.put("msg","用户组不可一项权限都没有!");
            }else{
                tipsMap = new UserGroupService().insertUserGroup(name,s);
            }
        }else if("update".equals(type)){
            if(Tools.empty(id) || Tools.empty(name) || Tools.empty(le)){
                tipsMap.put("code","403");
                tipsMap.put("msg","缺少用户组信息或其他必要参数!");
            }else{
                tipsMap = new UserGroupService().updateUserGroup(Integer.parseInt(id),name,le);
            }
        }else if("select".equals(type)){
            if(Tools.empty(id)){
                tipsMap.put("code","403");
                tipsMap.put("msg","缺少用户组信息或其他必要参数!");
            }else{
                tipsMap = new UserGroupService().selectUserGroup(Integer.parseInt(id));
            }
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