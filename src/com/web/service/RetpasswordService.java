package com.web.service;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/27 0027.
 */
public class RetpasswordService {
    public Map<String,Object> getData(){
        Map<String,Object> map = new HashMap<>();
        map.put("header",new HeaderService().getHeaderData());
        map.put("footer",new FooterService().getFooterData());
        return map;
    }
}
