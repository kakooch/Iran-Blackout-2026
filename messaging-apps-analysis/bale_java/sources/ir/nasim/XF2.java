package ir.nasim;

/* loaded from: classes5.dex */
public final class XF2 {
    private final InterfaceC20667sP1 a;
    private final AbstractC13778go1 b;
    private final InterfaceC20315ro1 c;

    public interface a {
        void a(Throwable th);
    }

    public interface b {
        void a(int i);
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ int c;
        final /* synthetic */ b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, interfaceC20295rm1);
            cVar.c = ((Number) obj).intValue();
            return cVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return n(((Number) obj).intValue(), (InterfaceC20295rm1) obj2);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.d.a(this.c);
            return C19938rB7.a;
        }

        public final Object n(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(Integer.valueOf(i), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Throwable th = (Throwable) this.c;
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(th);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.d, interfaceC20295rm1);
            dVar.c = th;
            return dVar.invokeSuspend(C19938rB7.a);
        }
    }

    public XF2(InterfaceC20667sP1 interfaceC20667sP1, AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC20667sP1, "repository");
        AbstractC13042fc3.i(abstractC13778go1, "io");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.a = interfaceC20667sP1;
        this.b = abstractC13778go1;
        this.c = interfaceC20315ro1;
    }

    public final void a(b bVar, a aVar) {
        AbstractC13042fc3.i(bVar, "listener");
        AbstractC6459Nq2.W(AbstractC6459Nq2.h(AbstractC6459Nq2.b0(AbstractC6459Nq2.V(AbstractC6459Nq2.q(AbstractC6459Nq2.v(this.a.F())), this.b), new c(bVar, null)), new d(aVar, null)), this.c);
    }
}
