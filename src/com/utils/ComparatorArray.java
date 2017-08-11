package com.utils;

import java.util.Comparator;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/29 0029.
 */
public class ComparatorArray implements Comparator {
    @Override
    public int compare(Object o1,Object o2) {
        Map i = (Map)o1;
        Map j = (Map)o2;
        if((Integer)(i.get("count"))>(Integer)(j.get("count"))){
            return -1;
        }else if((Integer)(i.get("count"))==(Integer)(j.get("count"))){
            return 0;
        }else{
            return 1;
        }
    }
}
