package com.fly.cloud.adapter;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.group.ChannelGroup;
import lombok.extern.slf4j.Slf4j;

import com.fly.cloud.service.feign.ZztThroughBusinessService;

@Component
@Slf4j
@Sharable
public class NettyServerChannelHandlerAdapter extends ChannelHandlerAdapter {
	
	@Autowired ChannelGroup channelGroup ;
	
	@Resource ZztThroughBusinessService ZztThroughBusinessService;
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		super.exceptionCaught(ctx, cause);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ctx.writeAndFlush("asdasd");
		System.out.println("------------------------------");
		System.out.println(ZztThroughBusinessService.list());
		System.out.println("------------------------------");
		super.channelRead(ctx, msg);
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		log.info("========================================");
		log.info("连接的客户端地址:" + ctx.channel().remoteAddress());
		log.info("连接的客户端ID:" + ctx.channel().id());
		log.info("========================================");
		channelGroup.add(ctx.channel());
		super.channelActive(ctx);
	}
	
}
