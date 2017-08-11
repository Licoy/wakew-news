package com.web.service;

import com.beans.Category;
import com.beans.News;
import com.dao.CategoryDao;
import com.dao.NewsDao;

import java.util.List;
import java.util.Random;

/*
 * Created by Licoy on 2016/12/29 0029.
 */
public class LuckService {
    /*
    * 查询出所有的新闻ID集合
    * */
    private List<Integer> getAllNewsId(){
        return new NewsDao().getAllNewsId();
    }

    /*
    *随机返回一个新闻ID
    * */
    private int randomNewsId(int length){
        Random random = new Random();
        return  random.nextInt(length);
    }

    /*
    * 查询出指定新闻的分类信息
    * */
    private Category getCategoryById(int id){
        return new CategoryDao().selectCategoryById(id);
    }

    /*
    * 获取随机新闻
    * */
    public String getRandomNews(){
        List<Integer> list = getAllNewsId();
        int id = randomNewsId(list.size());
        News news = new NewsDao().selectNewsByIdDisText(list.get(id));
        Category category = getCategoryById(news.getCategory());
        return "/category/"+category.getAlias()+"/"+news.getId()+".html";
    }
}
