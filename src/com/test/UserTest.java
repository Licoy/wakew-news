package com.test;

import com.beans.News;
import com.dao.NewsDao;

import java.util.List;

/*
 * Created by Licoy on 2016/12/18 0018.
 */
public class UserTest {
    public static void main(String[] args) {
       /* UserDao userDao = new UserDao();
        List<UserBeans> list = userDao.selectLikeUser(0,99,"id","2");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getUsername());
        }*/

        NewsDao newsDao = new NewsDao();
        List<News> list = newsDao.selectLikeSearchsHeightNewsDisText(1,0,99);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTitle()+":"+list.get(i).getSearchs());
        }
    }
}
