package ir.nasim;

/* loaded from: classes7.dex */
public final class BF1 extends VW7 {
    private final IF2 b;
    private final InterfaceC9336Zm4 c;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BF1.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object value2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = BF1.this.c;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, AF1.c((AF1) value, null, true, null, 5, null)));
                this.b = 1;
                if (HG1.b(500L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = BF1.this.c;
            do {
                value2 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value2, AF1.c((AF1) value2, null, false, null, 5, null)));
            BF1.this.X0();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public BF1(IF2 if2) {
        Object value;
        AbstractC13042fc3.i(if2, "getDefaultTabUseCase");
        this.b = if2;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AF1.d.a());
        this.c = interfaceC9336Zm4A;
        do {
            value = interfaceC9336Zm4A.getValue();
        } while (!interfaceC9336Zm4A.f(value, AF1.c((AF1) value, this.b.b(), false, null, 6, null)));
    }

    private final void V0(String str, int i) {
        W0();
        C3343Am.i("navigation_set_default_tab", AbstractC20051rO3.n(AbstractC4616Fw7.a("tab_title", str), AbstractC4616Fw7.a("tab_num", Integer.valueOf(i)), AbstractC4616Fw7.a("back_stage", 2)));
    }

    private final void W0() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.d(), null, new a(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AF1.c((AF1) value, null, false, XF6.a, 3, null)));
    }

    private final void Y0(EnumC15002iq4 enumC15002iq4) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AF1.c((AF1) value, enumC15002iq4, false, null, 6, null)));
    }

    public final InterfaceC10258bL6 S0() {
        return this.c;
    }

    public final void T0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AF1.c((AF1) value, null, false, null, 3, null)));
    }

    public final void U0(EnumC15002iq4 enumC15002iq4, String str) {
        AbstractC13042fc3.i(enumC15002iq4, "tab");
        AbstractC13042fc3.i(str, "title");
        if (((AF1) S0().getValue()).d() != enumC15002iq4) {
            V0(str, enumC15002iq4.ordinal());
            Y0(enumC15002iq4);
        }
    }
}
