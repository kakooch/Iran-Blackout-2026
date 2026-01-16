package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;

/* loaded from: classes3.dex */
public final class N0 implements Runnable {
    public final /* synthetic */ AdRevenue a;
    public final /* synthetic */ C2601i1 b;

    public N0(C2601i1 c2601i1, AdRevenue adRevenue) {
        this.b = c2601i1;
        this.a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.b).reportAdRevenue(this.a);
    }
}
