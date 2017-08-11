package com.web.service;

import com.beans.Set;
import com.dao.SetDao;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/26 0026.
 */
public class FooterService {
    /*
    * 查询设置
    * */
    private Set getSet(String key){
        return new SetDao().selectSetByKey(key);
    }

    public Map<String,Object> getFooterData(){
        Map<String,Object> map = new HashMap<>();
        /*底部文档*/
        Set footerSet = getSet("footer");
        map.put("footerSet",footerSet.getValue());
        return map;
    }
}
