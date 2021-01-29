package com.shadow.dubbo.provider;

import com.shadow.dubbo.client.UserService;

/**
 * @author Shadow
 * @date 2021/01/28 22:39:20
 */
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String name) {
        System.out.println(name);
        return "hello" + name;
    }
}
