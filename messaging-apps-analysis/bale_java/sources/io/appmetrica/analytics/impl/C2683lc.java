package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* renamed from: io.appmetrica.analytics.impl.lc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2683lc {
    public final Wl a;
    public final Wl b;
    public final C2962x4 c;
    public final PublicLogger d;
    public final String e;

    public C2683lc(String str, PublicLogger publicLogger) {
        this(new C2962x4(30), new Wl(50, str.concat("map key"), publicLogger), new Wl(4000, str.concat("map value"), publicLogger), str, publicLogger);
    }

    public C2683lc(C2962x4 c2962x4, Wl wl, Wl wl2, String str, PublicLogger publicLogger) {
        this.c = c2962x4;
        this.a = wl;
        this.b = wl2;
        this.e = str;
        this.d = publicLogger;
    }
}
