package com.web.controller;

import com.web.service.newestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "W_newestController", urlPatterns = {"/web/W_newestController"})
public class W_newestController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,Object> map = null;
        map = new newestService().getData();
        request.setAttribute("map",map);
        request.getRequestDispatcher("/WEB-INF/web/newest.jsp").forward(request,response);
    }
}