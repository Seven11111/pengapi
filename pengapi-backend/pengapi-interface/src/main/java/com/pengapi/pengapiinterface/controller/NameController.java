package com.pengapi.pengapiinterface.controller;

import com.pengapi.pengapiclientsdk.model.User;
import com.pengapi.pengapiclientsdk.utils.SignUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Mr.Peng
 * @version 1.0
 * @description: 名称API
 * @date 2024/1/27 15:30
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name) {
        return "GET Hello " + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "POST Hello " + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {


        String result = "POST 用户的名字是 " + user.getUsername();

        // 调用成功后次数加 +1

        return result;
    }
}
