package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;

/* loaded from: classes3.dex */
public final class M5 extends BaseRequestConfig.DataSource {
    public final C2549fl a;
    public final SdkEnvironmentProvider b;

    public M5(C2549fl c2549fl, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(c2549fl.f(), c2549fl.b(), c2549fl.c()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.a = c2549fl;
        this.b = sdkEnvironmentProvider;
    }
}
