package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionResolutionStrategy;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.cache.CachedDataProvider;
import io.appmetrica.analytics.coreutils.internal.permission.AlwaysAllowPermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.permission.SinglePermissionStrategy;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.util.concurrent.TimeUnit;

/* renamed from: io.appmetrica.analytics.impl.tc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2874tc implements InterfaceC2741nm {
    public final Context a;
    public final PermissionResolutionStrategy b;
    public final CellularNetworkTypeExtractor c;
    public final CachedDataProvider.CachedData d;

    public C2874tc(Context context) {
        this.a = context;
        this.b = AndroidUtils.isApiAchieved(29) ? new SinglePermissionStrategy(C2586ha.h().g(), "android.permission.READ_PHONE_STATE") : new AlwaysAllowPermissionStrategy();
        this.c = new CellularNetworkTypeExtractor(context);
        long millis = TimeUnit.SECONDS.toMillis(20L);
        this.d = new CachedDataProvider.CachedData(millis, millis * 2, "mobile-connection");
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2741nm
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final synchronized C2850sc a() {
        C2850sc c2850sc;
        try {
            c2850sc = (C2850sc) this.d.getData();
            if (c2850sc == null || this.d.shouldUpdateData()) {
                c2850sc = new C2850sc(this.b.hasNecessaryPermissions(this.a) ? this.c.getNetworkType() : CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE);
                this.d.setData(c2850sc);
            }
        } catch (Throwable th) {
            throw th;
        }
        return c2850sc;
    }
}
