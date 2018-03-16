package com.ace.trade.client;

import com.ace.trade.protocl.user.QueryUserRes;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 创建动态代理对象
 * Created by Administrator on 2018/3/14 0014.
 */
public class RestClientProxyFactory implements FactoryBean{
    private  RestTemplate restTemplate;
    public Class getServiceIntfacer() {
        return serviceIntfacer;
    }

    public void setServiceIntfacer(Class serviceIntfacer) {
        this.serviceIntfacer = serviceIntfacer;
    }

    private Class serviceIntfacer;
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(getClass().getClassLoader(),new Class[]{serviceIntfacer},new ClientProxy());
    }

    public Class<?> getObjectType() {
        return serviceIntfacer;
    }

    public boolean isSingleton() {
        return true;
    }

    private class ClientProxy implements InvocationHandler{

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            return restTemplate.postForObject("https://localhost:8080/user/"+method.getName(),args[0],method.getReturnType());

        }
    }
}
