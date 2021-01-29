package com.shadow.dubbo.framework.protocol.http;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.shadow.dubbo.entity.Invocation;

/**
 * @author Shadow
 * @date 2021/01/28 23:38:29
 */
public class HttpClient {

    public static String send(String host, int port, Invocation invocation){
        return HttpUtil.post("http://" + host + ":" + port + "/", JSONObject.toJSONString(invocation));
    }
}
