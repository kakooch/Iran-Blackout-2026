package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.XV4;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Qc implements Converter {
    public final C3001yj a = C2586ha.h().m();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2883tl[] fromModel(Map<String, ? extends Object> map) {
        C2883tl c2883tl;
        Map<String, Fc> mapB = this.a.b();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Fc fc = mapB.get(key);
            if (fc == null || value == null) {
                c2883tl = null;
            } else {
                c2883tl = new C2883tl();
                c2883tl.a = key;
                c2883tl.b = (byte[]) fc.c.fromModel(value);
            }
            if (c2883tl != null) {
                arrayList.add(c2883tl);
            }
        }
        Object[] array = arrayList.toArray(new C2883tl[0]);
        if (array != null) {
            return (C2883tl[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Map<String, Object> toModel(C2883tl[] c2883tlArr) {
        Map<String, Fc> mapB = this.a.b();
        ArrayList arrayList = new ArrayList();
        for (C2883tl c2883tl : c2883tlArr) {
            Fc fc = mapB.get(c2883tl.a);
            XV4 xv4A = fc != null ? AbstractC4616Fw7.a(c2883tl.a, fc.c.toModel(c2883tl.b)) : null;
            if (xv4A != null) {
                arrayList.add(xv4A);
            }
        }
        return AbstractC20051rO3.w(arrayList);
    }
}
