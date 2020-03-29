import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @ClassName LambdaTest
 * @Description: TODO
 * @Author HaosionChiang
 * @Date 2020/3/23
 * @Version V1.0
 **/
public class LambdaTest {


    //1.基础语法
    //左侧：Lambda表达式参数
    //右侧：lambda表达式方法体
    //语法一：无参数，无返回值    ()->System.out.println("hello world");
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        runnable.run();
        System.out.println("===========================");
        Runnable r = () -> System.out.println("hello lambda");
        r.run();

    }
    //语法二：有一个参数，无返回值  (x)->system.out.println(x)
    @Test
    public void test2() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("ni hao lambda");
        Consumer<String> consumer1=System.out::println;
        consumer1.accept("ni hao lambda1");

    }

    //语法三：有两个以上参数，有返回值，函数体中有多条语句
    @Test
    public void test3(){
        Comparator<Integer> comparator=(x,y)->{
            return x.compareTo(y);
        };
    }
    //语法四： 若只有一个参数，小括号可以省略 x->system.out.println(x)
    //        若只有一个返回语句，大括号和return 都可以不写
    //        lambda表达式的参数类型可以不写，因为jvm可以通过上下文自动判断，“类型推断”
    @Test
    public void test4(){
        Comparator<Integer> comparator=Integer::compareTo;
        int compare = comparator.compare(3, 5);
    }

    //lambda表达式需要函数式接口的支持，即只有一个抽象方法的接口 jdk1.8


    @Test
    public void test5(){
        Integer op = op(11, x -> x * x);
        System.out.println(op);
    }

    public Integer op(int a,Predicate predicate){
        return predicate.getValue(a);
    }


    /**
     * lambda 表达式联系题
     * 1.使用Collections.sort 方法，定制排序，先按照年龄比，年龄相同按照姓名比。
     * 2.声明函数式接口，定义一个抽象方法，声明一个类，参数为接口，处理相关的字符串，转为大写/截取一段。
     * 3.声明一个带两个泛型的接口，T R 计算连个long类型的乘积。
     */

    List<Employee> employees=Arrays.asList(
            new Employee("zhangsan",11,2000),
            new Employee("lisi",21,3000),
            new Employee("wangwu",21,2200),
            new Employee("zhaoliu",8,9000),
            new Employee("sunqi",8,1200)
    );
    @Test
    public void test6(){
        Collections.sort(employees,(x,y)->{
            if (x.getAge()==y.getAge()){
                return x.getName().compareTo(y.getName());
            }else {
                return Integer.compare(x.getAge(),y.getAge());
            }
        });

        employees.forEach(System.out::println);
    }





























}
