package _02.责任链模式.filter02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HaosionChiang
 * @Date 2020/9/20
 **/
public class MyFilterChain implements MyFilter{


    private List<MyFilter> filters=new ArrayList<>();


    int index =0;

    public MyFilterChain addFilter(MyFilter filter){
        filters.add(filter);
        return this;
    }


    @Override
    public boolean doFilter(UserInfo userInfo, LimitInfo limitInfo, MyFilterChain filterChain) {
        if (index<filters.size()){
          return filters.get(index++).doFilter(userInfo,limitInfo,filterChain);
        }
        return true;
    }
}
