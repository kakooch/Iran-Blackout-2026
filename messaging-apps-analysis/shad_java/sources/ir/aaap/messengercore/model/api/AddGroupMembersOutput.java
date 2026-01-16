package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChatUpdateObject;
import ir.aaap.messengercore.model.GroupInfoFromServer;
import ir.aaap.messengercore.model.InChatMemberFromServer;
import ir.aaap.messengercore.model.MessageUpdateObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AddGroupMembersOutput {
    public ArrayList<InChatMemberFromServer> added_in_chat_members;
    public ChatUpdateObject chat_update;
    public GroupInfoFromServer group;
    public MessageUpdateObject message_update;
    public long timestamp;
}
