package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;

/* loaded from: classes3.dex */
public final class Rb extends Sm {
    public final AppMetricaConfig c;

    public Rb(Na na, AppMetricaConfig appMetricaConfig) {
        super(na, appMetricaConfig.apiKey);
        this.c = appMetricaConfig;
    }

    @Override // io.appmetrica.analytics.impl.Sm
    public final Oa a() {
        return this.b.a().b(this.c);
    }
}
