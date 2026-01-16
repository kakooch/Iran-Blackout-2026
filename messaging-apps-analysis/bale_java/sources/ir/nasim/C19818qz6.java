package ir.nasim;

/* renamed from: ir.nasim.qz6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19818qz6 {
    public static final a d = new a(null);
    private final boolean a;
    private final boolean b;
    private C8822Xm c;

    /* renamed from: ir.nasim.qz6$a */
    public static final class a {

        /* renamed from: ir.nasim.qz6$a$a, reason: collision with other inner class name */
        static final class C1487a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            public static final C1487a e = new C1487a();

            C1487a() {
                super(2);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final EnumC20427rz6 invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C19818qz6 c19818qz6) {
                return c19818qz6.e();
            }
        }

        /* renamed from: ir.nasim.qz6$a$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ boolean e;
            final /* synthetic */ WH1 f;
            final /* synthetic */ UA2 g;
            final /* synthetic */ boolean h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(boolean z, WH1 wh1, UA2 ua2, boolean z2) {
                super(1);
                this.e = z;
                this.f = wh1;
                this.g = ua2;
                this.h = z2;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C19818qz6 invoke(EnumC20427rz6 enumC20427rz6) {
                return new C19818qz6(this.e, this.f, enumC20427rz6, this.g, this.h);
            }
        }

        private a() {
        }

        public final InterfaceC8230Vb6 a(boolean z, UA2 ua2, WH1 wh1, boolean z2) {
            return AbstractC8464Wb6.a(C1487a.e, new b(z, wh1, ua2, z2));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.qz6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ WH1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(WH1 wh1) {
            super(1);
            this.e = wh1;
        }

        public final Float a(float f) {
            return Float.valueOf(this.e.w1(C17784nZ1.q(56)));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).floatValue());
        }
    }

    /* renamed from: ir.nasim.qz6$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ WH1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(WH1 wh1) {
            super(0);
            this.e = wh1;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf(this.e.w1(C17784nZ1.q(125)));
        }
    }

    public C19818qz6(boolean z, WH1 wh1, EnumC20427rz6 enumC20427rz6, UA2 ua2, boolean z2) {
        this.a = z;
        this.b = z2;
        if (z && enumC20427rz6 == EnumC20427rz6.PartiallyExpanded) {
            throw new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.".toString());
        }
        if (z2 && enumC20427rz6 == EnumC20427rz6.Hidden) {
            throw new IllegalArgumentException("The initial value must not be set to Hidden if skipHiddenState is set to true.".toString());
        }
        this.c = new C8822Xm(enumC20427rz6, new b(wh1), new c(wh1), AbstractC19227pz6.b, ua2);
    }

    public static /* synthetic */ Object b(C19818qz6 c19818qz6, EnumC20427rz6 enumC20427rz6, float f, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 2) != 0) {
            f = c19818qz6.c.v();
        }
        return c19818qz6.a(enumC20427rz6, f, interfaceC20295rm1);
    }

    public final Object a(EnumC20427rz6 enumC20427rz6, float f, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objF = androidx.compose.material3.internal.b.f(this.c, enumC20427rz6, f, interfaceC20295rm1);
        return objF == AbstractC14862ic3.e() ? objF : C19938rB7.a;
    }

    public final Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = androidx.compose.material3.internal.b.g(this.c, EnumC20427rz6.Expanded, 0.0f, interfaceC20295rm1, 2, null);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public final C8822Xm d() {
        return this.c;
    }

    public final EnumC20427rz6 e() {
        return (EnumC20427rz6) this.c.s();
    }

    public final boolean f() {
        return this.c.o().c(EnumC20427rz6.Expanded);
    }

    public final boolean g() {
        return this.c.o().c(EnumC20427rz6.PartiallyExpanded);
    }

    public final boolean h() {
        return this.a;
    }

    public final EnumC20427rz6 i() {
        return (EnumC20427rz6) this.c.x();
    }

    public final Object j(InterfaceC20295rm1 interfaceC20295rm1) {
        if (!(!this.b)) {
            throw new IllegalStateException("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.".toString());
        }
        Object objB = b(this, EnumC20427rz6.Hidden, 0.0f, interfaceC20295rm1, 2, null);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    public final boolean k() {
        return this.c.s() != EnumC20427rz6.Hidden;
    }

    public final Object l(InterfaceC20295rm1 interfaceC20295rm1) {
        if (!(!this.a)) {
            throw new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.".toString());
        }
        Object objB = b(this, EnumC20427rz6.PartiallyExpanded, 0.0f, interfaceC20295rm1, 2, null);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    public final float m() {
        return this.c.A();
    }

    public final Object n(float f, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = this.c.G(f, interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public final Object o(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = b(this, g() ? EnumC20427rz6.PartiallyExpanded : EnumC20427rz6.Expanded, 0.0f, interfaceC20295rm1, 2, null);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }
}
