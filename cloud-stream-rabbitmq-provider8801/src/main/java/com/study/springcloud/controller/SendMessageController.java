package com.study.springcloud.controller;

import com.study.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月12日 21:25:12
 * @version:
 * @Description:
 */
@RestController
@RequestMapping("/send")
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage()
    {
        return messageProvider.send();
    }

}
