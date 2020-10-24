package com.fly.cloud.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.CharsetUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fly.cloud.adapter.NettyServerChannelHandlerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class NettyServer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NettyServer.class);
    
	@Autowired private ServerBootstrap serverBootstrap ;
    
    @Autowired private EventLoopGroup boss ;
    
    @Autowired private EventLoopGroup work ;
    
    @Autowired private NettyServerChannelHandlerAdapter channelHandlerAdapter;
    
    @Value("${netty.server.port}") int PORT ;
    
    @PreDestroy
    public void close() {
        LOGGER.info("关闭服务器....");
        boss.shutdownGracefully();
        work.shutdownGracefully();
    }
    
    @PostConstruct
    public void start() {
        serverBootstrap.group(boss, work)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
                //设置事件处理
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {

					@Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
                        pipeline.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
                        pipeline.addLast(channelHandlerAdapter);
                    }
                });
        try {
            LOGGER.info("netty服务器在[{}]端口启动监听", PORT);
            ChannelFuture f = serverBootstrap.bind(PORT).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            LOGGER.info("[出现异常] 释放资源");
            close();
        }
    }
}
