package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.wf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2949wf implements Runnable {
    public final /* synthetic */ Hf a;
    public final /* synthetic */ Throwable b;

    public RunnableC2949wf(Hf hf, Throwable th) {
        this.a = hf;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b);
    }
}
