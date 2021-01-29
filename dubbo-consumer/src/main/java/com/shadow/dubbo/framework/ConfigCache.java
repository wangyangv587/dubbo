package com.shadow.dubbo.framework;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.shadow.dubbo.entity.URL;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author Shadow
 * @date 2021/01/29 00:48:35
 */
public class ConfigCache {

    public static Map<String, List<URL>> cache;

    public static void loadCache() {

        System.out.println("获取服务缓存");
        String urls = FileUtil.readString(new File("D:\\url.txt"), "UTF-8");
        cache = (Map<String, List<URL>>) JSONObject.parseObject(urls, Map.class);
    }

    public static void remove(String interfaceName, URL url) {
        if (cache == null) {
            return;
        }
        List<URL> urls = cache.get(interfaceName);
        if (urls != null) {
            System.out.println("服务下线：" + urls);
            urls.remove(url);
        }
    }

    public static List<URL> getCache(String interfaceName) {
        return cache.get(interfaceName);
    }
}
