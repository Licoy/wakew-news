package com.dao;

import com.beans.Category;
import com.utils.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/19 0019.
 */
public class CategoryDao {
    /*
    * 查询所有的分类
    * */
    public List<Category> selectAllCategory(int begin,int end){
        List<Category> list = new ArrayList<>();
        String sql = "SELECT `id`,`name`,`alias`,`describe` FROM `category` LIMIT ?,?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,begin);
            st.setInt(2,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                Category category = new Category();
                category.setId(re.getInt(1));
                category.setName(re.getString(2));
                category.setAlias(re.getString(3));
                category.setDescribe(re.getString(4));
                list.add(category);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
    * 查询所有的分类
    * */
    public List<Category> selectAllCategoryDisDefault(){
        List<Category> list = new ArrayList<>();
        String sql = "SELECT `id`,`name`,`alias`,`describe` FROM `category` WHERE `id`!=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,1);
            ResultSet re = st.executeQuery();
            while (re.next()){
                Category category = new Category();
                category.setId(re.getInt(1));
                category.setName(re.getString(2));
                category.setAlias(re.getString(3));
                category.setDescribe(re.getString(4));
                list.add(category);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
    * 模糊查询分类
    * */
    public List<Category> selectLikeCategory(int begin,int end,String type,String value){
        List<Category> list = new ArrayList<>();
        String sql = "SELECT `id`,`name`,`alias`,`describe` FROM `category` WHERE `"+type+"` LIKE ? LIMIT ?,?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,"%"+value+"%");
            st.setInt(2,begin);
            st.setInt(3,end);
            ResultSet re = st.executeQuery();
            while (re.next()){
                Category category = new Category();
                category.setId(re.getInt(1));
                category.setName(re.getString(2));
                category.setAlias(re.getString(3));
                category.setDescribe(re.getString(4));
                list.add(category);
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
    * 根据分类名查找分类目录
    * */
    public Category selectCategoryByName(String name){
        Category category = null;
        String sql = "SELECT `id`,`name`,`alias`,`describe` FROM `category` WHERE `name`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,name);
            ResultSet re = st.executeQuery();
            while (re.next()){
                category = new Category();
                category.setId(re.getInt(1));
                category.setName(re.getString(2));
                category.setAlias(re.getString(3));
                category.setDescribe(re.getString(4));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    /*
    * 根据分类别名查找分类目录
    * */
    public Category selectCategoryByAlias(String name){
        Category category = null;
        String sql = "SELECT `id`,`name`,`alias`,`describe` FROM `category` WHERE `alias`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,name);
            ResultSet re = st.executeQuery();
            while (re.next()){
                category = new Category();
                category.setId(re.getInt(1));
                category.setName(re.getString(2));
                category.setAlias(re.getString(3));
                category.setDescribe(re.getString(4));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    /*
    * 根据id查找分类目录
    * */
    public Category selectCategoryById(int id){
        Category category = null;
        String sql = "SELECT `id`,`name`,`alias`,`describe` FROM `category` WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet re = st.executeQuery();
            while (re.next()){
                category = new Category();
                category.setId(re.getInt(1));
                category.setName(re.getString(2));
                category.setAlias(re.getString(3));
                category.setDescribe(re.getString(4));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    /*
    * 增加分类目录
    * */
    public int insertCategoryByObject(Category category){
        int count = 0;
        String sql = "INSERT INTO `category`(`name`,`alias`,`describe`) VALUES(?,?,?)";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,category.getName());
            st.setString(2,category.getAlias());
            st.setString(3,category.getDescribe());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    * 修改分类目录
    * */
    public int updateCategoryByObject(Category category){
        int count = 0;
        String sql = "UPDATE `category` SET `name`=?,`alias`=?,`describe`=? WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,category.getName());
            st.setString(2,category.getAlias());
            st.setString(3,category.getDescribe());
            st.setInt(4,category.getId());
            count = st.executeUpdate();
            DataBase.close(conn,st,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /*
    * 删除分类目录
    * */
    public int deleteCategoryById(int id){
        int count = 0;
        String sql = "DELETE FROM `category` WHERE `id`=?";
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
    * 统计分类目录总数
    * */
    public int GetCategoryCount(){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `category`";
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
    * 统计模糊查询分类目录总数
    * */
    public int GetLikeCategoryCount(String type,String value){
        int count = 0;
        String sql = "SELECT count(`id`) FROM `category` WHERE `"+type+"` LIKE ?";
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
    * 根据分类目录ID获取分类目录别名
    * */
    public Map<String,String> getNameAndAliasById(int id){
        Map<String,String> map = new HashMap<>();
        String sql = "SELECT `alias`,`name` FROM `category` WHERE `id`=?";
        try {
            Connection conn = DataBase.getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet re = st.executeQuery();
            while(re.next()){
                map.put("alias",re.getString(1));
                map.put("name",re.getString(2));
            }
            DataBase.close(conn,st,re);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
