package ir.nasim;

import java.util.Iterator;

/* loaded from: classes8.dex */
public final class EJ0 extends AbstractC20003rJ0 {
    private final Iterable d;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC4557Fq2 c;
        final /* synthetic */ C7640So6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC4557Fq2 interfaceC4557Fq2, C7640So6 c7640So6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC4557Fq2;
            this.d = c7640So6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2 = this.c;
                C7640So6 c7640So6 = this.d;
                this.b = 1;
                if (interfaceC4557Fq2.b(c7640So6, this) == objE) {
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

    public /* synthetic */ EJ0(Iterable iterable, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0, int i2, ED1 ed1) {
        this(iterable, (i2 & 2) != 0 ? C18712p72.a : interfaceC11938do1, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? EnumC6162Ml0.SUSPEND : enumC6162Ml0);
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected Object j(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
        C7640So6 c7640So6 = new C7640So6(interfaceC16204ks5);
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            AbstractC10533bm0.d(interfaceC16204ks5, null, null, new a((InterfaceC4557Fq2) it.next(), c7640So6, null), 3, null);
        }
        return C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected AbstractC20003rJ0 l(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        return new EJ0(this.d, interfaceC11938do1, i, enumC6162Ml0);
    }

    @Override // ir.nasim.AbstractC20003rJ0
    public VI5 p(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC13822gs5.d(interfaceC20315ro1, this.a, this.b, n());
    }

    public EJ0(Iterable iterable, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        super(interfaceC11938do1, i, enumC6162Ml0);
        this.d = iterable;
    }
}
