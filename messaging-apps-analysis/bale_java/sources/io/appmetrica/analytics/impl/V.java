package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* loaded from: classes3.dex */
public final class V implements Converter {
    public final C2869t7 a;
    public final C2705ma b;

    public V() {
        this(new C2869t7(), new C2705ma(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Rh fromModel(W w) {
        X7 x7 = new X7();
        x7.b = this.a.fromModel(w.a);
        Im imA = this.b.a(w.b);
        x7.a = StringUtils.getUTF8Bytes((String) imA.a);
        return new Rh(x7, new C2817r3(C2817r3.b(imA)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public V(C2869t7 c2869t7, C2705ma c2705ma) {
        this.a = c2869t7;
        this.b = c2705ma;
    }

    public final W a(Rh rh) {
        throw new UnsupportedOperationException();
    }
}
