package _02.责任链模式.filter.filters;

import _02.责任链模式.filter.model.MyRequest;
import _02.责任链模式.filter.model.MyResponse;

//定义的过滤敏感字眼的过滤规则
public class SensitiveFilter implements Filter {


    @Override
    public void doFilter(MyRequest request, MyResponse response, FilterChain chain) {
        String requestStr = request.getRequestStr();
        if (request.getType()==1){
            String replace = requestStr.replace("APPLE", "HUAWEI").replace(",", "&");
            request.setRequestStr(replace+"  sensitivefliter");
        }else {
            return;
        }
        chain.doFilter(request, response,chain);
        response.setResponseStr(response.getResponseStr()+"  sensitivefliter");
    }

}