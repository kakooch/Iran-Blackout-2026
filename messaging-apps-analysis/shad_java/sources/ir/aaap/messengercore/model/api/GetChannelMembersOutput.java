package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.InChatMemberFromServer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetChannelMembersOutput {
    public boolean has_continue;
    public ArrayList<InChatMemberFromServer> in_chat_members;
    public String next_start_id;
    public long timestamp;
}
