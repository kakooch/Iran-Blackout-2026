package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashClientConfig;
import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashClientModule;
import ir.nasim.AbstractC13042fc3;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class Ub extends Q2 implements Ca {
    public static final Am q = new Am(new C2827rd("Referral url"));
    public static final Long r = Long.valueOf(TimeUnit.SECONDS.toMillis(5));
    public final C2516ec o;
    public final Vb p;

    public Ub(C2516ec c2516ec) {
        super(c2516ec.b(), c2516ec.i(), c2516ec.h(), c2516ec.d(), c2516ec.f(), c2516ec.j(), c2516ec.g(), c2516ec.c(), c2516ec.a(), c2516ec.e());
        this.o = c2516ec;
        this.p = new Vb(c2516ec, this);
        l();
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(String str, boolean z) {
        this.c.info("App opened via deeplink: " + WrapUtils.wrapToTag(str), new Object[0]);
        Lh lh = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        HashMap map = new HashMap();
        map.put("type", "open");
        map.put("link", str);
        map.put("auto", Boolean.valueOf(z));
        String strB = Ya.b(map);
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(strB, "", 8208, 0, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void b(String str) {
        q.a(str);
        Lh lh = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        HashMap map = new HashMap();
        map.put("type", "referral");
        map.put("link", str);
        map.put("auto", Boolean.FALSE);
        String strB = Ya.b(map);
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(strB, "", 8208, 0, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
        this.c.info("Referral URL received: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void c() {
        Vb vb = this.p;
        synchronized (vb) {
            vb.b.a(vb.a);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final List<String> f() {
        return this.b.a.b();
    }

    @Override // io.appmetrica.analytics.impl.Q2
    public final String j() {
        return "[MainReporter]";
    }

    @Override // io.appmetrica.analytics.impl.Q2
    public final void k() {
        super.k();
        C2747o4.g().i().b();
    }

    public final void l() {
        Lh lh = this.h;
        lh.c.a(this.b.a);
        C2530f2 c2530f2 = this.o.h;
        Tb tb = new Tb(this);
        long jLongValue = r.longValue();
        synchronized (c2530f2) {
            c2530f2.a(tb, jLongValue);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(EnumC2742o enumC2742o) {
        if (enumC2742o == EnumC2742o.b) {
            this.c.info("Enable activity auto tracking", new Object[0]);
            return;
        }
        this.c.warning("Could not enable activity auto tracking. " + enumC2742o.a, new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void b(Activity activity) {
        if (this.o.k.a(activity, EnumC2790q.PAUSED)) {
            this.c.info("Pause session", new Object[0]);
            c(activity != null ? activity.getClass().getSimpleName() : null);
            C2530f2 c2530f2 = this.o.h;
            synchronized (c2530f2) {
                for (C2506e2 c2506e2 : c2530f2.a) {
                    if (!c2506e2.d) {
                        c2506e2.d = true;
                        c2506e2.b.executeDelayed(c2506e2.e, c2506e2.c);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(Activity activity) {
        if (this.o.k.a(activity, EnumC2790q.RESUMED)) {
            this.c.info("Resume session", new Object[0]);
            d(activity != null ? activity.getClass().getSimpleName() : null);
            C2530f2 c2530f2 = this.o.h;
            synchronized (c2530f2) {
                for (C2506e2 c2506e2 : c2530f2.a) {
                    if (c2506e2.d) {
                        c2506e2.d = false;
                        c2506e2.b.remove(c2506e2.e);
                        Ub ub = c2506e2.a.a;
                        ub.h.c.b(ub.b.a);
                    }
                }
            }
        }
    }

    public final void a(AppMetricaConfig appMetricaConfig, boolean z) {
        if (z) {
            clearAppEnvironment();
        }
        a(appMetricaConfig.appEnvironment);
        b(appMetricaConfig.errorEnvironment);
        Boolean bool = (Boolean) WrapUtils.getOrDefault(appMetricaConfig.nativeCrashReporting, Boolean.TRUE);
        boolean zBooleanValue = bool.booleanValue();
        this.c.info("native crash reporting enabled: %b", bool);
        if (zBooleanValue) {
            C2442bd c2442bd = this.o.e;
            Context context = this.a;
            c2442bd.d = new C2958x0(this.b.b.getApiKey(), c2442bd.a.a.getAsString("PROCESS_CFG_PACKAGE_NAME"), CounterConfigurationReporterType.MAIN, c2442bd.a.a.getAsInteger("PROCESS_CFG_PROCESS_ID").intValue(), c2442bd.a.a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID"), this.b.d());
            File nativeCrashDirectory = FileUtils.getNativeCrashDirectory(context);
            C2958x0 c2958x0 = null;
            String absolutePath = nativeCrashDirectory != null ? nativeCrashDirectory.getAbsolutePath() : null;
            if (absolutePath != null) {
                NativeCrashClientModule nativeCrashClientModule = c2442bd.b;
                C2982y0 c2982y0 = c2442bd.c;
                C2958x0 c2958x02 = c2442bd.d;
                if (c2958x02 == null) {
                    AbstractC13042fc3.y("nativeCrashMetadata");
                } else {
                    c2958x0 = c2958x02;
                }
                c2982y0.getClass();
                nativeCrashClientModule.initHandling(context, new NativeCrashClientConfig(absolutePath, C2982y0.a(c2958x0)));
            }
        }
        Vb vb = this.p;
        synchronized (vb) {
            try {
                Integer num = appMetricaConfig.anrMonitoringTimeout;
                vb.a = num != null ? num.intValue() : 5;
                Boolean bool2 = appMetricaConfig.anrMonitoring;
                if (bool2 == null) {
                    bool2 = Boolean.FALSE;
                }
                if (bool2.booleanValue()) {
                    vb.b.a(vb.a);
                } else {
                    vb.b.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(Location location) {
        this.b.b.setManualLocation(location);
        this.c.info("Set location: %s", location);
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(boolean z) {
        this.b.b.setLocationTracking(z);
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(Cn cn) {
        PublicLogger publicLogger = this.c;
        synchronized (cn) {
            cn.b = publicLogger;
        }
        Iterator it = cn.a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(publicLogger);
        }
        cn.a.clear();
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(AnrListener anrListener) {
        this.p.a(anrListener);
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(ExternalAttribution externalAttribution) {
        this.c.info("External attribution received: %s", externalAttribution);
        Lh lh = this.h;
        byte[] bytes = externalAttribution.toBytes();
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(bytes, "", 42, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
    }

    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(String str, String str2) {
        super.a(str, str2);
        C2442bd c2442bd = this.o.e;
        String strD = this.b.d();
        C2958x0 c2958x0 = c2442bd.d;
        if (c2958x0 != null) {
            C2958x0 c2958x02 = new C2958x0(c2958x0.a, c2958x0.b, c2958x0.c, c2958x0.d, c2958x0.e, strD);
            c2442bd.d = c2958x02;
            NativeCrashClientModule nativeCrashClientModule = c2442bd.b;
            c2442bd.c.getClass();
            nativeCrashClientModule.updateAppMetricaMetadata(C2982y0.a(c2958x02));
        }
    }
}
