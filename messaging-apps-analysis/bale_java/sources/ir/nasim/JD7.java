package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupAboutChangedObsolete;

/* loaded from: classes5.dex */
public final class JD7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ID7 a(GroupsOuterClass$UpdateGroupAboutChangedObsolete groupsOuterClass$UpdateGroupAboutChangedObsolete) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupAboutChangedObsolete, "input");
        return new ID7(groupsOuterClass$UpdateGroupAboutChangedObsolete.getGroupId(), groupsOuterClass$UpdateGroupAboutChangedObsolete.hasAbout() ? groupsOuterClass$UpdateGroupAboutChangedObsolete.getAbout().getValue() : null);
    }
}
