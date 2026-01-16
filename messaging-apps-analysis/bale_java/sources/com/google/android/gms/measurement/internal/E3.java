package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class E3 {
    private D3 a;
    final /* synthetic */ J3 b;

    E3(J3 j3) {
        this.b = j3;
    }

    final void a(long j) {
        this.a = new D3(this, this.b.a.c().currentTimeMillis(), j);
        this.b.c.postDelayed(this.a, 2000L);
    }

    final void b() {
        this.b.h();
        D3 d3 = this.a;
        if (d3 != null) {
            this.b.c.removeCallbacks(d3);
        }
        this.b.a.F().r.a(false);
    }
}
