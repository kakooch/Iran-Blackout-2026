package ir.nasim;

import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.root.RootActivity;

/* renamed from: ir.nasim.g36, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC13339g36 {
    public static void a(RootActivity rootActivity, LQ lq) {
        rootActivity.authRepository = lq;
    }

    public static void b(RootActivity rootActivity, InterfaceC23146wR interfaceC23146wR) {
        rootActivity.authenticatorNavigator = interfaceC23146wR;
    }

    public static void c(RootActivity rootActivity, BankingModule bankingModule) {
        rootActivity.bankingModule = bankingModule;
    }

    public static void d(RootActivity rootActivity, InterfaceC23238wb0 interfaceC23238wb0) {
        rootActivity.baseSettingsNavigator = interfaceC23238wb0;
    }

    public static void e(RootActivity rootActivity, InterfaceC13737gk0 interfaceC13737gk0) {
        rootActivity.bottomSheetNavigatorImp = interfaceC13737gk0;
    }

    public static void f(RootActivity rootActivity, InterfaceC11677dQ0 interfaceC11677dQ0) {
        rootActivity.chatNavigator = interfaceC11677dQ0;
    }

    public static void g(RootActivity rootActivity, InterfaceC19567qa2 interfaceC19567qa2) {
        rootActivity.eventAnalytics = interfaceC19567qa2;
    }

    public static void h(RootActivity rootActivity, ZF2 zf2) {
        rootActivity.getInAppMessageUseCase = zf2;
    }

    public static void i(RootActivity rootActivity, InterfaceC7565Sg3 interfaceC7565Sg3) {
        rootActivity.jaryanNavigator = interfaceC7565Sg3;
    }

    public static void j(RootActivity rootActivity, DK4 dk4) {
        rootActivity.onboardingNavigator = dk4;
    }

    public static void k(RootActivity rootActivity, InterfaceC15690k05 interfaceC15690k05) {
        rootActivity.passportsNavigator = interfaceC15690k05;
    }

    public static void l(RootActivity rootActivity, InterfaceC3570Bk5 interfaceC3570Bk5) {
        rootActivity.preferences = interfaceC3570Bk5;
    }

    public static void m(RootActivity rootActivity, InterfaceC8898Xu3 interfaceC8898Xu3) {
        rootActivity.rootBeer = interfaceC8898Xu3;
    }

    public static void n(RootActivity rootActivity, SettingsModule settingsModule) {
        rootActivity.settingsModule = settingsModule;
    }

    public static void o(RootActivity rootActivity, InterfaceC16935m68 interfaceC16935m68) {
        rootActivity.webAppNavigator = interfaceC16935m68;
    }
}
