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
    public int testAspect(int i, String i2) {

        int count = 1;
        redisService.put(KEY, count);

        for (int k = 0; k < 1; k++) {
            new Runnable() {
                @Override
                public void run() {
                    testDistributedLock();
                }
            }.run();
        }

        return i + 1;
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
