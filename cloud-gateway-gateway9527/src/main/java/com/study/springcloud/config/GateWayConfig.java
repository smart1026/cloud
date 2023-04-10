package com.study.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月10日 20:56:18
 * @version:
 * @Description:
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("paymentB",r -> r.path("/tieba").uri("https://tieba.baidu.com/index.html")).build();
        return routes.build();

    }

}
