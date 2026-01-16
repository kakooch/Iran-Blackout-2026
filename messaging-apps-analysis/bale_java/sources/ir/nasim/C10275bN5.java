package ir.nasim;

/* renamed from: ir.nasim.bN5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C10275bN5 implements InterfaceC20315ro1, YM5 {
    public static final a e = new a(null);
    public static final int f = 8;
    public static final InterfaceC11938do1 g = new TE0();
    private final InterfaceC11938do1 a;
    private final InterfaceC11938do1 b;
    private final Object c = this;
    private volatile InterfaceC11938do1 d;

    /* renamed from: ir.nasim.bN5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C10275bN5(InterfaceC11938do1 interfaceC11938do1, InterfaceC11938do1 interfaceC11938do12) {
        this.a = interfaceC11938do1;
        this.b = interfaceC11938do12;
    }

    public final void a() {
        synchronized (this.c) {
            try {
                InterfaceC11938do1 interfaceC11938do1 = this.d;
                if (interfaceC11938do1 == null) {
                    this.d = g;
                } else {
                    AbstractC19067pj3.c(interfaceC11938do1, new C18595ov2());
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.YM5
    public void d() {
        a();
    }

    @Override // ir.nasim.YM5
    public void e() {
        a();
    }

    @Override // ir.nasim.InterfaceC20315ro1
    public InterfaceC11938do1 getCoroutineContext() {
        InterfaceC11938do1 interfaceC11938do1X;
        InterfaceC11938do1 interfaceC11938do1 = this.d;
        if (interfaceC11938do1 == null || interfaceC11938do1 == g) {
            synchronized (this.c) {
                try {
                    interfaceC11938do1X = this.d;
                    if (interfaceC11938do1X == null) {
                        InterfaceC11938do1 interfaceC11938do12 = this.a;
                        interfaceC11938do1X = interfaceC11938do12.X(AbstractC19067pj3.a((InterfaceC13730gj3) interfaceC11938do12.a(InterfaceC13730gj3.n0))).X(this.b);
                    } else if (interfaceC11938do1X == g) {
                        InterfaceC11938do1 interfaceC11938do13 = this.a;
                        InterfaceC24075y01 interfaceC24075y01A = AbstractC19067pj3.a((InterfaceC13730gj3) interfaceC11938do13.a(InterfaceC13730gj3.n0));
                        interfaceC24075y01A.g(new C18595ov2());
                        interfaceC11938do1X = interfaceC11938do13.X(interfaceC24075y01A).X(this.b);
                    }
                    this.d = interfaceC11938do1X;
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            interfaceC11938do1 = interfaceC11938do1X;
        }
        AbstractC13042fc3.f(interfaceC11938do1);
        return interfaceC11938do1;
    }

    @Override // ir.nasim.YM5
    public void b() {
    }
}
