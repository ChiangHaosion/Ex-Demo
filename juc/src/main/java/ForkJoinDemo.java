import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.RecursiveTask;

/**
 * @Author HaosionChiang
 * @Date 2020/4/9
 **/
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    private Long temp = 10000L;
    protected ForkJoinDemo(Long start,Long end){
        this.start=start;
        this.end=end;
    }

    @Override
    protected Long compute() {

        if ((end - start) < temp) {
            long sum = 0;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else {
            long mid = (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, mid);
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(mid + 1, end);
            task2.fork();
            return task1.join() + task2.join();
        }

    }
}
