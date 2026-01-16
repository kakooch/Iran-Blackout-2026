package io.appmetrica.analytics.billingv6.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* loaded from: classes3.dex */
public final class n extends SafeRunnable {
    public final /* synthetic */ p a;
    public final /* synthetic */ k b;

    public n(p pVar, k kVar) {
        this.a = pVar;
        this.b = kVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.a.e.a(this.b);
    }
}
