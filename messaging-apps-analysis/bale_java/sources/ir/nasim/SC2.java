package ir.nasim;

/* loaded from: classes6.dex */
public final class SC2 implements NP0 {
    private final C11458d25 a;
    private final int b;
    private final OK7 c;
    private final C10299bQ2 d;
    private final InterfaceC9173Yu3 e;
    private final InterfaceC9173Yu3 f;

    private final class a extends AbstractC15742k57 {
        final /* synthetic */ SC2 S;

        public a(SC2 sc2, C14697iL2 c14697iL2) {
            AbstractC13042fc3.i(c14697iL2, "group");
            this.S = sc2;
            this.c = c14697iL2.G0();
            this.g = c14697iL2.w0() == sc2.b;
            this.L = new U67();
            V67 v67 = new V67();
            v67.p = false;
            v67.q = false;
            this.N = v67;
        }
    }

    private final class b extends AbstractC19652qi7 {
        final /* synthetic */ SC2 Q;

        public b(SC2 sc2, C17637nI7 c17637nI7) {
            AbstractC13042fc3.i(c17637nI7, "user");
            this.Q = sc2;
            this.l = c17637nI7.u0().getPeerId() == sc2.b;
            this.c = c17637nI7.getName();
            this.d = "";
        }
    }

    public SC2(C11458d25 c11458d25, int i, OK7 ok7, C10299bQ2 c10299bQ2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        this.a = c11458d25;
        this.b = i;
        this.c = ok7;
        this.d = c10299bQ2;
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.QC2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return SC2.j(this.a);
            }
        });
        this.f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.RC2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return SC2.i(this.a);
            }
        });
    }

    private final C14697iL2 g() {
        return (C14697iL2) this.f.getValue();
    }

    private final C17637nI7 h() {
        return (C17637nI7) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14697iL2 i(SC2 sc2) {
        AbstractC13042fc3.i(sc2, "this$0");
        if (sc2.a.s() == W25.b) {
            return (C14697iL2) sc2.d.X1().d(sc2.a.getPeerId());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17637nI7 j(SC2 sc2) {
        AbstractC13042fc3.i(sc2, "this$0");
        if (sc2.a.s() == W25.a) {
            return (C17637nI7) sc2.c.o0().o().d(sc2.a.getPeerId());
        }
        return null;
    }

    @Override // ir.nasim.NP0
    public AbstractC15742k57 a() {
        C14697iL2 c14697iL2G = g();
        if (c14697iL2G != null) {
            return new a(this, c14697iL2G);
        }
        return null;
    }

    @Override // ir.nasim.NP0
    public AbstractC19652qi7 b() {
        C17637nI7 c17637nI7H = h();
        if (c17637nI7H != null) {
            return new b(this, c17637nI7H);
        }
        return null;
    }

    @Override // ir.nasim.NP0
    public InterfaceC14695iL0 c() {
        return null;
    }

    public /* synthetic */ SC2(C11458d25 c11458d25, int i, OK7 ok7, C10299bQ2 c10299bQ2, int i2, ED1 ed1) {
        this(c11458d25, (i2 & 2) != 0 ? AbstractC5969Lp4.e().i0() : i, (i2 & 4) != 0 ? AbstractC5969Lp4.e().W() : ok7, (i2 & 8) != 0 ? AbstractC5969Lp4.e().E() : c10299bQ2);
    }
}
