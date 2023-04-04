package com.study.spring;

import com.study.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年03月30日 20:39:17
 * @version:
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-provider-service", configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }

}
