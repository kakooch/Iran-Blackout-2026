package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupUserInvitedObsolete;

/* renamed from: ir.nasim.tE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21177tE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C20574sE7 a(GroupsOuterClass$UpdateGroupUserInvitedObsolete groupsOuterClass$UpdateGroupUserInvitedObsolete) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupUserInvitedObsolete, "input");
        return new C20574sE7(groupsOuterClass$UpdateGroupUserInvitedObsolete.getGroupId(), groupsOuterClass$UpdateGroupUserInvitedObsolete.getRid(), groupsOuterClass$UpdateGroupUserInvitedObsolete.getUid(), groupsOuterClass$UpdateGroupUserInvitedObsolete.getInviterUid(), groupsOuterClass$UpdateGroupUserInvitedObsolete.getDate(), groupsOuterClass$UpdateGroupUserInvitedObsolete.getIsJoined());
    }
}
