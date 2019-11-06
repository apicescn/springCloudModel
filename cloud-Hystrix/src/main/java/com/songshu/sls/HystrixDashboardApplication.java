package com.songshu.sls;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 测试步骤:
 * 1. 访问http://localhost:8030/hystrix.stream 可以查看Dashboard
 * 2. 在上面的输入框填入: http://想监控的服务:端口/hystrix.stream进行测试
 * 注意：首先要先调用一下想监控的服务的API，否则将会显示一个空的图表.
 * 通过http://iPaddress:port/hystrix.stream即本例中为:http://localhost:8030/hystrix.stream
 * (参数:http://iPaddress:port/turbine.stream即本例中为:http://localhost:8030/turbine.stream,如为单个实例仪表监控可输入http://192.168.81.1:9001/ hystrix.stream)
 * 运行该方法之前应先调用http://192.168.81.1:9001/findUser/20001来调用一次.
 * 注意：上述步骤不能省略，因为如果应用的所有接口都未被调用，Turbine将只会看到一个ping，所以Turbine将会报连接不上。
 * @author Allen
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class HystrixDashboardApplication  {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixDashboardApplication.class).web(true).run(args);
    }
}