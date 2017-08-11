package com.beans;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/18 0018.
 */
public class News {
    private int id;
    private String title;
    private String text;
    private int author;
    private int impnews;
    private int slide;
    private String slideImg;
    private String tag;
    private int category;
    private int views;
    private int searchs;
    private HashMap attr = new HashMap();
    public String getSlideImg() {
        return slideImg;
    }

    public void setSlideImg(String slideImg) {
        this.slideImg = slideImg;
    }
    public HashMap getAttr() {
        return attr;
    }

    public void setAttr(HashMap attr) {
        this.attr = attr;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getSearchs() {
        return searchs;
    }

    public void setSearchs(int searchs) {
        this.searchs = searchs;
    }

    private long created;
    private long updated;

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getImpnews() {
        return impnews;
    }

    public void setImpnews(int impnews) {
        this.impnews = impnews;
    }

    public int getSlide() {
        return slide;
    }

    public void setSlide(int slide) {
        this.slide = slide;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }
}
