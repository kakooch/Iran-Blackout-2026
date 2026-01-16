package ir.nasim;

/* renamed from: ir.nasim.nE6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17600nE6 implements OZ1 {
    public static final int q = 8;
    private final int a;
    private SA2 b;
    private final InterfaceC10351bW0 c;
    private final InterfaceC14354hm4 d;
    private UA2 e;
    private final float[] f;
    private boolean h;
    private final InterfaceC14354hm4 m;
    private final InterfaceC17916nm4 g = UG6.a(0);
    private final InterfaceC14354hm4 i = AbstractC4326Eq5.a(0.0f);
    private final InterfaceC14354hm4 j = AbstractC4326Eq5.a(0.0f);
    private final InterfaceC9102Ym4 k = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
    private final SA2 l = new c();
    private final InterfaceC14354hm4 n = AbstractC4326Eq5.a(0.0f);
    private final IZ1 o = new b();
    private final C17335mn4 p = new C17335mn4();

    /* renamed from: ir.nasim.nE6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ EnumC15562jn4 d;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = enumC15562jn4;
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17600nE6.this.new a(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C17600nE6.this.y(true);
                C17335mn4 c17335mn4 = C17600nE6.this.p;
                IZ1 iz1 = C17600nE6.this.o;
                EnumC15562jn4 enumC15562jn4 = this.d;
                InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                this.b = 1;
                if (c17335mn4.f(iz1, enumC15562jn4, interfaceC14603iB2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C17600nE6.this.y(false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.nE6$b */
    public static final class b implements IZ1 {
        b() {
        }

        @Override // ir.nasim.IZ1
        public void a(float f) {
            C17600nE6.this.e(f);
        }
    }

    /* renamed from: ir.nasim.nE6$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        public final void a() {
            SA2 sa2I;
            if (C17600nE6.this.t() || (sa2I = C17600nE6.this.i()) == null) {
                return;
            }
            sa2I.invoke();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public C17600nE6(float f, int i, SA2 sa2, InterfaceC10351bW0 interfaceC10351bW0) {
        this.a = i;
        this.b = sa2;
        this.c = interfaceC10351bW0;
        this.d = AbstractC4326Eq5.a(f);
        this.f = AbstractC17009mE6.r(i);
        this.m = AbstractC4326Eq5.a(w(0.0f, 0.0f, f));
    }

    private final void B(float f) {
        this.n.s(f);
    }

    private final void C(float f) {
        this.m.s(f);
    }

    private final void F(int i) {
        this.g.h(i);
    }

    private final void I(float f) {
        this.d.s(f);
    }

    private final float j() {
        return this.n.a();
    }

    private final float k() {
        return this.m.a();
    }

    private final int o() {
        return this.g.d();
    }

    private final float s() {
        return this.d.a();
    }

    private final float w(float f, float f2, float f3) {
        return AbstractC17009mE6.n(((Number) this.c.f()).floatValue(), ((Number) this.c.j()).floatValue(), f3, f, f2);
    }

    private final float x(float f, float f2, float f3) {
        return AbstractC17009mE6.n(f, f2, f3, ((Number) this.c.f()).floatValue(), ((Number) this.c.j()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(boolean z) {
        this.k.setValue(Boolean.valueOf(z));
    }

    public final void A(SA2 sa2) {
        this.b = sa2;
    }

    public final void D(boolean z) {
        this.h = z;
    }

    public final void E(float f) {
        this.j.s(f);
    }

    public final void G(float f) {
        this.i.s(f);
    }

    public final void H(float f) {
        I(AbstractC17009mE6.q(AbstractC23053wG5.l(f, ((Number) this.c.f()).floatValue(), ((Number) this.c.j()).floatValue()), this.f, ((Number) this.c.f()).floatValue(), ((Number) this.c.j()).floatValue()));
    }

    public final void J(float f, int i) {
        G(f);
        F(i);
    }

    @Override // ir.nasim.OZ1
    public Object a(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new a(enumC15562jn4, interfaceC14603iB2, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public void e(float f) {
        float f2 = 2;
        float fMax = Math.max(o() - (m() / f2), 0.0f);
        float fMin = Math.min(m() / f2, fMax);
        C(k() + f + j());
        B(0.0f);
        float fX = x(fMin, fMax, AbstractC17009mE6.q(k(), this.f, fMin, fMax));
        if (fX == q()) {
            return;
        }
        UA2 ua2 = this.e;
        if (ua2 == null) {
            H(fX);
        } else if (ua2 != null) {
            ua2.invoke(Float.valueOf(fX));
        }
    }

    public final float f() {
        return AbstractC17009mE6.l(((Number) this.c.f()).floatValue(), ((Number) this.c.j()).floatValue(), AbstractC23053wG5.l(q(), ((Number) this.c.f()).floatValue(), ((Number) this.c.j()).floatValue()));
    }

    public final SA2 g() {
        return this.l;
    }

    public final UA2 h() {
        return this.e;
    }

    public final SA2 i() {
        return this.b;
    }

    public final int l() {
        return this.a;
    }

    public final float m() {
        return this.j.a();
    }

    public final float[] n() {
        return this.f;
    }

    public final float p() {
        return this.i.a();
    }

    public final float q() {
        return s();
    }

    public final InterfaceC10351bW0 r() {
        return this.c;
    }

    public final boolean t() {
        return ((Boolean) this.k.getValue()).booleanValue();
    }

    public final boolean u() {
        return this.h;
    }

    public final void v(long j) {
        B((this.h ? o() - ZG4.m(j) : ZG4.m(j)) - k());
    }

    public final void z(UA2 ua2) {
        this.e = ua2;
    }
}
