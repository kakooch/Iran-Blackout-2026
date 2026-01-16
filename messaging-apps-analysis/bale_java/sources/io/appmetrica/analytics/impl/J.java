package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class J implements Callable {
    public final /* synthetic */ S a;

    public J(S s) {
        this.a = s;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        S s = this.a;
        AdTrackingInfoResult adTrackingInfoResultA = S.a(s, s.k);
        S s2 = this.a;
        AdTrackingInfoResult adTrackingInfoResultB = S.b(s2, s2.k);
        S s3 = this.a;
        s.m = new AdvertisingIdsHolder(adTrackingInfoResultA, adTrackingInfoResultB, s3.g.a(s3.c) ? s3.j.a(s3.k, new C2780pd()) : new AdTrackingInfoResult(null, IdentifierStatus.UNKNOWN, "identifiers collecting is forbidden for unknown reason"));
        return null;
    }
}
