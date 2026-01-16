package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class X implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ C2330y0 b;

    X(C2330y0 c2330y0, long j) {
        this.b = c2330y0;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.q(this.a);
    }
}
