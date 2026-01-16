package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;

/* loaded from: classes3.dex */
public final class Q4 extends Wg {
    public Q4(Oe oe) {
        super(oe, new CounterConfiguration());
        b().setReporterType(CounterConfigurationReporterType.COMMUTATION);
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean f() {
        return true;
    }
}
