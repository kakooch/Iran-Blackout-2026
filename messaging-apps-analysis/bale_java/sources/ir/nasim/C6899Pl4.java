package ir.nasim;

import ir.nasim.VS4;

/* renamed from: ir.nasim.Pl4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C6899Pl4 {
    private final InterfaceC20315ro1 a;
    private final NT4 b;
    private final C9161Yt0 c;

    /* renamed from: ir.nasim.Pl4$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6899Pl4.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6899Pl4.this.d();
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
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Pl4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6899Pl4.this.d();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6899Pl4.this.new b(interfaceC20295rm1).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Pl4$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final VS4.b invoke() {
            return C6899Pl4.this.c.f();
        }
    }

    public C6899Pl4(InterfaceC20315ro1 interfaceC20315ro1, NT4 nt4, N5 n5) {
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(nt4, "parent");
        this.a = interfaceC20315ro1;
        this.b = nt4;
        this.c = new C9161Yt0(nt4.d(), interfaceC20315ro1);
    }

    public final NT4 b() {
        return new NT4(AbstractC6459Nq2.a0(AbstractC6459Nq2.c0(this.c.g(), new a(null)), new b(null)), this.b.f(), this.b.e(), new c());
    }

    public final Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        this.c.e();
        return C19938rB7.a;
    }

    public final N5 d() {
        return null;
    }
}
