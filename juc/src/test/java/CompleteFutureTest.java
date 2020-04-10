import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author HaosionChiang
 * @Date 2020/4/9
 **/
public class CompleteFutureTest {

    @Test
    public void testCompleteFuture1() throws ExecutionException, InterruptedException {
        // 没有返回值的 runAsync 异步回调
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "runAsync-无返回值");
        });
        System.out.println("111");
        voidCompletableFuture.get();
        System.out.println("hello");
    }

    @Test
    public void testCompleteFuture2() throws ExecutionException, InterruptedException {
        // 有返回值的 supplyAsync 异步回调
        // ajax，成功和失败的回调
        CompletableFuture<Integer> uCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "supplyAsync-返回int");
            int i = 1 / 0;
            return 10;
        });
        System.out.println(
                uCompletableFuture.whenComplete((t, u) -> {
                    System.out.println("t=" + t);//正常的返回结果
                    System.out.println("u=" + u);//错误信息
                }).exceptionally(e -> {
                    System.out.println(e.getMessage());
                    return 500;//可获取错误的返回结果
                }).get());
    }
}
