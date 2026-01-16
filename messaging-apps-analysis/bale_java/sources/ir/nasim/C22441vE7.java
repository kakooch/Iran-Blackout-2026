package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupUserKickObsolete;

/* renamed from: ir.nasim.vE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22441vE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C21851uE7 a(GroupsOuterClass$UpdateGroupUserKickObsolete groupsOuterClass$UpdateGroupUserKickObsolete) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupUserKickObsolete, "input");
        return new C21851uE7(groupsOuterClass$UpdateGroupUserKickObsolete.getGroupId(), groupsOuterClass$UpdateGroupUserKickObsolete.getRid(), groupsOuterClass$UpdateGroupUserKickObsolete.getUid(), groupsOuterClass$UpdateGroupUserKickObsolete.getKickerUid(), groupsOuterClass$UpdateGroupUserKickObsolete.getDate());
    }
}
