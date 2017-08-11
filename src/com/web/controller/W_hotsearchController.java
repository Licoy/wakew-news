package com.web.controller;

import com.web.service.hotsearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "W_hotsearchController", urlPatterns = {"/web/W_hotsearchController"})
public class W_hotsearchController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,Object> map = null;
        map = new hotsearchService().getData();
        request.setAttribute("map",map);
        request.getRequestDispatcher("/WEB-INF/web/hotsearch.jsp").forward(request,response);
    }
}