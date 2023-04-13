package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月13日 21:16:35
 * @version:
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9002 {


    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9002.class,args);
    }

}
