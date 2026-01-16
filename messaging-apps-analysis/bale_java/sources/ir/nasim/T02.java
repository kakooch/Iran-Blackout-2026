package ir.nasim;

/* loaded from: classes.dex */
public final class T02 {
    public static final a c = new a(null);
    private final C8556Wm a;
    private WH1 b;

    public static final class a {

        /* renamed from: ir.nasim.T02$a$a, reason: collision with other inner class name */
        static final class C0639a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            public static final C0639a e = new C0639a();

            C0639a() {
                super(2);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final U02 invoke(InterfaceC8730Xb6 interfaceC8730Xb6, T02 t02) {
                return t02.d();
            }
        }

        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ UA2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(UA2 ua2) {
                super(1);
                this.e = ua2;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final T02 invoke(U02 u02) {
                return new T02(u02, this.e);
            }
        }

        private a() {
        }

        public final InterfaceC8230Vb6 a(UA2 ua2) {
            return AbstractC8464Wb6.a(C0639a.e, new b(ua2));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final Float a(float f) {
            return Float.valueOf(T02.this.f().w1(Q02.b));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).floatValue());
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf(T02.this.f().w1(Q02.c));
        }
    }

    public T02(U02 u02, UA2 ua2) {
        this.a = new C8556Wm(u02, new b(), new c(), Q02.d, ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WH1 f() {
        WH1 wh1 = this.b;
        if (wh1 != null) {
            return wh1;
        }
        throw new IllegalArgumentException(("The density on DrawerState (" + this + ") was not set. Did you use DrawerState with the Drawer composable?").toString());
    }

    public final Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC8322Vm.g(this.a, U02.a, 0.0f, interfaceC20295rm1, 2, null);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public final C8556Wm c() {
        return this.a;
    }

    public final U02 d() {
        return (U02) this.a.r();
    }

    public final boolean e() {
        return d() == U02.b;
    }

    public final float g() {
        return this.a.z();
    }

    public final void h(WH1 wh1) {
        this.b = wh1;
    }
}
