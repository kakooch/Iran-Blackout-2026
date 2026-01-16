package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChatUpdateObject;
import ir.aaap.messengercore.model.MessageUpdateObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SendMessageOutput {
    public ChatUpdateObject chat_update;
    public MessageUpdateObject message_update;
    public ArrayList<MessageUpdateObject> message_updates;
    public SendMessageStatus status;

    public enum SendMessageStatus {
        OK,
        Repeated,
        InvalidFile
    }
}
