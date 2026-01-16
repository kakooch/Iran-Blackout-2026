package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.network.NetworkClientWithCacheControl;
import io.appmetrica.analytics.modulesapi.internal.network.SimpleNetworkApi;
import io.appmetrica.analytics.networktasks.internal.CacheControlHttpsConnectionPerformer;

/* renamed from: io.appmetrica.analytics.impl.rk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2834rk implements SimpleNetworkApi {
    public final CacheControlHttpsConnectionPerformer a = new CacheControlHttpsConnectionPerformer(((C3026zk) C2586ha.h().x()).getSslSocketFactory());

    @Override // io.appmetrica.analytics.modulesapi.internal.network.SimpleNetworkApi
    public final void performRequestWithCacheControl(String str, NetworkClientWithCacheControl networkClientWithCacheControl) {
        this.a.performConnection(str, new C2913v3(networkClientWithCacheControl));
    }
}
