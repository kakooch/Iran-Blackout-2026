package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import java.util.List;

/* loaded from: classes3.dex */
public final class Fd extends ECommerceEvent {
    public static final int d = 6;
    public static final int e = 7;
    public final int a;
    public final Hd b;
    public final W7 c;

    public Fd(int i, ECommerceOrder eCommerceOrder) {
        this(i, new Hd(eCommerceOrder), new Gd());
    }

    public final W7 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "order info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.We
    public final List<Rh> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "OrderInfoEvent{eventType=" + this.a + ", order=" + this.b + ", converter=" + this.c + '}';
    }

    public Fd(int i, Hd hd, W7 w7) {
        this.a = i;
        this.b = hd;
        this.c = w7;
    }
}
