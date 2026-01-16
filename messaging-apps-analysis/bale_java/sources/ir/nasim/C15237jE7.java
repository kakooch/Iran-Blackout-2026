package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupNicknameChanged;

/* renamed from: ir.nasim.jE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15237jE7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C14639iE7 a(GroupsOuterClass$UpdateGroupNicknameChanged groupsOuterClass$UpdateGroupNicknameChanged) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupNicknameChanged, "input");
        return new C14639iE7(groupsOuterClass$UpdateGroupNicknameChanged.getGroupId(), groupsOuterClass$UpdateGroupNicknameChanged.getRid(), groupsOuterClass$UpdateGroupNicknameChanged.getUid(), groupsOuterClass$UpdateGroupNicknameChanged.hasNick() ? groupsOuterClass$UpdateGroupNicknameChanged.getNick().getValue() : null, groupsOuterClass$UpdateGroupNicknameChanged.getDate());
    }
}
