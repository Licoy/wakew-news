package com.web.service;

import com.beans.Category;
import com.beans.Set;
import com.dao.CategoryDao;
import com.dao.SetDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/26 0026.
 */
public class HeaderService {

    /*
    * 查询出所有的分类导航
    * */
    private List<Category> getAllCategory(){
        return new CategoryDao().selectAllCategoryDisDefault();
    }

    /*
    * 查询设置
    * */
    private Set getSet(String key){
        return new SetDao().selectSetByKey(key);
    }

    /*
    * 查询分类目录总集
    * */
    private List<Category> getCategoryCollection(){
        return new CategoryDao().selectAllCategory(0,1000);
    }

    public Map<String,Object> getHeaderData(){
        Map<String,Object> map = new HashMap<>();
        /*搜索框预留文字*/
        Set searchSet = getSet("search-placeholder");
        /*底部文档*/
        Set footerSet = getSet("footer");
        /*LOGO_URL*/
        Set logourlSet = getSet("logo-url");
        /*ICO_URL*/
        Set icourlSet = getSet("ico-url");
        /*站点标题*/
        Set siteTitle = getSet("site-title");
        /*站点关键字*/
        Set siteKeyword = getSet("site-keyword");
        /*站点描述*/
        Set siteDescribe = getSet("site-describe");
        map.put("searchSet",searchSet.getValue());
        map.put("footerSet",footerSet.getValue());
        map.put("logourlSet",logourlSet.getValue());
        map.put("icourlSet",icourlSet.getValue());
        map.put("siteTitle",siteTitle.getValue());
        map.put("siteKeyword",siteKeyword.getValue());
        map.put("siteDescribe",siteDescribe.getValue());
        map.put("category",getCategoryCollection());
        map.put("nav",getAllCategory());
        return map;
    }
}
