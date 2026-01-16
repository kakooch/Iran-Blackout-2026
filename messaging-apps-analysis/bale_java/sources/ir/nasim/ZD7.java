package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupMemberAdminChanged;

/* loaded from: classes5.dex */
public final class ZD7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public YD7 a(GroupsOuterClass$UpdateGroupMemberAdminChanged groupsOuterClass$UpdateGroupMemberAdminChanged) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupMemberAdminChanged, "input");
        return new YD7(groupsOuterClass$UpdateGroupMemberAdminChanged.getGroupId(), groupsOuterClass$UpdateGroupMemberAdminChanged.getUserId(), groupsOuterClass$UpdateGroupMemberAdminChanged.getIsAdmin());
    }
}
