package _02.责任链模式.filter.filters;

import _02.责任链模式.filter.model.MyRequest;
import _02.责任链模式.filter.model.MyResponse;

/**
 * @Author HaosionChiang
 * @Date 2020/9/20
 **/
public class Numilter implements Filter {
    @Override
    public void doFilter(MyRequest myRequest, MyResponse myResponse, FilterChain filterChain) {
        if (myRequest.getType()==2){
            myRequest.setRequestStr(myRequest.getRequestStr().replace("0","1")+"numfilter");
        }else {
            return;
        }
        filterChain.doFilter(myRequest,myResponse,filterChain);

        myResponse.setResponseStr(myResponse.getResponseStr()+"numfilter");
    }
}
