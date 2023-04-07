package com.study.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月06日 22:40:15
 * @version:
 * @Description:
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler" ,
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Long id) {
        int timeNumber = 5;
        int age=5/0;
        try {
            // 暂停5秒钟
            //TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" +
                "O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Long id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOutHandler,id:" + id + "\t" +
                "O(∩_∩)O超时提示";
    }


    //========服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback" ,commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //开启短路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //该属性用来没置在演动时间窗中，断路器熔断的最小请求数。例如，默认该值为10的时候，
            //如果燎动时间窗(默认10秒)内仅收到了9个请求，即使这9个请求都失败 了，断路器也不会打开
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //该属性用来没置当断路器打开之后的休眠时间窗。休眠时间窗结束之后, .
            //会将断路器置为“半开”状态，尝试熔断的请求命令，如果依然失败就将断路器继续设置为”打开”状态，
            //如果成功就设置为"关闭”状态。
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
            //该属性用来没置在演动时间窗中，表示在滚动时间窗中，在请求数量超过
            // circuitBreaker. requestVoLumeThreshold的情况下，如果错误请求数的百分比超过60,   失败率达到多少后跳闸
            // 就把断路器设置为 ”打开”状态，否则就设置为 "关闭”状态。
    })
    public String paymentCricuitBreaker(Long id){
            if (id<0){
                throw new RuntimeException("************id  不能负数");
            }
            String s = IdUtil.simpleUUID();// = UUID.randomUUID();

            return Thread.currentThread().getName() + "\t"+"调用成功,流水号: "+s;
    }


    public String paymentCircuitBreaker_fallback(@RequestParam("id") Long id){
        return "id 不能负数, 请稍后再试!!!!";
    }


}
