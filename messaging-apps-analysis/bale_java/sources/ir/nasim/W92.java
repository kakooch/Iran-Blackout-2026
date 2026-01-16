package ir.nasim;

import com.google.zxing.ChecksumException;

/* loaded from: classes3.dex */
public final class W92 {
    private final C9877ai4 a = C9877ai4.f;

    private int[] b(C10497bi4 c10497bi4) throws ChecksumException {
        int iD = c10497bi4.d();
        int[] iArr = new int[iD];
        int i = 0;
        for (int i2 = 1; i2 < this.a.e() && i < iD; i2++) {
            if (c10497bi4.b(i2) == 0) {
                iArr[i] = this.a.g(i2);
                i++;
            }
        }
        if (i == iD) {
            return iArr;
        }
        throw ChecksumException.a();
    }

    private int[] c(C10497bi4 c10497bi4, C10497bi4 c10497bi42, int[] iArr) {
        int iD = c10497bi42.d();
        int[] iArr2 = new int[iD];
        for (int i = 1; i <= iD; i++) {
            iArr2[iD - i] = this.a.i(i, c10497bi42.c(i));
        }
        C10497bi4 c10497bi43 = new C10497bi4(this.a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iG = this.a.g(iArr[i2]);
            iArr3[i2] = this.a.i(this.a.j(0, c10497bi4.b(iG)), this.a.g(c10497bi43.b(iG)));
        }
        return iArr3;
    }

    private C10497bi4[] d(C10497bi4 c10497bi4, C10497bi4 c10497bi42, int i) throws ChecksumException {
        if (c10497bi4.d() < c10497bi42.d()) {
            c10497bi42 = c10497bi4;
            c10497bi4 = c10497bi42;
        }
        C10497bi4 c10497bi4F = this.a.f();
        C10497bi4 c10497bi4D = this.a.d();
        while (true) {
            C10497bi4 c10497bi43 = c10497bi42;
            c10497bi42 = c10497bi4;
            c10497bi4 = c10497bi43;
            C10497bi4 c10497bi44 = c10497bi4D;
            C10497bi4 c10497bi45 = c10497bi4F;
            c10497bi4F = c10497bi44;
            if (c10497bi4.d() < i / 2) {
                int iC = c10497bi4F.c(0);
                if (iC == 0) {
                    throw ChecksumException.a();
                }
                int iG = this.a.g(iC);
                return new C10497bi4[]{c10497bi4F.f(iG), c10497bi4.f(iG)};
            }
            if (c10497bi4.e()) {
                throw ChecksumException.a();
            }
            C10497bi4 c10497bi4F2 = this.a.f();
            int iG2 = this.a.g(c10497bi4.c(c10497bi4.d()));
            while (c10497bi42.d() >= c10497bi4.d() && !c10497bi42.e()) {
                int iD = c10497bi42.d() - c10497bi4.d();
                int i2 = this.a.i(c10497bi42.c(c10497bi42.d()), iG2);
                c10497bi4F2 = c10497bi4F2.a(this.a.b(iD, i2));
                c10497bi42 = c10497bi42.j(c10497bi4.h(iD, i2));
            }
            c10497bi4D = c10497bi4F2.g(c10497bi4F).j(c10497bi45).i();
        }
    }

    public int a(int[] iArr, int i, int[] iArr2) throws ChecksumException {
        C10497bi4 c10497bi4 = new C10497bi4(this.a, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int iB = c10497bi4.b(this.a.c(i2));
            iArr3[i - i2] = iB;
            if (iB != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        C10497bi4 c10497bi4D = this.a.d();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int iC = this.a.c((iArr.length - 1) - i3);
                C9877ai4 c9877ai4 = this.a;
                c10497bi4D = c10497bi4D.g(new C10497bi4(c9877ai4, new int[]{c9877ai4.j(0, iC), 1}));
            }
        }
        C10497bi4[] c10497bi4ArrD = d(this.a.b(i, 1), new C10497bi4(this.a, iArr3), i);
        C10497bi4 c10497bi42 = c10497bi4ArrD[0];
        C10497bi4 c10497bi43 = c10497bi4ArrD[1];
        int[] iArrB = b(c10497bi42);
        int[] iArrC = c(c10497bi43, c10497bi42, iArrB);
        for (int i4 = 0; i4 < iArrB.length; i4++) {
            int length = (iArr.length - 1) - this.a.h(iArrB[i4]);
            if (length < 0) {
                throw ChecksumException.a();
            }
            iArr[length] = this.a.j(iArr[length], iArrC[i4]);
        }
        return iArrB.length;
    }
}
