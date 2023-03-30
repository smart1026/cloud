package com.atguigu.springcloud.dao;

import com.atguigu.spring.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年03月30日 19:08:39
 * @version:
 * @Description:
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);

}
