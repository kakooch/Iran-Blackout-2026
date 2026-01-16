package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupUserLeaveObsolete;

/* renamed from: ir.nasim.xE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23627xE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C23037wE7 a(GroupsOuterClass$UpdateGroupUserLeaveObsolete groupsOuterClass$UpdateGroupUserLeaveObsolete) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupUserLeaveObsolete, "input");
        return new C23037wE7(groupsOuterClass$UpdateGroupUserLeaveObsolete.getGroupId(), groupsOuterClass$UpdateGroupUserLeaveObsolete.getRid(), groupsOuterClass$UpdateGroupUserLeaveObsolete.getUid(), groupsOuterClass$UpdateGroupUserLeaveObsolete.getDate());
    }
}
