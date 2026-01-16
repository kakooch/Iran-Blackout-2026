package ir.nasim;

import ir.nasim.ZG4;

/* loaded from: classes2.dex */
public final class EJ3 implements InterfaceC11379cu3 {
    private final DJ3 a;

    public EJ3(DJ3 dj3) {
        this.a = dj3;
    }

    private final long d() {
        DJ3 dj3A = FJ3.a(this.a);
        InterfaceC11379cu3 interfaceC11379cu3K1 = dj3A.k1();
        ZG4.a aVar = ZG4.b;
        return ZG4.p(F(interfaceC11379cu3K1, aVar.c()), c().F(dj3A.e2(), aVar.c()));
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long F(InterfaceC11379cu3 interfaceC11379cu3, long j) {
        return P(interfaceC11379cu3, j, true);
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long M(long j) {
        return ZG4.q(c().M(j), d());
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public CK5 N(InterfaceC11379cu3 interfaceC11379cu3, boolean z) {
        return c().N(interfaceC11379cu3, z);
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long P(InterfaceC11379cu3 interfaceC11379cu3, long j, boolean z) {
        if (!(interfaceC11379cu3 instanceof EJ3)) {
            DJ3 dj3A = FJ3.a(this.a);
            long jP = P(dj3A.f2(), j, z);
            long jF1 = dj3A.F1();
            float fK = C22045ua3.k(jF1);
            float fL = C22045ua3.l(jF1);
            long jP2 = ZG4.p(jP, ZG4.e((4294967295L & Float.floatToRawIntBits(fL)) | (Float.floatToRawIntBits(fK) << 32)));
            InterfaceC11379cu3 interfaceC11379cu3G2 = dj3A.e2().G2();
            if (interfaceC11379cu3G2 == null) {
                interfaceC11379cu3G2 = dj3A.e2().k1();
            }
            return ZG4.q(jP2, interfaceC11379cu3G2.P(interfaceC11379cu3, ZG4.b.c(), z));
        }
        DJ3 dj3 = ((EJ3) interfaceC11379cu3).a;
        dj3.e2().a3();
        DJ3 dj3E2 = c().u2(dj3.e2()).E2();
        if (dj3E2 != null) {
            long jN = C22045ua3.n(C22045ua3.o(dj3.j2(dj3E2, !z), AbstractC22635va3.d(j)), this.a.j2(dj3E2, !z));
            float fK2 = C22045ua3.k(jN);
            float fL2 = C22045ua3.l(jN);
            return ZG4.e((Float.floatToRawIntBits(fK2) << 32) | (Float.floatToRawIntBits(fL2) & 4294967295L));
        }
        DJ3 dj3A2 = FJ3.a(dj3);
        long jO = C22045ua3.o(C22045ua3.o(dj3.j2(dj3A2, !z), dj3A2.F1()), AbstractC22635va3.d(j));
        DJ3 dj3A3 = FJ3.a(this.a);
        long jN2 = C22045ua3.n(jO, C22045ua3.o(this.a.j2(dj3A3, !z), dj3A3.F1()));
        float fK3 = C22045ua3.k(jN2);
        float fL3 = C22045ua3.l(jN2);
        long jE = ZG4.e((Float.floatToRawIntBits(fL3) & 4294967295L) | (Float.floatToRawIntBits(fK3) << 32));
        XA4 xa4L2 = dj3A3.e2().L2();
        AbstractC13042fc3.f(xa4L2);
        XA4 xa4L22 = dj3A2.e2().L2();
        AbstractC13042fc3.f(xa4L22);
        return xa4L2.P(xa4L22, jE, z);
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long a() {
        DJ3 dj3 = this.a;
        return C4414Fa3.c((dj3.P0() << 32) | (dj3.A0() & 4294967295L));
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long a0(long j) {
        return c().a0(ZG4.q(j, d()));
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public boolean b() {
        return c().b();
    }

    public final XA4 c() {
        return this.a.e2();
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public void g0(InterfaceC11379cu3 interfaceC11379cu3, float[] fArr) {
        c().g0(interfaceC11379cu3, fArr);
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public void h0(float[] fArr) {
        c().h0(fArr);
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public InterfaceC11379cu3 o0() {
        DJ3 dj3E2;
        if (!b()) {
            M73.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        XA4 xa4L2 = c().G1().w0().L2();
        if (xa4L2 == null || (dj3E2 = xa4L2.E2()) == null) {
            return null;
        }
        return dj3E2.k1();
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long p(long j) {
        return ZG4.q(c().p(j), d());
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long p0(long j) {
        return c().p0(ZG4.q(j, d()));
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long u(long j) {
        return c().u(ZG4.q(j, d()));
    }
}
