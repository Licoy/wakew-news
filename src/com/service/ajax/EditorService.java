package com.service.ajax;

import com.beans.Category;
import com.beans.News;
import com.dao.CategoryDao;
import com.dao.NewsDao;
import com.utils.Tools;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/21 0021.
 */
public class EditorService {
    /*
    * 查找在一天内是否已经存在同名标题文章，不存在返回false
    * */
    public boolean isOneDayTitleRepeat(String title){
        NewsDao newsDao = new NewsDao();
        int num = newsDao.FindNewsInTimeRepeat(1,title);
        return num > 0;
    }

    /*
    * [修改]查找在一天内是否已经存在另外一个同名标题文章，不存在返回false
    * */
    public boolean isOneDayOtherTitleRepeat(String title,int id){
        NewsDao newsDao = new NewsDao();
        int num = newsDao.FindNewsInOtherTimeRepeat(1,title,id);
        return num > 0;
    }

    /*
    * 查找是否存在指定的分类目录
    * */
    public boolean issetCategory(int id){
        CategoryDao categoryDao = new CategoryDao();
        Category category = categoryDao.selectCategoryById(id);
        return category != null;
    }

    /*
    * 进行文章增加
    * */
    public Map<String,String> insertNewsStart(News news){
        Map<String,String> tipsMap = new HashMap<>();
        if(isOneDayTitleRepeat(news.getTitle())){
            tipsMap.put("code","403");
            tipsMap.put("msg","24小时内已经发过重复文章!");
            return tipsMap;
        }
        if(!issetCategory(news.getCategory())){
            tipsMap.put("code","403");
            tipsMap.put("msg","对应分类目录不存在，发布失败!");
            return tipsMap;
        }
        NewsDao newsDao = new NewsDao();
        int num = newsDao.insertNewsByObject(news);
        if(num>0){
            tipsMap.put("code","200");
            tipsMap.put("msg","发布成功!");
            return tipsMap;
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","发布失败!");
            return tipsMap;
        }
    }

    /*
    * 对文章进行修改
    * */
    public Map<String,String> updateNewsStart(News news){
        Map<String,String> tipsMap = new HashMap<>();
        if(news.getId()==0){
            tipsMap.put("code","403");
            tipsMap.put("msg","标识不存在!");
            return tipsMap;
        }
        if(isOneDayOtherTitleRepeat(news.getTitle(),news.getId())){
            tipsMap.put("code","403");
            tipsMap.put("msg","24小时内存在重复文章!");
            return tipsMap;
        }
        if(!issetCategory(news.getCategory())){
            tipsMap.put("code","403");
            tipsMap.put("msg","对应分类目录不存在,无法修改!");
            return tipsMap;
        }
        NewsDao newsDao = new NewsDao();
        int num = newsDao.updateNewsByObject(news);
        if(num>0){
            tipsMap.put("code","200");
            tipsMap.put("msg","修改成功!");
            return tipsMap;
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","修改失败!");
            return tipsMap;
        }
    }

}
