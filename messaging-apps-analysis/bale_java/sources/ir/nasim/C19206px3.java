package ir.nasim;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.d;
import androidx.compose.runtime.snapshots.g;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.px3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19206px3 implements InterfaceC11049ce6 {
    public static final c x = new c(null);
    private static final InterfaceC8230Vb6 y = WB3.a(a.e, b.e);
    private final InterfaceC13869gx3 a;
    private boolean b;
    private C11408cx3 c;
    private final C15660jx3 d;
    private final InterfaceC9102Ym4 e;
    private final InterfaceC18507om4 f;
    private float g;
    private final InterfaceC11049ce6 h;
    private int i;
    private boolean j;
    private RM5 k;
    private final SM5 l;
    private final CV m;
    private final LazyLayoutItemAnimator n;
    private final C15060iw3 o;
    private final androidx.compose.foundation.lazy.layout.d p;
    private final InterfaceC13278fx3 q;
    private final C4861Gw3 r;
    private final InterfaceC9102Ym4 s;
    private final InterfaceC9102Ym4 t;
    private final InterfaceC9102Ym4 u;
    private final InterfaceC9102Ym4 v;
    private final C5095Hw3 w;

    /* renamed from: ir.nasim.px3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C19206px3 c19206px3) {
            return AbstractC10360bX0.p(Integer.valueOf(c19206px3.s()), Integer.valueOf(c19206px3.t()));
        }
    }

    /* renamed from: ir.nasim.px3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19206px3 invoke(List list) {
            return new C19206px3(((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue());
        }
    }

    /* renamed from: ir.nasim.px3$c */
    public static final class c {
        private c() {
        }

        public final InterfaceC8230Vb6 a() {
            return C19206px3.y;
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.px3$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ int e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = i;
            this.f = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C19206px3.this.new d(this.e, this.f, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC5563Jw3 interfaceC5563Jw3A = AbstractC16251kx3.a(C19206px3.this, (InterfaceC8748Xd6) this.c);
                int i2 = this.e;
                int i3 = this.f;
                WH1 wh1R = C19206px3.this.r();
                this.b = 1;
                if (AbstractC5797Kw3.b(interfaceC5563Jw3A, i2, i3, 100, wh1R, this) == objE) {
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
            return ((d) create(interfaceC8748Xd6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.px3$e */
    public static final class e implements InterfaceC13278fx3 {
        e() {
        }

        @Override // ir.nasim.InterfaceC13278fx3
        public d.b a(int i) {
            g.a aVar = androidx.compose.runtime.snapshots.g.e;
            C19206px3 c19206px3 = C19206px3.this;
            androidx.compose.runtime.snapshots.g gVarD = aVar.d();
            UA2 ua2G = gVarD != null ? gVarD.g() : null;
            androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
            try {
                long jO = ((C11408cx3) c19206px3.e.getValue()).o();
                aVar.l(gVarD, gVarE, ua2G);
                return C19206px3.this.C().e(i, jO);
            } catch (Throwable th) {
                aVar.l(gVarD, gVarE, ua2G);
                throw th;
            }
        }
    }

    /* renamed from: ir.nasim.px3$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(int i) {
            super(1);
            this.f = i;
        }

        public final void a(InterfaceC23982xq4 interfaceC23982xq4) {
            InterfaceC13869gx3 interfaceC13869gx3 = C19206px3.this.a;
            int i = this.f;
            g.a aVar = androidx.compose.runtime.snapshots.g.e;
            androidx.compose.runtime.snapshots.g gVarD = aVar.d();
            aVar.l(gVarD, aVar.e(gVarD), gVarD != null ? gVarD.g() : null);
            interfaceC13869gx3.a(interfaceC23982xq4, i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC23982xq4) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.px3$g */
    public static final class g implements SM5 {
        g() {
        }

        @Override // ir.nasim.SM5
        public void h(RM5 rm5) {
            C19206px3.this.k = rm5;
        }
    }

    /* renamed from: ir.nasim.px3$h */
    static final class h extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C19206px3.this.b(null, null, this);
        }
    }

    /* renamed from: ir.nasim.px3$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19206px3.this.new i(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C19206px3.this.M(this.d, this.e, true);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC8748Xd6 interfaceC8748Xd6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC8748Xd6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.px3$j */
    static final class j extends AbstractC8614Ws3 implements UA2 {
        j() {
            super(1);
        }

        public final Float a(float f) {
            return Float.valueOf(-C19206px3.this.H(-f));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).floatValue());
        }
    }

    public C19206px3(int i2, int i3, InterfaceC13869gx3 interfaceC13869gx3) {
        this.a = interfaceC13869gx3;
        C15660jx3 c15660jx3 = new C15660jx3(i2, i3);
        this.d = c15660jx3;
        this.e = AbstractC10222bH6.h(AbstractC19797qx3.a, AbstractC10222bH6.j());
        this.f = AbstractC23831xb3.a();
        this.h = AbstractC11844de6.a(new j());
        this.j = true;
        this.l = new g();
        this.m = new CV();
        this.n = new LazyLayoutItemAnimator();
        this.o = new C15060iw3();
        this.p = new androidx.compose.foundation.lazy.layout.d(interfaceC13869gx3.b(), new f(i2));
        this.q = new e();
        this.r = new C4861Gw3();
        c15660jx3.b();
        this.s = LG4.c(null, 1, null);
        Boolean bool = Boolean.FALSE;
        this.t = AbstractC13472gH6.d(bool, null, 2, null);
        this.u = AbstractC13472gH6.d(bool, null, 2, null);
        this.v = LG4.c(null, 1, null);
        this.w = new C5095Hw3();
    }

    private final void G(float f2, InterfaceC9425Zw3 interfaceC9425Zw3) {
        if (this.j) {
            this.a.d(this.q, f2, interfaceC9425Zw3);
        }
    }

    public static /* synthetic */ Object J(C19206px3 c19206px3, int i2, int i3, InterfaceC20295rm1 interfaceC20295rm1, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        return c19206px3.I(i2, i3, interfaceC20295rm1);
    }

    private void K(boolean z) {
        this.u.setValue(Boolean.valueOf(z));
    }

    private void L(boolean z) {
        this.t.setValue(Boolean.valueOf(z));
    }

    public static /* synthetic */ Object l(C19206px3 c19206px3, int i2, int i3, InterfaceC20295rm1 interfaceC20295rm1, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        return c19206px3.k(i2, i3, interfaceC20295rm1);
    }

    public static /* synthetic */ void n(C19206px3 c19206px3, C11408cx3 c11408cx3, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        c19206px3.m(c11408cx3, z, z2);
    }

    public final C4861Gw3 A() {
        return this.r;
    }

    public final InterfaceC9102Ym4 B() {
        return this.v;
    }

    public final androidx.compose.foundation.lazy.layout.d C() {
        return this.p;
    }

    public final SM5 D() {
        return this.l;
    }

    public final float E() {
        return this.w.b();
    }

    public final float F() {
        return this.g;
    }

    public final float H(float f2) {
        C11408cx3 c11408cx3;
        if ((f2 < 0.0f && !e()) || (f2 > 0.0f && !d())) {
            return 0.0f;
        }
        if (!(Math.abs(this.g) <= 0.5f)) {
            P73.c("entered drag with non-zero pending scroll");
        }
        float f3 = this.g + f2;
        this.g = f3;
        if (Math.abs(f3) > 0.5f) {
            float f4 = this.g;
            int iRound = Math.round(f4);
            C11408cx3 c11408cx3L = ((C11408cx3) this.e.getValue()).l(iRound, !this.b);
            if (c11408cx3L != null && (c11408cx3 = this.c) != null) {
                C11408cx3 c11408cx3L2 = c11408cx3 != null ? c11408cx3.l(iRound, true) : null;
                if (c11408cx3L2 != null) {
                    this.c = c11408cx3L2;
                } else {
                    c11408cx3L = null;
                }
            }
            if (c11408cx3L != null) {
                m(c11408cx3L, this.b, true);
                LG4.d(this.v);
                G(f4 - this.g, c11408cx3L);
            } else {
                RM5 rm5 = this.k;
                if (rm5 != null) {
                    rm5.l();
                }
                G(f4 - this.g, x());
            }
        }
        if (Math.abs(this.g) <= 0.5f) {
            return f2;
        }
        float f5 = f2 - this.g;
        this.g = 0.0f;
        return f5;
    }

    public final Object I(int i2, int i3, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = InterfaceC11049ce6.a(this, null, new i(i2, i3, null), interfaceC20295rm1, 1, null);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    public final void M(int i2, int i3, boolean z) {
        if (this.d.a() != i2 || this.d.c() != i3) {
            this.n.p();
        }
        this.d.d(i2, i3);
        if (!z) {
            LG4.d(this.s);
            return;
        }
        RM5 rm5 = this.k;
        if (rm5 != null) {
            rm5.l();
        }
    }

    public final int N(InterfaceC8182Uw3 interfaceC8182Uw3, int i2) {
        return this.d.j(interfaceC8182Uw3, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC11049ce6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.EnumC15562jn4 r6, ir.nasim.InterfaceC14603iB2 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C19206px3.h
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.px3$h r0 = (ir.nasim.C19206px3.h) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.px3$h r0 = new ir.nasim.px3$h
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r8)
            goto L6c
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.c
            r7 = r6
            ir.nasim.iB2 r7 = (ir.nasim.InterfaceC14603iB2) r7
            java.lang.Object r6 = r0.b
            ir.nasim.jn4 r6 = (ir.nasim.EnumC15562jn4) r6
            java.lang.Object r2 = r0.a
            ir.nasim.px3 r2 = (ir.nasim.C19206px3) r2
            ir.nasim.AbstractC10685c16.b(r8)
            goto L5a
        L45:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.CV r8 = r5.m
            r0.a = r5
            r0.b = r6
            r0.c = r7
            r0.f = r4
            java.lang.Object r8 = r8.k(r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            r2 = r5
        L5a:
            ir.nasim.ce6 r8 = r2.h
            r2 = 0
            r0.a = r2
            r0.b = r2
            r0.c = r2
            r0.f = r3
            java.lang.Object r6 = r8.b(r6, r7, r0)
            if (r6 != r1) goto L6c
            return r1
        L6c:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19206px3.b(ir.nasim.jn4, ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public boolean c() {
        return this.h.c();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public boolean d() {
        return ((Boolean) this.u.getValue()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public boolean e() {
        return ((Boolean) this.t.getValue()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public float f(float f2) {
        return this.h.f(f2);
    }

    public final Object k(int i2, int i3, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = InterfaceC11049ce6.a(this, null, new d(i2, i3, null), interfaceC20295rm1, 1, null);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    public final void m(C11408cx3 c11408cx3, boolean z, boolean z2) {
        if (!z && this.b) {
            this.c = c11408cx3;
            return;
        }
        if (z) {
            this.b = true;
        }
        K(c11408cx3.m());
        L(c11408cx3.n());
        this.g -= c11408cx3.p();
        this.e.setValue(c11408cx3);
        if (z2) {
            this.d.i(c11408cx3.u());
        } else {
            this.d.h(c11408cx3);
            if (this.j) {
                this.a.c(this.q, c11408cx3);
            }
        }
        if (z) {
            this.w.c(c11408cx3.w(), c11408cx3.r(), c11408cx3.q());
        }
        this.i++;
    }

    public final C11408cx3 o() {
        return this.c;
    }

    public final CV p() {
        return this.m;
    }

    public final C15060iw3 q() {
        return this.o;
    }

    public final WH1 r() {
        return ((C11408cx3) this.e.getValue()).r();
    }

    public final int s() {
        return this.d.a();
    }

    public final int t() {
        return this.d.c();
    }

    public final boolean u() {
        return this.b;
    }

    public final InterfaceC18507om4 v() {
        return this.f;
    }

    public final LazyLayoutItemAnimator w() {
        return this.n;
    }

    public final InterfaceC9425Zw3 x() {
        return (InterfaceC9425Zw3) this.e.getValue();
    }

    public final InterfaceC9102Ym4 y() {
        return this.s;
    }

    public final C24411ya3 z() {
        return (C24411ya3) this.d.b().getValue();
    }

    public /* synthetic */ C19206px3(int i2, int i3, int i4, ED1 ed1) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0 : i3);
    }

    public C19206px3(int i2, int i3) {
        this(i2, i3, AbstractC14462hx3.b(0, 1, null));
    }
}
