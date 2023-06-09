package com.study.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年03月30日 20:39:17
 * @version:
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderOpenFeginMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeginMain80.class,args);
    }

}
