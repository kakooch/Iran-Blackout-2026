package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class lc implements jy {
    public static final /* synthetic */ int a = 0;
    private final byte[] b;
    private final aee c;
    private final kd d;
    private ka e;
    private kr f;
    private int g;
    private qz h;
    private kh i;
    private int j;
    private int k;
    private la l;
    private int m;
    private long n;

    static {
        int i = lb.b;
    }

    public lc() {
        this(null);
    }

    private final long a(aee aeeVar, boolean z) {
        boolean zI;
        ary.t(this.i);
        int iG = aeeVar.g();
        while (iG <= aeeVar.e() - 16) {
            aeeVar.h(iG);
            if (asn.i(aeeVar, this.i, this.k, this.d)) {
                aeeVar.h(iG);
                return this.d.a;
            }
            iG++;
        }
        if (!z) {
            aeeVar.h(iG);
            return -1L;
        }
        while (iG <= aeeVar.e() - this.j) {
            aeeVar.h(iG);
            try {
                zI = asn.i(aeeVar, this.i, this.k, this.d);
            } catch (IndexOutOfBoundsException unused) {
                zI = false;
            }
            if (aeeVar.g() <= aeeVar.e() && zI) {
                aeeVar.h(iG);
                return this.d.a;
            }
            iG++;
        }
        aeeVar.h(aeeVar.e());
        return -1L;
    }

    private final void b() {
        long j = this.n;
        kh khVar = this.i;
        int i = aeu.a;
        this.f.b((j * 1000000) / khVar.e, 1, this.m, 0, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.e = kaVar;
        this.f = kaVar.ak(0, 1);
        kaVar.al();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final boolean g(jv jvVar) throws IOException {
        atv.t(jvVar, false);
        aee aeeVar = new aee(4);
        jvVar.g(aeeVar.i(), 0, 4);
        return aeeVar.t() == 1716281667;
    }

    public lc(byte[] bArr) {
        this.b = new byte[42];
        this.c = new aee(new byte[32768], 0);
        this.d = new kd();
        this.g = 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        if (j == 0) {
            this.g = 0;
        } else {
            la laVar = this.l;
            if (laVar != null) {
                laVar.b(j2);
            }
        }
        this.n = j2 != 0 ? -1L : 0L;
        this.m = 0;
        this.c.a(0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final int h(jv jvVar, kl klVar) throws IOException {
        boolean zH;
        kh khVar;
        ko knVar;
        boolean z;
        int i = this.g;
        if (i == 0) {
            jvVar.j();
            long jK = jvVar.k();
            qz qzVarT = atv.t(jvVar, true);
            jvVar.d((int) (jvVar.k() - jK));
            this.h = qzVarT;
            this.g = 1;
            return 0;
        }
        if (i == 1) {
            byte[] bArr = this.b;
            int length = bArr.length;
            jvVar.g(bArr, 0, 42);
            jvVar.j();
            this.g = 2;
            return 0;
        }
        if (i == 2) {
            aee aeeVar = new aee(4);
            jvVar.c(aeeVar.i(), 0, 4);
            if (aeeVar.t() != 1716281667) {
                throw new dt("Failed to read FLAC stream marker.");
            }
            this.g = 3;
            return 0;
        }
        if (i == 3) {
            ke keVar = new ke(this.i);
            do {
                jvVar.j();
                aed aedVar = new aed(new byte[4]);
                jvVar.g(aedVar.a, 0, 4);
                zH = aedVar.h();
                int i2 = aedVar.i(7);
                int i3 = aedVar.i(24) + 4;
                if (i2 == 0) {
                    byte[] bArr2 = new byte[38];
                    jvVar.c(bArr2, 0, 38);
                    keVar.a = new kh(bArr2, 4);
                } else {
                    kh khVar2 = keVar.a;
                    if (khVar2 == null) {
                        throw new IllegalArgumentException();
                    }
                    if (i2 == 3) {
                        aee aeeVar2 = new aee(i3);
                        jvVar.c(aeeVar2.i(), 0, i3);
                        keVar.a = khVar2.e(atv.s(aeeVar2));
                    } else if (i2 == 4) {
                        aee aeeVar3 = new aee(i3);
                        jvVar.c(aeeVar3.i(), 0, i3);
                        aeeVar3.k(4);
                        keVar.a = khVar2.f(Arrays.asList(atv.n(aeeVar3, false, false).a));
                    } else if (i2 == 6) {
                        aee aeeVar4 = new aee(i3);
                        jvVar.c(aeeVar4.i(), 0, i3);
                        aeeVar4.k(4);
                        int iV = aeeVar4.v();
                        String strF = aeeVar4.F(aeeVar4.v(), apv.a);
                        String strE = aeeVar4.E(aeeVar4.v());
                        int iV2 = aeeVar4.v();
                        int iV3 = aeeVar4.v();
                        int iV4 = aeeVar4.v();
                        int iV5 = aeeVar4.v();
                        int iV6 = aeeVar4.v();
                        byte[] bArr3 = new byte[iV6];
                        aeeVar4.m(bArr3, 0, iV6);
                        keVar.a = khVar2.g(Collections.singletonList(new rg(iV, strF, strE, iV2, iV3, iV4, iV5, bArr3)));
                    } else {
                        jvVar.d(i3);
                    }
                }
                khVar = keVar.a;
                int i4 = aeu.a;
                this.i = khVar;
            } while (!zH);
            ary.t(khVar);
            this.j = Math.max(this.i.c, 6);
            this.f.a(this.i.c(this.b, this.h));
            this.g = 4;
            return 0;
        }
        if (i == 4) {
            jvVar.j();
            aee aeeVar5 = new aee(2);
            jvVar.g(aeeVar5.i(), 0, 2);
            int iO = aeeVar5.o();
            if ((iO >> 2) != 16382) {
                jvVar.j();
                throw new dt("First frame does not start with sync code.");
            }
            jvVar.j();
            this.k = iO;
            ka kaVar = this.e;
            int i5 = aeu.a;
            long jL = jvVar.l();
            long jM = jvVar.m();
            ary.t(this.i);
            kh khVar3 = this.i;
            if (khVar3.k != null) {
                knVar = new kf(khVar3, jL);
            } else if (jM == -1 || khVar3.j <= 0) {
                knVar = new kn(khVar3.a());
            } else {
                la laVar = new la(khVar3, this.k, jL, jM);
                this.l = laVar;
                knVar = laVar.a();
            }
            kaVar.am(knVar);
            this.g = 5;
            return 0;
        }
        ary.t(this.f);
        ary.t(this.i);
        la laVar2 = this.l;
        if (laVar2 != null && laVar2.c()) {
            return this.l.d(jvVar, klVar);
        }
        if (this.n == -1) {
            this.n = asn.l(jvVar, this.i);
            return 0;
        }
        int iE = this.c.e();
        if (iE < 32768) {
            int iA = jvVar.a(this.c.i(), iE, 32768 - iE);
            z = iA == -1;
            if (!z) {
                this.c.f(iE + iA);
            } else if (this.c.d() == 0) {
                b();
                return -1;
            }
        } else {
            z = false;
        }
        int iG = this.c.g();
        int i6 = this.m;
        int i7 = this.j;
        if (i6 < i7) {
            aee aeeVar6 = this.c;
            aeeVar6.k(Math.min(i7 - i6, aeeVar6.d()));
        }
        long jA = a(this.c, z);
        int iG2 = this.c.g() - iG;
        this.c.h(iG);
        this.f.d(this.c, iG2);
        this.m += iG2;
        if (jA != -1) {
            b();
            this.m = 0;
            this.n = jA;
        }
        if (this.c.d() >= 16) {
            return 0;
        }
        System.arraycopy(this.c.i(), this.c.g(), this.c.i(), 0, this.c.d());
        aee aeeVar7 = this.c;
        aeeVar7.a(aeeVar7.d());
        return 0;
    }
}
