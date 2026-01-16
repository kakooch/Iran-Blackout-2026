package ir.nasim;

/* renamed from: ir.nasim.kk5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16124kk5 implements InterfaceC23475wz1 {
    private final InterfaceC23475wz1 a;

    /* renamed from: ir.nasim.kk5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14603iB2;
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
                AbstractC19670qk5 abstractC19670qk5 = (AbstractC19670qk5) this.c;
                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                this.b = 1;
                obj = interfaceC14603iB2.invoke(abstractC19670qk5, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            AbstractC19670qk5 abstractC19670qk52 = (AbstractC19670qk5) obj;
            ((C4772Gm4) abstractC19670qk52).g();
            return abstractC19670qk52;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(AbstractC19670qk5 abstractC19670qk5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(abstractC19670qk5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C16124kk5(InterfaceC23475wz1 interfaceC23475wz1) {
        AbstractC13042fc3.i(interfaceC23475wz1, "delegate");
        this.a = interfaceC23475wz1;
    }

    @Override // ir.nasim.InterfaceC23475wz1
    public Object a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.a(new a(interfaceC14603iB2, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC23475wz1
    public InterfaceC4557Fq2 getData() {
        return this.a.getData();
    }
}
