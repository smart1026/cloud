package com.study.spring.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月06日 21:58:42
 * @version:
 * @Description:
 */
@Configuration
public class FeignConfig {


    /**
     * feignClient配置日志级别
     *
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        // 请求和响应的头信息,请求和响应的正文及元数据
        return Logger.Level.FULL;
    }


}
