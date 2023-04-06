package com.study.springcloud.controller;

import com.study.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月06日 22:41:11
 * @version:
 * @Description:
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/hystrix/ok")
    public String paymentInfo_OK(@RequestParam("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("*****result:" + result);
        return result;
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/hystrix/timeout")
    public String paymentInfo_TimeOut(@RequestParam("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*****result:" + result);
        return result;

    }


}
