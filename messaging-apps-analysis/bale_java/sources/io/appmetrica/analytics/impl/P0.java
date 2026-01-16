package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;

/* loaded from: classes3.dex */
public final class P0 implements Runnable {
    public final /* synthetic */ DeferredDeeplinkParametersListener a;
    public final /* synthetic */ C2601i1 b;

    public P0(C2601i1 c2601i1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c2601i1;
        this.a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.getClass();
        C2719n0 c2719n0 = C2719n0.e;
        c2719n0.j().a(this.a);
    }
}
