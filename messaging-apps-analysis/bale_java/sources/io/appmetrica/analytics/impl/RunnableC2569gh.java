package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;

/* renamed from: io.appmetrica.analytics.impl.gh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC2569gh implements Runnable {
    public final /* synthetic */ ECommerceEvent a;
    public final /* synthetic */ C2951wh b;

    public RunnableC2569gh(C2951wh c2951wh, ECommerceEvent eCommerceEvent) {
        this.b = c2951wh;
        this.a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2951wh c2951wh = this.b;
        C2951wh.a(c2951wh.a, c2951wh.d, c2951wh.e).reportECommerce(this.a);
    }
}
