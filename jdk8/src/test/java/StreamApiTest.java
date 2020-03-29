import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName StreamApiTest
 * @Description: TODO
 * @Author HaosionChiang
 * @Date 2020/3/22
 * @Version V1.0
 **/


public class StreamApiTest {

    List<Employee> employees = Arrays.asList(
            new Employee("张一", 10, 3000),
            new Employee("赵二", 22, 4440),
            new Employee("孙三", 30, 3430),
            new Employee("王四", 90, 9900),
            new Employee("李五", 30, 3430),
            new Employee("李五", 30, 3430)
    );

    /**
     * 创建Stream流
     */

    @Test
    public void test1() {
        //方式一：通过collection提供的stream()或者parallelStream()
        ArrayList<String> str = new ArrayList<>();
        Stream<String> stream = str.stream();

        //方式二：通过Arrays里面的stream()
        String[] str1 = new String[10];
        Stream<String> stream1 = Arrays.stream(str1);

        //方式三：通过Stream类中的静态方法
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");

        //方式四：无限流1
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);

        //方式四：无线流2
        Stream<Double> stream4 = Stream.generate(Math::random);

    }

    /**
     * 筛选与切片
     * filter 接受lambda 从流中排除部分元素
     * limit 截断流 使其元素不超过给定数量
     * skip(n) 跳过流 返回扔掉前n个的元素的流
     * distinct 通过元素的hashcode() equals() 去除重复元素
     */
    @Test
    public void test2() {

        /**
         * Stream 中间操作不会执行，直到遇到终止操作，才会一次性执行，称之为 “惰性求值”
         */

        employees.stream().filter((x) -> x.getAge() > 30)
                .forEach(System.out::println);//forEach属于终止操作
        System.out.println("========================================");
        employees.stream().limit(2)
                .forEach(System.out::println);

        //“短路” filter加上limit  一旦找到符合条件的两条数据，就不再继续
        System.out.println("========================================");
        employees.stream().filter((x) -> x.getAge() > 10)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("========================================");
        employees.stream().skip(3).distinct().forEach(System.out::println);


    }

    /**
     * 映射 map  接受lambda 将元素转换为其他形式或者提取信息.(接受一个函数作为参数，该函数会应用到每个元素上，并将其映射成一个新的元素)
     *     flatMap  接受一个函数作为参数，将流中每一个值都换为一个流，然后将所有的流连成一个流
     */
    @Test
    public void test3(){

        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("-----------------------------------------------");
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }
}
