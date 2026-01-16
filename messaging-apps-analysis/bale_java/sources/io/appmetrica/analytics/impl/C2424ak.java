package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.ak, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2424ak extends ECommerceEvent {
    public final Te a;
    public final C2809qi b;
    public final W7 c;

    public C2424ak(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new Te(eCommerceProduct), new C2809qi(eCommerceScreen), new C2449bk());
    }

    public final W7 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product card info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.We
    public final List<Rh> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductCardInfoEvent{product=" + this.a + ", screen=" + this.b + ", converter=" + this.c + '}';
    }

    public C2424ak(Te te, C2809qi c2809qi, W7 w7) {
        this.a = te;
        this.b = c2809qi;
        this.c = w7;
    }
}
