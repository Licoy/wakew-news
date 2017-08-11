package com.beans;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/18 0018.
 */
public class Group {
    private int id;
    private String name;
    private String level;
    private Map attr = new HashMap();

    public Map getAttr() {
        return attr;
    }

    public void setAttr(Map attr) {
        this.attr = attr;
    }

    public Group() {
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
