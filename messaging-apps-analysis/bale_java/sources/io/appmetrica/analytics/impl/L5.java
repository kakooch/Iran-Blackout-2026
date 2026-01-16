package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueReporter;

/* loaded from: classes3.dex */
public final class L5 implements K5 {
    public final ModuleAdRevenueReporter a;
    public final C2700m5 b;

    public L5(ModuleAdRevenueReporter moduleAdRevenueReporter, C2700m5 c2700m5) {
        this.a = moduleAdRevenueReporter;
        this.b = c2700m5;
    }

    @Override // io.appmetrica.analytics.impl.K5, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final C2700m5 getAdRevenueProcessorsHolder() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.K5, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueReporter getAdRevenueReporter() {
        return this.a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueProcessorsHolder getAdRevenueProcessorsHolder() {
        return this.b;
    }
}
