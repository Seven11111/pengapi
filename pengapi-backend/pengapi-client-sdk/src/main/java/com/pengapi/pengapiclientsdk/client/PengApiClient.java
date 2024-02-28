package com.pengapi.pengapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.pengapi.pengapiclientsdk.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.pengapi.pengapiclientsdk.utils.SignUtil.genSign;

/**
 * @author Mr.Peng
 * @version 1.0
 * @description: 调用第三方接口的客户端
 * @date 2024/1/27 15:45
 */

public class PengApiClient {

    private static final String GATEWAY_HOST = "http://localhost:8090";

    private String accessKey;

    private String secretKey;

    public PengApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/", paramMap);

        System.out.println(result);

        return result;
    }


    public String getNameByPost( String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/", paramMap);

        System.out.println(result);

        return result;
    }




    private Map<String,String> getHeaderMap(String body) {
        HashMap hashMap = new HashMap<String,String>();
        hashMap.put("accessKey",accessKey);
        // 不能直接发送
//        hashMap.put("secretKey",secretKey);
        hashMap.put("once", RandomUtil.randomNumbers(4));
        hashMap.put("body",body);
        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign",genSign(body,secretKey));

        return hashMap;
    }

    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse response = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(response.getStatus());

        String result = response.body();
        System.out.println(result);
        return "POST 用户的名字是 " + user.getUsername();
    }
}
