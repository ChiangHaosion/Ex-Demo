import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Author HaosionChiang
 * @Date 2020/3/29
 **/
@Slf4j
public class OldTest {

    @Test
    public void test() {
        //卖票
        //创建线程任务
        Tickets t = new Tickets();
        //创建线程对象，共计三条，将创建的线程任务传入线程对象
        Thread t0 = new Thread(t);
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        //开始线程
        log.info("开始啦！！");
        t0.start();
        t1.start();
        t2.start();
        log.info("结束啦！！");

    }

    class Tickets implements Runnable {
        //多个线程共享，必须要用成员变量
        private int ticket = 100;
        private Object obj = new Object();

        //重写run
        public void run() {
            while (true) {
                synchronized (obj) {//把会出现问题的代码放入同步代码块中。
                    if (ticket > 0) {
                        //获取名称并让倒售出票，--先赋值再运算，当ticket变成100，成员变量成99
                        System.out.println(Thread.currentThread().getName() + "售出第" + ticket-- + "张票");
                    }
                }
            }
        }
    }
}
