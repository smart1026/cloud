package com.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月13日 21:18:15
 * @version:
 * @Description:
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/nacos")
    public String getPayment(@RequestParam("id") Integer id) {
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }

}
