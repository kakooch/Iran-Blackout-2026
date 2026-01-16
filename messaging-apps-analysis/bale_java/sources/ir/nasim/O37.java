package ir.nasim;

/* loaded from: classes.dex */
public final class O37 {
    public static final a c = new a(null);
    public static final int d = 0;
    private final WH1 a;
    private final C8822Xm b;

    public static final class a {

        /* renamed from: ir.nasim.O37$a$a, reason: collision with other inner class name */
        static final class C0544a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            public static final C0544a e = new C0544a();

            C0544a() {
                super(2);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final P37 invoke(InterfaceC8730Xb6 interfaceC8730Xb6, O37 o37) {
                return o37.b();
            }
        }

        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ WH1 e;
            final /* synthetic */ UA2 f;
            final /* synthetic */ UA2 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(WH1 wh1, UA2 ua2, UA2 ua22) {
                super(1);
                this.e = wh1;
                this.f = ua2;
                this.g = ua22;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final O37 invoke(P37 p37) {
                return new O37(p37, this.e, this.f, this.g);
            }
        }

        private a() {
        }

        public final InterfaceC8230Vb6 a(UA2 ua2, UA2 ua22, WH1 wh1) {
            return AbstractC8464Wb6.a(C0544a.e, new b(wh1, ua2, ua22));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf(O37.this.c().w1(N37.a));
        }
    }

    public O37(P37 p37, WH1 wh1, UA2 ua2, UA2 ua22) {
        this.a = wh1;
        this.b = new C8822Xm(p37, ua22, new b(), C8088Um.a.a(), ua2);
    }

    public final C8822Xm a() {
        return this.b;
    }

    public final P37 b() {
        return (P37) this.b.s();
    }

    public final WH1 c() {
        return this.a;
    }

    public final P37 d() {
        return (P37) this.b.x();
    }
}
