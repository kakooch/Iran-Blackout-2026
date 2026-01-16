package ir.nasim;

import androidx.compose.foundation.lazy.layout.d;
import androidx.compose.runtime.snapshots.g;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class GT4 implements InterfaceC11049ce6 {
    private final CV A;
    private final InterfaceC9102Ym4 B;
    private final SM5 C;
    private long D;
    private final C4861Gw3 E;
    private final InterfaceC9102Ym4 F;
    private final InterfaceC9102Ym4 G;
    private final InterfaceC9102Ym4 H;
    private final InterfaceC9102Ym4 I;
    private final InterfaceC9102Ym4 J;
    private final InterfaceC9102Ym4 K;
    private boolean a;
    private C21326tT4 b;
    private final InterfaceC9102Ym4 c;
    private final C24349yT4 d;
    private int e;
    private int f;
    private long g;
    private long h;
    private float i;
    private float j;
    private final InterfaceC11049ce6 k;
    private int l;
    private int m;
    private boolean n;
    private int o;
    private d.b p;
    private boolean q;
    private InterfaceC9102Ym4 r;
    private WH1 s;
    private final InterfaceC18507om4 t;
    private final InterfaceC17916nm4 u;
    private final InterfaceC17916nm4 v;
    private final InterfaceC9664aL6 w;
    private final InterfaceC9664aL6 x;
    private final androidx.compose.foundation.lazy.layout.d y;
    private final C15060iw3 z;

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        float d;
        /* synthetic */ Object e;
        int g;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return GT4.this.m(0, 0.0f, null, this);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ int e;
        final /* synthetic */ float f;
        final /* synthetic */ InterfaceC5766Kt g;

        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ GT4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(GT4 gt4) {
                super(2);
                this.e = gt4;
            }

            public final void a(InterfaceC8748Xd6 interfaceC8748Xd6, int i) {
                this.e.o0(interfaceC8748Xd6, i);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC8748Xd6) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, float f, InterfaceC5766Kt interfaceC5766Kt, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = i;
            this.f = f;
            this.g = interfaceC5766Kt;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = GT4.this.new b(this.e, this.f, this.g, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC5563Jw3 interfaceC5563Jw3A = AT4.a(GT4.this, (InterfaceC8748Xd6) this.c);
                int i2 = this.e;
                float f = this.f;
                InterfaceC5766Kt interfaceC5766Kt = this.g;
                a aVar = new a(GT4.this);
                this.b = 1;
                if (IT4.d(interfaceC5563Jw3A, i2, f, interfaceC5766Kt, aVar, this) == objE) {
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
        public final Object invoke(InterfaceC8748Xd6 interfaceC8748Xd6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC8748Xd6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        c() {
            super(1);
        }

        public final void a(InterfaceC23982xq4 interfaceC23982xq4) {
            g.a aVar = androidx.compose.runtime.snapshots.g.e;
            GT4 gt4 = GT4.this;
            androidx.compose.runtime.snapshots.g gVarD = aVar.d();
            UA2 ua2G = gVarD != null ? gVarD.g() : null;
            androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
            try {
                interfaceC23982xq4.a(gt4.y());
                C19938rB7 c19938rB7 = C19938rB7.a;
            } finally {
                aVar.l(gVarD, gVarE, ua2G);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC23982xq4) obj);
            return C19938rB7.a;
        }
    }

    public static final class d implements SM5 {
        d() {
        }

        @Override // ir.nasim.SM5
        public void h(RM5 rm5) {
            GT4.this.j0(rm5);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return GT4.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GT4 gt4 = GT4.this;
                this.b = 1;
                if (AbstractC7778Td6.e(gt4, null, this, 1, null) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return GT4.b0(GT4.this, null, null, this);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ float d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(float f, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = f;
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return GT4.this.new g(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GT4 gt4 = GT4.this;
                this.b = 1;
                if (gt4.q(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            float f = this.d;
            double d = f;
            boolean z = false;
            if (-0.5d <= d && d <= 0.5d) {
                z = true;
            }
            if (!z) {
                P73.a("pageOffsetFraction " + f + " is not within the range -0.5 to 0.5");
            }
            GT4.this.m0(GT4.this.s(this.e), this.d, true);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC8748Xd6 interfaceC8748Xd6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC8748Xd6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC8614Ws3 implements UA2 {
        h() {
            super(1);
        }

        public final Float a(float f) {
            return Float.valueOf(GT4.this.Y(f));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).floatValue());
        }
    }

    static final class i extends AbstractC8614Ws3 implements SA2 {
        i() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(GT4.this.c() ? GT4.this.S() : GT4.this.v());
        }
    }

    static final class j extends AbstractC8614Ws3 implements SA2 {
        j() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(GT4.this.s(!GT4.this.c() ? GT4.this.v() : GT4.this.P() != -1 ? GT4.this.P() : Math.abs(GT4.this.w()) >= Math.abs(GT4.this.N()) ? GT4.this.B() ? GT4.this.y() + 1 : GT4.this.y() : GT4.this.v()));
        }
    }

    public GT4(int i2, float f2, InterfaceC4989Hk5 interfaceC4989Hk5) {
        double d2 = f2;
        boolean z = false;
        if (-0.5d <= d2 && d2 <= 0.5d) {
            z = true;
        }
        if (!z) {
            P73.a("currentPageOffsetFraction " + f2 + " is not within the range -0.5 to 0.5");
        }
        this.c = AbstractC13472gH6.d(ZG4.d(ZG4.b.c()), null, 2, null);
        C24349yT4 c24349yT4 = new C24349yT4(i2, f2, this);
        this.d = c24349yT4;
        this.e = i2;
        this.g = Long.MAX_VALUE;
        this.k = AbstractC11844de6.a(new h());
        this.n = true;
        this.o = -1;
        this.r = AbstractC10222bH6.h(IT4.j(), AbstractC10222bH6.j());
        this.s = IT4.c;
        this.t = AbstractC23831xb3.a();
        this.u = UG6.a(-1);
        this.v = UG6.a(i2);
        this.w = AbstractC10222bH6.e(AbstractC10222bH6.s(), new i());
        this.x = AbstractC10222bH6.e(AbstractC10222bH6.s(), new j());
        this.y = new androidx.compose.foundation.lazy.layout.d(interfaceC4989Hk5, new c());
        this.z = new C15060iw3();
        this.A = new CV();
        this.B = AbstractC13472gH6.d(null, null, 2, null);
        this.C = new d();
        this.D = AbstractC19606qe1.b(0, 0, 0, 0, 15, null);
        this.E = new C4861Gw3();
        c24349yT4.d();
        this.F = LG4.c(null, 1, null);
        this.G = LG4.c(null, 1, null);
        Boolean bool = Boolean.FALSE;
        this.H = AbstractC13472gH6.d(bool, null, 2, null);
        this.I = AbstractC13472gH6.d(bool, null, 2, null);
        this.J = AbstractC13472gH6.d(bool, null, 2, null);
        this.K = AbstractC13472gH6.d(bool, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int P() {
        return this.u.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int S() {
        return this.v.d();
    }

    private final boolean U(float f2) {
        if (C().a() != EnumC24286yM4.a ? Math.signum(f2) != Math.signum(-Float.intBitsToFloat((int) (T() >> 32))) : Math.signum(f2) != Math.signum(-Float.intBitsToFloat((int) (T() & 4294967295L)))) {
            if (!V()) {
                return false;
            }
        }
        return true;
    }

    private final void X(float f2, InterfaceC17733nT4 interfaceC17733nT4) {
        d.b bVar;
        d.b bVar2;
        d.b bVar3;
        if (this.n && (!interfaceC17733nT4.i().isEmpty())) {
            boolean z = f2 > 0.0f;
            int index = z ? ((InterfaceC9734aT4) AbstractC15401jX0.C0(interfaceC17733nT4.i())).getIndex() + interfaceC17733nT4.m() + 1 : (((InterfaceC9734aT4) AbstractC15401jX0.q0(interfaceC17733nT4.i())).getIndex() - interfaceC17733nT4.m()) - 1;
            if (index < 0 || index >= H()) {
                return;
            }
            if (index != this.o) {
                if (this.q != z && (bVar3 = this.p) != null) {
                    bVar3.cancel();
                }
                this.q = z;
                this.o = index;
                this.p = this.y.e(index, this.D);
            }
            if (z) {
                if ((((InterfaceC9734aT4) AbstractC15401jX0.C0(interfaceC17733nT4.i())).getOffset() + (interfaceC17733nT4.h() + interfaceC17733nT4.l())) - interfaceC17733nT4.d() >= f2 || (bVar2 = this.p) == null) {
                    return;
                }
                bVar2.a();
                return;
            }
            if (interfaceC17733nT4.f() - ((InterfaceC9734aT4) AbstractC15401jX0.q0(interfaceC17733nT4.i())).getOffset() >= (-f2) || (bVar = this.p) == null) {
                return;
            }
            bVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float Y(float f2) {
        C21326tT4 c21326tT4;
        long jA = AbstractC24943zT4.a(this);
        float f3 = this.i + f2;
        long jF = AbstractC20723sV3.f(f3);
        this.i = f3 - jF;
        if (Math.abs(f2) < 1.0E-4f) {
            return f2;
        }
        long j2 = jF + jA;
        long jO = AbstractC23053wG5.o(j2, this.h, this.g);
        boolean z = j2 != jO;
        long j3 = jO - jA;
        float f4 = j3;
        this.j = f4;
        if (Math.abs(j3) != 0) {
            this.J.setValue(Boolean.valueOf(f4 > 0.0f));
            this.K.setValue(Boolean.valueOf(f4 < 0.0f));
        }
        int i2 = (int) j3;
        int i3 = -i2;
        C21326tT4 c21326tT4O = ((C21326tT4) this.r.getValue()).o(i3);
        if (c21326tT4O != null && (c21326tT4 = this.b) != null) {
            C21326tT4 c21326tT4O2 = c21326tT4 != null ? c21326tT4.o(i3) : null;
            if (c21326tT4O2 != null) {
                this.b = c21326tT4O2;
            } else {
                c21326tT4O = null;
            }
        }
        if (c21326tT4O != null) {
            o(c21326tT4O, this.a, true);
            LG4.d(this.F);
            this.m++;
        } else {
            this.d.a(i2);
            RM5 rm5Q = Q();
            if (rm5Q != null) {
                rm5Q.l();
            }
            this.l++;
        }
        return (z ? Long.valueOf(j3) : Float.valueOf(f2)).floatValue();
    }

    public static /* synthetic */ void a0(GT4 gt4, int i2, float f2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestScrollToPage");
        }
        if ((i3 & 2) != 0) {
            f2 = 0.0f;
        }
        gt4.Z(i2, f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object b0(ir.nasim.GT4 r5, ir.nasim.EnumC15562jn4 r6, ir.nasim.InterfaceC14603iB2 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            boolean r0 = r8 instanceof ir.nasim.GT4.f
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.GT4$f r0 = (ir.nasim.GT4.f) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.GT4$f r0 = new ir.nasim.GT4$f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.a
            ir.nasim.GT4 r5 = (ir.nasim.GT4) r5
            ir.nasim.AbstractC10685c16.b(r8)
            goto L7b
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r5 = r0.c
            r7 = r5
            ir.nasim.iB2 r7 = (ir.nasim.InterfaceC14603iB2) r7
            java.lang.Object r5 = r0.b
            r6 = r5
            ir.nasim.jn4 r6 = (ir.nasim.EnumC15562jn4) r6
            java.lang.Object r5 = r0.a
            ir.nasim.GT4 r5 = (ir.nasim.GT4) r5
            ir.nasim.AbstractC10685c16.b(r8)
            goto L5c
        L4a:
            ir.nasim.AbstractC10685c16.b(r8)
            r0.a = r5
            r0.b = r6
            r0.c = r7
            r0.f = r4
            java.lang.Object r8 = r5.q(r0)
            if (r8 != r1) goto L5c
            return r1
        L5c:
            boolean r8 = r5.c()
            if (r8 != 0) goto L69
            int r8 = r5.v()
            r5.k0(r8)
        L69:
            ir.nasim.ce6 r8 = r5.k
            r0.a = r5
            r2 = 0
            r0.b = r2
            r0.c = r2
            r0.f = r3
            java.lang.Object r6 = r8.b(r6, r7, r0)
            if (r6 != r1) goto L7b
            return r1
        L7b:
            r6 = -1
            r5.i0(r6)
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GT4.b0(ir.nasim.GT4, ir.nasim.jn4, ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ Object d0(GT4 gt4, int i2, float f2, InterfaceC20295rm1 interfaceC20295rm1, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
        }
        if ((i3 & 2) != 0) {
            f2 = 0.0f;
        }
        return gt4.c0(i2, f2, interfaceC20295rm1);
    }

    private final void e0(boolean z) {
        this.I.setValue(Boolean.valueOf(z));
    }

    private final void f0(boolean z) {
        this.H.setValue(Boolean.valueOf(z));
    }

    private final void i0(int i2) {
        this.u.h(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(RM5 rm5) {
        this.B.setValue(rm5);
    }

    private final void k0(int i2) {
        this.v.h(i2);
    }

    public static /* synthetic */ Object n(GT4 gt4, int i2, float f2, InterfaceC5766Kt interfaceC5766Kt, InterfaceC20295rm1 interfaceC20295rm1, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
        }
        if ((i3 & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i3 & 4) != 0) {
            interfaceC5766Kt = AbstractC5999Lt.j(0.0f, 0.0f, null, 7, null);
        }
        return gt4.m(i2, f2, interfaceC5766Kt, interfaceC20295rm1);
    }

    private final void n0(C21326tT4 c21326tT4) {
        g.a aVar = androidx.compose.runtime.snapshots.g.e;
        androidx.compose.runtime.snapshots.g gVarD = aVar.d();
        UA2 ua2G = gVarD != null ? gVarD.g() : null;
        androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
        try {
            if (Math.abs(this.j) > 0.5f && this.n && U(this.j)) {
                X(this.j, c21326tT4);
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            aVar.l(gVarD, gVarE, ua2G);
        } catch (Throwable th) {
            aVar.l(gVarD, gVarE, ua2G);
            throw th;
        }
    }

    public static /* synthetic */ void p(GT4 gt4, C21326tT4 c21326tT4, boolean z, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyMeasureResult");
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        gt4.o(c21326tT4, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objK = this.A.k(interfaceC20295rm1);
        return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
    }

    private final void r(InterfaceC17733nT4 interfaceC17733nT4) {
        if (this.o == -1 || !(!interfaceC17733nT4.i().isEmpty())) {
            return;
        }
        if (this.o != (this.q ? ((InterfaceC9734aT4) AbstractC15401jX0.C0(interfaceC17733nT4.i())).getIndex() + interfaceC17733nT4.m() + 1 : (((InterfaceC9734aT4) AbstractC15401jX0.q0(interfaceC17733nT4.i())).getIndex() - interfaceC17733nT4.m()) - 1)) {
            this.o = -1;
            d.b bVar = this.p;
            if (bVar != null) {
                bVar.cancel();
            }
            this.p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s(int i2) {
        if (H() > 0) {
            return AbstractC23053wG5.m(i2, 0, H() - 1);
        }
        return 0;
    }

    public final InterfaceC18507om4 A() {
        return this.t;
    }

    public boolean B() {
        return ((Boolean) this.J.getValue()).booleanValue();
    }

    public final InterfaceC17733nT4 C() {
        return (InterfaceC17733nT4) this.r.getValue();
    }

    public final long D() {
        return this.g;
    }

    public final InterfaceC9102Ym4 E() {
        return this.G;
    }

    public final long F() {
        return this.h;
    }

    public final C24411ya3 G() {
        return (C24411ya3) this.d.d().getValue();
    }

    public abstract int H();

    public final int I() {
        return ((C21326tT4) this.r.getValue()).h();
    }

    public final int J() {
        return I() + K();
    }

    public final int K() {
        return ((C21326tT4) this.r.getValue()).l();
    }

    public final C4861Gw3 L() {
        return this.E;
    }

    public final InterfaceC9102Ym4 M() {
        return this.F;
    }

    public final float N() {
        return Math.min(this.s.w1(IT4.i()), I() / 2.0f) / I();
    }

    public final androidx.compose.foundation.lazy.layout.d O() {
        return this.y;
    }

    public final RM5 Q() {
        return (RM5) this.B.getValue();
    }

    public final SM5 R() {
        return this.C;
    }

    public final long T() {
        return ((ZG4) this.c.getValue()).t();
    }

    public final boolean V() {
        return ((int) Float.intBitsToFloat((int) (T() >> 32))) == 0 && ((int) Float.intBitsToFloat((int) (T() & 4294967295L))) == 0;
    }

    public final int W(C19506qT4 c19506qT4, int i2) {
        return this.d.e(c19506qT4, i2);
    }

    public final void Z(int i2, float f2) {
        if (c()) {
            AbstractC10533bm0.d(((C21326tT4) this.r.getValue()).r(), null, null, new e(null), 3, null);
        }
        m0(i2, f2, false);
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public Object b(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return b0(this, enumC15562jn4, interfaceC14603iB2, interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public boolean c() {
        return this.k.c();
    }

    public final Object c0(int i2, float f2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = InterfaceC11049ce6.a(this, null, new g(f2, i2, null), interfaceC20295rm1, 1, null);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public final boolean d() {
        return ((Boolean) this.I.getValue()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public final boolean e() {
        return ((Boolean) this.H.getValue()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public float f(float f2) {
        return this.k.f(f2);
    }

    public final void g0(WH1 wh1) {
        this.s = wh1;
    }

    public final void h0(long j2) {
        this.D = j2;
    }

    public final void l0(long j2) {
        this.c.setValue(ZG4.d(j2));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(int r12, float r13, ir.nasim.InterfaceC5766Kt r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof ir.nasim.GT4.a
            if (r0 == 0) goto L14
            r0 = r15
            ir.nasim.GT4$a r0 = (ir.nasim.GT4.a) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.g = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            ir.nasim.GT4$a r0 = new ir.nasim.GT4$a
            r0.<init>(r15)
            goto L12
        L1a:
            java.lang.Object r15 = r4.e
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r4.g
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L48
            if (r1 == r3) goto L37
            if (r1 != r2) goto L2f
            ir.nasim.AbstractC10685c16.b(r15)
            goto Lc5
        L2f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L37:
            float r13 = r4.d
            int r12 = r4.c
            java.lang.Object r14 = r4.b
            ir.nasim.Kt r14 = (ir.nasim.InterfaceC5766Kt) r14
            java.lang.Object r1 = r4.a
            ir.nasim.GT4 r1 = (ir.nasim.GT4) r1
            ir.nasim.AbstractC10685c16.b(r15)
        L46:
            r9 = r14
            goto L76
        L48:
            ir.nasim.AbstractC10685c16.b(r15)
            int r15 = r11.v()
            if (r12 != r15) goto L5a
            float r15 = r11.w()
            int r15 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r15 != 0) goto L5a
            goto L60
        L5a:
            int r15 = r11.H()
            if (r15 != 0) goto L63
        L60:
            ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
            return r12
        L63:
            r4.a = r11
            r4.b = r14
            r4.c = r12
            r4.d = r13
            r4.g = r3
            java.lang.Object r15 = r11.q(r4)
            if (r15 != r0) goto L74
            return r0
        L74:
            r1 = r11
            goto L46
        L76:
            double r14 = (double) r13
            r5 = -4620693217682128896(0xbfe0000000000000, double:-0.5)
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            r6 = 0
            if (r5 > 0) goto L85
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r14 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r14 > 0) goto L85
            goto L86
        L85:
            r3 = r6
        L86:
            if (r3 != 0) goto La1
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "pageOffsetFraction "
            r14.append(r15)
            r14.append(r13)
            java.lang.String r15 = " is not within the range -0.5 to 0.5"
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            ir.nasim.P73.a(r14)
        La1:
            int r7 = r1.s(r12)
            int r12 = r1.J()
            float r12 = (float) r12
            float r8 = r13 * r12
            ir.nasim.GT4$b r3 = new ir.nasim.GT4$b
            r10 = 0
            r5 = r3
            r6 = r1
            r5.<init>(r7, r8, r9, r10)
            r12 = 0
            r4.a = r12
            r4.b = r12
            r4.g = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r12 = ir.nasim.InterfaceC11049ce6.a(r1, r2, r3, r4, r5, r6)
            if (r12 != r0) goto Lc5
            return r0
        Lc5:
            ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GT4.m(int, float, ir.nasim.Kt, ir.nasim.rm1):java.lang.Object");
    }

    public final void m0(int i2, float f2, boolean z) {
        this.d.f(i2, f2);
        if (!z) {
            LG4.d(this.G);
            return;
        }
        RM5 rm5Q = Q();
        if (rm5Q != null) {
            rm5Q.l();
        }
    }

    public final void o(C21326tT4 c21326tT4, boolean z, boolean z2) {
        if (!z && this.a) {
            this.b = c21326tT4;
            return;
        }
        if (z) {
            this.a = true;
        }
        if (z2) {
            this.d.j(c21326tT4.u());
        } else {
            this.d.k(c21326tT4);
            r(c21326tT4);
        }
        this.r.setValue(c21326tT4);
        f0(c21326tT4.q());
        e0(c21326tT4.p());
        C14806iW3 c14806iW3V = c21326tT4.v();
        if (c14806iW3V != null) {
            this.e = c14806iW3V.getIndex();
        }
        this.f = c21326tT4.w();
        n0(c21326tT4);
        this.g = IT4.g(c21326tT4, H());
        this.h = IT4.h(c21326tT4, H());
    }

    public final void o0(InterfaceC8748Xd6 interfaceC8748Xd6, int i2) {
        i0(s(i2));
    }

    public final CV t() {
        return this.A;
    }

    public final C15060iw3 u() {
        return this.z;
    }

    public final int v() {
        return this.d.b();
    }

    public final float w() {
        return this.d.c();
    }

    public final WH1 x() {
        return this.s;
    }

    public final int y() {
        return this.e;
    }

    public final int z() {
        return this.f;
    }

    public GT4(int i2, float f2) {
        this(i2, f2, null);
    }
}
