package ir.nasim;

import com.google.zxing.FormatException;

/* renamed from: ir.nasim.Jf0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C5407Jf0 {
    private final C4705Gf0 a;
    private final C4705Gf0 b;
    private final XR7 c;

    C5407Jf0(C4705Gf0 c4705Gf0) throws FormatException {
        int i = c4705Gf0.i();
        if (i < 8 || i > 144 || (i & 1) != 0) {
            throw FormatException.a();
        }
        this.c = j(c4705Gf0);
        C4705Gf0 c4705Gf0A = a(c4705Gf0);
        this.a = c4705Gf0A;
        this.b = new C4705Gf0(c4705Gf0A.m(), c4705Gf0A.i());
    }

    private C4705Gf0 a(C4705Gf0 c4705Gf0) {
        int iF = this.c.f();
        int iE = this.c.e();
        if (c4705Gf0.i() != iF) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int iC = this.c.c();
        int iB = this.c.b();
        int i = iF / iC;
        int i2 = iE / iB;
        C4705Gf0 c4705Gf02 = new C4705Gf0(i2 * iB, i * iC);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * iC;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * iB;
                for (int i7 = 0; i7 < iC; i7++) {
                    int i8 = ((iC + 2) * i3) + 1 + i7;
                    int i9 = i4 + i7;
                    for (int i10 = 0; i10 < iB; i10++) {
                        if (c4705Gf0.e(((iB + 2) * i5) + 1 + i10, i8)) {
                            c4705Gf02.o(i6 + i10, i9);
                        }
                    }
                }
            }
        }
        return c4705Gf02;
    }

    private int d(int i, int i2) {
        int i3 = i - 1;
        int i4 = (h(i3, 0, i, i2) ? 1 : 0) << 1;
        if (h(i3, 1, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(i3, 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i2 - 2, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 1;
        if (h(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (h(1, i8, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(2, i8, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return h(3, i8, i, i2) ? i11 | 1 : i11;
    }

    private int e(int i, int i2) {
        int i3 = (h(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (h(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (h(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i2 - 1;
        if (h(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        return h(1, i9, i, i2) ? i10 | 1 : i10;
    }

    private int f(int i, int i2) {
        int i3 = i - 1;
        int i4 = (h(i3, 0, i, i2) ? 1 : 0) << 1;
        int i5 = i2 - 1;
        if (h(i3, i5, i, i2)) {
            i4 |= 1;
        }
        int i6 = i4 << 1;
        int i7 = i2 - 3;
        if (h(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        int i9 = i2 - 2;
        if (h(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (h(0, i5, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(1, i7, i, i2)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(1, i9, i, i2)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return h(1, i5, i, i2) ? i13 | 1 : i13;
    }

    private int g(int i, int i2) {
        int i3 = (h(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (h(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (h(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        int i7 = i2 - 1;
        if (h(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        if (h(1, i7, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (h(2, i7, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        return h(3, i7, i, i2) ? i10 | 1 : i10;
    }

    private boolean h(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.b.o(i2, i);
        return this.a.e(i2, i);
    }

    private int i(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (h(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (h(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (h(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (h(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return h(i, i2, i3, i4) ? i15 | 1 : i15;
    }

    private static XR7 j(C4705Gf0 c4705Gf0) {
        return XR7.h(c4705Gf0.i(), c4705Gf0.m());
    }

    XR7 b() {
        return this.c;
    }

    byte[] c() throws FormatException {
        byte[] bArr = new byte[this.c.g()];
        int i = this.a.i();
        int iM = this.a.m();
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i4 = 4;
        while (true) {
            if (i4 == i && i2 == 0 && !z) {
                bArr[i3] = (byte) d(i, iM);
                i4 -= 2;
                i2 += 2;
                i3++;
                z = true;
            } else {
                int i5 = i - 2;
                if (i4 == i5 && i2 == 0 && (iM & 3) != 0 && !z2) {
                    bArr[i3] = (byte) e(i, iM);
                    i4 -= 2;
                    i2 += 2;
                    i3++;
                    z2 = true;
                } else if (i4 == i + 4 && i2 == 2 && (iM & 7) == 0 && !z3) {
                    bArr[i3] = (byte) f(i, iM);
                    i4 -= 2;
                    i2 += 2;
                    i3++;
                    z3 = true;
                } else if (i4 == i5 && i2 == 0 && (iM & 7) == 4 && !z4) {
                    bArr[i3] = (byte) g(i, iM);
                    i4 -= 2;
                    i2 += 2;
                    i3++;
                    z4 = true;
                } else {
                    while (true) {
                        if (i4 < i && i2 >= 0 && !this.b.e(i2, i4)) {
                            bArr[i3] = (byte) i(i4, i2, i, iM);
                            i3++;
                        }
                        int i6 = i4 - 2;
                        int i7 = i2 + 2;
                        if (i6 < 0 || i7 >= iM) {
                            break;
                        }
                        i4 = i6;
                        i2 = i7;
                    }
                    int i8 = i4 - 1;
                    int i9 = i2 + 5;
                    while (true) {
                        if (i8 >= 0 && i9 < iM && !this.b.e(i9, i8)) {
                            bArr[i3] = (byte) i(i8, i9, i, iM);
                            i3++;
                        }
                        int i10 = i8 + 2;
                        int i11 = i9 - 2;
                        if (i10 >= i || i11 < 0) {
                            break;
                        }
                        i8 = i10;
                        i9 = i11;
                    }
                    i4 = i8 + 5;
                    i2 = i9 - 1;
                }
            }
            if (i4 >= i && i2 >= iM) {
                break;
            }
        }
        if (i3 == this.c.g()) {
            return bArr;
        }
        throw FormatException.a();
    }
}
