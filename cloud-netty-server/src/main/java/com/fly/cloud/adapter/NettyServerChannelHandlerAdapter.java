package com.fly.cloud.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;

@Component
public class NettyServerChannelHandlerAdapter extends ChannelHandlerAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NettyServerChannelHandlerAdapter.class);
	
	@Autowired ChannelGroup channelGroup ;
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		super.exceptionCaught(ctx, cause);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ctx.writeAndFlush("asdasd");
		super.channelRead(ctx, msg);
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		LOGGER.info("========================================");
		LOGGER.info("连接的客户端地址:" + ctx.channel().remoteAddress());
		LOGGER.info("连接的客户端ID:" + ctx.channel().id());
		LOGGER.info("========================================");
		channelGroup.add(ctx.channel());
		super.channelActive(ctx);
	}
	
}
