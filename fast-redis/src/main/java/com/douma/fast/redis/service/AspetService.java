package com.douma.fast.redis.service;

import com.douma.fast.redis.annotation.DistributedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Douma | Hao xijun
 * @date: 2018/12/29 17:14
 */
@Service
public class AspetService {

    final static private String KEY = "KEY";

    @Autowired
    private RedisService redisService;

    /**
     * 测试 Aspect
     *
     * @param i
     * @return
     */
    @DistributedLock
    public int testAspect(int i, String i2) {
        return i + 1;
    }

    @DistributedLock
    public int testAspectWithException(int i){

        redisService.put("11111", "22222");

        throw new RuntimeException("方法执行异常");
    }

    @DistributedLock
    public void testDistributedLock() {

        int count = Integer.valueOf(redisService.get(KEY).toString());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count++;

        redisService.put(KEY, count);

    }

}
