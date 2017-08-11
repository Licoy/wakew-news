package com.beans;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/18 0018.
 */
public class Category {
    private int id;
    private String name;
    private String alias;
    private String describe;
    private Map attr = new HashMap();

    public Map getAttr() {
        return attr;
    }

    public void setAttr(Map attr) {
        this.attr = attr;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
