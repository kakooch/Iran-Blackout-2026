package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class D2 implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ G2 b;

    D2(G2 g2, boolean z) {
        this.b = g2;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zO = this.b.a.o();
        boolean zN = this.b.a.n();
        this.b.a.k(this.a);
        if (zN == this.a) {
            this.b.a.b().v().b("Default data collection state already set to", Boolean.valueOf(this.a));
        }
        if (this.b.a.o() == zO || this.b.a.o() != this.b.a.n()) {
            this.b.a.b().x().c("Default data collection is different than actual status", Boolean.valueOf(this.a), Boolean.valueOf(zO));
        }
        this.b.P();
    }
}
