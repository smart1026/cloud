package com.study.spring.controller;

import com.study.spring.entities.CommonResult;
import com.study.spring.entities.Payment;
import com.study.spring.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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


    public static final String PAYMENT_URL = "http://localhost:8001";
    //public static final String PAYMENT_URL = "http://cloud-provider-service";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }

    @GetMapping(value = "/payment/getPaymentById")
    public CommonResult<Payment> getPaymentById(@RequestParam("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById?id="+id,CommonResult.class);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb",String.class);
    }


    @GetMapping(value = "/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin",String.class);
    }




}
