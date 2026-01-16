package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.ck, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2474ck extends ECommerceEvent {
    public final Te a;
    public final Mf b;
    public final W7 c;

    public C2474ck(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new Te(eCommerceProduct), eCommerceReferrer == null ? null : new Mf(eCommerceReferrer), new C2499dk());
    }

    public final W7 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product details info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.We
    public final List<Rh> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductDetailInfoEvent{product=" + this.a + ", referrer=" + this.b + ", converter=" + this.c + '}';
    }

    public C2474ck(Te te, Mf mf, W7 w7) {
        this.a = te;
        this.b = mf;
        this.c = w7;
    }
}
