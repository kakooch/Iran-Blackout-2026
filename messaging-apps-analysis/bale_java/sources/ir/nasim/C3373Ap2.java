package ir.nasim;

import ir.nasim.C3846Cp2;
import ir.nasim.YX6;
import java.util.Arrays;

/* renamed from: ir.nasim.Ap2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C3373Ap2 extends YX6 {
    private C3846Cp2 n;
    private a o;

    /* renamed from: ir.nasim.Ap2$a */
    private static final class a implements InterfaceC15261jH4 {
        private C3846Cp2 a;
        private C3846Cp2.a b;
        private long c = -1;
        private long d = -1;

        public a(C3846Cp2 c3846Cp2, C3846Cp2.a aVar) {
            this.a = c3846Cp2;
            this.b = aVar;
        }

        @Override // ir.nasim.InterfaceC15261jH4
        public long a(InterfaceC9845af2 interfaceC9845af2) {
            long j = this.d;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.d = -1L;
            return j2;
        }

        @Override // ir.nasim.InterfaceC15261jH4
        public InterfaceC22148uk6 b() {
            AbstractC20011rK.g(this.c != -1);
            return new C3612Bp2(this.a, this.c);
        }

        @Override // ir.nasim.InterfaceC15261jH4
        public void c(long j) {
            long[] jArr = this.b.a;
            this.d = jArr[AbstractC9683aN7.i(jArr, j, true, true)];
        }

        public void d(long j) {
            this.c = j;
        }
    }

    C3373Ap2() {
    }

    private int n(EW4 ew4) {
        int i = (ew4.e()[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            ew4.T(4);
            ew4.M();
        }
        int iJ = AbstractC24560yp2.j(ew4, i);
        ew4.S(0);
        return iJ;
    }

    private static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(EW4 ew4) {
        return ew4.a() >= 5 && ew4.F() == 127 && ew4.H() == 1179402563;
    }

    @Override // ir.nasim.YX6
    protected long f(EW4 ew4) {
        if (o(ew4.e())) {
            return n(ew4);
        }
        return -1L;
    }

    @Override // ir.nasim.YX6
    protected boolean i(EW4 ew4, long j, YX6.b bVar) {
        byte[] bArrE = ew4.e();
        C3846Cp2 c3846Cp2 = this.n;
        if (c3846Cp2 == null) {
            C3846Cp2 c3846Cp22 = new C3846Cp2(bArrE, 17);
            this.n = c3846Cp22;
            bVar.a = c3846Cp22.g(Arrays.copyOfRange(bArrE, 9, ew4.g()), null);
            return true;
        }
        if ((bArrE[0] & 127) == 3) {
            C3846Cp2.a aVarG = AbstractC25154zp2.g(ew4);
            C3846Cp2 c3846Cp2B = c3846Cp2.b(aVarG);
            this.n = c3846Cp2B;
            this.o = new a(c3846Cp2B, aVarG);
            return true;
        }
        if (!o(bArrE)) {
            return true;
        }
        a aVar = this.o;
        if (aVar != null) {
            aVar.d(j);
            bVar.b = this.o;
        }
        AbstractC20011rK.e(bVar.a);
        return false;
    }

    @Override // ir.nasim.YX6
    protected void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }
}
