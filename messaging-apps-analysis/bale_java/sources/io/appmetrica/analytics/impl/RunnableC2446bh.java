package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.bh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2446bh implements Runnable {
    public final /* synthetic */ C2951wh a;

    public RunnableC2446bh(C2951wh c2951wh) {
        this.a = c2951wh;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.a;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).pauseSession();
    }
}
