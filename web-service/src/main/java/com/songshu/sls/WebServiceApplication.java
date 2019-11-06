package com.songshu.sls;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2017/5/11.
 */

@SpringBootApplication
@EnableEurekaClient
//自动加载配置MyBatis及其他应用配置属性
@EnableAutoConfiguration
public class WebServiceApplication {

    private static Logger logger = Logger.getLogger(WebServiceApplication.class);

    public static void main(String[] args) {
//        new SpringApplicationBuilder(WebServiceApplication.class).web(true).run(args);
        SpringApplication.run(WebServiceApplication.class, args);
    }

}