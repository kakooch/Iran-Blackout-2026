package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* loaded from: classes3.dex */
public final class Kc extends SafeRunnable {
    public final /* synthetic */ Oc a;
    public final /* synthetic */ AdRevenue b;
    public final /* synthetic */ boolean c;

    public Kc(Oc oc, AdRevenue adRevenue, boolean z) {
        this.a = oc;
        this.b = adRevenue;
        this.c = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Oc.a(this.a).reportAdRevenue(this.b, this.c);
    }
}
