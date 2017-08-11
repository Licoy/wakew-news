package com.web.controller;


import com.web.service.IndexService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "W_indexController", urlPatterns = {"/web/W_indexController"})
public class W_indexController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,Object> map = new IndexService().getIndexData();
        request.setAttribute("map",map);
        request.getRequestDispatcher("/WEB-INF/web/index.jsp").forward(request,response);
    }
}