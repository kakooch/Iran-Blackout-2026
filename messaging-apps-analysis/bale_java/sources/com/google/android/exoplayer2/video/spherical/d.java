package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.video.spherical.c;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.DW4;
import ir.nasim.EW4;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* loaded from: classes2.dex */
abstract class d {
    public static c a(byte[] bArr, int i) {
        ArrayList arrayListF;
        EW4 ew4 = new EW4(bArr);
        try {
            arrayListF = c(ew4) ? f(ew4) : e(ew4);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayListF = null;
        }
        if (arrayListF == null) {
            return null;
        }
        int size = arrayListF.size();
        if (size == 1) {
            return new c((c.a) arrayListF.get(0), i);
        }
        if (size != 2) {
            return null;
        }
        return new c((c.a) arrayListF.get(0), (c.a) arrayListF.get(1), i);
    }

    private static int b(int i) {
        return (-(i & 1)) ^ (i >> 1);
    }

    private static boolean c(EW4 ew4) {
        ew4.T(4);
        int iO = ew4.o();
        ew4.S(0);
        return iO == 1886547818;
    }

    private static c.a d(EW4 ew4) {
        int iO = ew4.o();
        if (iO > 10000) {
            return null;
        }
        float[] fArr = new float[iO];
        for (int i = 0; i < iO; i++) {
            fArr[i] = ew4.n();
        }
        int iO2 = ew4.o();
        if (iO2 > 32000) {
            return null;
        }
        double d = 2.0d;
        double dLog = Math.log(2.0d);
        int iCeil = (int) Math.ceil(Math.log(iO * 2.0d) / dLog);
        DW4 dw4 = new DW4(ew4.e());
        int i2 = 8;
        dw4.p(ew4.f() * 8);
        float[] fArr2 = new float[iO2 * 5];
        int i3 = 5;
        int[] iArr = new int[5];
        int i4 = 0;
        int i5 = 0;
        while (i4 < iO2) {
            int i6 = 0;
            while (i6 < i3) {
                int iB = iArr[i6] + b(dw4.h(iCeil));
                if (iB >= iO || iB < 0) {
                    return null;
                }
                fArr2[i5] = fArr[iB];
                iArr[i6] = iB;
                i6++;
                i5++;
                i3 = 5;
            }
            i4++;
            i3 = 5;
        }
        dw4.p((dw4.e() + 7) & (-8));
        int i7 = 32;
        int iH = dw4.h(32);
        c.b[] bVarArr = new c.b[iH];
        int i8 = 0;
        while (i8 < iH) {
            int iH2 = dw4.h(i2);
            int iH3 = dw4.h(i2);
            int iH4 = dw4.h(i7);
            if (iH4 > 128000) {
                return null;
            }
            int iCeil2 = (int) Math.ceil(Math.log(iO2 * d) / dLog);
            float[] fArr3 = new float[iH4 * 3];
            float[] fArr4 = new float[iH4 * 2];
            int iB2 = 0;
            for (int i9 = 0; i9 < iH4; i9++) {
                iB2 += b(dw4.h(iCeil2));
                if (iB2 < 0 || iB2 >= iO2) {
                    return null;
                }
                int i10 = i9 * 3;
                int i11 = iB2 * 5;
                fArr3[i10] = fArr2[i11];
                fArr3[i10 + 1] = fArr2[i11 + 1];
                fArr3[i10 + 2] = fArr2[i11 + 2];
                int i12 = i9 * 2;
                fArr4[i12] = fArr2[i11 + 3];
                fArr4[i12 + 1] = fArr2[i11 + 4];
            }
            bVarArr[i8] = new c.b(iH2, fArr3, fArr4, iH3);
            i8++;
            i7 = 32;
            d = 2.0d;
            i2 = 8;
        }
        return new c.a(bVarArr);
    }

    private static ArrayList e(EW4 ew4) {
        if (ew4.F() != 0) {
            return null;
        }
        ew4.T(7);
        int iO = ew4.o();
        if (iO == 1684433976) {
            EW4 ew42 = new EW4();
            Inflater inflater = new Inflater(true);
            try {
                if (!AbstractC9683aN7.q0(ew4, ew42, inflater)) {
                    return null;
                }
                inflater.end();
                ew4 = ew42;
            } finally {
                inflater.end();
            }
        } else if (iO != 1918990112) {
            return null;
        }
        return g(ew4);
    }

    private static ArrayList f(EW4 ew4) {
        int iO;
        ew4.T(8);
        int iF = ew4.f();
        int iG = ew4.g();
        while (iF < iG && (iO = ew4.o() + iF) > iF && iO <= iG) {
            int iO2 = ew4.o();
            if (iO2 == 2037673328 || iO2 == 1836279920) {
                ew4.R(iO);
                return e(ew4);
            }
            ew4.S(iO);
            iF = iO;
        }
        return null;
    }

    private static ArrayList g(EW4 ew4) {
        ArrayList arrayList = new ArrayList();
        int iF = ew4.f();
        int iG = ew4.g();
        while (iF < iG) {
            int iO = ew4.o() + iF;
            if (iO <= iF || iO > iG) {
                return null;
            }
            if (ew4.o() == 1835365224) {
                c.a aVarD = d(ew4);
                if (aVarD == null) {
                    return null;
                }
                arrayList.add(aVarD);
            }
            ew4.S(iO);
            iF = iO;
        }
        return arrayList;
    }
}
