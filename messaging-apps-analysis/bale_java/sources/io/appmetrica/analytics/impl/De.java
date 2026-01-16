package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;

/* loaded from: classes3.dex */
public final class De implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Integer fromModel(M7 m7) {
        int iOrdinal = m7.ordinal();
        if (iOrdinal == 1) {
            return 1;
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? 0 : 2;
        }
        return 3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final M7 toModel(Integer num) {
        int iIntValue = num.intValue();
        if (iIntValue == 1) {
            return M7.c;
        }
        if (iIntValue == 2) {
            return M7.e;
        }
        if (iIntValue != 3) {
            return M7.b;
        }
        return M7.d;
    }
}
