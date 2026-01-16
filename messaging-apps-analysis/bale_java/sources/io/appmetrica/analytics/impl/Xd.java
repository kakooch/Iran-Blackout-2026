package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import ir.nasim.C12275eL0;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Xd implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final U5[] fromModel(Map<String, String> map) {
        int size = map.size();
        U5[] u5Arr = new U5[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            u5Arr[i2] = new U5();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            U5 u5 = u5Arr[i];
            String key = entry.getKey();
            Charset charset = C12275eL0.b;
            u5.a = key.getBytes(charset);
            u5Arr[i].b = entry.getValue().getBytes(charset);
            i++;
        }
        return u5Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Map<String, String> a(U5[] u5Arr) {
        throw new UnsupportedOperationException();
    }
}
