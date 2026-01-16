package ir.nasim;

import ir.nasim.InterfaceC16756lo6;

/* loaded from: classes2.dex */
public abstract class DE0 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC13730gj3 d;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* renamed from: ir.nasim.DE0$a$a, reason: collision with other inner class name */
        static final class C0316a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ OC6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0316a(OC6 oc6) {
                super(1);
                this.e = oc6;
            }

            public final void a(Throwable th) {
                InterfaceC16756lo6.a.a(this.e, null, 1, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC13730gj3 interfaceC13730gj3, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC13730gj3;
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                OC6 oc6 = (OC6) this.c;
                this.d.s(new C0316a(oc6));
                InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                this.b = 1;
                if (interfaceC14603iB2.invoke(oc6, this) == objE) {
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
        public final Object invoke(OC6 oc6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(oc6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC4557Fq2 a(InterfaceC13730gj3 interfaceC13730gj3, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC13730gj3, "controller");
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        return BC6.a(new a(interfaceC13730gj3, interfaceC14603iB2, null));
    }
}
