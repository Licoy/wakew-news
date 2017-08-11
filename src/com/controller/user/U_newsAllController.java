package com.controller.user;

import com.beans.News;
import com.beans.Page;
import com.service.user.NewsAllService;
import com.utils.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "U_newsAllController", urlPatterns = {"/user/U_newsAllController"})
public class U_newsAllController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(!Tools.isLevelOnPage(request,"2")){
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return;
        }
        String url = "newsAll.html?";
        String search = request.getParameter("search");
        String text = request.getParameter("searchText");
        String nowPageNum = request.getParameter("page");
        Page page = null;
        if(Tools.empty(nowPageNum)){
            nowPageNum = "1";
        }
        if(!Tools.empty(search)&&!Tools.empty(text)&&("id".equals(search)||"title".equals(search))){
            url = url+"search="+search+"&searchText="+text+"&";
            page = new NewsAllService().getSearchNewsList(Integer.parseInt(nowPageNum),url,search,text);
        }else{
            page = new NewsAllService().getDefaultNewsList(Integer.parseInt(nowPageNum),url);
        }
        request.setAttribute("page",page);
        request.getRequestDispatcher("/WEB-INF/web/user/news-all.jsp").forward(request,response);
    }
}