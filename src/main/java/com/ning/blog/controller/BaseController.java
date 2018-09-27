package com.ning.blog.controller;

import com.ning.blog.domain.ReturnCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 用途：
 * 作者：郭桐宁
 * 时间：2018/9/27 15:00
 * Version:1.0
 */
public abstract class BaseController {
    protected static final String RETURNCODE = "returnCode";

    /**
     * @return 获取一个返回的map，默认放入了操作成功的返回json。key = returnCode value = ReturnCode.SUCCESS
     */
    Map<String, Object> getReturnMap() {
        HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put(RETURNCODE, ReturnCode.str2JsonStr(ReturnCode.SUCCESS));
        return returnMap;
    }

    void setReturnCode(Map<String, Object> map, ReturnCode returnCode) {
        map.put(RETURNCODE, ReturnCode.str2JsonStr(returnCode));
    }

    void setReturnObject(Map<String, Object> map, String name, Object obj) {
        map.put(name, obj);
    }
}
