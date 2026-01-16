package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC20943sr8;

/* renamed from: com.google.android.gms.internal.measurement.s0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2144s0 {
    static int a(byte[] bArr, int i, C2142r0 c2142r0) {
        int iJ = j(bArr, i, c2142r0);
        int i2 = c2142r0.a;
        if (i2 < 0) {
            throw zzkp.d();
        }
        if (i2 > bArr.length - iJ) {
            throw zzkp.f();
        }
        if (i2 == 0) {
            c2142r0.c = A0.b;
            return iJ;
        }
        c2142r0.c = A0.O(bArr, iJ, i2);
        return iJ + i2;
    }

    static int b(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static int c(o1 o1Var, byte[] bArr, int i, int i2, int i3, C2142r0 c2142r0) {
        Object objG = o1Var.g();
        int iN = n(objG, o1Var, bArr, i, i2, i3, c2142r0);
        o1Var.j(objG);
        c2142r0.c = objG;
        return iN;
    }

    static int d(o1 o1Var, byte[] bArr, int i, int i2, C2142r0 c2142r0) {
        Object objG = o1Var.g();
        int iO = o(objG, o1Var, bArr, i, i2, c2142r0);
        o1Var.j(objG);
        c2142r0.c = objG;
        return iO;
    }

    static int e(o1 o1Var, int i, byte[] bArr, int i2, int i3, InterfaceC20943sr8 interfaceC20943sr8, C2142r0 c2142r0) {
        int iD = d(o1Var, bArr, i2, i3, c2142r0);
        interfaceC20943sr8.add(c2142r0.c);
        while (iD < i3) {
            int iJ = j(bArr, iD, c2142r0);
            if (i != c2142r0.a) {
                break;
            }
            iD = d(o1Var, bArr, iJ, i3, c2142r0);
            interfaceC20943sr8.add(c2142r0.c);
        }
        return iD;
    }

    static int f(byte[] bArr, int i, InterfaceC20943sr8 interfaceC20943sr8, C2142r0 c2142r0) {
        Q0 q0 = (Q0) interfaceC20943sr8;
        int iJ = j(bArr, i, c2142r0);
        int i2 = c2142r0.a + iJ;
        while (iJ < i2) {
            iJ = j(bArr, iJ, c2142r0);
            q0.j(c2142r0.a);
        }
        if (iJ == i2) {
            return iJ;
        }
        throw zzkp.f();
    }

    static int g(byte[] bArr, int i, C2142r0 c2142r0) throws zzkp {
        int iJ = j(bArr, i, c2142r0);
        int i2 = c2142r0.a;
        if (i2 < 0) {
            throw zzkp.d();
        }
        if (i2 == 0) {
            c2142r0.c = "";
            return iJ;
        }
        c2142r0.c = new String(bArr, iJ, i2, R0.b);
        return iJ + i2;
    }

    static int h(byte[] bArr, int i, C2142r0 c2142r0) throws zzkp {
        int iJ = j(bArr, i, c2142r0);
        int i2 = c2142r0.a;
        if (i2 < 0) {
            throw zzkp.d();
        }
        if (i2 == 0) {
            c2142r0.c = "";
            return iJ;
        }
        c2142r0.c = E1.d(bArr, iJ, i2);
        return iJ + i2;
    }

    static int i(int i, byte[] bArr, int i2, int i3, t1 t1Var, C2142r0 c2142r0) {
        if ((i >>> 3) == 0) {
            throw zzkp.b();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iM = m(bArr, i2, c2142r0);
            t1Var.j(i, Long.valueOf(c2142r0.b));
            return iM;
        }
        if (i4 == 1) {
            t1Var.j(i, Long.valueOf(p(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iJ = j(bArr, i2, c2142r0);
            int i5 = c2142r0.a;
            if (i5 < 0) {
                throw zzkp.d();
            }
            if (i5 > bArr.length - iJ) {
                throw zzkp.f();
            }
            if (i5 == 0) {
                t1Var.j(i, A0.b);
            } else {
                t1Var.j(i, A0.O(bArr, iJ, i5));
            }
            return iJ + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzkp.b();
            }
            t1Var.j(i, Integer.valueOf(b(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        t1 t1VarF = t1.f();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iJ2 = j(bArr, i2, c2142r0);
            int i8 = c2142r0.a;
            if (i8 == i6) {
                i7 = i8;
                i2 = iJ2;
                break;
            }
            i7 = i8;
            i2 = i(i8, bArr, iJ2, i3, t1VarF, c2142r0);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzkp.e();
        }
        t1Var.j(i, t1VarF);
        return i2;
    }

    static int j(byte[] bArr, int i, C2142r0 c2142r0) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return k(b, bArr, i2, c2142r0);
        }
        c2142r0.a = b;
        return i2;
    }

    static int k(int i, byte[] bArr, int i2, C2142r0 c2142r0) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            c2142r0.a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            c2142r0.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            c2142r0.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            c2142r0.a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                c2142r0.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int l(int i, byte[] bArr, int i2, int i3, InterfaceC20943sr8 interfaceC20943sr8, C2142r0 c2142r0) {
        Q0 q0 = (Q0) interfaceC20943sr8;
        int iJ = j(bArr, i2, c2142r0);
        q0.j(c2142r0.a);
        while (iJ < i3) {
            int iJ2 = j(bArr, iJ, c2142r0);
            if (i != c2142r0.a) {
                break;
            }
            iJ = j(bArr, iJ2, c2142r0);
            q0.j(c2142r0.a);
        }
        return iJ;
    }

    static int m(byte[] bArr, int i, C2142r0 c2142r0) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            c2142r0.b = j;
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
        c2142r0.b = j2;
        return i3;
    }

    static int n(Object obj, o1 o1Var, byte[] bArr, int i, int i2, int i3, C2142r0 c2142r0) {
        int iJ = ((g1) o1Var).J(obj, bArr, i, i2, i3, c2142r0);
        c2142r0.c = obj;
        return iJ;
    }

    static int o(Object obj, o1 o1Var, byte[] bArr, int i, int i2, C2142r0 c2142r0) {
        int iK = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iK = k(i3, bArr, iK, c2142r0);
            i3 = c2142r0.a;
        }
        int i4 = iK;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzkp.f();
        }
        int i5 = i3 + i4;
        o1Var.n(obj, bArr, i4, i5, c2142r0);
        c2142r0.c = obj;
        return i5;
    }

    static long p(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }
}
