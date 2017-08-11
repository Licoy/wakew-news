package com.controller.user;

import com.service.user.IndexService;
import com.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "U_indexController", urlPatterns = {"/user/U_indexController"})
public class U_indexController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,Object> map = new IndexService().get();
        request.setAttribute("map",map);
        request.getRequestDispatcher("/WEB-INF/web/user/index.jsp").forward(request,response);
    }
}