package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;

/* loaded from: classes3.dex */
public final class O0 implements Runnable {
    public final /* synthetic */ ECommerceEvent a;
    public final /* synthetic */ C2601i1 b;

    public O0(C2601i1 c2601i1, ECommerceEvent eCommerceEvent) {
        this.b = c2601i1;
        this.a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2601i1.a(this.b).reportECommerce(this.a);
    }
}
