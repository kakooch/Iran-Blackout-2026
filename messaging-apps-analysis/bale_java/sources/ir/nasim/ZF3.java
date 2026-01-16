package ir.nasim;

/* loaded from: classes4.dex */
public final class ZF3 {
    private final InterfaceC19305q74 a;
    private final AbstractC13778go1 b;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ C11458d25 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = c11458d25;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ZF3.this.new a(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objC;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19305q74 interfaceC19305q74 = ZF3.this.a;
                long j = this.d;
                C11458d25 c11458d25 = this.e;
                EnumC15083iz enumC15083iz = EnumC15083iz.FORWARD;
                this.b = 1;
                objC = interfaceC19305q74.c(j, c11458d25, 1, enumC15083iz, this);
                if (objC == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objC = ((C9475a16) obj).l();
            }
            if (C9475a16.e(objC) == null) {
                return (J44) objC;
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public ZF3(InterfaceC19305q74 interfaceC19305q74, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC19305q74, "messageRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = interfaceC19305q74;
        this.b = abstractC13778go1;
    }

    public final Object b(C11458d25 c11458d25, long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new a(j, c11458d25, null), interfaceC20295rm1);
    }
}
