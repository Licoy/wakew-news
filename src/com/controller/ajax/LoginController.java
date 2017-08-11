package com.controller.ajax;

import com.beans.User;
import com.service.ajax.LoginService;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginController", urlPatterns = {"/ajax/LoginController.do"})
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ajaxHeader = request.getHeader("x-requested-with");
        String is = request.getParameter("is");
        if(!"XMLHttpRequest".toUpperCase().equals(ajaxHeader.toUpperCase())) {
            return;
        }
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
        }catch (Exception e) {
            e.printStackTrace();
        }
        /*创建相应JSON和Map集合*/
        Map<String,String> tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();
        /*获取请求的验证码是否正确*/
        if(!Tools.isCheckCode(request)){
            tipsMap.put("code","403");
            tipsMap.put("msg","验证码错误!");
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
        /*开始登录*/
        user.setIp(Tools.getIpAddress(request));
        LoginService loginService = new LoginService();
        tipsMap = loginService.userLoginStart(user,is,request,response);
        jsonArray.put(tipsMap);
        try {
            response.getWriter().print(jsonArray.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}