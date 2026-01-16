package ir.nasim;

import androidx.compose.ui.e;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Gk1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4751Gk1 extends e.c implements InterfaceC8071Uk0, InterfaceC9398Zt3, InterfaceC9814ac1 {
    private EnumC24286yM4 o;
    private final C23864xe6 p;
    private boolean q;
    private InterfaceC8539Wk0 r;
    private final boolean s;
    private InterfaceC11379cu3 u;
    private boolean v;
    private boolean w;
    private boolean y;
    private final C7364Rk0 t = new C7364Rk0();
    private long x = C4414Fa3.b.a();

    /* renamed from: ir.nasim.Gk1$a */
    public static final class a {
        private final SA2 a;
        private final HE0 b;

        public a(SA2 sa2, HE0 he0) {
            this.a = sa2;
            this.b = he0;
        }

        public final HE0 a() {
            return this.b;
        }

        public final SA2 b() {
            return this.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                r4 = this;
                ir.nasim.HE0 r0 = r4.b
                ir.nasim.do1 r0 = r0.getContext()
                ir.nasim.po1$a r1 = ir.nasim.C19115po1.c
                ir.nasim.do1$b r0 = r0.a(r1)
                ir.nasim.po1 r0 = (ir.nasim.C19115po1) r0
                if (r0 == 0) goto L15
                java.lang.String r0 = r0.x0()
                goto L16
            L15:
                r0 = 0
            L16:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Request@"
                r1.append(r2)
                int r2 = r4.hashCode()
                r3 = 16
                int r3 = ir.nasim.AbstractC10252bL0.a(r3)
                java.lang.String r2 = java.lang.Integer.toString(r2, r3)
                java.lang.String r3 = "toString(...)"
                ir.nasim.AbstractC13042fc3.h(r2, r3)
                r1.append(r2)
                if (r0 == 0) goto L50
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r3 = 91
                r2.append(r3)
                r2.append(r0)
                java.lang.String r0 = "]("
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                if (r0 != 0) goto L52
            L50:
                java.lang.String r0 = "("
            L52:
                r1.append(r0)
                java.lang.String r0 = "currentBounds()="
                r1.append(r0)
                ir.nasim.SA2 r0 = r4.a
                java.lang.Object r0 = r0.invoke()
                r1.append(r0)
                java.lang.String r0 = ", continuation="
                r1.append(r0)
                ir.nasim.HE0 r0 = r4.b
                r1.append(r0)
                r0 = 41
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4751Gk1.a.toString():java.lang.String");
        }
    }

    /* renamed from: ir.nasim.Gk1$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC24286yM4.values().length];
            try {
                iArr[EnumC24286yM4.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC24286yM4.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Gk1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C18765pC7 e;
        final /* synthetic */ InterfaceC8539Wk0 f;

        /* renamed from: ir.nasim.Gk1$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ C18765pC7 d;
            final /* synthetic */ C4751Gk1 e;
            final /* synthetic */ InterfaceC8539Wk0 f;
            final /* synthetic */ InterfaceC13730gj3 g;

            /* renamed from: ir.nasim.Gk1$c$a$a, reason: collision with other inner class name */
            static final class C0394a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ C4751Gk1 e;
                final /* synthetic */ C18765pC7 f;
                final /* synthetic */ InterfaceC13730gj3 g;
                final /* synthetic */ InterfaceC4325Eq4 h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0394a(C4751Gk1 c4751Gk1, C18765pC7 c18765pC7, InterfaceC13730gj3 interfaceC13730gj3, InterfaceC4325Eq4 interfaceC4325Eq4) {
                    super(1);
                    this.e = c4751Gk1;
                    this.f = c18765pC7;
                    this.g = interfaceC13730gj3;
                    this.h = interfaceC4325Eq4;
                }

                public final void a(float f) {
                    float f2 = this.e.q ? 1.0f : -1.0f;
                    C23864xe6 c23864xe6 = this.e.p;
                    float F = f2 * c23864xe6.F(c23864xe6.y(this.h.b(c23864xe6.y(c23864xe6.G(f2 * f)), AbstractC4559Fq4.a.c())));
                    if (Math.abs(F) < Math.abs(f)) {
                        AbstractC20267rj3.f(this.g, "Scroll animation cancelled because scroll was not consumed (" + F + " < " + f + ')', null, 2, null);
                    }
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a(((Number) obj).floatValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Gk1$c$a$b */
            static final class b extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ C4751Gk1 e;
                final /* synthetic */ C18765pC7 f;
                final /* synthetic */ InterfaceC8539Wk0 g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C4751Gk1 c4751Gk1, C18765pC7 c18765pC7, InterfaceC8539Wk0 interfaceC8539Wk0) {
                    super(0);
                    this.e = c4751Gk1;
                    this.f = c18765pC7;
                    this.g = interfaceC8539Wk0;
                }

                public final void a() {
                    C7364Rk0 c7364Rk0 = this.e.t;
                    C4751Gk1 c4751Gk1 = this.e;
                    while (true) {
                        if (c7364Rk0.a.o() != 0) {
                            CK5 ck5 = (CK5) ((a) c7364Rk0.a.q()).b().invoke();
                            if (!(ck5 == null ? true : C4751Gk1.N2(c4751Gk1, ck5, 0L, 1, null))) {
                                break;
                            } else {
                                ((a) c7364Rk0.a.w(c7364Rk0.a.o() - 1)).a().resumeWith(C9475a16.b(C19938rB7.a));
                            }
                        } else {
                            break;
                        }
                    }
                    if (this.e.v) {
                        CK5 ck5K2 = this.e.K2();
                        if (ck5K2 != null && C4751Gk1.N2(this.e, ck5K2, 0L, 1, null)) {
                            this.e.v = false;
                        }
                    }
                    this.f.j(this.e.F2(this.g));
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C18765pC7 c18765pC7, C4751Gk1 c4751Gk1, InterfaceC8539Wk0 interfaceC8539Wk0, InterfaceC13730gj3 interfaceC13730gj3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c18765pC7;
                this.e = c4751Gk1;
                this.f = interfaceC8539Wk0;
                this.g = interfaceC13730gj3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, this.g, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4325Eq4 interfaceC4325Eq4 = (InterfaceC4325Eq4) this.c;
                    this.d.j(this.e.F2(this.f));
                    C18765pC7 c18765pC7 = this.d;
                    C0394a c0394a = new C0394a(this.e, c18765pC7, this.g, interfaceC4325Eq4);
                    b bVar = new b(this.e, this.d, this.f);
                    this.b = 1;
                    if (c18765pC7.h(c0394a, bVar, this) == objE) {
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
            public final Object invoke(InterfaceC4325Eq4 interfaceC4325Eq4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC4325Eq4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C18765pC7 c18765pC7, InterfaceC8539Wk0 interfaceC8539Wk0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c18765pC7;
            this.f = interfaceC8539Wk0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = C4751Gk1.this.new c(this.e, this.f, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                try {
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC13730gj3 interfaceC13730gj3P = AbstractC19067pj3.p(((InterfaceC20315ro1) this.c).getCoroutineContext());
                        C4751Gk1.this.y = true;
                        C23864xe6 c23864xe6 = C4751Gk1.this.p;
                        EnumC15562jn4 enumC15562jn4 = EnumC15562jn4.a;
                        a aVar = new a(this.e, C4751Gk1.this, this.f, interfaceC13730gj3P, null);
                        this.b = 1;
                        if (c23864xe6.z(enumC15562jn4, aVar, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    C4751Gk1.this.t.d();
                    C4751Gk1.this.y = false;
                    C4751Gk1.this.t.b(null);
                    C4751Gk1.this.v = false;
                    return C19938rB7.a;
                } catch (CancellationException e) {
                    throw e;
                }
            } catch (Throwable th) {
                C4751Gk1.this.y = false;
                C4751Gk1.this.t.b(null);
                C4751Gk1.this.v = false;
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C4751Gk1(EnumC24286yM4 enumC24286yM4, C23864xe6 c23864xe6, boolean z, InterfaceC8539Wk0 interfaceC8539Wk0) {
        this.o = enumC24286yM4;
        this.p = c23864xe6;
        this.q = z;
        this.r = interfaceC8539Wk0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float F2(InterfaceC8539Wk0 interfaceC8539Wk0) {
        if (C4414Fa3.e(this.x, C4414Fa3.b.a())) {
            return 0.0f;
        }
        CK5 ck5J2 = J2();
        if (ck5J2 == null) {
            ck5J2 = this.v ? K2() : null;
            if (ck5J2 == null) {
                return 0.0f;
            }
        }
        long jD = AbstractC4663Ga3.d(this.x);
        int i = b.a[this.o.ordinal()];
        if (i == 1) {
            return interfaceC8539Wk0.a(ck5J2.l(), ck5J2.e() - ck5J2.l(), Float.intBitsToFloat((int) (jD & 4294967295L)));
        }
        if (i == 2) {
            return interfaceC8539Wk0.a(ck5J2.i(), ck5J2.j() - ck5J2.i(), Float.intBitsToFloat((int) (jD >> 32)));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int G2(long j, long j2) {
        int i = b.a[this.o.ordinal()];
        if (i == 1) {
            return AbstractC13042fc3.k((int) (j & 4294967295L), (int) (j2 & 4294967295L));
        }
        if (i == 2) {
            return AbstractC13042fc3.k((int) (j >> 32), (int) (j2 >> 32));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int H2(long j, long j2) {
        int i = b.a[this.o.ordinal()];
        if (i == 1) {
            return Float.compare(Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 & 4294967295L)));
        }
        if (i == 2) {
            return Float.compare(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 >> 32)));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final CK5 I2(CK5 ck5, long j) {
        return ck5.s(ZG4.e(Q2(ck5, j) ^ (-9223372034707292160L)));
    }

    private final CK5 J2() {
        C12544en4 c12544en4 = this.t.a;
        int iO = c12544en4.o() - 1;
        Object[] objArr = c12544en4.a;
        CK5 ck5 = null;
        if (iO < objArr.length) {
            while (iO >= 0) {
                CK5 ck52 = (CK5) ((a) objArr[iO]).b().invoke();
                if (ck52 != null) {
                    if (H2(ck52.k(), AbstractC4663Ga3.d(this.x)) > 0) {
                        return ck5 == null ? ck52 : ck5;
                    }
                    ck5 = ck52;
                }
                iO--;
            }
        }
        return ck5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CK5 K2() {
        if (!b2()) {
            return null;
        }
        InterfaceC11379cu3 interfaceC11379cu3M = KG1.m(this);
        InterfaceC11379cu3 interfaceC11379cu3 = this.u;
        if (interfaceC11379cu3 != null) {
            if (!interfaceC11379cu3.b()) {
                interfaceC11379cu3 = null;
            }
            if (interfaceC11379cu3 != null) {
                return interfaceC11379cu3M.N(interfaceC11379cu3, false);
            }
        }
        return null;
    }

    private final boolean M2(CK5 ck5, long j) {
        long jQ2 = Q2(ck5, j);
        return Math.abs(Float.intBitsToFloat((int) (jQ2 >> 32))) <= 0.5f && Math.abs(Float.intBitsToFloat((int) (jQ2 & 4294967295L))) <= 0.5f;
    }

    static /* synthetic */ boolean N2(C4751Gk1 c4751Gk1, CK5 ck5, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = c4751Gk1.x;
        }
        return c4751Gk1.M2(ck5, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O2() {
        InterfaceC8539Wk0 interfaceC8539Wk0R2 = R2();
        if (!(!this.y)) {
            P73.c("launchAnimation called when previous animation was running");
        }
        AbstractC10533bm0.d(U1(), null, EnumC23959xo1.UNDISPATCHED, new c(new C18765pC7(InterfaceC8539Wk0.a.c()), interfaceC8539Wk0R2, null), 1, null);
    }

    private final long Q2(CK5 ck5, long j) {
        long jD = AbstractC4663Ga3.d(j);
        int i = b.a[this.o.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return ZG4.e((Float.floatToRawIntBits(R2().a(ck5.i(), ck5.j() - ck5.i(), Float.intBitsToFloat((int) (jD >> 32)))) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
        }
        float fA = R2().a(ck5.l(), ck5.e() - ck5.l(), Float.intBitsToFloat((int) (jD & 4294967295L)));
        return ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(fA) & 4294967295L));
    }

    private final InterfaceC8539Wk0 R2() {
        InterfaceC8539Wk0 interfaceC8539Wk0 = this.r;
        return interfaceC8539Wk0 == null ? (InterfaceC8539Wk0) AbstractC10434bc1.a(this, AbstractC8805Xk0.a()) : interfaceC8539Wk0;
    }

    @Override // ir.nasim.InterfaceC8071Uk0
    public Object F0(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
        CK5 ck5 = (CK5) sa2.invoke();
        if (ck5 == null || N2(this, ck5, 0L, 1, null)) {
            return C19938rB7.a;
        }
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        if (this.t.c(new a(sa2, ie0)) && !this.y) {
            O2();
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    public final long L2() {
        return this.x;
    }

    public final void P2(InterfaceC11379cu3 interfaceC11379cu3) {
        CK5 ck5K2;
        this.u = interfaceC11379cu3;
        if (this.w && (ck5K2 = K2()) != null && !M2(ck5K2, this.x)) {
            this.v = true;
            O2();
        }
        this.w = false;
    }

    @Override // ir.nasim.InterfaceC9398Zt3
    public void S(long j) {
        CK5 ck5K2;
        long j2 = this.x;
        this.x = j;
        if (G2(j, j2) >= 0 || this.y || this.v || (ck5K2 = K2()) == null || !M2(ck5K2, j2)) {
            return;
        }
        this.w = true;
    }

    public final void S2(EnumC24286yM4 enumC24286yM4, boolean z, InterfaceC8539Wk0 interfaceC8539Wk0) {
        this.o = enumC24286yM4;
        this.q = z;
        this.r = interfaceC8539Wk0;
    }

    @Override // ir.nasim.InterfaceC8071Uk0
    public CK5 Z(CK5 ck5) {
        if (!(!C4414Fa3.e(this.x, C4414Fa3.b.a()))) {
            P73.c("Expected BringIntoViewRequester to not be used before parents are placed.");
        }
        return I2(ck5, this.x);
    }

    @Override // androidx.compose.ui.e.c
    /* renamed from: Z1 */
    public boolean getShouldAutoInvalidate() {
        return this.s;
    }
}
