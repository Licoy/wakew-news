package com.controller.ajax;

import com.service.ajax.SiteSetService;
import com.utils.Tools;
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

@WebServlet(name = "SiteSetController", urlPatterns = {"/ajax/SiteSetController.do"})
public class SiteSetController extends HttpServlet {
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

        if("notice".equals(type)){
            /*公告*/
            String text = request.getParameter("notice");
            if(Tools.empty(text)){
                tipsMap.put("code","403");
                tipsMap.put("msg","值不能为空!");
            }else{
                tipsMap = new SiteSetService().saveNoticeSet(text);
            }
        }else if("site".equals(type)){
            /*SEO*/
            String text1 = request.getParameter("site-title");
            String text2 = request.getParameter("site-keyword");
            String text3 = request.getParameter("site-describe");
            if(Tools.empty(text1) || Tools.empty(text2) || Tools.empty(text3)){
                tipsMap.put("code","403");
                tipsMap.put("msg","值不能为空!");
            }else{
                tipsMap = new SiteSetService().saveSiteSet(text1,text2,text3);
            }
        }else if("logo".equals(type)){
            /*LOGO*/
            String text = request.getParameter("logo-url");
            if(Tools.empty(text)){
                tipsMap.put("code","403");
                tipsMap.put("msg","值不能为空!");
            }else{
                tipsMap = new SiteSetService().saveLogoSet(text);
            }

        }else if("ico".equals(type)){
            /*ICO*/
            String text = request.getParameter("ico-url");
            if(Tools.empty(text)){
                tipsMap.put("code","403");
                tipsMap.put("msg","值不能为空!");
            }else{
                tipsMap = new SiteSetService().saveIcoSet(text);
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