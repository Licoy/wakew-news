package com.service.ajax;

import com.beans.Group;
import com.beans.Level;
import com.beans.User;
import com.dao.GroupDao;
import com.dao.UserDao;
import com.utils.CookieUtils;
import com.utils.Encrypt;
import com.utils.Tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/20 0020.
 */
public class LoginService {

    /*
    * 查询用户组对应的权限
    * */
    private Group getGroupLevel(int id){
        return new GroupDao().selectGroupById(id);
    }
    /*
    * 用户登录
    * */
    public Map<String,String> userLoginStart(User user, String is, HttpServletRequest request, HttpServletResponse response){
        Map<String,String> tipsMap = new HashMap<>();
         /*对用户信息去除空白符*/
        user.setUsername(user.getUsername().trim());
        user.setPassword(user.getPassword().trim());
        if(Tools.empty(user.getUsername()) || Tools.empty(user.getPassword())){
            tipsMap.put("code","403");
            tipsMap.put("msg","所有的内容不能为空!");
            return tipsMap;
        }
        UserDao userDao = new UserDao();
        User users = userDao.selectUserByUsername(user.getUsername());
        if(users==null){
            tipsMap.put("code","403");
            tipsMap.put("msg","不存在此用户!");
            this.clearCookie(response);
            return tipsMap;
        }else if(!Encrypt.md5(user.getPassword()).equals(users.getPassword())){
            tipsMap.put("code","403");
            tipsMap.put("msg","密码不正确!");
            this.clearCookie(response);
            return tipsMap;
        }

        /*记住登录状态*/
        if("true".equals(is)){
            CookieUtils.addCookie("UN",users.getUsername(),response);
            CookieUtils.addCookie("PW",user.getPassword(),response);
            CookieUtils.addCookie("IS","IsAutoLogin",response);
        }else{
            this.clearCookie(response);
        }
        request.getSession().setAttribute("id",users.getId());
        request.getSession().setAttribute("name",users.getUsername());
        request.getSession().setAttribute("level",getGroupLevel(users.getUsergroup()).getLevel());
        String grava = users.getGrava();
        if(!Tools.empty(grava)){
            /*CookieUtils.addCookie("Grava",grava,response);*/
        }
        tipsMap.put("code","200");
        tipsMap.put("msg","登录成功!");
        return tipsMap;
    }

    public void clearCookie(HttpServletResponse response){
        CookieUtils.clearCookie("UN",response);
        CookieUtils.clearCookie("PW",response);
        CookieUtils.clearCookie("IS",response);
    }
}
