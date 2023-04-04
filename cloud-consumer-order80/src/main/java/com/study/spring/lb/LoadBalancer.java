package com.study.spring.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: 蔡佳兴
 * @createTime: 2023年04月04日 19:56:41
 * @version:
 * @Description:
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
