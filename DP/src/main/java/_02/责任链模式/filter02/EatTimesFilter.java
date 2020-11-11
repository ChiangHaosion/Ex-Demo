package _02.责任链模式.filter02;

import javafx.scene.control.Pagination;

/**
 * @Author HaosionChiang
 * @Date 2020/9/20
 **/
public class EatTimesFilter implements MyFilter {


    @Override
    public boolean doFilter(UserInfo userInfo, LimitInfo limitInfo, MyFilterChain filterChain) {

        if (eatTimesCanConsume(userInfo,limitInfo)){
           return filterChain.doFilter(userInfo,limitInfo,filterChain);
        }
        return false;
    }

    private boolean eatTimesCanConsume(UserInfo userInfo,LimitInfo limitInfo){
        //获取当前用户今日消费次数
        Integer currentEatTimes = userInfo.getCurrentEatTimes();
        //获取当前用户 每日限制次数
        Integer configEatTime = limitInfo.getConfigEatTime();
        if (currentEatTimes<configEatTime){
            return true;
        }
        return false;
    }
}
