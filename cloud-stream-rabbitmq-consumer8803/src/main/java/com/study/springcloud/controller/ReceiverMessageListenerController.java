package com.study.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月12日 22:15:32
 * @version:
 * @Description:
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiverMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者1号，接受："+message.getPayload()+"\t port:"+serverPort);
    }

}
