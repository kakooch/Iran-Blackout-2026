package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;

/* loaded from: classes3.dex */
public final class Vi implements Ka {
    public final /* synthetic */ AdRevenue a;
    public final /* synthetic */ boolean b;

    public Vi(AdRevenue adRevenue, boolean z) {
        this.a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.reportAdRevenue(this.a, this.b);
    }
}
