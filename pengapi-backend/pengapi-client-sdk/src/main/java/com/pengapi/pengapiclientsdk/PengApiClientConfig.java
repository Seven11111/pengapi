package com.pengapi.pengapiclientsdk;

import com.pengapi.pengapiclientsdk.client.PengApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.Peng
 * @version 1.0
 * @description: TODO
 * @date 2024/1/28 12:11
 */
@Configuration
@ConfigurationProperties(prefix = "pengapi.client")
@Data
@ComponentScan
public class PengApiClientConfig {
    private String accessKey;
    private String secretKey;


    @Bean
    public PengApiClient pengApiClient() {
        return new PengApiClient(accessKey, secretKey);
    }
}
