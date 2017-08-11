package com.web.controller;

import com.web.service.RetpasswordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "W_retpasswordController", urlPatterns = {"/web/W_retpasswordController"})
public class W_retpasswordController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,Object> map = null;
        map = new RetpasswordService().getData();
        request.setAttribute("map",map);
        request.getRequestDispatcher("/WEB-INF/web/retpassword.jsp").forward(request,response);

    }
}