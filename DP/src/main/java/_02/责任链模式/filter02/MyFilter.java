package _02.责任链模式.filter02;


/**
 * @author HaosionChiang
 * @since  2020-09-20
 */
public interface MyFilter {

    /**
     * 判断是否可以消费
     * @param uId
     * @param shopId
     * @param filterChain
     * @return
     */
    boolean doFilter(UserInfo userInfo,LimitInfo limitInfo,MyFilterChain filterChain);
}
