package com.atguigu.spring.controller;

import com.atguigu.spring.entities.CommonResult;
import com.atguigu.spring.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年03月30日 20:42:58
 * @version:
 * @Description:
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {


    public static final String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }

    @GetMapping(value = "/payment/getPaymentById")
    public CommonResult<Payment> getPaymentById(@RequestParam("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById?id="+id,CommonResult.class);
    }





}
