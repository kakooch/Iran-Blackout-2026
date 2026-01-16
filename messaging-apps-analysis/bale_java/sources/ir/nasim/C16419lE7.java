package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupOwnerChanged;

/* renamed from: ir.nasim.lE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16419lE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C15828kE7 a(GroupsOuterClass$UpdateGroupOwnerChanged groupsOuterClass$UpdateGroupOwnerChanged) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupOwnerChanged, "input");
        return new C15828kE7(groupsOuterClass$UpdateGroupOwnerChanged.getGroupId(), groupsOuterClass$UpdateGroupOwnerChanged.getUserId());
    }
}
