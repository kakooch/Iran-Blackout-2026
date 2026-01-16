package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import ir.nasim.C17399mt8;

/* loaded from: classes3.dex */
final class H3 {
    protected long a;
    protected long b;
    private final AbstractC2275n c;
    final /* synthetic */ J3 d;

    public H3(J3 j3) {
        this.d = j3;
        this.c = new F3(this, j3.a);
        long jElapsedRealtime = j3.a.c().elapsedRealtime();
        this.a = jElapsedRealtime;
        this.b = jElapsedRealtime;
    }

    final void a() {
        this.c.b();
        this.a = 0L;
        this.b = 0L;
    }

    final void b(long j) {
        this.c.b();
    }

    final void c(long j) {
        this.d.h();
        this.c.b();
        this.a = j;
        this.b = j;
    }

    public final boolean d(boolean z, boolean z2, long j) {
        this.d.h();
        this.d.i();
        C17399mt8.b();
        if (!this.d.a.z().B(null, S0.f0) || this.d.a.o()) {
            this.d.a.F().o.b(this.d.a.c().currentTimeMillis());
        }
        long j2 = j - this.a;
        if (!z && j2 < 1000) {
            this.d.a.b().v().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
            return false;
        }
        if (!z2) {
            j2 = j - this.b;
            this.b = j;
        }
        this.d.a.b().v().b("Recording user engagement, ms", Long.valueOf(j2));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j2);
        f4.y(this.d.a.K().s(!this.d.a.z().D()), bundle, true);
        if (!z2) {
            this.d.a.I().u("auto", "_e", bundle);
        }
        this.a = j;
        this.c.b();
        this.c.d(3600000L);
        return true;
    }
}
