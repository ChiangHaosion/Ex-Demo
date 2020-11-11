package _02.责任链模式.filter02;

/**
 * @Author HaosionChiang
 * @Date 2020/9/20
 **/
public class TestDemo {
    public static void main(String[] args) {

        // 获取用户信息
        UserInfo lucy = new UserInfo("001", "Lucy", 2);
        //获取消费限制信息
        LimitInfo s001 = new LimitInfo("S001", 5 , true);

        //构造过滤链
        MyFilterChain myFilterChain = new MyFilterChain();
        myFilterChain.addFilter(new SpecialUserFilter()).addFilter(new EatTimesFilter());

        boolean b = myFilterChain.doFilter(lucy, s001, myFilterChain);

        System.out.println("是否可以消费?"+b);

    }
}
