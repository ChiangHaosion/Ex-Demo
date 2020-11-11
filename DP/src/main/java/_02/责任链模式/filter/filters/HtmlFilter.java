package _02.责任链模式.filter.filters;

import _02.责任链模式.filter.model.MyRequest;
import _02.责任链模式.filter.model.MyResponse;

/**
 * @Author HaosionChiang
 * @Date 2020/9/20
 **/
public class HtmlFilter implements Filter {

    @Override
    public void doFilter(MyRequest request, MyResponse response, FilterChain filterChain) {

        if (request.getType()==1){
            request.setRequestStr(request.getRequestStr().replace("<","{").replace(">","}")+"  htmlfilter");
        }else {
            return;
        }
        filterChain.doFilter(request, response,filterChain);
        response.setResponseStr(response.getResponseStr()+"  htmlfilter");
    }
}
