package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfo;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;

/* loaded from: classes3.dex */
public final class G implements D {
    public final D a;

    public G(D d) {
        this.a = d;
    }

    @Override // io.appmetrica.analytics.impl.D
    public final AdTrackingInfoResult a(Context context) {
        return a(new E(this, context));
    }

    @Override // io.appmetrica.analytics.impl.D
    public final AdTrackingInfoResult a(Context context, Uh uh) {
        return a(new F(this, context, uh));
    }

    public static AdTrackingInfoResult a(Provider provider) {
        AdTrackingInfoResult adTrackingInfoResult = (AdTrackingInfoResult) provider.get();
        AdTrackingInfo adTrackingInfo = adTrackingInfoResult.mAdTrackingInfo;
        return (adTrackingInfo == null || !"00000000-0000-0000-0000-000000000000".equals(adTrackingInfo.advId)) ? adTrackingInfoResult : new AdTrackingInfoResult(null, IdentifierStatus.INVALID_ADV_ID, "AdvId is invalid: 00000000-0000-0000-0000-000000000000");
    }
}
