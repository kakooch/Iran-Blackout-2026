package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.iK3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C14689iK3 implements InterfaceC14087hK3 {
    private final InterfaceC9102Ym4 a;
    private final InterfaceC9102Ym4 b;
    private final InterfaceC9102Ym4 c;
    private final InterfaceC9102Ym4 d;
    private final InterfaceC9102Ym4 e;
    private final InterfaceC9102Ym4 f;
    private final InterfaceC9102Ym4 g;
    private final InterfaceC9664aL6 h;
    private final InterfaceC9102Ym4 i;
    private final InterfaceC9102Ym4 j;
    private final InterfaceC9102Ym4 k;
    private final InterfaceC9102Ym4 l;
    private final InterfaceC9664aL6 m;
    private final InterfaceC9664aL6 n;
    private final C17335mn4 o;

    /* renamed from: ir.nasim.iK3$a */
    static final class a extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ boolean f;
        final /* synthetic */ float g;
        final /* synthetic */ C23677xK3 h;
        final /* synthetic */ float i;
        final /* synthetic */ boolean j;
        final /* synthetic */ boolean k;
        final /* synthetic */ EnumC22491vK3 l;

        /* renamed from: ir.nasim.iK3$a$a, reason: collision with other inner class name */
        static final class C1291a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ EnumC22491vK3 c;
            final /* synthetic */ InterfaceC13730gj3 d;
            final /* synthetic */ int e;
            final /* synthetic */ int f;
            final /* synthetic */ C14689iK3 g;

            /* renamed from: ir.nasim.iK3$a$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C1292a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC22491vK3.values().length];
                    try {
                        iArr[EnumC22491vK3.b.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1291a(EnumC22491vK3 enumC22491vK3, InterfaceC13730gj3 interfaceC13730gj3, int i, int i2, C14689iK3 c14689iK3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = enumC22491vK3;
                this.d = interfaceC13730gj3;
                this.e = i;
                this.f = i2;
                this.g = c14689iK3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1291a(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
            }

            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0034 A[ADDED_TO_REGION, REMOVE] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0040 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003e -> B:19:0x0041). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r4) {
                /*
                    r3 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r3.b
                    r2 = 1
                    if (r1 == 0) goto L17
                    if (r1 != r2) goto Lf
                    ir.nasim.AbstractC10685c16.b(r4)
                    goto L41
                Lf:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r0)
                    throw r4
                L17:
                    ir.nasim.AbstractC10685c16.b(r4)
                L1a:
                    ir.nasim.vK3 r4 = r3.c
                    int[] r1 = ir.nasim.C14689iK3.a.C1291a.C1292a.a
                    int r4 = r4.ordinal()
                    r4 = r1[r4]
                    if (r4 != r2) goto L34
                    ir.nasim.gj3 r4 = r3.d
                    boolean r4 = r4.b()
                    if (r4 == 0) goto L31
                    int r4 = r3.e
                    goto L36
                L31:
                    int r4 = r3.f
                    goto L36
                L34:
                    int r4 = r3.e
                L36:
                    ir.nasim.iK3 r1 = r3.g
                    r3.b = r2
                    java.lang.Object r4 = ir.nasim.C14689iK3.f(r1, r4, r3)
                    if (r4 != r0) goto L41
                    return r0
                L41:
                    java.lang.Boolean r4 = (java.lang.Boolean) r4
                    boolean r4 = r4.booleanValue()
                    if (r4 != 0) goto L1a
                    ir.nasim.rB7 r4 = ir.nasim.C19938rB7.a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14689iK3.a.C1291a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1291a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.iK3$a$b */
        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC22491vK3.values().length];
                try {
                    iArr[EnumC22491vK3.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC22491vK3.a.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, int i2, boolean z, float f, AbstractC23087wK3 abstractC23087wK3, C23677xK3 c23677xK3, float f2, boolean z2, boolean z3, EnumC22491vK3 enumC22491vK3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = i;
            this.e = i2;
            this.f = z;
            this.g = f;
            this.h = c23677xK3;
            this.i = f2;
            this.j = z2;
            this.k = z3;
            this.l = enumC22491vK3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C14689iK3.this.new a(this.d, this.e, this.f, this.g, null, this.h, this.i, this.j, this.k, this.l, interfaceC20295rm1);
        }

        /* JADX WARN: Finally extract failed */
        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC11938do1 interfaceC11938do1;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C14689iK3.this.T(this.d);
                    C14689iK3.this.U(this.e);
                    C14689iK3.this.Z(this.f);
                    C14689iK3.this.a0(this.g);
                    C14689iK3.this.R(null);
                    C14689iK3.this.S(this.h);
                    C14689iK3.this.c0(this.i);
                    C14689iK3.this.b0(this.j);
                    if (!this.k) {
                        C14689iK3.this.V(Long.MIN_VALUE);
                    }
                    if (this.h == null) {
                        C14689iK3.this.W(false);
                        return C19938rB7.a;
                    }
                    if (Float.isInfinite(this.g)) {
                        C14689iK3 c14689iK3 = C14689iK3.this;
                        c14689iK3.c0(c14689iK3.K());
                        C14689iK3.this.W(false);
                        C14689iK3.this.T(this.e);
                        return C19938rB7.a;
                    }
                    C14689iK3.this.W(true);
                    int i2 = b.a[this.l.ordinal()];
                    if (i2 == 1) {
                        interfaceC11938do1 = C12798fB4.b;
                    } else {
                        if (i2 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        interfaceC11938do1 = C18712p72.a;
                    }
                    C1291a c1291a = new C1291a(this.l, AbstractC19067pj3.p(getContext()), this.e, this.d, C14689iK3.this, null);
                    this.b = 1;
                    if (AbstractC9323Zl0.g(interfaceC11938do1, c1291a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                AbstractC19067pj3.n(getContext());
                C14689iK3.this.W(false);
                return C19938rB7.a;
            } catch (Throwable th) {
                C14689iK3.this.W(false);
                throw th;
            }
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.iK3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i) {
            super(1);
            this.f = i;
        }

        public final Boolean a(long j) {
            return Boolean.valueOf(C14689iK3.this.P(this.f, j));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).longValue());
        }
    }

    /* renamed from: ir.nasim.iK3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i) {
            super(1);
            this.f = i;
        }

        public final Boolean a(long j) {
            return Boolean.valueOf(C14689iK3.this.P(this.f, j));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).longValue());
        }
    }

    /* renamed from: ir.nasim.iK3$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            float f = 0.0f;
            if (C14689iK3.this.u() != null) {
                if (C14689iK3.this.r() < 0.0f) {
                    C14689iK3.this.v();
                } else {
                    C14689iK3.this.v();
                    f = 1.0f;
                }
            }
            return Float.valueOf(f);
        }
    }

    /* renamed from: ir.nasim.iK3$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf((C14689iK3.this.p() && C14689iK3.this.t() % 2 == 0) ? -C14689iK3.this.r() : C14689iK3.this.r());
        }
    }

    /* renamed from: ir.nasim.iK3$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        f() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(C14689iK3.this.t() == C14689iK3.this.q() && C14689iK3.this.b() == C14689iK3.this.K());
        }
    }

    /* renamed from: ir.nasim.iK3$g */
    static final class g extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ C23677xK3 d;
        final /* synthetic */ float e;
        final /* synthetic */ int f;
        final /* synthetic */ boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C23677xK3 c23677xK3, float f, int i, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = c23677xK3;
            this.e = f;
            this.f = i;
            this.g = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C14689iK3.this.new g(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C14689iK3.this.S(this.d);
            C14689iK3.this.c0(this.e);
            C14689iK3.this.T(this.f);
            C14689iK3.this.W(false);
            if (this.g) {
                C14689iK3.this.V(Long.MIN_VALUE);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C14689iK3() {
        Boolean bool = Boolean.FALSE;
        this.a = AbstractC13472gH6.d(bool, null, 2, null);
        this.b = AbstractC13472gH6.d(1, null, 2, null);
        this.c = AbstractC13472gH6.d(1, null, 2, null);
        this.d = AbstractC13472gH6.d(bool, null, 2, null);
        this.e = AbstractC13472gH6.d(null, null, 2, null);
        this.f = AbstractC13472gH6.d(Float.valueOf(1.0f), null, 2, null);
        this.g = AbstractC13472gH6.d(bool, null, 2, null);
        this.h = AbstractC10222bH6.d(new e());
        this.i = AbstractC13472gH6.d(null, null, 2, null);
        Float fValueOf = Float.valueOf(0.0f);
        this.j = AbstractC13472gH6.d(fValueOf, null, 2, null);
        this.k = AbstractC13472gH6.d(fValueOf, null, 2, null);
        this.l = AbstractC13472gH6.d(Long.MIN_VALUE, null, 2, null);
        this.m = AbstractC10222bH6.d(new d());
        this.n = AbstractC10222bH6.d(new f());
        this.o = new C17335mn4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object J(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        return i == Integer.MAX_VALUE ? AbstractC19885r63.a(new b(i), interfaceC20295rm1) : AbstractC16704lj4.c(new c(i), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float K() {
        return ((Number) this.m.getValue()).floatValue();
    }

    private final float L() {
        return ((Number) this.h.getValue()).floatValue();
    }

    private final float N() {
        return ((Number) this.j.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean P(int i, long j) {
        C23677xK3 c23677xK3U = u();
        if (c23677xK3U == null) {
            return true;
        }
        long jM = M() == Long.MIN_VALUE ? 0L : j - M();
        V(j);
        v();
        v();
        float fD = ((jM / 1000000) / c23677xK3U.d()) * L();
        float fN = L() < 0.0f ? 0.0f - (N() + fD) : (N() + fD) - 1.0f;
        if (0.0f == 1.0f) {
            c0(0.0f);
            return false;
        }
        if (fN < 0.0f) {
            c0(AbstractC23053wG5.l(N(), 0.0f, 1.0f) + fD);
        } else {
            float f2 = 1.0f - 0.0f;
            int i2 = (int) (fN / f2);
            int i3 = i2 + 1;
            if (t() + i3 > i) {
                c0(K());
                T(i);
                return false;
            }
            T(t() + i3);
            float f3 = fN - (i2 * f2);
            c0(L() < 0.0f ? 1.0f - f3 : 0.0f + f3);
        }
        return true;
    }

    private final float Q(float f2, C23677xK3 c23677xK3) {
        if (c23677xK3 == null) {
            return f2;
        }
        return f2 - (f2 % (1 / c23677xK3.i()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(AbstractC23087wK3 abstractC23087wK3) {
        this.e.setValue(abstractC23087wK3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(C23677xK3 c23677xK3) {
        this.i.setValue(c23677xK3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i) {
        this.b.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i) {
        this.c.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(long j) {
        this.l.setValue(Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(boolean z) {
        this.a.setValue(Boolean.valueOf(z));
    }

    private void X(float f2) {
        this.k.setValue(Float.valueOf(f2));
    }

    private final void Y(float f2) {
        this.j.setValue(Float.valueOf(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(boolean z) {
        this.d.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(float f2) {
        this.f.setValue(Float.valueOf(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(boolean z) {
        this.g.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(float f2) {
        Y(f2);
        if (O()) {
            f2 = Q(f2, u());
        }
        X(f2);
    }

    public long M() {
        return ((Number) this.l.getValue()).longValue();
    }

    public boolean O() {
        return ((Boolean) this.g.getValue()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC17651nK3
    public float b() {
        return ((Number) this.k.getValue()).floatValue();
    }

    @Override // ir.nasim.InterfaceC14087hK3
    public Object g(C23677xK3 c23677xK3, int i, int i2, boolean z, float f2, AbstractC23087wK3 abstractC23087wK3, float f3, boolean z2, EnumC22491vK3 enumC22491vK3, boolean z3, boolean z4, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = C17335mn4.e(this.o, null, new a(i, i2, z, f2, abstractC23087wK3, c23677xK3, f3, z4, z2, enumC22491vK3, null), interfaceC20295rm1, 1, null);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC14087hK3
    public Object k(C23677xK3 c23677xK3, float f2, int i, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = C17335mn4.e(this.o, null, new g(c23677xK3, f2, i, z, null), interfaceC20295rm1, 1, null);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC17651nK3
    public boolean p() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC17651nK3
    public int q() {
        return ((Number) this.c.getValue()).intValue();
    }

    @Override // ir.nasim.InterfaceC17651nK3
    public float r() {
        return ((Number) this.f.getValue()).floatValue();
    }

    @Override // ir.nasim.InterfaceC17651nK3
    public int t() {
        return ((Number) this.b.getValue()).intValue();
    }

    @Override // ir.nasim.InterfaceC17651nK3
    public C23677xK3 u() {
        return (C23677xK3) this.i.getValue();
    }

    @Override // ir.nasim.InterfaceC17651nK3
    public AbstractC23087wK3 v() {
        AbstractC18350oW3.a(this.e.getValue());
        return null;
    }

    @Override // ir.nasim.InterfaceC9664aL6
    public Float getValue() {
        return Float.valueOf(b());
    }
}
