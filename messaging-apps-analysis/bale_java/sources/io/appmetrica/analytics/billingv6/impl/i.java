package io.appmetrica.analytics.billingv6.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* loaded from: classes3.dex */
public final class i extends SafeRunnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ r b;

    public i(k kVar, r rVar) {
        this.a = kVar;
        this.b = rVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.a.f.a(this.b);
    }
}
