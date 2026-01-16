package ir.nasim;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import ir.nasim.features.root.AbstractC13089g;
import ir.nasim.features.root.RootActivity;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/* renamed from: ir.nasim.Kp4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5735Kp4 {
    public static volatile C5735Kp4 q = new C5735Kp4();
    public C6202Mp4 a;
    private volatile boolean b;
    private AbstractC13089g d;
    private int e;
    private C11458d25 f;
    private volatile C11335cq g;
    private String[] h;
    private String[] i;
    private ProgressDialog p;
    private final Object c = new Object();
    private final int j = 1;
    private final String k = "ade83ab67038e6a1266d386cc761b40478ad03b73b13b30cdabc7d74538191e2940fde9464";
    private String l = "Bale";
    private long m = 0;
    private final String n = "https://faq.bale.ai";
    private C4164Dy5 o = null;

    /* renamed from: ir.nasim.Kp4$a */
    class a implements InterfaceC15419jZ0 {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ C11458d25 c;

        a(Context context, String str, C11458d25 c11458d25) {
            this.a = context;
            this.b = str;
            this.c = c11458d25;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(C4382Ew7 c4382Ew7, Context context, String str, C11458d25 c11458d25) {
            C8920Xu5.c();
            if (((C21231tK7[]) c4382Ew7.a()).length == 0 && ((C14733iO2[]) c4382Ew7.b()).length == 0) {
                Toast.makeText(context, AbstractC12217eE5.toast_chat_not_found, 0).show();
                return;
            }
            if (((C14733iO2[]) c4382Ew7.b()).length <= 0) {
                if (((C21231tK7[]) c4382Ew7.a()).length > 0) {
                    C21231tK7 c21231tK7 = ((C21231tK7[]) c4382Ew7.a())[0];
                    if (c21231tK7.y()) {
                        C18987pb3.a.r1(C11458d25.E(c21231tK7.o()));
                        return;
                    } else {
                        C5735Kp4.this.x(c21231tK7.o());
                        return;
                    }
                }
                return;
            }
            C14733iO2 c14733iO2 = ((C14733iO2[]) c4382Ew7.b())[0];
            if (c14733iO2.q().equals(ZN2.CHANNEL) || c14733iO2.E().i(W06.PUBLIC)) {
                C11458d25 c11458d25Y = C11458d25.y(c14733iO2.r());
                if (!((Boolean) c14733iO2.F().b()).booleanValue()) {
                    C5735Kp4.this.o(c11458d25Y);
                }
                C18987pb3.z1(c11458d25Y, null, null, false, str, c11458d25, Boolean.FALSE);
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(final C4382Ew7 c4382Ew7) {
            final Context context = this.a;
            final String str = this.b;
            final C11458d25 c11458d25 = this.c;
            AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.Jp4
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(c4382Ew7, context, str, c11458d25);
                }
            });
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            if (C8920Xu5.c()) {
                C19406qI3.c("NasimSDK", "startShowPeer", exc);
            }
        }
    }

    private C5735Kp4() {
        PH3.h(C5721Ko.b);
        this.h = new String[0];
        this.i = new String[0];
        this.a = new C6202Mp4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        AbstractC20507s76.l();
        Context context = C5721Ko.b;
        C12736f7.n().i("D_voice_capture", 1);
        d(context);
        this.g.S2();
        synchronized (this.c) {
            this.b = true;
            C19406qI3.a("SyncLog", "load_lock_notify_all_waited_threads", new Object[0]);
            this.c.notifyAll();
        }
        l(context);
    }

    private void d(Context context) {
        C9009Yc1 c9009Yc1 = new C9009Yc1();
        for (String str : this.h) {
            c9009Yc1.a(str);
        }
        for (String str2 : this.i) {
            c9009Yc1.c(str2);
        }
        c9009Yc1.f(new TJ1(context.getContentResolver()));
        c9009Yc1.e(new C13274fx(1, "ade83ab67038e6a1266d386cc761b40478ad03b73b13b30cdabc7d74538191e2940fde9464", AK1.b(), C5721Ko.b.getPackageName() + ":" + g()));
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            country = locale.getLanguage().equals("en") ? "US" : "IR";
        }
        c9009Yc1.b(locale.getLanguage() + "-" + country);
        c9009Yc1.b(locale.getLanguage());
        c9009Yc1.g(TimeZone.getDefault().getID());
        this.g = new C11335cq(context, c9009Yc1.d());
    }

    private void e(Context context) {
        if (!AbstractC21784u76.b() && AbstractC19662qj7.a(context)) {
            Toast.makeText(context, AbstractC12217eE5.error_tamper, 1).show();
            AbstractC20507s76.D(new Runnable() { // from class: ir.nasim.Gp4
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC20507s76.y();
                }
            }, 3000L);
            AbstractC20507s76.D(new Runnable() { // from class: ir.nasim.Hp4
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC20507s76.v();
                }
            }, 6000L);
        }
    }

    private String g() {
        String strE = C7183Qq.s().e("build_serial");
        if (strE == null) {
            strE = CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE;
        }
        if (strE.equals(CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE)) {
            strE = Build.SERIAL;
            if (strE.equals(CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE)) {
                strE = UUID.randomUUID().toString();
            }
            C7183Qq.s().putString("build_serial", strE);
        }
        return strE;
    }

    private void l(Context context) {
        C6164Ml2.n();
        if (AbstractC21784u76.d()) {
            C17213mb2.a(true);
        }
        this.g.T2();
        F();
        e(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(int i, C17637nI7 c17637nI7) {
        if (c17637nI7 != null) {
            x(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n() {
        C7183Qq.p().k();
    }

    public static C5735Kp4 w() {
        return q;
    }

    private void z(Context context, Bundle bundle, Class cls) {
        Intent intent = new Intent(context, (Class<?>) cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    public void A(Context context) {
        B(context, null);
    }

    public void B(Context context, Bundle bundle) {
        context.startActivity(KP.INSTANCE.a().g(context, bundle));
    }

    public synchronized void C(InterfaceC5620Kc6 interfaceC5620Kc6) {
        if (this.g != null) {
            return;
        }
        AbstractC7407Ro7.c(new C4082Dp4());
        C9248Zc6 c9248Zc6G = new C9248Zc6(new C5152Ic6(new Runnable() { // from class: ir.nasim.Ep4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.E();
            }
        })).g(interfaceC5620Kc6);
        EnumC11723dV1 enumC11723dV1 = EnumC11723dV1.IO;
        SZ.e(c9248Zc6G.h(enumC11723dV1));
        SZ.e(new C9248Zc6(new C5152Ic6(new Runnable() { // from class: ir.nasim.Fp4
            @Override // java.lang.Runnable
            public final void run() {
                C5735Kp4.n();
            }
        })).h(enumC11723dV1));
    }

    public void D() {
        C19406qI3.a("NasimSDK", "startCoreAndAwait started!", new Object[0]);
        L();
        if (this.g == null) {
            C(null);
            L();
        }
        C19406qI3.a("NasimSDK", "startCoreAndAwait ended!", new Object[0]);
    }

    public void F() {
        try {
            if (!this.g.z0() || this.m == 0) {
                return;
            }
            if (this.o == null) {
                this.o = new C4164Dy5();
            }
            this.o.g(C5721Ko.b);
        } catch (Exception e) {
            C19406qI3.d("NasimSDK", e);
        }
    }

    public void G(Context context) {
        H(context, null);
    }

    public void H(Context context, Bundle bundle) {
        z(context, bundle, RootActivity.class);
    }

    public void I(Activity activity) {
        if (this.g.g1()) {
            G(activity);
        } else {
            A(activity);
        }
    }

    public void J(Context context, String str, String str2) {
        K(context, str, str2, null);
    }

    public void K(Context context, String str, String str2, C11458d25 c11458d25) {
        ProgressDialog progressDialog = this.p;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.p = C8920Xu5.e(context, true);
        }
        this.g.I(str).a(new a(context, str2, c11458d25));
    }

    public void L() {
        if (this.b) {
            return;
        }
        synchronized (this.c) {
            if (!this.b) {
                try {
                    long jP = AbstractC20507s76.p();
                    C19406qI3.a("SyncLog", "load_lock_wait_for_ready_wait_start_on_thread:" + Thread.currentThread().getName(), new Object[0]);
                    this.c.wait();
                    C19406qI3.a("SyncLog", "load_lock_wait_for_ready_wait_finish, duration:" + (System.currentTimeMillis() - jP) + "ms", new Object[0]);
                } catch (InterruptedException e) {
                    C19406qI3.c("NasimSDK", "waitForReady", e);
                }
            }
        }
    }

    public String f() {
        return this.l;
    }

    public C11458d25 h() {
        return this.f;
    }

    public C11335cq i() {
        return this.g;
    }

    public long j() {
        return this.m;
    }

    public AbstractC13089g k() {
        return this.d;
    }

    public void o(C11458d25 c11458d25) {
        C9057Yh4 c9057Yh4Y = this.g.Y();
        if (c9057Yh4Y == null) {
            return;
        }
        c9057Yh4Y.G().j2(c11458d25);
        c9057Yh4Y.G().o0(c11458d25, false);
    }

    public void p(String str) {
        this.l = str;
    }

    public void q(String[] strArr) {
        this.h = strArr;
        this.i = new String[0];
    }

    public void r(String str) {
        try {
            if (!this.g.z0() || this.m == 0) {
                C19406qI3.a("NasimSDK", "setFCMPushToken return because !isLoggedIn or pushId is zero ", new Object[0]);
                return;
            }
            C19406qI3.a("NasimSDK", "setFCMPushToken, isLoggedIn and pushId is not zero.", new Object[0]);
            if (this.o == null) {
                this.o = new C4164Dy5();
            }
            this.o.f(str);
        } catch (Exception e) {
            C19406qI3.a("NasimSDK", "Error in setFCMPushToken: " + e.getMessage(), new Object[0]);
        }
    }

    public void s(C11458d25 c11458d25) {
        this.f = c11458d25;
    }

    public void t(long j) {
        this.m = j;
    }

    public void u(AbstractC13089g abstractC13089g) {
        this.d = abstractC13089g;
    }

    public void v(int i) {
        this.e = i;
    }

    public void x(int i) {
        AbstractC13089g abstractC13089gK = w().k();
        if (abstractC13089gK != null) {
            abstractC13089gK.y9(C24137y63.b(i));
        }
    }

    public void y(Context context, final int i) {
        this.g.a.W().o0().o().a(i).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Ip4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.m(i, (C17637nI7) obj);
            }
        });
    }
}
