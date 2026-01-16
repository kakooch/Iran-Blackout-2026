package ir.nasim;

import ir.nasim.ZG4;

/* renamed from: ir.nasim.pm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19101pm7 {
    private final C14612iB7 a;
    private C6542Ny3 d;
    private SA2 g;
    private IV0 h;
    private InterfaceC20315ro1 i;
    private InterfaceC11323co7 j;
    private InterfaceC15967kU2 k;
    private androidx.compose.ui.focus.m l;
    private final InterfaceC9102Ym4 m;
    private final InterfaceC9102Ym4 n;
    private long o;
    private Integer p;
    private long q;
    private final InterfaceC9102Ym4 r;
    private final InterfaceC9102Ym4 s;
    private int t;
    private C23945xm7 u;
    private InterfaceC4066Dn6 v;
    private final InterfaceC4766Gl7 w;
    private final InterfaceC17305mk4 x;
    private InterfaceC11600dH4 b = VO7.d();
    private UA2 c = f.e;
    private final InterfaceC9102Ym4 e = AbstractC13472gH6.d(new C23945xm7((String) null, 0, (C4301En7) null, 7, (ED1) null), null, 2, null);
    private QY7 f = QY7.a.c();

    /* renamed from: ir.nasim.pm7$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19101pm7.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (C4301En7.h(C19101pm7.this.U().g())) {
                    return C19938rB7.a;
                }
                IV0 iv0A = C19101pm7.this.A();
                if (iv0A != null) {
                    EV0 ev0E = MV0.e(AbstractC24535ym7.a(C19101pm7.this.U()));
                    this.b = 1;
                    if (iv0A.b(ev0E, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            if (!this.d) {
                return C19938rB7.a;
            }
            int iK = C4301En7.k(C19101pm7.this.U().g());
            C19101pm7 c19101pm7 = C19101pm7.this;
            C19101pm7.this.O().invoke(c19101pm7.s(c19101pm7.U().e(), AbstractC4535Fn7.b(iK, iK)));
            C19101pm7.this.j0(EnumC17140mT2.a);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.pm7$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19101pm7.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (C4301En7.h(C19101pm7.this.U().g())) {
                    return C19938rB7.a;
                }
                IV0 iv0A = C19101pm7.this.A();
                if (iv0A != null) {
                    EV0 ev0E = MV0.e(AbstractC24535ym7.a(C19101pm7.this.U()));
                    this.b = 1;
                    if (iv0A.b(ev0E, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C13245fu c13245fuR = AbstractC24535ym7.c(C19101pm7.this.U(), C19101pm7.this.U().h().length()).r(AbstractC24535ym7.b(C19101pm7.this.U(), C19101pm7.this.U().h().length()));
            int iL = C4301En7.l(C19101pm7.this.U().g());
            C19101pm7.this.O().invoke(C19101pm7.this.s(c13245fuR, AbstractC4535Fn7.b(iL, iL)));
            C19101pm7.this.j0(EnumC17140mT2.a);
            C14612iB7 c14612iB7T = C19101pm7.this.T();
            if (c14612iB7T != null) {
                c14612iB7T.a();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.pm7$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19101pm7.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C13245fu c13245fuD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                IV0 iv0A = C19101pm7.this.A();
                if (iv0A != null) {
                    this.b = 1;
                    obj = iv0A.a(this);
                    if (obj == objE) {
                        return objE;
                    }
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            EV0 ev0 = (EV0) obj;
            if (ev0 != null && (c13245fuD = MV0.d(ev0)) != null) {
                C13245fu c13245fuR = AbstractC24535ym7.c(C19101pm7.this.U(), C19101pm7.this.U().h().length()).r(c13245fuD).r(AbstractC24535ym7.b(C19101pm7.this.U(), C19101pm7.this.U().h().length()));
                int iL = C4301En7.l(C19101pm7.this.U().g()) + c13245fuD.length();
                C19101pm7.this.O().invoke(C19101pm7.this.s(c13245fuR, AbstractC4535Fn7.b(iL, iL)));
                C19101pm7.this.j0(EnumC17140mT2.a);
                C14612iB7 c14612iB7T = C19101pm7.this.T();
                if (c14612iB7T != null) {
                    c14612iB7T.a();
                }
                return C19938rB7.a;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.pm7$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;

        /* renamed from: ir.nasim.pm7$h$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C19101pm7 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C19101pm7 c19101pm7) {
                super(0);
                this.e = c19101pm7;
            }

            public final void a() {
                this.e.o();
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.pm7$h$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C19101pm7 e;

            /* renamed from: ir.nasim.pm7$h$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C19101pm7 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(C19101pm7 c19101pm7, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c19101pm7;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    C19101pm7.r(this.c, false, 1, null);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C19101pm7 c19101pm7) {
                super(0);
                this.e = c19101pm7;
            }

            public final void a() {
                InterfaceC20315ro1 interfaceC20315ro1C = this.e.C();
                if (interfaceC20315ro1C != null) {
                    AbstractC10533bm0.d(interfaceC20315ro1C, null, EnumC23959xo1.UNDISPATCHED, new a(this.e, null), 1, null);
                }
                this.e.X();
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.pm7$h$c */
        static final class c extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C19101pm7 e;

            /* renamed from: ir.nasim.pm7$h$c$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C19101pm7 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(C19101pm7 c19101pm7, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c19101pm7;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.u();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(C19101pm7 c19101pm7) {
                super(0);
                this.e = c19101pm7;
            }

            public final void a() {
                InterfaceC20315ro1 interfaceC20315ro1C = this.e.C();
                if (interfaceC20315ro1C != null) {
                    AbstractC10533bm0.d(interfaceC20315ro1C, null, EnumC23959xo1.UNDISPATCHED, new a(this.e, null), 1, null);
                }
                this.e.X();
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.pm7$h$d */
        static final class d extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C19101pm7 e;

            /* renamed from: ir.nasim.pm7$h$d$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C19101pm7 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(C19101pm7 c19101pm7, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c19101pm7;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.Z();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(C19101pm7 c19101pm7) {
                super(0);
                this.e = c19101pm7;
            }

            public final void a() {
                InterfaceC20315ro1 interfaceC20315ro1C = this.e.C();
                if (interfaceC20315ro1C != null) {
                    AbstractC10533bm0.d(interfaceC20315ro1C, null, EnumC23959xo1.UNDISPATCHED, new a(this.e, null), 1, null);
                }
                this.e.X();
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.pm7$h$e */
        static final class e extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C19101pm7 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(C19101pm7 c19101pm7) {
                super(0);
                this.e = c19101pm7;
            }

            public final void a() {
                this.e.a0();
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19101pm7.this.new h(interfaceC20295rm1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0110  */
        /* JADX WARN: Type inference failed for: r0v13, types: [ir.nasim.SA2] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 287
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19101pm7.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C19101pm7(C14612iB7 c14612iB7) {
        this.a = c14612iB7;
        Boolean bool = Boolean.TRUE;
        this.m = AbstractC13472gH6.d(bool, null, 2, null);
        this.n = AbstractC13472gH6.d(bool, null, 2, null);
        ZG4.a aVar = ZG4.b;
        this.o = aVar.c();
        this.q = aVar.c();
        this.r = AbstractC13472gH6.d(null, null, 2, null);
        this.s = AbstractC13472gH6.d(null, null, 2, null);
        this.t = -1;
        this.u = new C23945xm7((String) null, 0L, (C4301En7) null, 7, (ED1) null);
        this.w = new i();
        this.x = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CK5 B() {
        long j;
        float fIntBitsToFloat;
        InterfaceC11379cu3 interfaceC11379cu3K;
        C13774gn7 c13774gn7F;
        CK5 ck5E;
        InterfaceC11379cu3 interfaceC11379cu3K2;
        C13774gn7 c13774gn7F2;
        CK5 ck5E2;
        InterfaceC11379cu3 interfaceC11379cu3K3;
        InterfaceC11379cu3 interfaceC11379cu3K4;
        C6542Ny3 c6542Ny3 = this.d;
        if (c6542Ny3 != null) {
            if (!(!c6542Ny3.B())) {
                c6542Ny3 = null;
            }
            if (c6542Ny3 != null) {
                int iB = this.b.b(C4301En7.n(U().g()));
                int iB2 = this.b.b(C4301En7.i(U().g()));
                C6542Ny3 c6542Ny32 = this.d;
                long jC = (c6542Ny32 == null || (interfaceC11379cu3K4 = c6542Ny32.k()) == null) ? ZG4.b.c() : interfaceC11379cu3K4.p0(K(true));
                C6542Ny3 c6542Ny33 = this.d;
                long jC2 = (c6542Ny33 == null || (interfaceC11379cu3K3 = c6542Ny33.k()) == null) ? ZG4.b.c() : interfaceC11379cu3K3.p0(K(false));
                C6542Ny3 c6542Ny34 = this.d;
                float fIntBitsToFloat2 = 0.0f;
                if (c6542Ny34 == null || (interfaceC11379cu3K2 = c6542Ny34.k()) == null) {
                    j = jC2;
                    fIntBitsToFloat = 0.0f;
                } else {
                    C14367hn7 c14367hn7L = c6542Ny3.l();
                    j = jC2;
                    fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC11379cu3K2.p0(ZG4.e((Float.floatToRawIntBits((c14367hn7L == null || (c13774gn7F2 = c14367hn7L.f()) == null || (ck5E2 = c13774gn7F2.e(iB)) == null) ? 0.0f : ck5E2.l()) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32))) & 4294967295L));
                }
                C6542Ny3 c6542Ny35 = this.d;
                if (c6542Ny35 != null && (interfaceC11379cu3K = c6542Ny35.k()) != null) {
                    C14367hn7 c14367hn7L2 = c6542Ny3.l();
                    fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC11379cu3K.p0(ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits((c14367hn7L2 == null || (c13774gn7F = c14367hn7L2.f()) == null || (ck5E = c13774gn7F.e(iB2)) == null) ? 0.0f : ck5E.l()) & 4294967295L))) & 4294967295L));
                }
                int i2 = (int) (jC >> 32);
                int i3 = (int) (j >> 32);
                return new CK5(Math.min(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3)), Math.min(fIntBitsToFloat, fIntBitsToFloat2), Math.max(Float.intBitsToFloat(i2), Float.intBitsToFloat(i3)), Math.max(Float.intBitsToFloat((int) (jC & 4294967295L)), Float.intBitsToFloat((int) (j & 4294967295L))) + (C17784nZ1.q(25) * c6542Ny3.x().a().getDensity()));
            }
        }
        return CK5.e.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(ZG4 zg4) {
        this.s.setValue(zg4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(EnumC10942cT2 enumC10942cT2) {
        this.r.setValue(enumC10942cT2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(EnumC17140mT2 enumC17140mT2) {
        C6542Ny3 c6542Ny3 = this.d;
        if (c6542Ny3 != null) {
            if (c6542Ny3.e() == enumC17140mT2) {
                c6542Ny3 = null;
            }
            if (c6542Ny3 != null) {
                c6542Ny3.E(enumC17140mT2);
            }
        }
    }

    public static /* synthetic */ InterfaceC13730gj3 r(C19101pm7 c19101pm7, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        return c19101pm7.q(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C23945xm7 s(C13245fu c13245fu, long j) {
        return new C23945xm7(c13245fu, j, (C4301En7) null, 4, (ED1) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(boolean z) {
        C6542Ny3 c6542Ny3 = this.d;
        if (c6542Ny3 != null) {
            c6542Ny3.O(z);
        }
        if (z) {
            t0();
        } else {
            X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long v0(C23945xm7 c23945xm7, long j, boolean z, boolean z2, InterfaceC23364wn6 interfaceC23364wn6, boolean z3) {
        C14367hn7 c14367hn7L;
        InterfaceC15967kU2 interfaceC15967kU2;
        int i2;
        C6542Ny3 c6542Ny3 = this.d;
        if (c6542Ny3 == null || (c14367hn7L = c6542Ny3.l()) == null) {
            return C4301En7.b.a();
        }
        long jB = AbstractC4535Fn7.b(this.b.b(C4301En7.n(c23945xm7.g())), this.b.b(C4301En7.i(c23945xm7.g())));
        boolean z4 = false;
        int iD = c14367hn7L.d(j, false);
        int iN = (z2 || z) ? iD : C4301En7.n(jB);
        int i3 = (!z2 || z) ? iD : C4301En7.i(jB);
        InterfaceC4066Dn6 interfaceC4066Dn6 = this.v;
        int i4 = -1;
        if (!z && interfaceC4066Dn6 != null && (i2 = this.t) != -1) {
            i4 = i2;
        }
        InterfaceC4066Dn6 interfaceC4066Dn6C = AbstractC4300En6.c(c14367hn7L.f(), iN, i3, i4, jB, z, z2);
        if (!interfaceC4066Dn6C.g(interfaceC4066Dn6)) {
            return c23945xm7.g();
        }
        this.v = interfaceC4066Dn6C;
        this.t = iD;
        C19701qn6 c19701qn6A = interfaceC23364wn6.a(interfaceC4066Dn6C);
        long jB2 = AbstractC4535Fn7.b(this.b.a(c19701qn6A.e().c()), this.b.a(c19701qn6A.c().c()));
        if (C4301En7.g(jB2, c23945xm7.g())) {
            return c23945xm7.g();
        }
        boolean z5 = C4301En7.m(jB2) != C4301En7.m(c23945xm7.g()) && C4301En7.g(AbstractC4535Fn7.b(C4301En7.i(jB2), C4301En7.n(jB2)), c23945xm7.g());
        boolean z6 = C4301En7.h(jB2) && C4301En7.h(c23945xm7.g());
        if (z3 && c23945xm7.h().length() > 0 && !z5 && !z6 && (interfaceC15967kU2 = this.k) != null) {
            interfaceC15967kU2.a(AbstractC16558lU2.a.i());
        }
        this.c.invoke(s(c23945xm7.e(), jB2));
        if (!z3) {
            u0(!C4301En7.h(jB2));
        }
        C6542Ny3 c6542Ny32 = this.d;
        if (c6542Ny32 != null) {
            c6542Ny32.G(z3);
        }
        C6542Ny3 c6542Ny33 = this.d;
        if (c6542Ny33 != null) {
            c6542Ny33.Q(!C4301En7.h(jB2) && AbstractC19692qm7.c(this, true));
        }
        C6542Ny3 c6542Ny34 = this.d;
        if (c6542Ny34 != null) {
            c6542Ny34.P(!C4301En7.h(jB2) && AbstractC19692qm7.c(this, false));
        }
        C6542Ny3 c6542Ny35 = this.d;
        if (c6542Ny35 != null) {
            if (C4301En7.h(jB2) && AbstractC19692qm7.c(this, true)) {
                z4 = true;
            }
            c6542Ny35.N(z4);
        }
        return jB2;
    }

    public static /* synthetic */ void w(C19101pm7 c19101pm7, ZG4 zg4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            zg4 = null;
        }
        c19101pm7.v(zg4);
    }

    public static /* synthetic */ void y(C19101pm7 c19101pm7, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        c19101pm7.x(z);
    }

    public final IV0 A() {
        return this.h;
    }

    public final InterfaceC20315ro1 C() {
        return this.i;
    }

    public final ZG4 D() {
        return (ZG4) this.s.getValue();
    }

    public final long E(WH1 wh1) {
        int iB = this.b.b(C4301En7.n(U().g()));
        C6542Ny3 c6542Ny3 = this.d;
        C14367hn7 c14367hn7L = c6542Ny3 != null ? c6542Ny3.l() : null;
        AbstractC13042fc3.f(c14367hn7L);
        C13774gn7 c13774gn7F = c14367hn7L.f();
        CK5 ck5E = c13774gn7F.e(AbstractC23053wG5.m(iB, 0, c13774gn7F.l().j().length()));
        return ZG4.e((Float.floatToRawIntBits(ck5E.i() + (wh1.w1(AbstractC8087Ul7.a()) / 2)) << 32) | (Float.floatToRawIntBits(ck5E.e()) & 4294967295L));
    }

    public final EnumC10942cT2 F() {
        return (EnumC10942cT2) this.r.getValue();
    }

    public final boolean G() {
        return ((Boolean) this.m.getValue()).booleanValue();
    }

    public final boolean H() {
        return ((Boolean) this.n.getValue()).booleanValue();
    }

    public final androidx.compose.ui.focus.m I() {
        return this.l;
    }

    public final float J(boolean z) {
        C14367hn7 c14367hn7L;
        C13774gn7 c13774gn7F;
        int iN = z ? C4301En7.n(U().g()) : C4301En7.i(U().g());
        C6542Ny3 c6542Ny3 = this.d;
        if (c6542Ny3 == null || (c14367hn7L = c6542Ny3.l()) == null || (c13774gn7F = c14367hn7L.f()) == null) {
            return 0.0f;
        }
        return AbstractC12547en7.b(c13774gn7F, iN);
    }

    public final long K(boolean z) {
        C14367hn7 c14367hn7L;
        C13774gn7 c13774gn7F;
        C6542Ny3 c6542Ny3 = this.d;
        if (c6542Ny3 == null || (c14367hn7L = c6542Ny3.l()) == null || (c13774gn7F = c14367hn7L.f()) == null) {
            return ZG4.b.b();
        }
        C13245fu c13245fuS = S();
        if (c13245fuS == null) {
            return ZG4.b.b();
        }
        if (!AbstractC13042fc3.d(c13245fuS.k(), c13774gn7F.l().j().k())) {
            return ZG4.b.b();
        }
        long jG = U().g();
        return AbstractC6920Pn7.b(c13774gn7F, this.b.b(z ? C4301En7.n(jG) : C4301En7.i(jG)), z, C4301En7.m(U().g()));
    }

    public final InterfaceC15967kU2 L() {
        return this.k;
    }

    public final InterfaceC17305mk4 M() {
        return this.x;
    }

    public final InterfaceC11600dH4 N() {
        return this.b;
    }

    public final UA2 O() {
        return this.c;
    }

    public final C6542Ny3 P() {
        return this.d;
    }

    public final InterfaceC11323co7 Q() {
        return this.j;
    }

    public final InterfaceC4766Gl7 R() {
        return this.w;
    }

    public final C13245fu S() {
        C3342Al7 c3342Al7X;
        C6542Ny3 c6542Ny3 = this.d;
        if (c6542Ny3 == null || (c3342Al7X = c6542Ny3.x()) == null) {
            return null;
        }
        return c3342Al7X.k();
    }

    public final C14612iB7 T() {
        return this.a;
    }

    public final C23945xm7 U() {
        return (C23945xm7) this.e.getValue();
    }

    public final QY7 V() {
        return this.f;
    }

    public final InterfaceC4766Gl7 W(boolean z) {
        return new d(z);
    }

    public final void X() {
        InterfaceC11323co7 interfaceC11323co7;
        InterfaceC11323co7 interfaceC11323co72 = this.j;
        if ((interfaceC11323co72 != null ? interfaceC11323co72.j() : null) != EnumC12557eo7.a || (interfaceC11323co7 = this.j) == null) {
            return;
        }
        interfaceC11323co7.b();
    }

    public final boolean Y() {
        return !AbstractC13042fc3.d(this.u.h(), U().h());
    }

    public final InterfaceC13730gj3 Z() {
        InterfaceC20315ro1 interfaceC20315ro1 = this.i;
        if (interfaceC20315ro1 != null) {
            return AbstractC10533bm0.d(interfaceC20315ro1, null, EnumC23959xo1.UNDISPATCHED, new g(null), 1, null);
        }
        return null;
    }

    public final void a0() {
        C23945xm7 c23945xm7S = s(U().e(), AbstractC4535Fn7.b(0, U().h().length()));
        this.c.invoke(c23945xm7S);
        this.u = C23945xm7.c(this.u, null, c23945xm7S.g(), null, 5, null);
        x(true);
    }

    public final void b0(IV0 iv0) {
        this.h = iv0;
    }

    public final void c0(InterfaceC20315ro1 interfaceC20315ro1) {
        this.i = interfaceC20315ro1;
    }

    public final void e0(long j) {
        C6542Ny3 c6542Ny3 = this.d;
        if (c6542Ny3 != null) {
            c6542Ny3.D(j);
        }
        C6542Ny3 c6542Ny32 = this.d;
        if (c6542Ny32 != null) {
            c6542Ny32.M(C4301En7.b.a());
        }
        if (C4301En7.h(j)) {
            return;
        }
        z();
    }

    public final void g0(boolean z) {
        this.m.setValue(Boolean.valueOf(z));
    }

    public final void h0(boolean z) {
        this.n.setValue(Boolean.valueOf(z));
    }

    public final void i0(androidx.compose.ui.focus.m mVar) {
        this.l = mVar;
    }

    public final void k0(InterfaceC15967kU2 interfaceC15967kU2) {
        this.k = interfaceC15967kU2;
    }

    public final void l0(InterfaceC11600dH4 interfaceC11600dH4) {
        this.b = interfaceC11600dH4;
    }

    public final void m0(UA2 ua2) {
        this.c = ua2;
    }

    public final void n0(SA2 sa2) {
        this.g = sa2;
    }

    public final void o() {
        SA2 sa2 = this.g;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    public final void o0(long j) {
        C6542Ny3 c6542Ny3 = this.d;
        if (c6542Ny3 != null) {
            c6542Ny3.M(j);
        }
        C6542Ny3 c6542Ny32 = this.d;
        if (c6542Ny32 != null) {
            c6542Ny32.D(C4301En7.b.a());
        }
        if (C4301En7.h(j)) {
            return;
        }
        z();
    }

    public final void p() {
        C6542Ny3 c6542Ny3 = this.d;
        if (c6542Ny3 != null) {
            c6542Ny3.D(C4301En7.b.a());
        }
        C6542Ny3 c6542Ny32 = this.d;
        if (c6542Ny32 == null) {
            return;
        }
        c6542Ny32.M(C4301En7.b.a());
    }

    public final void p0(C6542Ny3 c6542Ny3) {
        this.d = c6542Ny3;
    }

    public final InterfaceC13730gj3 q(boolean z) {
        InterfaceC20315ro1 interfaceC20315ro1 = this.i;
        if (interfaceC20315ro1 != null) {
            return AbstractC10533bm0.d(interfaceC20315ro1, null, EnumC23959xo1.UNDISPATCHED, new a(z, null), 1, null);
        }
        return null;
    }

    public final void q0(InterfaceC11323co7 interfaceC11323co7) {
        this.j = interfaceC11323co7;
    }

    public final void r0(C23945xm7 c23945xm7) {
        this.e.setValue(c23945xm7);
    }

    public final void s0(QY7 qy7) {
        this.f = qy7;
    }

    public final InterfaceC4766Gl7 t() {
        return new b();
    }

    public final InterfaceC13730gj3 t0() {
        InterfaceC20315ro1 interfaceC20315ro1 = this.i;
        if (interfaceC20315ro1 != null) {
            return AbstractC10533bm0.d(interfaceC20315ro1, null, EnumC23959xo1.UNDISPATCHED, new h(null), 1, null);
        }
        return null;
    }

    public final InterfaceC13730gj3 u() {
        InterfaceC20315ro1 interfaceC20315ro1 = this.i;
        if (interfaceC20315ro1 != null) {
            return AbstractC10533bm0.d(interfaceC20315ro1, null, EnumC23959xo1.UNDISPATCHED, new c(null), 1, null);
        }
        return null;
    }

    public final void v(ZG4 zg4) {
        if (!C4301En7.h(U().g())) {
            C6542Ny3 c6542Ny3 = this.d;
            C14367hn7 c14367hn7L = c6542Ny3 != null ? c6542Ny3.l() : null;
            this.c.invoke(C23945xm7.c(U(), null, AbstractC4535Fn7.a((zg4 == null || c14367hn7L == null) ? C4301En7.k(U().g()) : this.b.a(C14367hn7.e(c14367hn7L, zg4.t(), false, 2, null))), null, 5, null));
        }
        j0((zg4 == null || U().h().length() <= 0) ? EnumC17140mT2.a : EnumC17140mT2.c);
        u0(false);
    }

    public final void x(boolean z) {
        androidx.compose.ui.focus.m mVar;
        C6542Ny3 c6542Ny3 = this.d;
        if (c6542Ny3 != null && !c6542Ny3.f() && (mVar = this.l) != null) {
            androidx.compose.ui.focus.m.g(mVar, 0, 1, null);
        }
        this.u = U();
        u0(z);
        j0(EnumC17140mT2.b);
    }

    public final void z() {
        u0(false);
        j0(EnumC17140mT2.a);
    }

    /* renamed from: ir.nasim.pm7$b */
    public static final class b implements InterfaceC4766Gl7 {
        b() {
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void b(long j) {
            C14367hn7 c14367hn7L;
            long jA = AbstractC3832Cn6.a(C19101pm7.this.K(true));
            C6542Ny3 c6542Ny3P = C19101pm7.this.P();
            if (c6542Ny3P == null || (c14367hn7L = c6542Ny3P.l()) == null) {
                return;
            }
            long jK = c14367hn7L.k(jA);
            C19101pm7.this.o = jK;
            C19101pm7.this.d0(ZG4.d(jK));
            C19101pm7.this.q = ZG4.b.c();
            C19101pm7.this.f0(EnumC10942cT2.a);
            C19101pm7.this.u0(false);
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void c() {
            C19101pm7.this.f0(null);
            C19101pm7.this.d0(null);
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void d(long j) {
            C14367hn7 c14367hn7L;
            InterfaceC15967kU2 interfaceC15967kU2L;
            C19101pm7 c19101pm7 = C19101pm7.this;
            c19101pm7.q = ZG4.q(c19101pm7.q, j);
            C6542Ny3 c6542Ny3P = C19101pm7.this.P();
            if (c6542Ny3P == null || (c14367hn7L = c6542Ny3P.l()) == null) {
                return;
            }
            C19101pm7 c19101pm72 = C19101pm7.this;
            c19101pm72.d0(ZG4.d(ZG4.q(c19101pm72.o, c19101pm72.q)));
            InterfaceC11600dH4 interfaceC11600dH4N = c19101pm72.N();
            ZG4 zg4D = c19101pm72.D();
            AbstractC13042fc3.f(zg4D);
            int iA = interfaceC11600dH4N.a(C14367hn7.e(c14367hn7L, zg4D.t(), false, 2, null));
            long jB = AbstractC4535Fn7.b(iA, iA);
            if (C4301En7.g(jB, c19101pm72.U().g())) {
                return;
            }
            C6542Ny3 c6542Ny3P2 = c19101pm72.P();
            if ((c6542Ny3P2 == null || c6542Ny3P2.A()) && (interfaceC15967kU2L = c19101pm72.L()) != null) {
                interfaceC15967kU2L.a(AbstractC16558lU2.a.i());
            }
            c19101pm72.O().invoke(c19101pm72.s(c19101pm72.U().e(), jB));
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void i() {
            C19101pm7.this.f0(null);
            C19101pm7.this.d0(null);
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void onCancel() {
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void a(long j) {
        }
    }

    /* renamed from: ir.nasim.pm7$d */
    public static final class d implements InterfaceC4766Gl7 {
        final /* synthetic */ boolean b;

        d(boolean z) {
            this.b = z;
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void a(long j) {
            C14367hn7 c14367hn7L;
            C19101pm7.this.f0(this.b ? EnumC10942cT2.b : EnumC10942cT2.c);
            long jA = AbstractC3832Cn6.a(C19101pm7.this.K(this.b));
            C6542Ny3 c6542Ny3P = C19101pm7.this.P();
            if (c6542Ny3P == null || (c14367hn7L = c6542Ny3P.l()) == null) {
                return;
            }
            long jK = c14367hn7L.k(jA);
            C19101pm7.this.o = jK;
            C19101pm7.this.d0(ZG4.d(jK));
            C19101pm7.this.q = ZG4.b.c();
            C19101pm7.this.t = -1;
            C6542Ny3 c6542Ny3P2 = C19101pm7.this.P();
            if (c6542Ny3P2 != null) {
                c6542Ny3P2.G(true);
            }
            C19101pm7.this.u0(false);
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void c() {
            C19101pm7.this.f0(null);
            C19101pm7.this.d0(null);
            C19101pm7.this.u0(true);
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void d(long j) {
            C19101pm7 c19101pm7 = C19101pm7.this;
            c19101pm7.q = ZG4.q(c19101pm7.q, j);
            C19101pm7 c19101pm72 = C19101pm7.this;
            c19101pm72.d0(ZG4.d(ZG4.q(c19101pm72.o, C19101pm7.this.q)));
            C19101pm7 c19101pm73 = C19101pm7.this;
            C23945xm7 c23945xm7U = c19101pm73.U();
            ZG4 zg4D = C19101pm7.this.D();
            AbstractC13042fc3.f(zg4D);
            c19101pm73.v0(c23945xm7U, zg4D.t(), false, this.b, InterfaceC23364wn6.a.k(), true);
            C19101pm7.this.u0(false);
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void i() {
            C19101pm7.this.f0(null);
            C19101pm7.this.d0(null);
            C19101pm7.this.u0(true);
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void onCancel() {
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void b(long j) {
        }
    }

    /* renamed from: ir.nasim.pm7$e */
    public static final class e implements InterfaceC17305mk4 {
        e() {
        }

        @Override // ir.nasim.InterfaceC17305mk4
        public boolean b(long j, InterfaceC23364wn6 interfaceC23364wn6) {
            C6542Ny3 c6542Ny3P;
            if (!C19101pm7.this.H() || C19101pm7.this.U().h().length() == 0 || (c6542Ny3P = C19101pm7.this.P()) == null || c6542Ny3P.l() == null) {
                return false;
            }
            f(C19101pm7.this.U(), j, false, interfaceC23364wn6);
            return true;
        }

        @Override // ir.nasim.InterfaceC17305mk4
        public boolean c(long j, InterfaceC23364wn6 interfaceC23364wn6) {
            C6542Ny3 c6542Ny3P;
            if (!C19101pm7.this.H() || C19101pm7.this.U().h().length() == 0 || (c6542Ny3P = C19101pm7.this.P()) == null || c6542Ny3P.l() == null) {
                return false;
            }
            androidx.compose.ui.focus.m mVarI = C19101pm7.this.I();
            if (mVarI != null) {
                androidx.compose.ui.focus.m.g(mVarI, 0, 1, null);
            }
            C19101pm7.this.o = j;
            C19101pm7.this.t = -1;
            C19101pm7.y(C19101pm7.this, false, 1, null);
            f(C19101pm7.this.U(), C19101pm7.this.o, true, interfaceC23364wn6);
            return true;
        }

        @Override // ir.nasim.InterfaceC17305mk4
        public boolean d(long j) {
            C6542Ny3 c6542Ny3P;
            if (!C19101pm7.this.H() || C19101pm7.this.U().h().length() == 0 || (c6542Ny3P = C19101pm7.this.P()) == null || c6542Ny3P.l() == null) {
                return false;
            }
            f(C19101pm7.this.U(), j, false, InterfaceC23364wn6.a.l());
            return true;
        }

        @Override // ir.nasim.InterfaceC17305mk4
        public boolean e(long j) {
            C6542Ny3 c6542Ny3P = C19101pm7.this.P();
            if (c6542Ny3P == null || c6542Ny3P.l() == null || !C19101pm7.this.H()) {
                return false;
            }
            C19101pm7.this.t = -1;
            f(C19101pm7.this.U(), j, false, InterfaceC23364wn6.a.l());
            return true;
        }

        public final void f(C23945xm7 c23945xm7, long j, boolean z, InterfaceC23364wn6 interfaceC23364wn6) {
            C19101pm7.this.j0(C4301En7.h(C19101pm7.this.v0(c23945xm7, j, z, false, interfaceC23364wn6, false)) ? EnumC17140mT2.c : EnumC17140mT2.b);
        }

        @Override // ir.nasim.InterfaceC17305mk4
        public void a() {
        }
    }

    /* renamed from: ir.nasim.pm7$i */
    public static final class i implements InterfaceC4766Gl7 {
        i() {
        }

        private final void e() {
            C19101pm7.this.f0(null);
            C19101pm7.this.d0(null);
            C19101pm7.this.u0(true);
            C19101pm7.this.p = null;
            boolean zH = C4301En7.h(C19101pm7.this.U().g());
            C19101pm7.this.j0(zH ? EnumC17140mT2.c : EnumC17140mT2.b);
            C6542Ny3 c6542Ny3P = C19101pm7.this.P();
            if (c6542Ny3P != null) {
                c6542Ny3P.Q(!zH && AbstractC19692qm7.c(C19101pm7.this, true));
            }
            C6542Ny3 c6542Ny3P2 = C19101pm7.this.P();
            if (c6542Ny3P2 != null) {
                c6542Ny3P2.P(!zH && AbstractC19692qm7.c(C19101pm7.this, false));
            }
            C6542Ny3 c6542Ny3P3 = C19101pm7.this.P();
            if (c6542Ny3P3 == null) {
                return;
            }
            c6542Ny3P3.N(zH && AbstractC19692qm7.c(C19101pm7.this, true));
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void b(long j) {
            C14367hn7 c14367hn7L;
            C14367hn7 c14367hn7L2;
            if (C19101pm7.this.H() && C19101pm7.this.F() == null) {
                C19101pm7.this.f0(EnumC10942cT2.c);
                C19101pm7.this.t = -1;
                C19101pm7.this.X();
                C6542Ny3 c6542Ny3P = C19101pm7.this.P();
                if (c6542Ny3P == null || (c14367hn7L2 = c6542Ny3P.l()) == null || !c14367hn7L2.g(j)) {
                    C6542Ny3 c6542Ny3P2 = C19101pm7.this.P();
                    if (c6542Ny3P2 != null && (c14367hn7L = c6542Ny3P2.l()) != null) {
                        C19101pm7 c19101pm7 = C19101pm7.this;
                        int iA = c19101pm7.N().a(C14367hn7.e(c14367hn7L, j, false, 2, null));
                        C23945xm7 c23945xm7S = c19101pm7.s(c19101pm7.U().e(), AbstractC4535Fn7.b(iA, iA));
                        c19101pm7.x(false);
                        InterfaceC15967kU2 interfaceC15967kU2L = c19101pm7.L();
                        if (interfaceC15967kU2L != null) {
                            interfaceC15967kU2L.a(AbstractC16558lU2.a.i());
                        }
                        c19101pm7.O().invoke(c23945xm7S);
                    }
                } else {
                    if (C19101pm7.this.U().h().length() == 0) {
                        return;
                    }
                    C19101pm7.this.x(false);
                    C19101pm7 c19101pm72 = C19101pm7.this;
                    C19101pm7.this.p = Integer.valueOf(C4301En7.n(c19101pm72.v0(C23945xm7.c(c19101pm72.U(), null, C4301En7.b.a(), null, 5, null), j, true, false, InterfaceC23364wn6.a.n(), true)));
                }
                C19101pm7.this.j0(EnumC17140mT2.a);
                C19101pm7.this.o = j;
                C19101pm7 c19101pm73 = C19101pm7.this;
                c19101pm73.d0(ZG4.d(c19101pm73.o));
                C19101pm7.this.q = ZG4.b.c();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00b6  */
        @Override // ir.nasim.InterfaceC4766Gl7
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void d(long r10) {
            /*
                r9 = this;
                ir.nasim.pm7 r0 = ir.nasim.C19101pm7.this
                boolean r0 = r0.H()
                if (r0 == 0) goto L107
                ir.nasim.pm7 r0 = ir.nasim.C19101pm7.this
                ir.nasim.xm7 r0 = r0.U()
                java.lang.String r0 = r0.h()
                int r0 = r0.length()
                if (r0 != 0) goto L1a
                goto L107
            L1a:
                ir.nasim.pm7 r0 = ir.nasim.C19101pm7.this
                long r1 = ir.nasim.C19101pm7.e(r0)
                long r10 = ir.nasim.ZG4.q(r1, r10)
                ir.nasim.C19101pm7.i(r0, r10)
                ir.nasim.pm7 r10 = ir.nasim.C19101pm7.this
                ir.nasim.Ny3 r10 = r10.P()
                r11 = 0
                if (r10 == 0) goto L102
                ir.nasim.hn7 r10 = r10.l()
                if (r10 == 0) goto L102
                ir.nasim.pm7 r6 = ir.nasim.C19101pm7.this
                long r0 = ir.nasim.C19101pm7.d(r6)
                long r2 = ir.nasim.C19101pm7.e(r6)
                long r0 = ir.nasim.ZG4.q(r0, r2)
                ir.nasim.ZG4 r0 = ir.nasim.ZG4.d(r0)
                ir.nasim.C19101pm7.f(r6, r0)
                java.lang.Integer r0 = ir.nasim.C19101pm7.c(r6)
                if (r0 != 0) goto Lb6
                ir.nasim.ZG4 r0 = r6.D()
                ir.nasim.AbstractC13042fc3.f(r0)
                long r0 = r0.t()
                boolean r0 = r10.g(r0)
                if (r0 != 0) goto Lb6
                ir.nasim.dH4 r7 = r6.N()
                long r1 = ir.nasim.C19101pm7.d(r6)
                r4 = 2
                r5 = 0
                r3 = 0
                r0 = r10
                int r0 = ir.nasim.C14367hn7.e(r0, r1, r3, r4, r5)
                int r7 = r7.a(r0)
                ir.nasim.dH4 r8 = r6.N()
                ir.nasim.ZG4 r0 = r6.D()
                ir.nasim.AbstractC13042fc3.f(r0)
                long r1 = r0.t()
                r0 = r10
                int r10 = ir.nasim.C14367hn7.e(r0, r1, r3, r4, r5)
                int r10 = r8.a(r10)
                if (r7 != r10) goto L97
                ir.nasim.wn6$a r10 = ir.nasim.InterfaceC23364wn6.a
                ir.nasim.wn6 r10 = r10.l()
                goto L9d
            L97:
                ir.nasim.wn6$a r10 = ir.nasim.InterfaceC23364wn6.a
                ir.nasim.wn6 r10 = r10.n()
            L9d:
                ir.nasim.xm7 r1 = r6.U()
                ir.nasim.ZG4 r0 = r6.D()
                ir.nasim.AbstractC13042fc3.f(r0)
                long r2 = r0.t()
                r5 = 0
                r7 = 1
                r4 = 0
                r0 = r6
                r6 = r10
                long r0 = ir.nasim.C19101pm7.n(r0, r1, r2, r4, r5, r6, r7)
                goto Lff
            Lb6:
                java.lang.Integer r0 = ir.nasim.C19101pm7.c(r6)
                if (r0 == 0) goto Lc1
                int r0 = r0.intValue()
                goto Lc9
            Lc1:
                long r0 = ir.nasim.C19101pm7.d(r6)
                int r0 = r10.d(r0, r11)
            Lc9:
                ir.nasim.ZG4 r1 = r6.D()
                ir.nasim.AbstractC13042fc3.f(r1)
                long r1 = r1.t()
                int r10 = r10.d(r1, r11)
                java.lang.Integer r1 = ir.nasim.C19101pm7.c(r6)
                if (r1 != 0) goto Le1
                if (r0 != r10) goto Le1
                return
            Le1:
                ir.nasim.xm7 r1 = r6.U()
                ir.nasim.ZG4 r10 = r6.D()
                ir.nasim.AbstractC13042fc3.f(r10)
                long r2 = r10.t()
                ir.nasim.wn6$a r10 = ir.nasim.InterfaceC23364wn6.a
                ir.nasim.wn6 r10 = r10.n()
                r7 = 1
                r4 = 0
                r5 = 0
                r0 = r6
                r6 = r10
                long r0 = ir.nasim.C19101pm7.n(r0, r1, r2, r4, r5, r6, r7)
            Lff:
                ir.nasim.C4301En7.b(r0)
            L102:
                ir.nasim.pm7 r10 = ir.nasim.C19101pm7.this
                ir.nasim.C19101pm7.m(r10, r11)
            L107:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19101pm7.i.d(long):void");
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void i() {
            e();
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void onCancel() {
            e();
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void c() {
        }

        @Override // ir.nasim.InterfaceC4766Gl7
        public void a(long j) {
        }
    }

    /* renamed from: ir.nasim.pm7$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
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
