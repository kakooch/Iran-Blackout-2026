package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class B3 implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ J3 b;

    B3(J3 j3, long j) {
        this.b = j3;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        J3.q(this.b, this.a);
    }
}
