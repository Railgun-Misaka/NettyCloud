package com.fly.cloud.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.fly.cloud.entity.ZztThroughBusiness;
import com.fly.cloud.mapper.ZztThroughBusinessMapper;
import com.fly.cloud.service.ZztThroughBusinessService;

@RestController
public class ZztThroughBusinessServiceImpl implements ZztThroughBusinessService {
	
	@Autowired ZztThroughBusinessMapper mapper ;
	
	@Override
	public List<ZztThroughBusiness> list(){
		return mapper.list();
	}
	
}
