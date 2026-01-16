package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class K implements Callable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Uh b;
    public final /* synthetic */ S c;

    public K(S s, Context context, Uh uh) {
        this.c = s;
        this.a = context;
        this.b = uh;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        AdvertisingIdsHolder advertisingIdsHolder = this.c.m;
        S s = this.c;
        AdTrackingInfoResult adTrackingInfoResultA = S.a(s, this.a);
        AdTrackingInfoResult google = advertisingIdsHolder.getGoogle();
        IdentifierStatus identifierStatus = adTrackingInfoResultA.mStatus;
        IdentifierStatus identifierStatus2 = IdentifierStatus.OK;
        if (identifierStatus != identifierStatus2) {
            adTrackingInfoResultA = new AdTrackingInfoResult(google.mAdTrackingInfo, identifierStatus, adTrackingInfoResultA.mErrorExplanation);
        }
        AdTrackingInfoResult adTrackingInfoResultB = S.b(this.c, this.a);
        AdTrackingInfoResult huawei = advertisingIdsHolder.getHuawei();
        IdentifierStatus identifierStatus3 = adTrackingInfoResultB.mStatus;
        if (identifierStatus3 != identifierStatus2) {
            adTrackingInfoResultB = new AdTrackingInfoResult(huawei.mAdTrackingInfo, identifierStatus3, adTrackingInfoResultB.mErrorExplanation);
        }
        S s2 = this.c;
        AdTrackingInfoResult adTrackingInfoResultA2 = s2.g.a(s2.c) ? s2.j.a(this.a, this.b) : new AdTrackingInfoResult(null, IdentifierStatus.UNKNOWN, "identifiers collecting is forbidden for unknown reason");
        AdTrackingInfoResult yandex = advertisingIdsHolder.getYandex();
        IdentifierStatus identifierStatus4 = adTrackingInfoResultA2.mStatus;
        if (identifierStatus4 != identifierStatus2) {
            adTrackingInfoResultA2 = new AdTrackingInfoResult(yandex.mAdTrackingInfo, identifierStatus4, adTrackingInfoResultA2.mErrorExplanation);
        }
        s.m = new AdvertisingIdsHolder(adTrackingInfoResultA, adTrackingInfoResultB, adTrackingInfoResultA2);
        return null;
    }
}
