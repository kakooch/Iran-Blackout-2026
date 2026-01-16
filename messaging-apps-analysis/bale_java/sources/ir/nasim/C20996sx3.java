package ir.nasim;

/* renamed from: ir.nasim.sx3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20996sx3 {
    public static final int f = 8;
    private final InterfaceC4557Fq2 a;
    private final InterfaceC11938do1 b;
    private final c c;
    private final InterfaceC9102Ym4 d;
    private final InterfaceC9102Ym4 e;

    /* renamed from: ir.nasim.sx3$a */
    static final class a implements InterfaceC4806Gq2 {
        a() {
        }

        @Override // ir.nasim.InterfaceC4806Gq2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object a(C13628gZ0 c13628gZ0, InterfaceC20295rm1 interfaceC20295rm1) {
            C20996sx3.this.l(c13628gZ0);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.sx3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C20996sx3.this.new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                NT4 nt4 = (NT4) this.c;
                c cVar = C20996sx3.this.c;
                this.b = 1;
                if (cVar.o(nt4, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sx3$c */
    public static final class c extends ST4 {
        c(InterfaceC11938do1 interfaceC11938do1, NT4 nt4) {
            super(interfaceC11938do1, nt4);
        }

        @Override // ir.nasim.ST4
        public Object u(PT4 pt4, InterfaceC20295rm1 interfaceC20295rm1) {
            C20996sx3.this.m();
            return C19938rB7.a;
        }
    }

    public C20996sx3(InterfaceC4557Fq2 interfaceC4557Fq2) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "flow");
        this.a = interfaceC4557Fq2;
        InterfaceC11938do1 interfaceC11938do1B = C20343rr.m.b();
        this.b = interfaceC11938do1B;
        c cVar = new c(interfaceC11938do1B, interfaceC4557Fq2 instanceof InterfaceC10040ay6 ? (NT4) AbstractC15401jX0.s0(((InterfaceC10040ay6) interfaceC4557Fq2).e()) : null);
        this.c = cVar;
        this.d = AbstractC13472gH6.d(cVar.A(), null, 2, null);
        C13628gZ0 c13628gZ0 = (C13628gZ0) cVar.q().getValue();
        this.e = AbstractC13472gH6.d(c13628gZ0 == null ? new C13628gZ0(AbstractC21683tx3.b.f(), AbstractC21683tx3.b.e(), AbstractC21683tx3.b.d(), AbstractC21683tx3.b, null, 16, null) : c13628gZ0, null, 2, null);
    }

    private final void k(C11066cg3 c11066cg3) {
        this.d.setValue(c11066cg3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(C13628gZ0 c13628gZ0) {
        this.e.setValue(c13628gZ0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        k(this.c.A());
    }

    public final Object d(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = AbstractC6459Nq2.F(this.c.q()).b(new a(), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    public final Object e(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(this.a, new b(null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    public final Object f(int i) {
        this.c.p(i);
        return h().get(i);
    }

    public final int g() {
        return h().size();
    }

    public final C11066cg3 h() {
        return (C11066cg3) this.d.getValue();
    }

    public final C13628gZ0 i() {
        return (C13628gZ0) this.e.getValue();
    }

    public final Object j(int i) {
        return h().get(i);
    }
}
