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
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok")
    String paymentInfo_OK(@RequestParam("id") Long id);

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout")
    String paymentInfo_TimeOut(@RequestParam("id") Long id);


}
