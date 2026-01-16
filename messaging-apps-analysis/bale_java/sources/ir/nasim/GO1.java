package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC24274yL1;
import ir.nasim.InterfaceC13521gN1;
import ir.nasim.InterfaceC20625sK4;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class GO1 {
    private final C23094wL1 a;
    private final C9695aP1 b;
    private final InterfaceC20315ro1 c;
    private final InterfaceC9336Zm4 d;
    private final InterfaceC10258bL6 e;
    private final InterfaceC10258bL6 f;

    public interface a {

        /* renamed from: ir.nasim.GO1$a$a, reason: collision with other inner class name */
        public static final class C0389a implements a {
            public static final int b = AbstractC23684xL1.a;
            private final AbstractC23684xL1 a;

            public C0389a(AbstractC23684xL1 abstractC23684xL1) {
                AbstractC13042fc3.i(abstractC23684xL1, "adUiAction");
                this.a = abstractC23684xL1;
            }

            public final AbstractC23684xL1 a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0389a) && AbstractC13042fc3.d(this.a, ((C0389a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "AdvertisementAction(adUiAction=" + this.a + Separators.RPAREN;
            }
        }

        public static final class b implements a {
            private final InterfaceC18834pK4 a;

            public b(InterfaceC18834pK4 interfaceC18834pK4) {
                AbstractC13042fc3.i(interfaceC18834pK4, "bannerAction");
                this.a = interfaceC18834pK4;
            }

            public final InterfaceC18834pK4 a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "OnboardingBannerAction(bannerAction=" + this.a + Separators.RPAREN;
            }
        }
    }

    public static final class b {
        private final AbstractC24274yL1 a;
        private final InterfaceC20625sK4 b;

        public b(AbstractC24274yL1 abstractC24274yL1, InterfaceC20625sK4 interfaceC20625sK4) {
            AbstractC13042fc3.i(abstractC24274yL1, "dialogAdUiState");
            AbstractC13042fc3.i(interfaceC20625sK4, "onboardingBannerUiState");
            this.a = abstractC24274yL1;
            this.b = interfaceC20625sK4;
        }

        private final boolean f(int i) {
            return AbstractC4597Fu6.i(0, 3).contains(Integer.valueOf(i));
        }

        private final boolean g(int i) {
            return AbstractC4363Eu6.c(0).contains(Integer.valueOf(i));
        }

        public final AbstractC24274yL1 a() {
            return this.a;
        }

        public final InterfaceC20625sK4 b() {
            return this.b;
        }

        public final boolean c(InterfaceC13521gN1 interfaceC13521gN1) {
            AbstractC13042fc3.i(interfaceC13521gN1, "tab");
            if (!(interfaceC13521gN1 instanceof InterfaceC13521gN1.b)) {
                return false;
            }
            AbstractC24274yL1 abstractC24274yL1 = this.a;
            if ((abstractC24274yL1 instanceof AbstractC24274yL1.b ? (AbstractC24274yL1.b) abstractC24274yL1 : null) != null) {
                return !h(interfaceC13521gN1);
            }
            return false;
        }

        public final boolean d(InterfaceC13521gN1 interfaceC13521gN1) {
            AbstractC13042fc3.i(interfaceC13521gN1, "tab");
            return c(interfaceC13521gN1) && (this.a instanceof AbstractC24274yL1.b.a);
        }

        public final boolean e(InterfaceC13521gN1 interfaceC13521gN1) {
            AbstractC13042fc3.i(interfaceC13521gN1, "tab");
            return c(interfaceC13521gN1) && (this.a instanceof AbstractC24274yL1.b.C1786b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public final boolean h(InterfaceC13521gN1 interfaceC13521gN1) {
            AbstractC13042fc3.i(interfaceC13521gN1, "tab");
            if (!(interfaceC13521gN1 instanceof InterfaceC13521gN1.b)) {
                return false;
            }
            InterfaceC20625sK4 interfaceC20625sK4 = this.b;
            if ((interfaceC20625sK4 instanceof InterfaceC20625sK4.b ? (InterfaceC20625sK4.b) interfaceC20625sK4 : null) != null) {
                return ((InterfaceC20625sK4.b) interfaceC20625sK4).e() == 5 ? g(((InterfaceC13521gN1.b) interfaceC13521gN1).e()) : f(((InterfaceC13521gN1.b) interfaceC13521gN1).e());
            }
            return false;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "DialogListTopSpotUiState(dialogAdUiState=" + this.a + ", onboardingBannerUiState=" + this.b + Separators.RPAREN;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return new b((AbstractC24274yL1) this.c, (InterfaceC20625sK4) this.d);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(AbstractC24274yL1 abstractC24274yL1, InterfaceC20625sK4 interfaceC20625sK4, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(interfaceC20295rm1);
            cVar.c = abstractC24274yL1;
            cVar.d = interfaceC20625sK4;
            return cVar.invokeSuspend(C19938rB7.a);
        }
    }

    public GO1(C23094wL1 c23094wL1, C9695aP1 c9695aP1, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(c23094wL1, "dialogAdStateManager");
        AbstractC13042fc3.i(c9695aP1, "dialogOnboardingBannerStateManager");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        this.a = c23094wL1;
        this.b = c9695aP1;
        this.c = interfaceC20315ro1;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.d = interfaceC9336Zm4A;
        this.e = interfaceC9336Zm4A;
        this.f = AbstractC6459Nq2.o0(AbstractC6459Nq2.p(c23094wL1.o(), c9695aP1.l(), new c(null)), interfaceC20315ro1, InterfaceC16863lz6.a.d(), new b(AbstractC24274yL1.a.a, InterfaceC20625sK4.a.a));
    }

    public final InterfaceC10258bL6 a() {
        return this.e;
    }

    public final InterfaceC10258bL6 b() {
        return this.f;
    }

    public final void c(a aVar) {
        AbstractC13042fc3.i(aVar, "topSpotUiAction");
        if (aVar instanceof a.C0389a) {
            this.a.t(((a.C0389a) aVar).a());
        } else {
            if (!(aVar instanceof a.b)) {
                throw new NoWhenBranchMatchedException();
            }
            this.b.q(((a.b) aVar).a());
        }
    }

    public final void d(List list) {
        AbstractC13042fc3.i(list, "names");
        this.d.setValue(list);
    }
}
