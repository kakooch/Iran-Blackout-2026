package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateChannelAdTagIdChanged;

/* loaded from: classes5.dex */
public final class VC7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UC7 a(GroupsOuterClass$UpdateChannelAdTagIdChanged groupsOuterClass$UpdateChannelAdTagIdChanged) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateChannelAdTagIdChanged, "proto");
        int groupId = groupsOuterClass$UpdateChannelAdTagIdChanged.getGroupId();
        String channelNativeAdTagId = groupsOuterClass$UpdateChannelAdTagIdChanged.getChannelNativeAdTagId();
        AbstractC13042fc3.h(channelNativeAdTagId, "getChannelNativeAdTagId(...)");
        String channelBannerAdTagId = groupsOuterClass$UpdateChannelAdTagIdChanged.getChannelBannerAdTagId();
        AbstractC13042fc3.h(channelBannerAdTagId, "getChannelBannerAdTagId(...)");
        return new UC7(groupId, channelNativeAdTagId, channelBannerAdTagId);
    }
}
