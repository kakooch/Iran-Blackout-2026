package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;

/* renamed from: io.appmetrica.analytics.impl.a5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2409a5 extends Z4 {
    public C2409a5(C2484d5 c2484d5) {
        super(c2484d5);
    }

    @Override // io.appmetrica.analytics.impl.Z4
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.Z4
    public final void c() {
        C2661ke c2661ke = this.a.c;
        try {
            Vj vj = new Vj(c2661ke, G2.g);
            Long lA = vj.c.a(Vj.d);
            if (lA != null) {
                vj.a(Vj.d, Long.valueOf(TimeUnit.SECONDS.toMillis(lA.longValue())));
            }
            Long lA2 = vj.c.a(Vj.e);
            if (lA2 != null) {
                vj.a(Vj.e, Long.valueOf(TimeUnit.SECONDS.toMillis(lA2.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            Vj vj2 = new Vj(c2661ke, C2439ba.g);
            Long lA3 = vj2.c.a(Vj.d);
            if (lA3 != null) {
                vj2.a(Vj.d, Long.valueOf(TimeUnit.SECONDS.toMillis(lA3.longValue())));
            }
            Long lA4 = vj2.c.a(Vj.e);
            if (lA4 != null) {
                vj2.a(Vj.e, Long.valueOf(TimeUnit.SECONDS.toMillis(lA4.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
