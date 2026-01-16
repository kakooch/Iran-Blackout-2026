package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.payment.data.model.BalanceReceipt;
import ir.nasim.features.payment.data.model.BankCreditCard;

/* renamed from: ir.nasim.vX, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22604vX extends VW7 implements InterfaceC23790xX {
    private final BankingModule b;
    private final SettingsModule c;

    public C22604vX(BankingModule bankingModule, SettingsModule settingsModule) {
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = bankingModule;
        this.c = settingsModule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(BankCreditCard bankCreditCard, Context context, C22604vX c22604vX, C20298rm4 c20298rm4, N60 n60) {
        String string;
        AbstractC13042fc3.i(bankCreditCard, "$creditCard");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(c22604vX, "this$0");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        if (!(n60 instanceof ir.nasim.core.modules.banking.h)) {
            c20298rm4.n(new C5354Iz1((Throwable) new Exception(context.getString(AbstractC12217eE5.card_payment_operation_failed))));
            return;
        }
        ir.nasim.core.modules.banking.h hVar = (ir.nasim.core.modules.banking.h) n60;
        if (!hVar.b()) {
            c20298rm4.n(new C5354Iz1((Throwable) new Exception(hVar.a())));
            return;
        }
        if (bankCreditCard.getId() != null) {
            c22604vX.t0(bankCreditCard);
        }
        String string2 = context.getString(AbstractC12217eE5.card_payment_rial_param, XY6.e(GY6.g(String.valueOf(hVar.d().longValue()))));
        AbstractC13042fc3.h(string2, "getString(...)");
        String string3 = context.getString(AbstractC12217eE5.card_payment_rial_param, XY6.e(GY6.g(String.valueOf(hVar.c()))));
        AbstractC13042fc3.h(string3, "getString(...)");
        if (c22604vX.c.K3() == 0) {
            string = context.getString(AbstractC12217eE5.card_payment_without_wage);
        } else {
            string = GY6.a(String.valueOf(c22604vX.c.K3())) + Separators.SP + context.getString(AbstractC12217eE5.rial);
        }
        String str = string;
        AbstractC13042fc3.f(str);
        String strB = C20481s50.a.b(bankCreditCard.getNumber());
        AbstractC13042fc3.f(strB);
        String strE = XY6.e(strB);
        String string4 = context.getString(AbstractC12217eE5.bank_name_melli);
        AbstractC13042fc3.h(string4, "getString(...)");
        c20298rm4.n(new C5354Iz1(new BalanceReceipt(strE, string4, string2, string3, str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(C20298rm4 c20298rm4, ir.nasim.core.modules.banking.k kVar) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1(kVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    @Override // ir.nasim.InterfaceC23790xX
    public androidx.lifecycle.r U(String str) {
        AbstractC13042fc3.i(str, "cardNumber");
        final C20298rm4 c20298rm4 = new C20298rm4();
        ir.nasim.core.modules.banking.l lVarA = ir.nasim.core.modules.banking.l.a(str);
        AbstractC13042fc3.g(lVarA, "null cannot be cast to non-null type ir.nasim.core.modules.banking.DigitOnlyBankCard");
        ir.nasim.core.modules.banking.m mVarK = ir.nasim.core.modules.banking.m.k(lVarA, "", "", "");
        AbstractC13042fc3.f(mVarK);
        this.b.s2(mVarK, null, EnumC15044iu7.GET_REMAIN, 0L).m0(new InterfaceC24449ye1() { // from class: ir.nasim.rX
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22604vX.W0(c20298rm4, (ir.nasim.core.modules.banking.k) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.sX
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22604vX.X0(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }

    @Override // ir.nasim.InterfaceC23790xX
    public androidx.lifecycle.r b0(final Context context, final BankCreditCard bankCreditCard, String str) {
        AbstractC13042fc3.i(context, "context");
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
        this.b.m1(new ir.nasim.core.modules.banking.n(mVarK, str)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.tX
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22604vX.U0(bankCreditCard, context, this, c20298rm4, (N60) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.uX
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C22604vX.V0(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }
}
