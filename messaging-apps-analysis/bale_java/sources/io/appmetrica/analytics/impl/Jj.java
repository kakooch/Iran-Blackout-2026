package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import ir.nasim.AbstractC19460qO3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.C12275eL0;
import ir.nasim.XV4;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Jj implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Lj fromModel(Map<String, byte[]> map) {
        Lj lj = new Lj();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            Mj mj = new Mj();
            mj.a = entry.getKey().getBytes(C12275eL0.b);
            mj.b = entry.getValue();
            arrayList.add(mj);
        }
        Object[] array = arrayList.toArray(new Mj[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        lj.a = (Mj[]) array;
        return lj;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Map<String, byte[]> toModel(Lj lj) {
        Mj[] mjArr = lj.a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(mjArr.length), 16));
        for (Mj mj : mjArr) {
            XV4 xv4A = AbstractC4616Fw7.a(new String(mj.a, C12275eL0.b), mj.b);
            linkedHashMap.put(xv4A.e(), xv4A.f());
        }
        return linkedHashMap;
    }
}
