import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 *
 * @Author HaosionChiang
 * @Date 2020/3/29
 **/
@Getter
@Setter
public class Ticket {
    /**
     余票量
     */
    private int size=30;


    //方式一: 使用synchronized
    public synchronized void sailTicket(){
        if (size > 0) {
            System.out.println(Thread.currentThread().getName()+"卖出了第"+(size--)+" 还剩:"+size);
        }
    }
    //方式二: 使用lock
    private Lock lock=new ReentrantLock();

    public void sailTicket1(){
        lock.lock();
        try {
            if (size>0){
                System.out.println(Thread.currentThread().getName()+"售货员卖出了第"+(size--)+"--还剩:"+size);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
