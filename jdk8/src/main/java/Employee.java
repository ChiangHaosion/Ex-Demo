import lombok.*;

/**
 * @ClassName Employee
 * @Description: TODO
 * @Author HaosionChiang
 * @Date 2020/3/22
 * @Version V1.0
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {

    private String name;
    private int age;
    private double salary;
}
