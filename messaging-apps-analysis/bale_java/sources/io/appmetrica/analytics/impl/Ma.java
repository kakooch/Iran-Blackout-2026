package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* loaded from: classes3.dex */
public interface Ma extends Na {
    Ca a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    @Override // io.appmetrica.analytics.impl.Na
    /* synthetic */ Ma a();

    void a(ReporterConfig reporterConfig);

    Ca b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z);

    La b(ReporterConfig reporterConfig);

    Oa b(AppMetricaConfig appMetricaConfig);
}
