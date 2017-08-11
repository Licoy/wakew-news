package com.web.controller;

import com.web.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "W_loginController", urlPatterns = {"/web/W_loginController"})
public class W_loginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,Object> map = null;
        map = new LoginService().getData();
        request.setAttribute("map",map);
        request.getRequestDispatcher("/WEB-INF/web/login.jsp").forward(request,response);
    }
}