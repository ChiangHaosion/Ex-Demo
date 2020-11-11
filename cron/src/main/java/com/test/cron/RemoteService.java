package com.test.cron;

import cn.hutool.core.util.RandomUtil;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author HaosionChiang
 */
@Service
public class RemoteService {
    @Retryable(
            value = {RemoteAccessException.class},
            backoff = @Backoff(delay = 5000L, multiplier = 1))
    @Async
    public void call() {
        int a = RandomUtil.randomInt(1,100);
        if (a!=66) {
            System.out.println("RPC调用异常");
            throw new RemoteAccessException("RPC调用异常");
        }
        System.out.println("方法成功调用");
    }

    @Recover
    public void recover(RemoteAccessException e) {
        System.out.println("重试都没有成功，在这里做数据还原");
        e.printStackTrace();
    }
}
