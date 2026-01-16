package ir.nasim;

import ir.nasim.AbstractC24274yL1;
import ir.nasim.IO1;
import ir.nasim.InterfaceC20625sK4;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class HO1 {
    private final C23094wL1 a;
    private final C9695aP1 b;
    private final InterfaceC20315ro1 c;
    private final InterfaceC10258bL6 d;

    static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return new JO1((AbstractC24274yL1) this.c, (InterfaceC20625sK4) this.d);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(AbstractC24274yL1 abstractC24274yL1, InterfaceC20625sK4 interfaceC20625sK4, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(interfaceC20295rm1);
            aVar.c = abstractC24274yL1;
            aVar.d = interfaceC20625sK4;
            return aVar.invokeSuspend(C19938rB7.a);
        }
    }

    public HO1(C23094wL1 c23094wL1, C9695aP1 c9695aP1, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(c23094wL1, "dialogAdStateManager");
        AbstractC13042fc3.i(c9695aP1, "dialogOnboardingBannerStateManager");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        this.a = c23094wL1;
        this.b = c9695aP1;
        this.c = interfaceC20315ro1;
        this.d = AbstractC6459Nq2.o0(AbstractC6459Nq2.p(c23094wL1.o(), c9695aP1.l(), new a(null)), interfaceC20315ro1, InterfaceC16863lz6.a.d(), new JO1(AbstractC24274yL1.a.a, InterfaceC20625sK4.a.a));
    }

    public final InterfaceC10258bL6 a() {
        return this.d;
    }

    public final void b(IO1 io1) {
        AbstractC13042fc3.i(io1, "topSpotUiAction");
        if (io1 instanceof IO1.a) {
            this.a.t(((IO1.a) io1).a());
        } else {
            if (!(io1 instanceof IO1.b)) {
                throw new NoWhenBranchMatchedException();
            }
            this.b.q(((IO1.b) io1).a());
        }
    }
}
