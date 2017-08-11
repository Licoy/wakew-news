package com.service.user;

import com.beans.Category;
import com.beans.News;
import com.dao.CategoryDao;
import com.dao.NewsDao;

import java.util.List;

/*
 * Created by Licoy on 2016/12/21 0021.
 */
public class EditorService {
    /*
    * 查询出所有的新闻分类
    * */
    public List<Category> selectAllCategory(){
        return new CategoryDao().selectAllCategory(0,1000);
    }

    /*
    * 查找指定ID的新闻内容
    * */
    public News selectNewsById(int id){
        return new NewsDao().selectNewsById(id);
    }


}
