package com.songshu.sls;

import com.songshu.sls.Filter.AccessFilter;
import org.apache.log4j.Logger;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 启动后访问样例地址http://ipaddress:port/api-client/findUser/200001
 * Created by Administrator on 2017/5/11.
 */

@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {

    private static Logger logger = Logger.getLogger(ZuulGatewayApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulGatewayApplication.class).web(true).run(args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}