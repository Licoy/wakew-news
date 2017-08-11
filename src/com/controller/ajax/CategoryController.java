package com.controller.ajax;

import com.beans.Category;
import com.service.ajax.CategoryService;
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
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CategoryController", urlPatterns = {"/ajax/CategoryController.do"})
public class CategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*创建相应JSON和Map集合*/
        Map<String,String> tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();
        Category category = new Category();
        try {
            BeanUtils.populate(category,request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String type = request.getParameter("type");
        if("insert".equals(type) && !Tools.empty(category.getName()) && !Tools.empty(category.getAlias())){
            tipsMap = new CategoryService().insertCategory(category);
        }else if("update".equals(type) && !Tools.empty(category.getName()) && !Tools.empty(category.getAlias())){
            if(category.getId()!=0){
                tipsMap = new CategoryService().updateCategory(category);
            }else{
                tipsMap.put("code","403");
                tipsMap.put("msg","不存在必要参数,无法操作!");
            }
        }else if("select".equals(type) && category.getId()!=0){
            tipsMap = new CategoryService().getCategoryById(category.getId());
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","无效请求!");
        }
        jsonArray.put(tipsMap);
        try {
            response.getWriter().print(jsonArray.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}