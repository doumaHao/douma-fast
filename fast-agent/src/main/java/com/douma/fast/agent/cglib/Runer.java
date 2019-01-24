package com.douma.fast.agent.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Douma | Hao xijun
 * @date: 2019/1/24 14:10
 */
public class Runer {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("调用实际方法前...");
                Object object = methodProxy.invokeSuper(o, objects);
                System.out.println("调用实际方法后...");
                return object;
            }
        });
        UserService proxy = (UserService) enhancer.create();
        String result = proxy.getUserName("123");
        System.out.println("调用结果=" + result);
    }

}
