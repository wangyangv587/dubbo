package com.shadow.dubbo;


import com.shadow.dubbo.client.UserService;
import com.shadow.dubbo.entity.URL;
import com.shadow.dubbo.framework.protocol.http.HttpServer;
import com.shadow.dubbo.framework.register.LocalRegister;
import com.shadow.dubbo.provider.UserServiceImpl;
import com.shadow.dubbo.register.RemotingRegister;


/**
 * @author Shadow
 * @date 2021/01/28 22:39:57
 */
public class Provider {

    public static void main(String[] args) {

        LocalRegister.register(UserService.class.getName(),UserServiceImpl.class);
        RemotingRegister.register(UserService.class.getName(), new URL("localhost",8080));

        RemotingRegister.flush();

        //启动tomcat
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost",8080);
    }
}
