package study.spring.controller;

import com.study.spring.entities.CommonResult;
import com.study.spring.entities.Payment;
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


    //public static final String PAYMENT_URL = "http://localhost:2181";
    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;


    /**
     * http://localhost/consumer/payment/zk
     *
     * @return
     */
    @GetMapping("/payment/zk")
    public String paymentInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }






}
