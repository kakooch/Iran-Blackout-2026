package ir.nasim;

import ir.nasim.JA3;

/* renamed from: ir.nasim.Gz6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4891Gz6 extends VW7 {
    private final InterfaceC5409Jf2 b;
    private final InterfaceC9336Zm4 c;
    private final InterfaceC10258bL6 d;

    /* renamed from: ir.nasim.Gz6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4891Gz6.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC5409Jf2 interfaceC5409Jf2 = C4891Gz6.this.b;
                String str = this.d;
                this.b = 1;
                objA = interfaceC5409Jf2.a(str, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            if (C9475a16.j(objA)) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = C4891Gz6.this.c;
                String str2 = this.d;
                EnumC4458Ff2 enumC4458Ff2 = EnumC4458Ff2.c;
                if (C9475a16.g(objA)) {
                    objA = enumC4458Ff2;
                }
                interfaceC9336Zm4.setValue(new JA3.b(str2, (EnumC4458Ff2) objA));
            } else {
                C4891Gz6.this.c.setValue(new JA3.a(this.d));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C4891Gz6(InterfaceC5409Jf2 interfaceC5409Jf2) {
        AbstractC13042fc3.i(interfaceC5409Jf2, "falakeRepository");
        this.b = interfaceC5409Jf2;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(null);
        this.c = interfaceC9336Zm4A;
        this.d = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    public final InterfaceC13730gj3 S0(String str) {
        AbstractC13042fc3.i(str, "link");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(str, null), 3, null);
    }

    public final InterfaceC10258bL6 T0() {
        return this.d;
    }

    public final void U0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }
}
