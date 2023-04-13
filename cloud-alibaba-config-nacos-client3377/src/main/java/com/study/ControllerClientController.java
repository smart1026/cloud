package com.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月13日 22:05:48
 * @version:
 * @Description:
 */
@RestController
@RefreshScope //支持Nacos的动态刷新功能
@RequestMapping("/config")
public class ControllerClientController {


    @Value("${config.info}")  //在Nacos配置中心的配置文件内容
    private String configInfo;

    @GetMapping("/info")
    public String getConfigInfo(){
        return configInfo;
    }

}
