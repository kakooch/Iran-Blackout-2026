package ir.nasim;

import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.features.payment.data.response.Bank;
import ir.nasim.features.payment.data.response.CardToCardConfig;
import java.util.List;

/* renamed from: ir.nasim.c8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10748c8 extends VW7 implements Z7 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final BankingModule b;

    /* renamed from: ir.nasim.c8$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C10748c8(BankingModule bankingModule) {
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        this.b = bankingModule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(C20298rm4 c20298rm4, List list) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
        C19406qI3.d("AddCardViewModelImpl", exc);
    }

    @Override // ir.nasim.Z7
    public androidx.lifecycle.r e0(String str) {
        AbstractC13042fc3.i(str, "cardNumber");
        final C20298rm4 c20298rm4 = new C20298rm4();
        ir.nasim.core.modules.banking.l lVarA = ir.nasim.core.modules.banking.l.a(str);
        if (lVarA != null) {
            this.b.Q0(lVarA).m0(new InterfaceC24449ye1() { // from class: ir.nasim.a8
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C10748c8.S0(c20298rm4, (List) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.b8
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C10748c8.T0(c20298rm4, (Exception) obj);
                }
            });
        }
        return c20298rm4;
    }

    @Override // ir.nasim.Z7
    public androidx.lifecycle.r getConfig() {
        C20298rm4 c20298rm4 = new C20298rm4();
        CardToCardConfig cardToCardConfig = (CardToCardConfig) new KS2().k(AbstractC5969Lp4.d().o2().S().b1().toString(), CardToCardConfig.class);
        for (Bank bank : cardToCardConfig.getBankList()) {
            Integer numE = C20481s50.a.e(bank.getCardNumberPattern());
            if (numE != null) {
                bank.setDrawableId(numE);
            }
        }
        c20298rm4.n(cardToCardConfig);
        return c20298rm4;
    }
}
