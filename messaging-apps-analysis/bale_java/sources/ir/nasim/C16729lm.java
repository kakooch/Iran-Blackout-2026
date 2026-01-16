package ir.nasim;

import com.google.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.lm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C16729lm {
    private final C4705Gf0 a;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final float g;
    private final List b = new ArrayList(5);
    private final int[] h = new int[3];

    C16729lm(C4705Gf0 c4705Gf0, int i, int i2, int i3, int i4, float f, InterfaceC12683f16 interfaceC12683f16) {
        this.a = c4705Gf0;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = f;
    }

    private static float a(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    private float b(int i, int i2, int i3, int i4) {
        C4705Gf0 c4705Gf0 = this.a;
        int i5 = c4705Gf0.i();
        int[] iArr = this.h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i6 = i;
        while (i6 >= 0 && c4705Gf0.e(i2, i6)) {
            int i7 = iArr[1];
            if (i7 > i3) {
                break;
            }
            iArr[1] = i7 + 1;
            i6--;
        }
        if (i6 >= 0 && iArr[1] <= i3) {
            while (i6 >= 0 && !c4705Gf0.e(i2, i6)) {
                int i8 = iArr[0];
                if (i8 > i3) {
                    break;
                }
                iArr[0] = i8 + 1;
                i6--;
            }
            if (iArr[0] > i3) {
                return Float.NaN;
            }
            int i9 = i + 1;
            while (i9 < i5 && c4705Gf0.e(i2, i9)) {
                int i10 = iArr[1];
                if (i10 > i3) {
                    break;
                }
                iArr[1] = i10 + 1;
                i9++;
            }
            if (i9 != i5 && iArr[1] <= i3) {
                while (i9 < i5 && !c4705Gf0.e(i2, i9)) {
                    int i11 = iArr[2];
                    if (i11 > i3) {
                        break;
                    }
                    iArr[2] = i11 + 1;
                    i9++;
                }
                int i12 = iArr[2];
                if (i12 <= i3 && Math.abs(((iArr[0] + iArr[1]) + i12) - i4) * 5 < i4 * 2 && d(iArr)) {
                    return a(iArr, i9);
                }
            }
        }
        return Float.NaN;
    }

    private boolean d(int[] iArr) {
        float f = this.g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    private C16138km e(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i2);
        float fB = b(i, (int) fA, iArr[1] * 2, i3);
        if (Float.isNaN(fB)) {
            return null;
        }
        float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (C16138km c16138km : this.b) {
            if (c16138km.f(f, fB, fA)) {
                return c16138km.g(fB, fA, f);
            }
        }
        this.b.add(new C16138km(fA, fB, f));
        return null;
    }

    C16138km c() throws NotFoundException {
        C16138km c16138kmE;
        C16138km c16138kmE2;
        int i = this.c;
        int i2 = this.f;
        int i3 = this.e + i;
        int i4 = this.d + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2)) + i4;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.a.e(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            while (i7 < i3) {
                if (!this.a.e(i7, i6)) {
                    if (i8 == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i8 != 2) {
                    i8++;
                    iArr[i8] = iArr[i8] + 1;
                } else {
                    if (d(iArr) && (c16138kmE2 = e(iArr, i6, i7)) != null) {
                        return c16138kmE2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i8 = 1;
                }
                i7++;
            }
            if (d(iArr) && (c16138kmE = e(iArr, i6, i3)) != null) {
                return c16138kmE;
            }
        }
        if (this.b.isEmpty()) {
            throw NotFoundException.a();
        }
        return (C16138km) this.b.get(0);
    }
}
