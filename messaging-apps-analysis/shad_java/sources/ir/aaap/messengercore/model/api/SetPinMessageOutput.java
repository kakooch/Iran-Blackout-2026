package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChatUpdateObject;
import ir.aaap.messengercore.model.MessageUpdateObject;

/* loaded from: classes3.dex */
public class SetPinMessageOutput {
    public ChatUpdateObject chat_update;
    public MessageUpdateObject message_update;
    public Status status;

    public enum Status {
        OK,
        AnotherMessagePinned
    }
}
