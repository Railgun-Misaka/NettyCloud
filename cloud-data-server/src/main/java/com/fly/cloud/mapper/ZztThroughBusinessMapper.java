package com.fly.cloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.fly.cloud.entity.ZztThroughBusiness;

@Mapper
public interface ZztThroughBusinessMapper {
	
	@Select("select * from zzt_through_business")
	public List<ZztThroughBusiness> list();
	
}
