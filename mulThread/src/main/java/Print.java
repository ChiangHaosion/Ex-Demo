import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author HaosionChiang
 * @Date 2020/3/29
 **/
public class Print {
    
    private Lock lock=new ReentrantLock();
    Condition condition1=lock.newCondition();
    Condition condition2=lock.newCondition();
    Condition condition3=lock.newCondition();
    private int sort=1;
    
    public void printA(){
        lock.lock();
        try {
            while (sort!=1){
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.print(Thread.currentThread().getName());
            }
            System.out.println();
            sort=2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            while (sort!=2){
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.print(Thread.currentThread().getName());
            }
            System.out.println();
            sort=3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            while (sort!=3){
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.print(Thread.currentThread().getName());
            }
            System.out.println();
            sort=1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
