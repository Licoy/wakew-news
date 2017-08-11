package com.beans;

/*
 * Created by Licoy on 2016/12/18 0018.
 */
public class Nav {
    private int id;
    private int type;/*type=0代表小栏导航,为1时代表大栏导航*/
    private String name;
    private int priority;
    private int types;/*type=0时代表分类目录,为1时代表链接*/
    private int category;
    private String url;

    public Nav() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTypes() {
        return types;
    }

    public void setTypes(int types) {
        this.types = types;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
