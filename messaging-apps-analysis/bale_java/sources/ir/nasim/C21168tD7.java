package ir.nasim;

import ai.bale.proto.LahzeOuterClass$UpdateEndLive;

/* renamed from: ir.nasim.tD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21168tD7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C20565sD7 a(LahzeOuterClass$UpdateEndLive lahzeOuterClass$UpdateEndLive) {
        AbstractC13042fc3.i(lahzeOuterClass$UpdateEndLive, "input");
        return new C20565sD7(lahzeOuterClass$UpdateEndLive.hasInfo() ? new SC3(lahzeOuterClass$UpdateEndLive.getInfo().getKey(), lahzeOuterClass$UpdateEndLive.getInfo().getGroupId(), lahzeOuterClass$UpdateEndLive.getInfo().getUserCount(), lahzeOuterClass$UpdateEndLive.getInfo().getIsLive(), lahzeOuterClass$UpdateEndLive.getInfo().getMainMessageId(), lahzeOuterClass$UpdateEndLive.getInfo().getMainMessageDate()) : null);
    }
}
