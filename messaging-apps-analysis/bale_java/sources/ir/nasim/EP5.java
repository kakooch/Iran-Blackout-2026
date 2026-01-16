package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeer;

/* loaded from: classes5.dex */
public final class EP5 {
    private final AbstractC13778go1 a;
    private final FP5 b;
    private final InterfaceC20315ro1 c;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ExPeer d;
        final /* synthetic */ String e;
        final /* synthetic */ OP5 f;
        final /* synthetic */ P25 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ExPeer exPeer, String str, OP5 op5, P25 p25, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = exPeer;
            this.e = str;
            this.f = op5;
            this.g = p25;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return EP5.this.new a(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                FP5 fp5 = EP5.this.b;
                ExPeer exPeer = this.d;
                String str = this.e;
                OP5 op5 = this.f;
                P25 p25 = this.g;
                this.b = 1;
                if (fp5.b(exPeer, str, op5, p25, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public EP5(AbstractC13778go1 abstractC13778go1, FP5 fp5, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(fp5, "reportRepository");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.a = abstractC13778go1;
        this.b = fp5;
        this.c = interfaceC20315ro1;
    }

    public final void b(ExPeer exPeer, String str, OP5 op5, P25 p25) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, "description");
        AbstractC13042fc3.i(op5, "reportType");
        AbstractC13042fc3.i(p25, "peerSource");
        AbstractC10533bm0.d(this.c, this.a, null, new a(exPeer, str, op5, p25, null), 2, null);
    }
}
