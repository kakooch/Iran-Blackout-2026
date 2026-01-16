package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class na {
    private static final int[] a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean a(jv jvVar) throws IOException {
        return c(jvVar, true);
    }

    public static boolean b(jv jvVar) throws IOException {
        return c(jvVar, false);
    }

    private static boolean c(jv jvVar, boolean z) throws IOException {
        boolean z2;
        long jM = jvVar.m();
        long j = 4096;
        long j2 = -1;
        if (jM != -1 && jM <= 4096) {
            j = jM;
        }
        int i = (int) j;
        aee aeeVar = new aee(64);
        boolean z3 = false;
        int i2 = 0;
        boolean z4 = false;
        while (i2 < i) {
            aeeVar.a(8);
            if (!jvVar.f(aeeVar.i(), z3 ? 1 : 0, 8, true)) {
                break;
            }
            long jT = aeeVar.t();
            int iV = aeeVar.v();
            int i3 = 16;
            if (jT == 1) {
                jvVar.g(aeeVar.i(), 8, 8);
                aeeVar.f(16);
                jT = aeeVar.x();
            } else {
                if (jT == 0) {
                    long jM2 = jvVar.m();
                    if (jM2 != j2) {
                        jT = 8 + (jM2 - jvVar.k());
                    }
                }
                i3 = 8;
            }
            long j3 = i3;
            if (jT < j3) {
                return z3;
            }
            i2 += i3;
            if (iV == 1836019574) {
                i += (int) jT;
                if (jM != -1 && i > jM) {
                    i = (int) jM;
                }
                j2 = -1;
            } else {
                if (iV == 1836019558 || iV == 1836475768) {
                    z2 = true;
                    break;
                }
                long j4 = jM;
                if ((i2 + jT) - j3 >= i) {
                    break;
                }
                int i4 = (int) (jT - j3);
                i2 += i4;
                if (iV == 1718909296) {
                    if (i4 < 8) {
                        return false;
                    }
                    aeeVar.a(i4);
                    jvVar.g(aeeVar.i(), 0, i4);
                    int i5 = i4 >> 2;
                    for (int i6 = 0; i6 < i5; i6++) {
                        if (i6 != 1) {
                            int iV2 = aeeVar.v();
                            if ((iV2 >>> 8) != 3368816) {
                                int[] iArr = a;
                                for (int i7 = 0; i7 < 28; i7++) {
                                    if (iArr[i7] != iV2) {
                                    }
                                }
                            }
                            z4 = true;
                            break;
                        }
                        aeeVar.k(4);
                    }
                    if (!z4) {
                        return false;
                    }
                } else if (i4 != 0) {
                    jvVar.i(i4);
                }
                j2 = -1;
                jM = j4;
                z3 = false;
            }
        }
        z2 = false;
        return z4 && z == z2;
    }
}
