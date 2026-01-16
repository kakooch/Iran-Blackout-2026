package ir.nasim;

import ir.nasim.AbstractC23145wQ7;

/* renamed from: ir.nasim.wQ7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC23145wQ7 {

    /* renamed from: ir.nasim.wQ7$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C19482qQ7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C19482qQ7 c19482qQ7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c19482qQ7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 G(InterfaceC16204ks5 interfaceC16204ks5, Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
            interfaceC16204ks5.h(obj);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H(InterfaceC14603iB2 interfaceC14603iB2, Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
            interfaceC14603iB2.invoke(obj, abstractC13554gQ7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 K(C19482qQ7 c19482qQ7, final InterfaceC14603iB2 interfaceC14603iB2) {
            c19482qQ7.h(new InterfaceC14756iQ7() { // from class: ir.nasim.vQ7
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    AbstractC23145wQ7.a.L(interfaceC14603iB2, obj, abstractC13554gQ7);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void L(InterfaceC14603iB2 interfaceC14603iB2, Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
            interfaceC14603iB2.invoke(obj, abstractC13554gQ7);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
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
                final InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.sQ7
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj2, Object obj3) {
                        return AbstractC23145wQ7.a.G(interfaceC16204ks5, obj2, (AbstractC13554gQ7) obj3);
                    }
                };
                this.d.f(new InterfaceC14756iQ7() { // from class: ir.nasim.tQ7
                    @Override // ir.nasim.InterfaceC14756iQ7
                    public final void b(Object obj2, AbstractC13554gQ7 abstractC13554gQ7) {
                        AbstractC23145wQ7.a.H(interfaceC14603iB2, obj2, abstractC13554gQ7);
                    }
                });
                final C19482qQ7 c19482qQ7 = this.d;
                SA2 sa2 = new SA2() { // from class: ir.nasim.uQ7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC23145wQ7.a.K(c19482qQ7, interfaceC14603iB2);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
    }

    public static final InterfaceC4557Fq2 a(C19482qQ7 c19482qQ7) {
        AbstractC13042fc3.i(c19482qQ7, "<this>");
        return AbstractC6459Nq2.f(new a(c19482qQ7, null));
    }
}
