package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC3795Cj5;
import ir.nasim.OV0;

/* loaded from: classes3.dex */
final class K3 {
    private final OV0 a;
    private long b;

    public K3(OV0 ov0) {
        AbstractC3795Cj5.j(ov0);
        this.a = ov0;
    }

    public final void a() {
        this.b = 0L;
    }

    public final void b() {
        this.b = this.a.elapsedRealtime();
    }

    public final boolean c(long j) {
        return this.b == 0 || this.a.elapsedRealtime() - this.b >= 3600000;
    }
}
