package com.dao;

import com.beans.Set;
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
public class SetDao {
    /**
    * 获取所有的设置
    * */
    public List<Set> selectAllSet(){
        List<Set> list = new ArrayList<>();
        String sql = "SELECT `id`,`key`,`value`,`type`,`value_big`,`created`,`updated` FROM `set`";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet re = st.executeQuery();
            while(re.next()){
                Set set = new Set();
                set.setId(re.getInt(1));
                set.setKey(re.getString(2));
                set.setType(re.getInt(4));
                if(set.getType()==0){
                    set.setValue(re.getString(3));
                }else{
                    set.setValue(re.getString(5));
                }
                set.setCreated(re.getLong(6));
                set.setUpdated(re.getLong(7));
                list.add(set);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
    * 获取单一设置
     * @param key
    * */
    public Set selectSetByKey(String key){
        Set set = null;
        String sql = "SELECT `id`,`key`,`value`,`type`,`value_big`,`created`,`updated` FROM `set` WHERE `key`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,key);
            ResultSet re = st.executeQuery();
            while(re.next()){
                set = new Set();
                set.setId(re.getInt(1));
                set.setKey(re.getString(2));
                set.setType(re.getInt(4));
                if(set.getType()==0){
                    set.setValue(re.getString(3));
                }else{
                    set.setValue(re.getString(5));
                }
                set.setCreated(re.getLong(6));
                set.setUpdated(re.getLong(7));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

    /**
    * 添加设置
     *@param set
    * */
    public int insertSetByObject(Set set){
        int count = 0;
        String type = null;
        if(set.getType()==0){
            type="value";
        }else{
            type="value_big";
        }
        String sql = "INSERT INTO `set`(`key`,`"+type+"`,`type`,`created`,`updated`) VALUES(?,?,?,?,?)";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,set.getKey());
            st.setString(2,set.getValue());
            st.setInt(3,set.getType());
            st.setLong(4,System.currentTimeMillis());
            st.setLong(5,System.currentTimeMillis());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
    * 根据ID修改单一设置
     * @param id
     * @param value
    * */
    public int updateSetById(int id,String value){
        int count = 0;
        String sql = "UPDATE `set` SET `value`=? WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,value);
            st.setInt(2,id);
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 根据KEY值修改单一设置
     * @param key
     * @param value
     * */
    public int updateSetByKey(String key,String value){
        int count = 0;
        String sql = "UPDATE `set` SET `value`=? WHERE `key`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,value);
            st.setString(2,key);
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 根据KEY值修改单一设置，储存BIG文本
     * @param key
     * @param value
     * */
    public int updateBigSetByKey(String key,String value){
        int count = 0;
        String sql = "UPDATE `set` SET `value_big`=? WHERE `key`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,value);
            st.setString(2,key);
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
    * 根据SET实例修改设置
     * @param set
    * */
    public int updateSetByObject(Set set){
        int count = 0;
        String sql = "UPDATE `set` SET `value`=? WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,set.getValue());
            st.setInt(2,set.getId());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
    * 根据ID删除设置
     * @param id
    * */
    public int deleteSetByid(int id){
        int count = 0;
        String sql = "DELETE FROM `set` WHERE `id`=?";
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
    * 根据KEY值删除设置
     * @param key
    * */
    public int deleteSetByKey(String key){
        int count = 0;
        String sql = "DELETE FROM `set` WHERE `key`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,key);
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
