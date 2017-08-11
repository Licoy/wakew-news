package com.service.ajax;

import com.dao.SetDao;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/25 0025.
 */
public class SiteSetService {
    /*
    * 提交更新数据
    * */
    private Map<String,String> sendData(String key,String value,boolean isBig){
        Map<String,String> map = new HashMap<>();
        int count;
        if(isBig){
            count = new SetDao().updateBigSetByKey(key,value);
        }else{
            count = new SetDao().updateSetByKey(key,value);
        }
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
    * 更新公告数据
    * */
    public Map<String,String> saveNoticeSet(String str){
        return this.sendData("notice",str,true);
    }

    /*
    * 更新SEO数据
    * */
    public Map<String,String> saveSiteSet(String title,String keyword,String describ){
        this.sendData("site-title",title,false);
        this.sendData("site-keyword",keyword,false);
        return this.sendData("site-describe",describ,false);
    }

    /*
    * 更新LOGO
    * */
    public Map<String,String> saveLogoSet(String str){
        return this.sendData("logo-url",str,false);
    }

    /*
    * 更新ICO
    * */
    public Map<String,String> saveIcoSet(String str){
        return this.sendData("ico-url",str,false);
    }
}
