package ir.nasim;

import ir.nasim.AbstractC4754Gk4;
import ir.nasim.InterfaceC22148uk6;

/* renamed from: ir.nasim.kc8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C16047kc8 implements InterfaceC24514yk6 {
    private final long a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;
    private final long[] f;

    private C16047kc8(long j, int i, long j2) {
        this(j, i, j2, -1L, null);
    }

    public static C16047kc8 a(long j, long j2, AbstractC4754Gk4.a aVar, EW4 ew4) {
        int iJ;
        int i = aVar.g;
        int i2 = aVar.d;
        int iO = ew4.o();
        if ((iO & 1) != 1 || (iJ = ew4.J()) == 0) {
            return null;
        }
        long jN0 = AbstractC9683aN7.N0(iJ, i * 1000000, i2);
        if ((iO & 6) != 6) {
            return new C16047kc8(j2, aVar.c, jN0);
        }
        long jH = ew4.H();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = ew4.F();
        }
        if (j != -1) {
            long j3 = j2 + jH;
            if (j != j3) {
                AbstractC18815pI3.k("XingSeeker", "XING data size mismatch: " + j + ", " + j3);
            }
        }
        return new C16047kc8(j2, aVar.c, jN0, jH, jArr);
    }

    private long b(int i) {
        return (this.c * i) / 100;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public InterfaceC22148uk6.a c(long j) {
        if (!g()) {
            return new InterfaceC22148uk6.a(new C23334wk6(0L, this.a + this.b));
        }
        long jQ = AbstractC9683aN7.q(j, 0L, this.c);
        double d = (jQ * 100.0d) / this.c;
        double d2 = 0.0d;
        if (d > 0.0d) {
            if (d >= 100.0d) {
                d2 = 256.0d;
            } else {
                int i = (int) d;
                double d3 = ((long[]) AbstractC20011rK.i(this.f))[i];
                d2 = d3 + ((d - i) * ((i == 99 ? 256.0d : r3[i + 1]) - d3));
            }
        }
        return new InterfaceC22148uk6.a(new C23334wk6(jQ, this.a + AbstractC9683aN7.q(Math.round((d2 / 256.0d) * this.d), this.b, this.d - 1)));
    }

    @Override // ir.nasim.InterfaceC24514yk6
    public long f() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public boolean g() {
        return this.f != null;
    }

    @Override // ir.nasim.InterfaceC24514yk6
    public long h(long j) {
        long j2 = j - this.a;
        if (!g() || j2 <= this.b) {
            return 0L;
        }
        long[] jArr = (long[]) AbstractC20011rK.i(this.f);
        double d = (j2 * 256.0d) / this.d;
        int i = AbstractC9683aN7.i(jArr, (long) d, true, true);
        long jB = b(i);
        long j3 = jArr[i];
        int i2 = i + 1;
        long jB2 = b(i2);
        return jB + Math.round((j3 == (i == 99 ? 256L : jArr[i2]) ? 0.0d : (d - j3) / (r0 - j3)) * (jB2 - jB));
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public long i() {
        return this.c;
    }

    private C16047kc8(long j, int i, long j2, long j3, long[] jArr) {
        this.a = j;
        this.b = i;
        this.c = j2;
        this.f = jArr;
        this.d = j3;
        this.e = j3 != -1 ? j + j3 : -1L;
    }
}
