package com.controller.user;

import com.service.user.SiteSetService;
import com.utils.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "U_siteSetController", urlPatterns = {"/user/U_siteSetController"})
public class U_siteSetController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(!Tools.isLevelOnPage(request,"11")){
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return;
        }
        Map data = new SiteSetService().getSetData();
        request.setAttribute("data",data);
        request.getRequestDispatcher("/WEB-INF/web/user/siteSet.jsp").forward(request,response);
    }
}