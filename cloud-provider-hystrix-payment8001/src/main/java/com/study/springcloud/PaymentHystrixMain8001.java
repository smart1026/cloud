package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年03月30日 18:56:39
 * @version: 1.0
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentHystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }

}
