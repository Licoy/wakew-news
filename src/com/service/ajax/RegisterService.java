package com.service.ajax;

import com.beans.User;
import com.dao.UserDao;
import com.utils.Encrypt;
import com.utils.Tools;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/20 0020.
 */
public class RegisterService {
    /*
    * 注册用户
    * */
    public Map<String,String> insertUser(User user){
        Map<String,String> tipsMap = new HashMap<>();
         /*对用户信息去除空白符*/
        user.setUsername(user.getUsername().trim());
        user.setUsermail(user.getUsermail().trim());
        user.setPassword(user.getPassword().trim());
        if(Tools.empty(user.getUsername()) || Tools.empty(user.getUsermail()) || Tools.empty(user.getPassword())){
            tipsMap.put("code","403");
            tipsMap.put("msg","所有的内容不能为空!");
            return tipsMap;
        }
        if(!Tools.checkPasswordModel(user.getPassword())){
            tipsMap.put("code","403");
            tipsMap.put("msg","密码应为a-Z|0-9以及下划线组成的6-15个字符");
            return tipsMap;
        }
        UserDao userDao = new UserDao();
        User users1 = userDao.selectUserByUsername(user.getUsername());
        if(users1!=null){
            tipsMap.put("code","403");
            tipsMap.put("msg","用户名已经存在,请试试别的!");
            return tipsMap;
        }
        User users2 = userDao.selectUserByUsermail(user.getUsermail());
        if(users2!=null){
            tipsMap.put("code","403");
            tipsMap.put("msg","该邮箱已经存在!");
            return tipsMap;
        }
        user.setPassword(Encrypt.md5(user.getPassword()));
        int num = userDao.insertUserByObject(user);
        if(num>0){
            tipsMap.put("code","200");
            tipsMap.put("msg","注册成功!");
            return tipsMap;
        }
        tipsMap.put("code","403");
        tipsMap.put("msg","注册失败!");
        return tipsMap;
    }
}
