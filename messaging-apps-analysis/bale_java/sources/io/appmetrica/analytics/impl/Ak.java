package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class Ak implements ListConverter {
    public final Bk a = new Bk();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2410a6[] fromModel(List<Ck> list) {
        C2410a6[] c2410a6Arr = new C2410a6[list.size()];
        Iterator<Ck> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            c2410a6Arr[i] = this.a.fromModel(it.next());
            i++;
        }
        return c2410a6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final List<Ck> a(C2410a6[] c2410a6Arr) {
        throw new UnsupportedOperationException();
    }
}
