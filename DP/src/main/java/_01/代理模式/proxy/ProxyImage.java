package _01.代理模式.proxy;

/**
 * @Author HaosionChiang
 * @Date 2020/6/15
 * 代理类
 **/
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
