package com.mall.utils;



import com.github.pagehelper.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回数据
 *
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
    }


    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }




    public static R ok(int code, String msg, Object data) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        r.put("data", data);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        R r=new R();
        r.put("msg","成功");
        return r;
    }

    public static R okWithData(Object data) {
        R r=new R();
        r.put("msg","成功");
        r.put("data",data);
        return r;
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     *通过pageHelper分页
     * @param list
     * @return
     */
    public static R okPage( List<?> list) {
        R r = new R();
        Page<?> page = (Page) list;
        r.put("count",Integer.valueOf(page.getTotal()+""));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data",list);
        r.putAll(map);
        return r;
    }

}
