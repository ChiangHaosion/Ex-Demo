package _02.责任链模式.filter02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author HaosionChiang
 * @Date 2020/9/20
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LimitInfo {
    private String shopId;
    private Integer configEatTime;
    private Boolean muslin;
}
