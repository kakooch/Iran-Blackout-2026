package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC22220ur8;
import ir.nasim.AbstractC3795Cj5;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
final class W3 {
    com.google.android.gms.internal.measurement.U a;
    List b;
    List c;
    long d;
    final /* synthetic */ Y3 e;

    /* synthetic */ W3(Y3 y3, AbstractC22220ur8 abstractC22220ur8) {
        this.e = y3;
    }

    private static final long b(com.google.android.gms.internal.measurement.J j) {
        return ((j.D() / 1000) / 60) / 60;
    }

    public final boolean a(long j, com.google.android.gms.internal.measurement.J j2) {
        AbstractC3795Cj5.j(j2);
        if (this.c == null) {
            this.c = new ArrayList();
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (!this.c.isEmpty() && b((com.google.android.gms.internal.measurement.J) this.c.get(0)) != b(j2)) {
            return false;
        }
        long jD = this.d + j2.d();
        this.e.U();
        if (jD >= Math.max(0, ((Integer) S0.j.a(null)).intValue())) {
            return false;
        }
        this.d = jD;
        this.c.add(j2);
        this.b.add(Long.valueOf(j));
        int size = this.c.size();
        this.e.U();
        return size < Math.max(1, ((Integer) S0.k.a(null)).intValue());
    }
}
