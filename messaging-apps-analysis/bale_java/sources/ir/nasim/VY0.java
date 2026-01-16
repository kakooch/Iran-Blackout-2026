package ir.nasim;

/* loaded from: classes.dex */
public abstract class VY0 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(a.e);

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UY0 invoke() {
            return VY0.h(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 4095, null);
        }
    }

    public static final long a(UY0 uy0, long j) {
        return C24381yX0.q(j, uy0.j()) ? uy0.g() : C24381yX0.q(j, uy0.k()) ? uy0.g() : C24381yX0.q(j, uy0.l()) ? uy0.h() : C24381yX0.q(j, uy0.m()) ? uy0.h() : C24381yX0.q(j, uy0.c()) ? uy0.e() : C24381yX0.q(j, uy0.n()) ? uy0.i() : C24381yX0.q(j, uy0.d()) ? uy0.f() : C24381yX0.b.i();
    }

    public static final long b(long j, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(441849991, i, -1, "androidx.compose.material.contentColorFor (Colors.kt:311)");
        }
        interfaceC22053ub1.W(-702388415);
        long jA = a(C15977kV3.a.a(interfaceC22053ub1, 6), j);
        if (jA == 16) {
            jA = ((C24381yX0) interfaceC22053ub1.H(AbstractC20866sk1.a())).y();
        }
        interfaceC22053ub1.Q();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return jA;
    }

    public static final UY0 c(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new UY0(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, false, null);
    }

    public static /* synthetic */ UY0 d(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long jD = (i & 1) != 0 ? DX0.d(4290479868L) : j;
        long jD2 = (i & 2) != 0 ? DX0.d(4281794739L) : j2;
        long jD3 = (i & 4) != 0 ? DX0.d(4278442694L) : j3;
        return c(jD, jD2, jD3, (i & 8) != 0 ? jD3 : j4, (i & 16) != 0 ? DX0.d(4279374354L) : j5, (i & 32) != 0 ? DX0.d(4279374354L) : j6, (i & 64) != 0 ? DX0.d(4291782265L) : j7, (i & 128) != 0 ? C24381yX0.b.a() : j8, (i & 256) != 0 ? C24381yX0.b.a() : j9, (i & 512) != 0 ? C24381yX0.b.j() : j10, (i & 1024) != 0 ? C24381yX0.b.j() : j11, (i & 2048) != 0 ? C24381yX0.b.a() : j12);
    }

    public static final AbstractC6535Nx5 e() {
        return a;
    }

    public static final long f(UY0 uy0) {
        return uy0.o() ? uy0.j() : uy0.n();
    }

    public static final UY0 g(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new UY0(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, true, null);
    }

    public static /* synthetic */ UY0 h(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        return g((i & 1) != 0 ? DX0.d(4284612846L) : j, (i & 2) != 0 ? DX0.d(4281794739L) : j2, (i & 4) != 0 ? DX0.d(4278442694L) : j3, (i & 8) != 0 ? DX0.d(4278290310L) : j4, (i & 16) != 0 ? C24381yX0.b.j() : j5, (i & 32) != 0 ? C24381yX0.b.j() : j6, (i & 64) != 0 ? DX0.d(4289724448L) : j7, (i & 128) != 0 ? C24381yX0.b.j() : j8, (i & 256) != 0 ? C24381yX0.b.a() : j9, (i & 512) != 0 ? C24381yX0.b.a() : j10, (i & 1024) != 0 ? C24381yX0.b.a() : j11, (i & 2048) != 0 ? C24381yX0.b.j() : j12);
    }

    public static final void i(UY0 uy0, UY0 uy02) {
        uy0.x(uy02.j());
        uy0.y(uy02.k());
        uy0.z(uy02.l());
        uy0.A(uy02.m());
        uy0.p(uy02.c());
        uy0.B(uy02.n());
        uy0.q(uy02.d());
        uy0.u(uy02.g());
        uy0.v(uy02.h());
        uy0.s(uy02.e());
        uy0.w(uy02.i());
        uy0.t(uy02.f());
        uy0.r(uy02.o());
    }
}
