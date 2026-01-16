package ir.nasim;

import ai.bale.proto.PresenceOuterClass$UpdateUserOffline;

/* renamed from: ir.nasim.tG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21195tG7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C20592sG7 a(PresenceOuterClass$UpdateUserOffline presenceOuterClass$UpdateUserOffline) {
        AbstractC13042fc3.i(presenceOuterClass$UpdateUserOffline, "proto");
        return new C20592sG7(presenceOuterClass$UpdateUserOffline.getUid(), EnumC24265yK1.b.a(presenceOuterClass$UpdateUserOffline.getDeviceTypeValue()), presenceOuterClass$UpdateUserOffline.hasDeviceCategory() ? presenceOuterClass$UpdateUserOffline.getDeviceCategory().getValue() : null);
    }
}
