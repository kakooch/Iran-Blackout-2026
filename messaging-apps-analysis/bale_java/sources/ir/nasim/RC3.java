package ir.nasim;

/* loaded from: classes2.dex */
public final class RC3 implements QC3 {
    private C17342mo1 a;
    private final InterfaceC11938do1 b;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = obj;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return RC3.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C17342mo1 c17342mo1B = RC3.this.b();
                this.b = 1;
                if (c17342mo1B.t(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            RC3.this.b().p(this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public RC3(C17342mo1 c17342mo1, InterfaceC11938do1 interfaceC11938do1) {
        AbstractC13042fc3.i(c17342mo1, "target");
        AbstractC13042fc3.i(interfaceC11938do1, "context");
        this.a = c17342mo1;
        this.b = interfaceC11938do1.X(C12366eV1.c().F0());
    }

    @Override // ir.nasim.QC3
    public Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.b, new a(obj, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public final C17342mo1 b() {
        return this.a;
    }
}
