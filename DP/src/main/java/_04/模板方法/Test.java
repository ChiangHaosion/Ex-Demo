package _04.模板方法;


/**
 * @Author HaosionChiang
 * @Date 2020/10/17
 *
 *
 *
 * 1 一次性实现一个算法的不变部分，并将可变的行为留给子类来实现。
 * 2 各子类中公共的行为应被提取出来并集中到一个公共父类中以避免代码重复。
 * 3 需要通过子类来决定父类算法中某个步骤是否执行，实现子类对父类的反向控制。
 *
 **/
public class Test {

    public static void main(String[] args) {
        MeCook meCook = new MeCook();

        meCook.setAdd(false);
        meCook.cooks();

        BaseCook bigCook = new BigCook();

        bigCook.cooks();
    }
}
