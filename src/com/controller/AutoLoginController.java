package com.controller;

import com.beans.User;
import com.dao.UserDao;
import com.service.ajax.LoginService;
import com.utils.Encrypt;
import com.utils.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AutoLoginController", urlPatterns = {"/controller/AutoLoginController.do"})
public class AutoLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object id = request.getSession().getAttribute("id");
        if(id!=null && !"".equals(id)){
            response.sendRedirect("/u/index.html");
            return;
        }
        Cookie[] c = request.getCookies();
        String username = null;
        String password = null;
        for(Cookie ck:c){
            if("UN".equals(ck.getName())){
                username = ck.getValue();
            }
            if("PW".equals(ck.getName())){
                password = ck.getValue();
            }
        }
        if(username!=null && password!=null){
            username = Encrypt.base64Decode(username);
            password = Encrypt.base64Decode(password);
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            Map<String,String> tips = new LoginService().userLoginStart(user,"true",request,response);
            String referer = request.getHeader("referer");
            if("200".equals(tips.get("code"))){
                if(Tools.empty(referer)){
                    referer = "/u/index.html";
                }
                response.sendRedirect(referer);
            }else{
                if(Tools.empty(referer)){
                    referer = "/login.html";
                }
                response.sendRedirect(referer);
            }
        }
    }
}