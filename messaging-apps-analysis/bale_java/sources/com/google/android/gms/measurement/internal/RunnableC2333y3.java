package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.y3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2333y3 implements Runnable {
    final /* synthetic */ Y3 a;
    final /* synthetic */ Runnable b;

    RunnableC2333y3(C2338z3 c2338z3, Y3 y3, Runnable runnable) {
        this.a = y3;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.a.e();
        this.a.l0(this.b);
        this.a.C();
    }
}
