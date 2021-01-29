package com.shadow.dubbo.framework.protocol.http;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Shadow
 * @date 2021/01/28 22:57:46
 */
public class DispatcherServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        new HttpServerHandler().handler(req,res);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
