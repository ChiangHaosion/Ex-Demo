package _01.代理模式.dproxy;


/**
 * @Author HaosionChiang
 * @Date 2020/6/15
 **/
public class Test {
    public static void main(String[] args) {
        ProxyHandler proxyHandler = new ProxyHandler();
        IPrinter printer = (IPrinter) proxyHandler.newProxyInstance(new Printer());
        printer.print();

    }
}
