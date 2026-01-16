package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupMembersCountChanged;

/* renamed from: ir.nasim.dE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11576dE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C10812cE7 a(GroupsOuterClass$UpdateGroupMembersCountChanged groupsOuterClass$UpdateGroupMembersCountChanged) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupMembersCountChanged, "input");
        return new C10812cE7(groupsOuterClass$UpdateGroupMembersCountChanged.getGroupId(), groupsOuterClass$UpdateGroupMembersCountChanged.getMembersCount());
    }
}
