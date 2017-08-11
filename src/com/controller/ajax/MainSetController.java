package com.controller.ajax;

import com.service.ajax.MainSetService;
import com.utils.Tools;
import org.json.JSONArray;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "MainSetController", urlPatterns = {"/ajax/MainSetController.do"})
public class MainSetController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         /*创建相应JSON和Map集合*/
        Map<String,String> tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();

        String type = request.getParameter("type");

        /*缺少必要参数*/
        if(Tools.empty(type)){
            tipsMap.put("code","403");
            tipsMap.put("msg","参数不合法!");
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }

        if("column".equals(type)){
            /*分类目录*/
            String columnIndexFooter = request.getParameter("column-index-footer");
            String columnIndexSlidebar = request.getParameter("column-index-slidebar");
            String columnPageSlidebar = request.getParameter("column-page-slidebar");
            if(Tools.empty(columnIndexFooter) || Tools.empty(columnIndexSlidebar) || Tools.empty(columnPageSlidebar)){
                tipsMap.put("code","403");
                tipsMap.put("msg","内容不可以为空，至少每个选项保留一个值");
            }else{
                tipsMap = new MainSetService().saveColumnSet(columnIndexFooter,columnIndexSlidebar,columnPageSlidebar);
            }

        }else if("slide".equals(type)){
            /*幻灯*/
            String slideMaxNumber = request.getParameter("slide-max-number");
            if(Tools.empty(slideMaxNumber) || !Tools.isNumber(slideMaxNumber)){
                tipsMap.put("code","403");
                tipsMap.put("msg","参数值有误");
            }else{
                tipsMap = new MainSetService().saveSlideSet(Integer.parseInt(slideMaxNumber));
            }

        }else if("search".equals(type)){
            /*搜索框*/
            String text = request.getParameter("search-placeholder");
            if(Tools.empty(text)){
                tipsMap.put("code","403");
                tipsMap.put("msg","参数值有误");
            }else{
                tipsMap = new MainSetService().saveSearchSet(text);
            }

        }else if("footer".equals(type)){
            /*底部设置*/
            String text = request.getParameter("footer");
            if(Tools.empty(text)){
                tipsMap.put("code","403");
                tipsMap.put("msg","参数值有误");
            }else{
                tipsMap = new MainSetService().saveFooterSet(text);
            }

        }else if("clause".equals(type)){
            /*条款*/
            String text = request.getParameter("register-clause");
            if(Tools.empty(text)){
                tipsMap.put("code","403");
                tipsMap.put("msg","参数值有误");
            }else{
                tipsMap = new MainSetService().saveClauseSet(text);
            }

        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","参数不合法!");
        }

        jsonArray.put(tipsMap);
        try {
            response.getWriter().print(jsonArray.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}