package ir.nasim;

import ai.bale.proto.PresenceOuterClass$UpdateUserLastSeen;

/* renamed from: ir.nasim.jG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15255jG7 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C14657iG7 a(PresenceOuterClass$UpdateUserLastSeen presenceOuterClass$UpdateUserLastSeen) {
        AbstractC13042fc3.i(presenceOuterClass$UpdateUserLastSeen, "proto");
        return new C14657iG7(presenceOuterClass$UpdateUserLastSeen.getUid(), presenceOuterClass$UpdateUserLastSeen.getDate(), EnumC24265yK1.b.a(presenceOuterClass$UpdateUserLastSeen.getDeviceTypeValue()), presenceOuterClass$UpdateUserLastSeen.hasDeviceCategory() ? presenceOuterClass$UpdateUserLastSeen.getDeviceCategory().getValue() : null);
    }
}
