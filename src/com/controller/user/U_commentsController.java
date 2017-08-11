package com.controller.user;

import com.beans.Page;
import com.service.user.CommentsService;
import com.utils.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "U_commentsController", urlPatterns = {"/user/U_commentsController"})
public class U_commentsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(!Tools.isLevelOnPage(request,"4")){
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return;
        }
        String url = "comments.html?";
        String search = request.getParameter("search");
        String text = request.getParameter("searchText");
        String nowPageNum = request.getParameter("page");
        Page page = null;
        if(Tools.empty(nowPageNum)){
            nowPageNum = "1";
        }
        if(!Tools.empty(search)&&!Tools.empty(text)&&("id".equals(search)||"user".equals(search)||"news".equals(search))){
            url = url+"search="+search+"&searchText="+text+"&";
            page = new CommentsService().getSearchCommentsList(Integer.parseInt(nowPageNum),url,search,text);
        }else{
            page = new CommentsService().getDefaultCommentsList(Integer.parseInt(nowPageNum),url);
        }
        request.setAttribute("page",page);
        request.getRequestDispatcher("/WEB-INF/web/user/comments.jsp").forward(request,response);
    }
}