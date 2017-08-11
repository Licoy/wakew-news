package com.controller.user;

import com.beans.User;
import com.service.user.AlterinfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "U_alterinfoController", urlPatterns = {"/user/U_alterinfoController"})
public class U_alterinfoController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getSession().getAttribute("id")+"";
        User user = new AlterinfoService().getNowUserInfo(Integer.parseInt(id));
        request.setAttribute("user",user);
        request.getRequestDispatcher("/WEB-INF/web/user/alterinfo.jsp").forward(request,response);
    }
}