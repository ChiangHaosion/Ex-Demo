package com.ex.service.impl;

import com.ex.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author HaosionChiang
 * @Date 2020/10/12
 **/

@Service
public class OrderServiceImpl implements IOrderService {

    /**
     * 当无事务方法调用有事务的方法时事务不会生效，
     * 而主方法有事务去调用其他方法，无论被调用的方法有无事务，且是否出现异常（有异常需要能够抛出不被捕获），都触发事务。
     */


    @Override
    @Transactional
    public void testMethodA() {

    }
}
