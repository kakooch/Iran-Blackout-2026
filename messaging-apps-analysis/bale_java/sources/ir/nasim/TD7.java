package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupDefaultPermissionsChanged;
import ai.bale.proto.PeersStruct$GroupOutPeer;

/* loaded from: classes5.dex */
public final class TD7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SD7 a(GroupsOuterClass$UpdateGroupDefaultPermissionsChanged groupsOuterClass$UpdateGroupDefaultPermissionsChanged) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupDefaultPermissionsChanged, "input");
        C18732p92 c18732p92 = C18732p92.a;
        PeersStruct$GroupOutPeer group = groupsOuterClass$UpdateGroupDefaultPermissionsChanged.getGroup();
        AbstractC13042fc3.h(group, "getGroup(...)");
        C25238zy c25238zyQ1 = c18732p92.q1(group);
        DA daK0 = C18732p92.K0(groupsOuterClass$UpdateGroupDefaultPermissionsChanged.getPermissions());
        if (daK0 == null) {
            daK0 = new DA();
        }
        return new SD7(c25238zyQ1, daK0);
    }
}
