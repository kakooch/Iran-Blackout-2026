package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;

/* renamed from: io.appmetrica.analytics.impl.eh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2521eh implements Runnable {
    public final /* synthetic */ Revenue a;
    public final /* synthetic */ C2951wh b;

    public RunnableC2521eh(C2951wh c2951wh, Revenue revenue) {
        this.b = c2951wh;
        this.a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.b;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).reportRevenue(this.a);
    }
}
