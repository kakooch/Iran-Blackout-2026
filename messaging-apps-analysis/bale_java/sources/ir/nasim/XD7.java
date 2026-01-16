package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupInviteObsolete;

/* loaded from: classes5.dex */
public final class XD7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public WD7 a(GroupsOuterClass$UpdateGroupInviteObsolete groupsOuterClass$UpdateGroupInviteObsolete) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupInviteObsolete, "input");
        return new WD7(groupsOuterClass$UpdateGroupInviteObsolete.getGroupId(), groupsOuterClass$UpdateGroupInviteObsolete.getRid(), groupsOuterClass$UpdateGroupInviteObsolete.getInviteUid(), groupsOuterClass$UpdateGroupInviteObsolete.getDate(), groupsOuterClass$UpdateGroupInviteObsolete.getSeq().getValue(), groupsOuterClass$UpdateGroupInviteObsolete.getIsJoined());
    }
}
