package com.controller.ajax;

import com.service.ajax.AlterInfoService;
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

@WebServlet(name = "AlterInfoController", urlPatterns = {"/ajax/AlterInfoController.do"})
public class AlterInfoController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*创建相应JSON和Map集合*/
        Map<String,String> tipsMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();

        String id = request.getSession().getAttribute("id")+"";
        String type = request.getParameter("type");
        /*缺少必要参数*/
        if(Tools.empty(id) || Tools.empty(type)){
            tipsMap.put("code","403");
            tipsMap.put("msg","缺少必要参数,无法继续!");
            jsonArray.put(tipsMap);
            try {
                response.getWriter().print(jsonArray.getString(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return;
        }

        if("alterPassword".equals(type)){
            /*修改密码*/
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            String newPassword_V = request.getParameter("newPassword_V");
            if(Tools.empty(oldPassword) || Tools.empty(newPassword) || Tools.empty(newPassword_V)){
                tipsMap.put("code","403");
                tipsMap.put("msg","缺少参数,值不能为空!");
            }else{
                if(!newPassword.equals(newPassword_V)){
                    tipsMap.put("code","403");
                    tipsMap.put("msg","确认密码两次输入不一致!");
                }else{
                    tipsMap = new AlterInfoService().alterPassword(Integer.parseInt(id),oldPassword,newPassword);
                }
            }

        }else if("alterInfo".equals(type)){
            /*修改信息*/
            String usermail = request.getParameter("usermail");
            if(Tools.empty(usermail)){
                tipsMap.put("code","403");
                tipsMap.put("msg","缺少参数,值不能为空!");
            }else{
                tipsMap = new AlterInfoService().alterInfo(Integer.parseInt(id),usermail);
            }
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","无效请求");
        }

        jsonArray.put(tipsMap);
        try {
            response.getWriter().print(jsonArray.getString(0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}