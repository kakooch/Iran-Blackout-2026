package ir.nasim;

/* renamed from: ir.nasim.fT4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12960fT4 {
    private final InterfaceC4557Fq2 a;

    /* renamed from: ir.nasim.fT4$a */
    static final class a extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ SA2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.c = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return this.c.invoke();
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C12960fT4(MT4 mt4, Object obj, AbstractC20044rN5 abstractC20044rN5, SA2 sa2) {
        AbstractC13042fc3.i(mt4, "config");
        AbstractC13042fc3.i(sa2, "pagingSourceFactory");
        this.a = new WS4(new a(sa2, null), obj, mt4, abstractC20044rN5).i();
    }

    public final InterfaceC4557Fq2 a() {
        return this.a;
    }

    public /* synthetic */ C12960fT4(MT4 mt4, Object obj, AbstractC20044rN5 abstractC20044rN5, SA2 sa2, int i, ED1 ed1) {
        this(mt4, (i & 2) != 0 ? null : obj, abstractC20044rN5, sa2);
    }

    public /* synthetic */ C12960fT4(MT4 mt4, Object obj, SA2 sa2, int i, ED1 ed1) {
        this(mt4, (i & 2) != 0 ? null : obj, sa2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C12960fT4(MT4 mt4, Object obj, SA2 sa2) {
        this(mt4, obj, null, sa2);
        AbstractC13042fc3.i(mt4, "config");
        AbstractC13042fc3.i(sa2, "pagingSourceFactory");
    }
}
