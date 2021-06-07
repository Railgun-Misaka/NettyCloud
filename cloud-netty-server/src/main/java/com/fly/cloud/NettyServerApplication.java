package com.fly.cloud;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class NettyServerApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(NettyServerApplication.class)
                .web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
                .run(args);
	}

}
