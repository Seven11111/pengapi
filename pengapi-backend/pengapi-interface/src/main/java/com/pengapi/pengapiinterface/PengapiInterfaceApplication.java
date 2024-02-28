package com.pengapi.pengapiinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pengapi")
public class PengapiInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PengapiInterfaceApplication.class, args);
    }

}
