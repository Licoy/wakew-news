package com.test;

import com.beans.Comments;
import com.beans.News;
import com.dao.CommentsDao;
import com.dao.NewsDao;

import java.util.List;

/*
 * Created by Licoy on 2016/12/18 0018.
 */
public class DB {
    public static void main(String[] args) {
        CommentsDao commentsDao = new CommentsDao();
//        List<Comments> list = commentsDao.selectLikeComments(0,2,"user","3");
        /*List<Comments> list = commentsDao.selectNewsCommentsByNewsId(2,0,2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("authorId:"+list.get(i).getUser()+";text:"+list.get(i).getText());
        }*/
        /*Comments comments = new Comments();
        comments.setUser(3);
        comments.setText("我是插入的内容222");
        comments.setNews(5);
        int num = commentsDao.insertCommentsByObject(comments);
        System.out.println(num);*/
        /*Comments comments = commentsDao.selectCommentsById(11);
        System.out.println("authorId:"+comments.getUser()+";text:"+comments.getText());
//        System.out.println(commentsDao.deleteCommentsById(comments.getId()));
        System.out.println(commentsDao.updateCommentsByObject(comments));
        Comments comments2 = commentsDao.selectCommentsById(11);
        System.out.println("authorId:"+comments2.getUser()+";text:"+comments2.getText());*/
        /*NewsDao newsDao = new NewsDao();
        List<News> list = newsDao.selectLikeNewsByCategoryDisText(2,0,3,true,"title","5");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("标题:"+list.get(i).getTitle()+";内容:"+list.get(i).getText());
        }*/
    }
}
