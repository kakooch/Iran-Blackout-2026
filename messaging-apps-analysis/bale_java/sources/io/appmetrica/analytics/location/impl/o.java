package io.appmetrica.analytics.location.impl;

import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;

/* loaded from: classes3.dex */
public final class o implements LocationReceiverProviderFactory {
    public final q a;

    public o(q qVar) {
        this.a = qVar;
    }

    public final q a() {
        return this.a;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory
    public final LocationReceiverProvider getPassiveLocationReceiverProvider() {
        return this.a;
    }
}
