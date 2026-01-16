package ir.nasim;

/* renamed from: ir.nasim.tN3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21254tN3 implements InterfaceC16863lz6 {
    private final InterfaceC22299v01 b = AbstractC23485x01.c(null, 1, null);

    /* renamed from: ir.nasim.tN3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C21254tN3.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4806Gq2 interfaceC4806Gq2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                InterfaceC22299v01 interfaceC22299v01 = C21254tN3.this.b;
                this.c = interfaceC4806Gq2;
                this.b = 1;
                if (interfaceC22299v01.y(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                AbstractC10685c16.b(obj);
            }
            EnumC15090iz6 enumC15090iz6 = EnumC15090iz6.START;
            this.c = null;
            this.b = 2;
            if (interfaceC4806Gq2.a(enumC15090iz6, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    @Override // ir.nasim.InterfaceC16863lz6
    public InterfaceC4557Fq2 a(InterfaceC10258bL6 interfaceC10258bL6) {
        AbstractC13042fc3.i(interfaceC10258bL6, "subscriptionCount");
        return AbstractC6459Nq2.R(new a(null));
    }

    public final boolean c() {
        return this.b.U(C19938rB7.a);
    }
}
