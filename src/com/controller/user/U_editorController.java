package com.controller.user;

import com.beans.Category;
import com.beans.News;
import com.service.user.EditorService;
import com.utils.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "U_editorController", urlPatterns = {"/user/U_editorController"})
public class U_editorController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(!Tools.isLevelOnPage(request,"3")){
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return;
        }
        Map<String,Object> map = new HashMap<>();
        EditorService editorService = new EditorService();
        String id = request.getParameter("id");
        if(!Tools.empty(id)){
            News news = editorService.selectNewsById(Integer.parseInt(id));
            if(news!=null){
                map.put("news",news);
            }
        }

        /*查询出所有的新闻分类*/

        List<Category> list = editorService.selectAllCategory();
        map.put("cat",list);
        request.setAttribute("map",map);
        request.getRequestDispatcher("/WEB-INF/web/user/editor.jsp").forward(request,response);
    }
}