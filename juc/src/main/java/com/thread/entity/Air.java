package com.thread.entity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author HaosionChiang
 * @Date 2020/3/29
 **/
public class Air {
    /**
     * 温度
     */
    private int tempture=0;

    public void add(){
        synchronized (this){
            while (tempture!=0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":add "+(++tempture));
            this.notifyAll();
        }
    }

    public void sub(){
        synchronized (this){
            while (tempture==0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":sub "+(--tempture));
            this.notifyAll();
        }
    }


    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    public void add1(){
        lock.lock();
        try {
            while (tempture!=0){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+":add "+(++tempture));
            condition.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void sub1(){
        lock.lock();
        try {
            while (tempture==0){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+":sub "+(--tempture));
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
