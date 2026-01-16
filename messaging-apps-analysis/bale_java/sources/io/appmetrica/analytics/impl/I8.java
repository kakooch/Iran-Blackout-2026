package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class I8 implements ProtobufConverter {
    public static C2728n9 a(H8 h8) {
        C2728n9 c2728n9 = new C2728n9();
        c2728n9.d = new int[h8.b.size()];
        Iterator it = h8.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            c2728n9.d[i] = ((Integer) it.next()).intValue();
            i++;
        }
        c2728n9.c = h8.d;
        c2728n9.b = h8.c;
        c2728n9.a = h8.a;
        return c2728n9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((H8) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C2728n9 c2728n9 = (C2728n9) obj;
        return new H8(c2728n9.a, c2728n9.b, c2728n9.c, CollectionUtils.hashSetFromIntArray(c2728n9.d));
    }
}
