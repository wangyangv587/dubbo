package com.shadow.dubbo.framework.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shadow
 * @date 2021/01/28 23:14:16
 */
public class LocalRegister {

    private static final Map<String,Class> map = new HashMap<>();

    public static void register(String name,Class clazz){
        map.put(name,clazz);
    }

    public static Class get(String name){
        return map.get(name);
    }
}
