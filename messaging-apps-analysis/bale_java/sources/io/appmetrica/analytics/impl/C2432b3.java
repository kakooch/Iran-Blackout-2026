package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* renamed from: io.appmetrica.analytics.impl.b3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2432b3 implements ProtobufConverter {
    public static C2864t2 a(BillingInfo billingInfo) {
        C2864t2 c2864t2 = new C2864t2();
        int i = AbstractC2407a3.a[billingInfo.type.ordinal()];
        c2864t2.a = i != 1 ? i != 2 ? 1 : 3 : 2;
        c2864t2.b = billingInfo.productId;
        c2864t2.c = billingInfo.purchaseToken;
        c2864t2.d = billingInfo.purchaseTime;
        c2864t2.e = billingInfo.sendTime;
        return c2864t2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((BillingInfo) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C2864t2 c2864t2 = (C2864t2) obj;
        int i = c2864t2.a;
        return new BillingInfo(i != 2 ? i != 3 ? ProductType.UNKNOWN : ProductType.SUBS : ProductType.INAPP, c2864t2.b, c2864t2.c, c2864t2.d, c2864t2.e);
    }
}
