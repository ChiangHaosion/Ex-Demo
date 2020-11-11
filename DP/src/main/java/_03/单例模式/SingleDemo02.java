package _03.单例模式;

/**
 *
 * 单例模式  静态内部类
 * @Author HaosionChiang
 * @Date 2020/10/22
 **/
public class SingleDemo02 {

    private SingleDemo02(){
        System.out.println("singleDemo02 is init");
    }



    private  static class SingleDemoHolder{
        private static SingleDemo02 singleDemo=new SingleDemo02();
    }

    public static SingleDemo02 getInstance(){
        return SingleDemoHolder.singleDemo;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingleDemo02.getInstance();
            },Thread.currentThread().getName()+i).start();
        }
    }

}
