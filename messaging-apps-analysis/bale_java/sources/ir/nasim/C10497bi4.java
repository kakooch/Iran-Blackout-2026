package ir.nasim;

/* renamed from: ir.nasim.bi4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C10497bi4 {
    private final C9877ai4 a;
    private final int[] b;

    C10497bi4(C9877ai4 c9877ai4, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = c9877ai4;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    C10497bi4 a(C10497bi4 c10497bi4) {
        if (!this.a.equals(c10497bi4.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e()) {
            return c10497bi4;
        }
        if (c10497bi4.e()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = c10497bi4.b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = this.a.a(iArr2[i - length], iArr[i]);
        }
        return new C10497bi4(this.a, iArr3);
    }

    int b(int i) {
        if (i == 0) {
            return c(0);
        }
        if (i == 1) {
            int iA = 0;
            for (int i2 : this.b) {
                iA = this.a.a(iA, i2);
            }
            return iA;
        }
        int[] iArr = this.b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            C9877ai4 c9877ai4 = this.a;
            iA2 = c9877ai4.a(c9877ai4.i(i, iA2), this.b[i3]);
        }
        return iA2;
    }

    int c(int i) {
        return this.b[(r0.length - 1) - i];
    }

    int d() {
        return this.b.length - 1;
    }

    boolean e() {
        return this.b[0] == 0;
    }

    C10497bi4 f(int i) {
        if (i == 0) {
            return this.a.f();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.i(this.b[i2], i);
        }
        return new C10497bi4(this.a, iArr);
    }

    C10497bi4 g(C10497bi4 c10497bi4) {
        if (!this.a.equals(c10497bi4.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (e() || c10497bi4.e()) {
            return this.a.f();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = c10497bi4.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                C9877ai4 c9877ai4 = this.a;
                iArr3[i4] = c9877ai4.a(iArr3[i4], c9877ai4.i(i2, iArr2[i3]));
            }
        }
        return new C10497bi4(this.a, iArr3);
    }

    C10497bi4 h(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.a.f();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.i(this.b[i3], i2);
        }
        return new C10497bi4(this.a, iArr);
    }

    C10497bi4 i() {
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.a.j(0, this.b[i]);
        }
        return new C10497bi4(this.a, iArr);
    }

    C10497bi4 j(C10497bi4 c10497bi4) {
        if (this.a.equals(c10497bi4.a)) {
            return c10497bi4.e() ? this : a(c10497bi4.i());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int iD = d(); iD >= 0; iD--) {
            int iC = c(iD);
            if (iC != 0) {
                if (iC < 0) {
                    sb.append(" - ");
                    iC = -iC;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iD == 0 || iC != 1) {
                    sb.append(iC);
                }
                if (iD != 0) {
                    if (iD == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iD);
                    }
                }
            }
        }
        return sb.toString();
    }
}
