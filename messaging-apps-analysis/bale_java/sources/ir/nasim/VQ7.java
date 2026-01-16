package ir.nasim;

import androidx.compose.ui.graphics.vector.VectorPainter;

/* loaded from: classes2.dex */
public abstract class VQ7 {
    public static final VectorPainter a(VectorPainter vectorPainter, long j, long j2, String str, AbstractC24975zX0 abstractC24975zX0, boolean z) {
        vectorPainter.y(j);
        vectorPainter.u(z);
        vectorPainter.v(abstractC24975zX0);
        vectorPainter.z(j2);
        vectorPainter.x(str);
        return vectorPainter;
    }

    private static final AbstractC24975zX0 b(long j, int i) {
        if (j != 16) {
            return AbstractC24975zX0.b.a(j, i);
        }
        return null;
    }

    public static final C14104hM2 c(C14104hM2 c14104hM2, SQ7 sq7) {
        int iB = sq7.B();
        for (int i = 0; i < iB; i++) {
            UQ7 uq7H = sq7.h(i);
            if (uq7H instanceof WQ7) {
                C12682f15 c12682f15 = new C12682f15();
                WQ7 wq7 = (WQ7) uq7H;
                c12682f15.k(wq7.j());
                c12682f15.l(wq7.o());
                c12682f15.j(wq7.i());
                c12682f15.h(wq7.f());
                c12682f15.i(wq7.h());
                c12682f15.m(wq7.t());
                c12682f15.n(wq7.v());
                c12682f15.r(wq7.C());
                c12682f15.o(wq7.x());
                c12682f15.p(wq7.A());
                c12682f15.q(wq7.B());
                c12682f15.u(wq7.I());
                c12682f15.s(wq7.E());
                c12682f15.t(wq7.F());
                c14104hM2.i(i, c12682f15);
            } else if (uq7H instanceof SQ7) {
                C14104hM2 c14104hM22 = new C14104hM2();
                SQ7 sq72 = (SQ7) uq7H;
                c14104hM22.p(sq72.j());
                c14104hM22.s(sq72.v());
                c14104hM22.t(sq72.x());
                c14104hM22.u(sq72.A());
                c14104hM22.v(sq72.C());
                c14104hM22.w(sq72.E());
                c14104hM22.q(sq72.o());
                c14104hM22.r(sq72.t());
                c14104hM22.o(sq72.i());
                c(c14104hM22, sq72);
                c14104hM2.i(i, c14104hM22);
            }
        }
        return c14104hM2;
    }

    public static final VectorPainter d(WH1 wh1, C12700f33 c12700f33, C14104hM2 c14104hM2) {
        long jE = e(wh1, c12700f33.f(), c12700f33.e());
        return a(new VectorPainter(c14104hM2), jE, f(jE, c12700f33.m(), c12700f33.l()), c12700f33.h(), b(c12700f33.k(), c12700f33.j()), c12700f33.d());
    }

    private static final long e(WH1 wh1, float f, float f2) {
        float fW1 = wh1.w1(f);
        float fW12 = wh1.w1(f2);
        return OD6.d((Float.floatToRawIntBits(fW1) << 32) | (Float.floatToRawIntBits(fW12) & 4294967295L));
    }

    private static final long f(long j, float f, float f2) {
        if (Float.isNaN(f)) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if (Float.isNaN(f2)) {
            f2 = Float.intBitsToFloat((int) (j & 4294967295L));
        }
        return OD6.d((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
    }

    public static final VectorPainter g(C12700f33 c12700f33, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1413834416, i, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:169)");
        }
        WH1 wh1 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
        float fG = c12700f33.g();
        float density = wh1.getDensity();
        boolean zF = interfaceC22053ub1.f((Float.floatToRawIntBits(density) & 4294967295L) | (Float.floatToRawIntBits(fG) << 32));
        Object objB = interfaceC22053ub1.B();
        if (zF || objB == InterfaceC22053ub1.a.a()) {
            C14104hM2 c14104hM2 = new C14104hM2();
            c(c14104hM2, c12700f33.i());
            C19938rB7 c19938rB7 = C19938rB7.a;
            objB = d(wh1, c12700f33, c14104hM2);
            interfaceC22053ub1.s(objB);
        }
        VectorPainter vectorPainter = (VectorPainter) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return vectorPainter;
    }
}
