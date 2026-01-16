package ir.nasim;

import ir.nasim.AbstractC4754Gk4;
import ir.nasim.InterfaceC22148uk6;

/* loaded from: classes2.dex */
final class NQ7 implements InterfaceC24514yk6 {
    private final long[] a;
    private final long[] b;
    private final long c;
    private final long d;

    private NQ7(long[] jArr, long[] jArr2, long j, long j2) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j;
        this.d = j2;
    }

    public static NQ7 a(long j, long j2, AbstractC4754Gk4.a aVar, EW4 ew4) {
        int iF;
        ew4.T(10);
        int iO = ew4.o();
        if (iO <= 0) {
            return null;
        }
        int i = aVar.d;
        long jN0 = AbstractC9683aN7.N0(iO, (i >= 32000 ? 1152 : 576) * 1000000, i);
        int iL = ew4.L();
        int iL2 = ew4.L();
        int iL3 = ew4.L();
        ew4.T(2);
        long j3 = j2 + aVar.c;
        long[] jArr = new long[iL];
        long[] jArr2 = new long[iL];
        int i2 = 0;
        long j4 = j2;
        while (i2 < iL) {
            int i3 = iL2;
            long j5 = j3;
            jArr[i2] = (i2 * jN0) / iL;
            jArr2[i2] = Math.max(j4, j5);
            if (iL3 == 1) {
                iF = ew4.F();
            } else if (iL3 == 2) {
                iF = ew4.L();
            } else if (iL3 == 3) {
                iF = ew4.I();
            } else {
                if (iL3 != 4) {
                    return null;
                }
                iF = ew4.J();
            }
            j4 += iF * i3;
            i2++;
            jArr = jArr;
            iL2 = i3;
            j3 = j5;
        }
        long[] jArr3 = jArr;
        if (j != -1 && j != j4) {
            AbstractC18815pI3.k("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new NQ7(jArr3, jArr2, jN0, j4);
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public InterfaceC22148uk6.a c(long j) {
        int i = AbstractC9683aN7.i(this.a, j, true, true);
        C23334wk6 c23334wk6 = new C23334wk6(this.a[i], this.b[i]);
        if (c23334wk6.a >= j || i == this.a.length - 1) {
            return new InterfaceC22148uk6.a(c23334wk6);
        }
        int i2 = i + 1;
        return new InterfaceC22148uk6.a(c23334wk6, new C23334wk6(this.a[i2], this.b[i2]));
    }

    @Override // ir.nasim.InterfaceC24514yk6
    public long f() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public boolean g() {
        return true;
    }

    @Override // ir.nasim.InterfaceC24514yk6
    public long h(long j) {
        return this.a[AbstractC9683aN7.i(this.b, j, true, true)];
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public long i() {
        return this.c;
    }
}
