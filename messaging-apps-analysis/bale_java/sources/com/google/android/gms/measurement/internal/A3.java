package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class A3 implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ J3 b;

    A3(J3 j3, long j) {
        this.b = j3;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        J3.r(this.b, this.a);
    }
}
