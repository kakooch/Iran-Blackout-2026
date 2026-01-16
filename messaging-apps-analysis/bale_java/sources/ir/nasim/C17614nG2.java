package ir.nasim;

/* renamed from: ir.nasim.nG2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17614nG2 {
    private final InterfaceC4308Eo5 a;
    private final AbstractC13778go1 b;

    /* renamed from: ir.nasim.nG2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17614nG2.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            PI7 pi7F;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4308Eo5 interfaceC4308Eo5 = C17614nG2.this.a;
                long j = this.d;
                this.b = 1;
                obj = interfaceC4308Eo5.h(j, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return (PI7) obj;
                }
                AbstractC10685c16.b(obj);
            }
            SI7 si7 = (SI7) obj;
            if (si7 != null && (pi7F = XI7.f(si7)) != null) {
                return pi7F;
            }
            C17614nG2 c17614nG2 = C17614nG2.this;
            long j2 = this.d;
            this.b = 2;
            obj = c17614nG2.c(j2, this);
            if (obj == objE) {
                return objE;
            }
            return (PI7) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C17614nG2(InterfaceC4308Eo5 interfaceC4308Eo5, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC4308Eo5, "presenceRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = interfaceC4308Eo5;
        this.b = abstractC13778go1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object c(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.b((int) j, interfaceC20295rm1);
    }

    public final Object d(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new a(j, null), interfaceC20295rm1);
    }
}
