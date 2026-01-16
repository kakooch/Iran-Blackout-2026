package ir.nasim;

import ir.nasim.C24381yX0;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.sF0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20576sF0 implements InterfaceC17460n02 {
    private final a a = new a(null, null, null, 0, 15, null);
    private final YZ1 b = new b();
    private InterfaceC12969fU4 c;
    private InterfaceC12969fU4 d;

    /* renamed from: ir.nasim.sF0$a */
    public static final class a {
        private WH1 a;
        private EnumC12613eu3 b;
        private UE0 c;
        private long d;

        public /* synthetic */ a(WH1 wh1, EnumC12613eu3 enumC12613eu3, UE0 ue0, long j, ED1 ed1) {
            this(wh1, enumC12613eu3, ue0, j);
        }

        public final WH1 a() {
            return this.a;
        }

        public final EnumC12613eu3 b() {
            return this.b;
        }

        public final UE0 c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public final UE0 e() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b && AbstractC13042fc3.d(this.c, aVar.c) && OD6.f(this.d, aVar.d);
        }

        public final WH1 f() {
            return this.a;
        }

        public final EnumC12613eu3 g() {
            return this.b;
        }

        public final long h() {
            return this.d;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + OD6.j(this.d);
        }

        public final void i(UE0 ue0) {
            this.c = ue0;
        }

        public final void j(WH1 wh1) {
            this.a = wh1;
        }

        public final void k(EnumC12613eu3 enumC12613eu3) {
            this.b = enumC12613eu3;
        }

        public final void l(long j) {
            this.d = j;
        }

        public String toString() {
            return "DrawParams(density=" + this.a + ", layoutDirection=" + this.b + ", canvas=" + this.c + ", size=" + ((Object) OD6.l(this.d)) + ')';
        }

        private a(WH1 wh1, EnumC12613eu3 enumC12613eu3, UE0 ue0, long j) {
            this.a = wh1;
            this.b = enumC12613eu3;
            this.c = ue0;
            this.d = j;
        }

        public /* synthetic */ a(WH1 wh1, EnumC12613eu3 enumC12613eu3, UE0 ue0, long j, int i, ED1 ed1) {
            this((i & 1) != 0 ? ZZ1.a() : wh1, (i & 2) != 0 ? EnumC12613eu3.a : enumC12613eu3, (i & 4) != 0 ? C15757k72.a : ue0, (i & 8) != 0 ? OD6.b.b() : j, null);
        }
    }

    /* renamed from: ir.nasim.sF0$b */
    public static final class b implements YZ1 {
        private final InterfaceC19824r02 a = AbstractC21179tF0.b(this);
        private C21226tK2 b;

        b() {
        }

        @Override // ir.nasim.YZ1
        public void a(UE0 ue0) {
            C20576sF0.this.E().i(ue0);
        }

        @Override // ir.nasim.YZ1
        public InterfaceC19824r02 b() {
            return this.a;
        }

        @Override // ir.nasim.YZ1
        public void c(EnumC12613eu3 enumC12613eu3) {
            C20576sF0.this.E().k(enumC12613eu3);
        }

        @Override // ir.nasim.YZ1
        public long d() {
            return C20576sF0.this.E().h();
        }

        @Override // ir.nasim.YZ1
        public UE0 e() {
            return C20576sF0.this.E().e();
        }

        @Override // ir.nasim.YZ1
        public void f(WH1 wh1) {
            C20576sF0.this.E().j(wh1);
        }

        @Override // ir.nasim.YZ1
        public void g(long j) {
            C20576sF0.this.E().l(j);
        }

        @Override // ir.nasim.YZ1
        public WH1 getDensity() {
            return C20576sF0.this.E().f();
        }

        @Override // ir.nasim.YZ1
        public EnumC12613eu3 getLayoutDirection() {
            return C20576sF0.this.E().g();
        }

        @Override // ir.nasim.YZ1
        public void h(C21226tK2 c21226tK2) {
            this.b = c21226tK2;
        }

        @Override // ir.nasim.YZ1
        public C21226tK2 i() {
            return this.b;
        }
    }

    static /* synthetic */ InterfaceC12969fU4 C(C20576sF0 c20576sF0, AbstractC12520el0 abstractC12520el0, float f, float f2, int i, int i2, InterfaceC13909h15 interfaceC13909h15, float f3, AbstractC24975zX0 abstractC24975zX0, int i3, int i4, int i5, Object obj) {
        return c20576sF0.z(abstractC12520el0, f, f2, i, i2, interfaceC13909h15, f3, abstractC24975zX0, i3, (i5 & 512) != 0 ? InterfaceC17460n02.i0.b() : i4);
    }

    private final long F(long j, float f) {
        return f == 1.0f ? j : C24381yX0.o(j, C24381yX0.r(j) * f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    private final InterfaceC12969fU4 J() {
        InterfaceC12969fU4 interfaceC12969fU4 = this.c;
        if (interfaceC12969fU4 != null) {
            return interfaceC12969fU4;
        }
        InterfaceC12969fU4 interfaceC12969fU4A = AbstractC15587jq.a();
        interfaceC12969fU4A.v(VV4.a.a());
        this.c = interfaceC12969fU4A;
        return interfaceC12969fU4A;
    }

    private final InterfaceC12969fU4 M() {
        InterfaceC12969fU4 interfaceC12969fU4 = this.d;
        if (interfaceC12969fU4 != null) {
            return interfaceC12969fU4;
        }
        InterfaceC12969fU4 interfaceC12969fU4A = AbstractC15587jq.a();
        interfaceC12969fU4A.v(VV4.a.b());
        this.d = interfaceC12969fU4A;
        return interfaceC12969fU4A;
    }

    private final InterfaceC12969fU4 N(AbstractC18051o02 abstractC18051o02) {
        if (AbstractC13042fc3.d(abstractC18051o02, C8568Wn2.a)) {
            return J();
        }
        if (!(abstractC18051o02 instanceof C23815xZ6)) {
            throw new NoWhenBranchMatchedException();
        }
        InterfaceC12969fU4 interfaceC12969fU4M = M();
        C23815xZ6 c23815xZ6 = (C23815xZ6) abstractC18051o02;
        if (interfaceC12969fU4M.x() != c23815xZ6.f()) {
            interfaceC12969fU4M.w(c23815xZ6.f());
        }
        if (!AbstractC24405yZ6.e(interfaceC12969fU4M.i(), c23815xZ6.b())) {
            interfaceC12969fU4M.f(c23815xZ6.b());
        }
        if (interfaceC12969fU4M.n() != c23815xZ6.d()) {
            interfaceC12969fU4M.t(c23815xZ6.d());
        }
        if (!AZ6.e(interfaceC12969fU4M.m(), c23815xZ6.c())) {
            interfaceC12969fU4M.j(c23815xZ6.c());
        }
        interfaceC12969fU4M.l();
        c23815xZ6.e();
        if (!AbstractC13042fc3.d(null, null)) {
            c23815xZ6.e();
            interfaceC12969fU4M.s(null);
        }
        return interfaceC12969fU4M;
    }

    private final InterfaceC12969fU4 b(long j, AbstractC18051o02 abstractC18051o02, float f, AbstractC24975zX0 abstractC24975zX0, int i, int i2) {
        InterfaceC12969fU4 interfaceC12969fU4N = N(abstractC18051o02);
        long jF = F(j, f);
        if (!C24381yX0.q(interfaceC12969fU4N.d(), jF)) {
            interfaceC12969fU4N.k(jF);
        }
        if (interfaceC12969fU4N.r() != null) {
            interfaceC12969fU4N.q(null);
        }
        if (!AbstractC13042fc3.d(interfaceC12969fU4N.b(), abstractC24975zX0)) {
            interfaceC12969fU4N.e(abstractC24975zX0);
        }
        if (!AbstractC7094Qg0.E(interfaceC12969fU4N.o(), i)) {
            interfaceC12969fU4N.g(i);
        }
        if (!AbstractC17934no2.d(interfaceC12969fU4N.u(), i2)) {
            interfaceC12969fU4N.h(i2);
        }
        return interfaceC12969fU4N;
    }

    static /* synthetic */ InterfaceC12969fU4 h(C20576sF0 c20576sF0, long j, AbstractC18051o02 abstractC18051o02, float f, AbstractC24975zX0 abstractC24975zX0, int i, int i2, int i3, Object obj) {
        return c20576sF0.b(j, abstractC18051o02, f, abstractC24975zX0, i, (i3 & 32) != 0 ? InterfaceC17460n02.i0.b() : i2);
    }

    private final InterfaceC12969fU4 o(AbstractC12520el0 abstractC12520el0, AbstractC18051o02 abstractC18051o02, float f, AbstractC24975zX0 abstractC24975zX0, int i, int i2) {
        InterfaceC12969fU4 interfaceC12969fU4N = N(abstractC18051o02);
        if (abstractC12520el0 != null) {
            abstractC12520el0.a(d(), interfaceC12969fU4N, f);
        } else {
            if (interfaceC12969fU4N.r() != null) {
                interfaceC12969fU4N.q(null);
            }
            long jD = interfaceC12969fU4N.d();
            C24381yX0.a aVar = C24381yX0.b;
            if (!C24381yX0.q(jD, aVar.a())) {
                interfaceC12969fU4N.k(aVar.a());
            }
            if (interfaceC12969fU4N.a() != f) {
                interfaceC12969fU4N.c(f);
            }
        }
        if (!AbstractC13042fc3.d(interfaceC12969fU4N.b(), abstractC24975zX0)) {
            interfaceC12969fU4N.e(abstractC24975zX0);
        }
        if (!AbstractC7094Qg0.E(interfaceC12969fU4N.o(), i)) {
            interfaceC12969fU4N.g(i);
        }
        if (!AbstractC17934no2.d(interfaceC12969fU4N.u(), i2)) {
            interfaceC12969fU4N.h(i2);
        }
        return interfaceC12969fU4N;
    }

    static /* synthetic */ InterfaceC12969fU4 p(C20576sF0 c20576sF0, AbstractC12520el0 abstractC12520el0, AbstractC18051o02 abstractC18051o02, float f, AbstractC24975zX0 abstractC24975zX0, int i, int i2, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            i2 = InterfaceC17460n02.i0.b();
        }
        return c20576sF0.o(abstractC12520el0, abstractC18051o02, f, abstractC24975zX0, i, i2);
    }

    private final InterfaceC12969fU4 t(long j, float f, float f2, int i, int i2, InterfaceC13909h15 interfaceC13909h15, float f3, AbstractC24975zX0 abstractC24975zX0, int i3, int i4) {
        InterfaceC12969fU4 interfaceC12969fU4M = M();
        long jF = F(j, f3);
        if (!C24381yX0.q(interfaceC12969fU4M.d(), jF)) {
            interfaceC12969fU4M.k(jF);
        }
        if (interfaceC12969fU4M.r() != null) {
            interfaceC12969fU4M.q(null);
        }
        if (!AbstractC13042fc3.d(interfaceC12969fU4M.b(), abstractC24975zX0)) {
            interfaceC12969fU4M.e(abstractC24975zX0);
        }
        if (!AbstractC7094Qg0.E(interfaceC12969fU4M.o(), i3)) {
            interfaceC12969fU4M.g(i3);
        }
        if (interfaceC12969fU4M.x() != f) {
            interfaceC12969fU4M.w(f);
        }
        if (interfaceC12969fU4M.n() != f2) {
            interfaceC12969fU4M.t(f2);
        }
        if (!AbstractC24405yZ6.e(interfaceC12969fU4M.i(), i)) {
            interfaceC12969fU4M.f(i);
        }
        if (!AZ6.e(interfaceC12969fU4M.m(), i2)) {
            interfaceC12969fU4M.j(i2);
        }
        interfaceC12969fU4M.l();
        if (!AbstractC13042fc3.d(null, interfaceC13909h15)) {
            interfaceC12969fU4M.s(interfaceC13909h15);
        }
        if (!AbstractC17934no2.d(interfaceC12969fU4M.u(), i4)) {
            interfaceC12969fU4M.h(i4);
        }
        return interfaceC12969fU4M;
    }

    static /* synthetic */ InterfaceC12969fU4 u(C20576sF0 c20576sF0, long j, float f, float f2, int i, int i2, InterfaceC13909h15 interfaceC13909h15, float f3, AbstractC24975zX0 abstractC24975zX0, int i3, int i4, int i5, Object obj) {
        return c20576sF0.t(j, f, f2, i, i2, interfaceC13909h15, f3, abstractC24975zX0, i3, (i5 & 512) != 0 ? InterfaceC17460n02.i0.b() : i4);
    }

    private final InterfaceC12969fU4 z(AbstractC12520el0 abstractC12520el0, float f, float f2, int i, int i2, InterfaceC13909h15 interfaceC13909h15, float f3, AbstractC24975zX0 abstractC24975zX0, int i3, int i4) {
        InterfaceC12969fU4 interfaceC12969fU4M = M();
        if (abstractC12520el0 != null) {
            abstractC12520el0.a(d(), interfaceC12969fU4M, f3);
        } else if (interfaceC12969fU4M.a() != f3) {
            interfaceC12969fU4M.c(f3);
        }
        if (!AbstractC13042fc3.d(interfaceC12969fU4M.b(), abstractC24975zX0)) {
            interfaceC12969fU4M.e(abstractC24975zX0);
        }
        if (!AbstractC7094Qg0.E(interfaceC12969fU4M.o(), i3)) {
            interfaceC12969fU4M.g(i3);
        }
        if (interfaceC12969fU4M.x() != f) {
            interfaceC12969fU4M.w(f);
        }
        if (interfaceC12969fU4M.n() != f2) {
            interfaceC12969fU4M.t(f2);
        }
        if (!AbstractC24405yZ6.e(interfaceC12969fU4M.i(), i)) {
            interfaceC12969fU4M.f(i);
        }
        if (!AZ6.e(interfaceC12969fU4M.m(), i2)) {
            interfaceC12969fU4M.j(i2);
        }
        interfaceC12969fU4M.l();
        if (!AbstractC13042fc3.d(null, interfaceC13909h15)) {
            interfaceC12969fU4M.s(interfaceC13909h15);
        }
        if (!AbstractC17934no2.d(interfaceC12969fU4M.u(), i4)) {
            interfaceC12969fU4M.h(i4);
        }
        return interfaceC12969fU4M;
    }

    public final a E() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void K0(AbstractC12520el0 abstractC12520el0, long j, long j2, float f, int i, InterfaceC13909h15 interfaceC13909h15, float f2, AbstractC24975zX0 abstractC24975zX0, int i2) {
        this.a.e().u(j, j2, C(this, abstractC12520el0, f, 4.0f, i, AZ6.a.b(), interfaceC13909h15, f2, abstractC24975zX0, i2, 0, 512, null));
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void M0(Y03 y03, long j, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.e().x(y03, j, p(this, null, abstractC18051o02, f, abstractC24975zX0, i, 0, 32, null));
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void Q0(V05 v05, long j, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.e().f(v05, h(this, j, abstractC18051o02, f, abstractC24975zX0, i, 0, 32, null));
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void R(AbstractC12520el0 abstractC12520el0, long j, long j2, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        int i2 = (int) (j >> 32);
        int i3 = (int) (j & 4294967295L);
        this.a.e().t(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat(i2) + Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat(i3) + Float.intBitsToFloat((int) (j2 & 4294967295L)), p(this, abstractC12520el0, abstractC18051o02, f, abstractC24975zX0, i, 0, 32, null));
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void X(V05 v05, AbstractC12520el0 abstractC12520el0, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.e().f(v05, p(this, abstractC12520el0, abstractC18051o02, f, abstractC24975zX0, i, 0, 32, null));
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void a1(AbstractC12520el0 abstractC12520el0, float f, long j, float f2, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.e().w(j, f, p(this, abstractC12520el0, abstractC18051o02, f2, abstractC24975zX0, i, 0, 32, null));
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void c0(long j, long j2, long j3, float f, int i, InterfaceC13909h15 interfaceC13909h15, float f2, AbstractC24975zX0 abstractC24975zX0, int i2) {
        this.a.e().u(j2, j3, u(this, j, f, 4.0f, i, AZ6.a.b(), interfaceC13909h15, f2, abstractC24975zX0, i2, 0, 512, null));
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return this.a.f().getDensity();
    }

    @Override // ir.nasim.InterfaceC17460n02
    public EnumC12613eu3 getLayoutDirection() {
        return this.a.g();
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void m1(long j, long j2, long j3, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        int i2 = (int) (j2 >> 32);
        int i3 = (int) (j2 & 4294967295L);
        this.a.e().t(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat(i2) + Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat(i3) + Float.intBitsToFloat((int) (j3 & 4294967295L)), h(this, j, abstractC18051o02, f, abstractC24975zX0, i, 0, 32, null));
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void n1(long j, float f, long j2, float f2, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.e().w(j2, f, h(this, j, abstractC18051o02, f2, abstractC24975zX0, i, 0, 32, null));
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void r0(AbstractC12520el0 abstractC12520el0, long j, long j2, long j3, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        int i2 = (int) (j >> 32);
        int i3 = (int) (j & 4294967295L);
        this.a.e().v(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat(i2) + Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat(i3) + Float.intBitsToFloat((int) (j2 & 4294967295L)), Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), p(this, abstractC12520el0, abstractC18051o02, f, abstractC24975zX0, i, 0, 32, null));
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return this.a.f().t1();
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void v1(long j, long j2, long j3, long j4, AbstractC18051o02 abstractC18051o02, float f, AbstractC24975zX0 abstractC24975zX0, int i) {
        int i2 = (int) (j2 >> 32);
        int i3 = (int) (j2 & 4294967295L);
        this.a.e().v(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat(i2) + Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat(i3) + Float.intBitsToFloat((int) (j3 & 4294967295L)), Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)), h(this, j, abstractC18051o02, f, abstractC24975zX0, i, 0, 32, null));
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void x1(long j, float f, float f2, boolean z, long j2, long j3, float f3, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        int i2 = (int) (j2 >> 32);
        int i3 = (int) (j2 & 4294967295L);
        this.a.e().o(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3), Float.intBitsToFloat(i2) + Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat(i3) + Float.intBitsToFloat((int) (j3 & 4294967295L)), f, f2, z, h(this, j, abstractC18051o02, f3, abstractC24975zX0, i, 0, 32, null));
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void y1(Y03 y03, long j, long j2, long j3, long j4, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i, int i2) {
        this.a.e().h(y03, j, j2, j3, j4, o(null, abstractC18051o02, f, abstractC24975zX0, i, i2));
    }

    @Override // ir.nasim.InterfaceC17460n02
    public YZ1 z1() {
        return this.b;
    }
}
