package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC19460qO3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.XV4;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class C8 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final byte[] fromModel(Map<String, byte[]> map) {
        E8 e8 = new E8();
        D8[] d8Arr = new D8[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            Map.Entry entry = (Map.Entry) obj;
            D8 d8 = new D8();
            d8.a = (String) entry.getKey();
            d8.b = (byte[]) entry.getValue();
            d8Arr[i] = d8;
            i = i2;
        }
        e8.a = d8Arr;
        return MessageNano.toByteArray(e8);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Map<String, byte[]> toModel(byte[] bArr) {
        D8[] d8Arr = ((E8) MessageNano.mergeFrom(new E8(), bArr)).a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(d8Arr.length), 16));
        for (D8 d8 : d8Arr) {
            XV4 xv4A = AbstractC4616Fw7.a(d8.a, d8.b);
            linkedHashMap.put(xv4A.e(), xv4A.f());
        }
        return linkedHashMap;
    }
}
