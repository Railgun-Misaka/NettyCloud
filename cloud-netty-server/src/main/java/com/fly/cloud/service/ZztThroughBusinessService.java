package com.fly.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("CLOUD-DATA-SERVICE")
public interface ZztThroughBusinessService {

}
