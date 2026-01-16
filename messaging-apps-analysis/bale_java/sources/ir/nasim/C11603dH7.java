package ir.nasim;

/* renamed from: ir.nasim.dH7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11603dH7 extends IL {
    private final long b;
    private final InterfaceC12246eH7 c;
    private final C14970in2 d;
    private final InterfaceC10223bH7 e;

    /* renamed from: ir.nasim.dH7$a */
    public static final class a implements InterfaceC10223bH7 {
        a() {
        }

        @Override // ir.nasim.InterfaceC10223bH7
        public void b() {
            C11603dH7.this.f(new c());
        }

        @Override // ir.nasim.InterfaceC10223bH7
        public void f(float f, int i) {
            C11603dH7.this.f(new d(f, i));
        }

        @Override // ir.nasim.InterfaceC10223bH7
        public void g(boolean z) {
            C11603dH7.this.f(new b(z));
        }
    }

    /* renamed from: ir.nasim.dH7$b */
    private static final class b {
        private final boolean a;

        public b(boolean z) {
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.dH7$c */
    private static final class c {
    }

    /* renamed from: ir.nasim.dH7$d */
    private static final class d {
        private final float a;
        private final int b;

        public d(float f, int i) {
            this.a = f;
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public final float b() {
            return this.a;
        }
    }

    public C11603dH7(long j, InterfaceC12246eH7 interfaceC12246eH7, C14970in2 c14970in2) {
        AbstractC13042fc3.i(interfaceC12246eH7, "vmCallback");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        this.b = j;
        this.c = interfaceC12246eH7;
        this.d = c14970in2;
        a aVar = new a();
        this.e = aVar;
        c14970in2.F(j, aVar);
    }

    @Override // ir.nasim.IL, ir.nasim.InterfaceC7857Tm2
    public void b() {
        super.b();
        this.d.k0(this.b, this.e);
    }

    @Override // ir.nasim.IL
    protected void e(Object obj) {
        AbstractC13042fc3.i(obj, "obj");
        if (obj instanceof b) {
            this.c.k();
            if (((b) obj).a()) {
                return;
            }
            this.c.i();
            return;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            this.c.f(dVar.b(), dVar.a());
        } else if (obj instanceof c) {
            this.c.b();
        }
    }
}
