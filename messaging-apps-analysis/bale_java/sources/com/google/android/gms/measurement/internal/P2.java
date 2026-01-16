package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class P2 implements Runnable {
    final /* synthetic */ T2 a;

    P2(T2 t2) {
        this.a = t2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        T2 t2 = this.a;
        t2.e = t2.j;
    }
}
