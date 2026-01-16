package ir.nasim;

import ir.nasim.AbstractC9998au2;
import ir.nasim.C4301En7;

/* renamed from: ir.nasim.Ny3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6542Ny3 {
    private final InterfaceC9102Ym4 A;
    private C3342Al7 a;
    private final OJ5 b;
    private final InterfaceC20600sH6 c;
    private final C11475d42 d = new C11475d42();
    private C8564Wm7 e;
    private final InterfaceC9102Ym4 f;
    private final InterfaceC9102Ym4 g;
    private InterfaceC11379cu3 h;
    private final InterfaceC9102Ym4 i;
    private C13245fu j;
    private final InterfaceC9102Ym4 k;
    private final InterfaceC9102Ym4 l;
    private final InterfaceC9102Ym4 m;
    private final InterfaceC9102Ym4 n;
    private final InterfaceC9102Ym4 o;
    private boolean p;
    private final InterfaceC9102Ym4 q;
    private final C9946ap3 r;
    private final InterfaceC9102Ym4 s;
    private final InterfaceC9102Ym4 t;
    private UA2 u;
    private final UA2 v;
    private final UA2 w;
    private final InterfaceC12969fU4 x;
    private long y;
    private final InterfaceC9102Ym4 z;

    /* renamed from: ir.nasim.Ny3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(int i) {
            C6542Ny3.this.r.d(i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((S33) obj).p());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ny3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(C23945xm7 c23945xm7) {
            String strH = c23945xm7.h();
            C13245fu c13245fuY = C6542Ny3.this.y();
            if (!AbstractC13042fc3.d(strH, c13245fuY != null ? c13245fuY.k() : null)) {
                C6542Ny3.this.E(EnumC17140mT2.a);
                if (C6542Ny3.this.i()) {
                    C6542Ny3.this.I(false);
                } else {
                    C6542Ny3.this.C(false);
                }
            }
            C6542Ny3 c6542Ny3 = C6542Ny3.this;
            C4301En7.a aVar = C4301En7.b;
            c6542Ny3.M(aVar.a());
            C6542Ny3.this.D(aVar.a());
            C6542Ny3.this.u.invoke(c23945xm7);
            C6542Ny3.this.q().invalidate();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C23945xm7) obj);
            return C19938rB7.a;
        }
    }

    public C6542Ny3(C3342Al7 c3342Al7, OJ5 oj5, InterfaceC20600sH6 interfaceC20600sH6) {
        this.a = c3342Al7;
        this.b = oj5;
        this.c = interfaceC20600sH6;
        Boolean bool = Boolean.FALSE;
        this.f = AbstractC13472gH6.d(bool, null, 2, null);
        this.g = AbstractC13472gH6.d(C17784nZ1.j(C17784nZ1.q(0)), null, 2, null);
        this.i = AbstractC13472gH6.d(null, null, 2, null);
        this.k = AbstractC13472gH6.d(EnumC17140mT2.a, null, 2, null);
        this.l = AbstractC13472gH6.d(bool, null, 2, null);
        this.m = AbstractC13472gH6.d(bool, null, 2, null);
        this.n = AbstractC13472gH6.d(bool, null, 2, null);
        this.o = AbstractC13472gH6.d(bool, null, 2, null);
        this.p = true;
        this.q = AbstractC13472gH6.d(Boolean.TRUE, null, 2, null);
        this.r = new C9946ap3(interfaceC20600sH6);
        this.s = AbstractC13472gH6.d(bool, null, 2, null);
        this.t = AbstractC13472gH6.d(bool, null, 2, null);
        this.u = c.e;
        this.v = new b();
        this.w = new a();
        this.x = AbstractC15587jq.a();
        this.y = C24381yX0.b.i();
        C4301En7.a aVar = C4301En7.b;
        this.z = AbstractC13472gH6.d(C4301En7.b(aVar.a()), null, 2, null);
        this.A = AbstractC13472gH6.d(C4301En7.b(aVar.a()), null, 2, null);
    }

    public final boolean A() {
        return ((Boolean) this.q.getValue()).booleanValue();
    }

    public final boolean B() {
        return this.p;
    }

    public final void C(boolean z) {
        this.s.setValue(Boolean.valueOf(z));
    }

    public final void D(long j) {
        this.A.setValue(C4301En7.b(j));
    }

    public final void E(EnumC17140mT2 enumC17140mT2) {
        this.k.setValue(enumC17140mT2);
    }

    public final void F(boolean z) {
        this.f.setValue(Boolean.valueOf(z));
    }

    public final void G(boolean z) {
        this.q.setValue(Boolean.valueOf(z));
    }

    public final void H(C8564Wm7 c8564Wm7) {
        this.e = c8564Wm7;
    }

    public final void I(boolean z) {
        this.t.setValue(Boolean.valueOf(z));
    }

    public final void J(InterfaceC11379cu3 interfaceC11379cu3) {
        this.h = interfaceC11379cu3;
    }

    public final void K(C14367hn7 c14367hn7) {
        this.i.setValue(c14367hn7);
        this.p = false;
    }

    public final void L(float f) {
        this.g.setValue(C17784nZ1.j(f));
    }

    public final void M(long j) {
        this.z.setValue(C4301En7.b(j));
    }

    public final void N(boolean z) {
        this.o.setValue(Boolean.valueOf(z));
    }

    public final void O(boolean z) {
        this.l.setValue(Boolean.valueOf(z));
    }

    public final void P(boolean z) {
        this.n.setValue(Boolean.valueOf(z));
    }

    public final void Q(boolean z) {
        this.m.setValue(Boolean.valueOf(z));
    }

    public final void R(C13245fu c13245fu, C13245fu c13245fu2, C9348Zn7 c9348Zn7, boolean z, WH1 wh1, AbstractC9998au2.b bVar, UA2 ua2, C11329cp3 c11329cp3, InterfaceC3630Br2 interfaceC3630Br2, long j) {
        this.u = ua2;
        this.y = j;
        C9946ap3 c9946ap3 = this.r;
        c9946ap3.f(c11329cp3);
        c9946ap3.e(interfaceC3630Br2);
        this.j = c13245fu;
        C3342Al7 c3342Al7B = AbstractC3815Cl7.b(this.a, c13245fu2, c9348Zn7, wh1, bVar, (448 & 32) != 0 ? true : z, (448 & 64) != 0 ? AbstractC23365wn7.a.a() : 0, (448 & 128) != 0 ? Integer.MAX_VALUE : 0, (448 & 256) != 0 ? 1 : 0, AbstractC10360bX0.m());
        if (this.a != c3342Al7B) {
            this.p = true;
        }
        this.a = c3342Al7B;
    }

    public final boolean c() {
        return ((Boolean) this.s.getValue()).booleanValue();
    }

    public final long d() {
        return ((C4301En7) this.A.getValue()).r();
    }

    public final EnumC17140mT2 e() {
        return (EnumC17140mT2) this.k.getValue();
    }

    public final boolean f() {
        return ((Boolean) this.f.getValue()).booleanValue();
    }

    public final InterfaceC12969fU4 g() {
        return this.x;
    }

    public final C8564Wm7 h() {
        return this.e;
    }

    public final boolean i() {
        return ((Boolean) this.t.getValue()).booleanValue();
    }

    public final InterfaceC20600sH6 j() {
        return this.c;
    }

    public final InterfaceC11379cu3 k() {
        InterfaceC11379cu3 interfaceC11379cu3 = this.h;
        if (interfaceC11379cu3 == null || !interfaceC11379cu3.b()) {
            return null;
        }
        return interfaceC11379cu3;
    }

    public final C14367hn7 l() {
        return (C14367hn7) this.i.getValue();
    }

    public final float m() {
        return ((C17784nZ1) this.g.getValue()).v();
    }

    public final UA2 n() {
        return this.w;
    }

    public final UA2 o() {
        return this.v;
    }

    public final C11475d42 p() {
        return this.d;
    }

    public final OJ5 q() {
        return this.b;
    }

    public final long r() {
        return this.y;
    }

    public final long s() {
        return ((C4301En7) this.z.getValue()).r();
    }

    public final boolean t() {
        return ((Boolean) this.o.getValue()).booleanValue();
    }

    public final boolean u() {
        return ((Boolean) this.l.getValue()).booleanValue();
    }

    public final boolean v() {
        return ((Boolean) this.n.getValue()).booleanValue();
    }

    public final boolean w() {
        return ((Boolean) this.m.getValue()).booleanValue();
    }

    public final C3342Al7 x() {
        return this.a;
    }

    public final C13245fu y() {
        return this.j;
    }

    public final boolean z() {
        return (C4301En7.h(s()) && C4301En7.h(d())) ? false : true;
    }

    /* renamed from: ir.nasim.Ny3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C23945xm7) obj);
            return C19938rB7.a;
        }

        public final void a(C23945xm7 c23945xm7) {
        }
    }
}
