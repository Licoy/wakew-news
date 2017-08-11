package com.web.service;

import com.beans.*;
import com.dao.CommentsDao;
import com.dao.NewsDao;
import com.dao.SetDao;
import com.dao.UserDao;
import com.utils.Tools;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/26 0026.
 */
public class PageService {
    private CommentsDao commentsDao =  new CommentsDao();
    private int containNumber = 1;

    /*
    * 统计指定文章的评论数量
    * */
    private int getNewsCommentsCount(int id){
        return commentsDao.GetCommentsCountByNewsId(id);
    }

    /*
    * 获取指定文章的评论
    * */
    private List<Comments> getNewsCommentsById(int id,int begin,int end){
        return commentsDao.selectNewsCommentsByNewsId(id,begin,end);
    }

    /*
    * 查询指定的用户的信息
    * */
    private User getUserById(int id){
        return new UserDao().selectUserById(id);
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
            map.put("imgSrc", Tools.matchFirstImage(n.getText()));
            mapList.add(map);
        }
        return  mapList;
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
    /*
    * 获取当前的文章数据
    * */
    private News getNewsById(int id){
        NewsDao newsDao = new NewsDao();
        newsDao.updateViewsIncrement(id);
        return newsDao.selectNewsById(id);
    }

    /*
    * 获取指定评论数据
    * */
    private Comments getCommentsById(int id){
        return commentsDao.selectCommentsById(id);
    }

    /*
    * 查询指定评论的嵌套评论
    * */
    private List<Map> getContainComments(int CommentsId){
        List<Map> commentsList = new ArrayList<>();
        List<Comments> comments =  commentsDao.selectContainComments(CommentsId);
        if(comments.size()==0){
            return null;
        }
        for (Comments comment : comments) {
            Map<String, Object> commentsMap = new HashMap<>();
            commentsMap.put("comments", comment);
            commentsMap.put("user", getUserById(comment.getUser()));
            commentsMap.put("num", containNumber++);
            commentsMap.put("contain",getContainComments(comment.getId()));
            commentsList.add(commentsMap);
        }
        return commentsList;
    }


    /*
    * 获取评论数据
    * */
    private List<Map> getComments(int newsId,int begin,int end){
        List<Map> commentsList = new ArrayList<>();
        List<Comments> comments = getNewsCommentsById(newsId,begin,end);
        for (Comments comment : comments) {
            Map<String, Object> commentsMap = new HashMap<>();
            commentsMap.put("comments", comment);
            commentsMap.put("user", getUserById(comment.getUser()));
            commentsMap.put("num", containNumber++);
            commentsMap.put("contain",getContainComments(comment.getId()));
            commentsList.add(commentsMap);
        }
        return commentsList;
    }

    public Map getPageData(int id,int nowPageNum){
        int count = commentsDao.GetCommentsCountByNewsIdDisContain(id);
        Page page = new Page(nowPageNum,count,id+".html?");
        Map<String,Object> map = new HashMap<>();
        News news = getNewsById(id);
        if(news==null){
            return null;
        }
        /*查询出侧边栏模块数据*/
        Set columPageSlidebar = new SetDao().selectSetByKey("column-page-slidebar");
        /*获取指定的评论的用户信息*/
        map.put("news",news);
        map.put("commentsNumber",getNewsCommentsCount(id));
        map.put("Cpsn",getColumnNews(columPageSlidebar));
        page.getAttr().put("comments",getComments(id,page.getStartIndex(),page.getPageSize()));
        map.put("header",new HeaderService().getHeaderData());
        map.put("footer",new FooterService().getFooterData());
        map.put("page",page);
        return map;
    }
}
