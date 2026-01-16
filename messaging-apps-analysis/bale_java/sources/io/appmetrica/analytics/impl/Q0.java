package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;

/* loaded from: classes3.dex */
public final class Q0 implements Runnable {
    public final /* synthetic */ DeferredDeeplinkListener a;
    public final /* synthetic */ C2601i1 b;

    public Q0(C2601i1 c2601i1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c2601i1;
        this.a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.getClass();
        C2719n0 c2719n0 = C2719n0.e;
        c2719n0.j().a(this.a);
    }
}
