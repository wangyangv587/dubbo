package com.shadow.dubbo.framework;

import com.alibaba.fastjson.JSONObject;
import com.shadow.dubbo.entity.URL;

import java.util.List;
import java.util.Random;

/**
 * @author Shadow
 * @date 2021/01/29 00:39:46
 */
public class LoadBalance {

    public static URL random(List<URL> list) {

        Random random = new Random();
        int i = random.nextInt(list.size());
        URL url = JSONObject.parseObject(JSONObject.toJSONString(list.get(i)), URL.class);

        return url;
    }
}
