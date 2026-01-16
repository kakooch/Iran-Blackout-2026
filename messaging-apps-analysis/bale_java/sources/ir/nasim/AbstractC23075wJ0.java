package ir.nasim;

import ir.nasim.InterfaceC22753vm1;

/* renamed from: ir.nasim.wJ0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23075wJ0 extends AbstractC20003rJ0 {
    protected final InterfaceC4557Fq2 d;

    /* renamed from: ir.nasim.wJ0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = AbstractC23075wJ0.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                AbstractC23075wJ0 abstractC23075wJ0 = AbstractC23075wJ0.this;
                this.b = 1;
                if (abstractC23075wJ0.t(interfaceC4806Gq2, this) == objE) {
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
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public AbstractC23075wJ0(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        super(interfaceC11938do1, i, enumC6162Ml0);
        this.d = interfaceC4557Fq2;
    }

    static /* synthetic */ Object q(AbstractC23075wJ0 abstractC23075wJ0, InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        if (abstractC23075wJ0.b == -3) {
            InterfaceC11938do1 context = interfaceC20295rm1.getContext();
            InterfaceC11938do1 interfaceC11938do1D = AbstractC12551eo1.d(context, abstractC23075wJ0.a);
            if (AbstractC13042fc3.d(interfaceC11938do1D, context)) {
                Object objT = abstractC23075wJ0.t(interfaceC4806Gq2, interfaceC20295rm1);
                return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
            }
            InterfaceC22753vm1.b bVar = InterfaceC22753vm1.g0;
            if (AbstractC13042fc3.d(interfaceC11938do1D.a(bVar), context.a(bVar))) {
                Object objS = abstractC23075wJ0.s(interfaceC4806Gq2, interfaceC11938do1D, interfaceC20295rm1);
                return objS == AbstractC14862ic3.e() ? objS : C19938rB7.a;
            }
        }
        Object objB = super.b(interfaceC4806Gq2, interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    static /* synthetic */ Object r(AbstractC23075wJ0 abstractC23075wJ0, InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objT = abstractC23075wJ0.t(new C7640So6(interfaceC16204ks5), interfaceC20295rm1);
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    private final Object s(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC11938do1 interfaceC11938do1, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = AbstractC21889uJ0.d(interfaceC11938do1, AbstractC21889uJ0.e(interfaceC4806Gq2, interfaceC20295rm1.getContext()), null, new a(null), interfaceC20295rm1, 4, null);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC20003rJ0, ir.nasim.InterfaceC4557Fq2
    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        return q(this, interfaceC4806Gq2, interfaceC20295rm1);
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected Object j(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
        return r(this, interfaceC16204ks5, interfaceC20295rm1);
    }

    protected abstract Object t(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1);

    @Override // ir.nasim.AbstractC20003rJ0
    public String toString() {
        return this.d + " -> " + super.toString();
    }
}
