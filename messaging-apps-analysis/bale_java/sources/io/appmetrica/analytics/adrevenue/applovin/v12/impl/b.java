package io.appmetrica.analytics.adrevenue.applovin.v12.impl;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdk;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenue;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC4616Fw7;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b implements ModuleAdRevenueProcessor {
    public final a a;
    public final ClientContext b;

    public b(a aVar, ClientContext clientContext) {
        this.a = aVar;
        this.b = clientContext;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final String getDescription() {
        return "AppLovin";
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final boolean process(Object... objArr) {
        if (!ReflectionUtils.isArgumentsOfClasses(objArr, MaxAd.class, AppLovinSdk.class)) {
            return false;
        }
        Object objN0 = AbstractC10242bK.n0(objArr, 0);
        if (objN0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.applovin.mediation.MaxAd");
        }
        MaxAd maxAd = (MaxAd) objN0;
        Object objN02 = AbstractC10242bK.n0(objArr, 1);
        if (objN02 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.applovin.sdk.AppLovinSdk");
        }
        AppLovinSdk appLovinSdk = (AppLovinSdk) objN02;
        this.a.getClass();
        MaxAdFormat format = maxAd.getFormat();
        ModuleAdType moduleAdType = format == null ? null : AbstractC13042fc3.d(format, MaxAdFormat.NATIVE) ? ModuleAdType.NATIVE : AbstractC13042fc3.d(format, MaxAdFormat.BANNER) ? ModuleAdType.BANNER : AbstractC13042fc3.d(format, MaxAdFormat.REWARDED) ? ModuleAdType.REWARDED : AbstractC13042fc3.d(format, MaxAdFormat.INTERSTITIAL) ? ModuleAdType.INTERSTITIAL : AbstractC13042fc3.d(format, MaxAdFormat.MREC) ? ModuleAdType.MREC : ModuleAdType.OTHER;
        Map mapP = AbstractC20051rO3.p(AbstractC4616Fw7.a("countryCode", appLovinSdk.getConfiguration().getCountryCode()));
        if (moduleAdType == ModuleAdType.OTHER) {
            mapP.put("adType", maxAd.getFormat().getLabel());
        }
        this.b.getModuleAdRevenueContext().getAdRevenueReporter().reportAutoAdRevenue(new ModuleAdRevenue(BigDecimal.valueOf(WrapUtils.getFiniteDoubleOrDefault(maxAd.getRevenue(), 0.0d)), Currency.getInstance("USD"), moduleAdType, maxAd.getNetworkName(), maxAd.getAdUnitId(), null, maxAd.getNetworkPlacement(), maxAd.getPlacement(), maxAd.getRevenuePrecision(), mapP, false, 32, null));
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Ad Revenue from AppLovin with values " + Arrays.toString(objArr) + " was reported", new Object[0]);
        return true;
    }
}
