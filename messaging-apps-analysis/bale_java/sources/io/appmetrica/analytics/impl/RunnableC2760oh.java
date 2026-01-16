package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.oh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2760oh implements Runnable {
    public final /* synthetic */ Mm a;
    public final /* synthetic */ C2951wh b;

    public RunnableC2760oh(C2951wh c2951wh, Mm mm) {
        this.b = c2951wh;
        this.a = mm;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.b;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).a(this.a);
    }
}
