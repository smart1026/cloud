package com.study.spring.service;

import com.study.spring.entities.CommonResult;
import com.study.spring.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月06日 21:16:01
 * @version:
 * @Description:
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/getPaymentById")
    CommonResult<Payment> getPaymentById(@RequestParam("id") Long id);

    @GetMapping(value = "/payment/feign/timeOut")
    String getPaymentTimeOut();

}
