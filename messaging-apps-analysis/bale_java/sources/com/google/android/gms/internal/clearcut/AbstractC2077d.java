package com.google.android.gms.internal.clearcut;

import ir.nasim.AbstractC18350oW3;
import ir.nasim.InterfaceC25120zl8;

/* renamed from: com.google.android.gms.internal.clearcut.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2077d {
    static int a(int i, byte[] bArr, int i2, int i3, C2079e c2079e) {
        if ((i >>> 3) == 0) {
            throw zzco.b();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return g(bArr, i2, c2079e);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return e(bArr, i2, c2079e) + c2079e.a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzco.b();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = e(bArr, i2, c2079e);
            i6 = c2079e.a;
            if (i6 == i5) {
                break;
            }
            i2 = a(i6, bArr, i2, i3, c2079e);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzco.d();
        }
        return i2;
    }

    static int b(int i, byte[] bArr, int i2, int i3, m0 m0Var, C2079e c2079e) throws zzco {
        if ((i >>> 3) == 0) {
            throw zzco.b();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iG = g(bArr, i2, c2079e);
            m0Var.e(i, Long.valueOf(c2079e.b));
            return iG;
        }
        if (i4 == 1) {
            m0Var.e(i, Long.valueOf(k(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iE = e(bArr, i2, c2079e);
            int i5 = c2079e.a;
            m0Var.e(i, i5 == 0 ? AbstractC2081f.b : AbstractC2081f.F(bArr, iE, i5));
            return iE + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzco.b();
            }
            m0Var.e(i, Integer.valueOf(h(bArr, i2)));
            return i2 + 4;
        }
        m0 m0VarI = m0.i();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iE2 = e(bArr, i2, c2079e);
            int i8 = c2079e.a;
            i7 = i8;
            if (i8 == i6) {
                i2 = iE2;
                break;
            }
            int iB = b(i7, bArr, iE2, i3, m0VarI, c2079e);
            i7 = i8;
            i2 = iB;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzco.d();
        }
        m0Var.e(i, m0VarI);
        return i2;
    }

    static int c(int i, byte[] bArr, int i2, int i3, InterfaceC25120zl8 interfaceC25120zl8, C2079e c2079e) {
        AbstractC18350oW3.a(interfaceC25120zl8);
        e(bArr, i2, c2079e);
        int i4 = c2079e.a;
        throw null;
    }

    static int d(int i, byte[] bArr, int i2, C2079e c2079e) {
        int i3;
        int i4 = i & 127;
        int i5 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            i3 = b << 7;
        } else {
            int i6 = i4 | ((b & 127) << 7);
            int i7 = i2 + 2;
            byte b2 = bArr[i5];
            if (b2 >= 0) {
                c2079e.a = i6 | (b2 << 14);
                return i7;
            }
            i4 = i6 | ((b2 & 127) << 14);
            i5 = i2 + 3;
            byte b3 = bArr[i7];
            if (b3 >= 0) {
                i3 = b3 << 21;
            } else {
                int i8 = i4 | ((b3 & 127) << 21);
                int i9 = i2 + 4;
                byte b4 = bArr[i5];
                if (b4 >= 0) {
                    c2079e.a = i8 | (b4 << 28);
                    return i9;
                }
                int i10 = i8 | ((b4 & 127) << 28);
                while (true) {
                    int i11 = i9 + 1;
                    if (bArr[i9] >= 0) {
                        c2079e.a = i10;
                        return i11;
                    }
                    i9 = i11;
                }
            }
        }
        c2079e.a = i4 | i3;
        return i5;
    }

    static int e(byte[] bArr, int i, C2079e c2079e) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return d(b, bArr, i2, c2079e);
        }
        c2079e.a = b;
        return i2;
    }

    static int f(byte[] bArr, int i, InterfaceC25120zl8 interfaceC25120zl8, C2079e c2079e) {
        AbstractC18350oW3.a(interfaceC25120zl8);
        int iE = e(bArr, i, c2079e);
        int i2 = c2079e.a + iE;
        if (iE < i2) {
            e(bArr, iE, c2079e);
            throw null;
        }
        if (iE == i2) {
            return iE;
        }
        throw zzco.a();
    }

    static int g(byte[] bArr, int i, C2079e c2079e) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            c2079e.b = j;
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
        c2079e.b = j2;
        return i3;
    }

    static int h(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static int i(byte[] bArr, int i, C2079e c2079e) {
        int iE = e(bArr, i, c2079e);
        int i2 = c2079e.a;
        if (i2 == 0) {
            c2079e.c = "";
            return iE;
        }
        c2079e.c = new String(bArr, iE, i2, B.a);
        return iE + i2;
    }

    static int j(byte[] bArr, int i, C2079e c2079e) throws zzco {
        int iE = e(bArr, i, c2079e);
        int i2 = c2079e.a;
        if (i2 == 0) {
            c2079e.c = "";
            return iE;
        }
        int i3 = iE + i2;
        if (!q0.i(bArr, iE, i3)) {
            throw zzco.e();
        }
        c2079e.c = new String(bArr, iE, i2, B.a);
        return i3;
    }

    static long k(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    static double l(byte[] bArr, int i) {
        return Double.longBitsToDouble(k(bArr, i));
    }

    static int m(byte[] bArr, int i, C2079e c2079e) {
        int iE = e(bArr, i, c2079e);
        int i2 = c2079e.a;
        if (i2 == 0) {
            c2079e.c = AbstractC2081f.b;
            return iE;
        }
        c2079e.c = AbstractC2081f.F(bArr, iE, i2);
        return iE + i2;
    }

    static float n(byte[] bArr, int i) {
        return Float.intBitsToFloat(h(bArr, i));
    }
}
