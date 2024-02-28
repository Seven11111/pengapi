package com.pengapi.pengapiinterface;

import com.pengapi.pengapiclientsdk.client.PengApiClient;
import com.pengapi.pengapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class PengapiInterfaceApplicationTests {

    @Resource
    private PengApiClient pengApiClient;

    @Test
    void contextLoads() {
//        PengApiClient pengApiClient = new PengApiClient("pzh", "abcdefjh");
        System.out.println(pengApiClient);
        String result1 = pengApiClient.getNameByGet("pzh");
        String result2 = pengApiClient.getNameByPost("pzh");
        User user = new User();
        user.setUsername("pzh");

        String result3 = pengApiClient.getUsernameByPost(user);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

}
