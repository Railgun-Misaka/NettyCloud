package com.fly.cloud.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ZztThroughBusiness {
	
	private String business_id ;
	
	private Date create_time ;
	
	private String business_code ;

}
