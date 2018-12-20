package the.flash.client.console;

import io.netty.channel.Channel;
import the.flash.protocol.request.GroupMessageRequestPacket;

import java.util.Scanner;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/12/202:36 PM
 */
public class SendGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个群：");
        String toGroupId = scanner.next();
        String message = scanner.next();

        channel.writeAndFlush(new GroupMessageRequestPacket(toGroupId, message));
    }
}
