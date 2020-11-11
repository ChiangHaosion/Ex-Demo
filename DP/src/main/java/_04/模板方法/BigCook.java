package _04.模板方法;

/**
 * @Author HaosionChiang
 * @Date 2020/10/17
 **/
public class BigCook extends BaseCook {
    @Override
    public void oil() {
        System.out.println("you2");

    }

    @Override
    public void eggs() {
        System.out.println("egg2");

    }

    @Override
    public void totamo() {
        System.out.println("t2");

    }
}
