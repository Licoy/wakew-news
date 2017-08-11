package com.dao;

import com.beans.News;
import com.utils.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Created by Licoy on 2016/12/18 0018.
 */
public class NewsDao {
    /**
    * 查询所有的新闻，但不包括内容
    * */
    public List<News> selectAllNewsDisText(int begin,int end){
        List<News> list = new ArrayList<News>();
        try {
            String sql = "select id,title,author,impnews,slide,tag,category,created,updated,views,searchs,slideImg from news ORDER BY id DESC LIMIT ?,?";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,begin);
            st.setInt(2,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                News news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setImpnews(re.getInt(4));
                news.setSlide(re.getInt(5));
                news.setTag(re.getString(6));
                news.setCategory(re.getInt(7));
                news.setCreated(re.getLong(8));
                news.setUpdated(re.getLong(9));
                news.setViews(re.getInt(10));
                news.setSearchs(re.getInt(11));
                news.setSlideImg(re.getString(12));
                list.add(news);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 分页（含模糊）查询所有的新闻，但不包括内容
     * */
    public List<News> selectLikeAllNewsDisText(int begin, int end, String type, String value){
        List<News> list = new ArrayList<News>();
        try {
            String sql = "SELECT id,title,author,impnews,slide,tag,category,created,updated,views,searchs,slideImg FROM news WHERE `"+type+"` LIKE ? ORDER BY id DESC LIMIT ?,?";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,"%"+value+"%");
            st.setInt(2,begin);
            st.setInt(3,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                News news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setImpnews(re.getInt(4));
                news.setSlide(re.getInt(5));
                news.setTag(re.getString(6));
                news.setCategory(re.getInt(7));
                news.setCreated(re.getLong(8));
                news.setUpdated(re.getLong(9));
                news.setViews(re.getInt(10));
                news.setSearchs(re.getInt(11));
                news.setSlideImg(re.getString(12));
                list.add(news);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
    * 查询所有的新闻包括内容
    * */
    public List<News> selectAllNews(int begin,int end){
        List<News> list = new ArrayList<News>();
        try {
            String sql = "select id,title,author,impnews,slide,tag,category,created,updated,text,views,searchs,slideImg from news ORDER BY id DESC LIMIT ?,?";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,begin);
            st.setInt(2,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                News news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setImpnews(re.getInt(4));
                news.setSlide(re.getInt(5));
                news.setTag(re.getString(6));
                news.setCategory(re.getInt(7));
                news.setCreated(re.getLong(8));
                news.setUpdated(re.getLong(9));
                news.setText(re.getString(10));
                news.setViews(re.getInt(11));
                news.setSearchs(re.getInt(12));
                news.setSlideImg(re.getString(13));
                list.add(news);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询所有的新闻ID
     * */
    public List<Integer> getAllNewsId(){
        List<Integer> list = new ArrayList<>();
        try {
            String sql = "select `id` from `news` ORDER BY id DESC";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet re = st.executeQuery();
            while (re.next()){
                list.add(re.getInt(1));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询指定数量最新的新闻ID
     * */
    public List<Integer> getNewestNewsId(int category,int number){
        List<Integer> list = new ArrayList<>();
        try {
            String sql = "select `id` from `news` WHERE `category`=? ORDER BY `id` AND `created` DESC LIMIT ?,?";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,category);
            st.setInt(2,0);
            st.setInt(3,number);
            ResultSet re = st.executeQuery();
            while (re.next()){
                list.add(re.getInt(1));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
    * 查询指定分类目录下所有新闻，但不包括内容
    * */
    public List<News> selectNewsByCategoryDisText(int categoryId){
        List<News> list = new ArrayList<News>();
        try {
            String sql = "select id,title,author,impnews,slide,tag,category,created,updated,views,searchs,slideImg from news WHERE category=? ORDER BY id DESC ";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,categoryId);
            ResultSet re = st.executeQuery();
            while (re.next()){
                News news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setImpnews(re.getInt(4));
                news.setSlide(re.getInt(5));
                news.setTag(re.getString(6));
                news.setCategory(re.getInt(7));
                news.setCreated(re.getLong(8));
                news.setUpdated(re.getLong(9));
                news.setViews(re.getInt(10));
                news.setSearchs(re.getInt(11));
                news.setSlideImg(re.getString(12));
                list.add(news);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 分页（含模糊）查询指定分类目录下所有新闻，但不包括内容
     * */
    public List<News> selectLikeNewsByCategoryDisText(int categoryId, int begin, int end, boolean like, String type, String value){
        List<News> list = new ArrayList<News>();
        try {
            String sql = "select id,title,author,impnews,slide,tag,category,created,updated,views,searchs,slideImg from news WHERE category=? ORDER BY id DESC LIMIT ?,?";
            if(like){
                sql = "select id,title,author,impnews,slide,tag,category,created,updated,views,searchs,slideImg from news WHERE category=? AND "+type+" LIKE '%"+value+"%' ORDER BY id DESC LIMIT ?,?";
            }
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,categoryId);
            st.setInt(2,begin);
            st.setInt(3,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                News news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setImpnews(re.getInt(4));
                news.setSlide(re.getInt(5));
                news.setTag(re.getString(6));
                news.setCategory(re.getInt(7));
                news.setCreated(re.getLong(8));
                news.setUpdated(re.getLong(9));
                news.setViews(re.getInt(10));
                news.setSearchs(re.getInt(11));
                news.setSlideImg(re.getString(12));
                list.add(news);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 分页查询指定分类目录下所有新闻包括内容
     * */
    public List<News> selectNewsByCategory(int categoryId, int begin, int end){
        List<News> list = new ArrayList<News>();
        try {
            String sql = "select id,title,author,impnews,slide,tag,category,created,updated,views,searchs,slideImg,text from news WHERE category=? ORDER BY id DESC LIMIT ?,?";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,categoryId);
            st.setInt(2,begin);
            st.setInt(3,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                News news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setImpnews(re.getInt(4));
                news.setSlide(re.getInt(5));
                news.setTag(re.getString(6));
                news.setCategory(re.getInt(7));
                news.setCreated(re.getLong(8));
                news.setUpdated(re.getLong(9));
                news.setViews(re.getInt(10));
                news.setSearchs(re.getInt(11));
                news.setSlideImg(re.getString(12));
                news.setText(re.getString(13));
                list.add(news);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询最新推送到幻灯的新闻，但不包括内容
     * */
    public List<News> selectNewsBySlideDisText(int num){
        List<News> list = new ArrayList<News>();
        try {
            String sql = "select id,title,author,impnews,slide,tag,category,created,updated,views,searchs,slideImg from news WHERE slide=? ORDER BY id DESC LIMIT ?,?";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,1);
            st.setInt(2,0);
            st.setInt(3,num);
            ResultSet re = st.executeQuery();
            while (re.next()){
                News news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setImpnews(re.getInt(4));
                news.setSlide(re.getInt(5));
                news.setTag(re.getString(6));
                news.setCategory(re.getInt(7));
                news.setCreated(re.getLong(8));
                news.setUpdated(re.getLong(9));
                news.setViews(re.getInt(10));
                news.setSearchs(re.getInt(11));
                news.setSlideImg(re.getString(12));
                list.add(news);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询最新推送到今日要闻的新闻，但不包括内容
     * */
    public List<News> selectNewsByImpnews(int num){
        List<News> list = new ArrayList<News>();
        try {
            String sql = "select id,title,author,impnews,slide,tag,category,created,updated,views,searchs,slideImg,text from news WHERE impnews=? ORDER BY id DESC LIMIT ?,?";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,1);
            st.setInt(2,0);
            st.setInt(3,num);
            ResultSet re = st.executeQuery();
            while (re.next()){
                News news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setImpnews(re.getInt(4));
                news.setSlide(re.getInt(5));
                news.setTag(re.getString(6));
                news.setCategory(re.getInt(7));
                news.setCreated(re.getLong(8));
                news.setUpdated(re.getLong(9));
                news.setViews(re.getInt(10));
                news.setSearchs(re.getInt(11));
                news.setSlideImg(re.getString(12));
                news.setText(re.getString(13));
                list.add(news);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询指定作者发表的新闻，但不包括内容
     * */
    public List<News> selectNewsByAuthorDisText(int id,int begin,int end){
        List<News> list = new ArrayList<News>();
        try {
            String sql = "select id,title,author,impnews,slide,tag,category,created,updated,views,searchs,slideImg from news WHERE author=? ORDER BY id DESC LIMIT ?,?";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            st.setInt(2,begin);
            st.setInt(3,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                News news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setImpnews(re.getInt(4));
                news.setSlide(re.getInt(5));
                news.setTag(re.getString(6));
                news.setCategory(re.getInt(7));
                news.setCreated(re.getLong(8));
                news.setUpdated(re.getLong(9));
                news.setViews(re.getInt(10));
                news.setSearchs(re.getInt(11));
                news.setSlideImg(re.getString(12));
                list.add(news);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据ID查找新闻，包括内容
     * */
    public News selectNewsById(int id){
        News news = null;
        try {
            String sql = "select id,title,author,impnews,slide,tag,category,created,updated,text,views,searchs,slideImg from news WHERE id=?";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet re = st.executeQuery();
            while (re.next()){
                news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setImpnews(re.getInt(4));
                news.setSlide(re.getInt(5));
                news.setTag(re.getString(6));
                news.setCategory(re.getInt(7));
                news.setCreated(re.getLong(8));
                news.setUpdated(re.getLong(9));
                news.setText(re.getString(10));
                news.setViews(re.getInt(11));
                news.setSearchs(re.getInt(12));
                news.setSlideImg(re.getString(13));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    /**
     * 根据ID查找新闻必要因素，但不包括内容
     * */
    public News selectNewsByIdDisText(int id){
        News news = null;
        try {
            String sql = "select id,title,author,category from news WHERE id=?";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet re = st.executeQuery();
            while (re.next()){
                news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setCategory(re.getInt(4));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    /**
    * 增加文章
    * */
    public int insertNewsByObject(News news){
        int count = 0;
        String sql = "INSERT INTO `news`(`title`,`text`,`author`,`impnews`,`slide`,`tag`,`category`,`views`,`searchs`,`created`,`updated`,`slideImg`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,news.getTitle());
            st.setString(2,news.getText());
            st.setInt(3,news.getAuthor());
            st.setInt(4,news.getImpnews());
            st.setInt(5,news.getSlide());
            st.setString(6,news.getTag());
            st.setInt(7,news.getCategory());
            st.setInt(8,0);
            st.setInt(9,0);
            st.setLong(10,System.currentTimeMillis());
            st.setLong(11,System.currentTimeMillis());
            st.setString(12,news.getSlideImg());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
    * 修改文章
    * */
    public int updateNewsByObject(News news){
        int count = 0;
        String sql = "UPDATE news SET title=?,text=?,impnews=?,slide=?,tag=?,category=?,updated=?,views=?,searchs=?,slideImg=? WHERE id=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,news.getTitle());
            st.setString(2,news.getText());
            st.setInt(3,news.getImpnews());
            st.setInt(4,news.getSlide());
            st.setString(5,news.getTag());
            st.setInt(6,news.getCategory());
            st.setLong(7,System.currentTimeMillis());
            st.setInt(8,news.getViews());
            st.setInt(9,news.getSearchs());
            st.setString(10,news.getSlideImg());
            st.setInt(11,news.getId());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
    * 对浏览量自增加1
    * */
    public int updateViewsIncrement(int id){
        int count = 0;
        String sql = "UPDATE news SET views=views+1 WHERE id=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
    * 对搜索量自增加1
    * */
    public int updateSearchsIncrement(int id){
        int count = 0;
        String sql = "UPDATE news SET searchs=searchs+1 WHERE id=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 分页查询指定目录下的搜索量高的新闻，但不包括内容
     * */
    public List<News> selectLikeSearchsHeightNewsDisText(int categoryId, int begin, int end){
        List<News> list = new ArrayList<News>();
        try {
            String sql = "select id,title,author,impnews,slide,tag,category,created,updated,views,searchs,slideImg from news WHERE category=? ORDER BY `searchs` and `created` DESC LIMIT ?,?";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,categoryId);
            st.setInt(2,begin);
            st.setInt(3,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                News news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setImpnews(re.getInt(4));
                news.setSlide(re.getInt(5));
                news.setTag(re.getString(6));
                news.setCategory(re.getInt(7));
                news.setCreated(re.getLong(8));
                news.setUpdated(re.getLong(9));
                news.setViews(re.getInt(10));
                news.setSearchs(re.getInt(11));
                news.setSlideImg(re.getString(12));
                list.add(news);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 分页查询指定目录下的浏览量最高的新闻，但不包括内容
     * */
    public List<News> selectLikeViewsHeightNewsDisText(int categoryId, int begin, int end){
        List<News> list = new ArrayList<News>();
        try {
            String sql = "select id,title,author,impnews,slide,tag,category,created,updated,views,searchs,slideImg from news WHERE category=? ORDER BY `views` DESC LIMIT ?,?";
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,categoryId);
            st.setInt(2,begin);
            st.setInt(3,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                News news = new News();
                news.setId(re.getInt(1));
                news.setTitle(re.getString(2));
                news.setAuthor(re.getInt(3));
                news.setImpnews(re.getInt(4));
                news.setSlide(re.getInt(5));
                news.setTag(re.getString(6));
                news.setCategory(re.getInt(7));
                news.setCreated(re.getLong(8));
                news.setUpdated(re.getLong(9));
                news.setViews(re.getInt(10));
                news.setSearchs(re.getInt(11));
                news.setSlideImg(re.getString(12));
                list.add(news);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    /**
    * 根据ID删除指定文章
    * */
    public int deleteNewsById(int id){
        int count = 0;
        String sql = "DELETE FROM `news` WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    * 统计新闻总数
    * */
    public int GetNewsCount(){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `news`";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet re = st.executeQuery();
            while(re.next()){
                count = re.getInt(1);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    * 统计模糊新闻总数
    * */
    public int GetLikeNewsCount(String type,String value){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `news` WHERE `"+type+"` LIKE ?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,"%"+value+"%");
            ResultSet re = st.executeQuery();
            while(re.next()){
                count = re.getInt(1);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    * 统计指定分类目录下的新闻总数
    * */
    public int GetCategoryNewsCount(int id){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `news` WHERE `category`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet re = st.executeQuery();
            while(re.next()){
                count = re.getInt(1);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    * 查找在指定时间内是否存在相同文章
    * */
    public int FindNewsInTimeRepeat(int day,String title){
        long time = day*86400*1000;
        int count = 0;
        String sql = "SELECT count(`id`) FROM `news` WHERE `created`>? AND `title`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setLong(1,time);
            st.setString(2,title);
            ResultSet re = st.executeQuery();
            while(re.next()){
                count = re.getInt(1);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    * 查找在指定时间内是否存在相同文章
    * */
    public int FindNewsInOtherTimeRepeat(int day,String title,int id){
        long time = day*86400*1000;
        int count = 0;
        String sql = "SELECT count(`id`) FROM `news` WHERE `created`>? AND `title`=? AND `id`!=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setLong(1,time);
            st.setString(2,title);
            st.setInt(3,id);
            ResultSet re = st.executeQuery();
            while(re.next()){
                count = re.getInt(1);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


}
