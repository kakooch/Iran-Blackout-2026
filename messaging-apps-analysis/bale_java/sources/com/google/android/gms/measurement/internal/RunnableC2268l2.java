package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.l2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2268l2 implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ G2 b;

    RunnableC2268l2(G2 g2, long j) {
        this.b = g2;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.F().k.b(this.a);
        this.b.a.b().q().b("Session timeout duration set", Long.valueOf(this.a));
    }
}
