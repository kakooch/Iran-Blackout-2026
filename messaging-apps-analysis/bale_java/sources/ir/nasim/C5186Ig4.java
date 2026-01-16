package ir.nasim;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.PowerManager;
import android.os.Vibrator;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.settings.SettingsModule;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.Ig4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5186Ig4 {
    public static final C5186Ig4 a = new C5186Ig4();

    private C5186Ig4() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final R74 p(Context context, InterfaceC11621dJ7 interfaceC11621dJ7) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(interfaceC11621dJ7, "$userRepository");
        return new R74(context, interfaceC11621dJ7);
    }

    public final C17453mz5 A() {
        C17453mz5 c17453mz5P = AbstractC5969Lp4.e().P();
        AbstractC13042fc3.h(c17453mz5P, "getPushesModule(...)");
        return c17453mz5P;
    }

    public final C4471Fg6 B() {
        C4471Fg6 c4471Fg6Q = AbstractC5969Lp4.e().Q();
        AbstractC13042fc3.h(c4471Fg6Q, "getSearchModule(...)");
        return c4471Fg6Q;
    }

    public final SensorManager C(Context context) {
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("sensor");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        return (SensorManager) systemService;
    }

    public final SettingsModule D() {
        SettingsModule settingsModuleS = AbstractC5969Lp4.e().S();
        AbstractC13042fc3.h(settingsModuleS, "getSettingsModule(...)");
        return settingsModuleS;
    }

    public final InterfaceC3570Bk5 E() {
        InterfaceC3570Bk5 interfaceC3570Bk5S = C7183Qq.s();
        AbstractC13042fc3.h(interfaceC3570Bk5S, "getSharedInstance(...)");
        return interfaceC3570Bk5S;
    }

    public final MO6 F() {
        MO6 mo6T = AbstractC5969Lp4.e().T();
        AbstractC13042fc3.h(mo6T, "getStorageModule(...)");
        return mo6T;
    }

    public final C4892Gz7 G() {
        C4892Gz7 c4892Gz7U = AbstractC5969Lp4.e().U();
        AbstractC13042fc3.h(c4892Gz7U, "getTypingModule(...)");
        return c4892Gz7U;
    }

    public final UG7 H() {
        UG7 ug7V = AbstractC5969Lp4.e().V();
        AbstractC13042fc3.h(ug7V, "getUpdatesModule(...)");
        return ug7V;
    }

    public final OK7 I() {
        OK7 ok7W = AbstractC5969Lp4.e().W();
        AbstractC13042fc3.h(ok7W, "getUsersModule(...)");
        return ok7W;
    }

    public final Vibrator J(Context context, int i) {
        AbstractC13042fc3.i(context, "context");
        if (i > 31) {
            Vibrator defaultVibrator = AbstractC4235Eg4.a(context.getSystemService(AbstractC4001Dg4.a())).getDefaultVibrator();
            AbstractC13042fc3.f(defaultVibrator);
            return defaultVibrator;
        }
        Object systemService = context.getSystemService("vibrator");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        return (Vibrator) systemService;
    }

    public final A08 K() {
        A08 a08X = AbstractC5969Lp4.e().X();
        AbstractC13042fc3.h(a08X, "getVoiceCallModule(...)");
        return a08X;
    }

    public final C11461d28 L() {
        C11461d28 c11461d28Y = AbstractC5969Lp4.e().Y();
        AbstractC13042fc3.h(c11461d28Y, "getWalletsModule(...)");
        return c11461d28Y;
    }

    public final C23572x88 M() {
        C23572x88 c23572x88Z = AbstractC5969Lp4.e().Z();
        AbstractC13042fc3.h(c23572x88Z, "getWebViewModule(...)");
        return c23572x88Z;
    }

    public final InterfaceC16501lO N() {
        return C23709xO.a;
    }

    public final C6559Oa2 O() {
        C6559Oa2 c6559Oa2L2 = C5735Kp4.w().i().l2();
        AbstractC13042fc3.h(c6559Oa2L2, "getEvents(...)");
        return c6559Oa2L2;
    }

    public final C9057Yh4 P() {
        C9057Yh4 c9057Yh4E = AbstractC5969Lp4.e();
        AbstractC13042fc3.h(c9057Yh4E, "modules(...)");
        return c9057Yh4E;
    }

    public final C14934ij6 Q() {
        C14934ij6 c14934ij6R = AbstractC5969Lp4.e().R();
        AbstractC13042fc3.h(c14934ij6R, "getSecurityModule(...)");
        return c14934ij6R;
    }

    public final InterfaceC15524jj6 R(C14934ij6 c14934ij6) {
        AbstractC13042fc3.i(c14934ij6, "securityModule");
        return c14934ij6;
    }

    public final AlarmManager b(Context context) {
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("alarm");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        return (AlarmManager) systemService;
    }

    public final C6287Mz c() {
        C6287Mz c6287MzS = AbstractC5969Lp4.e().s();
        AbstractC13042fc3.h(c6287MzS, "getApiModule(...)");
        return c6287MzS;
    }

    public final PE d() {
        PE peV = AbstractC5969Lp4.e().v();
        AbstractC13042fc3.h(peV, "getAppStateModule(...)");
        return peV;
    }

    public final AudioManager e(Context context) {
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) systemService;
    }

    public final C15346jR f() {
        C15346jR c15346jRW = AbstractC5969Lp4.e().w();
        AbstractC13042fc3.h(c15346jRW, "getAuthModule(...)");
        return c15346jRW;
    }

    public final BankingModule g() {
        BankingModule bankingModuleY = AbstractC5969Lp4.e().y();
        AbstractC13042fc3.h(bankingModuleY, "getBanking(...)");
        return bankingModuleY;
    }

    public final ConnectivityManager h(Context context) {
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("connectivity");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) systemService;
    }

    public final C8054Ui1 i() {
        C8054Ui1 c8054Ui1A = AbstractC5969Lp4.e().A();
        AbstractC13042fc3.h(c8054Ui1A, "getContactsModule(...)");
        return c8054Ui1A;
    }

    public final BV1 j() {
        BV1 bv1C = AbstractC5969Lp4.e().C();
        AbstractC13042fc3.h(bv1C, "getDisplayListsModule(...)");
        return bv1C;
    }

    public final C14970in2 k() {
        C14970in2 c14970in2D = AbstractC5969Lp4.e().D();
        AbstractC13042fc3.h(c14970in2D, "getFilesModule(...)");
        return c14970in2D;
    }

    public final C10299bQ2 l() {
        C10299bQ2 c10299bQ2E = AbstractC5969Lp4.e().E();
        AbstractC13042fc3.h(c10299bQ2E, "getGroupsModule(...)");
        return c10299bQ2E;
    }

    public final InterfaceC21014sz3 m() {
        InterfaceC21014sz3 interfaceC21014sz3 = AbstractC20507s76.d;
        AbstractC13042fc3.h(interfaceC21014sz3, "lifecycleRuntime");
        return interfaceC21014sz3;
    }

    public final QQ3 n() {
        QQ3 qq3F = AbstractC5969Lp4.e().F();
        AbstractC13042fc3.h(qq3F, "getMarketModule(...)");
        return qq3F;
    }

    public final InterfaceC7486Rx5 o(final Context context, final InterfaceC11621dJ7 interfaceC11621dJ7) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        return new InterfaceC7486Rx5() { // from class: ir.nasim.Gg4
            @Override // ir.nasim.InterfaceC7720Sx5
            public final Object get() {
                return C5186Ig4.p(context, interfaceC11621dJ7);
            }
        };
    }

    public final E84 q() {
        E84 e84G = AbstractC5969Lp4.e().G();
        AbstractC13042fc3.h(e84G, "getMessagesModule(...)");
        return e84G;
    }

    public final C11941do4 r() {
        C11941do4 c11941do4J = AbstractC5969Lp4.e().J();
        AbstractC13042fc3.h(c11941do4J, "getMxpModule(...)");
        return c11941do4J;
    }

    public final int s() {
        return AbstractC5969Lp4.f();
    }

    public final NotificationManager t(Context context) {
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    public final VE4 u() {
        VE4 ve4K = AbstractC5969Lp4.e().K();
        AbstractC13042fc3.h(ve4K, "getNotificationsModule(...)");
        return ve4K;
    }

    public final UP4 v() {
        UP4 up4L = AbstractC5969Lp4.e().L();
        AbstractC13042fc3.h(up4L, "getPFMModule(...)");
        return up4L;
    }

    public final PowerManager w(Context context) {
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("power");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return (PowerManager) systemService;
    }

    public final InterfaceC3570Bk5 x() {
        InterfaceC3570Bk5 interfaceC3570Bk5O = KN6.o();
        AbstractC13042fc3.h(interfaceC3570Bk5O, "createPreferencesStorage(...)");
        return interfaceC3570Bk5O;
    }

    public final C14375ho5 y() {
        C14375ho5 c14375ho5N = AbstractC5969Lp4.e().N();
        AbstractC13042fc3.h(c14375ho5N, "getPresenceModule(...)");
        return c14375ho5N;
    }

    public final C6508Nu5 z() {
        C6508Nu5 c6508Nu5O = AbstractC5969Lp4.e().O();
        AbstractC13042fc3.h(c6508Nu5O, "getProfileModule(...)");
        return c6508Nu5O;
    }
}
