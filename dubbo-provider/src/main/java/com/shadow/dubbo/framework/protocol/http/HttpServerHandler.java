package com.shadow.dubbo.framework.protocol.http;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSONObject;
import com.shadow.dubbo.entity.Invocation;
import com.shadow.dubbo.framework.register.LocalRegister;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Shadow
 * @date 2021/01/28 23:01:39
 */
public class HttpServerHandler {

    public void handler(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        try {
            //处理请求
            Invocation invocation = JSONObject.parseObject(req.getInputStream(), Invocation.class);

            Class implClass = LocalRegister.get(invocation.getInterfaceName());

            Method method = implClass.getMethod(invocation.getMethodName(),invocation.getParamTypes());
            Object result = method.invoke(implClass.newInstance(), invocation.getParams());

            IoUtil.write(res.getOutputStream(),"UTF-8",true,result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
