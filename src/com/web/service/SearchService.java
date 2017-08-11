package com.web.service;

import com.beans.News;
import com.beans.Page;
import com.beans.SearchPage;
import com.dao.NewsDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/29 0029.
 */
public class SearchService {
    private NewsDao newsDao = new NewsDao();
    /*
    * 获取搜索数据总量
    * */
    private int getSearchCount(String s){
        return newsDao.GetLikeNewsCount("title",s);
    }
    /*
    * 获取搜索数据
    * */
    private List<News> getSearchNewsList(String s,int begin,int end){
        List<News> list =  newsDao.selectLikeAllNewsDisText(begin,end,"title",s);
        for (News aList : list) {
            newsDao.updateSearchsIncrement(aList.getId());
        }
        return list;
    }

    public Map<String,Object> getData(String s,int nowPageNum){
        Map<String,Object> map = new HashMap<>();
        int count = getSearchCount(s);
        SearchPage page = new SearchPage(nowPageNum,count,s+"?");
        List<News> list = getSearchNewsList(s,page.getStartIndex(),page.getPageSize());
        page.setList(list);
        map.put("header",new HeaderService().getHeaderData());
        map.put("footer",new FooterService().getFooterData());
        map.put("page",page);
        map.put("count",count);
        return map;
    }
}
