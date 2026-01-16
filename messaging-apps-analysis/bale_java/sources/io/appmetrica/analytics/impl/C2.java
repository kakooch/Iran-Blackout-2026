package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* loaded from: classes3.dex */
public final class C2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final W1 fromModel(E2 e2) {
        W1 w1 = new W1();
        D2 d2 = e2.a;
        if (d2 != null) {
            int iOrdinal = d2.ordinal();
            if (iOrdinal == 0) {
                w1.a = 1;
            } else if (iOrdinal == 1) {
                w1.a = 2;
            } else if (iOrdinal == 2) {
                w1.a = 3;
            } else if (iOrdinal == 3) {
                w1.a = 4;
            } else if (iOrdinal == 4) {
                w1.a = 5;
            }
        }
        Boolean bool = e2.b;
        if (bool != null) {
            if (bool.booleanValue()) {
                w1.b = 1;
            } else {
                w1.b = 0;
            }
        }
        return w1;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final E2 toModel(W1 w1) {
        D2 d2;
        int i = w1.a;
        Boolean bool = null;
        if (i == 1) {
            d2 = D2.ACTIVE;
        } else if (i == 2) {
            d2 = D2.WORKING_SET;
        } else if (i == 3) {
            d2 = D2.FREQUENT;
        } else if (i != 4) {
            d2 = i != 5 ? null : D2.RESTRICTED;
        } else {
            d2 = D2.RARE;
        }
        int i2 = w1.b;
        if (i2 == 0) {
            bool = Boolean.FALSE;
        } else if (i2 == 1) {
            bool = Boolean.TRUE;
        }
        return new E2(d2, bool);
    }
}
