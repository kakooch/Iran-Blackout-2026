package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class xd implements vb {
    private final cy a;
    private long[] c;
    private boolean d;
    private xn e;
    private boolean f;
    private int g;
    private final re b = new re();
    private long h = -9223372036854775807L;

    public xd(xn xnVar, cy cyVar, boolean z) {
        this.a = cyVar;
        this.e = xnVar;
        this.c = xnVar.b;
        f(xnVar, z);
    }

    public final String a() {
        return this.e.a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final boolean b() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final void c() throws IOException {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final int d(cz czVar, iw iwVar, boolean z) throws IOException {
        if (z || !this.f) {
            czVar.a = this.a;
            this.f = true;
            return -5;
        }
        int i = this.g;
        if (i == this.c.length) {
            if (this.d) {
                return -3;
            }
            iwVar.f(4);
            return -4;
        }
        this.g = i + 1;
        byte[] bArrA = this.b.a(this.e.a[i]);
        iwVar.i(bArrA.length);
        iwVar.b.put(bArrA);
        iwVar.d = this.c[i];
        iwVar.f(1);
        return -4;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final int e(long j) {
        int iMax = Math.max(this.g, aeu.ak(this.c, j, true));
        int i = this.g;
        this.g = iMax;
        return iMax - i;
    }

    public final void g(long j) {
        int iAk = aeu.ak(this.c, j, true);
        this.g = iAk;
        if (!this.d || iAk != this.c.length) {
            j = -9223372036854775807L;
        }
        this.h = j;
    }

    public final void f(xn xnVar, boolean z) {
        int i = this.g;
        long j = i == 0 ? -9223372036854775807L : this.c[i - 1];
        this.d = z;
        this.e = xnVar;
        long[] jArr = xnVar.b;
        this.c = jArr;
        long j2 = this.h;
        if (j2 != -9223372036854775807L) {
            g(j2);
        } else if (j != -9223372036854775807L) {
            this.g = aeu.ak(jArr, j, false);
        }
    }
}
