package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class Q3 implements Runnable {
    final /* synthetic */ Z3 a;
    final /* synthetic */ Y3 b;

    Q3(Y3 y3, Z3 z3) {
        this.b = y3;
        this.a = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Y3.k0(this.b, this.a);
        this.b.x();
    }
}
