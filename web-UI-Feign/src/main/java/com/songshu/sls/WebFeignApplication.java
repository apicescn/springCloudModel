package com.songshu.sls;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Administrator on 2017/5/11.
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableAutoConfiguration
public class WebFeignApplication {

    private static Logger logger = Logger.getLogger(WebFeignApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebFeignApplication.class, args);
    }
}