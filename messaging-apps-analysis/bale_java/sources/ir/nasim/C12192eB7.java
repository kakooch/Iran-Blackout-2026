package ir.nasim;

/* renamed from: ir.nasim.eB7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C12192eB7 implements InterfaceC4806Gq2 {
    private final InterfaceC11938do1 a;
    private final Object b;
    private final InterfaceC14603iB2 c;

    /* renamed from: ir.nasim.eB7$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ InterfaceC4806Gq2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC4806Gq2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Object obj2 = this.c;
                InterfaceC4806Gq2 interfaceC4806Gq2 = this.d;
                this.b = 1;
                if (interfaceC4806Gq2.a(obj2, this) == objE) {
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
        public final Object invoke(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(obj, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C12192eB7(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC11938do1 interfaceC11938do1) {
        this.a = interfaceC11938do1;
        this.b = AbstractC7173Qo7.b(interfaceC11938do1);
        this.c = new a(interfaceC4806Gq2, null);
    }

    @Override // ir.nasim.InterfaceC4806Gq2
    public Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = AbstractC21889uJ0.c(this.a, obj, this.b, this.c, interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }
}
