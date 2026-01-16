package ir.nasim;

/* renamed from: ir.nasim.Qq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC7186Qq2 {

    /* renamed from: ir.nasim.Qq2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC4557Fq2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC4557Fq2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2 = this.c;
                this.b = 1;
                if (AbstractC6459Nq2.k(interfaceC4557Fq2, this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = interfaceC4557Fq2.b(C19944rC4.a, interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    public static final Object b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objK = AbstractC6459Nq2.k(AbstractC7420Rq2.b(AbstractC6459Nq2.X(interfaceC4557Fq2, interfaceC14603iB2), 0, null, 2, null), interfaceC20295rm1);
        return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
    }

    public static final Object c(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
        AbstractC6459Nq2.D(interfaceC4806Gq2);
        Object objB = interfaceC4557Fq2.b(interfaceC4806Gq2, interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    public static final InterfaceC13730gj3 d(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(interfaceC4557Fq2, null), 3, null);
    }
}
