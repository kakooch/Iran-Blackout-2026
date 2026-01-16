package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupAvatarChangedObsolete;

/* loaded from: classes5.dex */
public final class LD7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public KD7 a(GroupsOuterClass$UpdateGroupAvatarChangedObsolete groupsOuterClass$UpdateGroupAvatarChangedObsolete) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupAvatarChangedObsolete, "input");
        return new KD7(groupsOuterClass$UpdateGroupAvatarChangedObsolete.getGroupId(), groupsOuterClass$UpdateGroupAvatarChangedObsolete.getRid(), groupsOuterClass$UpdateGroupAvatarChangedObsolete.getUid(), C18732p92.R(groupsOuterClass$UpdateGroupAvatarChangedObsolete.hasAvatar() ? groupsOuterClass$UpdateGroupAvatarChangedObsolete.getAvatar() : null), groupsOuterClass$UpdateGroupAvatarChangedObsolete.getDate());
    }
}
