package com.fly.cloud.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.fly.cloud.entity.ZztThroughBusiness;

public interface ZztThroughBusinessService {
	
	@GetMapping("/list")
	public List<ZztThroughBusiness> list();

}
