package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Wm, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8556Wm {
    public static final a p = new a(null);
    private final UA2 a;
    private final SA2 b;
    private final InterfaceC5766Kt c;
    private final UA2 d;
    private final InterfaceC9102Ym4 g;
    private final C6314Nb3 e = new C6314Nb3();
    private final OZ1 f = new h();
    private final InterfaceC9664aL6 h = AbstractC10222bH6.d(new j());
    private final InterfaceC9664aL6 i = AbstractC10222bH6.d(new g());
    private final InterfaceC14354hm4 j = AbstractC4326Eq5.a(Float.NaN);
    private final InterfaceC9664aL6 k = AbstractC10222bH6.e(AbstractC10222bH6.s(), new i());
    private final InterfaceC14354hm4 l = AbstractC4326Eq5.a(0.0f);
    private final InterfaceC9102Ym4 m = AbstractC13472gH6.d(null, null, 2, null);
    private final InterfaceC9102Ym4 n = AbstractC13472gH6.d(AbstractC8322Vm.h(), null, 2, null);
    private final InterfaceC7854Tm o = new f();

    /* renamed from: ir.nasim.Wm$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Wm$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C8556Wm.this.i(null, null, this);
        }
    }

    /* renamed from: ir.nasim.Wm$c */
    static final class c extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ InterfaceC15796kB2 d;

        /* renamed from: ir.nasim.Wm$c$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C8556Wm e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8556Wm c8556Wm) {
                super(0);
                this.e = c8556Wm;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final KZ1 invoke() {
                return this.e.n();
            }
        }

        /* renamed from: ir.nasim.Wm$c$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC15796kB2 d;
            final /* synthetic */ C8556Wm e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC15796kB2 interfaceC15796kB2, C8556Wm c8556Wm, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC15796kB2;
                this.e = c8556Wm;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, this.e, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    KZ1 kz1 = (KZ1) this.c;
                    InterfaceC15796kB2 interfaceC15796kB2 = this.d;
                    InterfaceC7854Tm interfaceC7854Tm = this.e.o;
                    this.b = 1;
                    if (interfaceC15796kB2.q(interfaceC7854Tm, kz1, this) == objE) {
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
            public final Object invoke(KZ1 kz1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(kz1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = interfaceC15796kB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C8556Wm.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                a aVar = new a(C8556Wm.this);
                b bVar = new b(this.d, C8556Wm.this, null);
                this.b = 1;
                if (AbstractC8322Vm.i(aVar, bVar, this) == objE) {
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

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wm$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C8556Wm.this.j(null, null, null, this);
        }
    }

    /* renamed from: ir.nasim.Wm$e */
    static final class e extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ Object d;
        final /* synthetic */ InterfaceC16978mB2 e;

        /* renamed from: ir.nasim.Wm$e$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C8556Wm e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8556Wm c8556Wm) {
                super(0);
                this.e = c8556Wm;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final XV4 invoke() {
                return AbstractC4616Fw7.a(this.e.n(), this.e.w());
            }
        }

        /* renamed from: ir.nasim.Wm$e$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC16978mB2 d;
            final /* synthetic */ C8556Wm e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC16978mB2 interfaceC16978mB2, C8556Wm c8556Wm, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC16978mB2;
                this.e = c8556Wm;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, this.e, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    XV4 xv4 = (XV4) this.c;
                    KZ1 kz1 = (KZ1) xv4.a();
                    Object objB = xv4.b();
                    InterfaceC16978mB2 interfaceC16978mB2 = this.d;
                    InterfaceC7854Tm interfaceC7854Tm = this.e.o;
                    this.b = 1;
                    if (interfaceC16978mB2.e(interfaceC7854Tm, kz1, objB, this) == objE) {
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
            public final Object invoke(XV4 xv4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(xv4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Object obj, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = obj;
            this.e = interfaceC16978mB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C8556Wm.this.new e(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C8556Wm.this.C(this.d);
                a aVar = new a(C8556Wm.this);
                b bVar = new b(this.e, C8556Wm.this, null);
                this.b = 1;
                if (AbstractC8322Vm.i(aVar, bVar, this) == objE) {
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

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Wm$f */
    public static final class f implements InterfaceC7854Tm {
        f() {
        }

        @Override // ir.nasim.InterfaceC7854Tm
        public void a(float f, float f2) {
            C8556Wm.this.E(f);
            C8556Wm.this.D(f2);
        }
    }

    /* renamed from: ir.nasim.Wm$g */
    static final class g extends AbstractC8614Ws3 implements SA2 {
        g() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            Object objS = C8556Wm.this.s();
            if (objS != null) {
                return objS;
            }
            C8556Wm c8556Wm = C8556Wm.this;
            float fV = c8556Wm.v();
            return !Float.isNaN(fV) ? c8556Wm.m(fV, c8556Wm.r()) : c8556Wm.r();
        }
    }

    /* renamed from: ir.nasim.Wm$h */
    public static final class h implements OZ1 {
        private final b a;

        /* renamed from: ir.nasim.Wm$h$a */
        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            final /* synthetic */ InterfaceC14603iB2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
                this.d = interfaceC14603iB2;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    b bVar = h.this.a;
                    InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                    this.b = 1;
                    if (interfaceC14603iB2.invoke(bVar, this) == objE) {
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

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC7854Tm interfaceC7854Tm, KZ1 kz1, InterfaceC20295rm1 interfaceC20295rm1) {
                return h.this.new a(this.d, interfaceC20295rm1).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Wm$h$b */
        public static final class b implements IZ1 {
            final /* synthetic */ C8556Wm a;

            b(C8556Wm c8556Wm) {
                this.a = c8556Wm;
            }

            @Override // ir.nasim.IZ1
            public void a(float f) {
                InterfaceC7854Tm.b(this.a.o, this.a.y(f), 0.0f, 2, null);
            }
        }

        h() {
            this.a = new b(C8556Wm.this);
        }

        @Override // ir.nasim.OZ1
        public Object a(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
            Object objI = C8556Wm.this.i(enumC15562jn4, new a(interfaceC14603iB2, null), interfaceC20295rm1);
            return objI == AbstractC14862ic3.e() ? objI : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Wm$i */
    static final class i extends AbstractC8614Ws3 implements SA2 {
        i() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            float fE = C8556Wm.this.n().e(C8556Wm.this.r());
            float fE2 = C8556Wm.this.n().e(C8556Wm.this.p()) - fE;
            float fAbs = Math.abs(fE2);
            float f = 1.0f;
            if (!Float.isNaN(fAbs) && fAbs > 1.0E-6f) {
                float fZ = (C8556Wm.this.z() - fE) / fE2;
                if (fZ < 1.0E-6f) {
                    f = 0.0f;
                } else if (fZ <= 0.999999f) {
                    f = fZ;
                }
            }
            return Float.valueOf(f);
        }
    }

    /* renamed from: ir.nasim.Wm$j */
    static final class j extends AbstractC8614Ws3 implements SA2 {
        j() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            Object objS = C8556Wm.this.s();
            if (objS != null) {
                return objS;
            }
            C8556Wm c8556Wm = C8556Wm.this;
            float fV = c8556Wm.v();
            return !Float.isNaN(fV) ? c8556Wm.l(fV, c8556Wm.r(), 0.0f) : c8556Wm.r();
        }
    }

    /* renamed from: ir.nasim.Wm$k */
    static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Object f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(Object obj) {
            super(0);
            this.f = obj;
        }

        public final void a() {
            InterfaceC7854Tm interfaceC7854Tm = C8556Wm.this.o;
            C8556Wm c8556Wm = C8556Wm.this;
            Object obj = this.f;
            float fE = c8556Wm.n().e(obj);
            if (!Float.isNaN(fE)) {
                InterfaceC7854Tm.b(interfaceC7854Tm, fE, 0.0f, 2, null);
                c8556Wm.C(null);
            }
            c8556Wm.B(obj);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public C8556Wm(Object obj, UA2 ua2, SA2 sa2, InterfaceC5766Kt interfaceC5766Kt, UA2 ua22) {
        this.a = ua2;
        this.b = sa2;
        this.c = interfaceC5766Kt;
        this.d = ua22;
        this.g = AbstractC13472gH6.d(obj, null, 2, null);
    }

    private final void A(KZ1 kz1) {
        this.n.setValue(kz1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(Object obj) {
        this.g.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(Object obj) {
        this.m.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(float f2) {
        this.l.s(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(float f2) {
        this.j.s(f2);
    }

    private final boolean G(Object obj) {
        return this.e.e(new k(obj));
    }

    public static /* synthetic */ void I(C8556Wm c8556Wm, KZ1 kz1, Object obj, int i2, Object obj2) {
        if ((i2 & 2) != 0 && (Float.isNaN(c8556Wm.v()) || (obj = kz1.b(c8556Wm.v())) == null)) {
            obj = c8556Wm.w();
        }
        c8556Wm.H(kz1, obj);
    }

    public static /* synthetic */ Object k(C8556Wm c8556Wm, Object obj, EnumC15562jn4 enumC15562jn4, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            enumC15562jn4 = EnumC15562jn4.a;
        }
        return c8556Wm.j(obj, enumC15562jn4, interfaceC16978mB2, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(float f2, Object obj, float f3) {
        Object objA;
        KZ1 kz1N = n();
        float fE = kz1N.e(obj);
        float fFloatValue = ((Number) this.b.invoke()).floatValue();
        if (fE == f2 || Float.isNaN(fE)) {
            return obj;
        }
        if (fE < f2) {
            if (f3 >= fFloatValue) {
                Object objA2 = kz1N.a(f2, true);
                AbstractC13042fc3.f(objA2);
                return objA2;
            }
            objA = kz1N.a(f2, true);
            AbstractC13042fc3.f(objA);
            if (f2 < Math.abs(fE + Math.abs(((Number) this.a.invoke(Float.valueOf(Math.abs(kz1N.e(objA) - fE)))).floatValue()))) {
                return obj;
            }
        } else {
            if (f3 <= (-fFloatValue)) {
                Object objA3 = kz1N.a(f2, false);
                AbstractC13042fc3.f(objA3);
                return objA3;
            }
            objA = kz1N.a(f2, false);
            AbstractC13042fc3.f(objA);
            float fAbs = Math.abs(fE - Math.abs(((Number) this.a.invoke(Float.valueOf(Math.abs(fE - kz1N.e(objA))))).floatValue()));
            if (f2 < 0.0f) {
                if (Math.abs(f2) < fAbs) {
                    return obj;
                }
            } else if (f2 > fAbs) {
                return obj;
            }
        }
        return objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(float f2, Object obj) {
        Object objA;
        KZ1 kz1N = n();
        float fE = kz1N.e(obj);
        if (fE == f2 || Float.isNaN(fE)) {
            return obj;
        }
        if (fE < f2) {
            objA = kz1N.a(f2, true);
            if (objA == null) {
                return obj;
            }
        } else {
            objA = kz1N.a(f2, false);
            if (objA == null) {
                return obj;
            }
        }
        return objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s() {
        return this.m.getValue();
    }

    public final Object F(float f2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objR = r();
        Object objL = l(z(), objR, f2);
        if (((Boolean) this.d.invoke(objL)).booleanValue()) {
            Object objF = AbstractC8322Vm.f(this, objL, f2, interfaceC20295rm1);
            return objF == AbstractC14862ic3.e() ? objF : C19938rB7.a;
        }
        Object objF2 = AbstractC8322Vm.f(this, objR, f2, interfaceC20295rm1);
        return objF2 == AbstractC14862ic3.e() ? objF2 : C19938rB7.a;
    }

    public final void H(KZ1 kz1, Object obj) {
        if (AbstractC13042fc3.d(n(), kz1)) {
            return;
        }
        A(kz1);
        if (G(obj)) {
            return;
        }
        C(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(ir.nasim.EnumC15562jn4 r7, ir.nasim.InterfaceC15796kB2 r8, ir.nasim.InterfaceC20295rm1 r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ir.nasim.C8556Wm.b
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.Wm$b r0 = (ir.nasim.C8556Wm.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Wm$b r0 = new ir.nasim.Wm$b
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1056964608(0x3f000000, float:0.5)
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r7 = r0.a
            ir.nasim.Wm r7 = (ir.nasim.C8556Wm) r7
            ir.nasim.AbstractC10685c16.b(r9)     // Catch: java.lang.Throwable -> L2f
            goto L50
        L2f:
            r8 = move-exception
            goto L89
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.Nb3 r9 = r6.e     // Catch: java.lang.Throwable -> L87
            ir.nasim.Wm$c r2 = new ir.nasim.Wm$c     // Catch: java.lang.Throwable -> L87
            r5 = 0
            r2.<init>(r8, r5)     // Catch: java.lang.Throwable -> L87
            r0.a = r6     // Catch: java.lang.Throwable -> L87
            r0.d = r4     // Catch: java.lang.Throwable -> L87
            java.lang.Object r7 = r9.d(r7, r2, r0)     // Catch: java.lang.Throwable -> L87
            if (r7 != r1) goto L4f
            return r1
        L4f:
            r7 = r6
        L50:
            ir.nasim.KZ1 r8 = r7.n()
            float r9 = r7.v()
            java.lang.Object r8 = r8.b(r9)
            if (r8 == 0) goto L84
            float r9 = r7.v()
            ir.nasim.KZ1 r0 = r7.n()
            float r0 = r0.e(r8)
            float r9 = r9 - r0
            float r9 = java.lang.Math.abs(r9)
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 > 0) goto L84
            ir.nasim.UA2 r9 = r7.d
            java.lang.Object r9 = r9.invoke(r8)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L84
            r7.B(r8)
        L84:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        L87:
            r8 = move-exception
            r7 = r6
        L89:
            ir.nasim.KZ1 r9 = r7.n()
            float r0 = r7.v()
            java.lang.Object r9 = r9.b(r0)
            if (r9 == 0) goto Lbd
            float r0 = r7.v()
            ir.nasim.KZ1 r1 = r7.n()
            float r1 = r1.e(r9)
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto Lbd
            ir.nasim.UA2 r0 = r7.d
            java.lang.Object r0 = r0.invoke(r9)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto Lbd
            r7.B(r9)
        Lbd:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8556Wm.i(ir.nasim.jn4, ir.nasim.kB2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r7, ir.nasim.EnumC15562jn4 r8, ir.nasim.InterfaceC16978mB2 r9, ir.nasim.InterfaceC20295rm1 r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof ir.nasim.C8556Wm.d
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.Wm$d r0 = (ir.nasim.C8556Wm.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Wm$d r0 = new ir.nasim.Wm$d
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1056964608(0x3f000000, float:0.5)
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r7 = r0.a
            ir.nasim.Wm r7 = (ir.nasim.C8556Wm) r7
            ir.nasim.AbstractC10685c16.b(r10)     // Catch: java.lang.Throwable -> L30
            goto L5a
        L30:
            r8 = move-exception
            goto L94
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.KZ1 r10 = r6.n()
            boolean r10 = r10.c(r7)
            if (r10 == 0) goto Lcc
            ir.nasim.Nb3 r10 = r6.e     // Catch: java.lang.Throwable -> L92
            ir.nasim.Wm$e r2 = new ir.nasim.Wm$e     // Catch: java.lang.Throwable -> L92
            r2.<init>(r7, r9, r5)     // Catch: java.lang.Throwable -> L92
            r0.a = r6     // Catch: java.lang.Throwable -> L92
            r0.d = r4     // Catch: java.lang.Throwable -> L92
            java.lang.Object r7 = r10.d(r8, r2, r0)     // Catch: java.lang.Throwable -> L92
            if (r7 != r1) goto L59
            return r1
        L59:
            r7 = r6
        L5a:
            r7.C(r5)
            ir.nasim.KZ1 r8 = r7.n()
            float r9 = r7.v()
            java.lang.Object r8 = r8.b(r9)
            if (r8 == 0) goto Lcf
            float r9 = r7.v()
            ir.nasim.KZ1 r10 = r7.n()
            float r10 = r10.e(r8)
            float r9 = r9 - r10
            float r9 = java.lang.Math.abs(r9)
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 > 0) goto Lcf
            ir.nasim.UA2 r9 = r7.d
            java.lang.Object r9 = r9.invoke(r8)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lcf
            r7.B(r8)
            goto Lcf
        L92:
            r8 = move-exception
            r7 = r6
        L94:
            r7.C(r5)
            ir.nasim.KZ1 r9 = r7.n()
            float r10 = r7.v()
            java.lang.Object r9 = r9.b(r10)
            if (r9 == 0) goto Lcb
            float r10 = r7.v()
            ir.nasim.KZ1 r0 = r7.n()
            float r0 = r0.e(r9)
            float r10 = r10 - r0
            float r10 = java.lang.Math.abs(r10)
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 > 0) goto Lcb
            ir.nasim.UA2 r10 = r7.d
            java.lang.Object r10 = r10.invoke(r9)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto Lcb
            r7.B(r9)
        Lcb:
            throw r8
        Lcc:
            r6.B(r7)
        Lcf:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8556Wm.j(java.lang.Object, ir.nasim.jn4, ir.nasim.mB2, ir.nasim.rm1):java.lang.Object");
    }

    public final KZ1 n() {
        return (KZ1) this.n.getValue();
    }

    public final InterfaceC5766Kt o() {
        return this.c;
    }

    public final Object p() {
        return this.i.getValue();
    }

    public final UA2 q() {
        return this.d;
    }

    public final Object r() {
        return this.g.getValue();
    }

    public final OZ1 t() {
        return this.f;
    }

    public final float u() {
        return this.l.a();
    }

    public final float v() {
        return this.j.a();
    }

    public final Object w() {
        return this.h.getValue();
    }

    public final boolean x() {
        return s() != null;
    }

    public final float y(float f2) {
        return AbstractC23053wG5.l((Float.isNaN(v()) ? 0.0f : v()) + f2, n().d(), n().f());
    }

    public final float z() {
        if (!Float.isNaN(v())) {
            return v();
        }
        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
    }
}
