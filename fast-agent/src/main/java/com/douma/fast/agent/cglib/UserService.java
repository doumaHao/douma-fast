package com.douma.fast.agent.cglib;

/**
 * @description:
 * @author: Douma | Hao xijun
 * @date: 2019/1/24 13:45
 */
public class UserService {

    public String getUserName(String userId) {
        System.out.println("调动实现类...");
        return userId;
    }

    public final String getUserName2(String userId) {
        System.out.println("调动实现类...");
        return userId;
    }

}
