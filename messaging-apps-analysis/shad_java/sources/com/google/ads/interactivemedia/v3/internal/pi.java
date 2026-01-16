package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class pi {
    private boolean d;
    private boolean e;
    private boolean f;
    private final int a = 112800;
    private final aes b = new aes(0);
    private long g = -9223372036854775807L;
    private long h = -9223372036854775807L;
    private long i = -9223372036854775807L;
    private final aee c = new aee();

    pi(int i) {
    }

    private final void e(jv jvVar) {
        this.c.b(aeu.f);
        this.d = true;
        jvVar.j();
    }

    public final boolean a() {
        return this.d;
    }

    public final long b() {
        return this.i;
    }

    public final aes c() {
        return this.b;
    }

    public final int d(jv jvVar, kl klVar, int i) throws IOException {
        if (i <= 0) {
            e(jvVar);
            return 0;
        }
        long j = -9223372036854775807L;
        if (!this.f) {
            long jM = jvVar.m();
            int iMin = (int) Math.min(112800L, jM);
            long j2 = jM - iMin;
            if (jvVar.l() != j2) {
                klVar.a = j2;
                return 1;
            }
            this.c.a(iMin);
            jvVar.j();
            jvVar.g(this.c.i(), 0, iMin);
            aee aeeVar = this.c;
            int iG = aeeVar.g();
            int iE = aeeVar.e();
            while (true) {
                iE--;
                if (iE < iG) {
                    break;
                }
                if (aeeVar.i()[iE] == 71) {
                    long jG = mz.g(aeeVar, iE, i);
                    if (jG != -9223372036854775807L) {
                        j = jG;
                        break;
                    }
                }
            }
            this.h = j;
            this.f = true;
            return 0;
        }
        if (this.h == -9223372036854775807L) {
            e(jvVar);
            return 0;
        }
        if (this.e) {
            long j3 = this.g;
            if (j3 == -9223372036854775807L) {
                e(jvVar);
                return 0;
            }
            this.i = this.b.f(this.h) - this.b.f(j3);
            e(jvVar);
            return 0;
        }
        int iMin2 = (int) Math.min(112800L, jvVar.m());
        if (jvVar.l() != 0) {
            klVar.a = 0L;
            return 1;
        }
        this.c.a(iMin2);
        jvVar.j();
        jvVar.g(this.c.i(), 0, iMin2);
        aee aeeVar2 = this.c;
        int iG2 = aeeVar2.g();
        int iE2 = aeeVar2.e();
        while (true) {
            if (iG2 >= iE2) {
                break;
            }
            if (aeeVar2.i()[iG2] == 71) {
                long jG2 = mz.g(aeeVar2, iG2, i);
                if (jG2 != -9223372036854775807L) {
                    j = jG2;
                    break;
                }
            }
            iG2++;
        }
        this.g = j;
        this.e = true;
        return 0;
    }
}
