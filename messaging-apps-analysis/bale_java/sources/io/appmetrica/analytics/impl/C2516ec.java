package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* renamed from: io.appmetrica.analytics.impl.ec, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2516ec {
    public final Context a;
    public final Lh b;
    public final Sm c;
    public final Sm d;
    public final C2442bd e;
    public final G9 f;
    public final Wg g;
    public final C2530f2 h;
    public final C2897ub i;
    public final Sb j;
    public final r k;
    public final Yd l;
    public final Nm m;
    public final Tf n;
    public final C2844s6 o;
    public final Y p;

    public C2516ec(Context context, Na na, Oe oe, Lh lh, Nk nk) {
        this.a = context;
        this.b = lh;
        this.c = new Sm(na, "20799a27-fa80-4b36-b2db-0f8141f24180");
        this.d = new Sm(na, "0e5e9c33-f8c3-4568-86c5-2e4f57523f72");
        this.e = new C2442bd(oe);
        G9 g9 = new G9(context);
        this.f = g9;
        this.g = new Wg(oe, new CounterConfiguration(CounterConfigurationReporterType.MAIN));
        this.h = new C2530f2();
        this.i = new C2897ub();
        this.j = C2747o4.g().j();
        this.k = new r();
        this.l = new Yd(g9);
        this.m = new Nm();
        this.n = new Tf();
        this.o = new C2844s6();
        this.p = new Y();
    }

    public final Y a() {
        return this.p;
    }

    public final Context b() {
        return this.a;
    }

    public final C2844s6 c() {
        return this.o;
    }

    public final G9 d() {
        return this.f;
    }

    public final Yd e() {
        return this.l;
    }

    public final Sb f() {
        return this.j;
    }

    public final Tf g() {
        return this.n;
    }

    public final Wg h() {
        return this.g;
    }

    public final Lh i() {
        return this.b;
    }

    public final Nm j() {
        return this.m;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.g.b.applyFromConfig(appMetricaConfig);
        Wg wg = this.g;
        String str = appMetricaConfig.userProfileID;
        synchronized (wg) {
            wg.f = str;
        }
        Wg wg2 = this.g;
        PreloadInfo preloadInfo = appMetricaConfig.preloadInfo;
        Boolean bool = (Boolean) appMetricaConfig.additionalConfig.get("YMM_preloadInfoAutoTracking");
        wg2.d = new Ie(preloadInfo, publicLogger, bool != null ? bool.booleanValue() : false);
        StringBuilder sb = new StringBuilder("Actual session timeout is ");
        Integer num = appMetricaConfig.sessionTimeout;
        if (num == null) {
            num = 10;
        }
        sb.append(num.intValue());
        publicLogger.info(sb.toString(), new Object[0]);
    }
}
