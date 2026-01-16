package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Yg implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C2951wh d;

    public Yg(C2951wh c2951wh, String str, String str2, Throwable th) {
        this.d = c2951wh;
        this.a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.d;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).reportError(this.a, this.b, this.c);
    }
}
