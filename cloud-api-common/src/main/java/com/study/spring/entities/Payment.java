package com.study.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年03月30日 19:04:14
 * @version: 1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    /**
     * 主键
     */
    private Long id;
    /**
     * 支付流水号
     */
    private String serial;

}
