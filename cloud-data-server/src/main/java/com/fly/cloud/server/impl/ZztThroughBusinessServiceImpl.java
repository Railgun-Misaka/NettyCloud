package com.fly.cloud.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fly.cloud.entity.ZztThroughBusiness;
import com.fly.cloud.mapper.ZztThroughBusinessMapper;
import com.fly.cloud.server.ZztThroughBusinessService;

@Service
public class ZztThroughBusinessServiceImpl implements ZztThroughBusinessService {
	
	@Autowired ZztThroughBusinessMapper mapper ;
	
	@Override
	public List<ZztThroughBusiness> list(){
		return mapper.list();
	}
	
}
