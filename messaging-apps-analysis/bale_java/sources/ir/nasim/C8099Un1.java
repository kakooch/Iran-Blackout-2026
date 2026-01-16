package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Un1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8099Un1 extends RG1 implements InterfaceC7163Qn6 {
    private C18600ov7 q;
    private C23945xm7 r;
    private C6542Ny3 s;
    private boolean t;
    private boolean u;
    private boolean v;
    private InterfaceC11600dH4 w;
    private C19101pm7 x;
    private T33 y;
    private androidx.compose.ui.focus.m z;

    /* renamed from: ir.nasim.Un1$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        public final void a() {
            KG1.i(C8099Un1.this);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Un1$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            C8099Un1.this.F2().u();
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.Un1$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            C8099Un1.this.F2().Z();
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.Un1$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C13245fu c13245fu) {
            C8099Un1.this.I2().I(true);
            C8099Un1.this.I2().C(true);
            C8099Un1 c8099Un1 = C8099Un1.this;
            c8099Un1.K2(c8099Un1.I2(), c13245fu.k(), C8099Un1.this.H2(), C8099Un1.this.C2());
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.Un1$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(List list) {
            boolean z;
            if (C8099Un1.this.I2().l() != null) {
                C14367hn7 c14367hn7L = C8099Un1.this.I2().l();
                AbstractC13042fc3.f(c14367hn7L);
                list.add(c14367hn7L.f());
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* renamed from: ir.nasim.Un1$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C13245fu c13245fu) {
            C8099Un1 c8099Un1 = C8099Un1.this;
            c8099Un1.K2(c8099Un1.I2(), c13245fu.k(), C8099Un1.this.H2(), C8099Un1.this.C2());
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.Un1$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC11943do6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC11943do6 interfaceC11943do6) {
            super(1);
            this.f = interfaceC11943do6;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C13245fu c13245fu) {
            C19938rB7 c19938rB7;
            if (C8099Un1.this.H2() || !C8099Un1.this.C2()) {
                return Boolean.FALSE;
            }
            C8564Wm7 c8564Wm7H = C8099Un1.this.I2().h();
            if (c8564Wm7H != null) {
                C8099Un1 c8099Un1 = C8099Un1.this;
                AbstractC9096Yl7.a.g(AbstractC10360bX0.p(new C4539Fo2(), new UZ0(c13245fu, 1)), c8099Un1.I2().p(), c8099Un1.I2().o(), c8564Wm7H);
                c19938rB7 = C19938rB7.a;
            } else {
                c19938rB7 = null;
            }
            if (c19938rB7 == null) {
                C8099Un1 c8099Un12 = C8099Un1.this;
                c8099Un12.I2().o().invoke(new C23945xm7(AbstractC20762sZ6.H0(c8099Un12.J2().h(), C4301En7.n(c8099Un12.J2().g()), C4301En7.i(c8099Un12.J2().g()), c13245fu).toString(), AbstractC4535Fn7.a(C4301En7.n(c8099Un12.J2().g()) + c13245fu.length()), (C4301En7) null, 4, (ED1) null));
            }
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.Un1$h */
    static final class h extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        h() {
            super(3);
        }

        public final Boolean a(int i, int i2, boolean z) {
            if (!z) {
                i = C8099Un1.this.G2().a(i);
            }
            if (!z) {
                i2 = C8099Un1.this.G2().a(i2);
            }
            boolean z2 = false;
            if (C8099Un1.this.C2() && (i != C4301En7.n(C8099Un1.this.J2().g()) || i2 != C4301En7.i(C8099Un1.this.J2().g()))) {
                if (Math.min(i, i2) < 0 || Math.max(i, i2) > C8099Un1.this.J2().e().length()) {
                    C8099Un1.this.F2().z();
                } else {
                    if (z || i == i2) {
                        C8099Un1.this.F2().z();
                    } else {
                        C19101pm7.y(C8099Un1.this.F2(), false, 1, null);
                    }
                    C8099Un1.this.I2().o().invoke(new C23945xm7(C8099Un1.this.J2().e(), AbstractC4535Fn7.b(i, i2), (C4301En7) null, 4, (ED1) null));
                    z2 = true;
                }
            }
            return Boolean.valueOf(z2);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Boolean) obj3).booleanValue());
        }
    }

    /* renamed from: ir.nasim.Un1$i */
    static final class i extends AbstractC8614Ws3 implements SA2 {
        i() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            C8099Un1.this.I2().n().invoke(S33.j(C8099Un1.this.E2().e()));
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.Un1$j */
    static final class j extends AbstractC8614Ws3 implements SA2 {
        j() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            AbstractC7865Tn1.q(C8099Un1.this.I2(), C8099Un1.this.D2(), !C8099Un1.this.H2());
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.Un1$k */
    static final class k extends AbstractC8614Ws3 implements SA2 {
        k() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            C19101pm7.y(C8099Un1.this.F2(), false, 1, null);
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.Un1$l */
    static final class l extends AbstractC8614Ws3 implements SA2 {
        l() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            C19101pm7.r(C8099Un1.this.F2(), false, 1, null);
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.Un1$m */
    static final class m extends AbstractC8614Ws3 implements SA2 {
        m() {
            super(0);
        }

        public final void a() {
            KG1.i(C8099Un1.this);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public C8099Un1(C18600ov7 c18600ov7, C23945xm7 c23945xm7, C6542Ny3 c6542Ny3, boolean z, boolean z2, boolean z3, InterfaceC11600dH4 interfaceC11600dH4, C19101pm7 c19101pm7, T33 t33, androidx.compose.ui.focus.m mVar) {
        this.q = c18600ov7;
        this.r = c23945xm7;
        this.s = c6542Ny3;
        this.t = z;
        this.u = z2;
        this.v = z3;
        this.w = interfaceC11600dH4;
        this.x = c19101pm7;
        this.y = t33;
        this.z = mVar;
        c19101pm7.n0(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K2(C6542Ny3 c6542Ny3, String str, boolean z, boolean z2) {
        C19938rB7 c19938rB7;
        if (z || !z2) {
            return;
        }
        C8564Wm7 c8564Wm7H = c6542Ny3.h();
        if (c8564Wm7H != null) {
            AbstractC9096Yl7.a.g(AbstractC10360bX0.p(new C16440lH1(), new UZ0(str, 1)), c6542Ny3.p(), c6542Ny3.o(), c8564Wm7H);
            c19938rB7 = C19938rB7.a;
        } else {
            c19938rB7 = null;
        }
        if (c19938rB7 == null) {
            c6542Ny3.o().invoke(new C23945xm7(str, AbstractC4535Fn7.a(str.length()), (C4301En7) null, 4, (ED1) null));
        }
    }

    public final boolean C2() {
        return this.u;
    }

    public final androidx.compose.ui.focus.m D2() {
        return this.z;
    }

    public final T33 E2() {
        return this.y;
    }

    public final C19101pm7 F2() {
        return this.x;
    }

    public final InterfaceC11600dH4 G2() {
        return this.w;
    }

    public final boolean H2() {
        return this.t;
    }

    public final C6542Ny3 I2() {
        return this.s;
    }

    public final C23945xm7 J2() {
        return this.r;
    }

    @Override // ir.nasim.InterfaceC7163Qn6
    public boolean L1() {
        return true;
    }

    public final void L2(C18600ov7 c18600ov7, C23945xm7 c23945xm7, C6542Ny3 c6542Ny3, boolean z, boolean z2, boolean z3, InterfaceC11600dH4 interfaceC11600dH4, C19101pm7 c19101pm7, T33 t33, androidx.compose.ui.focus.m mVar) {
        boolean z4 = this.u;
        boolean z5 = false;
        boolean z6 = z4 && !this.t;
        boolean z7 = this.v;
        T33 t332 = this.y;
        C19101pm7 c19101pm72 = this.x;
        if (z2 && !z) {
            z5 = true;
        }
        this.q = c18600ov7;
        this.r = c23945xm7;
        this.s = c6542Ny3;
        this.t = z;
        this.u = z2;
        this.w = interfaceC11600dH4;
        this.x = c19101pm7;
        this.y = t33;
        this.z = mVar;
        if (z2 != z4 || z5 != z6 || !AbstractC13042fc3.d(t33, t332) || z3 != z7 || !C4301En7.h(c23945xm7.g())) {
            AbstractC7397Rn6.b(this);
        }
        if (AbstractC13042fc3.d(c19101pm7, c19101pm72)) {
            return;
        }
        c19101pm7.n0(new m());
    }

    @Override // ir.nasim.InterfaceC7163Qn6
    public void U0(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC9939ao6.j0(interfaceC11943do6, this.r.e());
        AbstractC9939ao6.g0(interfaceC11943do6, this.q.b());
        AbstractC9939ao6.z0(interfaceC11943do6, this.r.g());
        AbstractC9939ao6.d0(interfaceC11943do6, InterfaceC22143uk1.a.a());
        AbstractC9939ao6.z(interfaceC11943do6, null, new d(), 1, null);
        if (!this.u) {
            AbstractC9939ao6.k(interfaceC11943do6);
        }
        if (this.v) {
            AbstractC9939ao6.O(interfaceC11943do6);
        }
        boolean z = this.u && !this.t;
        AbstractC9939ao6.f0(interfaceC11943do6, z);
        AbstractC9939ao6.s(interfaceC11943do6, null, new e(), 1, null);
        if (z) {
            AbstractC9939ao6.y0(interfaceC11943do6, null, new f(), 1, null);
            AbstractC9939ao6.w(interfaceC11943do6, null, new g(interfaceC11943do6), 1, null);
        }
        AbstractC9939ao6.s0(interfaceC11943do6, null, new h(), 1, null);
        AbstractC9939ao6.D(interfaceC11943do6, this.y.e(), null, new i(), 2, null);
        AbstractC9939ao6.B(interfaceC11943do6, null, new j(), 1, null);
        AbstractC9939ao6.F(interfaceC11943do6, null, new k(), 1, null);
        if (!C4301En7.h(this.r.g()) && !this.v) {
            AbstractC9939ao6.g(interfaceC11943do6, null, new l(), 1, null);
            if (this.u && !this.t) {
                AbstractC9939ao6.i(interfaceC11943do6, null, new b(), 1, null);
            }
        }
        if (!this.u || this.t) {
            return;
        }
        AbstractC9939ao6.Q(interfaceC11943do6, null, new c(), 1, null);
    }
}
