import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Objects;

/**
 * @ClassName TestOkHttp
 * @Description: TODO
 * @Author HaosionChiang
 * @Date 2020/3/27
 * @Version V1.0
 **/
@SpringBootTest(classes = TestOkHttp.class)
public class TestOkHttp {


    private static final String BASE_URL = "http://10.46.30.49:60002";

    /**
     * OkHttp使用
     * 使用OkHttp发送请求主要分为以下几步骤：
     * 1创建OkHttpClient对象
     * 2创建Request对象
     * 3将Request 对象封装为Call
     * 4通过Call 来执行同步或异步请求，调用execute方法同步执行，调用enqueue方法异步执行
     */
    @Test
    public void testGet() throws IOException {
        OkHttpClient client = new OkHttpClient();

        String api = "/api/home/v1/hotelBrand";
        String url = String.format("%s%s", BASE_URL, api);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        final Call call = client.newCall(request);
        Response response = null;
            response = call.execute();
            System.out.println(Objects.requireNonNull(response.body()).string());
    }
    @Test
    public void testPost() throws IOException{
        OkHttpClient client = new OkHttpClient();
        String api = "/api/home/v1/brandStory";
        String url = String.format("%s%s", BASE_URL, api);
        //请求参数
        JSONObject json = new JSONObject();
        json.put("appInfo",new AppBaseInfo("Native-iOS","3.12.0",""));
        json.put("pageParam", new PageParam(2,2));
        RequestBody requestBody = RequestBody.create(JSON.toJSONString(json), MediaType.parse("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody) //post请求
                .build();
        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(Objects.requireNonNull(response.body()).string());
    }

    public static final MediaType JSON_TYPE = MediaType.get("application/json; charset=utf-8");
    @Test
    public void testPost2() throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create("json", JSON_TYPE);

        Request request = new Request.Builder()
                .url("http://www.xx.xx")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(Objects.requireNonNull(response.body()).string());
        }
    }
}
