package ir.nasim;

import ai.bale.proto.PresenceOuterClass$UpdateUserLastSeenUnknown;

/* renamed from: ir.nasim.lG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16437lG7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C15846kG7 a(PresenceOuterClass$UpdateUserLastSeenUnknown presenceOuterClass$UpdateUserLastSeenUnknown) {
        AbstractC13042fc3.i(presenceOuterClass$UpdateUserLastSeenUnknown, "proto");
        return new C15846kG7(presenceOuterClass$UpdateUserLastSeenUnknown.getUid(), EnumC24265yK1.b.a(presenceOuterClass$UpdateUserLastSeenUnknown.getDeviceTypeValue()), presenceOuterClass$UpdateUserLastSeenUnknown.hasDeviceCategory() ? presenceOuterClass$UpdateUserLastSeenUnknown.getDeviceCategory().getValue() : null, presenceOuterClass$UpdateUserLastSeenUnknown.hasDate() ? Long.valueOf(presenceOuterClass$UpdateUserLastSeenUnknown.getDate().getValue()) : null);
    }
}
