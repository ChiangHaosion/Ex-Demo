package _02.责任链模式.filter02;


/**
 * @Author HaosionChiang
 * @Date 2020/9/20
 **/
public class SpecialUserFilter implements MyFilter {


    @Override
    public boolean doFilter(UserInfo userInfo, LimitInfo limitInfo, MyFilterChain filterChain) {

        boolean can=findConsumeConfig(userInfo,limitInfo);

        //满足,继续执行下一个过滤; 否则停止
        if (can){
           return filterChain.doFilter(userInfo,limitInfo,filterChain);
        }
        return false;
    }

    private boolean findConsumeConfig(UserInfo userInfo, LimitInfo limitInfo){
        return "001".equals(userInfo.getUid()) && "S001".equals(limitInfo.getShopId());
    }

}
