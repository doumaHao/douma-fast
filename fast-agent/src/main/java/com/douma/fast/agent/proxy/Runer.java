package com.douma.fast.agent.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: Douma | Hao xijun
 * @date: 2019/1/24 08:59
 */
public class Runer {

    public static void main(String[] args) {

        UserService proxy = (UserService) Proxy.newProxyInstance(
                Runer.class.getClassLoader(),
                new Class[]{UserService.class},
                new InvocationHandler() {
                    UserServiceImpl impl = new UserServiceImpl();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("调用实际方法前...");
                        Object result = method.invoke(impl, args);
                        System.out.println("调用实际方法后...");
                        return result;
                    }
                });

        String result = proxy.getUserName("123");
        System.out.println("调用结果=" + result);
    }

}
