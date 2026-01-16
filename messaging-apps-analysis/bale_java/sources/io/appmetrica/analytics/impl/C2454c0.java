package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;

/* renamed from: io.appmetrica.analytics.impl.c0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2454c0 {
    public final HashMap a = new HashMap();

    public final synchronized C2429b0 a(W4 w4, PublicLogger publicLogger, C2661ke c2661ke) {
        C2429b0 c2429b0;
        c2429b0 = (C2429b0) this.a.get(w4.toString());
        if (c2429b0 == null) {
            C2404a0 c2404a0D = c2661ke.d();
            c2429b0 = new C2429b0(c2404a0D.a, c2404a0D.b, new C2811qk(publicLogger, "[App Environment]"));
            this.a.put(w4.toString(), c2429b0);
        }
        return c2429b0;
    }

    public final synchronized void a(C2404a0 c2404a0, C2661ke c2661ke) {
        c2661ke.a(c2404a0).b();
    }
}
