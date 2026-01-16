package ir.nasim;

import ir.nasim.DF2;

/* loaded from: classes5.dex */
public final class DF2 {
    private final PE a;
    private final AbstractC13778go1 b;
    private final InterfaceC20315ro1 c;
    private final InterfaceC10258bL6 d;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 D(DF2 df2, InterfaceC14756iQ7 interfaceC14756iQ7) {
            df2.a.E().f().h(interfaceC14756iQ7);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(InterfaceC16204ks5 interfaceC16204ks5, boolean z, AbstractC13554gQ7 abstractC13554gQ7) {
            interfaceC16204ks5.h(Boolean.valueOf(!z));
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = DF2.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                final InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                final InterfaceC14756iQ7 interfaceC14756iQ7 = new InterfaceC14756iQ7() { // from class: ir.nasim.BF2
                    @Override // ir.nasim.InterfaceC14756iQ7
                    public final void b(Object obj2, AbstractC13554gQ7 abstractC13554gQ7) {
                        DF2.a.z(interfaceC16204ks5, ((Boolean) obj2).booleanValue(), abstractC13554gQ7);
                    }
                };
                DF2.this.a.E().f().f(interfaceC14756iQ7);
                final DF2 df2 = DF2.this;
                SA2 sa2 = new SA2() { // from class: ir.nasim.CF2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return DF2.a.D(df2, interfaceC14756iQ7);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public DF2(PE pe, AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(pe, "appSateModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        this.a = pe;
        this.b = abstractC13778go1;
        this.c = interfaceC20315ro1;
        this.d = AbstractC6459Nq2.o0(AbstractC6459Nq2.V(b(), abstractC13778go1), interfaceC20315ro1, InterfaceC16863lz6.a.c(), Boolean.FALSE);
    }

    private final InterfaceC4557Fq2 b() {
        return AbstractC6459Nq2.f(new a(null));
    }

    public final InterfaceC10258bL6 c() {
        return this.d;
    }
}
