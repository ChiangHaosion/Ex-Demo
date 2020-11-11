package _02.责任链模式.filter.filters;

import _02.责任链模式.filter.model.MyRequest;
import _02.责任链模式.filter.model.MyResponse;

/**
 * @author HaosionChiang
 */
public interface Filter {
    void doFilter(MyRequest myRequest, MyResponse myResponse, FilterChain filterChain);
}
