package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.webkit.WebView;
import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.impl.C2601i1;
import io.appmetrica.analytics.internal.IdentifiersResult;
import io.appmetrica.analytics.internal.js.AppMetricaInitializerJsInterface;
import io.appmetrica.analytics.internal.js.AppMetricaJsInterface;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import io.appmetrica.analytics.profile.UserProfile;
import java.util.List;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.i1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2601i1 {
    public final C2743o0 a;
    public final Cn b;
    public final Eh c;
    public final A7 d;
    public final C2572gk e;
    public final H2 f;
    public final C2501dm g;
    public final Xj h;

    public C2601i1(C2743o0 c2743o0, H2 h2, C2572gk c2572gk, Cn cn, C2501dm c2501dm, Eh eh, A7 a7, Xj xj) {
        this.a = c2743o0;
        this.b = cn;
        this.c = eh;
        this.d = a7;
        this.f = h2;
        this.g = c2501dm;
        this.e = c2572gk;
        this.h = xj;
    }

    public static IHandlerExecutor c() {
        return C2747o4.g().c.a();
    }

    public final void a(final Context context, final AppMetricaConfig appMetricaConfig) {
        H2 h2 = this.f;
        h2.f.a(context);
        h2.b.a(appMetricaConfig);
        C2501dm c2501dm = this.g;
        Context applicationContext = context.getApplicationContext();
        c2501dm.e.a(applicationContext);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(appMetricaConfig.apiKey);
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, Boolean.TRUE)).booleanValue()) {
            orCreatePublicLogger.info("Session auto tracking enabled", new Object[0]);
            c2501dm.d.a();
        } else {
            orCreatePublicLogger.info("Session auto tracking disabled", new Object[0]);
        }
        c2501dm.a.getClass();
        C2719n0 c2719n0A = C2719n0.a(applicationContext, true);
        c2719n0A.d.a(appMetricaConfig, c2719n0A);
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new Runnable() { // from class: ir.nasim.he8
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(context, appMetricaConfig);
            }
        });
        this.a.getClass();
        synchronized (C2719n0.class) {
            C2719n0.f = true;
        }
    }

    public final String b() {
        this.a.getClass();
        C2719n0 c2719n0 = C2719n0.e;
        if (c2719n0 == null) {
            return null;
        }
        return c2719n0.j().e();
    }

    public final Wb d() {
        this.a.getClass();
        return C2719n0.e.j().i();
    }

    public final void e() {
        d().a.a(this.h.a());
    }

    public final void f() {
        this.f.a.a(null);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new M0(this));
    }

    public final void c(Activity activity) {
        this.f.a.a(null);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new X0(this, activity));
    }

    public final void b(Context context, AppMetricaConfig appMetricaConfig) {
        C2743o0 c2743o0 = this.a;
        Context applicationContext = context.getApplicationContext();
        c2743o0.getClass();
        C2719n0 c2719n0A = C2719n0.a(applicationContext, false);
        c2719n0A.j().a(this.d.b(appMetricaConfig));
    }

    public final void e(String str) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new J0(this, str));
    }

    public final void d(String str) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.j.a(str);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new F0(this, str));
    }

    public C2601i1() {
        this(C2747o4.g().b(), new Cn());
    }

    public final void c(String str, String str2) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.s.a(str);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new RunnableC2480d1(this, str, str2));
    }

    public C2601i1(C2743o0 c2743o0, Cn cn) {
        this(c2743o0, new H2(c2743o0), new C2572gk(c2743o0), cn, new C2501dm(c2743o0, cn), Eh.a(), C2747o4.g().f(), C2747o4.g().k());
    }

    public final void b(String str) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.s.a(str);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new RunnableC2455c1(this, str));
    }

    public final void d(String str, String str2) {
        H2 h2 = this.f;
        h2.a.a(null);
        if (h2.o.a(str).a) {
            this.g.getClass();
            IHandlerExecutor iHandlerExecutorC = c();
            ((C2871t9) iHandlerExecutorC).b.post(new T0(this, str, str2));
        }
    }

    public final void c(String str) {
        if (this.e.a((Void) null).a && this.f.n.a(str).a) {
            this.g.getClass();
            IHandlerExecutor iHandlerExecutorC = c();
            ((C2871t9) iHandlerExecutorC).b.post(new U0(this, str));
        }
    }

    public final void b(Activity activity) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.c.a(activity);
        this.g.getClass();
        Intent intentA = C2501dm.a(activity);
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new C0(this, intentA));
    }

    public final void a(Activity activity) {
        this.f.a.a(null);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new RunnableC2430b1(this, activity));
    }

    public final void b(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new H0(this, z));
    }

    public final void b(String str, String str2) {
        this.f.l.a(str);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new R0(this, str, str2));
    }

    public final void a(Application application) {
        this.f.e.a(application);
        this.g.c.a(application);
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new Runnable() { // from class: ir.nasim.ie8
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e();
            }
        });
    }

    public final void b(final Object... objArr) {
        this.f.a.a(null);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new Runnable() { // from class: ir.nasim.je8
            @Override // java.lang.Runnable
            public final void run() {
                C2601i1.a(objArr);
            }
        });
    }

    public final void a(String str, Map<String, Object> map) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.s.a(str);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new RunnableC2505e1(this, str, listFromMap));
    }

    public final void a(String str, Throwable th) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.t.a(str);
        this.g.getClass();
        if (th == null) {
            th = new O1();
            th.fillInStackTrace();
        }
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new RunnableC2529f1(this, str, th));
    }

    public final void a(String str, String str2, Throwable th) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.u.a(str);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new RunnableC2553g1(this, str, str2, th));
    }

    public final void a(Throwable th) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.v.a(th);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new RunnableC2577h1(this, th));
    }

    public final void a(String str) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.i.a(str);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new D0(this, str));
    }

    public final void a(Intent intent) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.d.a(intent);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new E0(this, intent));
    }

    public final void a(Location location) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new G0(this, location));
    }

    public final void a(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new I0(this, z));
    }

    public final void a(UserProfile userProfile) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.w.a(userProfile);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new K0(this, userProfile));
    }

    public final void a(Revenue revenue) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.x.a(revenue);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new L0(this, revenue));
    }

    public final void a(AdRevenue adRevenue) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.y.a(adRevenue);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new N0(this, adRevenue));
    }

    public final void a(ECommerceEvent eCommerceEvent) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.z.a(eCommerceEvent);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new O0(this, eCommerceEvent));
    }

    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.g.a(deferredDeeplinkParametersListener);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new P0(this, deferredDeeplinkParametersListener));
    }

    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.g.a(deferredDeeplinkListener);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new Q0(this, deferredDeeplinkListener));
    }

    public final La a(Context context, String str) {
        H2 h2 = this.f;
        h2.f.a(context);
        h2.k.a(str);
        C2501dm c2501dm = this.g;
        c2501dm.e.a(context.getApplicationContext());
        return this.c.a(context.getApplicationContext(), str);
    }

    public final void a(Context context, ReporterConfig reporterConfig) {
        H2 h2 = this.f;
        h2.f.a(context);
        h2.h.a(reporterConfig);
        C2501dm c2501dm = this.g;
        c2501dm.e.a(context.getApplicationContext());
        Eh eh = this.c;
        Context applicationContext = context.getApplicationContext();
        if (((C2951wh) eh.a.get(reporterConfig.apiKey)) == null) {
            synchronized (eh.a) {
                try {
                    if (((C2951wh) eh.a.get(reporterConfig.apiKey)) == null) {
                        String str = reporterConfig.apiKey;
                        IHandlerExecutor iHandlerExecutorA = C2747o4.g().c.a();
                        eh.b.getClass();
                        if (C2719n0.e == null) {
                            ((C2871t9) iHandlerExecutorA).b.post(new Ch(eh, applicationContext));
                        }
                        C2951wh c2951wh = new C2951wh(applicationContext.getApplicationContext(), str, new C2743o0());
                        eh.a.put(str, c2951wh);
                        c2951wh.a(reporterConfig);
                    }
                } finally {
                }
            }
        }
    }

    public final void a(WebView webView) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.m.a(webView);
        Cn cn = this.g.b;
        cn.getClass();
        try {
            if (webView.getSettings().getJavaScriptEnabled()) {
                webView.addJavascriptInterface(new AppMetricaJsInterface(this), "AppMetrica");
                webView.addJavascriptInterface(new AppMetricaInitializerJsInterface(this), "AppMetricaInitializer");
                zn znVar = new zn();
                synchronized (cn) {
                    try {
                        PublicLogger publicLogger = cn.b;
                        if (publicLogger == null) {
                            cn.a.add(znVar);
                        } else {
                            znVar.consume(publicLogger);
                        }
                    } finally {
                    }
                }
            } else {
                cn.a(new An());
            }
        } catch (Throwable th) {
            cn.a(new Bn(th));
        }
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new S0(this));
    }

    public final IdentifiersResult a(Context context) {
        this.f.p.a(context);
        C2501dm c2501dm = this.g;
        c2501dm.e.a(context.getApplicationContext());
        return C2747o4.g().a(context.getApplicationContext()).a();
    }

    public final void a(String str, String str2) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new V0(this, str, str2));
    }

    public final void a() {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new W0(this));
    }

    public final void a(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        H2 h2 = this.f;
        h2.f.a(context);
        h2.p.a(startupParamsCallback);
        C2501dm c2501dm = this.g;
        c2501dm.e.a(context.getApplicationContext());
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new Y0(this, context, startupParamsCallback, list));
    }

    public final void a(AnrListener anrListener) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.q.a(anrListener);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new Z0(this, anrListener));
    }

    public final void a(ExternalAttribution externalAttribution) {
        H2 h2 = this.f;
        h2.a.a(null);
        h2.r.a(externalAttribution);
        this.g.getClass();
        IHandlerExecutor iHandlerExecutorC = c();
        ((C2871t9) iHandlerExecutorC).b.post(new RunnableC2405a1(this, externalAttribution));
    }

    public static /* synthetic */ void a(Object[] objArr) {
        ModuleAdRevenueProcessor moduleAdRevenueProcessorA = C2747o4.g().i().a();
        if (moduleAdRevenueProcessorA != null) {
            moduleAdRevenueProcessorA.process(objArr);
        }
    }

    public static Ca a(C2601i1 c2601i1) {
        return c2601i1.d().a;
    }
}
