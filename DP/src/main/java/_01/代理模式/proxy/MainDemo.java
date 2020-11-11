package _01.代理模式.proxy;

/**
 * @Author HaosionChiang
 * @Date 2020/6/15
 **/
public class MainDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("xx.jpg");

        image.display();
        System.out.println();
        image.display();
    }
}
