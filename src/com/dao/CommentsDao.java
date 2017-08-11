package com.dao;

import com.beans.Comments;
import com.utils.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Created by Licoy on 2016/12/19 0019.
 */
public class CommentsDao {
    /**
    * 查询所有的评论
    * */
    public List<Comments> selectAllComments(int begin,int end){
        List<Comments> list = new ArrayList<>();
        String sql = "SELECT `id`,`user`,`text`,`issuedate`,`news`,`support`,`contain` FROM `comments` ORDER BY `id` DESC LIMIT ?,?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,begin);
            st.setInt(2,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                Comments comments = new Comments();
                comments.setId(re.getInt(1));
                comments.setUser(re.getInt(2));
                comments.setText(re.getString(3));
                comments.setIssuedate(re.getLong(4));
                comments.setNews(re.getInt(5));
                comments.setSupport(re.getInt(6));
                comments.setContain(re.getInt(7));
                list.add(comments);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询指定评论的嵌套评论
     * */
    public List<Comments> selectContainComments(int id){
        List<Comments> list = new ArrayList<>();
        String sql = "SELECT `id`,`user`,`text`,`issuedate`,`news`,`support`,`contain` FROM `comments` WHERE `contain`=? ORDER BY `id` DESC";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet re = st.executeQuery();
            while (re.next()){
                Comments comments = new Comments();
                comments.setId(re.getInt(1));
                comments.setUser(re.getInt(2));
                comments.setText(re.getString(3));
                comments.setIssuedate(re.getLong(4));
                comments.setNews(re.getInt(5));
                comments.setSupport(re.getInt(6));
                comments.setContain(re.getInt(7));
                list.add(comments);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
    * 模糊查询评论
    * */
    public List<Comments> selectLikeComments(int begin,int end,String type,String value){
        List<Comments> list = new ArrayList<>();
        String sql = "SELECT `id`,`user`,`text`,`issuedate`,`news`,`support`,`contain` FROM `comments` WHERE `"+type+"` LIKE ? ORDER BY `id` DESC LIMIT ?,?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,"%"+value+"%");
            st.setInt(2,begin);
            st.setInt(3,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                Comments comments = new Comments();
                comments.setId(re.getInt(1));
                comments.setUser(re.getInt(2));
                comments.setText(re.getString(3));
                comments.setIssuedate(re.getLong(4));
                comments.setNews(re.getInt(5));
                comments.setSupport(re.getInt(6));
                comments.setContain(re.getInt(7));
                list.add(comments);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
    * 根据ID查询对应评论
    * */
    public Comments selectCommentsById(int id){
        Comments comments = null;
        String sql = "SELECT `id`,`user`,`text`,`issuedate`,`news`,`support`,`contain` FROM `comments` WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet re = st.executeQuery();
            while (re.next()){
                comments = new Comments();
                comments.setId(re.getInt(1));
                comments.setUser(re.getInt(2));
                comments.setText(re.getString(3));
                comments.setIssuedate(re.getLong(4));
                comments.setNews(re.getInt(5));
                comments.setSupport(re.getInt(6));
                comments.setContain(re.getInt(7));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    /*
    * 根据新闻ID查询指定新闻下的评论
    * */
    public List<Comments> selectNewsCommentsByNewsId(int newsId,int begin,int end){
        List<Comments> list = new ArrayList<>();
        String sql = "SELECT `id`,`user`,`text`,`issuedate`,`news`,`support`,`contain` FROM `comments` WHERE `news`=? AND `contain`=? ORDER BY `id` DESC LIMIT ?,?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,newsId);
            st.setInt(2,0);
            st.setInt(3,begin);
            st.setInt(4,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                Comments comments = new Comments();
                comments.setId(re.getInt(1));
                comments.setUser(re.getInt(2));
                comments.setText(re.getString(3));
                comments.setIssuedate(re.getLong(4));
                comments.setNews(re.getInt(5));
                comments.setSupport(re.getInt(6));
                comments.setContain(re.getInt(7));
                list.add(comments);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
    * 插入新的评论
    * */
    public int insertCommentsByObject(Comments comments){
        int count = 0;
        String sql = "INSERT INTO `comments`(`user`,`text`,`issuedate`,`news`,`support`,`contain`) VALUES(?,?,?,?,?,?)";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,comments.getUser());
            st.setString(2,comments.getText());
            st.setLong(3,System.currentTimeMillis());
            st.setInt(4,comments.getNews());
            st.setInt(5,comments.getSupport());
            st.setInt(6,comments.getContain());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    * 修改评论内容
    * */
    public int updateCommentsByObject(Comments comments){
        int count = 0;
        String sql = "UPDATE `comments` SET `text`=? WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,comments.getText());
            st.setInt(2,comments.getId());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    * 根据ID删除指定评论
    * */
    public int deleteCommentsById(int id){
        int count = 0;
        String sql = "DELETE FROM `comments` WHERE `id`=?";
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
    * 统计评论总数
    * */
    public int GetCommentsCount(){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `comments`";
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
    * 统计指定新闻的评论总数
    * */
    public int GetCommentsCountByNewsId(int id){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `comments` WHERE `news`=?";
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
    * 统计指定新闻的评论总数(排出包含评论)
    * */
    public int GetCommentsCountByNewsIdDisContain(int id){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `comments` WHERE `news`=? AND `contain`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            st.setInt(2,0);
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
   * 统计指定用户的评论总数
   * */
    public int GetCommentsCountByUserId(int id){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `comments` WHERE `user`=?";
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
    * 统计模糊新闻总数
    * */
    public int GetLikeCommentsCount(String type,String value){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `comments` WHERE `"+type+"` LIKE ?";
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

}
