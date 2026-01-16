package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.MessageParamUpdateTimeObject;
import java.util.Set;

/* loaded from: classes3.dex */
public class MessageUpdateResult {
    public ChatType chatType;
    public Message message;
    public long message_id;
    public String object_guid;
    public long timestamp;
    public Set<MessageParamUpdateTimeObject.UpdateParameterEnum> updatedParametersForDatabase;

    public static MessageUpdateResult createFromMessageUpdateObject(MessageUpdateObject messageUpdateObject) {
        MessageUpdateResult messageUpdateResult = new MessageUpdateResult();
        messageUpdateResult.object_guid = messageUpdateObject.object_guid;
        messageUpdateResult.message_id = messageUpdateObject.message_id;
        messageUpdateResult.message = messageUpdateObject.message;
        messageUpdateResult.timestamp = messageUpdateObject.timestamp;
        messageUpdateResult.chatType = messageUpdateObject.type;
        return messageUpdateResult;
    }
}
