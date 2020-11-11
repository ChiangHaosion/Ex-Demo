package _01.代理模式.dproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author HaosionChiang
 * @Date 2020/6/15
 * 用来创建代理对象
 **/
public class ProxyHandler implements InvocationHandler {

    /**
     定义一个被代理对象
     */
    private Object target;

    /**
     * 返回动态代理对象   参数是被代理对象
     */
    public Object newProxyInstance(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     *
     * 这个方法就是生成的代理类中的方法被调用时会去自动调用的方法，可以看到在这个方法中调用了被代理对象的方法: method.invoke(targetObject, args);
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("记录日志");
        return method.invoke(target,args);
    }
}
