package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Q1 implements Runnable {
    public final /* synthetic */ InterfaceC2851sd a;
    public final /* synthetic */ C2941w7 b;

    public Q1(S1 s1, C2941w7 c2941w7) {
        this.a = s1;
        this.b = c2941w7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.consume(this.b);
    }
}
