package A_工厂方法.service;

import java.util.Map;

public interface IGoodsService {


    //发奖接口    实物,虚拟,第三方  都需要通过这个接口 发放


    void sendBonus(String uID, String gID, String  bizId, Map<String,String> exMap);


}
