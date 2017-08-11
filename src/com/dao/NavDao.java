package com.dao;

import com.beans.Nav;
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
public class NavDao {
    /**
    * 查询大栏导航设置信息
    * */
    public List<Nav> selectAllBignav(int begin,int end,boolean p){
        List<Nav> list = new ArrayList<>();
        String sql = "SELECT `id`,`name`,`priority`,`types`,`category`,`url` FROM `nav` WHERE `type`=1 LIMIT "+begin+","+end+"";
        if(p){
            sql = "SELECT `id`,`name`,`priority`,`types`,`category`,`url` FROM `nav` WHERE `type`=1 ORDER BY `priority` DESC LIMIT "+begin+","+end+"";
        }
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet re = st.executeQuery();
            while(re.next()){
                Nav nav = new Nav();
                nav.setId(re.getInt(1));
                nav.setName(re.getString(2));
                nav.setPriority(re.getInt(3));
                nav.setTypes(re.getInt(4));
                nav.setCategory(re.getInt(5));
                nav.setUrl(re.getString(6));
                list.add(nav);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
    * 查询小栏导航设置信息
    * */
    public List<Nav> selectAllSmallnav(int begin,int end,boolean p){
        List<Nav> list = new ArrayList<>();
        String sql = "SELECT `id`,`name`,`priority`,`types`,`category`,`url` FROM `nav` WHERE `type`=0 LIMIT "+begin+","+end+"";
        if(p){
            sql = "SELECT `id`,`name`,`priority`,`types`,`category`,`url` FROM `nav` WHERE `type`=0 ORDER BY `priority` DESC LIMIT "+begin+","+end+"";
        }
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet re = st.executeQuery();
            while(re.next()){
                Nav nav = new Nav();
                nav.setId(re.getInt(1));
                nav.setName(re.getString(2));
                nav.setPriority(re.getInt(3));
                nav.setTypes(re.getInt(4));
                nav.setCategory(re.getInt(5));
                nav.setUrl(re.getString(6));
                list.add(nav);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
    * 根据ID查询导航信息
    * */
    public Nav selectNavById(int id){
        Nav nav = null;
        String sql = "SELECT `id`,`name`,`priority`,`types`,`category`,`url`,`type` FROM `nav` WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet re = st.executeQuery();
            while(re.next()){
                nav = new Nav();
                nav.setId(re.getInt(1));
                nav.setName(re.getString(2));
                nav.setPriority(re.getInt(3));
                nav.setTypes(re.getInt(4));
                nav.setCategory(re.getInt(5));
                nav.setUrl(re.getString(6));
                nav.setType(re.getInt(7));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nav;
    }

    /**
    * 修改导航信息
    * */
    public int updateNavInfo(int type,Nav nav){
        int count = 0;
        String sql = "UPDATE `nav` SET `name`=?,`priority`=?,`types`=?,`category`=?,`url`=? WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,nav.getName());
            st.setInt(2,nav.getPriority());
            st.setInt(3,nav.getTypes());
            st.setInt(4,nav.getCategory());
            st.setString(5,nav.getUrl());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
    * 增加导航条
    * */
    public int insertNavByObject(Nav nav){
        int count = 0;
        String sql = "INSERT INTO `nav`(`type`,`name`,`priority`,`types`,`category`,`url`) VALUES(?,?,?,?,?,?)";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,nav.getType());
            st.setString(2,nav.getName());
            st.setInt(3,nav.getPriority());
            st.setInt(4,nav.getTypes());
            st.setInt(5,nav.getCategory());
            st.setString(6,nav.getUrl());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
    * 根据ID删除导航条
    * */
    public int deleteNavById(int id){
        int count = 0;
        String sql = "DELETE FROM `nav` WHERE `id`=?";
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
}
