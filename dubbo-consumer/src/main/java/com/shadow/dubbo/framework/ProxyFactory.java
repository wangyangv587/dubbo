package com.shadow.dubbo.framework;

import com.shadow.dubbo.client.UserService;
import com.shadow.dubbo.entity.Invocation;
import com.shadow.dubbo.entity.URL;
import com.shadow.dubbo.framework.protocol.http.HttpClient;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author Shadow
 * @date 2021/01/28 23:53:56
 */
public class ProxyFactory {

    public static Object getInstance(Class interfaceClass) {

        return Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, ((proxy, method, args) -> {

            try {
                //代理 逻辑
                HttpClient httpClient = new HttpClient();
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);

                List<URL> cacheUrl = ConfigCache.getCache(interfaceClass.getName());
                //服务不可用处理，抛异常。。
                if (cacheUrl == null) {
                    throw new RuntimeException("There is no service named " + interfaceClass.getName());
                }
                URL url = LoadBalance.random(cacheUrl);
                return httpClient.send(url.getHostName(), url.getPort(), invocation);
            } catch (Exception e) {
//                e.printStackTrace();
                //服务调用异常 ，重试。。。
            }

            return "调用失败了";
        }));
    }
}
