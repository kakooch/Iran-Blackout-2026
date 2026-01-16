package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.core.modules.banking.BankingModule;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class V50 extends AbstractC4177Ea0 {
    private final W50 f;
    private final Z50 g;
    private final BankingModule h;
    private S64 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V50(W50 w50, Z50 z50) {
        super(w50);
        AbstractC13042fc3.i(w50, "mvpView");
        AbstractC13042fc3.i(z50, "bankOperationType");
        this.f = w50;
        this.g = z50;
        this.h = ((InterfaceC9291Zh4) C92.a(C5721Ko.a.d(), InterfaceC9291Zh4.class)).g();
        l();
    }

    private final void l() {
        this.h.W1(this.g).m0(new InterfaceC24449ye1() { // from class: ir.nasim.R50
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                V50.m(this.a, (ir.nasim.core.modules.banking.q) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(V50 v50, ir.nasim.core.modules.banking.q qVar) {
        AbstractC13042fc3.i(v50, "this$0");
        if (qVar.a() instanceof C13375g72) {
            if (qVar.b().isEmpty()) {
                v50.f.w2();
                return;
            } else {
                v50.f.M2();
                return;
            }
        }
        if (qVar.a() instanceof ir.nasim.core.modules.banking.m) {
            W50 w50 = v50.f;
            AbstractC20471s40 abstractC20471s40A = qVar.a();
            AbstractC13042fc3.g(abstractC20471s40A, "null cannot be cast to non-null type ir.nasim.core.modules.banking.DigitOnlyBankCard");
            w50.L4((ir.nasim.core.modules.banking.l) abstractC20471s40A);
            return;
        }
        W50 w502 = v50.f;
        AbstractC20471s40 abstractC20471s40A2 = qVar.a();
        AbstractC13042fc3.g(abstractC20471s40A2, "null cannot be cast to non-null type ir.nasim.core.modules.banking.DigitOnlyBankCard");
        w502.h1((ir.nasim.core.modules.banking.l) abstractC20471s40A2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(V50 v50, ir.nasim.core.modules.banking.q qVar) {
        AbstractC13042fc3.i(v50, "this$0");
        if (qVar.b().isEmpty()) {
            v50.f.w2();
        } else {
            v50.f.M2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(V50 v50, Exception exc) {
        AbstractC13042fc3.i(v50, "this$0");
        v50.f.w2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(V50 v50, ir.nasim.core.modules.banking.q qVar) {
        AbstractC13042fc3.i(v50, "this$0");
        W50 w50 = v50.f;
        List listB = qVar.b();
        AbstractC13042fc3.h(listB, "getSavedCards(...)");
        w50.e2(listB);
    }

    protected final S64 j() {
        return this.i;
    }

    public final void k(AbstractC20471s40 abstractC20471s40) {
        AbstractC13042fc3.i(abstractC20471s40, ParameterNames.CARD);
        if (abstractC20471s40 instanceof ir.nasim.core.modules.banking.m) {
            this.f.L4((ir.nasim.core.modules.banking.l) abstractC20471s40);
        } else {
            this.f.h1((ir.nasim.core.modules.banking.l) abstractC20471s40);
        }
    }

    public final void n() {
        this.h.W1(this.g).m0(new InterfaceC24449ye1() { // from class: ir.nasim.T50
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                V50.o(this.a, (ir.nasim.core.modules.banking.q) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.U50
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                V50.p(this.a, (Exception) obj);
            }
        });
    }

    public abstract void q(ir.nasim.core.modules.banking.m mVar, String str, String str2);

    public final void r() {
        this.h.W1(this.g).m0(new InterfaceC24449ye1() { // from class: ir.nasim.S50
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                V50.s(this.a, (ir.nasim.core.modules.banking.q) obj);
            }
        });
    }

    public final void t(S64 s64) {
        AbstractC13042fc3.i(s64, "_messageIdentifier");
        this.i = s64;
    }
}
