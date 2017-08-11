package com.tag;

import com.beans.Category;
import com.utils.Tools;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
 * Created by Licoy on 2016/12/26 0026.
 */
public class Myfunction {
    /*
    * 判断权限是否含有指定值
    * */
    public static boolean issetContainValue(String str,String value,String delims){
        String[] s = str.split(delims);
        if(Arrays.asList(s).contains(value)){
            return true;
        }
        return false;
    }

    /*
    * 指定分类目录ID返回对应的分类别名
    * */
    public static String getCategoryAliasById(List<Category> list, int id){
        for(Category c:list){
            if(c.getId()==id){
                return c.getAlias();
            }
        }
        return null;
    }

    /*
    * 指定分类目录ID返回对应的名称
    * */
    public static String getCategoryNameById(List<Category> list, int id){
        for(Category c:list){
            if(c.getId()==id){
                return c.getName();
            }
        }
        return null;
    }

    /*
    * 日期格式化
    * */
    public static String dateFormat(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(time));
    }

    /*
    * 日期格式化含时间
    * */
    public static String dateFormatHasTime(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date(time));
    }

    /*
    * 获取文章摘要
    * */
    public static String getAbstract(String str,int len){
        return Tools.matchAbstract(str,len);
    }
}
