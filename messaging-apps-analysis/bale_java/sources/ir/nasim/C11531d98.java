package ir.nasim;

import com.google.zxing.NotFoundException;

/* renamed from: ir.nasim.d98, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C11531d98 {
    private final C4705Gf0 a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public C11531d98(C4705Gf0 c4705Gf0) {
        this(c4705Gf0, 10, c4705Gf0.m() / 2, c4705Gf0.i() / 2);
    }

    private C12092e16[] a(C12092e16 c12092e16, C12092e16 c12092e162, C12092e16 c12092e163, C12092e16 c12092e164) {
        float fC = c12092e16.c();
        float fD = c12092e16.d();
        float fC2 = c12092e162.c();
        float fD2 = c12092e162.d();
        float fC3 = c12092e163.c();
        float fD3 = c12092e163.d();
        float fC4 = c12092e164.c();
        float fD4 = c12092e164.d();
        return fC < ((float) this.c) / 2.0f ? new C12092e16[]{new C12092e16(fC4 - 1.0f, fD4 + 1.0f), new C12092e16(fC2 + 1.0f, fD2 + 1.0f), new C12092e16(fC3 - 1.0f, fD3 - 1.0f), new C12092e16(fC + 1.0f, fD - 1.0f)} : new C12092e16[]{new C12092e16(fC4 + 1.0f, fD4 + 1.0f), new C12092e16(fC2 + 1.0f, fD2 - 1.0f), new C12092e16(fC3 - 1.0f, fD3 + 1.0f), new C12092e16(fC - 1.0f, fD - 1.0f)};
    }

    private boolean b(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.a.e(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.a.e(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    private C12092e16 d(float f, float f2, float f3, float f4) {
        int iC = AbstractC23186wV3.c(AbstractC23186wV3.a(f, f2, f3, f4));
        float f5 = iC;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < iC; i++) {
            float f8 = i;
            int iC2 = AbstractC23186wV3.c((f8 * f6) + f);
            int iC3 = AbstractC23186wV3.c((f8 * f7) + f2);
            if (this.a.e(iC2, iC3)) {
                return new C12092e16(iC2, iC3);
            }
        }
        return null;
    }

    public C12092e16[] c() throws NotFoundException {
        int i = this.d;
        int i2 = this.e;
        int i3 = this.g;
        int i4 = this.f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = true;
        while (z7) {
            boolean z8 = false;
            boolean zB = true;
            while (true) {
                if ((!zB && z2) || i2 >= this.c) {
                    break;
                }
                zB = b(i3, i4, i2, false);
                if (zB) {
                    i2++;
                    z2 = true;
                    z8 = true;
                } else if (!z2) {
                    i2++;
                }
            }
            if (i2 < this.c) {
                boolean zB2 = true;
                while (true) {
                    if ((!zB2 && z3) || i4 >= this.b) {
                        break;
                    }
                    zB2 = b(i, i2, i4, true);
                    if (zB2) {
                        i4++;
                        z3 = true;
                        z8 = true;
                    } else if (!z3) {
                        i4++;
                    }
                }
                if (i4 < this.b) {
                    boolean zB3 = true;
                    while (true) {
                        if ((!zB3 && z4) || i < 0) {
                            break;
                        }
                        zB3 = b(i3, i4, i, false);
                        if (zB3) {
                            i--;
                            z4 = true;
                            z8 = true;
                        } else if (!z4) {
                            i--;
                        }
                    }
                    if (i >= 0) {
                        z7 = z8;
                        boolean zB4 = true;
                        while (true) {
                            if ((!zB4 && z6) || i3 < 0) {
                                break;
                            }
                            zB4 = b(i, i2, i3, true);
                            if (zB4) {
                                i3--;
                                z7 = true;
                                z6 = true;
                            } else if (!z6) {
                                i3--;
                            }
                        }
                        if (i3 >= 0) {
                            if (z7) {
                                z5 = true;
                            }
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z || !z5) {
            throw NotFoundException.a();
        }
        int i5 = i2 - i;
        C12092e16 c12092e16D = null;
        C12092e16 c12092e16D2 = null;
        for (int i6 = 1; c12092e16D2 == null && i6 < i5; i6++) {
            c12092e16D2 = d(i, i4 - i6, i + i6, i4);
        }
        if (c12092e16D2 == null) {
            throw NotFoundException.a();
        }
        C12092e16 c12092e16D3 = null;
        for (int i7 = 1; c12092e16D3 == null && i7 < i5; i7++) {
            c12092e16D3 = d(i, i3 + i7, i + i7, i3);
        }
        if (c12092e16D3 == null) {
            throw NotFoundException.a();
        }
        C12092e16 c12092e16D4 = null;
        for (int i8 = 1; c12092e16D4 == null && i8 < i5; i8++) {
            c12092e16D4 = d(i2, i3 + i8, i2 - i8, i3);
        }
        if (c12092e16D4 == null) {
            throw NotFoundException.a();
        }
        for (int i9 = 1; c12092e16D == null && i9 < i5; i9++) {
            c12092e16D = d(i2, i4 - i9, i2 - i9, i4);
        }
        if (c12092e16D != null) {
            return a(c12092e16D, c12092e16D2, c12092e16D4, c12092e16D3);
        }
        throw NotFoundException.a();
    }

    public C11531d98(C4705Gf0 c4705Gf0, int i, int i2, int i3) throws NotFoundException {
        this.a = c4705Gf0;
        int i4 = c4705Gf0.i();
        this.b = i4;
        int iM = c4705Gf0.m();
        this.c = iM;
        int i5 = i / 2;
        int i6 = i2 - i5;
        this.d = i6;
        int i7 = i2 + i5;
        this.e = i7;
        int i8 = i3 - i5;
        this.g = i8;
        int i9 = i3 + i5;
        this.f = i9;
        if (i8 < 0 || i6 < 0 || i9 >= i4 || i7 >= iM) {
            throw NotFoundException.a();
        }
    }
}
