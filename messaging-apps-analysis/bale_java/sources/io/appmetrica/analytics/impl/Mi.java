package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;

/* loaded from: classes3.dex */
public final class Mi implements Ka {
    public final /* synthetic */ ECommerceEvent a;

    public Mi(ECommerceEvent eCommerceEvent) {
        this.a = eCommerceEvent;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.reportECommerce(this.a);
    }
}
