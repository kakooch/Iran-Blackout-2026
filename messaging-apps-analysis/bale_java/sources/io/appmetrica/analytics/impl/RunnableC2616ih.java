package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.ih, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2616ih implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ C2951wh b;

    public RunnableC2616ih(C2951wh c2951wh, boolean z) {
        this.b = c2951wh;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.b;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).setDataSendingEnabled(this.a);
    }
}
