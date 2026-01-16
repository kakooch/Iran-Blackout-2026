package io.appmetrica.analytics.billingv6.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* loaded from: classes3.dex */
public final class b extends SafeRunnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ p b;

    public b(d dVar, p pVar) {
        this.a = dVar;
        this.b = pVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.a.d.a(this.b);
    }
}
