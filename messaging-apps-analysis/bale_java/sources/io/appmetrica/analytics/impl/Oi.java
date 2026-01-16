package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;

/* loaded from: classes3.dex */
public final class Oi implements Ka {
    public final /* synthetic */ AdRevenue a;

    public Oi(AdRevenue adRevenue) {
        this.a = adRevenue;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.reportAdRevenue(this.a);
    }
}
