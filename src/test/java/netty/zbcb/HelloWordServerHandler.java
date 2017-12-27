package netty.zbcb;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.TooLongFrameException;

public class HelloWordServerHandler extends ChannelInboundHandlerAdapter {
	private int counter;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String body = (String) msg;
		System.out.println("server receive order : " + body + ";the counter is: " + ++counter);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		if(cause instanceof TooLongFrameException) {
			System.out.println("数据格式不符合数据报协议。");
			ctx.close();
		} else {
			super.exceptionCaught(ctx, cause);
		}
	}
}