package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;

/* loaded from: classes3.dex */
public final class Ue implements Converter {
    public final C2681la a;

    public Ue() {
        this(new C2681la(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Rh fromModel(List<String> list) {
        Im imA = this.a.a((List<Object>) list);
        List list2 = (List) imA.a;
        C2631j8[] c2631j8Arr = new C2631j8[0];
        if (list2 != null) {
            c2631j8Arr = new C2631j8[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                C2631j8 c2631j8 = new C2631j8();
                c2631j8Arr[i] = c2631j8;
                c2631j8.a = StringUtils.getUTF8Bytes((String) list2.get(i));
            }
        }
        imA.b.getBytesTruncated();
        return new Rh(c2631j8Arr, imA.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Ue(C2681la c2681la) {
        this.a = c2681la;
    }

    public final List<String> a(Rh rh) {
        throw new UnsupportedOperationException();
    }
}
