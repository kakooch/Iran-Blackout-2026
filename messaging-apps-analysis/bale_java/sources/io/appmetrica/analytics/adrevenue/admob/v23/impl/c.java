package io.appmetrica.analytics.adrevenue.admob.v23.impl;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdType;

/* loaded from: classes3.dex */
public final class c extends d {
    public c(b bVar, ClientContext clientContext) {
        super(bVar, clientContext);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor
    public final boolean process(Object... objArr) {
        if (!ReflectionUtils.isArgumentsOfClasses(objArr, AdValue.class, AdView.class)) {
            return false;
        }
        AdValue adValue = (AdValue) objArr[0];
        AdView adView = (AdView) objArr[1];
        this.a.getClass();
        a(b.a(adValue, ModuleAdType.BANNER, adView.getResponseInfo(), adView.getAdUnitId()));
        return true;
    }
}
