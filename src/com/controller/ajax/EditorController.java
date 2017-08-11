package com.controller.ajax;

import com.beans.News;
import com.service.ajax.EditorService;
import com.utils.Tools;
import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONArray;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "EditorController", urlPatterns = {"/ajax/EditorController.do"})
public class EditorController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*创建相应JSON和Map集合*/
        Map<String,String> tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();
        /*判断是否存在类型*/
        String type = request.getParameter("type");
        if(Tools.empty(type) && !"add".equals(type) && !"up".equals(type)){
            tipsMap.put("code","403");
            tipsMap.put("msg","非法请求!");
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
        /*判断是否登录*/
        String id = request.getSession().getAttribute("id")+"";
        if(Tools.empty(id)){
            tipsMap.put("code","403");
            tipsMap.put("msg","非法发表!");
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
        News news = new News();
        try {
            BeanUtils.populate(news,request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(Tools.empty(news.getTitle())){
            tipsMap.put("code","403");
            tipsMap.put("msg","标题不能为空!");
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }else if(news.getCategory()==0){
            tipsMap.put("code","403");
            tipsMap.put("msg","分类目录有误!");
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }else if(Tools.empty(news.getText())){
            tipsMap.put("code","403");
            tipsMap.put("msg","文章内容不能为空!");
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }
        news.setAuthor(Integer.parseInt(id));
        if("add".equals(type)){
            tipsMap = new EditorService().insertNewsStart(news);
        }else{
            tipsMap = new EditorService().updateNewsStart(news);
        }
        jsonArray.put(tipsMap);
        try {
            response.getWriter().print(jsonArray.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}