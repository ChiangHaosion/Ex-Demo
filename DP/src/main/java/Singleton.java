/**
 * @Author HaosionChiang
 * @Date 2020/10/22
 *
 * 单例模式:  保证类只有一个实例/ 并提供唯一全局访问点
 **/
public class Singleton {
    private static volatile Singleton singleton=null;

    private Singleton(){}

    public synchronized Singleton getSingleton(){
        if (singleton!=null){
            return singleton;
        }

        synchronized (Singleton.class){
            if (singleton==null){
                singleton=new Singleton();
            }
        }

        return singleton;
    }

}
