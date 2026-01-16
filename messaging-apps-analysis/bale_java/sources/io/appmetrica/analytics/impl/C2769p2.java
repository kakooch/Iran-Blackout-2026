package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* renamed from: io.appmetrica.analytics.impl.p2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2769p2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2764ol fromModel(BillingConfig billingConfig) {
        C2764ol c2764ol = new C2764ol();
        c2764ol.a = billingConfig.sendFrequencySeconds;
        c2764ol.b = billingConfig.firstCollectingInappMaxAgeSeconds;
        return c2764ol;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C2764ol c2764ol = (C2764ol) obj;
        return new BillingConfig(c2764ol.a, c2764ol.b);
    }

    public final BillingConfig a(C2764ol c2764ol) {
        return new BillingConfig(c2764ol.a, c2764ol.b);
    }
}
