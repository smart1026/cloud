package study.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年03月30日 20:39:17
 * @version:
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class,args);
    }

}
