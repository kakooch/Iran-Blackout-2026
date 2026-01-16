package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.j1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2257j1 implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ C2262k1 b;

    RunnableC2257j1(C2262k1 c2262k1, boolean z) {
        this.b = c2262k1;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.o(this.a);
    }
}
