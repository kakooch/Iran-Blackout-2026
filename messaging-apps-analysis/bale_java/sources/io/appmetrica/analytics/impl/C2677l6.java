package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;

/* renamed from: io.appmetrica.analytics.impl.l6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2677l6 extends Q2 {
    public final C2701m6 o;
    public final Om p;

    public C2677l6(Context context, Oe oe, AppMetricaConfig appMetricaConfig, Lh lh, G9 g9) {
        this(context, lh, new Wg(oe, new CounterConfiguration(appMetricaConfig, CounterConfigurationReporterType.CRASH), appMetricaConfig.userProfileID), g9, new C2701m6(context), new Om(), C2747o4.g().j(), new Nm(), new Tf(), new C2844s6(), new Y(), new Yd(g9));
    }

    @Override // io.appmetrica.analytics.impl.Q2, io.appmetrica.analytics.impl.La, io.appmetrica.analytics.impl.Oa
    public final void a(Mm mm) {
        this.o.a(this.p.a(mm, this.b));
        this.c.info("Unhandled exception received: " + mm, new Object[0]);
    }

    public final void b(AppMetricaConfig appMetricaConfig) {
        b(appMetricaConfig.errorEnvironment);
    }

    @Override // io.appmetrica.analytics.impl.Q2
    public final String j() {
        return "[CrashReporter]";
    }

    public C2677l6(Context context, Lh lh, Wg wg, G9 g9, C2701m6 c2701m6, Om om, Sb sb, Nm nm, Tf tf, C2844s6 c2844s6, Y y, Yd yd) {
        super(context, lh, wg, g9, sb, nm, tf, c2844s6, y, yd);
        this.o = c2701m6;
        this.p = om;
        C2747o4.g().getClass();
    }
}
