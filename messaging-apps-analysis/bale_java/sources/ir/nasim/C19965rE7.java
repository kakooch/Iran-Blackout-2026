package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupTitleChangedObsolete;

/* renamed from: ir.nasim.rE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19965rE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C19374qE7 a(GroupsOuterClass$UpdateGroupTitleChangedObsolete groupsOuterClass$UpdateGroupTitleChangedObsolete) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupTitleChangedObsolete, "input");
        int groupId = groupsOuterClass$UpdateGroupTitleChangedObsolete.getGroupId();
        long rid = groupsOuterClass$UpdateGroupTitleChangedObsolete.getRid();
        int uid = groupsOuterClass$UpdateGroupTitleChangedObsolete.getUid();
        String title = groupsOuterClass$UpdateGroupTitleChangedObsolete.getTitle();
        AbstractC13042fc3.h(title, "getTitle(...)");
        return new C19374qE7(groupId, rid, uid, title, groupsOuterClass$UpdateGroupTitleChangedObsolete.getDate());
    }
}
