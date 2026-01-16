package ir.nasim;

import ai.bale.proto.LahzeOuterClass$UpdateStartLive;

/* loaded from: classes5.dex */
public final class AF7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C24820zF7 a(LahzeOuterClass$UpdateStartLive lahzeOuterClass$UpdateStartLive) {
        AbstractC13042fc3.i(lahzeOuterClass$UpdateStartLive, "input");
        return new C24820zF7(lahzeOuterClass$UpdateStartLive.hasInfo() ? new SC3(lahzeOuterClass$UpdateStartLive.getInfo().getKey(), lahzeOuterClass$UpdateStartLive.getInfo().getGroupId(), lahzeOuterClass$UpdateStartLive.getInfo().getUserCount(), lahzeOuterClass$UpdateStartLive.getInfo().getIsLive(), lahzeOuterClass$UpdateStartLive.getInfo().getMainMessageId(), lahzeOuterClass$UpdateStartLive.getInfo().getMainMessageDate()) : null);
    }
}
