package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ReporterConfig;

/* renamed from: io.appmetrica.analytics.impl.jh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2640jh implements Runnable {
    public final /* synthetic */ ReporterConfig a;
    public final /* synthetic */ C2951wh b;

    public RunnableC2640jh(C2951wh c2951wh, ReporterConfig reporterConfig) {
        this.b = c2951wh;
        this.a = reporterConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.b;
        ReporterConfig reporterConfig = this.a;
        C2743o0 c2743o0 = c2951wh.a;
        Context context = c2951wh.d;
        c2743o0.getClass();
        C2719n0.a(context, false).j().a(reporterConfig);
    }
}
