package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.InChatMemberFromServer;

/* loaded from: classes3.dex */
public class InChatMember {
    public long count_common_groups;
    public String custom_title;
    public InChatMemberFromServer.JoinTypeEnum join_type;
    public long last_online;
    public String member_guid;
    public ChatType member_type;
    public OnlineTimeObject online_time;
    public String promoted_by_object_guid;
    public String removed_by_object_guid;
    public ChatType removed_by_object_type;
    public long timeStamp;
    public String username;

    public static InChatMember createFromServerObject(InChatMemberFromServer inChatMemberFromServer, long j) {
        InChatMember inChatMember = new InChatMember();
        inChatMember.member_type = inChatMemberFromServer.member_type;
        inChatMember.member_guid = inChatMemberFromServer.member_guid;
        inChatMember.custom_title = inChatMemberFromServer.custom_title;
        inChatMember.last_online = inChatMemberFromServer.last_online;
        inChatMember.online_time = inChatMemberFromServer.online_time;
        inChatMember.count_common_groups = inChatMemberFromServer.count_common_groups;
        inChatMember.join_type = inChatMemberFromServer.join_type;
        inChatMember.removed_by_object_guid = inChatMemberFromServer.removed_by_object_guid;
        inChatMember.promoted_by_object_guid = inChatMemberFromServer.promoted_by_object_guid;
        inChatMember.removed_by_object_type = inChatMemberFromServer.removed_by_object_type;
        inChatMember.username = inChatMemberFromServer.username;
        inChatMember.timeStamp = j;
        return inChatMember;
    }
}
