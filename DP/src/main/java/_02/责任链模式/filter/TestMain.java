package _02.责任链模式.filter;

import _02.责任链模式.filter.filters.FilterChain;
import _02.责任链模式.filter.filters.HtmlFilter;
import _02.责任链模式.filter.filters.Numilter;
import _02.责任链模式.filter.filters.SensitiveFilter;
import _02.责任链模式.filter.model.MyRequest;
import _02.责任链模式.filter.model.MyResponse;

/**
 * @Author HaosionChiang
 * @Date 2020/9/20
 **/
public class TestMain {

    public static void main(String[] args) {
        //设定过滤
        String str="<My>,<Phone>,<APPLE>";
        MyRequest request = new MyRequest();
        request.setRequestStr(str);
        request.setType(1);
        MyResponse response = new MyResponse();
        response.setResponseStr("resp:  ");

        //设置拦截链条
        FilterChain filterChain = new FilterChain();

        //添加拦截器
        filterChain.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter()).addFilter(new Numilter());

        //应用规则
        filterChain.doFilter(request,response,filterChain);


        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }
}
