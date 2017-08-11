package com.service.user;

import com.beans.Comments;
import com.beans.News;
import com.beans.Page;
import com.dao.CommentsDao;
import com.dao.NewsDao;
import com.dao.UserDao;

import java.util.List;

/*
 * Created by Licoy on 2016/12/22 0022.
 */
public class CommentsService {
    private CommentsDao commentsDao = new CommentsDao();
    /*
    * 获取当前评论总数
    * */
    public int getCommentsCount(){
        return commentsDao.GetCommentsCount();
    }

    /*
    * 获取模糊搜索评论总数
    * */
    public int getLikeCommentsCount(String type,String value){
        return commentsDao.GetLikeCommentsCount(type,value);
    }

    /*
     * 获取当前页的评论列表
    **/
    public List<Comments> getCommentsList(int begin,int end){
        return commentsDao.selectAllComments(begin,end);
    }

    /*
    * 获取模糊搜索当前页的评论列表
    * */
    public List<Comments> getLikeCommentsList(int begin,int end,String type,String value){
        return commentsDao.selectLikeComments(begin,end,type,value);
    }

    /*
    * 对指定用户的用户名进行查询
    * */
    public String getUsernameByAuthorId(int id){
        UserDao userDao = new UserDao();
        return userDao.getUsernameById(id);
    }

    /*
    * 对指定新闻的必要元素进行查询
    * */
    public News getNewsByNewsId(int id){
        NewsDao newsDao = new NewsDao();
        return newsDao.selectNewsByIdDisText(id);
    }

    /*
    * 默认查询
    * */
    public Page getDefaultCommentsList(int nowPageNum,String url){
        int count = getCommentsCount();
        Page page = new Page(nowPageNum,count,url);
        List<Comments> list = getCommentsList(page.getStartIndex(),page.getPageSize());
        for(Comments c:list){
            if(c.getText().length()>25){
                c.setText(c.getText().substring(0,22)+"...");
            }
            c.getAttr().put("author",getUsernameByAuthorId(c.getUser()));
            News news = getNewsByNewsId(c.getNews());
            if(news.getTitle().length()>23){
                news.setTitle(news.getTitle().substring(0,20)+"...");
            }
            c.getAttr().put("news",news);
        }
        page.setList(list);
        return page;
    }

    /*
    * 搜索查询
    * */
    public Page getSearchCommentsList(int nowPageNum,String url,String type,String value) {
        int count = getLikeCommentsCount(type, value);
        Page page = new Page(nowPageNum, count, url);
        List<Comments> list = getLikeCommentsList(page.getStartIndex(), page.getPageSize(), type, value);
        for (Comments c : list) {
            c.getAttr().put("author", getUsernameByAuthorId(c.getUser()));
            News news = getNewsByNewsId(c.getNews());
            if(news.getTitle().length()>23){
                news.setTitle(news.getTitle().substring(0,20)+"...");
            }
            c.getAttr().put("news",news);
        }
        page.setList(list);
        return page;
    }


}