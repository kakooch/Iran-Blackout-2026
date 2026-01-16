package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* loaded from: classes3.dex */
public final class Ah implements Ma {
    @Override // io.appmetrica.analytics.impl.Ma, io.appmetrica.analytics.impl.Na
    public final Ma a() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ma
    public final Ca b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new C2564gc();
    }

    @Override // io.appmetrica.analytics.impl.Ma
    public final void a(ReporterConfig reporterConfig) {
    }

    @Override // io.appmetrica.analytics.impl.Ma
    public final La b(ReporterConfig reporterConfig) {
        return new C2975xh();
    }

    @Override // io.appmetrica.analytics.impl.Ma
    public final Ca a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        return new C2564gc();
    }

    @Override // io.appmetrica.analytics.impl.Ma
    public final Oa b(AppMetricaConfig appMetricaConfig) {
        return new C2975xh();
    }
}
