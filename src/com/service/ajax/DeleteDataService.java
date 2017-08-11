package com.service.ajax;


import com.dao.*;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/22 0022.
 */
public class DeleteDataService {
    Map<String,String> tips = new HashMap<>();
    /*
    * 删除新闻
    * */
    public Map<String,String> deleteNewsById(int id){
        NewsDao newsDao = new NewsDao();
        int num = newsDao.deleteNewsById(id);
        if(num>0){
            tips.put("code","200");
            tips.put("msg","操作成功!");
        }else{
            tips.put("code","403");
            tips.put("msg","操作失败!");
        }
        return tips;
    }

    /*
    * 删除评论
    * */
    public Map<String,String> deleteCommentsById(int id){
        CommentsDao commentsDao = new CommentsDao();
        int num = commentsDao.deleteCommentsById(id);
        if(num>0){
            tips.put("code","200");
            tips.put("msg","操作成功!");
        }else{
            tips.put("code","403");
            tips.put("msg","操作失败!");
        }
        return tips;
    }

    /*
    * 删除分类目录
    * */
    public Map<String,String> deleteCategoryById(int id){
        if(id==1){
            tips.put("code","403");
            tips.put("msg","默认分类拒绝删除!");
            return tips;
        }
        int num = new CategoryDao().deleteCategoryById(id);
        if(num>0){
            tips.put("code","200");
            tips.put("msg","操作成功!");
        }else{
            tips.put("code","403");
            tips.put("msg","操作失败!");
        }
        return tips;
    }

    /*
    * 删除用户
    * */
    public Map<String,String> deleteUserById(int id){
        if(id==1){
            tips.put("code","403");
            tips.put("msg","管理员账号不能删除!");
            return tips;
        }
        int num = new UserDao().deleteUserById(id);
        if(num>0){
            tips.put("code","200");
            tips.put("msg","操作成功!");
        }else{
            tips.put("code","403");
            tips.put("msg","操作失败!");
        }
        return tips;
    }

    /*
   * 删除用户组
   * */
    public Map<String,String> deleteUserGroupById(int id){
        if(id==1){
            tips.put("code","403");
            tips.put("msg","默认用户组不能删除!");
            return tips;
        }
        int num = new GroupDao().deleteGroupByObject(id);
        if(num>0){
            tips.put("code","200");
            tips.put("msg","操作成功!");
        }else{
            tips.put("code","403");
            tips.put("msg","操作失败!");
        }
        return tips;
    }
}
