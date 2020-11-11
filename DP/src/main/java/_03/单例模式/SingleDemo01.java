package _03.单例模式;

/**
 * 单例模式  双重校验锁   DCL
 * @Author HaosionChiang
 * @Date 2020/9/21
 **/
public class SingleDemo01 {

    /**
     * 私有化构造器
     */
    private SingleDemo01(){
        System.out.println(Thread.currentThread().getName() + "  init construct");
    }

    /**
     * 单例实例   volatile 禁止指令重排/保证有序性
     */
    private static volatile SingleDemo01 instance=null;

    /**
     * 全局访问点
     * @return
     */
    public static SingleDemo01 getInstance(){
        //第一次校验
        if (instance==null){
            //加锁
            synchronized (SingleDemo01.class){
                //第二次校验
                if (instance==null){
                    instance=new SingleDemo01();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingleDemo01.getInstance();
            },Thread.currentThread().getName()+i).start();
        }
    }
}
