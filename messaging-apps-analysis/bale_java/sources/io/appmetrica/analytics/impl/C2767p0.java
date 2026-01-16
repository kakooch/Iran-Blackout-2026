package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* renamed from: io.appmetrica.analytics.impl.p0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2767p0 implements InterfaceC2540fc {
    public final /* synthetic */ C2814r0 a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public C2767p0(C2814r0 c2814r0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.a = c2814r0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2540fc
    public final Ub a() {
        C2814r0 c2814r0 = this.a;
        return c2814r0.g.b(this.b, this.c, c2814r0.i.f);
    }
}
