package com.study.spring.service;

import org.springframework.stereotype.Component;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月07日 21:00:43
 * @version:  服务降级类
 * @Description:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Long id) {
        return "PaymentFallbackService Fallback paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Long id) {
        return "PaymentFallbackService Fallback paymentInfo_TimeOut";
    }
}
