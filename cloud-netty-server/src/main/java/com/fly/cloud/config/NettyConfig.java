package com.fly.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

@Configuration
public class NettyConfig {
	
	@Bean
	ServerBootstrap serverBootstrap() {
		return new ServerBootstrap();
	}
	
	@Bean
	EventLoopGroup boss() {
		return new NioEventLoopGroup(1);
	}
	
	@Bean
	EventLoopGroup work() {
		return new NioEventLoopGroup();
	}
	
	@Bean
	ChannelGroup ChannelMap() {
		return new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	}
	
}
