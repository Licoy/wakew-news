package com.service.user;

import com.beans.Group;
import com.beans.Level;
import com.beans.Page;
import com.dao.GroupDao;
import com.dao.LevelDao;

import java.util.List;

/*
 * Created by Licoy on 2016/12/23 0023.
 */
public class UserGroupService {
    private GroupDao groupDao = new GroupDao();
    /*
    * 获取所有权限信息
    * */
    public List<Level> getAllLevel(){
       return new LevelDao().selectAllLevel();
    }

    /*
    * 查询用户组权限对应的权限名称
    * */
    public StringBuffer getLevelInfo(String level){
        String[] s = level.split(",");
        LevelDao levelDao = new LevelDao();
        StringBuffer sb  = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            if(i==s.length-1){
                sb.append(levelDao.selectLevelNameById(Integer.parseInt(s[i])));
            }else{
                sb.append(levelDao.selectLevelNameById(Integer.parseInt(s[i]))).append("、");
            }

        }
        return sb;
    }

    /*
    * 统计用户组总数
    * */
    public int getGroupCount(){
        return groupDao.getGorupCount();
    }

    /*
    * 统计模糊搜索总数
    * */
    public int getLikeGroupCount(String type,String value){
        return groupDao.getGorupCount(type,value);
    }

    /*
    * 获取当前页用户组列表
    * */
    public List<Group> getGroup(int begin,int end){
        return groupDao.selectAllGroup(begin,end);
    }

    /*
    * 获取当前搜索页用户组列表
    * */
    public List<Group> getLikeGroup(int begin,int end,String type,String value){
        return groupDao.selectLikeGroup(begin, end, type, value);
    }

    /*
    * 默认数据
    * */
    public Page getDefaultGroup(int nowPageNum,String url){
        int count = getGroupCount();
        Page page = new Page(nowPageNum,count,url);
        List<Group> list  = getGroup(page.getStartIndex(),page.getPageSize());
        for (Group g:list){
            g.getAttr().put("group",getLevelInfo(g.getLevel()));
        }
        List<Level> level = getAllLevel();
        page.getAttr().put("level",level);
        page.setList(list);
        return page;
    }

    /*
    * 搜索数据
    * */
    public Page getSearchGroup(int nowPageNum,String url,String type,String value){
        int count = getLikeGroupCount(type,value);
        Page page = new Page(nowPageNum,count,url);
        List<Group> list = getLikeGroup(page.getStartIndex(),page.getPageSize(),type,value);
        for (Group g:list){
            g.getAttr().put("group",getLevelInfo(g.getLevel()));
        }
        List<Level> level = getAllLevel();
        page.getAttr().put("level",level);
        page.setList(list);
        return page;
    }

}
