package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;

/* renamed from: io.appmetrica.analytics.impl.s2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2840s2 implements ProtobufConverter {
    public final C2432b3 a;

    public C2840s2() {
        this(new C2432b3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2888u2 fromModel(C2816r2 c2816r2) {
        C2888u2 c2888u2 = new C2888u2();
        c2888u2.a = new C2864t2[c2816r2.a.size()];
        int i = 0;
        for (BillingInfo billingInfo : c2816r2.a) {
            C2864t2[] c2864t2Arr = c2888u2.a;
            this.a.getClass();
            c2864t2Arr[i] = C2432b3.a(billingInfo);
            i++;
        }
        c2888u2.b = c2816r2.b;
        return c2888u2;
    }

    public C2840s2(C2432b3 c2432b3) {
        this.a = c2432b3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2816r2 toModel(C2888u2 c2888u2) {
        ProductType productType;
        ArrayList arrayList = new ArrayList(c2888u2.a.length);
        for (C2864t2 c2864t2 : c2888u2.a) {
            this.a.getClass();
            int i = c2864t2.a;
            if (i == 2) {
                productType = ProductType.INAPP;
            } else if (i != 3) {
                productType = ProductType.UNKNOWN;
            } else {
                productType = ProductType.SUBS;
            }
            arrayList.add(new BillingInfo(productType, c2864t2.b, c2864t2.c, c2864t2.d, c2864t2.e));
        }
        return new C2816r2(arrayList, c2888u2.b);
    }
}
