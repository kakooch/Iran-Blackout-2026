package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;

/* loaded from: classes3.dex */
public final class L0 implements Runnable {
    public final /* synthetic */ Revenue a;
    public final /* synthetic */ C2601i1 b;

    public L0(C2601i1 c2601i1, Revenue revenue) {
        this.b = c2601i1;
        this.a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.b).reportRevenue(this.a);
    }
}
