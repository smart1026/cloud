package com.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月13日 21:18:15
 * @version:
 * @Description:
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderNacosControlle {


    @Value("${service-url.nacos-user-service}")
    private String SERVER_URL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/payment/nacos")
    public String getPayment(@RequestParam("id") Integer id) {
        return restTemplate.getForObject(SERVER_URL+"/payment/nacos?id="+id, String.class);
    }

}
