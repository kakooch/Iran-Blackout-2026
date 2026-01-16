package ir.nasim;

/* renamed from: ir.nasim.yH1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C24238yH1 {
    private final MO6 a;
    private final E84 b;
    private final AbstractC13778go1 c;

    /* renamed from: ir.nasim.yH1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24238yH1.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C24238yH1.this.a.B();
            C24238yH1.this.b.S1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C24238yH1(MO6 mo6, E84 e84, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(mo6, "storageModule");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = mo6;
        this.b = e84;
        this.c = abstractC13778go1;
    }

    public final Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.c, new a(null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }
}
