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
public class UserInfo {
    private String uid;
    private String name;
    private Integer currentEatTimes;
}
