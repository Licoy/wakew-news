package com.service.user;

import com.beans.Set;
import com.dao.SetDao;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/24 0024.
 */
public class SiteSetService {
    /*
    * 获取设置
    * */
    public Set getSetByKey(String key){
        return new SetDao().selectSetByKey(key);
    }

    /*
    * 获取设置数据
    * */
    public Map getSetData(){
        Map data = new HashMap();
        data.put("notice",getSetByKey("notice"));
        data.put("site-title",getSetByKey("site-title"));
        data.put("site-keyword",getSetByKey("site-keyword"));
        data.put("site-describe",getSetByKey("site-describe"));
        data.put("logo-url",getSetByKey("logo-url"));
        data.put("ico-url",getSetByKey("ico-url"));
        return data;
    }
}
