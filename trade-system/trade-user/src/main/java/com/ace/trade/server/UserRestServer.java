package com.ace.trade.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public class UserRestServer {
    public static void main(String[] args) {
      Server server = new Server(8080);
         ServletContextHandler servletContextHandler=  new ServletContextHandler();
            /*******************配置handler*********************/
        servletContextHandler.setContextPath("/user");
        //加载spring上下文
        XmlWebApplicationContext context =  new XmlWebApplicationContext();
        context.setConfigLocation("classpath:xml/spring-web-user.xml");
        //加入监听器
        servletContextHandler.addEventListener(new ContextLoaderListener(context));
        //创建servlet
        servletContextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)),"/*");
        //handler end

        //设置Handler
        server.setHandler(servletContextHandler);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
