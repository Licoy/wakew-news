package com.controller.user;

import com.service.user.mainSetService;
import com.utils.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "U_mainSetController", urlPatterns = {"/user/U_mainSetController"})
public class U_mainSetController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(!Tools.isLevelOnPage(request,"10")){
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return;
        }
        Map data = new mainSetService().getMainSet();
        request.setAttribute("data",data);
        request.getRequestDispatcher("/WEB-INF/web/user/mainSet.jsp").forward(request,response);
    }
}