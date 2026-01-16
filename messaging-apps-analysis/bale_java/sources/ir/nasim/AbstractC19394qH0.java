package ir.nasim;

import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;

/* renamed from: ir.nasim.qH0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC19394qH0 {
    public static void a(CardPaymentActivity cardPaymentActivity, BankingModule bankingModule) {
        cardPaymentActivity.bankingModule = bankingModule;
    }

    public static void b(CardPaymentActivity cardPaymentActivity, InterfaceC11677dQ0 interfaceC11677dQ0) {
        cardPaymentActivity.chatNavigator = interfaceC11677dQ0;
    }

    public static void c(CardPaymentActivity cardPaymentActivity, C18902pS0 c18902pS0) {
        cardPaymentActivity.checkMigrateCardsUseCase = c18902pS0;
    }

    public static void d(CardPaymentActivity cardPaymentActivity, C8054Ui1 c8054Ui1) {
        cardPaymentActivity.contactModule = c8054Ui1;
    }

    public static void e(CardPaymentActivity cardPaymentActivity, SettingsModule settingsModule) {
        cardPaymentActivity.settingsModule = settingsModule;
    }

    public static void f(CardPaymentActivity cardPaymentActivity, C23572x88 c23572x88) {
        cardPaymentActivity.webViewModule = c23572x88;
    }
}
