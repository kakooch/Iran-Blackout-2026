package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public final class B3 {
    public final Te a;
    public final BigDecimal b;
    public final Me c;
    public final Mf d;

    public B3(ECommerceCartItem eCommerceCartItem) {
        this(new Te(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new Me(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new Mf(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + '}';
    }

    public B3(Te te, BigDecimal bigDecimal, Me me2, Mf mf) {
        this.a = te;
        this.b = bigDecimal;
        this.c = me2;
        this.d = mf;
    }
}
