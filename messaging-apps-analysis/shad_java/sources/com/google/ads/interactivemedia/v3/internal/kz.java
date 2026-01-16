package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class kz implements jr {
    private final kh a;
    private final int b;
    private final kd c = new kd();

    /* synthetic */ kz(kh khVar, int i) {
        this.a = khVar;
        this.b = i;
    }

    private final long c(jv jvVar) throws IOException {
        while (jvVar.k() < jvVar.m() - 6 && !asn.k(jvVar, this.a, this.b, this.c)) {
            jvVar.i(1);
        }
        if (jvVar.k() < jvVar.m() - 6) {
            return this.c.a;
        }
        jvVar.i((int) (jvVar.m() - jvVar.k()));
        return this.a.j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jr
    public final void a() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jr
    public final jq b(jv jvVar, long j) throws IOException {
        long jL = jvVar.l();
        long jC = c(jvVar);
        long jK = jvVar.k();
        jvVar.i(Math.max(6, this.a.c));
        long jC2 = c(jvVar);
        return (jC > j || jC2 <= j) ? jC2 <= j ? jq.b(jC2, jvVar.k()) : jq.a(jC, jL) : jq.c(jK);
    }
}
