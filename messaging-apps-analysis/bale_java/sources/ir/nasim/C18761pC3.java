package ir.nasim;

/* renamed from: ir.nasim.pC3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C18761pC3 extends AbstractC6360Ng4 {
    private final C9057Yh4 m;

    /* renamed from: ir.nasim.pC3$a */
    public static class a {
        private C16110kj1 a;

        public a(C16110kj1 c16110kj1) {
            this.a = c16110kj1;
        }
    }

    /* renamed from: ir.nasim.pC3$b */
    public static class b {
    }

    /* renamed from: ir.nasim.pC3$c */
    public static class c {
        private boolean a;

        public c(boolean z) {
            this.a = z;
        }

        public boolean a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.pC3$d */
    public static class d {
    }

    /* renamed from: ir.nasim.pC3$e */
    public static class e {
        private OP1 a;
        private EnumC12820fE b;

        public e(OP1 op1, EnumC12820fE enumC12820fE) {
            this.a = op1;
            this.b = enumC12820fE;
        }

        public OP1 a() {
            return this.a;
        }

        public EnumC12820fE b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.pC3$f */
    public static class f {
        private EF2 a;

        public f(EF2 ef2) {
            this.a = ef2;
        }
    }

    /* renamed from: ir.nasim.pC3$g */
    public static class g {
    }

    public C18761pC3(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.m = c9057Yh4;
    }

    public void d0(C16110kj1 c16110kj1) {
        this.m.v().D().k(c16110kj1);
    }

    public void e0() {
        this.m.v().D().q();
    }

    public void f0(boolean z) {
        this.m.v().D().l(z);
    }

    public void g0() {
        this.m.v().D().m();
    }

    public void h0(OP1 op1, EnumC12820fE enumC12820fE) {
        this.m.v().D().n(op1, enumC12820fE);
    }

    public void i0(EF2 ef2) {
        this.m.v().D().p(ef2);
    }

    public void j0() {
        this.m.v().D().r();
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof c) {
            f0(((c) obj).a());
            return;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            h0(eVar.a(), eVar.b());
            return;
        }
        if (obj instanceof b) {
            e0();
            return;
        }
        if (obj instanceof d) {
            g0();
            return;
        }
        if (obj instanceof a) {
            d0(((a) obj).a);
            return;
        }
        if (obj instanceof f) {
            i0(((f) obj).a);
        } else if (obj instanceof g) {
            j0();
        } else {
            super.m(obj);
        }
    }
}
