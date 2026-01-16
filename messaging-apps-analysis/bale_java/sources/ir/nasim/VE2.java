package ir.nasim;

/* loaded from: classes3.dex */
final class VE2 {
    private final UE2 a;
    private final int[] b;

    VE2(UE2 ue2, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = ue2;
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

    VE2 a(VE2 ve2) {
        if (!this.a.equals(ve2.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return ve2;
        }
        if (ve2.g()) {
            return this;
        }
        int[] iArr = this.b;
        int[] iArr2 = ve2.b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = UE2.a(iArr2[i - length], iArr[i]);
        }
        return new VE2(this.a, iArr3);
    }

    VE2[] b(VE2 ve2) {
        if (!this.a.equals(ve2.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (ve2.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        VE2 ve2G = this.a.g();
        int iH = this.a.h(ve2.d(ve2.f()));
        VE2 ve2A = this;
        while (ve2A.f() >= ve2.f() && !ve2A.g()) {
            int iF = ve2A.f() - ve2.f();
            int iJ = this.a.j(ve2A.d(ve2A.f()), iH);
            VE2 ve2J = ve2.j(iF, iJ);
            ve2G = ve2G.a(this.a.b(iF, iJ));
            ve2A = ve2A.a(ve2J);
        }
        return new VE2[]{ve2G, ve2A};
    }

    int c(int i) {
        if (i == 0) {
            return d(0);
        }
        if (i == 1) {
            int iA = 0;
            for (int i2 : this.b) {
                iA = UE2.a(iA, i2);
            }
            return iA;
        }
        int[] iArr = this.b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            iA2 = UE2.a(this.a.j(i, iA2), this.b[i3]);
        }
        return iA2;
    }

    int d(int i) {
        return this.b[(r0.length - 1) - i];
    }

    int[] e() {
        return this.b;
    }

    int f() {
        return this.b.length - 1;
    }

    boolean g() {
        return this.b[0] == 0;
    }

    VE2 h(int i) {
        if (i == 0) {
            return this.a.g();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.j(this.b[i2], i);
        }
        return new VE2(this.a, iArr);
    }

    VE2 i(VE2 ve2) {
        if (!this.a.equals(ve2.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || ve2.g()) {
            return this.a.g();
        }
        int[] iArr = this.b;
        int length = iArr.length;
        int[] iArr2 = ve2.b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = UE2.a(iArr3[i4], this.a.j(i2, iArr2[i3]));
            }
        }
        return new VE2(this.a, iArr3);
    }

    VE2 j(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.a.g();
        }
        int length = this.b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.j(this.b[i3], i2);
        }
        return new VE2(this.a, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(f() * 8);
        for (int iF = f(); iF >= 0; iF--) {
            int iD = d(iF);
            if (iD != 0) {
                if (iD < 0) {
                    sb.append(" - ");
                    iD = -iD;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iF == 0 || iD != 1) {
                    int i = this.a.i(iD);
                    if (i == 0) {
                        sb.append('1');
                    } else if (i == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i);
                    }
                }
                if (iF != 0) {
                    if (iF == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iF);
                    }
                }
            }
        }
        return sb.toString();
    }
}
