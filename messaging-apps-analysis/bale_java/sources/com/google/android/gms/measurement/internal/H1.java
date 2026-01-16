package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzcl;
import ir.nasim.AbstractC11344cq8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.BD1;
import ir.nasim.Fb8;
import ir.nasim.OV0;
import ir.nasim.Qh8;
import ir.nasim.Rs8;
import ir.nasim.Wn8;
import ir.nasim.Xh8;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class H1 implements InterfaceC2223c2 {
    private static volatile H1 H;
    private volatile Boolean A;
    protected Boolean B;
    protected Boolean C;
    private volatile boolean D;
    private int E;
    final long G;
    private final Context a;
    private final String b;
    private final String c;
    private final String d;
    private final boolean e;
    private final C2220c f;
    private final C2240g g;
    private final C2292q1 h;
    private final C2227d1 i;
    private final F1 j;
    private final J3 k;
    private final f4 l;
    private final Y0 m;
    private final OV0 n;
    private final T2 o;
    private final G2 p;
    private final C2330y0 q;
    private final K2 r;
    private final String s;
    private X0 t;
    private C2308t3 u;
    private C2280o v;
    private U0 w;
    private Boolean y;
    private long z;
    private boolean x = false;
    private final AtomicInteger F = new AtomicInteger(0);

    H1(C2233e2 c2233e2) {
        Bundle bundle;
        AbstractC3795Cj5.j(c2233e2);
        Context context = c2233e2.a;
        C2220c c2220c = new C2220c(context);
        this.f = c2220c;
        Q0.a = c2220c;
        this.a = context;
        this.b = c2233e2.b;
        this.c = c2233e2.c;
        this.d = c2233e2.d;
        this.e = c2233e2.h;
        this.A = c2233e2.e;
        this.s = c2233e2.j;
        this.D = true;
        zzcl zzclVar = c2233e2.g;
        if (zzclVar != null && (bundle = zzclVar.g) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.B = (Boolean) obj;
            }
            Object obj2 = zzclVar.g.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.C = (Boolean) obj2;
            }
        }
        AbstractC11344cq8.e(context);
        OV0 ov0A = BD1.a();
        this.n = ov0A;
        Long l = c2233e2.i;
        this.G = l != null ? l.longValue() : ov0A.currentTimeMillis();
        this.g = new C2240g(this);
        C2292q1 c2292q1 = new C2292q1(this);
        c2292q1.l();
        this.h = c2292q1;
        C2227d1 c2227d1 = new C2227d1(this);
        c2227d1.l();
        this.i = c2227d1;
        f4 f4Var = new f4(this);
        f4Var.l();
        this.l = f4Var;
        this.m = new Y0(new C2228d2(c2233e2, this));
        this.q = new C2330y0(this);
        T2 t2 = new T2(this);
        t2.j();
        this.o = t2;
        G2 g2 = new G2(this);
        g2.j();
        this.p = g2;
        J3 j3 = new J3(this);
        j3.j();
        this.k = j3;
        K2 k2 = new K2(this);
        k2.l();
        this.r = k2;
        F1 f1 = new F1(this);
        f1.l();
        this.j = f1;
        zzcl zzclVar2 = c2233e2.g;
        boolean z = zzclVar2 == null || zzclVar2.b == 0;
        if (context.getApplicationContext() instanceof Application) {
            G2 g2I = I();
            if (g2I.a.a.getApplicationContext() instanceof Application) {
                Application application = (Application) g2I.a.a.getApplicationContext();
                if (g2I.c == null) {
                    g2I.c = new F2(g2I, null);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(g2I.c);
                    application.registerActivityLifecycleCallbacks(g2I.c);
                    g2I.a.b().v().a("Registered activity lifecycle callback");
                }
            }
        } else {
            b().w().a("Application context is not an Application");
        }
        f1.z(new G1(this, c2233e2));
    }

    public static H1 H(Context context, zzcl zzclVar, Long l) {
        Bundle bundle;
        if (zzclVar != null && (zzclVar.e == null || zzclVar.f == null)) {
            zzclVar = new zzcl(zzclVar.a, zzclVar.b, zzclVar.c, zzclVar.d, null, null, zzclVar.g, null);
        }
        AbstractC3795Cj5.j(context);
        AbstractC3795Cj5.j(context.getApplicationContext());
        if (H == null) {
            synchronized (H1.class) {
                try {
                    if (H == null) {
                        H = new H1(new C2233e2(context, zzclVar, l));
                    }
                } finally {
                }
            }
        } else if (zzclVar != null && (bundle = zzclVar.g) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            AbstractC3795Cj5.j(H);
            H.A = Boolean.valueOf(zzclVar.g.getBoolean("dataCollectionDefaultEnabled"));
        }
        AbstractC3795Cj5.j(H);
        return H;
    }

    static /* bridge */ /* synthetic */ void e(H1 h1, C2233e2 c2233e2) {
        h1.a().h();
        h1.g.w();
        C2280o c2280o = new C2280o(h1);
        c2280o.l();
        h1.v = c2280o;
        U0 u0 = new U0(h1, c2233e2.f);
        u0.j();
        h1.w = u0;
        X0 x0 = new X0(h1);
        x0.j();
        h1.t = x0;
        C2308t3 c2308t3 = new C2308t3(h1);
        c2308t3.j();
        h1.u = c2308t3;
        h1.l.m();
        h1.h.m();
        h1.w.k();
        C2217b1 c2217b1U = h1.b().u();
        h1.g.q();
        c2217b1U.b("App measurement initialized, version", 74029L);
        h1.b().u().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strS = u0.s();
        if (TextUtils.isEmpty(h1.b)) {
            if (h1.N().T(strS)) {
                h1.b().u().a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                h1.b().u().a("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(strS)));
            }
        }
        h1.b().q().a("Debug-level message logging enabled");
        if (h1.E != h1.F.get()) {
            h1.b().r().c("Not all components initialized", Integer.valueOf(h1.E), Integer.valueOf(h1.F.get()));
        }
        h1.x = true;
    }

    static final void t() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void u(AbstractC2213a2 abstractC2213a2) {
        if (abstractC2213a2 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void v(AbstractC2311u1 abstractC2311u1) {
        if (abstractC2311u1 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!abstractC2311u1.m()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(abstractC2311u1.getClass())));
        }
    }

    private static final void w(AbstractC2218b2 abstractC2218b2) {
        if (abstractC2218b2 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!abstractC2218b2.n()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(abstractC2218b2.getClass())));
        }
    }

    public final C2280o A() {
        w(this.v);
        return this.v;
    }

    public final U0 B() {
        v(this.w);
        return this.w;
    }

    public final X0 C() {
        v(this.t);
        return this.t;
    }

    public final Y0 D() {
        return this.m;
    }

    public final C2227d1 E() {
        C2227d1 c2227d1 = this.i;
        if (c2227d1 == null || !c2227d1.n()) {
            return null;
        }
        return c2227d1;
    }

    public final C2292q1 F() {
        u(this.h);
        return this.h;
    }

    final F1 G() {
        return this.j;
    }

    public final G2 I() {
        v(this.p);
        return this.p;
    }

    public final K2 J() {
        w(this.r);
        return this.r;
    }

    public final T2 K() {
        v(this.o);
        return this.o;
    }

    public final C2308t3 L() {
        v(this.u);
        return this.u;
    }

    public final J3 M() {
        v(this.k);
        return this.k;
    }

    public final f4 N() {
        u(this.l);
        return this.l;
    }

    public final String O() {
        return this.b;
    }

    public final String P() {
        return this.c;
    }

    public final String Q() {
        return this.d;
    }

    public final String R() {
        return this.s;
    }

    @Override // com.google.android.gms.measurement.internal.InterfaceC2223c2
    public final F1 a() {
        w(this.j);
        return this.j;
    }

    @Override // com.google.android.gms.measurement.internal.InterfaceC2223c2
    public final C2227d1 b() {
        w(this.i);
        return this.i;
    }

    @Override // com.google.android.gms.measurement.internal.InterfaceC2223c2
    public final OV0 c() {
        return this.n;
    }

    @Override // com.google.android.gms.measurement.internal.InterfaceC2223c2
    public final C2220c d() {
        return this.f;
    }

    @Override // com.google.android.gms.measurement.internal.InterfaceC2223c2
    public final Context f() {
        return this.a;
    }

    final void g() {
        this.F.incrementAndGet();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ void h(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map r11) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.H1.h(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    final void i() {
        this.E++;
    }

    public final void j() {
        a().h();
        w(J());
        String strS = B().s();
        Pair pairP = F().p(strS);
        if (!this.g.A() || ((Boolean) pairP.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairP.first)) {
            b().q().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        K2 k2J = J();
        k2J.k();
        ConnectivityManager connectivityManager = (ConnectivityManager) k2J.a.a.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            b().w().a("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        f4 f4VarN = N();
        B().a.g.q();
        URL urlS = f4VarN.s(74029L, strS, (String) pairP.first, (-1) + F().t.a());
        if (urlS != null) {
            K2 k2J2 = J();
            Wn8 wn8 = new Wn8(this);
            k2J2.h();
            k2J2.k();
            AbstractC3795Cj5.j(urlS);
            AbstractC3795Cj5.j(wn8);
            k2J2.a.a().y(new J2(k2J2, strS, urlS, null, null, wn8, null));
        }
    }

    final void k(boolean z) {
        this.A = Boolean.valueOf(z);
    }

    public final void l(boolean z) {
        a().h();
        this.D = z;
    }

    protected final void m(zzcl zzclVar) throws ClassNotFoundException {
        Xh8 xh8;
        a().h();
        Xh8 xh8Q = F().q();
        C2292q1 c2292q1F = F();
        H1 h1 = c2292q1F.a;
        c2292q1F.h();
        int i = 100;
        int i2 = c2292q1F.o().getInt("consent_source", 100);
        C2240g c2240g = this.g;
        H1 h12 = c2240g.a;
        Boolean boolT = c2240g.t("google_analytics_default_allow_ad_storage");
        C2240g c2240g2 = this.g;
        H1 h13 = c2240g2.a;
        Boolean boolT2 = c2240g2.t("google_analytics_default_allow_analytics_storage");
        if (!(boolT == null && boolT2 == null) && F().w(-10)) {
            xh8 = new Xh8(boolT, boolT2);
            i = -10;
        } else {
            if (!TextUtils.isEmpty(B().t()) && (i2 == 0 || i2 == 30 || i2 == 10 || i2 == 30 || i2 == 30 || i2 == 40)) {
                I().G(Xh8.b, -10, this.G);
            } else if (TextUtils.isEmpty(B().t()) && zzclVar != null && zzclVar.g != null && F().w(30)) {
                xh8 = Xh8.a(zzclVar.g);
                if (!xh8.equals(Xh8.b)) {
                    i = 30;
                }
            }
            xh8 = null;
        }
        if (xh8 != null) {
            I().G(xh8, i, this.G);
            xh8Q = xh8;
        }
        I().J(xh8Q);
        if (F().e.a() == 0) {
            b().v().b("Persisting first open", Long.valueOf(this.G));
            F().e.b(this.G);
        }
        I().n.c();
        if (r()) {
            if (!TextUtils.isEmpty(B().t()) || !TextUtils.isEmpty(B().r())) {
                f4 f4VarN = N();
                String strT = B().t();
                C2292q1 c2292q1F2 = F();
                c2292q1F2.h();
                String string = c2292q1F2.o().getString("gmp_app_id", null);
                String strR = B().r();
                C2292q1 c2292q1F3 = F();
                c2292q1F3.h();
                if (f4VarN.b0(strT, string, strR, c2292q1F3.o().getString("admob_app_id", null))) {
                    b().u().a("Rechecking which service to use due to a GMP App Id change");
                    C2292q1 c2292q1F4 = F();
                    c2292q1F4.h();
                    Boolean boolR = c2292q1F4.r();
                    SharedPreferences.Editor editorEdit = c2292q1F4.o().edit();
                    editorEdit.clear();
                    editorEdit.apply();
                    if (boolR != null) {
                        c2292q1F4.s(boolR);
                    }
                    C().q();
                    this.u.Q();
                    this.u.P();
                    F().e.b(this.G);
                    F().g.b(null);
                }
                C2292q1 c2292q1F5 = F();
                String strT2 = B().t();
                c2292q1F5.h();
                SharedPreferences.Editor editorEdit2 = c2292q1F5.o().edit();
                editorEdit2.putString("gmp_app_id", strT2);
                editorEdit2.apply();
                C2292q1 c2292q1F6 = F();
                String strR2 = B().r();
                c2292q1F6.h();
                SharedPreferences.Editor editorEdit3 = c2292q1F6.o().edit();
                editorEdit3.putString("admob_app_id", strR2);
                editorEdit3.apply();
            }
            if (!F().q().i(Qh8.ANALYTICS_STORAGE)) {
                F().g.b(null);
            }
            I().C(F().g.a());
            Rs8.b();
            if (this.g.B(null, S0.e0)) {
                try {
                    N().a.a.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    if (!TextUtils.isEmpty(F().u.a())) {
                        b().w().a("Remote config removed with active feature rollouts");
                        F().u.b(null);
                    }
                }
            }
            if (!TextUtils.isEmpty(B().t()) || !TextUtils.isEmpty(B().r())) {
                boolean zO = o();
                if (!F().u() && !this.g.E()) {
                    F().t(!zO);
                }
                if (zO) {
                    I().f0();
                }
                M().d.a();
                L().S(new AtomicReference());
                L().v(F().x.a());
            }
        } else if (o()) {
            if (!N().S("android.permission.INTERNET")) {
                b().r().a("App is missing INTERNET permission");
            }
            if (!N().S("android.permission.ACCESS_NETWORK_STATE")) {
                b().r().a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Fb8.a(this.a).f() && !this.g.G()) {
                if (!f4.Y(this.a)) {
                    b().r().a("AppMeasurementReceiver not registered/enabled");
                }
                if (!f4.Z(this.a, false)) {
                    b().r().a("AppMeasurementService not registered/enabled");
                }
            }
            b().r().a("Uploading is not possible. App measurement disabled");
        }
        F().n.a(true);
    }

    public final boolean n() {
        return this.A != null && this.A.booleanValue();
    }

    public final boolean o() {
        return x() == 0;
    }

    public final boolean p() {
        a().h();
        return this.D;
    }

    public final boolean q() {
        return TextUtils.isEmpty(this.b);
    }

    protected final boolean r() {
        if (!this.x) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        a().h();
        Boolean bool = this.y;
        if (bool == null || this.z == 0 || (!bool.booleanValue() && Math.abs(this.n.elapsedRealtime() - this.z) > 1000)) {
            this.z = this.n.elapsedRealtime();
            boolean z = true;
            Boolean boolValueOf = Boolean.valueOf(N().S("android.permission.INTERNET") && N().S("android.permission.ACCESS_NETWORK_STATE") && (Fb8.a(this.a).f() || this.g.G() || (f4.Y(this.a) && f4.Z(this.a, false))));
            this.y = boolValueOf;
            if (boolValueOf.booleanValue()) {
                if (!N().L(B().t(), B().r()) && TextUtils.isEmpty(B().r())) {
                    z = false;
                }
                this.y = Boolean.valueOf(z);
            }
        }
        return this.y.booleanValue();
    }

    public final boolean s() {
        return this.e;
    }

    public final int x() {
        a().h();
        if (this.g.E()) {
            return 1;
        }
        Boolean bool = this.C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        a().h();
        if (!this.D) {
            return 8;
        }
        Boolean boolR = F().r();
        if (boolR != null) {
            return boolR.booleanValue() ? 0 : 3;
        }
        C2240g c2240g = this.g;
        C2220c c2220c = c2240g.a.f;
        Boolean boolT = c2240g.t("firebase_analytics_collection_enabled");
        if (boolT != null) {
            return boolT.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.B;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (this.A == null || this.A.booleanValue()) ? 0 : 7;
    }

    public final C2330y0 y() {
        C2330y0 c2330y0 = this.q;
        if (c2330y0 != null) {
            return c2330y0;
        }
        throw new IllegalStateException("Component not created");
    }

    public final C2240g z() {
        return this.g;
    }
}
