package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class G1 implements Runnable {
    final /* synthetic */ C2233e2 a;
    final /* synthetic */ H1 b;

    G1(H1 h1, C2233e2 c2233e2) {
        this.b = h1;
        this.a = c2233e2;
    }

    @Override // java.lang.Runnable
    public final void run() throws ClassNotFoundException {
        H1.e(this.b, this.a);
        this.b.m(this.a.g);
    }
}
