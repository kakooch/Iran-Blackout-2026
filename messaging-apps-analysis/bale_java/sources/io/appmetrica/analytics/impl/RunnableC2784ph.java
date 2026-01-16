package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.ph, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2784ph implements Runnable {
    public final /* synthetic */ T a;
    public final /* synthetic */ C2951wh b;

    public RunnableC2784ph(C2951wh c2951wh, T t) {
        this.b = c2951wh;
        this.a = t;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.b;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).a(this.a);
    }
}
