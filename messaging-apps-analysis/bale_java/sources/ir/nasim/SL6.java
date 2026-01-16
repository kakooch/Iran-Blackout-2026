package ir.nasim;

import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.model.StatementItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final class SL6 extends VW7 implements InterfaceC24754z90 {
    private final BankingModule b;

    public SL6(BankingModule bankingModule) {
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        this.b = bankingModule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(BankCreditCard bankCreditCard, C20298rm4 c20298rm4, SL6 sl6, N60 n60) {
        AbstractC13042fc3.i(bankCreditCard, "$creditCard");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        AbstractC13042fc3.i(sl6, "this$0");
        AbstractC13042fc3.g(n60, "null cannot be cast to non-null type ir.nasim.core.modules.banking.CardStatementResponse");
        ir.nasim.core.modules.banking.i iVar = (ir.nasim.core.modules.banking.i) n60;
        if (!iVar.b()) {
            c20298rm4.n(new C5354Iz1((Throwable) new Exception(iVar.a())));
            return;
        }
        if (bankCreditCard.getId() != null) {
            sl6.t0(bankCreditCard);
        }
        ArrayList arrayList = new ArrayList();
        List<C19014pe0> listC = iVar.c();
        AbstractC13042fc3.h(listC, "getBillInfos(...)");
        for (C19014pe0 c19014pe0 : listC) {
            arrayList.add(new StatementItem(AbstractC13042fc3.d(c19014pe0.d(), "+"), c19014pe0.b(), c19014pe0.a(), c19014pe0.c()));
        }
        c20298rm4.n(new C5354Iz1(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(C20298rm4 c20298rm4, ir.nasim.core.modules.banking.k kVar) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1(kVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    public androidx.lifecycle.r U(String str) {
        AbstractC13042fc3.i(str, "cardNumber");
        final C20298rm4 c20298rm4 = new C20298rm4();
        ir.nasim.core.modules.banking.l lVarA = ir.nasim.core.modules.banking.l.a(str);
        AbstractC13042fc3.g(lVarA, "null cannot be cast to non-null type ir.nasim.core.modules.banking.DigitOnlyBankCard");
        ir.nasim.core.modules.banking.m mVarK = ir.nasim.core.modules.banking.m.k(lVarA, "", "", "");
        AbstractC13042fc3.f(mVarK);
        this.b.s2(mVarK, null, EnumC15044iu7.GET_STATEMENT, 0L).m0(new InterfaceC24449ye1() { // from class: ir.nasim.OL6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                SL6.X0(c20298rm4, (ir.nasim.core.modules.banking.k) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.PL6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                SL6.Y0(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }

    public androidx.lifecycle.r U0(final BankCreditCard bankCreditCard, String str) {
        AbstractC13042fc3.i(bankCreditCard, "creditCard");
        AbstractC13042fc3.i(str, "pin2");
        final C20298rm4 c20298rm4 = new C20298rm4();
        ir.nasim.core.modules.banking.l lVarA = ir.nasim.core.modules.banking.l.a(bankCreditCard.getNumber());
        AbstractC13042fc3.g(lVarA, "null cannot be cast to non-null type ir.nasim.core.modules.banking.DigitOnlyBankCard");
        String cvv2 = bankCreditCard.getCvv2();
        AbstractC13042fc3.f(cvv2);
        String realExpirationYear = bankCreditCard.getRealExpirationYear();
        AbstractC13042fc3.f(realExpirationYear);
        String realExpirationMonth = bankCreditCard.getRealExpirationMonth();
        AbstractC13042fc3.f(realExpirationMonth);
        ir.nasim.core.modules.banking.m mVarK = ir.nasim.core.modules.banking.m.k(lVarA, cvv2, realExpirationYear, realExpirationMonth);
        AbstractC13042fc3.f(mVarK);
        this.b.m1(new ir.nasim.core.modules.banking.o(mVarK, str)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.QL6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                SL6.V0(bankCreditCard, c20298rm4, this, (N60) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.RL6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                SL6.W0(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }
}
