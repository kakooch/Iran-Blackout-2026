package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Zg implements Runnable {
    public final /* synthetic */ Throwable a;
    public final /* synthetic */ C2951wh b;

    public Zg(C2951wh c2951wh, Throwable th) {
        this.b = c2951wh;
        this.a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.b;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).reportUnhandledException(this.a);
    }
}
