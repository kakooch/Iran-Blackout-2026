package ir.nasim;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.runtime.snapshots.g;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Lv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6021Lv3 implements InterfaceC11049ce6 {
    public static final c x = new c(null);
    private static final InterfaceC8230Vb6 y = WB3.a(a.e, b.e);
    private final InterfaceC3901Cv3 a;
    private boolean b;
    private C23441wv3 c;
    private final C4603Fv3 d;
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
    private final InterfaceC3667Bv3 q;
    private final C4861Gw3 r;
    private final InterfaceC9102Ym4 s;
    private final InterfaceC9102Ym4 t;
    private final InterfaceC9102Ym4 u;
    private final InterfaceC9102Ym4 v;
    private final C5095Hw3 w;

    /* renamed from: ir.nasim.Lv3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C6021Lv3 c6021Lv3) {
            return AbstractC10360bX0.p(Integer.valueOf(c6021Lv3.p()), Integer.valueOf(c6021Lv3.q()));
        }
    }

    /* renamed from: ir.nasim.Lv3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C6021Lv3 invoke(List list) {
            return new C6021Lv3(((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue());
        }
    }

    /* renamed from: ir.nasim.Lv3$c */
    public static final class c {
        private c() {
        }

        public final InterfaceC8230Vb6 a() {
            return C6021Lv3.y;
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Lv3$d */
    public static final class d implements InterfaceC3667Bv3 {
        d() {
        }

        @Override // ir.nasim.InterfaceC3667Bv3
        public List a(int i) {
            ArrayList arrayList = new ArrayList();
            g.a aVar = androidx.compose.runtime.snapshots.g.e;
            C6021Lv3 c6021Lv3 = C6021Lv3.this;
            androidx.compose.runtime.snapshots.g gVarD = aVar.d();
            UA2 ua2G = gVarD != null ? gVarD.g() : null;
            androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
            try {
                C23441wv3 c23441wv3M = c6021Lv3.r() ? c6021Lv3.m() : (C23441wv3) c6021Lv3.e.getValue();
                if (c23441wv3M != null) {
                    List list = (List) c23441wv3M.u().invoke(Integer.valueOf(i));
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        XV4 xv4 = (XV4) list.get(i2);
                        arrayList.add(c6021Lv3.z().e(((Number) xv4.e()).intValue(), ((C17833ne1) xv4.f()).r()));
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
                aVar.l(gVarD, gVarE, ua2G);
                return arrayList;
            } catch (Throwable th) {
                aVar.l(gVarD, gVarE, ua2G);
                throw th;
            }
        }
    }

    /* renamed from: ir.nasim.Lv3$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i) {
            super(1);
            this.f = i;
        }

        public final void a(InterfaceC23982xq4 interfaceC23982xq4) {
            InterfaceC3901Cv3 interfaceC3901Cv3 = C6021Lv3.this.a;
            int i = this.f;
            g.a aVar = androidx.compose.runtime.snapshots.g.e;
            androidx.compose.runtime.snapshots.g gVarD = aVar.d();
            aVar.l(gVarD, aVar.e(gVarD), gVarD != null ? gVarD.g() : null);
            interfaceC3901Cv3.a(interfaceC23982xq4, i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC23982xq4) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Lv3$f */
    public static final class f implements SM5 {
        f() {
        }

        @Override // ir.nasim.SM5
        public void h(RM5 rm5) {
            C6021Lv3.this.k = rm5;
        }
    }

    /* renamed from: ir.nasim.Lv3$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C6021Lv3.this.b(null, null, this);
        }
    }

    /* renamed from: ir.nasim.Lv3$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6021Lv3.this.new h(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C6021Lv3.this.J(this.d, this.e, true);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC8748Xd6 interfaceC8748Xd6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC8748Xd6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Lv3$i */
    static final class i extends AbstractC8614Ws3 implements UA2 {
        i() {
            super(1);
        }

        public final Float a(float f) {
            return Float.valueOf(-C6021Lv3.this.E(-f));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).floatValue());
        }
    }

    public C6021Lv3(int i2, int i3, InterfaceC3901Cv3 interfaceC3901Cv3) {
        this.a = interfaceC3901Cv3;
        C4603Fv3 c4603Fv3 = new C4603Fv3(i2, i3);
        this.d = c4603Fv3;
        this.e = AbstractC10222bH6.h(AbstractC6255Mv3.a, AbstractC10222bH6.j());
        this.f = AbstractC23831xb3.a();
        this.h = AbstractC11844de6.a(new i());
        this.j = true;
        this.l = new f();
        this.m = new CV();
        this.n = new LazyLayoutItemAnimator();
        this.o = new C15060iw3();
        this.p = new androidx.compose.foundation.lazy.layout.d(interfaceC3901Cv3.b(), new e(i2));
        this.q = new d();
        this.r = new C4861Gw3();
        c4603Fv3.b();
        this.s = LG4.c(null, 1, null);
        this.t = LG4.c(null, 1, null);
        Boolean bool = Boolean.FALSE;
        this.u = AbstractC13472gH6.d(bool, null, 2, null);
        this.v = AbstractC13472gH6.d(bool, null, 2, null);
        this.w = new C5095Hw3();
    }

    private final void D(float f2, InterfaceC21665tv3 interfaceC21665tv3) {
        if (this.j) {
            this.a.d(this.q, f2, interfaceC21665tv3);
        }
    }

    public static /* synthetic */ Object G(C6021Lv3 c6021Lv3, int i2, int i3, InterfaceC20295rm1 interfaceC20295rm1, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        return c6021Lv3.F(i2, i3, interfaceC20295rm1);
    }

    private void H(boolean z) {
        this.v.setValue(Boolean.valueOf(z));
    }

    private void I(boolean z) {
        this.u.setValue(Boolean.valueOf(z));
    }

    public static /* synthetic */ void l(C6021Lv3 c6021Lv3, C23441wv3 c23441wv3, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        c6021Lv3.k(c23441wv3, z, z2);
    }

    public final SM5 A() {
        return this.l;
    }

    public final float B() {
        return this.w.b();
    }

    public final float C() {
        return this.g;
    }

    public final float E(float f2) {
        C23441wv3 c23441wv3;
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
            int iD = AbstractC20723sV3.d(f4);
            C23441wv3 c23441wv3L = ((C23441wv3) this.e.getValue()).l(iD, !this.b);
            if (c23441wv3L != null && (c23441wv3 = this.c) != null) {
                C23441wv3 c23441wv3L2 = c23441wv3 != null ? c23441wv3.l(iD, true) : null;
                if (c23441wv3L2 != null) {
                    this.c = c23441wv3L2;
                } else {
                    c23441wv3L = null;
                }
            }
            if (c23441wv3L != null) {
                k(c23441wv3L, this.b, true);
                LG4.d(this.s);
                D(f4 - this.g, c23441wv3L);
            } else {
                RM5 rm5 = this.k;
                if (rm5 != null) {
                    rm5.l();
                }
                D(f4 - this.g, u());
            }
        }
        if (Math.abs(this.g) <= 0.5f) {
            return f2;
        }
        float f5 = f2 - this.g;
        this.g = 0.0f;
        return f5;
    }

    public final Object F(int i2, int i3, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = InterfaceC11049ce6.a(this, null, new h(i2, i3, null), interfaceC20295rm1, 1, null);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    public final void J(int i2, int i3, boolean z) {
        if (this.d.a() != i2 || this.d.c() != i3) {
            this.n.p();
        }
        this.d.d(i2, i3);
        if (!z) {
            LG4.d(this.t);
            return;
        }
        RM5 rm5 = this.k;
        if (rm5 != null) {
            rm5.l();
        }
    }

    public final int K(InterfaceC17414mv3 interfaceC17414mv3, int i2) {
        return this.d.j(interfaceC17414mv3, i2);
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
            boolean r0 = r8 instanceof ir.nasim.C6021Lv3.g
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Lv3$g r0 = (ir.nasim.C6021Lv3.g) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.Lv3$g r0 = new ir.nasim.Lv3$g
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
            ir.nasim.Lv3 r2 = (ir.nasim.C6021Lv3) r2
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6021Lv3.b(ir.nasim.jn4, ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public boolean c() {
        return this.h.c();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public boolean d() {
        return ((Boolean) this.v.getValue()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public boolean e() {
        return ((Boolean) this.u.getValue()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public float f(float f2) {
        return this.h.f(f2);
    }

    public final void k(C23441wv3 c23441wv3, boolean z, boolean z2) {
        if (!z && this.b) {
            this.c = c23441wv3;
            return;
        }
        if (z) {
            this.b = true;
        }
        this.g -= c23441wv3.o();
        this.e.setValue(c23441wv3);
        H(c23441wv3.m());
        I(c23441wv3.n());
        if (z2) {
            this.d.i(c23441wv3.s());
        } else {
            this.d.h(c23441wv3);
            if (this.j) {
                this.a.c(this.q, c23441wv3);
            }
        }
        if (z) {
            this.w.c(c23441wv3.w(), c23441wv3.q(), c23441wv3.p());
        }
        this.i++;
    }

    public final C23441wv3 m() {
        return this.c;
    }

    public final CV n() {
        return this.m;
    }

    public final C15060iw3 o() {
        return this.o;
    }

    public final int p() {
        return this.d.a();
    }

    public final int q() {
        return this.d.c();
    }

    public final boolean r() {
        return this.b;
    }

    public final InterfaceC18507om4 s() {
        return this.f;
    }

    public final LazyLayoutItemAnimator t() {
        return this.n;
    }

    public final InterfaceC21665tv3 u() {
        return (InterfaceC21665tv3) this.e.getValue();
    }

    public final InterfaceC9102Ym4 v() {
        return this.t;
    }

    public final C24411ya3 w() {
        return (C24411ya3) this.d.b().getValue();
    }

    public final C4861Gw3 x() {
        return this.r;
    }

    public final InterfaceC9102Ym4 y() {
        return this.s;
    }

    public final androidx.compose.foundation.lazy.layout.d z() {
        return this.p;
    }

    public C6021Lv3(int i2, int i3) {
        this(i2, i3, AbstractC4135Dv3.b(0, 1, null));
    }
}
