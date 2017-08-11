package com.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by Licoy on 2016/12/21 0021.
 */
public class Page {
    private int nowPageNum;     /*当前页*/
    private int totalNum;       /*记录总数*/
    private int pageSize = 6;  /*每页显示数*/
    private int pageNum;        /*总分页数*/
    private int startIndex;     /*数据库查询开始行*/
    private int startPage;      /*开始页*/
    private int endPage;        /*结束页*/
    private String url;            /*调用URL*/
    private List list;          /*携带内容*/
    private Map attr = new HashMap(); /*不必要因素*/

    public Map getAttr() {
        return attr;
    }

    public void setAttr(Map attr) {
        this.attr = attr;
    }

    public Page(int nowPageNum, int totalNum, String url) {
        this.nowPageNum = nowPageNum;
        this.totalNum = totalNum;
        this.url = url;
        /*计算总分页数*/
        if(totalNum%pageSize==0){
            pageNum = totalNum/pageSize;
        }else{
            pageNum = (totalNum/pageSize)+1;
        }

        /*计算数据库开始查询行*/
        startIndex = (nowPageNum-1)*pageSize;
        /*计算开始页与结束页*/
        if(pageNum<5){/*若总页数小于5条*/
            startPage = 1;
            endPage = pageNum;
        }else{
            if(nowPageNum<=3){/*若当前页还没有到达居中*/
                startPage = 1;
                endPage = 5;
            }else{
                if(nowPageNum<=(pageNum-3)&&(nowPageNum+2)<=pageNum){
                    startPage = nowPageNum-2;
                    endPage = nowPageNum+2;
                }else{
                    startPage = pageNum-4;
                    endPage = pageNum;
                }
            }
        }
    }

    public int getNowPageNum() {
        return nowPageNum;
    }

    public void setNowPageNum(int nowPageNum) {
        this.nowPageNum = nowPageNum;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
