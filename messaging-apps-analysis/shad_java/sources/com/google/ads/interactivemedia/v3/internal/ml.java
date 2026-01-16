package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ml {
    private static final byte[] a = aeu.y("OpusHead");

    public static qz a(md mdVar, boolean z) {
        if (z) {
            return null;
        }
        aee aeeVar = mdVar.a;
        aeeVar.h(8);
        while (aeeVar.d() >= 8) {
            int iG = aeeVar.g();
            int iV = aeeVar.v();
            if (aeeVar.v() == 1835365473) {
                aeeVar.h(iG);
                int i = iG + iV;
                aeeVar.k(12);
                while (aeeVar.g() < i) {
                    int iG2 = aeeVar.g();
                    int iV2 = aeeVar.v();
                    if (aeeVar.v() == 1768715124) {
                        aeeVar.h(iG2);
                        int i2 = iG2 + iV2;
                        aeeVar.k(8);
                        ArrayList arrayList = new ArrayList();
                        while (aeeVar.g() < i2) {
                            qy qyVarA = mt.a(aeeVar);
                            if (qyVarA != null) {
                                arrayList.add(qyVarA);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new qz(arrayList);
                    }
                    aeeVar.h(iG2 + iV2);
                }
                return null;
            }
            aeeVar.h(iG + iV);
        }
        return null;
    }

    public static qz b(mc mcVar) {
        sn snVar;
        md mdVarC = mcVar.c(1751411826);
        md mdVarC2 = mcVar.c(1801812339);
        md mdVarC3 = mcVar.c(1768715124);
        if (mdVarC == null || mdVarC2 == null || mdVarC3 == null || d(mdVarC.a) != 1835299937) {
            return null;
        }
        aee aeeVar = mdVarC2.a;
        aeeVar.h(12);
        int iV = aeeVar.v();
        String[] strArr = new String[iV];
        for (int i = 0; i < iV; i++) {
            int iV2 = aeeVar.v();
            aeeVar.k(4);
            strArr[i] = aeeVar.E(iV2 - 8);
        }
        aee aeeVar2 = mdVarC3.a;
        aeeVar2.h(8);
        ArrayList arrayList = new ArrayList();
        while (aeeVar2.d() > 8) {
            int iG = aeeVar2.g();
            int iV3 = aeeVar2.v();
            int iV4 = aeeVar2.v() - 1;
            if (iV4 < 0 || iV4 >= iV) {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Skipped metadata with unknown key index: ");
                sb.append(iV4);
                Log.w("AtomParsers", sb.toString());
            } else {
                String str = strArr[iV4];
                int i2 = iG + iV3;
                int i3 = mt.b;
                while (true) {
                    int iG2 = aeeVar2.g();
                    if (iG2 >= i2) {
                        snVar = null;
                        break;
                    }
                    int iV5 = aeeVar2.v();
                    if (aeeVar2.v() == 1684108385) {
                        int iV6 = aeeVar2.v();
                        int iV7 = aeeVar2.v();
                        int i4 = iV5 - 16;
                        byte[] bArr = new byte[i4];
                        aeeVar2.m(bArr, 0, i4);
                        snVar = new sn(str, bArr, iV7, iV6);
                        break;
                    }
                    aeeVar2.h(iG2 + iV5);
                }
                if (snVar != null) {
                    arrayList.add(snVar);
                }
            }
            aeeVar2.h(iG + iV3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new qz(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:328:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x06dc  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x06e1  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x08cd A[PHI: r6
      0x08cd: PHI (r6v52 int) = (r6v51 int), (r6v51 int), (r6v76 int), (r6v51 int) binds: [B:389:0x0809, B:396:0x0823, B:413:0x08cc, B:395:0x0821] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x08ec  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x0985 A[PHI: r18
      0x0985: PHI (r18v11 int) = (r18v7 int), (r18v13 int) binds: [B:443:0x096f, B:445:0x0976] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:458:0x09c2 A[ADDED_TO_REGION, LOOP:13: B:458:0x09c2->B:462:0x09cc, LOOP_START, PHI: r26
      0x09c2: PHI (r26v6 int) = (r26v5 int), (r26v7 int) binds: [B:457:0x09c0, B:462:0x09cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:463:0x09d2  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x09d5  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0a12  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0a25  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x0a28  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0a89  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x0aa2  */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0b5b  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x09b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0219  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<com.google.ads.interactivemedia.v3.internal.ne> c(com.google.ads.interactivemedia.v3.internal.mc r45, com.google.ads.interactivemedia.v3.internal.ki r46, long r47, com.google.ads.interactivemedia.v3.internal.jc r49, boolean r50, com.google.ads.interactivemedia.v3.internal.apw<com.google.ads.interactivemedia.v3.internal.nb, com.google.ads.interactivemedia.v3.internal.nb> r51) throws com.google.ads.interactivemedia.v3.internal.dt {
        /*
            Method dump skipped, instructions count: 3376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ml.c(com.google.ads.interactivemedia.v3.internal.mc, com.google.ads.interactivemedia.v3.internal.ki, long, com.google.ads.interactivemedia.v3.internal.jc, boolean, com.google.ads.interactivemedia.v3.internal.apw):java.util.List");
    }

    private static int d(aee aeeVar) {
        aeeVar.h(16);
        return aeeVar.v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(com.google.ads.interactivemedia.v3.internal.aee r21, int r22, int r23, int r24, int r25, java.lang.String r26, boolean r27, com.google.ads.interactivemedia.v3.internal.jc r28, com.google.ads.interactivemedia.v3.internal.mh r29, int r30) throws com.google.ads.interactivemedia.v3.internal.dt {
        /*
            Method dump skipped, instructions count: 838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ml.e(com.google.ads.interactivemedia.v3.internal.aee, int, int, int, int, java.lang.String, boolean, com.google.ads.interactivemedia.v3.internal.jc, com.google.ads.interactivemedia.v3.internal.mh, int):void");
    }

    private static Pair<String, byte[]> f(aee aeeVar, int i) {
        aeeVar.h(i + 12);
        aeeVar.k(1);
        h(aeeVar);
        aeeVar.k(2);
        int iN = aeeVar.n();
        if ((iN & 128) != 0) {
            aeeVar.k(2);
        }
        if ((iN & 64) != 0) {
            aeeVar.k(aeeVar.o());
        }
        if ((iN & 32) != 0) {
            aeeVar.k(2);
        }
        aeeVar.k(1);
        h(aeeVar);
        String strI = adz.i(aeeVar.n());
        if ("audio/mpeg".equals(strI) || "audio/vnd.dts".equals(strI) || "audio/vnd.dts.hd".equals(strI)) {
            return Pair.create(strI, null);
        }
        aeeVar.k(12);
        aeeVar.k(1);
        int iH = h(aeeVar);
        byte[] bArr = new byte[iH];
        aeeVar.m(bArr, 0, iH);
        return Pair.create(strI, bArr);
    }

    private static Pair<Integer, nc> g(aee aeeVar, int i, int i2) {
        Integer num;
        nc ncVar;
        Pair<Integer, nc> pairCreate;
        int i3;
        int i4;
        byte[] bArr;
        int iG = aeeVar.g();
        while (iG - i < i2) {
            aeeVar.h(iG);
            int iV = aeeVar.v();
            ary.r(iV > 0, "childAtomSize should be positive");
            if (aeeVar.v() == 1936289382) {
                int i5 = iG + 8;
                int i6 = -1;
                int i7 = 0;
                String strE = null;
                Integer numValueOf = null;
                while (i5 - iG < iV) {
                    aeeVar.h(i5);
                    int iV2 = aeeVar.v();
                    int iV3 = aeeVar.v();
                    if (iV3 == 1718775137) {
                        numValueOf = Integer.valueOf(aeeVar.v());
                    } else if (iV3 == 1935894637) {
                        aeeVar.k(4);
                        strE = aeeVar.E(4);
                    } else if (iV3 == 1935894633) {
                        i6 = i5;
                        i7 = iV2;
                    }
                    i5 += iV2;
                }
                if ("cenc".equals(strE) || "cbc1".equals(strE) || "cens".equals(strE) || "cbcs".equals(strE)) {
                    ary.w(numValueOf, "frma atom is mandatory");
                    ary.r(i6 != -1, "schi atom is mandatory");
                    int i8 = i6 + 8;
                    while (true) {
                        if (i8 - i6 >= i7) {
                            num = numValueOf;
                            ncVar = null;
                            break;
                        }
                        aeeVar.h(i8);
                        int iV4 = aeeVar.v();
                        if (aeeVar.v() == 1952804451) {
                            int iV5 = aeeVar.v();
                            aeeVar.k(1);
                            if (me.e(iV5) == 0) {
                                aeeVar.k(1);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int iN = aeeVar.n();
                                int i9 = (iN & 240) >> 4;
                                i3 = iN & 15;
                                i4 = i9;
                            }
                            boolean z = aeeVar.n() == 1;
                            int iN2 = aeeVar.n();
                            byte[] bArr2 = new byte[16];
                            aeeVar.m(bArr2, 0, 16);
                            if (z && iN2 == 0) {
                                int iN3 = aeeVar.n();
                                byte[] bArr3 = new byte[iN3];
                                aeeVar.m(bArr3, 0, iN3);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            num = numValueOf;
                            ncVar = new nc(z, strE, iN2, bArr2, i4, i3, bArr);
                        } else {
                            i8 += iV4;
                        }
                    }
                    ary.w(ncVar, "tenc atom is mandatory");
                    pairCreate = Pair.create(num, ncVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iG += iV;
        }
        return null;
    }

    private static int h(aee aeeVar) {
        int iN = aeeVar.n();
        int i = iN & 127;
        while ((iN & 128) == 128) {
            iN = aeeVar.n();
            i = (i << 7) | (iN & 127);
        }
        return i;
    }
}
