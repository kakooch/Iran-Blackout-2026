package ir.nasim;

import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;

/* loaded from: classes5.dex */
public final class K82 implements D48 {
    private final C6287Mz a;
    private final InterfaceC20315ro1 b;
    private final AbstractC13778go1 c;
    private final C22580vU2 d;
    private InterfaceC13730gj3 e;
    private InterfaceC13730gj3 f;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC13730gj3 d;
        final /* synthetic */ K82 e;
        final /* synthetic */ AbstractC20556sC7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC13730gj3 interfaceC13730gj3, K82 k82, AbstractC20556sC7 abstractC20556sC7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC13730gj3;
            this.e = k82;
            this.f = abstractC20556sC7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            InterfaceC20315ro1 interfaceC20315ro12;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC13730gj3 interfaceC13730gj3 = this.d;
                if (interfaceC13730gj3 != null) {
                    this.c = interfaceC20315ro1;
                    this.b = 1;
                    if (AbstractC19067pj3.g(interfaceC13730gj3, this) == objE) {
                        return objE;
                    }
                    interfaceC20315ro12 = interfaceC20315ro1;
                }
                this.e.a.H().c().e((ConnectionEndpoint[]) ((C21842uD7) this.f).a().toArray(new ConnectionEndpoint[0]));
                AbstractC20906so1.f(interfaceC20315ro1);
                this.e.a.K();
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC20315ro12 = (InterfaceC20315ro1) this.c;
            AbstractC10685c16.b(obj);
            interfaceC20315ro1 = interfaceC20315ro12;
            this.e.a.H().c().e((ConnectionEndpoint[]) ((C21842uD7) this.f).a().toArray(new ConnectionEndpoint[0]));
            AbstractC20906so1.f(interfaceC20315ro1);
            this.e.a.K();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC13730gj3 c;
        final /* synthetic */ K82 d;
        final /* synthetic */ AbstractC20556sC7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC13730gj3 interfaceC13730gj3, K82 k82, AbstractC20556sC7 abstractC20556sC7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC13730gj3;
            this.d = k82;
            this.e = abstractC20556sC7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC13730gj3 interfaceC13730gj3 = this.c;
                if (interfaceC13730gj3 != null) {
                    this.b = 1;
                    if (AbstractC19067pj3.g(interfaceC13730gj3, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            this.d.d.j(((C24217yE7) this.e).a());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private K82(C6287Mz c6287Mz, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, C22580vU2 c22580vU2) {
        this.a = c6287Mz;
        this.b = interfaceC20315ro1;
        this.c = abstractC13778go1;
        this.d = c22580vU2;
    }

    @Override // ir.nasim.D48
    public boolean d(AbstractC20556sC7 abstractC20556sC7, long j) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        if (abstractC20556sC7 instanceof C21842uD7) {
            this.e = AbstractC10533bm0.d(this.b, this.c, null, new a(this.e, this, abstractC20556sC7, null), 2, null);
            return true;
        }
        if (!(abstractC20556sC7 instanceof C24217yE7)) {
            return false;
        }
        this.f = AbstractC10533bm0.d(this.b, this.c, null, new b(this.f, this, abstractC20556sC7, null), 2, null);
        return true;
    }

    /* synthetic */ K82(C6287Mz c6287Mz, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, C22580vU2 c22580vU2, int i, ED1 ed1) {
        this(c6287Mz, (i & 2) != 0 ? C17050mJ2.a : interfaceC20315ro1, (i & 4) != 0 ? C12366eV1.b() : abstractC13778go1, (i & 8) != 0 ? C22580vU2.c.a() : c22580vU2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public K82(C9057Yh4 c9057Yh4) {
        AbstractC13042fc3.i(c9057Yh4, "context");
        C6287Mz c6287MzS = c9057Yh4.s();
        AbstractC13042fc3.h(c6287MzS, "getApiModule(...)");
        this(c6287MzS, null, null, null, 14, null);
    }
}
