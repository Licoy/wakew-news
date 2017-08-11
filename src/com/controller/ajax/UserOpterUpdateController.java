package com.controller.ajax;

import com.beans.User;
import com.service.ajax.UserOpterService;
import com.utils.Tools;
import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONArray;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UserOpterUpdateController", urlPatterns = {"/ajax/UserOpterUpdateController.do"})
public class UserOpterUpdateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*创建相应JSON和Map集合*/
        Map tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String type = request.getParameter("type");
        if(Tools.empty(type) && user.getId()==0){
            tipsMap.put("code","403");
            tipsMap.put("msg","不存在必要参数,无法操作!");
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
        if("select".equals(type)){
            tipsMap = new UserOpterService().selectUserInfo(user.getId());
        }else if("update".equals(type)){
            tipsMap = new UserOpterService().updateUserInfo(user);
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