package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.internal.CounterConfiguration;

/* renamed from: io.appmetrica.analytics.impl.hc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2588hc extends Q2 {
    public C2588hc(Context context, Oe oe, ReporterConfig reporterConfig, Lh lh, G9 g9) {
        this(context, lh, new Wg(oe, new CounterConfiguration(reporterConfig), reporterConfig.userProfileID), g9, C2747o4.g().j(), new Nm(), new Tf(), new C2844s6(), new Y(), new Yd(g9));
    }

    @Override // io.appmetrica.analytics.impl.Q2
    public final String j() {
        return "[ManualReporter]";
    }

    public C2588hc(Context context, Lh lh, Wg wg, G9 g9, Sb sb, Nm nm, Tf tf, C2844s6 c2844s6, Y y, Yd yd) {
        super(context, lh, wg, g9, sb, nm, tf, c2844s6, y, yd);
        C2747o4.g().getClass();
    }
}
