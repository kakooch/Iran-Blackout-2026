package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupExInfoChanged;
import ai.bale.proto.PeersStruct$ExInfo;

/* loaded from: classes5.dex */
public final class VD7 implements InterfaceC14123hO3 {
    private final C8187Ux a;

    public VD7(C8187Ux c8187Ux) {
        AbstractC13042fc3.i(c8187Ux, "apiExInfoMapper");
        this.a = c8187Ux;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UD7 a(GroupsOuterClass$UpdateGroupExInfoChanged groupsOuterClass$UpdateGroupExInfoChanged) {
        C7714Sx c7714SxA;
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupExInfoChanged, "input");
        int groupId = groupsOuterClass$UpdateGroupExInfoChanged.getGroupId();
        if (groupsOuterClass$UpdateGroupExInfoChanged.hasExInfo()) {
            C8187Ux c8187Ux = this.a;
            PeersStruct$ExInfo exInfo = groupsOuterClass$UpdateGroupExInfoChanged.getExInfo();
            AbstractC13042fc3.h(exInfo, "getExInfo(...)");
            c7714SxA = c8187Ux.a(exInfo);
        } else {
            c7714SxA = null;
        }
        return new UD7(groupId, c7714SxA);
    }
}
