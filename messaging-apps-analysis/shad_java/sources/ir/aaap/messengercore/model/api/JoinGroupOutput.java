package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChatUpdateObject;
import ir.aaap.messengercore.model.GroupInfoFromServer;
import ir.aaap.messengercore.model.MessageUpdateObject;

/* loaded from: classes3.dex */
public class JoinGroupOutput {
    public ChatUpdateObject chat_update;
    public GroupInfoFromServer group;
    public boolean is_valid;
    public MessageUpdateObject message_update;
    public long timestamp;
}
