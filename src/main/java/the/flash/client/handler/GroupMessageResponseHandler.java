package the.flash.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import the.flash.protocol.response.GroupMessageResponsePacket;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/12/202:42 PM
 */
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket groupMessageResponsePacket) throws Exception {
        String fromUserId = groupMessageResponsePacket.getFromUserId();
        String fromUserName = groupMessageResponsePacket.getFromUserName();
        System.out.println("群发消息:" + fromUserId + ":" + fromUserName + " -> " + groupMessageResponsePacket
                .getMessage());
    }
}
