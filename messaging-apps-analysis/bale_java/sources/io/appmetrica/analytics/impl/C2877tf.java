package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* renamed from: io.appmetrica.analytics.impl.tf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2877tf implements Converter {
    public final C2713mi a;
    public final C2705ma b;
    public final C2705ma c;

    public C2877tf() {
        this(new C2713mi(), new C2705ma(100), new C2705ma(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Rh fromModel(Mf mf) {
        Rh rhFromModel;
        C2655k8 c2655k8 = new C2655k8();
        Im imA = this.b.a(mf.a);
        c2655k8.a = StringUtils.getUTF8Bytes((String) imA.a);
        Im imA2 = this.c.a(mf.b);
        c2655k8.b = StringUtils.getUTF8Bytes((String) imA2.a);
        C2809qi c2809qi = mf.c;
        if (c2809qi != null) {
            rhFromModel = this.a.fromModel(c2809qi);
            c2655k8.c = (C2679l8) rhFromModel.a;
        } else {
            rhFromModel = null;
        }
        return new Rh(c2655k8, new C2817r3(C2817r3.b(imA, imA2, rhFromModel)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C2877tf(C2713mi c2713mi, C2705ma c2705ma, C2705ma c2705ma2) {
        this.a = c2713mi;
        this.b = c2705ma;
        this.c = c2705ma2;
    }

    public final Mf a(Rh rh) {
        throw new UnsupportedOperationException();
    }
}
