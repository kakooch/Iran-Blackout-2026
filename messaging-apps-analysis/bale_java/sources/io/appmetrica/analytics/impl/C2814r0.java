package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import ir.nasim.AbstractC13042fc3;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.r0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2814r0 implements InterfaceC2944wa {
    public final Context a;
    public final InterfaceC2920va b;
    public final C2637je c;
    public final Nk d;
    public final C2997yf e;
    public final Oe f;
    public final C3023zh g;
    public final Lh h;
    public final A7 i;
    public final Xj j;
    public volatile Wb k;
    public final C2479d0 l;
    public boolean m;

    public C2814r0(Context context, InterfaceC2920va interfaceC2920va) {
        this.a = context;
        this.b = interfaceC2920va;
        C2637je c2637jeB = C2747o4.g().b(context);
        this.c = c2637jeB;
        Tc.a();
        C2747o4 c2747o4G = C2747o4.g();
        c2747o4G.i().a(new Z3());
        Oe oeA = AbstractC2838s0.a(context, AbstractC2838s0.a(interfaceC2920va.b(), this));
        this.f = oeA;
        A7 a7F = c2747o4G.f();
        this.i = a7F;
        Lh lhA = AbstractC2838s0.a(oeA, context, interfaceC2920va.getDefaultExecutor());
        this.h = lhA;
        a7F.a(lhA);
        Nk nkA = AbstractC2838s0.a(context, lhA, c2637jeB, interfaceC2920va.b());
        this.d = nkA;
        lhA.a(nkA);
        this.e = AbstractC2838s0.a(lhA, c2637jeB, interfaceC2920va.b());
        this.g = AbstractC2838s0.a(context, oeA, lhA, interfaceC2920va.b(), nkA);
        this.j = c2747o4G.k();
        this.l = new C2479d0(context, c2637jeB);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final La c(ReporterConfig reporterConfig) {
        return this.g.b(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void clearAppEnvironment() {
        j().clearAppEnvironment();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final void d() {
        C2479d0 c2479d0 = this.l;
        AppMetricaConfig appMetricaConfigF = c2479d0.b.f();
        if (appMetricaConfigF == null) {
            C2671l0 c2671l0 = c2479d0.c;
            Context context = c2479d0.a;
            c2671l0.getClass();
            AppMetricaConfig.Builder builderNewConfigBuilder = AppMetricaConfig.newConfigBuilder("629a824d-c717-4ba5-bc0f-3f3968554d01");
            if (c2671l0.a.c()) {
                c2671l0.b.getClass();
                try {
                    File fileFromAppStorage = FileUtils.getFileFromAppStorage(context, "uuid.dat");
                    boolean zExists = fileFromAppStorage != null ? fileFromAppStorage.exists() : false;
                    File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(context, "uuid.dat");
                    boolean zExists2 = fileFromSdkStorage != null ? fileFromSdkStorage.exists() : false;
                    if (zExists || zExists2) {
                        builderNewConfigBuilder.handleFirstActivationAsUpdate(true);
                    }
                } catch (Throwable unused) {
                }
            }
            appMetricaConfigF = builderNewConfigBuilder.build();
        }
        PublicLogger mainPublicOrAnonymousLogger = LoggerStorage.getMainPublicOrAnonymousLogger();
        if (a(mainPublicOrAnonymousLogger, appMetricaConfigF, new C2791q0(this, appMetricaConfigF, mainPublicOrAnonymousLogger))) {
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate AppMetrica in anonymous mode", new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final String e() {
        return this.d.c();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final Map<String, String> g() {
        return this.d.b();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final R9 getFeatures() {
        return this.d.d();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final AdvIdentifiersResult h() {
        return this.d.a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final Wb i() {
        return this.k;
    }

    public final Ca j() {
        Wb wb = this.k;
        AbstractC13042fc3.f(wb);
        return wb.a;
    }

    public final C3023zh k() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void putAppEnvironmentValue(String str, String str2) {
        j().putAppEnvironmentValue(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void setDataSendingEnabled(boolean z) {
        j().setDataSendingEnabled(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void setUserProfileID(String str) {
        j().setUserProfileID(str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final void a(AppMetricaConfig appMetricaConfig) {
        boolean z;
        PublicLogger orCreateMainPublicLogger = LoggerStorage.getOrCreateMainPublicLogger(appMetricaConfig.apiKey);
        boolean zA = a(orCreateMainPublicLogger, appMetricaConfig, new C2767p0(this, appMetricaConfig, orCreateMainPublicLogger));
        if (zA || this.m) {
            z = false;
        } else {
            a(appMetricaConfig, orCreateMainPublicLogger);
            z = true;
        }
        if (zA || z) {
            this.c.a(appMetricaConfig);
        } else {
            orCreateMainPublicLogger.warning("AppMetrica SDK already has been activated", new Object[0]);
        }
        if (zA) {
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate AppMetrica with APIKey " + ApiKeyUtils.createPartialApiKey(appMetricaConfig.apiKey), new Object[0]);
        }
        if (z) {
            ImportantLogger.INSTANCE.info("AppMetrica", "Upgrade AppMetrica anonymous mode to normal with APIKey " + ApiKeyUtils.createPartialApiKey(appMetricaConfig.apiKey), new Object[0]);
        }
        this.m = true;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2964x6
    public final void a(int i, Bundle bundle) {
        this.d.b(bundle, null);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.e.a(deferredDeeplinkParametersListener);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        this.e.a(deferredDeeplinkListener);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final void a(ReporterConfig reporterConfig) {
        this.g.a(reporterConfig);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa
    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        this.d.a(startupParamsCallback, list, Ya.c(this.f.a.getAsString("PROCESS_CFG_CLIDS")));
    }

    public final boolean a(PublicLogger publicLogger, AppMetricaConfig appMetricaConfig, InterfaceC2540fc interfaceC2540fc) {
        if (this.k == null) {
            a(appMetricaConfig, publicLogger);
            this.e.a();
            Ub ubA = interfaceC2540fc.a();
            C2941w7 c2941w7 = new C2941w7(ubA);
            Wb wb = new Wb(ubA, c2941w7);
            this.b.c().a(c2941w7);
            this.k = wb;
            C2772p5 c2772p5 = this.j.b;
            synchronized (c2772p5) {
                try {
                    c2772p5.a = ubA;
                    Iterator it = c2772p5.b.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC2851sd) it.next()).consume(ubA);
                    }
                    c2772p5.b.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        interfaceC2540fc.a();
        return false;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        Boolean bool = appMetricaConfig.logs;
        Boolean bool2 = Boolean.TRUE;
        if (bool2.equals(bool)) {
            publicLogger.setEnabled(true);
            PublicLogger.INSTANCE.getAnonymousInstance().setEnabled(true);
        } else {
            publicLogger.setEnabled(false);
            PublicLogger.INSTANCE.getAnonymousInstance().setEnabled(false);
        }
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.crashReporting, bool2)).booleanValue()) {
            this.b.d().a(this.a, appMetricaConfig, this);
            this.b.d().a(this.a, this);
            publicLogger.info("Register application crash handler", new Object[0]);
        } else {
            this.b.d().a();
            publicLogger.info("Disable all crash handlers", new Object[0]);
        }
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, bool2)).booleanValue()) {
            this.j.a();
        } else {
            Xj xj = this.j;
            synchronized (xj) {
                if (xj.g) {
                    xj.a.b(xj.c, EnumC2694m.RESUMED);
                    xj.a.b(xj.d, EnumC2694m.PAUSED);
                    xj.g = false;
                }
            }
        }
        this.f.d(appMetricaConfig);
        Nk nk = this.d;
        nk.e = publicLogger;
        nk.b(appMetricaConfig.customHosts);
        Nk nk2 = this.d;
        Object obj = appMetricaConfig.additionalConfig.get("YMM_clids");
        nk2.a(obj instanceof Map ? (Map) obj : null);
        String str = (String) appMetricaConfig.additionalConfig.get("YMM_distributionReferrer");
        this.d.a(str);
        if (str != null) {
            this.d.b("api");
        }
        Lh lh = this.h;
        Boolean bool3 = appMetricaConfig.locationTracking;
        Boolean bool4 = appMetricaConfig.dataSendingEnabled;
        if (hn.a(bool3)) {
            lh.a.b.setLocationTracking(bool3.booleanValue());
        }
        if (hn.a(bool4)) {
            lh.a.b.setDataSendingEnabled(bool4.booleanValue());
        } else {
            lh.getClass();
        }
        Q5 q5A = Q5.a();
        Q4 q4 = lh.a;
        lh.a(Lh.a(q5A, q4), q4, 1, null);
        this.d.i();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(Location location) {
        j().a(location);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(boolean z) {
        j().a(z);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(String str, String str2) {
        j().a(str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2944wa, io.appmetrica.analytics.impl.Na
    public final Ma a() {
        return this.g;
    }
}
