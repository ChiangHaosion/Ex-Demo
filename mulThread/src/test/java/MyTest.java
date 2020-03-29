import org.junit.jupiter.api.Test;

/**
 * @Author HaosionChiang
 * @Date 2020/3/29
 **/
public class MyTest {

    /**
     * 1,在高内聚,低耦合的前提下,线程   操作   资源类
     * 2,判断,干活,通知
     * 3,多线程交互中,必须要防止虚假唤醒,判断使用while,而非if
     * 4,标志位的使用
     */

    /**
     * 题目:三个售票员A,B,C,卖出30张票
     */
    //方式1 synchronized
    @Test
    public void test(){

        Ticket ticket = new Ticket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sailTicket();
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sailTicket();
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sailTicket();
                }
            }
        },"C").start();
    }
    //方式1 lambda表达式写法
    @Test
    public void test1(){

        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sailTicket();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sailTicket();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sailTicket();
            }
        },"C").start();
    }

    //方式2 lock
    @Test
    public void test2(){
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sailTicket1();
            }
        },"a").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sailTicket1();
            }
        },"b").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sailTicket1();
            }
        },"c").start();
    }


    /**
     * 题目:两个线程,操作初始值为0的一个变量,实现一个线程对其加1，另一个线程减1，交替实现，10轮后，变量的初始值仍然是0.
     */
    //方式一：synchronized wait notifyAll
    @Test
    public void test3(){
        Air air = new Air();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                air.add();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                air.sub();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                air.add();
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                air.sub();
            }
        },"D").start();
    }
    //方式二：lock-condition  await signalAll
    @Test
    public void test4(){
        Air air = new Air();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                air.add1();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                air.sub1();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                air.add1();
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                air.sub1();
            }
        },"D").start();
    }


    /**
     * 题目： 多线程之间顺序调用，实现 A->B->C
     * 要求顺序如下：　A　打印５次　B打印10次　C打印15次  按照这个顺序打印10轮
     */
    @Test
    public void test5(){
        Print print = new Print();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                print.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                print.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                print.printC();
            }
        },"C").start();
    }


}
