package _02.责任链模式.filter.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author HaosionChiang
 * @Date 2020/9/20
 **/
@Setter
@Getter
public class MyRequest {
    private Integer type;
    private String requestStr;
}
