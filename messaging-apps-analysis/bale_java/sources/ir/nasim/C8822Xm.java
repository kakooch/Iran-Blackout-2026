package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Xm, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8822Xm {
    public static final k p = new k(null);
    private final UA2 a;
    private final SA2 b;
    private final InterfaceC5766Kt c;
    private final UA2 d;
    private final InterfaceC9102Ym4 g;
    private final C6569Ob3 e = new C6569Ob3();
    private final OZ1 f = new g();
    private final InterfaceC9664aL6 h = AbstractC10222bH6.d(new i());
    private final InterfaceC9664aL6 i = AbstractC10222bH6.d(new f());
    private final InterfaceC14354hm4 j = AbstractC4326Eq5.a(Float.NaN);
    private final InterfaceC9664aL6 k = AbstractC10222bH6.e(AbstractC10222bH6.s(), new h());
    private final InterfaceC14354hm4 l = AbstractC4326Eq5.a(0.0f);
    private final InterfaceC9102Ym4 m = AbstractC13472gH6.d(null, null, 2, null);
    private final InterfaceC9102Ym4 n = AbstractC13472gH6.d(androidx.compose.material3.internal.b.i(), null, 2, null);
    private final InterfaceC7615Sm o = new e();

    /* renamed from: ir.nasim.Xm$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C8822Xm.this.i(null, null, this);
        }
    }

    /* renamed from: ir.nasim.Xm$b */
    static final class b extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ InterfaceC15796kB2 d;

        /* renamed from: ir.nasim.Xm$b$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C8822Xm e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8822Xm c8822Xm) {
                super(0);
                this.e = c8822Xm;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final JZ1 invoke() {
                return this.e.o();
            }
        }

        /* renamed from: ir.nasim.Xm$b$b, reason: collision with other inner class name */
        static final class C0768b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC15796kB2 d;
            final /* synthetic */ C8822Xm e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0768b(InterfaceC15796kB2 interfaceC15796kB2, C8822Xm c8822Xm, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC15796kB2;
                this.e = c8822Xm;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0768b c0768b = new C0768b(this.d, this.e, interfaceC20295rm1);
                c0768b.c = obj;
                return c0768b;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    JZ1 jz1 = (JZ1) this.c;
                    InterfaceC15796kB2 interfaceC15796kB2 = this.d;
                    InterfaceC7615Sm interfaceC7615Sm = this.e.o;
                    this.b = 1;
                    if (interfaceC15796kB2.q(interfaceC7615Sm, jz1, this) == objE) {
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
            public final Object invoke(JZ1 jz1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0768b) create(jz1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = interfaceC15796kB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C8822Xm.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                a aVar = new a(C8822Xm.this);
                C0768b c0768b = new C0768b(this.d, C8822Xm.this, null);
                this.b = 1;
                if (androidx.compose.material3.internal.b.j(aVar, c0768b, this) == objE) {
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
            return ((b) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Xm$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C8822Xm.this.j(null, null, null, this);
        }
    }

    /* renamed from: ir.nasim.Xm$d */
    static final class d extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ Object d;
        final /* synthetic */ InterfaceC16978mB2 e;

        /* renamed from: ir.nasim.Xm$d$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C8822Xm e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8822Xm c8822Xm) {
                super(0);
                this.e = c8822Xm;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final XV4 invoke() {
                return AbstractC4616Fw7.a(this.e.o(), this.e.x());
            }
        }

        /* renamed from: ir.nasim.Xm$d$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC16978mB2 d;
            final /* synthetic */ C8822Xm e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC16978mB2 interfaceC16978mB2, C8822Xm c8822Xm, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC16978mB2;
                this.e = c8822Xm;
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
                    JZ1 jz1 = (JZ1) xv4.a();
                    Object objB = xv4.b();
                    InterfaceC16978mB2 interfaceC16978mB2 = this.d;
                    InterfaceC7615Sm interfaceC7615Sm = this.e.o;
                    this.b = 1;
                    if (interfaceC16978mB2.e(interfaceC7615Sm, jz1, objB, this) == objE) {
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
        d(Object obj, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = obj;
            this.e = interfaceC16978mB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C8822Xm.this.new d(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C8822Xm.this.D(this.d);
                a aVar = new a(C8822Xm.this);
                b bVar = new b(this.e, C8822Xm.this, null);
                this.b = 1;
                if (androidx.compose.material3.internal.b.j(aVar, bVar, this) == objE) {
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
            return ((d) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Xm$e */
    public static final class e implements InterfaceC7615Sm {
        e() {
        }

        @Override // ir.nasim.InterfaceC7615Sm
        public void a(float f, float f2) {
            C8822Xm.this.F(f);
            C8822Xm.this.E(f2);
        }
    }

    /* renamed from: ir.nasim.Xm$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        f() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            Object objT = C8822Xm.this.t();
            if (objT != null) {
                return objT;
            }
            C8822Xm c8822Xm = C8822Xm.this;
            float fW = c8822Xm.w();
            return !Float.isNaN(fW) ? c8822Xm.m(fW, c8822Xm.s()) : c8822Xm.s();
        }
    }

    /* renamed from: ir.nasim.Xm$g */
    public static final class g implements OZ1 {
        private final b a;

        /* renamed from: ir.nasim.Xm$g$a */
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
                    b bVar = g.this.a;
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
            public final Object q(InterfaceC7615Sm interfaceC7615Sm, JZ1 jz1, InterfaceC20295rm1 interfaceC20295rm1) {
                return g.this.new a(this.d, interfaceC20295rm1).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Xm$g$b */
        public static final class b implements IZ1 {
            final /* synthetic */ C8822Xm a;

            b(C8822Xm c8822Xm) {
                this.a = c8822Xm;
            }

            @Override // ir.nasim.IZ1
            public void a(float f) {
                InterfaceC7615Sm.b(this.a.o, this.a.z(f), 0.0f, 2, null);
            }
        }

        g() {
            this.a = new b(C8822Xm.this);
        }

        @Override // ir.nasim.OZ1
        public Object a(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
            Object objI = C8822Xm.this.i(enumC15562jn4, new a(interfaceC14603iB2, null), interfaceC20295rm1);
            return objI == AbstractC14862ic3.e() ? objI : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xm$h */
    static final class h extends AbstractC8614Ws3 implements SA2 {
        h() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            float fE = C8822Xm.this.o().e(C8822Xm.this.s());
            float fE2 = C8822Xm.this.o().e(C8822Xm.this.q()) - fE;
            float fAbs = Math.abs(fE2);
            float f = 1.0f;
            if (!Float.isNaN(fAbs) && fAbs > 1.0E-6f) {
                float fA = (C8822Xm.this.A() - fE) / fE2;
                if (fA < 1.0E-6f) {
                    f = 0.0f;
                } else if (fA <= 0.999999f) {
                    f = fA;
                }
            }
            return Float.valueOf(f);
        }
    }

    /* renamed from: ir.nasim.Xm$i */
    static final class i extends AbstractC8614Ws3 implements SA2 {
        i() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            Object objT = C8822Xm.this.t();
            if (objT != null) {
                return objT;
            }
            C8822Xm c8822Xm = C8822Xm.this;
            float fW = c8822Xm.w();
            return !Float.isNaN(fW) ? c8822Xm.l(fW, c8822Xm.s(), 0.0f) : c8822Xm.s();
        }
    }

    /* renamed from: ir.nasim.Xm$j */
    static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Object f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Object obj) {
            super(0);
            this.f = obj;
        }

        public final void a() {
            InterfaceC7615Sm interfaceC7615Sm = C8822Xm.this.o;
            C8822Xm c8822Xm = C8822Xm.this;
            Object obj = this.f;
            float fE = c8822Xm.o().e(obj);
            if (!Float.isNaN(fE)) {
                InterfaceC7615Sm.b(interfaceC7615Sm, fE, 0.0f, 2, null);
                c8822Xm.D(null);
            }
            c8822Xm.C(obj);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xm$k */
    public static final class k {
        private k() {
        }

        public /* synthetic */ k(ED1 ed1) {
            this();
        }
    }

    public C8822Xm(Object obj, UA2 ua2, SA2 sa2, InterfaceC5766Kt interfaceC5766Kt, UA2 ua22) {
        this.a = ua2;
        this.b = sa2;
        this.c = interfaceC5766Kt;
        this.d = ua22;
        this.g = AbstractC13472gH6.d(obj, null, 2, null);
    }

    private final void B(JZ1 jz1) {
        this.n.setValue(jz1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(Object obj) {
        this.g.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(Object obj) {
        this.m.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(float f2) {
        this.l.s(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(float f2) {
        this.j.s(f2);
    }

    private final boolean H(Object obj) {
        return this.e.e(new j(obj));
    }

    public static /* synthetic */ Object k(C8822Xm c8822Xm, Object obj, EnumC15562jn4 enumC15562jn4, InterfaceC16978mB2 interfaceC16978mB2, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            enumC15562jn4 = EnumC15562jn4.a;
        }
        return c8822Xm.j(obj, enumC15562jn4, interfaceC16978mB2, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(float f2, Object obj, float f3) {
        Object objA;
        JZ1 jz1O = o();
        float fE = jz1O.e(obj);
        float fFloatValue = ((Number) this.b.invoke()).floatValue();
        if (fE == f2 || Float.isNaN(fE)) {
            return obj;
        }
        if (fE < f2) {
            if (f3 >= fFloatValue) {
                Object objA2 = jz1O.a(f2, true);
                AbstractC13042fc3.f(objA2);
                return objA2;
            }
            objA = jz1O.a(f2, true);
            AbstractC13042fc3.f(objA);
            if (f2 < Math.abs(fE + Math.abs(((Number) this.a.invoke(Float.valueOf(Math.abs(jz1O.e(objA) - fE)))).floatValue()))) {
                return obj;
            }
        } else {
            if (f3 <= (-fFloatValue)) {
                Object objA3 = jz1O.a(f2, false);
                AbstractC13042fc3.f(objA3);
                return objA3;
            }
            objA = jz1O.a(f2, false);
            AbstractC13042fc3.f(objA);
            float fAbs = Math.abs(fE - Math.abs(((Number) this.a.invoke(Float.valueOf(Math.abs(fE - jz1O.e(objA))))).floatValue()));
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
        JZ1 jz1O = o();
        float fE = jz1O.e(obj);
        if (fE == f2 || Float.isNaN(fE)) {
            return obj;
        }
        if (fE < f2) {
            objA = jz1O.a(f2, true);
            if (objA == null) {
                return obj;
            }
        } else {
            objA = jz1O.a(f2, false);
            if (objA == null) {
                return obj;
            }
        }
        return objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t() {
        return this.m.getValue();
    }

    public final float A() {
        if (!Float.isNaN(w())) {
            return w();
        }
        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
    }

    public final Object G(float f2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objS = s();
        Object objL = l(A(), objS, f2);
        if (((Boolean) this.d.invoke(objL)).booleanValue()) {
            Object objF = androidx.compose.material3.internal.b.f(this, objL, f2, interfaceC20295rm1);
            return objF == AbstractC14862ic3.e() ? objF : C19938rB7.a;
        }
        Object objF2 = androidx.compose.material3.internal.b.f(this, objS, f2, interfaceC20295rm1);
        return objF2 == AbstractC14862ic3.e() ? objF2 : C19938rB7.a;
    }

    public final void I(JZ1 jz1, Object obj) {
        if (AbstractC13042fc3.d(o(), jz1)) {
            return;
        }
        B(jz1);
        if (H(obj)) {
            return;
        }
        D(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(ir.nasim.EnumC15562jn4 r7, ir.nasim.InterfaceC15796kB2 r8, ir.nasim.InterfaceC20295rm1 r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ir.nasim.C8822Xm.a
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.Xm$a r0 = (ir.nasim.C8822Xm.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Xm$a r0 = new ir.nasim.Xm$a
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
            ir.nasim.Xm r7 = (ir.nasim.C8822Xm) r7
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
            ir.nasim.Ob3 r9 = r6.e     // Catch: java.lang.Throwable -> L87
            ir.nasim.Xm$b r2 = new ir.nasim.Xm$b     // Catch: java.lang.Throwable -> L87
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
            ir.nasim.JZ1 r8 = r7.o()
            float r9 = r7.w()
            java.lang.Object r8 = r8.b(r9)
            if (r8 == 0) goto L84
            float r9 = r7.w()
            ir.nasim.JZ1 r0 = r7.o()
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
            r7.C(r8)
        L84:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        L87:
            r8 = move-exception
            r7 = r6
        L89:
            ir.nasim.JZ1 r9 = r7.o()
            float r0 = r7.w()
            java.lang.Object r9 = r9.b(r0)
            if (r9 == 0) goto Lbd
            float r0 = r7.w()
            ir.nasim.JZ1 r1 = r7.o()
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
            r7.C(r9)
        Lbd:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8822Xm.i(ir.nasim.jn4, ir.nasim.kB2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r7, ir.nasim.EnumC15562jn4 r8, ir.nasim.InterfaceC16978mB2 r9, ir.nasim.InterfaceC20295rm1 r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof ir.nasim.C8822Xm.c
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.Xm$c r0 = (ir.nasim.C8822Xm.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Xm$c r0 = new ir.nasim.Xm$c
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
            ir.nasim.Xm r7 = (ir.nasim.C8822Xm) r7
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
            ir.nasim.JZ1 r10 = r6.o()
            boolean r10 = r10.c(r7)
            if (r10 == 0) goto Lcc
            ir.nasim.Ob3 r10 = r6.e     // Catch: java.lang.Throwable -> L92
            ir.nasim.Xm$d r2 = new ir.nasim.Xm$d     // Catch: java.lang.Throwable -> L92
            r2.<init>(r7, r9, r5)     // Catch: java.lang.Throwable -> L92
            r0.a = r6     // Catch: java.lang.Throwable -> L92
            r0.d = r4     // Catch: java.lang.Throwable -> L92
            java.lang.Object r7 = r10.d(r8, r2, r0)     // Catch: java.lang.Throwable -> L92
            if (r7 != r1) goto L59
            return r1
        L59:
            r7 = r6
        L5a:
            r7.D(r5)
            ir.nasim.JZ1 r8 = r7.o()
            float r9 = r7.w()
            java.lang.Object r8 = r8.b(r9)
            if (r8 == 0) goto Lcf
            float r9 = r7.w()
            ir.nasim.JZ1 r10 = r7.o()
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
            r7.C(r8)
            goto Lcf
        L92:
            r8 = move-exception
            r7 = r6
        L94:
            r7.D(r5)
            ir.nasim.JZ1 r9 = r7.o()
            float r10 = r7.w()
            java.lang.Object r9 = r9.b(r10)
            if (r9 == 0) goto Lcb
            float r10 = r7.w()
            ir.nasim.JZ1 r0 = r7.o()
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
            r7.C(r9)
        Lcb:
            throw r8
        Lcc:
            r6.C(r7)
        Lcf:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8822Xm.j(java.lang.Object, ir.nasim.jn4, ir.nasim.mB2, ir.nasim.rm1):java.lang.Object");
    }

    public final float n(float f2) {
        float fZ = z(f2);
        float fW = Float.isNaN(w()) ? 0.0f : w();
        F(fZ);
        return fZ - fW;
    }

    public final JZ1 o() {
        return (JZ1) this.n.getValue();
    }

    public final InterfaceC5766Kt p() {
        return this.c;
    }

    public final Object q() {
        return this.i.getValue();
    }

    public final UA2 r() {
        return this.d;
    }

    public final Object s() {
        return this.g.getValue();
    }

    public final OZ1 u() {
        return this.f;
    }

    public final float v() {
        return this.l.a();
    }

    public final float w() {
        return this.j.a();
    }

    public final Object x() {
        return this.h.getValue();
    }

    public final boolean y() {
        return t() != null;
    }

    public final float z(float f2) {
        return AbstractC23053wG5.l((Float.isNaN(w()) ? 0.0f : w()) + f2, o().d(), o().f());
    }
}
