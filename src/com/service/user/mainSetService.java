package com.service.user;

import com.beans.Category;
import com.beans.Set;
import com.dao.CategoryDao;
import com.dao.SetDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/24 0024.
 */
public class mainSetService {
    /*
    * 查询栏目设置
    * */
    private Set getSetByKey(String key){
        return new SetDao().selectSetByKey(key);
    }

    /*
    * 查询分类目录的信息
    * */
    private List<Category> getCategory(){
        return new CategoryDao().selectAllCategory(0,1000);
    }

    /*
    * 返回基本设置所有数据
    * */
    public Map getMainSet(){
        Map map = new HashMap();
        map.put("column-index-footer",getSetByKey("column-index-footer"));
        map.put("column-index-slidebar",getSetByKey("column-index-slidebar"));
        map.put("column-page-slidebar",getSetByKey("column-page-slidebar"));
        map.put("slide-max-number",getSetByKey("slide-max-number"));
        map.put("search-placeholder",getSetByKey("search-placeholder"));
        map.put("footer",getSetByKey("footer"));
        map.put("register-clause",getSetByKey("register-clause"));
        map.put("category",getCategory());
        return map;
    }
}
