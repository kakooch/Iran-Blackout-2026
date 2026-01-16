package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceReferrer;

/* loaded from: classes3.dex */
public final class Mf {
    public final String a;
    public final String b;
    public final C2809qi c;

    public Mf(ECommerceReferrer eCommerceReferrer) {
        this(eCommerceReferrer.getType(), eCommerceReferrer.getIdentifier(), eCommerceReferrer.getScreen() == null ? null : new C2809qi(eCommerceReferrer.getScreen()));
    }

    public final String toString() {
        return "ReferrerWrapper{type='" + this.a + "', identifier='" + this.b + "', screen=" + this.c + '}';
    }

    public Mf(String str, String str2, C2809qi c2809qi) {
        this.a = str;
        this.b = str2;
        this.c = c2809qi;
    }
}
