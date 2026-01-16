package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class oz {
    private boolean c;
    private boolean d;
    private boolean e;
    private final aes a = new aes(0);
    private long f = -9223372036854775807L;
    private long g = -9223372036854775807L;
    private long h = -9223372036854775807L;
    private final aee b = new aee();

    oz() {
    }

    public static long d(aee aeeVar) {
        int iG = aeeVar.g();
        if (aeeVar.d() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        aeeVar.m(bArr, 0, 9);
        aeeVar.h(iG);
        if ((bArr[0] & 196) != 68 || (bArr[2] & 4) != 4 || (bArr[4] & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return -9223372036854775807L;
        }
        long j = bArr[0];
        byte b = bArr[1];
        long j2 = bArr[2];
        return ((bArr[3] & 255) << 5) | ((j & 3) << 28) | (((56 & j) >> 3) << 30) | ((b & 255) << 20) | (((j2 & 248) >> 3) << 15) | ((j2 & 3) << 13) | ((bArr[4] & 248) >> 3);
    }

    private final void f(jv jvVar) {
        this.b.b(aeu.f);
        this.c = true;
        jvVar.j();
    }

    private static final int g(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public final boolean a() {
        return this.c;
    }

    public final aes b() {
        return this.a;
    }

    public final long c() {
        return this.h;
    }

    public final int e(jv jvVar, kl klVar) throws IOException {
        long j = -9223372036854775807L;
        if (!this.e) {
            long jM = jvVar.m();
            int iMin = (int) Math.min(20000L, jM);
            long j2 = jM - iMin;
            if (jvVar.l() != j2) {
                klVar.a = j2;
                return 1;
            }
            this.b.a(iMin);
            jvVar.j();
            jvVar.g(this.b.i(), 0, iMin);
            aee aeeVar = this.b;
            int iG = aeeVar.g();
            int iE = aeeVar.e() - 4;
            while (true) {
                if (iE < iG) {
                    break;
                }
                if (g(aeeVar.i(), iE) == 442) {
                    aeeVar.h(iE + 4);
                    long jD = d(aeeVar);
                    if (jD != -9223372036854775807L) {
                        j = jD;
                        break;
                    }
                }
                iE--;
            }
            this.g = j;
            this.e = true;
            return 0;
        }
        if (this.g == -9223372036854775807L) {
            f(jvVar);
            return 0;
        }
        if (this.d) {
            long j3 = this.f;
            if (j3 == -9223372036854775807L) {
                f(jvVar);
                return 0;
            }
            this.h = this.a.f(this.g) - this.a.f(j3);
            f(jvVar);
            return 0;
        }
        int iMin2 = (int) Math.min(20000L, jvVar.m());
        if (jvVar.l() != 0) {
            klVar.a = 0L;
            return 1;
        }
        this.b.a(iMin2);
        jvVar.j();
        jvVar.g(this.b.i(), 0, iMin2);
        aee aeeVar2 = this.b;
        int iG2 = aeeVar2.g();
        int iE2 = aeeVar2.e();
        while (true) {
            if (iG2 >= iE2 - 3) {
                break;
            }
            if (g(aeeVar2.i(), iG2) == 442) {
                aeeVar2.h(iG2 + 4);
                long jD2 = d(aeeVar2);
                if (jD2 != -9223372036854775807L) {
                    j = jD2;
                    break;
                }
            }
            iG2++;
        }
        this.f = j;
        this.d = true;
        return 0;
    }
}
