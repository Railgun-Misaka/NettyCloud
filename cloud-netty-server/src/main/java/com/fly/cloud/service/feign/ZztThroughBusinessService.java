package com.fly.cloud.service.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.fly.cloud.service.hystrix.ZztThroughBusinessServiceHystrix;

@FeignClient(value = "${eureka.application.names.data}", fallback = ZztThroughBusinessServiceHystrix.class)
public interface ZztThroughBusinessService extends com.fly.cloud.service.ZztThroughBusinessService {

}
