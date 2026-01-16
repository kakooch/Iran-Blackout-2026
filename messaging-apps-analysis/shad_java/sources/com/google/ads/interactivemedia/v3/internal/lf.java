package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class lf implements jy {
    public static final /* synthetic */ int a = 0;
    private ka g;
    private boolean i;
    private long j;
    private int k;
    private int l;
    private int m;
    private long n;
    private boolean o;
    private ld p;
    private lj q;
    private final aee b = new aee(4);
    private final aee c = new aee(9);
    private final aee d = new aee(11);
    private final aee e = new aee();
    private final lg f = new lg();
    private int h = 1;

    static {
        int i = le.b;
    }

    private final void a() {
        if (this.o) {
            return;
        }
        this.g.am(new kn(-9223372036854775807L));
        this.o = true;
    }

    private final aee b(jv jvVar) throws IOException {
        if (this.m > this.e.j()) {
            aee aeeVar = this.e;
            int iJ = aeeVar.j();
            aeeVar.c(new byte[Math.max(iJ + iJ, this.m)], 0);
        } else {
            this.e.h(0);
        }
        this.e.f(this.m);
        jvVar.c(this.e.i(), 0, this.m);
        return this.e;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.g = kaVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        if (j == 0) {
            this.h = 1;
            this.i = false;
        } else {
            this.h = 3;
        }
        this.k = 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final boolean g(jv jvVar) throws IOException {
        jvVar.g(this.b.i(), 0, 3);
        this.b.h(0);
        if (this.b.r() != 4607062) {
            return false;
        }
        jvVar.g(this.b.i(), 0, 2);
        this.b.h(0);
        if ((this.b.o() & 250) != 0) {
            return false;
        }
        jvVar.g(this.b.i(), 0, 4);
        this.b.h(0);
        int iV = this.b.v();
        jvVar.j();
        jvVar.i(iV);
        jvVar.g(this.b.i(), 0, 4);
        this.b.h(0);
        return this.b.v() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0009 A[SYNTHETIC] */
    @Override // com.google.ads.interactivemedia.v3.internal.jy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(com.google.ads.interactivemedia.v3.internal.jv r17, com.google.ads.interactivemedia.v3.internal.kl r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.lf.h(com.google.ads.interactivemedia.v3.internal.jv, com.google.ads.interactivemedia.v3.internal.kl):int");
    }
}
