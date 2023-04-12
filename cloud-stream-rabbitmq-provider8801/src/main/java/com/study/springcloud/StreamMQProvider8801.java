package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年03月30日 18:56:39
 * @version: 1.0
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StreamMQProvider8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMQProvider8801.class,args);
    }

}
