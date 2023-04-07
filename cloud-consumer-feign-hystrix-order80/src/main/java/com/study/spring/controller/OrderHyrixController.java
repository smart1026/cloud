package com.study.spring.controller;

import com.study.spring.entities.CommonResult;
import com.study.spring.entities.Payment;
import com.study.spring.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月06日 21:22:47
 * @version:
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/orderHystrixFeign")
public class OrderHyrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;



    @GetMapping(value = "/getPaymentById")
    public Object getPaymentById(@RequestParam("id") Long id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping(value = "/timeOut")
    public Object getPaymentTimeOut(@RequestParam("id") Long id){
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
}
