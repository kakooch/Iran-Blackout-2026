package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class A2 implements Runnable {
    final /* synthetic */ Boolean a;
    final /* synthetic */ G2 b;

    A2(G2 g2, Boolean bool) {
        this.b = g2;
        this.a = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.O(this.a, true);
    }
}
