package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class pg implements jr {
    private final aes a;
    private final aee b = new aee();
    private final int c;
    private final int d;

    public pg(int i, aes aesVar, int i2) {
        this.c = i;
        this.a = aesVar;
        this.d = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jr
    public final void a() {
        this.b.b(aeu.f);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jr
    public final jq b(jv jvVar, long j) throws IOException {
        int iF;
        int iF2;
        long jL = jvVar.l();
        int iMin = (int) Math.min(this.d, jvVar.m() - jL);
        this.b.a(iMin);
        jvVar.g(this.b.i(), 0, iMin);
        aee aeeVar = this.b;
        int iE = aeeVar.e();
        long j2 = -1;
        long j3 = -1;
        long j4 = -9223372036854775807L;
        while (aeeVar.d() >= 188 && (iF2 = (iF = mz.f(aeeVar.i(), aeeVar.g(), iE)) + 188) <= iE) {
            long jG = mz.g(aeeVar, iF, this.c);
            if (jG != -9223372036854775807L) {
                long jF = this.a.f(jG);
                if (jF > j) {
                    return j4 == -9223372036854775807L ? jq.a(jF, jL) : jq.c(jL + j3);
                }
                if (100000 + jF > j) {
                    return jq.c(jL + iF);
                }
                j3 = iF;
                j4 = jF;
            }
            aeeVar.h(iF2);
            j2 = iF2;
        }
        return j4 != -9223372036854775807L ? jq.b(j4, jL + j2) : jq.a;
    }
}
