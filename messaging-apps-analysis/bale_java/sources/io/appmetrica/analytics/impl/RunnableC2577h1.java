package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.h1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2577h1 implements Runnable {
    public final /* synthetic */ Throwable a;
    public final /* synthetic */ C2601i1 b;

    public RunnableC2577h1(C2601i1 c2601i1, Throwable th) {
        this.b = c2601i1;
        this.a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.b).reportUnhandledException(this.a);
    }
}
