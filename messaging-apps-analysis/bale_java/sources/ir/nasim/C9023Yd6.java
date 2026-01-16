package ir.nasim;

import androidx.compose.runtime.snapshots.g;

/* renamed from: ir.nasim.Yd6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9023Yd6 implements InterfaceC11049ce6 {
    public static final c i = new c(null);
    private static final InterfaceC8230Vb6 j = AbstractC8464Wb6.a(a.e, b.e);
    private final InterfaceC17916nm4 a;
    private float e;
    private final InterfaceC17916nm4 b = UG6.a(0);
    private final InterfaceC18507om4 c = AbstractC23831xb3.a();
    private InterfaceC17916nm4 d = UG6.a(Integer.MAX_VALUE);
    private final InterfaceC11049ce6 f = AbstractC11844de6.a(new f());
    private final InterfaceC9664aL6 g = AbstractC10222bH6.d(new e());
    private final InterfaceC9664aL6 h = AbstractC10222bH6.d(new d());

    /* renamed from: ir.nasim.Yd6$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C9023Yd6 c9023Yd6) {
            return Integer.valueOf(c9023Yd6.o());
        }
    }

    /* renamed from: ir.nasim.Yd6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final C9023Yd6 a(int i) {
            return new C9023Yd6(i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.Yd6$c */
    public static final class c {
        private c() {
        }

        public final InterfaceC8230Vb6 a() {
            return C9023Yd6.j;
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Yd6$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(C9023Yd6.this.o() > 0);
        }
    }

    /* renamed from: ir.nasim.Yd6$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(C9023Yd6.this.o() < C9023Yd6.this.n());
        }
    }

    /* renamed from: ir.nasim.Yd6$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        f() {
            super(1);
        }

        public final Float a(float f) {
            float fO = C9023Yd6.this.o() + f + C9023Yd6.this.e;
            float fL = AbstractC23053wG5.l(fO, 0.0f, C9023Yd6.this.n());
            boolean z = !(fO == fL);
            float fO2 = fL - C9023Yd6.this.o();
            int iRound = Math.round(fO2);
            C9023Yd6 c9023Yd6 = C9023Yd6.this;
            c9023Yd6.q(c9023Yd6.o() + iRound);
            C9023Yd6.this.e = fO2 - iRound;
            if (z) {
                f = fO2;
            }
            return Float.valueOf(f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).floatValue());
        }
    }

    public C9023Yd6(int i2) {
        this.a = UG6.a(i2);
    }

    public static /* synthetic */ Object l(C9023Yd6 c9023Yd6, int i2, InterfaceC5766Kt interfaceC5766Kt, InterfaceC20295rm1 interfaceC20295rm1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            interfaceC5766Kt = new C18827pJ6(0.0f, 0.0f, null, 7, null);
        }
        return c9023Yd6.k(i2, interfaceC5766Kt, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int i2) {
        this.a.h(i2);
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public Object b(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = this.f.b(enumC15562jn4, interfaceC14603iB2, interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public boolean c() {
        return this.f.c();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public boolean d() {
        return ((Boolean) this.h.getValue()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public boolean e() {
        return ((Boolean) this.g.getValue()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC11049ce6
    public float f(float f2) {
        return this.f.f(f2);
    }

    public final Object k(int i2, InterfaceC5766Kt interfaceC5766Kt, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = AbstractC7778Td6.a(this, i2 - o(), interfaceC5766Kt, interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    public final InterfaceC18507om4 m() {
        return this.c;
    }

    public final int n() {
        return this.d.d();
    }

    public final int o() {
        return this.a.d();
    }

    public final void p(int i2) {
        this.d.h(i2);
        g.a aVar = androidx.compose.runtime.snapshots.g.e;
        androidx.compose.runtime.snapshots.g gVarD = aVar.d();
        UA2 ua2G = gVarD != null ? gVarD.g() : null;
        androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
        try {
            if (o() > i2) {
                q(i2);
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            aVar.l(gVarD, gVarE, ua2G);
        } catch (Throwable th) {
            aVar.l(gVarD, gVarE, ua2G);
            throw th;
        }
    }

    public final void r(int i2) {
        this.b.h(i2);
    }
}
