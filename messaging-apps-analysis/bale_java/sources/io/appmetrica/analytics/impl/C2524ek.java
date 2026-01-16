package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.ek, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2524ek extends ECommerceEvent {
    public final C2809qi a;
    public final W7 b;

    public C2524ek(ECommerceScreen eCommerceScreen) {
        this(new C2809qi(eCommerceScreen), new C2548fk());
    }

    public final W7 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.We
    public final List<Rh> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.a + ", converter=" + this.b + '}';
    }

    public C2524ek(C2809qi c2809qi, W7 w7) {
        this.a = c2809qi;
        this.b = w7;
    }
}
