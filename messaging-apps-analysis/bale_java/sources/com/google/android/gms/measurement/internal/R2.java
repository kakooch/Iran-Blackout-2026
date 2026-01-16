package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class R2 implements Runnable {
    final /* synthetic */ M2 a;
    final /* synthetic */ long b;
    final /* synthetic */ T2 c;

    R2(T2 t2, M2 m2, long j) {
        this.c = t2;
        this.a = m2;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.p(this.a, false, this.b);
        T2 t2 = this.c;
        t2.e = null;
        t2.a.L().u(null);
    }
}
