package ir.nasim;

import ir.nasim.InterfaceC8013Ud5;

/* renamed from: ir.nasim.Or2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6717Or2 extends RG1 implements InterfaceC7163Qn6, InterfaceC15868kJ2, InterfaceC9814ac1, SG4, InterfaceC8645Wv7 {
    private static final a y = new a(null);
    public static final int z = 8;
    private InterfaceC18507om4 q;
    private final UA2 r;
    private final boolean s;
    private C23400wr2 t;
    private InterfaceC8013Ud5.a u;
    private InterfaceC11379cu3 v;
    private final androidx.compose.ui.focus.q w;
    private SA2 x;

    /* renamed from: ir.nasim.Or2$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Or2$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(androidx.compose.ui.focus.q.p0(C6717Or2.this.w, 0, 1, null));
        }
    }

    /* renamed from: ir.nasim.Or2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC18507om4 c;
        final /* synthetic */ InterfaceC22645vb3 d;
        final /* synthetic */ NV1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC18507om4 interfaceC18507om4, InterfaceC22645vb3 interfaceC22645vb3, NV1 nv1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC18507om4;
            this.d = interfaceC22645vb3;
            this.e = nv1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC18507om4 interfaceC18507om4 = this.c;
                InterfaceC22645vb3 interfaceC22645vb3 = this.d;
                this.b = 1;
                if (interfaceC18507om4.c(interfaceC22645vb3, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            NV1 nv1 = this.e;
            if (nv1 != null) {
                nv1.dispose();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Or2$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC18507om4 e;
        final /* synthetic */ InterfaceC22645vb3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC18507om4 interfaceC18507om4, InterfaceC22645vb3 interfaceC22645vb3) {
            super(1);
            this.e = interfaceC18507om4;
            this.f = interfaceC22645vb3;
        }

        public final void a(Throwable th) {
            this.e.a(this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Or2$e */
    /* synthetic */ class e extends EB2 implements InterfaceC14603iB2 {
        e(Object obj) {
            super(2, obj, C6717Or2.class, "onFocusStateChange", "onFocusStateChange(Landroidx/compose/ui/focus/FocusState;Landroidx/compose/ui/focus/FocusState;)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y((InterfaceC5517Jr2) obj, (InterfaceC5517Jr2) obj2);
            return C19938rB7.a;
        }

        public final void y(InterfaceC5517Jr2 interfaceC5517Jr2, InterfaceC5517Jr2 interfaceC5517Jr22) {
            ((C6717Or2) this.receiver).I2(interfaceC5517Jr2, interfaceC5517Jr22);
        }
    }

    /* renamed from: ir.nasim.Or2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6717Or2.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6717Or2 c6717Or2 = C6717Or2.this;
                this.b = 1;
                if (AbstractC7130Qk0.b(c6717Or2, null, this, 1, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Or2$g */
    static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C12889fL5 e;
        final /* synthetic */ C6717Or2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C12889fL5 c12889fL5, C6717Or2 c6717Or2) {
            super(0);
            this.e = c12889fL5;
            this.f = c6717Or2;
        }

        public final void a() {
            this.e.a = AbstractC10434bc1.a(this.f, AbstractC8247Vd5.a());
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public /* synthetic */ C6717Or2(InterfaceC18507om4 interfaceC18507om4, int i, UA2 ua2, ED1 ed1) {
        this(interfaceC18507om4, i, ua2);
    }

    private final void D2() {
        C23400wr2 c23400wr2;
        InterfaceC18507om4 interfaceC18507om4 = this.q;
        if (interfaceC18507om4 != null && (c23400wr2 = this.t) != null) {
            interfaceC18507om4.a(new C23990xr2(c23400wr2));
        }
        this.t = null;
    }

    private final void E2(boolean z2) {
        InterfaceC18507om4 interfaceC18507om4 = this.q;
        if (interfaceC18507om4 != null) {
            if (!z2) {
                C23400wr2 c23400wr2 = this.t;
                if (c23400wr2 != null) {
                    F2(interfaceC18507om4, new C23990xr2(c23400wr2));
                    this.t = null;
                    return;
                }
                return;
            }
            C23400wr2 c23400wr22 = this.t;
            if (c23400wr22 != null) {
                F2(interfaceC18507om4, new C23990xr2(c23400wr22));
                this.t = null;
            }
            C23400wr2 c23400wr23 = new C23400wr2();
            F2(interfaceC18507om4, c23400wr23);
            this.t = c23400wr23;
        }
    }

    private final void F2(InterfaceC18507om4 interfaceC18507om4, InterfaceC22645vb3 interfaceC22645vb3) {
        if (!b2()) {
            interfaceC18507om4.a(interfaceC22645vb3);
        } else {
            InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) U1().getCoroutineContext().a(InterfaceC13730gj3.n0);
            AbstractC10533bm0.d(U1(), null, null, new c(interfaceC18507om4, interfaceC22645vb3, interfaceC13730gj3 != null ? interfaceC13730gj3.s(new d(interfaceC18507om4, interfaceC22645vb3)) : null, null), 3, null);
        }
    }

    private final C6951Pr2 G2() {
        if (!b2()) {
            return null;
        }
        InterfaceC8645Wv7 interfaceC8645Wv7A = AbstractC8931Xv7.a(this, C6951Pr2.q);
        if (interfaceC8645Wv7A instanceof C6951Pr2) {
            return (C6951Pr2) interfaceC8645Wv7A;
        }
        return null;
    }

    private final void H2() {
        C6951Pr2 c6951Pr2G2;
        InterfaceC11379cu3 interfaceC11379cu3 = this.v;
        if (interfaceC11379cu3 != null) {
            AbstractC13042fc3.f(interfaceC11379cu3);
            if (!interfaceC11379cu3.b() || (c6951Pr2G2 = G2()) == null) {
                return;
            }
            c6951Pr2G2.v2(this.v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I2(InterfaceC5517Jr2 interfaceC5517Jr2, InterfaceC5517Jr2 interfaceC5517Jr22) {
        boolean zA;
        if (b2() && (zA = interfaceC5517Jr22.a()) != interfaceC5517Jr2.a()) {
            UA2 ua2 = this.r;
            if (ua2 != null) {
                ua2.invoke(Boolean.valueOf(zA));
            }
            if (zA) {
                AbstractC10533bm0.d(U1(), null, null, new f(null), 3, null);
                InterfaceC8013Ud5 interfaceC8013Ud5J2 = J2();
                this.u = interfaceC8013Ud5J2 != null ? interfaceC8013Ud5J2.a() : null;
                H2();
            } else {
                InterfaceC8013Ud5.a aVar = this.u;
                if (aVar != null) {
                    aVar.release();
                }
                this.u = null;
                C6951Pr2 c6951Pr2G2 = G2();
                if (c6951Pr2G2 != null) {
                    c6951Pr2G2.v2(null);
                }
            }
            AbstractC7397Rn6.b(this);
            E2(zA);
        }
    }

    private final InterfaceC8013Ud5 J2() {
        C12889fL5 c12889fL5 = new C12889fL5();
        TG4.a(this, new g(c12889fL5, this));
        return (InterfaceC8013Ud5) c12889fL5.a;
    }

    public final void K2(InterfaceC18507om4 interfaceC18507om4) {
        if (AbstractC13042fc3.d(this.q, interfaceC18507om4)) {
            return;
        }
        D2();
        this.q = interfaceC18507om4;
    }

    @Override // ir.nasim.InterfaceC8645Wv7
    public Object P() {
        return y;
    }

    @Override // ir.nasim.InterfaceC7163Qn6
    public void U0(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC9939ao6.h0(interfaceC11943do6, this.w.W().a());
        if (this.x == null) {
            this.x = new b();
        }
        AbstractC9939ao6.T(interfaceC11943do6, null, this.x, 1, null);
    }

    @Override // androidx.compose.ui.e.c
    /* renamed from: Z1 */
    public boolean getShouldAutoInvalidate() {
        return this.s;
    }

    @Override // androidx.compose.ui.e.c
    public void g2() {
        InterfaceC8013Ud5.a aVar = this.u;
        if (aVar != null) {
            aVar.release();
        }
        this.u = null;
    }

    @Override // ir.nasim.InterfaceC15868kJ2
    public void u(InterfaceC11379cu3 interfaceC11379cu3) {
        this.v = interfaceC11379cu3;
        if (this.w.W().a()) {
            if (interfaceC11379cu3.b()) {
                H2();
                return;
            }
            C6951Pr2 c6951Pr2G2 = G2();
            if (c6951Pr2G2 != null) {
                c6951Pr2G2.v2(null);
            }
        }
    }

    @Override // ir.nasim.SG4
    public void x0() {
        InterfaceC8013Ud5 interfaceC8013Ud5J2 = J2();
        if (this.w.W().a()) {
            InterfaceC8013Ud5.a aVar = this.u;
            if (aVar != null) {
                aVar.release();
            }
            this.u = interfaceC8013Ud5J2 != null ? interfaceC8013Ud5J2.a() : null;
        }
    }

    public /* synthetic */ C6717Or2(InterfaceC18507om4 interfaceC18507om4, int i, UA2 ua2, int i2, ED1 ed1) {
        this(interfaceC18507om4, (i2 & 2) != 0 ? androidx.compose.ui.focus.u.a.a() : i, (i2 & 4) != 0 ? null : ua2, null);
    }

    private C6717Or2(InterfaceC18507om4 interfaceC18507om4, int i, UA2 ua2) {
        this.q = interfaceC18507om4;
        this.r = ua2;
        this.w = (androidx.compose.ui.focus.q) v2(androidx.compose.ui.focus.r.a(i, new e(this)));
    }
}
