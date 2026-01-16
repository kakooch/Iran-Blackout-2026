package ir.nasim;

import ir.nasim.BN6;

/* loaded from: classes5.dex */
public final class AN6 implements InterfaceC25225zw4 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                BN6.b bVar = BN6.e;
                C6287Mz c6287MzS = C5735Kp4.w().i().o2().s();
                AbstractC13042fc3.h(c6287MzS, "getApiModule(...)");
                InterfaceC3570Bk5 interfaceC3570Bk5C = C5735Kp4.w().i().o2().c();
                AbstractC13042fc3.h(interfaceC3570Bk5C, "<get-preferences>(...)");
                InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.j);
                AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
                BN6 bn6A = bVar.a(c6287MzS, interfaceC3570Bk5C, interfaceC3570Bk5Q);
                this.b = 1;
                if (bn6A.s(this) == objE) {
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

    @Override // ir.nasim.InterfaceC25225zw4
    public C6517Nv5 a(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        if (!(abstractC20556sC7 instanceof BF7)) {
            return null;
        }
        AbstractC10533bm0.d(C17050mJ2.a, null, null, new a(null), 3, null);
        return C6517Nv5.l0(C14505i18.a);
    }
}
