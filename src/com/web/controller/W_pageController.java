package com.web.controller;

import com.beans.Page;
import com.utils.Tools;
import com.web.service.PageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "W_pageController", urlPatterns = {"/web/W_pageController"})
public class W_pageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,Object> map = null;
        String nowPageNum = request.getParameter("page");
        Page page = null;
        if(Tools.empty(nowPageNum) || !Tools.isNumber(nowPageNum)){
            nowPageNum = "1";
        }
        String category = request.getParameter("category");
        String id = request.getParameter("id");

        if(Tools.empty(category) || Tools.empty(id) ||!Tools.isNumber(id)){
            request.getRequestDispatcher("/error.jsp");
            return;
        }else{
            map = new PageService().getPageData(Integer.parseInt(id),Integer.parseInt(nowPageNum));
            if(map==null){
                request.getRequestDispatcher("/error.jsp");
                return;
            }else{
                request.setAttribute("map",map);
            }
        }
        request.getRequestDispatcher("/WEB-INF/web/page.jsp").forward(request,response);
    }
}