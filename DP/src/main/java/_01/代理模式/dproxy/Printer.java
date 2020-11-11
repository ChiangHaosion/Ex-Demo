package _01.代理模式.dproxy;

/**
 * @Author HaosionChiang
 * @Date 2020/6/15
 **/
public class Printer implements IPrinter {
    @Override
    public void print() {
        System.out.println("打印!");
    }
}
