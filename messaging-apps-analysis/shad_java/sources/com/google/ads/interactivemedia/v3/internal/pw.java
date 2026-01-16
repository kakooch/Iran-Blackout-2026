package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class pw implements pv {
    private final ka a;
    private final kr b;
    private final py c;
    private final cy d;
    private final int e;
    private long f;
    private int g;
    private long h;

    public pw(ka kaVar, kr krVar, py pyVar, String str, int i) throws dt {
        this.a = kaVar;
        this.b = krVar;
        this.c = pyVar;
        int i2 = (pyVar.b * pyVar.e) / 8;
        int i3 = pyVar.d;
        if (i3 != i2) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Expected block size: ");
            sb.append(i2);
            sb.append("; got: ");
            sb.append(i3);
            throw new dt(sb.toString());
        }
        int i4 = pyVar.c * i2;
        int i5 = i4 * 8;
        int iMax = Math.max(i2, i4 / 10);
        this.e = iMax;
        cx cxVar = new cx();
        cxVar.ae(str);
        cxVar.G(i5);
        cxVar.Z(i5);
        cxVar.W(iMax);
        cxVar.H(pyVar.b);
        cxVar.af(pyVar.c);
        cxVar.Y(i);
        this.d = cxVar.a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pv
    public final void a(long j) {
        this.f = j;
        this.g = 0;
        this.h = 0L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pv
    public final void b(int i, long j) {
        this.a.am(new qb(this.c, 1, i, j));
        this.b.a(this.d);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.pv
    public final boolean c(jv jvVar, long j) throws IOException {
        long j2;
        int i;
        int i2;
        long j3 = j;
        while (j3 > 0 && (i = this.g) < (i2 = this.e)) {
            int iC = this.b.c(jvVar, (int) Math.min(i2 - i, j3), true);
            if (iC == -1) {
                j3 = 0;
            } else {
                this.g += iC;
                j3 -= iC;
            }
        }
        int i3 = this.c.d;
        int i4 = this.g / i3;
        if (i4 > 0) {
            long j4 = this.f;
            long jN = aeu.N(this.h, 1000000L, r6.c);
            int i5 = i4 * i3;
            int i6 = this.g - i5;
            this.b.b(j4 + jN, 1, i5, i6, null);
            this.h += i4;
            this.g = i6;
            j2 = 0;
        } else {
            j2 = 0;
        }
        return j3 <= j2;
    }
}
