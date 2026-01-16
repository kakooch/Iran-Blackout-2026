package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class Q2 implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ T2 b;

    Q2(T2 t2, long j) {
        this.b = t2;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.y().n(this.a);
        this.b.e = null;
    }
}
