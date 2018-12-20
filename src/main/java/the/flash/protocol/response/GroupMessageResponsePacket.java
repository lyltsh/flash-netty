package the.flash.protocol.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import the.flash.protocol.Packet;

import static the.flash.protocol.command.Command.GROUP_MESSAGE_RESPONSE;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/12/202:43 PM
 */
@Data
@NoArgsConstructor
public class GroupMessageResponsePacket extends Packet {
    private String fromUserId;
    private String fromUserName;
    private String message;

    public GroupMessageResponsePacket(String fromUserId, String fromUserName, String message) {
        this.fromUserId = fromUserId;
        this.fromUserName = fromUserName;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}
