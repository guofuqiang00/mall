package com.mall.utils;

//import net.sf.json.JSONArray;

//import net.sf.json.JSONArray;

import java.util.List;


public class Page<T> {

    //每页显示多少条
    private int pageSize = 5;
    //第几页
    private int pageCount;
    //总条数
    private int totalNum;
    //总页数
    private int totalPage;
    //查询起始位置
    private int numStart;

    private List<T> objects;

    /**
     * 第一页
     */
    public final static int FIRST_PAGE = 1;
    /**
     * 默认每页显示的记录数
     */
    public static final int DEFAULT_PAGE_SIZE = 20;

    //@Override
    public int getOffset() {
        if(pageCount >= 1){
            return (pageCount-1) * pageSize;
        }
        return 0;
    }
    /**
     * 获取当前页的偏移量
     * @return
     */
    public Integer getStartIndex(){
        return getOffset();
    }
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
        if(totalNum%pageSize == 0){
            this.totalPage = totalNum/pageSize;
        }else{
            this.totalPage = totalNum/pageSize+1;
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public int getNumStart() {
        this.numStart = (pageCount-1)*pageSize;
        return numStart;
    }

    public void setNumStart(int numStart) {
        this.numStart = numStart;
    }

//    public String toString(){
//        return JSONArray.fromObject(this).toString();
//    }
    public String toJsonString(){
        return this.toString();
    }
}
