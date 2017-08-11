package com.web.controller;

import com.utils.Tools;
import com.web.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "W_searchController", urlPatterns = {"/web/W_searchController"})
public class W_searchController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s = request.getParameter("s");
        String nowPageNum = request.getParameter("page");
        if(Tools.empty(nowPageNum) || !Tools.isNumber(nowPageNum)){
            nowPageNum = "1";
        }
        Map<String,Object> map = null;
        map = new SearchService().getData(s,Integer.parseInt(nowPageNum));
        request.setAttribute("map",map);
        request.getRequestDispatcher("/WEB-INF/web/search.jsp").forward(request,response);
    }
}