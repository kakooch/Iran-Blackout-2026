package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class la extends js {
    public la(kh khVar, int i, long j, long j2) {
        long j3;
        khVar.getClass();
        jp jpVarB = ky.b(khVar);
        kz kzVar = new kz(khVar, i);
        long jA = khVar.a();
        long j4 = khVar.j;
        int i2 = khVar.d;
        if (i2 > 0) {
            j3 = ((i2 + khVar.c) / 2) + 1;
        } else {
            int i3 = khVar.a;
            long j5 = 4096;
            if (i3 == khVar.b && i3 > 0) {
                j5 = i3;
            }
            j3 = (((j5 * khVar.g) * khVar.h) / 8) + 64;
        }
        super(jpVarB, kzVar, jA, j4, j, j2, j3, Math.max(6, khVar.c));
    }
}
