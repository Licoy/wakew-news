package com.controller.user;

import com.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "U_logoutController", urlPatterns = {"/user/U_logoutController"})
public class U_logoutController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        CookieUtils.clearCookie("IS",response);
        CookieUtils.clearCookie("UN",response);
        CookieUtils.clearCookie("PW",response);
        response.sendRedirect("/login.html");
    }
}