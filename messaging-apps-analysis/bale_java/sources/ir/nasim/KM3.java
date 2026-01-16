package ir.nasim;

import android.view.View;
import androidx.compose.ui.e;

/* loaded from: classes.dex */
public final class KM3 extends e.c implements InterfaceC15868kJ2, InterfaceC15687k02, InterfaceC7163Qn6, SG4 {
    private InterfaceC15483jf5 A;
    private final InterfaceC9102Ym4 B;
    private InterfaceC9664aL6 D;
    private long G;
    private C4414Fa3 H;
    private InterfaceC17639nJ0 J;
    private UA2 o;
    private UA2 p;
    private UA2 q;
    private float r;
    private boolean s;
    private long t;
    private float u;
    private float v;
    private boolean w;
    private InterfaceC16074kf5 x;
    private View y;
    private WH1 z;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        public final long a() {
            InterfaceC11379cu3 interfaceC11379cu3U0 = KM3.this.u0();
            return interfaceC11379cu3U0 != null ? AbstractC12000du3.e(interfaceC11379cu3U0) : ZG4.b.b();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            return ZG4.d(a());
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        public final long a() {
            return KM3.this.G;
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            return ZG4.d(a());
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        public final void a() {
            KM3.this.E2();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public /* synthetic */ KM3(UA2 ua2, UA2 ua22, UA2 ua23, float f, boolean z, long j, float f2, float f3, boolean z2, InterfaceC16074kf5 interfaceC16074kf5, ED1 ed1) {
        this(ua2, ua22, ua23, f, z, j, f2, f3, z2, interfaceC16074kf5);
    }

    private final long A2() {
        if (this.D == null) {
            this.D = AbstractC10222bH6.d(new a());
        }
        InterfaceC9664aL6 interfaceC9664aL6 = this.D;
        return interfaceC9664aL6 != null ? ((ZG4) interfaceC9664aL6.getValue()).t() : ZG4.b.b();
    }

    private final void B2() {
        InterfaceC15483jf5 interfaceC15483jf5 = this.A;
        if (interfaceC15483jf5 != null) {
            interfaceC15483jf5.dismiss();
        }
        View viewA = this.y;
        if (viewA == null) {
            viewA = LG1.a(this);
        }
        View view = viewA;
        this.y = view;
        WH1 wh1K = this.z;
        if (wh1K == null) {
            wh1K = KG1.k(this);
        }
        WH1 wh1 = wh1K;
        this.z = wh1;
        this.A = this.x.a(view, this.s, this.t, this.u, this.v, this.w, wh1, this.r);
        F2();
    }

    private final void C2(InterfaceC11379cu3 interfaceC11379cu3) {
        this.B.setValue(interfaceC11379cu3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E2() {
        /*
            r9 = this;
            ir.nasim.WH1 r0 = r9.z
            if (r0 != 0) goto La
            ir.nasim.WH1 r0 = ir.nasim.KG1.k(r9)
            r9.z = r0
        La:
            ir.nasim.UA2 r1 = r9.o
            java.lang.Object r1 = r1.invoke(r0)
            ir.nasim.ZG4 r1 = (ir.nasim.ZG4) r1
            long r1 = r1.t()
            r3 = 9223372034707292159(0x7fffffff7fffffff, double:NaN)
            long r5 = r1 & r3
            r7 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L83
            long r5 = r9.A2()
            long r5 = r5 & r3
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L83
            long r5 = r9.A2()
            long r1 = ir.nasim.ZG4.q(r5, r1)
            r9.G = r1
            ir.nasim.UA2 r1 = r9.p
            if (r1 == 0) goto L66
            java.lang.Object r0 = r1.invoke(r0)
            ir.nasim.ZG4 r0 = (ir.nasim.ZG4) r0
            long r0 = r0.t()
            ir.nasim.ZG4 r0 = ir.nasim.ZG4.d(r0)
            long r1 = r0.t()
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L55
            goto L56
        L55:
            r0 = 0
        L56:
            if (r0 == 0) goto L66
            long r0 = r0.t()
            long r2 = r9.A2()
            long r0 = ir.nasim.ZG4.q(r2, r0)
        L64:
            r5 = r0
            goto L6d
        L66:
            ir.nasim.ZG4$a r0 = ir.nasim.ZG4.b
            long r0 = r0.b()
            goto L64
        L6d:
            ir.nasim.jf5 r0 = r9.A
            if (r0 != 0) goto L74
            r9.B2()
        L74:
            ir.nasim.jf5 r2 = r9.A
            if (r2 == 0) goto L7f
            long r3 = r9.G
            float r7 = r9.r
            r2.b(r3, r5, r7)
        L7f:
            r9.F2()
            return
        L83:
            ir.nasim.ZG4$a r0 = ir.nasim.ZG4.b
            long r0 = r0.b()
            r9.G = r0
            ir.nasim.jf5 r0 = r9.A
            if (r0 == 0) goto L92
            r0.dismiss()
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KM3.E2():void");
    }

    private final void F2() {
        WH1 wh1;
        InterfaceC15483jf5 interfaceC15483jf5 = this.A;
        if (interfaceC15483jf5 == null || (wh1 = this.z) == null || C4414Fa3.d(interfaceC15483jf5.a(), this.H)) {
            return;
        }
        UA2 ua2 = this.q;
        if (ua2 != null) {
            ua2.invoke(C20148rZ1.c(wh1.U(AbstractC4663Ga3.d(interfaceC15483jf5.a()))));
        }
        this.H = C4414Fa3.b(interfaceC15483jf5.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC11379cu3 u0() {
        return (InterfaceC11379cu3) this.B.getValue();
    }

    public final void D2(UA2 ua2, UA2 ua22, float f, boolean z, long j, float f2, float f3, boolean z2, UA2 ua23, InterfaceC16074kf5 interfaceC16074kf5) {
        float f4 = this.r;
        long j2 = this.t;
        float f5 = this.u;
        boolean z3 = this.s;
        float f6 = this.v;
        boolean z4 = this.w;
        InterfaceC16074kf5 interfaceC16074kf52 = this.x;
        View view = this.y;
        WH1 wh1 = this.z;
        this.o = ua2;
        this.p = ua22;
        this.r = f;
        this.s = z;
        this.t = j;
        this.u = f2;
        this.v = f3;
        this.w = z2;
        this.q = ua23;
        this.x = interfaceC16074kf5;
        View viewA = LG1.a(this);
        WH1 wh1K = KG1.k(this);
        if (this.A != null && ((!LM3.a(f, f4) && !interfaceC16074kf5.b()) || !C20148rZ1.h(j, j2) || !C17784nZ1.s(f2, f5) || !C17784nZ1.s(f3, f6) || z != z3 || z2 != z4 || !AbstractC13042fc3.d(interfaceC16074kf5, interfaceC16074kf52) || !AbstractC13042fc3.d(viewA, view) || !AbstractC13042fc3.d(wh1K, wh1))) {
            B2();
        }
        E2();
    }

    @Override // ir.nasim.InterfaceC7163Qn6
    public void U0(InterfaceC11943do6 interfaceC11943do6) {
        interfaceC11943do6.f(LM3.b(), new b());
    }

    @Override // androidx.compose.ui.e.c
    public void e2() {
        x0();
        this.J = DJ0.b(0, null, null, 7, null);
        AbstractC10533bm0.d(U1(), null, EnumC23959xo1.UNDISPATCHED, new c(null), 1, null);
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        InterfaceC15483jf5 interfaceC15483jf5 = this.A;
        if (interfaceC15483jf5 != null) {
            interfaceC15483jf5.dismiss();
        }
        this.A = null;
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void o(InterfaceC23919xk1 interfaceC23919xk1) {
        interfaceC23919xk1.N1();
        InterfaceC17639nJ0 interfaceC17639nJ0 = this.J;
        if (interfaceC17639nJ0 != null) {
            GJ0.b(interfaceC17639nJ0.h(C19938rB7.a));
        }
    }

    @Override // ir.nasim.InterfaceC15868kJ2
    public void u(InterfaceC11379cu3 interfaceC11379cu3) {
        C2(interfaceC11379cu3);
    }

    @Override // ir.nasim.SG4
    public void x0() {
        TG4.a(this, new d());
    }

    private KM3(UA2 ua2, UA2 ua22, UA2 ua23, float f, boolean z, long j, float f2, float f3, boolean z2, InterfaceC16074kf5 interfaceC16074kf5) {
        this.o = ua2;
        this.p = ua22;
        this.q = ua23;
        this.r = f;
        this.s = z;
        this.t = j;
        this.u = f2;
        this.v = f3;
        this.w = z2;
        this.x = interfaceC16074kf5;
        this.B = AbstractC10222bH6.h(null, AbstractC10222bH6.j());
        this.G = ZG4.b.b();
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KM3.this.new c(interfaceC20295rm1);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0038 -> B:11:0x0021). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0042 -> B:21:0x0045). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r4.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ir.nasim.AbstractC10685c16.b(r5)
                goto L45
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                ir.nasim.AbstractC10685c16.b(r5)
                goto L32
            L1e:
                ir.nasim.AbstractC10685c16.b(r5)
            L21:
                ir.nasim.KM3 r5 = ir.nasim.KM3.this
                ir.nasim.nJ0 r5 = ir.nasim.KM3.v2(r5)
                if (r5 == 0) goto L32
                r4.b = r3
                java.lang.Object r5 = r5.i(r4)
                if (r5 != r0) goto L32
                return r0
            L32:
                ir.nasim.KM3 r5 = ir.nasim.KM3.this
                ir.nasim.jf5 r5 = ir.nasim.KM3.x2(r5)
                if (r5 == 0) goto L21
                ir.nasim.KM3$c$a r5 = ir.nasim.KM3.c.a.e
                r4.b = r2
                java.lang.Object r5 = ir.nasim.AbstractC16704lj4.b(r5, r4)
                if (r5 != r0) goto L45
                return r0
            L45:
                ir.nasim.KM3 r5 = ir.nasim.KM3.this
                ir.nasim.jf5 r5 = ir.nasim.KM3.x2(r5)
                if (r5 == 0) goto L21
                r5.c()
                goto L21
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KM3.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).longValue());
                return C19938rB7.a;
            }

            public final void a(long j) {
            }
        }
    }
}
