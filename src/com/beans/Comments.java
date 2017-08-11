package com.beans;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/18 0018.
 */
public class Comments {
    private int id;
    private int user;
    private String text;
    private long issuedate;
    private int news;
    private int support;
    private int contain;
    private HashMap attr = new HashMap();

    public HashMap getAttr() {
        return attr;
    }

    public void setAttr(HashMap attr) {
        this.attr = attr;
    }

    public Comments() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(long issuedate) {
        this.issuedate = issuedate;
    }

    public int getNews() {
        return news;
    }

    public void setNews(int news) {
        this.news = news;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    public int getContain() {
        return contain;
    }

    public void setContain(int contain) {
        this.contain = contain;
    }
}
