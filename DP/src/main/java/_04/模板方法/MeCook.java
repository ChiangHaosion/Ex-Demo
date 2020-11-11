package _04.模板方法;

/**
 * @Author HaosionChiang
 * @Date 2020/10/17
 **/
public class MeCook extends BaseCook {

    private boolean add=true;

    public void setAdd(boolean a){
        add=a;
    }

    @Override
    public boolean isAddOil() {
        return this.add;
    }

    @Override
    public void oil() {
        System.out.println("you1");

    }

    @Override
    public void eggs() {
        System.out.println("egg1");

    }

    @Override
    public void totamo() {
        System.out.println("t1");

    }
}
