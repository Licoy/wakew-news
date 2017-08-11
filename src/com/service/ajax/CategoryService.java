package com.service.ajax;

import com.beans.Category;
import com.dao.CategoryDao;
import com.utils.Tools;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/22 0022.
 */
public class CategoryService {
     private CategoryDao categoryDao = new CategoryDao();
    /*
    * 查找是否存在同名分类目录
    * */
    public boolean issetNameEqual(String name,String alias){
        Category category = categoryDao.selectCategoryByName(name);
        if(category!=null){
            return true;
        }else{
            category = categoryDao.selectCategoryByAlias(alias);
            if(category!=null){
                return true;
            }
        }
        return false;
    }

    /*
    * 查找是否存在该分类目录
    * */
    public boolean issetCategory(int id){
        Category category = categoryDao.selectCategoryById(id);
        return category!=null;
    }

    /*
    * 获取指定的分类目录信息
    * */
    public Map<String,String> getCategoryById(int id){
        Map<String,String> tipsMap = new HashMap<>();
        Category category =  categoryDao.selectCategoryById(id);
        if(category!=null){
            tipsMap.put("code","200");
            tipsMap.put("msg","查询成功!");
            tipsMap.put("name",category.getName());
            tipsMap.put("alias",category.getAlias());
            tipsMap.put("desc",category.getDescribe());
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","查询失败!");
        }
        return tipsMap;
    }

    /*
    * 添加新的分类目录
    * */
    public Map<String,String> insertCategory(Category category){
        Map<String,String> tipsMap = new HashMap<>();
        if(!issetNameEqual(category.getName(),category.getAlias())){
            category.setDescribe(Tools.htmlEscape(category.getDescribe()));
            int num = categoryDao.insertCategoryByObject(category);
            if(num>0){
                tipsMap.put("code","200");
                tipsMap.put("msg","添加成功!");
            }else{
                tipsMap.put("code","403");
                tipsMap.put("msg","添加失败!");
            }
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","存在同名或同别名分类目录!");
        }
        return tipsMap;
    }

    /*
    *修改分类目录
    * */
    public Map<String,String> updateCategory(Category category){
        Map<String,String> tipsMap = new HashMap<>();
        if(issetCategory(category.getId())){
            category.setDescribe(Tools.htmlEscape(category.getDescribe()));
            int num = categoryDao.updateCategoryByObject(category);
            if(num>0){
                tipsMap.put("code","200");
                tipsMap.put("msg","修改成功!");
            }else{
                tipsMap.put("code","403");
                tipsMap.put("msg","修改失败!");
            }
        }else{
            tipsMap.put("code","403");
            tipsMap.put("msg","不存在目标分类目录!");
        }
        return tipsMap;
    }
}
