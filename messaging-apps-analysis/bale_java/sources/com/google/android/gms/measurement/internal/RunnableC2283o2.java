package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.o2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2283o2 implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ G2 b;

    RunnableC2283o2(G2 g2, long j) {
        this.b = g2;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.z(this.a, true);
        this.b.a.L().S(new AtomicReference());
    }
}
