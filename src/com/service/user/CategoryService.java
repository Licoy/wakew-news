package com.service.user;

import com.beans.Category;
import com.beans.Page;
import com.dao.CategoryDao;
import com.dao.NewsDao;

import java.util.List;

/*
 * Created by Licoy on 2016/12/22 0022.
 */
public class CategoryService {
    private CategoryDao categoryDao = new CategoryDao();
    /*
    * 统计指定分类目录下的新闻总数
    * */
    public int getCategoryNewsCount(int id){
        return new NewsDao().GetCategoryNewsCount(id);
    }

    /*
    * 获取分类目录总数
    * */
    public int getCategoryCount(){
        return categoryDao.GetCategoryCount();
    }

    /*
    * 获取模糊查询分类目录总数
    * */
    public int getLikeCategoryCount(String type,String value){
        return categoryDao.GetLikeCategoryCount(type,value);
    }

    /*
    * 获取当前页分类目录
    * */
    public List<Category> getCategory(int begin, int end){
        return categoryDao.selectAllCategory(begin,end);
    }

    /*
    * 获取模糊查询当前页分类
    * */
    public List<Category> getLikeCategory(int begin,int end,String type,String value){
        return categoryDao.selectLikeCategory(begin,end,type,value);
    }

    /*
    * 获取默认浏览数据
    * */
    public Page getDefaultCategory(int nowPageNum,String url){
        int count = getCategoryCount();
        Page page = new Page(nowPageNum,count,url);
        List<Category> list = getCategory(page.getStartIndex(),page.getPageSize());
        for(Category c:list){
            c.getAttr().put("newsCount",getCategoryNewsCount(c.getId()));
        }
        page.setList(list);
        return page;
    }

    /*
    * 获取搜索浏览数据
    * */
    public Page getSearchCategory(int nowPageNum,String url,String type,String value){
        int count = getLikeCategoryCount(type,value);
        Page page = new Page(nowPageNum,count,url);
        List<Category> list = getLikeCategory(page.getStartIndex(),page.getPageSize(),type,value);
        for(Category c:list){
            c.getAttr().put("newsCount",getCategoryNewsCount(c.getId()));
        }
        page.setList(list);
        return page;
    }
}
