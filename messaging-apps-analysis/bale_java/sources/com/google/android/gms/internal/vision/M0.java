package com.google.android.gms.internal.vision;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
final class M0 {
    private static final M0 c = new M0();
    private final ConcurrentMap b = new ConcurrentHashMap();
    private final R0 a = new C2201v0();

    private M0() {
    }

    public static M0 a() {
        return c;
    }

    public final P0 b(Class cls) {
        AbstractC2184m0.f(cls, "messageType");
        P0 p0 = (P0) this.b.get(cls);
        if (p0 != null) {
            return p0;
        }
        P0 p0A = this.a.a(cls);
        AbstractC2184m0.f(cls, "messageType");
        AbstractC2184m0.f(p0A, "schema");
        P0 p02 = (P0) this.b.putIfAbsent(cls, p0A);
        return p02 != null ? p02 : p0A;
    }

    public final P0 c(Object obj) {
        return b(obj.getClass());
    }
}
