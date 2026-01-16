package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateChannelAdvertisementTypeChanged;

/* loaded from: classes5.dex */
public final class XC7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public WC7 a(GroupsOuterClass$UpdateChannelAdvertisementTypeChanged groupsOuterClass$UpdateChannelAdvertisementTypeChanged) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateChannelAdvertisementTypeChanged, "proto");
        return new WC7(groupsOuterClass$UpdateChannelAdvertisementTypeChanged.getGroupId(), EnumC6364Nh.b.a(groupsOuterClass$UpdateChannelAdvertisementTypeChanged.getAdvertisementTypeValue()));
    }
}
