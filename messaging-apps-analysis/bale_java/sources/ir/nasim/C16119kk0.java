package ir.nasim;

/* renamed from: ir.nasim.kk0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16119kk0 {
    public static final a b = new a(null);
    private final C8556Wm a;

    /* renamed from: ir.nasim.kk0$a */
    public static final class a {

        /* renamed from: ir.nasim.kk0$a$a, reason: collision with other inner class name */
        static final class C1360a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            public static final C1360a e = new C1360a();

            C1360a() {
                super(2);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final EnumC18483ok0 invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C16119kk0 c16119kk0) {
                return (EnumC18483ok0) c16119kk0.b().r();
            }
        }

        /* renamed from: ir.nasim.kk0$a$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ WH1 e;
            final /* synthetic */ InterfaceC5766Kt f;
            final /* synthetic */ UA2 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(WH1 wh1, InterfaceC5766Kt interfaceC5766Kt, UA2 ua2) {
                super(1);
                this.e = wh1;
                this.f = interfaceC5766Kt;
                this.g = ua2;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C16119kk0 invoke(EnumC18483ok0 enumC18483ok0) {
                return new C16119kk0(enumC18483ok0, this.e, this.f, this.g);
            }
        }

        private a() {
        }

        public final InterfaceC8230Vb6 a(InterfaceC5766Kt interfaceC5766Kt, UA2 ua2, WH1 wh1) {
            return AbstractC8464Wb6.a(C1360a.e, new b(wh1, interfaceC5766Kt, ua2));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.kk0$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ WH1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(WH1 wh1) {
            super(1);
            this.e = wh1;
        }

        public final Float a(float f) {
            return Float.valueOf(this.e.w1(AbstractC14938ik0.b));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).floatValue());
        }
    }

    /* renamed from: ir.nasim.kk0$c */
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
            return Float.valueOf(this.e.w1(AbstractC14938ik0.c));
        }
    }

    public C16119kk0(EnumC18483ok0 enumC18483ok0, WH1 wh1, InterfaceC5766Kt interfaceC5766Kt, UA2 ua2) {
        this.a = new C8556Wm(enumC18483ok0, new b(wh1), new c(wh1), interfaceC5766Kt, ua2);
    }

    public final Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        KZ1 kz1N = this.a.n();
        EnumC18483ok0 enumC18483ok0 = EnumC18483ok0.b;
        if (!kz1N.c(enumC18483ok0)) {
            enumC18483ok0 = EnumC18483ok0.a;
        }
        Object objG = AbstractC8322Vm.g(this.a, enumC18483ok0, 0.0f, interfaceC20295rm1, 2, null);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public final C8556Wm b() {
        return this.a;
    }
}
