package com.douma.fast.agent.proxy;

/**
 * @description:
 * @author: Douma | Hao xijun
 * @date: 2019/1/24 08:58
 */
public class UserServiceImpl implements UserService {

    @Override
    public String getUserName(String userId) {
        System.out.println("调动实现类...");
        return userId;
    }

}
