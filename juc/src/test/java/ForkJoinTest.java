import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * 求和的计算任务
 * 从1加到1000000000
 * @Author HaosionChiang
 * @Date 2020/4/9
 **/
public class ForkJoinTest {
    @Test
    public void testForkJoin() throws ExecutionException, InterruptedException {
        long begin = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);//提交任务
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+": time="+(end-begin));
    }

    @Test
    public void testStreamParallel(){
        long begin = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum="+reduce+": time="+(end-begin));
    }



}
