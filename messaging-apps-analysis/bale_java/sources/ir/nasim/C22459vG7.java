package ir.nasim;

import ai.bale.proto.PresenceOuterClass$UpdateUserOnline;

/* renamed from: ir.nasim.vG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22459vG7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C21869uG7 a(PresenceOuterClass$UpdateUserOnline presenceOuterClass$UpdateUserOnline) {
        AbstractC13042fc3.i(presenceOuterClass$UpdateUserOnline, "proto");
        return new C21869uG7(presenceOuterClass$UpdateUserOnline.getUid(), EnumC24265yK1.b.a(presenceOuterClass$UpdateUserOnline.getDeviceTypeValue()), presenceOuterClass$UpdateUserOnline.hasDeviceCategory() ? presenceOuterClass$UpdateUserOnline.getDeviceCategory().getValue() : null);
    }
}
