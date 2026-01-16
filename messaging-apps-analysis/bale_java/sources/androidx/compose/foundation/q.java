package androidx.compose.foundation;

import androidx.compose.ui.e;
import ir.nasim.AbstractC10222bH6;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19153ps;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC22490vK2;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.C15607js;
import ir.nasim.C17784nZ1;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.C21226tK2;
import ir.nasim.C4414Fa3;
import ir.nasim.DU3;
import ir.nasim.ED1;
import ir.nasim.EnumC12613eu3;
import ir.nasim.GV0;
import ir.nasim.InterfaceC10436bc3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15687k02;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC17916nm4;
import ir.nasim.InterfaceC20014rK2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC20937sr2;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.InterfaceC23919xk1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC5517Jr2;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.InterfaceC9236Zb3;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.KG1;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.UG6;
import ir.nasim.YZ1;
import ir.nasim.ZV3;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
final class q extends e.c implements InterfaceC21655tu3, InterfaceC15687k02, InterfaceC20937sr2 {
    private final InterfaceC9664aL6 A;
    private int o;
    private int p;
    private int q;
    private float r;
    private final InterfaceC17916nm4 s;
    private final InterfaceC17916nm4 t;
    private final InterfaceC9102Ym4 u;
    private InterfaceC13730gj3 v;
    private C21226tK2 w;
    private final InterfaceC9102Ym4 x;
    private final InterfaceC9102Ym4 y;
    private final C15607js z;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC12613eu3.values().length];
            try {
                iArr[EnumC12613eu3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC12613eu3.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC23919xk1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC23919xk1 interfaceC23919xk1) {
            super(1);
            this.e = interfaceC23919xk1;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            this.e.N1();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;
        final /* synthetic */ q f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC21430te5 abstractC21430te5, q qVar) {
            super(1);
            this.e = abstractC21430te5;
            this.f = qVar;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.v(aVar, this.e, AbstractC20723sV3.d((-((Number) this.f.z.q()).floatValue()) * this.f.J2()), 0, 0.0f, null, 12, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC13730gj3 c;
        final /* synthetic */ q d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC13730gj3 interfaceC13730gj3, q qVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC13730gj3;
            this.d = qVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC13730gj3 interfaceC13730gj3 = this.c;
                if (interfaceC13730gj3 != null) {
                    this.b = 1;
                    if (interfaceC13730gj3.k0(this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            q qVar = this.d;
            this.b = 2;
            if (qVar.N2(this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ q e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(q qVar) {
                super(0);
                this.e = qVar;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Float invoke() {
                if (this.e.I2() <= this.e.H2()) {
                    return null;
                }
                if (!p.f(this.e.G2(), p.b.b()) || this.e.K2()) {
                    return Float.valueOf(this.e.I2() + this.e.L2());
                }
                return null;
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            /* synthetic */ Object d;
            final /* synthetic */ q e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(q qVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = qVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.e, interfaceC20295rm1);
                bVar.d = obj;
                return bVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:30:0x00ba A[RETURN] */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
                /*
                    r21 = this;
                    r9 = r21
                    java.lang.Object r10 = ir.nasim.AbstractC13660gc3.e()
                    int r0 = r9.c
                    r11 = 4
                    r12 = 3
                    r1 = 2
                    r2 = 1
                    r13 = 0
                    r14 = 0
                    if (r0 == 0) goto L43
                    if (r0 == r2) goto L36
                    if (r0 == r1) goto L2e
                    if (r0 == r12) goto L29
                    if (r0 == r11) goto L20
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r1)
                    throw r0
                L20:
                    java.lang.Object r0 = r9.d
                    java.lang.Throwable r0 = (java.lang.Throwable) r0
                    ir.nasim.AbstractC10685c16.b(r22)
                    goto Ld5
                L29:
                    ir.nasim.AbstractC10685c16.b(r22)
                    goto Lbb
                L2e:
                    ir.nasim.AbstractC10685c16.b(r22)     // Catch: java.lang.Throwable -> L33
                    goto La8
                L33:
                    r0 = move-exception
                    goto Lbe
                L36:
                    java.lang.Object r0 = r9.b
                    ir.nasim.Kt r0 = (ir.nasim.InterfaceC5766Kt) r0
                    java.lang.Object r2 = r9.d
                    java.lang.Float r2 = (java.lang.Float) r2
                    ir.nasim.AbstractC10685c16.b(r22)
                    r3 = r0
                    goto L8d
                L43:
                    ir.nasim.AbstractC10685c16.b(r22)
                    java.lang.Object r0 = r9.d
                    java.lang.Float r0 = (java.lang.Float) r0
                    if (r0 != 0) goto L4f
                    ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
                    return r0
                L4f:
                    androidx.compose.foundation.q r3 = r9.e
                    int r15 = androidx.compose.foundation.q.B2(r3)
                    float r16 = r0.floatValue()
                    androidx.compose.foundation.q r3 = r9.e
                    int r17 = androidx.compose.foundation.q.A2(r3)
                    androidx.compose.foundation.q r3 = r9.e
                    int r18 = androidx.compose.foundation.q.x2(r3)
                    androidx.compose.foundation.q r3 = r9.e
                    float r19 = androidx.compose.foundation.q.E2(r3)
                    androidx.compose.foundation.q r3 = r9.e
                    ir.nasim.WH1 r20 = ir.nasim.KG1.k(r3)
                    ir.nasim.Kt r3 = androidx.compose.foundation.d.a(r15, r16, r17, r18, r19, r20)
                    androidx.compose.foundation.q r4 = r9.e
                    ir.nasim.js r4 = androidx.compose.foundation.q.C2(r4)
                    java.lang.Float r5 = ir.nasim.AbstractC6392Nk0.c(r14)
                    r9.d = r0
                    r9.b = r3
                    r9.c = r2
                    java.lang.Object r2 = r4.x(r5, r9)
                    if (r2 != r10) goto L8c
                    return r10
                L8c:
                    r2 = r0
                L8d:
                    androidx.compose.foundation.q r0 = r9.e     // Catch: java.lang.Throwable -> L33
                    ir.nasim.js r0 = androidx.compose.foundation.q.C2(r0)     // Catch: java.lang.Throwable -> L33
                    r9.d = r13     // Catch: java.lang.Throwable -> L33
                    r9.b = r13     // Catch: java.lang.Throwable -> L33
                    r9.c = r1     // Catch: java.lang.Throwable -> L33
                    r4 = 0
                    r5 = 0
                    r7 = 12
                    r8 = 0
                    r1 = r0
                    r6 = r21
                    java.lang.Object r0 = ir.nasim.C15607js.h(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L33
                    if (r0 != r10) goto La8
                    return r10
                La8:
                    androidx.compose.foundation.q r0 = r9.e
                    ir.nasim.js r0 = androidx.compose.foundation.q.C2(r0)
                    java.lang.Float r1 = ir.nasim.AbstractC6392Nk0.c(r14)
                    r9.c = r12
                    java.lang.Object r0 = r0.x(r1, r9)
                    if (r0 != r10) goto Lbb
                    return r10
                Lbb:
                    ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
                    return r0
                Lbe:
                    androidx.compose.foundation.q r1 = r9.e
                    ir.nasim.js r1 = androidx.compose.foundation.q.C2(r1)
                    java.lang.Float r2 = ir.nasim.AbstractC6392Nk0.c(r14)
                    r9.d = r0
                    r9.b = r13
                    r9.c = r11
                    java.lang.Object r1 = r1.x(r2, r9)
                    if (r1 != r10) goto Ld5
                    return r10
                Ld5:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.q.e.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Float f, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(f, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return q.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC10222bH6.r(new a(q.this));
                b bVar = new b(q.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2R, bVar, this) == objE) {
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

    static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ DU3 e;
        final /* synthetic */ q f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(DU3 du3, q qVar) {
            super(0);
            this.e = du3;
            this.f = qVar;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            DU3 du3 = this.e;
            q qVar = this.f;
            return Integer.valueOf(du3.a(KG1.k(qVar), qVar.I2(), qVar.H2()));
        }
    }

    public /* synthetic */ q(int i, int i2, int i3, int i4, DU3 du3, float f2, ED1 ed1) {
        this(i, i2, i3, i4, du3, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int H2() {
        return this.t.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int I2() {
        return this.s.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float J2() {
        float fSignum = Math.signum(this.r);
        int i = a.a[KG1.n(this).ordinal()];
        int i2 = 1;
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = -1;
        }
        return fSignum * i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K2() {
        return ((Boolean) this.u.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int L2() {
        return ((Number) this.A.getValue()).intValue();
    }

    private final void M2() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.v;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        if (b2()) {
            this.v = AbstractC10533bm0.d(U1(), null, null, new d(interfaceC13730gj3, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object N2(InterfaceC20295rm1 interfaceC20295rm1) {
        if (this.o <= 0) {
            return C19938rB7.a;
        }
        Object objG = AbstractC9323Zl0.g(i.a, new e(null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    private final void P2(int i) {
        this.t.h(i);
    }

    private final void Q2(int i) {
        this.s.h(i);
    }

    private final void R2(boolean z) {
        this.u.setValue(Boolean.valueOf(z));
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int F(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return interfaceC9236Zb3.z(Integer.MAX_VALUE);
    }

    public final int G2() {
        return ((p) this.y.getValue()).i();
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int J(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return interfaceC9236Zb3.Z(Integer.MAX_VALUE);
    }

    @Override // ir.nasim.InterfaceC20937sr2
    public void O(InterfaceC5517Jr2 interfaceC5517Jr2) {
        R2(interfaceC5517Jr2.j());
    }

    public final void O2(int i) {
        this.y.setValue(p.c(i));
    }

    public final void S2(DU3 du3) {
        this.x.setValue(du3);
    }

    public final void T2(int i, int i2, int i3, int i4, DU3 du3, float f2) {
        S2(du3);
        O2(i2);
        if (this.o == i && this.p == i3 && this.q == i4 && C17784nZ1.s(this.r, f2)) {
            return;
        }
        this.o = i;
        this.p = i3;
        this.q = i4;
        this.r = f2;
        M2();
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(C17833ne1.d(j, 0, Integer.MAX_VALUE, 0, 0, 13, null));
        P2(AbstractC19606qe1.g(j, abstractC21430te5L0.P0()));
        Q2(abstractC21430te5L0.P0());
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, H2(), abstractC21430te5L0.A0(), null, new c(abstractC21430te5L0, this), 4, null);
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        C21226tK2 c21226tK2 = this.w;
        InterfaceC20014rK2 interfaceC20014rK2L = KG1.l(this);
        if (c21226tK2 != null) {
            interfaceC20014rK2L.b(c21226tK2);
        }
        this.w = interfaceC20014rK2L.a();
        M2();
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.v;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.v = null;
        C21226tK2 c21226tK2 = this.w;
        if (c21226tK2 != null) {
            KG1.l(this).b(c21226tK2);
            this.w = null;
        }
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void o(InterfaceC23919xk1 interfaceC23919xk1) {
        float fFloatValue = ((Number) this.z.q()).floatValue() * J2();
        boolean z = J2() != 1.0f ? ((Number) this.z.q()).floatValue() < ((float) H2()) : ((Number) this.z.q()).floatValue() < ((float) I2());
        boolean z2 = J2() != 1.0f ? ((Number) this.z.q()).floatValue() > ((float) L2()) : ((Number) this.z.q()).floatValue() > ((float) ((I2() + L2()) - H2()));
        float fI2 = J2() == 1.0f ? I2() + L2() : (-I2()) - L2();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC23919xk1.d() & 4294967295L));
        C21226tK2 c21226tK2 = this.w;
        if (c21226tK2 != null) {
            interfaceC23919xk1.O1(c21226tK2, C4414Fa3.c((I2() << 32) | (AbstractC20723sV3.d(fIntBitsToFloat) & 4294967295L)), new b(interfaceC23919xk1));
        }
        float fH2 = fFloatValue + H2();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & interfaceC23919xk1.d()));
        int iB = GV0.a.b();
        YZ1 yz1Z1 = interfaceC23919xk1.z1();
        long jD = yz1Z1.d();
        yz1Z1.e().n();
        try {
            yz1Z1.b().b(fFloatValue, 0.0f, fH2, fIntBitsToFloat2, iB);
            C21226tK2 c21226tK22 = this.w;
            if (c21226tK22 != null) {
                if (z) {
                    AbstractC22490vK2.a(interfaceC23919xk1, c21226tK22);
                }
                if (z2) {
                    interfaceC23919xk1.z1().b().c(fI2, 0.0f);
                    try {
                        AbstractC22490vK2.a(interfaceC23919xk1, c21226tK22);
                        interfaceC23919xk1.z1().b().c(-fI2, -0.0f);
                    } finally {
                    }
                }
            } else {
                if (z) {
                    interfaceC23919xk1.N1();
                }
                if (z2) {
                    interfaceC23919xk1.z1().b().c(fI2, 0.0f);
                    try {
                        interfaceC23919xk1.N1();
                        interfaceC23919xk1.z1().b().c(-fI2, -0.0f);
                    } finally {
                    }
                }
            }
            yz1Z1.e().i();
            yz1Z1.g(jD);
        } catch (Throwable th) {
            yz1Z1.e().i();
            yz1Z1.g(jD);
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int p(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return 0;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int z(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return interfaceC9236Zb3.k0(i);
    }

    private q(int i, int i2, int i3, int i4, DU3 du3, float f2) {
        this.o = i;
        this.p = i3;
        this.q = i4;
        this.r = f2;
        this.s = UG6.a(0);
        this.t = UG6.a(0);
        this.u = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
        this.x = AbstractC13472gH6.d(du3, null, 2, null);
        this.y = AbstractC13472gH6.d(p.c(i2), null, 2, null);
        this.z = AbstractC19153ps.b(0.0f, 0.0f, 2, null);
        this.A = AbstractC10222bH6.d(new f(du3, this));
    }
}
