package ir.nasim;

import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* loaded from: classes3.dex */
public final class YK5 {
    private final UE2 a;

    public YK5(UE2 ue2) {
        this.a = ue2;
    }

    private int[] b(VE2 ve2) throws ReedSolomonException {
        int iF = ve2.f();
        if (iF == 1) {
            return new int[]{ve2.d(1)};
        }
        int[] iArr = new int[iF];
        int i = 0;
        for (int i2 = 1; i2 < this.a.f() && i < iF; i2++) {
            if (ve2.c(i2) == 0) {
                iArr[i] = this.a.h(i2);
                i++;
            }
        }
        if (i == iF) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] c(VE2 ve2, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int iH = this.a.h(iArr[i]);
            int iJ = 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (i != i2) {
                    int iJ2 = this.a.j(iArr[i2], iH);
                    iJ = this.a.j(iJ, (iJ2 & 1) == 0 ? iJ2 | 1 : iJ2 & (-2));
                }
            }
            iArr2[i] = this.a.j(ve2.c(iH), this.a.h(iJ));
            if (this.a.d() != 0) {
                iArr2[i] = this.a.j(iArr2[i], iH);
            }
        }
        return iArr2;
    }

    private VE2[] d(VE2 ve2, VE2 ve22, int i) throws ReedSolomonException {
        if (ve2.f() < ve22.f()) {
            ve22 = ve2;
            ve2 = ve22;
        }
        VE2 ve2G = this.a.g();
        VE2 ve2E = this.a.e();
        do {
            VE2 ve23 = ve22;
            ve22 = ve2;
            ve2 = ve23;
            VE2 ve24 = ve2E;
            VE2 ve25 = ve2G;
            ve2G = ve24;
            if (ve2.f() < i / 2) {
                int iD = ve2G.d(0);
                if (iD == 0) {
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
                int iH = this.a.h(iD);
                return new VE2[]{ve2G.h(iH), ve2.h(iH)};
            }
            if (ve2.g()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            VE2 ve2G2 = this.a.g();
            int iH2 = this.a.h(ve2.d(ve2.f()));
            while (ve22.f() >= ve2.f() && !ve22.g()) {
                int iF = ve22.f() - ve2.f();
                int iJ = this.a.j(ve22.d(ve22.f()), iH2);
                ve2G2 = ve2G2.a(this.a.b(iF, iJ));
                ve22 = ve22.a(ve2.j(iF, iJ));
            }
            ve2E = ve2G2.i(ve2G).a(ve25);
        } while (ve22.f() < ve2.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    public void a(int[] iArr, int i) throws ReedSolomonException {
        VE2 ve2 = new VE2(this.a, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            UE2 ue2 = this.a;
            int iC = ve2.c(ue2.c(ue2.d() + i2));
            iArr2[(i - 1) - i2] = iC;
            if (iC != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        VE2[] ve2ArrD = d(this.a.b(i, 1), new VE2(this.a, iArr2), i);
        VE2 ve22 = ve2ArrD[0];
        VE2 ve23 = ve2ArrD[1];
        int[] iArrB = b(ve22);
        int[] iArrC = c(ve23, iArrB);
        for (int i3 = 0; i3 < iArrB.length; i3++) {
            int length = (iArr.length - 1) - this.a.i(iArrB[i3]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = UE2.a(iArr[length], iArrC[i3]);
        }
    }
}
