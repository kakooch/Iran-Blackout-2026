package io.appmetrica.analytics.adrevenue.admob.v23.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenue;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;

/* loaded from: classes3.dex */
public abstract class d implements ModuleAdRevenueProcessor {
    protected final b a;
    public final ClientContext b;

    public d(b bVar, ClientContext clientContext) {
        this.a = bVar;
        this.b = clientContext;
    }

    public final void a(ModuleAdRevenue moduleAdRevenue) {
        this.b.getModuleAdRevenueContext().getAdRevenueReporter().reportAutoAdRevenue(moduleAdRevenue);
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Ad Revenue from AdMob was reported", new Object[0]);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final String getDescription() {
        return "AdMob";
    }
}
