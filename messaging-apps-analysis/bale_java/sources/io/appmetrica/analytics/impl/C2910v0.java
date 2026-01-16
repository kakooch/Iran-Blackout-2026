package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.AdType;
import io.appmetrica.analytics.ModulesFacade;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenue;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueReporter;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: io.appmetrica.analytics.impl.v0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2910v0 implements ModuleAdRevenueReporter {
    public final C2946wc a = new C2946wc();

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueReporter
    public final void reportAutoAdRevenue(ModuleAdRevenue moduleAdRevenue) {
        AdType adType;
        this.a.getClass();
        AdRevenue.Builder builderNewBuilder = AdRevenue.newBuilder(moduleAdRevenue.getAdRevenue(), moduleAdRevenue.getCurrency());
        ModuleAdType adType2 = moduleAdRevenue.getAdType();
        switch (adType2 == null ? -1 : AbstractC2922vc.a[adType2.ordinal()]) {
            case -1:
                adType = null;
                break;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                adType = AdType.NATIVE;
                break;
            case 2:
                adType = AdType.BANNER;
                break;
            case 3:
                adType = AdType.REWARDED;
                break;
            case 4:
                adType = AdType.INTERSTITIAL;
                break;
            case 5:
                adType = AdType.MREC;
                break;
            case 6:
                adType = AdType.OTHER;
                break;
        }
        ModulesFacade.reportAdRevenue(builderNewBuilder.withAdType(adType).withAdNetwork(moduleAdRevenue.getAdNetwork()).withAdUnitId(moduleAdRevenue.getAdUnitId()).withAdUnitName(moduleAdRevenue.getAdUnitName()).withAdPlacementId(moduleAdRevenue.getAdPlacementId()).withAdPlacementName(moduleAdRevenue.getAdPlacementName()).withPrecision(moduleAdRevenue.getPrecision()).withPayload(moduleAdRevenue.getPayload()).build(), Boolean.valueOf(moduleAdRevenue.getAutoCollected()));
    }
}
