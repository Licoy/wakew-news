package com.service.user;

import com.beans.Group;
import com.beans.Page;
import com.beans.User;
import com.dao.CommentsDao;
import com.dao.GroupDao;
import com.dao.UserDao;

import java.util.List;

/*
 * Created by Licoy on 2016/12/22 0022.
 */
public class UserService {
    private UserDao userDao = new UserDao();
    /*
    * 统计指定用户的评论数量
    * */
    public int getCommentsCount(int id){
        return new CommentsDao().GetCommentsCountByUserId(id);
    }

    /*
    * 获取指定的用户组信息
    * */
    public Group getGroupNameById(int id){
        return new GroupDao().selectGroupById(id);
    }

    /*
    * 获取用户总数
    * */
    public int getUserCount(){
        return userDao.getUserCount();
    }

    /*
    * 获取模糊搜索用户数量
    * */
    public int getLikeUserCount(String type,String value){
        return userDao.getLikeUserCount(type,value);
    }

    /*
    * 获取当前页用户列表
    * */
    public List<User> getUser(int begin,int end){
        return userDao.selectAllUser(begin,end);
    }

    /*
    * 获取模糊搜索当前页用户列表
    * */
    public List<User> getLikeUser(int begin,int end,String type,String value){
        return userDao.selectLikeUser(begin,end,type,value);
    }

    /*
    * 获取搜索的用户组
    * */
    public List<Group> getAllGroup(){
        return new GroupDao().selectAllGroup(0,1000);
    }

    /*
    * 获取默认数据
    * */
    public Page getDefaultUserList(int nowPageNum,String url){
        int count = getUserCount();
        Page page  = new Page(nowPageNum,count,url);
        List<User> list = getUser(page.getStartIndex(),page.getPageSize());
        for (User u:list){
            u.getAttr().put("commentsNum",getCommentsCount(u.getId()));
            u.getAttr().put("group",getGroupNameById(u.getUsergroup()));
            u.getAttr().put("groups",getAllGroup());
        }
        page.setList(list);
        return page;
    }

    /*
    * 获取搜索数据
    * */
    public Page getSearchUserList(int nowPageNum,String url,String type,String value){
        int count = getLikeUserCount(type,value);
        Page page  = new Page(nowPageNum,count,url);
        List<User> list = getLikeUser(page.getStartIndex(),page.getPageSize(),type,value);
        for (User u:list){
            u.getAttr().put("commentsNum",getCommentsCount(u.getId()));
            u.getAttr().put("group",getGroupNameById(u.getId()));
            u.getAttr().put("groups",getAllGroup());
        }
        page.setList(list);
        return page;
    }
}
