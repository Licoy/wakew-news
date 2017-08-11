package com.test;

import com.beans.Set;
import com.dao.SetDao;
import com.utils.Tools;

import java.util.List;

/*
 * Created by Licoy on 2016/12/19 0019.
 */
public class SetDaoTest {
    public static void main(String[] args) {
        SetDao set = new SetDao();
        /*List<Set> list = set.selectAllSet();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("key:"+list.get(i).getKey()+";value:"+list.get(i).getValue());
        }*/
        Set set1 = set.selectSetByKey("key5");
        /*if(set1!=null){
            System.out.println("key:"+set1.getKey()+";value:"+set1.getValue()+";时间:"+ Tools.dateFormat(set1.getUpdated()));
        }else{
            System.out.println("不存在");
        }*/
        /*Set sets = new Set();
        sets.setKey("key7");
        sets.setValue("value7_big");
        sets.setType(1);*/
        System.out.println(set.deleteSetByid(set1.getId()));
    }
}
