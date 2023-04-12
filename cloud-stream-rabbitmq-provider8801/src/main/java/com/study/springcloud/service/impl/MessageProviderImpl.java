package com.study.springcloud.service.impl;

import com.study.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月12日 21:23:52
 * @version:
 * @Description:
 */
@Slf4j
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {


    @Resource(name = "output")
    private MessageChannel messageChannel; // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(serial).build());
        log.info("随机数：" + serial);
        return serial;
    }
}

