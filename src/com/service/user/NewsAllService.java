package com.service.user;

import com.beans.News;
import com.beans.Page;
import com.dao.CategoryDao;
import com.dao.CommentsDao;
import com.dao.NewsDao;
import com.dao.UserDao;

import java.util.List;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/21 0021.
 */
public class NewsAllService {
    /*
    * 获取当前页的新闻列表
    * */
    public List<News> getNowPageNewsLists(int begin,int end){
        NewsDao newsDao = new NewsDao();
        return newsDao.selectAllNewsDisText(begin,end);
    }

    /*
    * 获取模糊查询新闻列表
    * */
    public List<News> getLikeNowPageNewsLists(int begin,int end,String type,String value){
        NewsDao newsDao = new NewsDao();
        return newsDao.selectLikeAllNewsDisText(begin,end,type,value);
    }

    /*
    * 获取当前新闻总数量
    * */
    public int getNewsCount(){
        NewsDao newsDao = new NewsDao();
        return newsDao.GetNewsCount();
    }
    /*
    * 获取模糊搜索新闻总数量
    * */
    public int getLikeNewsCount(String type,String value){
        NewsDao newsDao = new NewsDao();
        return newsDao.GetLikeNewsCount(type,value);
    }

    /*
    * 对新闻列表的用户的用户名进行匹配
    * */
    public String getUsernameByNewsId(int id){
        UserDao userDao = new UserDao();
        return userDao.getUsernameById(id);
    }

    /*
    * 统计指定新闻的评论数量
    * */
    public int getCommentsCountByNewsId(int id){
        return new CommentsDao().GetCommentsCountByNewsId(id);
    }

    /*
    * 获取指定新闻的分类目录别名
    * */
    public Map<String, String> getCategoryAliasByNewsId(int id){
        return new CategoryDao().getNameAndAliasById(id);
    }

    /*
    * 默认新闻列表
    * */
    public Page getDefaultNewsList(int nowPageNum,String url){
        int newsCount = getNewsCount();
        Page page = new Page(nowPageNum,newsCount,url);
        List<News> list = getNowPageNewsLists(page.getStartIndex(),page.getPageSize());
        for (News aList : list) {
            aList.getAttr().put("author",getUsernameByNewsId(aList.getAuthor()));
            aList.getAttr().put("commentsCount",getCommentsCountByNewsId(aList.getId()));
            aList.getAttr().put("cat",getCategoryAliasByNewsId(aList.getCategory()));
        }
        page.setList(list);
        return page;
    }

    /*
    * 搜索新闻列表
    * */
    public Page getSearchNewsList(int nowPageNum,String url,String type,String value){
        int newsCount = getLikeNewsCount(type,value);
        Page page = new Page(nowPageNum,newsCount,url);
        List<News> list = getLikeNowPageNewsLists(page.getStartIndex(),page.getPageSize(),type,value);
        for (News aList : list) {
            aList.getAttr().put("author",getUsernameByNewsId(aList.getAuthor()));
            aList.getAttr().put("commentsCount",getCommentsCountByNewsId(aList.getId()));
            aList.getAttr().put("cat",getCategoryAliasByNewsId(aList.getCategory()));
        }
        page.setList(list);
        return page;
    }

}
