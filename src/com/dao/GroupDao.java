package com.dao;

import com.beans.Group;
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
public class GroupDao {
    /**
    * 查询所有的用户组
    * */
    public List<Group> selectAllGroup(int begin,int end){
        List<Group> list = new ArrayList<>();
        String sql = "SELECT `id`,`name`,`level` FROM `group` ORDER BY `id` DESC LIMIT ?,?  ";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,begin);
            st.setInt(2,end);
            ResultSet re = st.executeQuery();
            while(re.next()){
                Group group = new Group();
                group.setId(re.getInt(1));
                group.setName(re.getString(2));
                group.setLevel(re.getString(3));
                list.add(group);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 模糊查询所有的用户组
     * */
    public List<Group> selectLikeGroup(int begin,int end,String type,String value){
        List<Group> list = new ArrayList<>();
        String sql = "SELECT `id`,`name`,`level` FROM `group` WHERE `"+type+"` LIKE ? ORDER BY `id` DESC LIMIT ?,? ";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,"%"+value+"%");
            st.setInt(2,begin);
            st.setInt(3,end);
            ResultSet re = st.executeQuery();
            while(re.next()){
                Group group = new Group();
                group.setId(re.getInt(1));
                group.setName(re.getString(2));
                group.setLevel(re.getString(3));
                list.add(group);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
    * 根据ID查询用户组
    * */
    public Group selectGroupById(int id){
        Group group = null;
        String sql = "SELECT `id`,`name`,`level` FROM `group` WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet re = st.executeQuery();
            while(re.next()){
                group = new Group();
                group.setId(re.getInt(1));
                group.setName(re.getString(2));
                group.setLevel(re.getString(3));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    /**
    *根据用户组名称查找用户组
    * */
    public Group selectGroupByName(String name){
        Group group = null;
        String sql = "SELECT `id`,`name`,`level` FROM `group` WHERE `name`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,name);
            ResultSet re = st.executeQuery();
            while(re.next()){
                group = new Group();
                group.setId(re.getInt(1));
                group.setName(re.getString(2));
                group.setLevel(re.getString(3));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    /**
     *根据用户组名称查找用户组
     * */
    public Group selectGroupByNameDisId(String name,int id){
        Group group = null;
        String sql = "SELECT `id`,`name`,`level` FROM `group` WHERE `name`=? AND `id`!=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,name);
            st.setInt(2,id);
            ResultSet re = st.executeQuery();
            while(re.next()){
                group = new Group();
                group.setId(re.getInt(1));
                group.setName(re.getString(2));
                group.setLevel(re.getString(3));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    /**
    * 修改用户组
    * */
    public int updateGroupByObject(Group group){
        int count = 0;
        String sql = "UPDATE `group` SET `name`=?,`level`=? WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,group.getName());
            st.setString(2,group.getLevel());
            st.setInt(3,group.getId());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
    * 删除用户组
    * */
    public int deleteGroupByObject(int id){
        int count = 0;
        String sql = "DELETE FROM `group` WHERE `id`=?";
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
     * 添加用户组
     * */
    public int insertGroupByObject(Group group){
        int count = 0;
        String sql = "INSERT INTO `group`(`name`,`level`) VALUES(?,?)";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,group.getName());
            st.setString(2,group.getLevel());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    * 统计用户组总数
    * */
    public int getGorupCount(){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `group`";
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
    * 统计模糊用户组总数
    * */
    public int getGorupCount(String type,String value){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `group` WHERE `"+type+"` LIKE ?";
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
