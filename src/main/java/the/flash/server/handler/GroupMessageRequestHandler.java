package the.flash.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import the.flash.protocol.request.GroupMessageRequestPacket;
import the.flash.protocol.response.GroupMessageResponsePacket;
import the.flash.session.Session;
import the.flash.util.SessionUtil;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/12/202:51 PM
 */
public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequestPacket groupMessageRequestPacket) throws Exception {
        Session userSession = SessionUtil.getSession(ctx.channel());
        String groupId = groupMessageRequestPacket.getToGroupId();
        String message = groupMessageRequestPacket.getMessage();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        if (!channelGroup.contains(ctx.channel())) {
            System.out.println("群里没有该用户: " + userSession.getUserName() + ",groupId: " + groupId);
            return;
        }

        GroupMessageResponsePacket groupMessageResponsePacket = new GroupMessageResponsePacket(
                userSession.getUserId(), userSession.getUserName(), message);

        for (Channel channel : channelGroup) {
            if (channel != null && channel.isActive()) {
                System.out.println("发送消息给:" + SessionUtil.getSession(channel).getUserName());
                channel.writeAndFlush(groupMessageResponsePacket);
            }
        }
    }
}
