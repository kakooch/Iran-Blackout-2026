package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.Ia3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5131Ia3 {
    public int[] a = new int[10];
    public int b;

    private final int[] i() {
        int[] iArr = this.a;
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
        AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
        this.a = iArrCopyOf;
        return iArrCopyOf;
    }

    public final void a() {
        this.b = 0;
    }

    public final int b(int i) {
        int[] iArr = this.a;
        int iMin = Math.min(iArr.length, this.b);
        for (int i2 = 0; i2 < iMin; i2++) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public final int c() {
        return this.a[this.b - 1];
    }

    public final int d(int i) {
        return this.a[i];
    }

    public final int e() {
        return this.a[this.b - 2];
    }

    public final int f(int i) {
        int i2 = this.b - 1;
        return i2 >= 0 ? this.a[i2] : i;
    }

    public final int g() {
        int[] iArr = this.a;
        int i = this.b - 1;
        this.b = i;
        return iArr[i];
    }

    public final void h(int i) {
        int[] iArrI = this.a;
        if (this.b >= iArrI.length) {
            iArrI = i();
        }
        int i2 = this.b;
        this.b = i2 + 1;
        iArrI[i2] = i;
    }
}
