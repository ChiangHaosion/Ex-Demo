
import java.util.concurrent.*;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author Haosion
 * @Date 2020/1/19
 * @Version V1.0
 **/
public class TestExecutor {

    /**
     * new ThreadPoolExecutor.AbortPolicy() // 银行满了，还有人进来，不处理这个人的，抛出异 常
     * new ThreadPoolExecutor.CallerRunsPolicy() // 哪来的去哪里！
     * new ThreadPoolExecutor.DiscardPolicy() //队列满了，丢掉任务，不会抛出异常！
     * new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，尝试去和早的竞争，也不会 抛出异常！
     * */
    public static void main(String[] args) {
        //单个线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //固定大小线程池
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);

        //可伸缩,可大可小
        ExecutorService executorService2 = Executors.newCachedThreadPool();

        //自定义线程池
        ThreadPoolExecutor kss = new ThreadPoolExecutor(2,3, 3, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        //最大承载线程数 队列数+maxPoolSize   最大是12+3=15个
        try {
            for (int i = 1; i <= 6; i++) {
                kss.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            kss.shutdown();
        }
    }
}