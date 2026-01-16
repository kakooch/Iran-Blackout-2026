package ir.nasim;

/* renamed from: ir.nasim.Io4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5258Io4 {
    private static final void b(C4897Ha3 c4897Ha3, InterfaceC21980uT1 interfaceC21980uT1) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < c4897Ha3.c()) {
            int i4 = i + 2;
            int iB = c4897Ha3.b(i) - c4897Ha3.b(i4);
            int iB2 = c4897Ha3.b(i + 1) - c4897Ha3.b(i4);
            int iB3 = c4897Ha3.b(i4);
            i += 3;
            while (i2 < iB) {
                interfaceC21980uT1.a(i3, i2);
                i2++;
            }
            while (i3 < iB2) {
                interfaceC21980uT1.c(i3);
                i3++;
            }
            while (true) {
                int i5 = iB3 - 1;
                if (iB3 > 0) {
                    interfaceC21980uT1.d(i2, i3);
                    i2++;
                    i3++;
                    iB3 = i5;
                }
            }
        }
    }

    private static final boolean c(int i, int i2, int i3, int i4, InterfaceC21980uT1 interfaceC21980uT1, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int iB;
        int i6;
        int i7;
        int i8 = (i2 - i) - (i4 - i3);
        boolean z = (i8 & 1) == 0;
        int i9 = -i5;
        for (int i10 = i9; i10 <= i5; i10 += 2) {
            if (i10 == i9 || (i10 != i5 && OH0.b(iArr2, i10 + 1) < OH0.b(iArr2, i10 - 1))) {
                iB = OH0.b(iArr2, i10 + 1);
                i6 = iB;
            } else {
                iB = OH0.b(iArr2, i10 - 1);
                i6 = iB - 1;
            }
            int i11 = i4 - ((i2 - i6) - i10);
            int i12 = ((i5 != 0 ? 1 : 0) & (i6 == iB ? 1 : 0)) + i11;
            while (i6 > i && i11 > i3) {
                if (!interfaceC21980uT1.b(i6 - 1, i11 - 1)) {
                    break;
                }
                i6--;
                i11--;
            }
            OH0.d(iArr2, i10, i6);
            if (z && (i7 = i8 - i10) >= i9 && i7 <= i5) {
                if (OH0.b(iArr, i7) >= i6) {
                    f(i6, i11, iB, i12, true, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    private static final C4897Ha3 d(int i, int i2, InterfaceC21980uT1 interfaceC21980uT1) {
        int i3 = ((i + i2) + 1) / 2;
        C4897Ha3 c4897Ha3 = new C4897Ha3(i3 * 3);
        C4897Ha3 c4897Ha32 = new C4897Ha3(i3 * 4);
        c4897Ha32.h(0, i, 0, i2);
        int i4 = (i3 * 2) + 1;
        int[] iArrA = OH0.a(new int[i4]);
        int[] iArrA2 = OH0.a(new int[i4]);
        int[] iArrB = AbstractC23644xG6.b(new int[5]);
        while (c4897Ha32.d()) {
            int iF = c4897Ha32.f();
            int iF2 = c4897Ha32.f();
            int iF3 = c4897Ha32.f();
            int iF4 = c4897Ha32.f();
            int[] iArr = iArrB;
            if (h(iF4, iF3, iF2, iF, interfaceC21980uT1, iArrA, iArrA2, iArr)) {
                if (Math.min(iArr[2] - iArr[0], iArr[3] - iArr[1]) > 0) {
                    AbstractC23644xG6.a(iArr, c4897Ha3);
                }
                c4897Ha32.h(iF4, iArr[0], iF2, iArr[1]);
                c4897Ha32.h(iArr[2], iF3, iArr[3], iF);
                iArrB = iArr;
            } else {
                iArrB = iArr;
            }
        }
        c4897Ha3.k();
        c4897Ha3.g(i, i2, 0);
        return c4897Ha3;
    }

    public static final void e(int i, int i2, InterfaceC21980uT1 interfaceC21980uT1) {
        b(d(i, i2, interfaceC21980uT1), interfaceC21980uT1);
    }

    public static final void f(int i, int i2, int i3, int i4, boolean z, int[] iArr) {
        if (iArr.length < 5) {
            return;
        }
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        iArr[4] = z ? 1 : 0;
    }

    private static final boolean g(int i, int i2, int i3, int i4, InterfaceC21980uT1 interfaceC21980uT1, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int iB;
        int i6;
        int i7;
        int i8 = (i2 - i) - (i4 - i3);
        boolean z = (Math.abs(i8) & 1) == 1;
        int i9 = -i5;
        for (int i10 = i9; i10 <= i5; i10 += 2) {
            if (i10 == i9 || (i10 != i5 && OH0.b(iArr, i10 + 1) > OH0.b(iArr, i10 - 1))) {
                iB = OH0.b(iArr, i10 + 1);
                i6 = iB;
            } else {
                iB = OH0.b(iArr, i10 - 1);
                i6 = iB + 1;
            }
            int i11 = (i3 + (i6 - i)) - i10;
            int i12 = i11 - ((i5 != 0 ? 1 : 0) & (i6 == iB ? 1 : 0));
            while (i6 < i2 && i11 < i4) {
                if (!interfaceC21980uT1.b(i6, i11)) {
                    break;
                }
                i6++;
                i11++;
            }
            OH0.d(iArr, i10, i6);
            if (z && (i7 = i8 - i10) >= i9 + 1 && i7 <= i5 - 1) {
                if (OH0.b(iArr2, i7) <= i6) {
                    f(iB, i12, i6, i11, false, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    private static final boolean h(int i, int i2, int i3, int i4, InterfaceC21980uT1 interfaceC21980uT1, int[] iArr, int[] iArr2, int[] iArr3) {
        int i5 = i2 - i;
        int i6 = i4 - i3;
        if (i5 >= 1 && i6 >= 1) {
            int i7 = ((i5 + i6) + 1) / 2;
            OH0.d(iArr, 1, i);
            OH0.d(iArr2, 1, i2);
            int i8 = 0;
            while (i8 < i7) {
                int i9 = i8;
                if (g(i, i2, i3, i4, interfaceC21980uT1, iArr, iArr2, i8, iArr3) || c(i, i2, i3, i4, interfaceC21980uT1, iArr, iArr2, i9, iArr3)) {
                    return true;
                }
                i8 = i9 + 1;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }
}
