package com.mall.utils;


import com.github.pagehelper.PageHelper;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 *
 */
public class QueryPageHelper extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    //当前页码
    private int page=1;
    //每页条数
    private int limit=20;

    public QueryPageHelper(Map<String, Object> params){
        this.putAll(params);

        //分页参数
        if (null != params.get("page")) {
            this.page = Integer.parseInt(params.get("page").toString());
        }
        if (null != params.get("limit")) {
            this.limit = Integer.parseInt(params.get("limit").toString());
        }
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String sidx = (String)params.get("sidx");
        String order = (String)params.get("order");

        PageHelper.startPage(page,limit);
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
