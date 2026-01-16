package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChannelInfoFromServer;
import ir.aaap.messengercore.model.InChatMemberFromServer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AddChannelMembersOutput {
    public ArrayList<InChatMemberFromServer> added_in_chat_members;
    public ChannelInfoFromServer channel;
    public long timestamp;
}
