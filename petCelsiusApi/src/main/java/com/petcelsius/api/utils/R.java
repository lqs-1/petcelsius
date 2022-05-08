package com.petcelsius.api.utils;


import com.petcelsius.api.constant.REnum;

import java.util.HashMap;
import java.util.Map;


/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 相应数据工具类
 */

public class R extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public R() {
        put("code", REnum.SUCCESS.getStatusCode());
        put("msg", REnum.SUCCESS.getStatusMsg());
    }


    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R error() {
        R r = new R();
        r.put("code", REnum.FAIL.getStatusCode());
        r.put("msg", REnum.FAIL.getStatusMsg());
        return r;
    }

    public static R error(String msg) {
        R r = new R();
        r.put("code", REnum.FAIL.getStatusCode());
        r.put("msg", msg);
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
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }


    public static void main(String[] args) {
        R ok = R.error();
        System.out.println(ok);
    }
}