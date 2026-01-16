package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.Ha3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C4897Ha3 {
    private int[] a;
    private int b;

    public C4897Ha3(int i) {
        this.a = new int[i];
    }

    private final boolean a(int i, int i2) {
        int[] iArr = this.a;
        int i3 = iArr[i];
        int i4 = iArr[i2];
        if (i3 >= i4) {
            return i3 == i4 && iArr[i + 1] <= iArr[i2 + 1];
        }
        return true;
    }

    private final int e(int i, int i2, int i3) {
        int i4 = i - i3;
        while (i < i2) {
            if (a(i, i2)) {
                i4 += i3;
                l(i4, i);
            }
            i += i3;
        }
        int i5 = i4 + i3;
        l(i5, i2);
        return i5;
    }

    private final void i(int i, int i2, int i3) {
        if (i < i2) {
            int iE = e(i, i2, i3);
            i(i, iE - i3, i3);
            i(iE + i3, i2, i3);
        }
    }

    private final int[] j(int[] iArr) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
        AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
        this.a = iArrCopyOf;
        return iArrCopyOf;
    }

    private final void l(int i, int i2) {
        int[] iArr = this.a;
        AbstractC5258Io4.i(iArr, i, i2);
        AbstractC5258Io4.i(iArr, i + 1, i2 + 1);
        AbstractC5258Io4.i(iArr, i + 2, i2 + 2);
    }

    public final int b(int i) {
        return this.a[i];
    }

    public final int c() {
        return this.b;
    }

    public final boolean d() {
        return this.b != 0;
    }

    public final int f() {
        int[] iArr = this.a;
        int i = this.b - 1;
        this.b = i;
        return iArr[i];
    }

    public final void g(int i, int i2, int i3) {
        int i4 = this.b;
        int[] iArrJ = this.a;
        int i5 = i4 + 3;
        if (i5 >= iArrJ.length) {
            iArrJ = j(iArrJ);
        }
        iArrJ[i4] = i + i3;
        iArrJ[i4 + 1] = i2 + i3;
        iArrJ[i4 + 2] = i3;
        this.b = i5;
    }

    public final void h(int i, int i2, int i3, int i4) {
        int i5 = this.b;
        int[] iArrJ = this.a;
        int i6 = i5 + 4;
        if (i6 >= iArrJ.length) {
            iArrJ = j(iArrJ);
        }
        iArrJ[i5] = i;
        iArrJ[i5 + 1] = i2;
        iArrJ[i5 + 2] = i3;
        iArrJ[i5 + 3] = i4;
        this.b = i6;
    }

    public final void k() {
        int i = this.b;
        if (!(i % 3 == 0)) {
            M73.b("Array size not a multiple of 3");
        }
        if (i > 3) {
            i(0, i - 3, 3);
        }
    }
}
