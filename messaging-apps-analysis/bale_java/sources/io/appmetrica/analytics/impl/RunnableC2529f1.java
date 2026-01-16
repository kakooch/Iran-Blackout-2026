package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.f1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2529f1 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C2601i1 c;

    public RunnableC2529f1(C2601i1 c2601i1, String str, Throwable th) {
        this.c = c2601i1;
        this.a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.c).reportError(this.a, this.b);
    }
}
