package com.shadow.dubbo.register;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.shadow.dubbo.entity.URL;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shadow
 * @date 2021/01/29 00:07:57
 */
public class RemotingRegister {

    private static final Map<String, List<URL>> map = new HashMap<>();

    public static void register(String interfaceName, URL url) {
        List<URL> urls = map.get(interfaceName);
        if (urls == null) {
            urls = new ArrayList<>();
        }
        urls.add(url);
        map.put(interfaceName, urls);
    }

    public static void flush(){
        FileUtil.writeString(JSONObject.toJSONString(map),new File("D:\\url.txt"),"UTF-8");
    }

    public static List<URL> getUrl(String interfaceName) {

        return map.get(interfaceName);
    }
}
