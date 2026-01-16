package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC19460qO3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.XV4;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.t6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2868t6 implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2812ql[] fromModel(Map<String, ? extends List<String>> map) {
        C2812ql[] c2812qlArr = new C2812ql[map.size()];
        int i = 0;
        for (Object obj : map.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            Map.Entry entry = (Map.Entry) obj;
            C2812ql c2812ql = new C2812ql();
            c2812ql.a = (String) entry.getKey();
            Object[] array = ((Collection) entry.getValue()).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            c2812ql.b = (String[]) array;
            c2812qlArr[i] = c2812ql;
            i = i2;
        }
        return c2812qlArr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Map<String, List<String>> toModel(C2812ql[] c2812qlArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(c2812qlArr.length), 16));
        for (C2812ql c2812ql : c2812qlArr) {
            XV4 xv4A = AbstractC4616Fw7.a(c2812ql.a, AbstractC10242bK.f1(c2812ql.b));
            linkedHashMap.put(xv4A.e(), xv4A.f());
        }
        return linkedHashMap;
    }
}
