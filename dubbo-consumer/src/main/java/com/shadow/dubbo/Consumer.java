package com.shadow.dubbo;


import com.shadow.dubbo.client.UserService;
import com.shadow.dubbo.framework.ConfigCache;
import com.shadow.dubbo.framework.ProxyFactory;

/**
 * @author Shadow
 * @date 2021/01/28 23:48:08
 */
public class Consumer {


    public static void main(String[] args) {

        //读取服务换粗信息
        ConfigCache.loadCache();

        //获取代理对象
        UserService userService = (UserService)ProxyFactory.getInstance(UserService.class);

        //远程调用
        String result = userService.sayHello("shadow");

        System.out.println(result);
    }
}
