package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Xg implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C2951wh c;

    public Xg(C2951wh c2951wh, String str, Throwable th) {
        this.c = c2951wh;
        this.a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.c;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).reportError(this.a, this.b);
    }
}
