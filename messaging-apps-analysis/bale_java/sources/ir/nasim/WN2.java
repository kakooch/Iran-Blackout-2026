package ir.nasim;

import ai.bale.proto.CollectionsStruct$MapValue;
import ai.bale.proto.CollectionsStruct$MapValueItem;
import ai.bale.proto.GroupsStruct$Group;
import java.util.List;

/* loaded from: classes5.dex */
public final class WN2 implements InterfaceC14123hO3 {
    private final C10897cO2 a;

    public WN2(C10897cO2 c10897cO2) {
        AbstractC13042fc3.i(c10897cO2, "groupTypeMapper");
        this.a = c10897cO2;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C14697iL2 a(GroupsStruct$Group groupsStruct$Group) {
        List<CollectionsStruct$MapValueItem> listM;
        AbstractC13042fc3.i(groupsStruct$Group, "input");
        int id = groupsStruct$Group.getId();
        long accessHash = groupsStruct$Group.getAccessHash();
        String title = groupsStruct$Group.getTitle();
        C6984Pv c6984PvR = C18732p92.R(groupsStruct$Group.getAvatar());
        Integer numValueOf = Integer.valueOf(groupsStruct$Group.getMembersCount().getValue());
        Boolean boolValueOf = Boolean.valueOf(groupsStruct$Group.getIsMember().getValue());
        Boolean boolValueOf2 = Boolean.valueOf(groupsStruct$Group.getIsHidden().getValue());
        C10897cO2 c10897cO2 = this.a;
        EnumC24932zS2 groupType = groupsStruct$Group.getGroupType();
        AbstractC13042fc3.h(groupType, "getGroupType(...)");
        EnumC3690By enumC3690ByA = c10897cO2.a(groupType);
        Boolean boolValueOf3 = Boolean.valueOf(groupsStruct$Group.getCanSendMessage().getValue());
        CollectionsStruct$MapValue ext = groupsStruct$Group.getExt();
        if (ext == null || (listM = ext.getItemsList()) == null) {
            listM = AbstractC10360bX0.m();
        }
        return new C14697iL2(new C23464wy(id, accessHash, title, c6984PvR, numValueOf, boolValueOf, boolValueOf2, enumC3690ByA, boolValueOf3, new C19811qz(C18732p92.y0(listM)), groupsStruct$Group.getNick().getValue(), Boolean.valueOf(groupsStruct$Group.getBecameOrphaned().getValue()), Long.valueOf(groupsStruct$Group.getStateVersion().getValue()), C18732p92.K0(groupsStruct$Group.getPermissions()), C18732p92.K0(groupsStruct$Group.getDefaultPermissions()), Integer.valueOf(groupsStruct$Group.getOwnerUid().getValue()), groupsStruct$Group.getAvailableReactionsList(), Boolean.valueOf(groupsStruct$Group.getIsSuspend().getValue()), Integer.valueOf(groupsStruct$Group.getLinkedGroupPeerId().getValue()), Boolean.valueOf(groupsStruct$Group.getDiscussionGroupEnabled().getValue())), null);
    }
}
