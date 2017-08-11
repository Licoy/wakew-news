package com.service.ajax;

import com.beans.Group;
import com.beans.User;
import com.dao.GroupDao;
import com.dao.UserDao;
import com.utils.Tools;

import java.util.*;

/*
 * Created by Licoy on 2016/12/22 0022.
 */
public class UserOpterService {
    private UserDao userDao = new UserDao();
    /*
    * 查找指定的用户
    * */
    public User getUserById(int id){
        return userDao.selectUserById(id);
    }

    /*
    * 查找指定的用户组
    * */
    public Group getGroupById(int id){
        return new GroupDao().selectGroupById(id);
    }

    /*
    * 获取指定的用户的信息
    * */
    public Map selectUserInfo(int id){
        Map tipsMap = new HashMap();
        User user = getUserById(id);
        if(user!=null){
            tipsMap.put("code","200");
            tipsMap.put("msg","查询成功!");
            tipsMap.put("id",user.getId());
            tipsMap.put("username",user.getUsername());
            tipsMap.put("usermail",user.getUsermail());
            tipsMap.put("usergroup",user.getUsergroup());
            tipsMap.put("lastlogin", Tools.dateFormatHasTime(user.getLastlogin()));
            tipsMap.put("created",Tools.dateFormatHasTime(user.getCreated()));
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","查询失败!");
        }
        return tipsMap;
    }

    /*
    * 更新用户
    * */
    public Map updateUserInfo(User users){
        Map tipsMap = new HashMap();
        User user = getUserById(users.getId());
        if(user!=null){
            if(!userDao.issetUserDisIdByUsername(users.getUsername(),users.getId())){
                user.setUsername(users.getUsername());
                if(!userDao.issetUserDisIdByUsermail(users.getUsermail(),users.getId())){
                    user.setUsermail(users.getUsermail());
                    if(getGroupById(users.getUsergroup())!=null){
                        user.setUsergroup(users.getUsergroup());
                        int num = userDao.updateUserByObject(user);
                        if(num>0){
                            tipsMap.put("code","200");
                            tipsMap.put("msg","更新成功");
                        }else{
                            tipsMap.put("code","403");
                            tipsMap.put("msg","更新失败!");
                        }
                    }else{
                        tipsMap.put("code","403");
                        tipsMap.put("msg","目标用户组不存在!");
                    }
                }else{
                    tipsMap.put("code","403");
                    tipsMap.put("msg","目标邮箱已经存在!");
                }
            }else{
                tipsMap.put("code","403");
                tipsMap.put("msg","目标用户名已经存在!");
            }
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","不存在目标用户!");
        }
        return tipsMap;
    }



}
