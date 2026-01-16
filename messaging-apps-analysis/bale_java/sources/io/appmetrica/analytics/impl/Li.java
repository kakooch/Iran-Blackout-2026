package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;

/* loaded from: classes3.dex */
public final class Li implements Ka {
    public final /* synthetic */ Revenue a;

    public Li(Revenue revenue) {
        this.a = revenue;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.reportRevenue(this.a);
    }
}
