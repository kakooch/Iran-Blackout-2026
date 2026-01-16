package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;

/* renamed from: io.appmetrica.analytics.impl.nh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2736nh implements Runnable {
    public final /* synthetic */ AdRevenue a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C2951wh c;

    public RunnableC2736nh(C2951wh c2951wh, AdRevenue adRevenue, boolean z) {
        this.c = c2951wh;
        this.a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.c;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).reportAdRevenue(this.a, this.b);
    }
}
