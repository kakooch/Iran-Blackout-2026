package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.g1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2553g1 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C2601i1 d;

    public RunnableC2553g1(C2601i1 c2601i1, String str, String str2, Throwable th) {
        this.d = c2601i1;
        this.a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.d).reportError(this.a, this.b, this.c);
    }
}
