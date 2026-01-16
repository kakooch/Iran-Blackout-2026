package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;

/* renamed from: io.appmetrica.analytics.impl.fh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2545fh implements Runnable {
    public final /* synthetic */ AdRevenue a;
    public final /* synthetic */ C2951wh b;

    public RunnableC2545fh(C2951wh c2951wh, AdRevenue adRevenue) {
        this.b = c2951wh;
        this.a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.b;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).reportAdRevenue(this.a);
    }
}
