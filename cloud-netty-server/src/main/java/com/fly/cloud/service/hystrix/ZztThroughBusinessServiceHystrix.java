package com.fly.cloud.service.hystrix;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fly.cloud.entity.ZztThroughBusiness;
import com.fly.cloud.service.feign.ZztThroughBusinessService;

@Component
public class ZztThroughBusinessServiceHystrix implements ZztThroughBusinessService {

	@Override
	public List<ZztThroughBusiness> list() {
		return null;
	}

}
