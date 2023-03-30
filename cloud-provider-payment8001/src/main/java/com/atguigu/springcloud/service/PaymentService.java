package com.atguigu.springcloud.service;


import com.atguigu.spring.entities.Payment;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年03月30日 19:11:45
 * @version:
 * @Description:
 */
public interface PaymentService {
    Integer create(Payment payment);

    Payment getPaymentById(Long id);
}
