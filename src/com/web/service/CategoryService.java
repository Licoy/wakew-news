package com.web.service;

import com.beans.Category;
import com.beans.News;
import com.dao.CategoryDao;
import com.dao.CommentsDao;
import com.dao.NewsDao;
import com.utils.ComparatorArray;

import java.util.*;

/*
 * Created by Licoy on 2016/12/29 0029.
 */
public class CategoryService {
    private NewsDao newsDao = new NewsDao();

    /*
    * 获取对应分类目录的最新新闻集合
    * */
    private List<News> getNewestNewsList(int categoryId,int number){
        return newsDao.selectNewsByCategory(categoryId,0,number);
    }

    /*
    * 获取对应分类目录的搜索量高的新闻集合
    * */
    private List<News> getSearchHeightNewsList(int categoryId,int number){
        return newsDao.selectLikeSearchsHeightNewsDisText(categoryId,0,number);
    }

    /*
    * 获取指定新闻的评论数量
    * */
    private int getNewsCommentsCountByNewsId(int id){
        return new CommentsDao().GetCommentsCountByNewsId(id);
    }

    /*
    * 获取对应分类目录的评论量高的新闻集合
    * */
    private List<News> getCommentsHeightNewsList(int categoryId,int number){
        /*获取所有新闻的ID集合*/
        List<Integer> newses= newsDao.getNewestNewsId(categoryId,number);
        List<Map> list = new ArrayList<>();
        for (int i=0;i<newses.size();i++){
            Map<String,Integer> map = new HashMap<>();
            map.put("id",newses.get(i));
            map.put("count",getNewsCommentsCountByNewsId(newses.get(i)));
            list.add(map);
        }
        Collections.sort(list,new ComparatorArray());
        /*再获取所有的新闻对应的评论数量集合*/
        List<News> newsList = new ArrayList<>();
        for(Map m:list){
            News news = newsDao.selectNewsByIdDisText(Integer.parseInt(m.get("id")+""));
            newsList.add(news);
        }
        return newsList;
    }

    /*
    * 获取对应分类目录的查看量高的新闻集合
    * */
    private List<News> getViewsHeightNewsList(int categoryId,int number){
        return newsDao.selectLikeViewsHeightNewsDisText(categoryId,0,number);
    }


    public Map<String,Object> getData(String category,int number){
        Category category1 = new CategoryDao().selectCategoryByAlias(category);
        Map<String,Object> map = new HashMap<>();
        if(category1!=null){
            int catId = category1.getId();
            map.put("header",new HeaderService().getHeaderData());
            map.put("footer",new FooterService().getFooterData());
            map.put("views",getViewsHeightNewsList(catId,number));
            map.put("search",getSearchHeightNewsList(catId,number));
            map.put("comments",getCommentsHeightNewsList(catId,number));
            map.put("newest",getNewestNewsList(catId,number));
            map.put("catId",catId);
        }
        return map;
    }
}
