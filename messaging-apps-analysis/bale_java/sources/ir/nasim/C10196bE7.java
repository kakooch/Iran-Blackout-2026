package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupMemberPermissionsChanged;

/* renamed from: ir.nasim.bE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10196bE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C9602aE7 a(GroupsOuterClass$UpdateGroupMemberPermissionsChanged groupsOuterClass$UpdateGroupMemberPermissionsChanged) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupMemberPermissionsChanged, "input");
        int groupId = groupsOuterClass$UpdateGroupMemberPermissionsChanged.getGroupId();
        DA daK0 = C18732p92.K0(groupsOuterClass$UpdateGroupMemberPermissionsChanged.getPermissions());
        if (daK0 == null) {
            daK0 = new DA();
        }
        return new C9602aE7(groupId, daK0, groupsOuterClass$UpdateGroupMemberPermissionsChanged.getUid());
    }
}
