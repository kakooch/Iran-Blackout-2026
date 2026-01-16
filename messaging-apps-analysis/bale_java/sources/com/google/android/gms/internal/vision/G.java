package com.google.android.gms.internal.vision;

import ir.nasim.Tq8;

/* loaded from: classes3.dex */
abstract class G {
    static int a(int i, byte[] bArr, int i2, int i3, h1 h1Var, H h) {
        if ((i >>> 3) == 0) {
            throw zzjk.c();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iJ = j(bArr, i2, h);
            h1Var.c(i, Long.valueOf(h.b));
            return iJ;
        }
        if (i4 == 1) {
            h1Var.c(i, Long.valueOf(k(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iH = h(bArr, i2, h);
            int i5 = h.a;
            if (i5 < 0) {
                throw zzjk.b();
            }
            if (i5 > bArr.length - iH) {
                throw zzjk.a();
            }
            if (i5 == 0) {
                h1Var.c(i, K.b);
            } else {
                h1Var.c(i, K.E(bArr, iH, i5));
            }
            return iH + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzjk.c();
            }
            h1Var.c(i, Integer.valueOf(g(bArr, i2)));
            return i2 + 4;
        }
        h1 h1VarG = h1.g();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iH2 = h(bArr, i2, h);
            int i8 = h.a;
            i7 = i8;
            if (i8 == i6) {
                i2 = iH2;
                break;
            }
            int iA = a(i7, bArr, iH2, i3, h1VarG, h);
            i7 = i8;
            i2 = iA;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzjk.e();
        }
        h1Var.c(i, h1VarG);
        return i2;
    }

    static int b(int i, byte[] bArr, int i2, int i3, Tq8 tq8, H h) {
        C2182l0 c2182l0 = (C2182l0) tq8;
        int iH = h(bArr, i2, h);
        c2182l0.i(h.a);
        while (iH < i3) {
            int iH2 = h(bArr, iH, h);
            if (i != h.a) {
                break;
            }
            iH = h(bArr, iH2, h);
            c2182l0.i(h.a);
        }
        return iH;
    }

    static int c(int i, byte[] bArr, int i2, H h) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            h.a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            h.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            h.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            h.a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                h.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int d(P0 p0, int i, byte[] bArr, int i2, int i3, Tq8 tq8, H h) {
        int iF = f(p0, bArr, i2, i3, h);
        tq8.add(h.c);
        while (iF < i3) {
            int iH = h(bArr, iF, h);
            if (i != h.a) {
                break;
            }
            iF = f(p0, bArr, iH, i3, h);
            tq8.add(h.c);
        }
        return iF;
    }

    static int e(P0 p0, byte[] bArr, int i, int i2, int i3, H h) {
        F0 f0 = (F0) p0;
        Object objZza = f0.zza();
        int iN = f0.n(objZza, bArr, i, i2, i3, h);
        f0.a(objZza);
        h.c = objZza;
        return iN;
    }

    static int f(P0 p0, byte[] bArr, int i, int i2, H h) {
        int iC = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iC = c(i3, bArr, iC, h);
            i3 = h.a;
        }
        int i4 = iC;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzjk.a();
        }
        Object objZza = p0.zza();
        int i5 = i3 + i4;
        p0.f(objZza, bArr, i4, i5, h);
        p0.a(objZza);
        h.c = objZza;
        return i5;
    }

    static int g(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static int h(byte[] bArr, int i, H h) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return c(b, bArr, i2, h);
        }
        h.a = b;
        return i2;
    }

    static int i(byte[] bArr, int i, Tq8 tq8, H h) {
        C2182l0 c2182l0 = (C2182l0) tq8;
        int iH = h(bArr, i, h);
        int i2 = h.a + iH;
        while (iH < i2) {
            iH = h(bArr, iH, h);
            c2182l0.i(h.a);
        }
        if (iH == i2) {
            return iH;
        }
        throw zzjk.a();
    }

    static int j(byte[] bArr, int i, H h) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            h.b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & 127) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & 127) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        h.b = j2;
        return i3;
    }

    static long k(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    static double l(byte[] bArr, int i) {
        return Double.longBitsToDouble(k(bArr, i));
    }

    static int m(byte[] bArr, int i, H h) throws zzjk {
        int iH = h(bArr, i, h);
        int i2 = h.a;
        if (i2 < 0) {
            throw zzjk.b();
        }
        if (i2 == 0) {
            h.c = "";
            return iH;
        }
        h.c = new String(bArr, iH, i2, AbstractC2184m0.a);
        return iH + i2;
    }

    static float n(byte[] bArr, int i) {
        return Float.intBitsToFloat(g(bArr, i));
    }

    static int o(byte[] bArr, int i, H h) throws zzjk {
        int iH = h(bArr, i, h);
        int i2 = h.a;
        if (i2 < 0) {
            throw zzjk.b();
        }
        if (i2 == 0) {
            h.c = "";
            return iH;
        }
        h.c = k1.k(bArr, iH, i2);
        return iH + i2;
    }

    static int p(byte[] bArr, int i, H h) {
        int iH = h(bArr, i, h);
        int i2 = h.a;
        if (i2 < 0) {
            throw zzjk.b();
        }
        if (i2 > bArr.length - iH) {
            throw zzjk.a();
        }
        if (i2 == 0) {
            h.c = K.b;
            return iH;
        }
        h.c = K.E(bArr, iH, i2);
        return iH + i2;
    }
}
