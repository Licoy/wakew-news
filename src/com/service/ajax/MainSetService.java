package com.service.ajax;

import com.beans.Category;
import com.dao.CategoryDao;
import com.dao.SetDao;
import com.dao.UserDao;
import com.utils.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/25 0025.
 */
public class MainSetService {
    private SetDao sd = new SetDao();
    /*
    * 判断是否存在该分类目录
    * */
    public boolean issetCategory(int id){
        Category category = new CategoryDao().selectCategoryById(id);
        return category != null;
    }

    /*
    * 存储栏目设置
    * */
    public Map<String,String> saveColumnSet(String columnIndexFooter,String columnIndexSlidebar,String columnPageSlidebar){
        Map<String,String> map = new HashMap<>();
        /*判断是否存在对应的分类目录*/
        String[] data = {columnIndexFooter,columnIndexSlidebar,columnPageSlidebar};
        boolean is = false;
        for (String aData : data) {
            String[] s = aData.split(",");
            for (String value : s) {
                if(Tools.isNumber(value)){
                    if (!issetCategory(Integer.parseInt(value))) {
                        is = true;
                        break;
                    }
                }else{
                    is = true;
                    break;
                }

            }
        }
        if(is){
            map.put("code","403");
            map.put("msg","目标数据有不存在分类目录！");
            return map;
        }

        /*开始存储*/
        int count = 0;
        count = sd.updateSetByKey("column-index-footer",columnIndexFooter);
        if(count>0){
            count = sd.updateSetByKey("column-index-slidebar",columnIndexSlidebar);
            if(count>0){
                count = sd.updateSetByKey("column-page-slidebar",columnPageSlidebar);
                if(count>0){
                    map.put("code","200");
                    map.put("msg","更新成功");
                }else{
                    map.put("code","403");
                    map.put("msg","更新失败！");
                }
            }else{
                map.put("code","403");
                map.put("msg","更新失败！");
            }
        }else{
            map.put("code","403");
            map.put("msg","更新失败！");
        }

        return map;
    }

    /*
    * 幻灯最大数设置
    * */
    public Map<String,String> saveSlideSet(int num){
        Map<String,String> map = new HashMap<>();
        int count = sd.updateSetByKey("slide-max-number",num+"");
        if(count>0){
            map.put("code","200");
            map.put("msg","更新成功！");
        }else{
            map.put("code","200");
            map.put("msg","更新失败！");
        }
        return map;
    }

    /*
    * 储存搜索框预留文字
    * */
    public Map<String,String> saveSearchSet(String str){
        Map<String,String> map = new HashMap<>();
        str = Tools.htmlEscape(str);
        int count = sd.updateSetByKey("search-placeholder",str);
        if(count>0){
            map.put("code","200");
            map.put("msg","更新成功！");
        }else{
            map.put("code","200");
            map.put("msg","更新失败！");
        }
        return map;
    }

    /*
    * 储存底部设置
    * */
    public Map<String,String> saveFooterSet(String footer){
        Map<String,String> map = new HashMap<>();
        int count = sd.updateBigSetByKey("footer",footer);
        if(count>0){
            map.put("code","200");
            map.put("msg","更新成功！");
        }else{
            map.put("code","200");
            map.put("msg","更新失败！");
        }
        return map;
    }

    /*
    * 储存条款设置
    * */
    public Map<String,String> saveClauseSet(String clause){
        Map<String,String> map = new HashMap<>();
        int count = sd.updateBigSetByKey("register-clause",clause);
        if(count>0){
            map.put("code","200");
            map.put("msg","更新成功！");
        }else{
            map.put("code","200");
            map.put("msg","更新失败！");
        }
        return map;
    }




}
