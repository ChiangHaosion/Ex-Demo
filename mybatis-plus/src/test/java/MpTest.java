import com.ex.hao.MpApplication;
import com.ex.hao.entity.User;
import com.ex.hao.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName MpTest
 * @Description: TODO
 * @Author HaosionChiang
 * @Date 2020/3/15
 * @Version V1.0
 **/

@SpringBootTest(classes = MpApplication.class)
@RunWith(SpringRunner.class)
public class MpTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectOne(){
        User user = userMapper.selectById("1087982257332887553L");
        System.out.println(user);
    }
}
