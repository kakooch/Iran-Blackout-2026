package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class M0 implements Runnable {
    public final /* synthetic */ C2601i1 a;

    public M0(C2601i1 c2601i1) {
        this.a = c2601i1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.a).sendEventsBuffer();
    }
}
