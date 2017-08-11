package com.service.user;

import com.beans.Set;
import com.dao.CategoryDao;
import com.dao.CommentsDao;
import com.dao.NewsDao;
import com.dao.SetDao;
import com.utils.Tools;

import java.util.*;


/*
 * Created by Licoy on 2016/12/20 0020.
 */
public class IndexService {
    /*
    * 查找公告内容
    * */
    public Set selectNotice(){
        Set set = new Set();
        SetDao setDao = new SetDao();
        set = setDao.selectSetByKey("notice");
        return set;
    }

    /*
    *获取当前格式化时间
    * */
    public String getNowDateTime(){
        return Tools.dateFormatHasTime(new Date().getTime());
    }

    /*
    * 获取新闻总数
    * */
    public int getNewCount(){
        NewsDao newsDao = new NewsDao();
        return newsDao.GetNewsCount();
    }

    /*
    * 获取评论总数
    * */
    public int getCommentsCount(){
        CommentsDao commentsDao = new CommentsDao();
        return commentsDao.GetCommentsCount();
    }

    /*
    * 获取分类目录总数
    * */
    public int getCategoryCount(){
        CategoryDao categoryDao = new CategoryDao();
        return categoryDao.GetCategoryCount();
    }

    public Map<String,Object> get(){
        Map<String,Object> map = new HashMap();
        map.put("notice",selectNotice());
        map.put("nowTime",getNowDateTime());
        map.put("newsCount",getNewCount());
        map.put("commentsCount",getCommentsCount());
        map.put("categoryCount",getCategoryCount());
        return map;
    }
}
