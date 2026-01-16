package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.GroupInfoFromServer;
import ir.aaap.messengercore.model.InChatMemberFromServer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GroupPreviewByJoinLinkOutput {
    public GroupInfoFromServer group;
    public boolean has_joined;
    public boolean is_valid;
    public long timestamp;
    public ArrayList<InChatMemberFromServer> top_participants = new ArrayList<>();
}
