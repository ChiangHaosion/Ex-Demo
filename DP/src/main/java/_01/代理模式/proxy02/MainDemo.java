package _01.代理模式.proxy02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author HaosionChiang
 * @Date 2020/6/15
 **/
public class MainDemo {
    public static void main(String[] args) {
        //创建实例对象(被代理对象)
        AImage realImage = new RealImage("baidu.jpg");
        //创建InvocationHandler
        InvocationHandler imgHandler = new ProxyHandler<>(realImage);
        //创建代理对象imgProxy 代理realImage,代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        AImage imgProxy = (AImage) Proxy.newProxyInstance(AImage.class.getClassLoader(), new Class<?>[]{AImage.class}, imgHandler);
        //代理执行方法
        imgProxy.display();
    }
}
