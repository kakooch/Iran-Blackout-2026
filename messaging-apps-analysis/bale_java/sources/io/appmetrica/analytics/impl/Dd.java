package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import ir.nasim.AbstractC13042fc3;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final class Dd implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Integer fromModel(Boolean bool) {
        int i;
        if (bool == null) {
            i = -1;
        } else if (AbstractC13042fc3.d(bool, Boolean.TRUE)) {
            i = 1;
        } else {
            if (!AbstractC13042fc3.d(bool, Boolean.FALSE)) {
                throw new NoWhenBranchMatchedException();
            }
            i = 0;
        }
        return Integer.valueOf(i);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object toModel(Object obj) {
        return a(((Number) obj).intValue());
    }

    public final Boolean a(int i) {
        if (i != -1) {
            if (i == 0) {
                return Boolean.FALSE;
            }
            if (i == 1) {
                return Boolean.TRUE;
            }
        }
        return null;
    }
}
