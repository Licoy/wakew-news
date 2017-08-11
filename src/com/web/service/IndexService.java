package com.web.service;

import com.beans.Category;
import com.beans.News;
import com.beans.Set;
import com.dao.CategoryDao;
import com.dao.CommentsDao;
import com.dao.NewsDao;
import com.dao.SetDao;
import com.utils.Tools;
import org.junit.Test;

import java.util.*;

/*
 * Created by Licoy on 2016/12/26 0026.
 */
public class IndexService {
    /*
    * 查询设置
    * */
    private Set getSet(String key){
        return new SetDao().selectSetByKey(key);
    }



    /*
    * 获取首页幻灯所有新闻
    * */
    private List<News> getSlideNews(int num){
        NewsDao newsDao = new NewsDao();
        return newsDao.selectNewsBySlideDisText(num);
    }

    /*
    * 获取今日要闻推荐
    * */
    private List<Map> getFocusNews(int number){
        List<News> newses =   new NewsDao().selectNewsByImpnews(number);
        List<Map> mapList = new ArrayList<>();
        for(News n:newses){
            Map<String,Object> map = new HashMap<>();
            map.put("news",n);
            map.put("imgSrc",Tools.matchFirstImage(n.getText()));
            mapList.add(map);
        }
        return  mapList;
    }

    /*
    * 查询栏目对应的新闻
    * */
    private List<Map> getColumnNews(int id,int begin,int end){
        List<News> newses =   new NewsDao().selectNewsByCategory(id,begin,end);
        List<Map> mapList = new ArrayList<>();
        for(News n:newses){
            Map<String,Object> map = new HashMap<>();
            map.put("news",n);
            map.put("imgSrc",Tools.matchFirstImage(n.getText()));
            mapList.add(map);
        }
        return  mapList;
    }

    /*
    * 获取指定新闻的评论数量
    * */
    private int getCommentsCountByNewsId(int id){
        return new CommentsDao().GetCommentsCountByNewsId(id);
    }

    /*
    * 获取最新新闻
    * */
    private List<Map> getNewNews(int num){
        List<News> newses = new NewsDao().selectAllNews(0,num);
        List<Map> mapList = new ArrayList<>();
        for(News n:newses){
            Map<String,Object> map = new HashMap<>();
            map.put("news",n);
            map.put("imgSrc",Tools.matchFirstImage(n.getText()));
            map.put("count",getCommentsCountByNewsId(n.getId()));
            mapList.add(map);
        }
        return  mapList;
    }

    /*
    * 查询INDEX_DATA
    * */
    public Map<String,Object> getIndexData(){
        Map<String,Object> map = new HashMap<>();

        Set slideMaxNumber = getSet("slide-max-number");
        /*查询首页侧边栏所有的新闻获取集合*/
        Set columnIndexSlidebar = getSet("column-index-slidebar");
        /*查询首页底部所有的新闻获取集合*/
        Set columnIndexFooter = getSet("column-index-footer");


        map.put("header",new HeaderService().getHeaderData());
        map.put("footer",new FooterService().getFooterData());
        map.put("Cisn",getColumnNews(columnIndexSlidebar));
        map.put("Cifn",getColumnNews(columnIndexFooter));
        map.put("slideNews",getSlideNews(Integer.parseInt(slideMaxNumber.getValue())));
        map.put("focusNews",getFocusNews(7));
        map.put("newNews",getNewNews(7));
        return map;
    }

    /*
    * 获取栏目的所有新闻的集合
    * */
    private List getColumnNews(Set set){
        List list = new ArrayList();
        String[] ss  = set.getValue().split(",");

        for (String s:ss){
            int id = Integer.parseInt(s);
            Map<String,Object> map = new HashMap<>();
            map.put("catId",id);
            map.put("list",getColumnNews(id,0,6));
            list.add(map);
        }
        return list;
    }
}
