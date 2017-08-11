package com.dao;

import com.beans.User;
import com.utils.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Created by Licoy on 2016/12/18 0018.
 */
public class UserDao {

    /**
    * 查询所有用户
    * */
    public List<User> selectAllUser(int begin, int end){
        List<User> list = new ArrayList<User>();
        String sql = "SELECT id,username,usermail,password,usergroup,created,updated,lastlogin,grava,ip FROM user ORDER BY id DESC LIMIT ?,?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,begin);
            st.setInt(2,end);
            ResultSet re = st.executeQuery();
            while(re.next()){
                User user = new User();
                user.setId(re.getInt(1));
                user.setUsername(re.getString(2));
                user.setUsermail(re.getString(3));
                user.setPassword(re.getString(4));
                user.setUsergroup(re.getInt(5));
                user.setCreated(re.getLong(6));
                user.setUpdated(re.getLong(7));
                user.setLastlogin(re.getLong(8));
                user.setGrava(re.getString(9));
                user.setIp(re.getString(10));
                list.add(user);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
    * 根据用户名查找用户
    * */
    public User selectUserByUsername(String username){
        User user = null;
        String sql = "SELECT id,username,usermail,password,usergroup,created,updated,lastlogin,grava,ip FROM user WHERE username=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,username);
            ResultSet re = st.executeQuery();
            while(re.next()){
                user = new User();
                user.setId(re.getInt(1));
                user.setUsername(re.getString(2));
                user.setUsermail(re.getString(3));
                user.setPassword(re.getString(4));
                user.setUsergroup(re.getInt(5));
                user.setCreated(re.getLong(6));
                user.setUpdated(re.getLong(7));
                user.setLastlogin(re.getLong(8));
                user.setGrava(re.getString(9));
                user.setIp(re.getString(10));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
    * 根据邮箱查找用户
    * */
    public User selectUserByUsermail(String usermail){
        User user = null;
        String sql = "SELECT id,username,usermail,password,usergroup,created,updated,lastlogin,grava,ip FROM user WHERE usermail=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,usermail);
            ResultSet re = st.executeQuery();
            while(re.next()){
                user = new User();
                user.setId(re.getInt(1));
                user.setUsername(re.getString(2));
                user.setUsermail(re.getString(3));
                user.setPassword(re.getString(4));
                user.setUsergroup(re.getInt(5));
                user.setCreated(re.getLong(6));
                user.setUpdated(re.getLong(7));
                user.setLastlogin(re.getLong(8));
                user.setGrava(re.getString(9));
                user.setIp(re.getString(10));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 根据邮箱查找用户
     * */
    public User selectUserByUsermailDisSelf(String usermail,int id){
        User user = null;
        String sql = "SELECT id,username,usermail,password,usergroup,created,updated,lastlogin,grava,ip FROM user WHERE usermail=? AND `id`!=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,usermail);
            st.setInt(2,id);
            ResultSet re = st.executeQuery();
            while(re.next()){
                user = new User();
                user.setId(re.getInt(1));
                user.setUsername(re.getString(2));
                user.setUsermail(re.getString(3));
                user.setPassword(re.getString(4));
                user.setUsergroup(re.getInt(5));
                user.setCreated(re.getLong(6));
                user.setUpdated(re.getLong(7));
                user.setLastlogin(re.getLong(8));
                user.setGrava(re.getString(9));
                user.setIp(re.getString(10));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
    * 根据ID查找用户
    * */
    public User selectUserById(int id){
        User user = null;
        String sql = "SELECT id,username,usermail,password,usergroup,created,updated,lastlogin,grava,ip FROM user WHERE id=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet re = st.executeQuery();
            while(re.next()){
                user = new User();
                user.setId(re.getInt(1));
                user.setUsername(re.getString(2));
                user.setUsermail(re.getString(3));
                user.setPassword(re.getString(4));
                user.setUsergroup(re.getInt(5));
                user.setCreated(re.getLong(6));
                user.setUpdated(re.getLong(7));
                user.setLastlogin(re.getLong(8));
                user.setGrava(re.getString(9));
                user.setIp(re.getString(10));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
    * 模糊查询用户
    * */
    public List<User> selectLikeUser(int begin, int end, String type, String value){
        List<User> list = new ArrayList<User>();
        String sql = "SELECT id,username,usermail,password,usergroup,created,updated,lastlogin,grava,ip FROM user WHERE "+type+" LIKE ? ORDER BY id DESC LIMIT ?,?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,"%"+value+"%");
            st.setInt(2,begin);
            st.setInt(3,end);
            ResultSet re = st.executeQuery();
            while(re.next()){
                User user = new User();
                user.setId(re.getInt(1));
                user.setUsername(re.getString(2));
                user.setUsermail(re.getString(3));
                user.setPassword(re.getString(4));
                user.setUsergroup(re.getInt(5));
                user.setCreated(re.getLong(6));
                user.setUpdated(re.getLong(7));
                user.setLastlogin(re.getLong(8));
                user.setGrava(re.getString(9));
                user.setIp(re.getString(10));
                list.add(user);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
    * 修改用户
    * */
    public int updateUserByObject(User user){
        int count = 0;
        String sql = "UPDATE user SET usermail=?,password=?,usergroup=?,updated=?,lastlogin=?,grava=?,ip=? WHERE id=?";
        Connection conn = null;
        try {
            conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,user.getUsermail());
            st.setString(2,user.getPassword());
            st.setInt(3,user.getUsergroup());
            st.setLong(4,System.currentTimeMillis());
            st.setLong(5,user.getLastlogin());
            st.setString(6,user.getGrava());
            st.setString(7,user.getIp());
            st.setInt(8,user.getId());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
    * 增加用户
    * */
    public int insertUserByObject(User user){
        int count = 0;
        String sql = "INSERT INTO user(username, usermail, password, usergroup, created, updated, lastlogin, grava, ip) VALUES(?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        try {
            conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,user.getUsername());
            st.setString(2,user.getUsermail());
            st.setString(3,user.getPassword());
            st.setInt(4,1);
            st.setLong(5,System.currentTimeMillis());
            st.setLong(6,System.currentTimeMillis());
            st.setLong(7,System.currentTimeMillis());
            st.setString(8,"/app/img/default-grava.jpg");
            st.setString(9,user.getIp());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
    * 根据ID删除用户
    * */
    public int deleteUserById(int id){
        int count = 0;
        String sql = "DELETE FROM user WHERE id=?";
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
    * 根据用户名删除用户
    * */
    public int deleteUserByUsername(String username){
        int count = 0;
        String sql = "DELETE FROM user WHERE username=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,username);
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    * 获取指定用户的用户名
    * */
    public String getUsernameById(int id){
        String name = null;
        String sql = "SELECT `username` FROM `user` WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet re = st.executeQuery();
            while(re.next()){
                name = re.getString(1);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    /*
    * 获取是否存在除指定ID外的用户
    * */
    public boolean issetUserDisIdByUsername(String username,int id){
        boolean is = false;
        String sql = "SELECT `username` FROM `user` WHERE `username`=? AND `id`!=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,username);
            st.setInt(2,id);
            ResultSet re = st.executeQuery();
            while(re.next()){
                is = true;
                break;
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return is;
    }

    /*
    * 获取是否存在除指定ID外的用户
    * */
    public boolean issetUserDisIdByUsermail(String usermail,int id){
        boolean is = false;
        String sql = "SELECT `username` FROM `user` WHERE `usermail`=? AND `id`!=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,usermail);
            st.setInt(2,id);
            ResultSet re = st.executeQuery();
            while(re.next()){
                is = true;
                break;
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return is;
    }

    /*
    * 获取所有用户数量
    * */
    public int getUserCount(){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `user`";
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
    * 获取所有模糊搜索用户数量
    * */
    public int getLikeUserCount(String type,String value){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `user` WHERE `"+type+"` LIKE ?";
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
