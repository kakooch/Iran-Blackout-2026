package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* loaded from: classes3.dex */
public final class Y implements ProtobufConverter {
    public final U a;
    public final C2582h6 b;

    public Y() {
        this(new U(new C2884tm()), new C2582h6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final T5 fromModel(X x) {
        T5 t5 = new T5();
        t5.a = this.a.fromModel(x.a);
        String str = x.b;
        if (str != null) {
            t5.b = str;
        }
        t5.c = this.b.a(x.c);
        return t5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Y(U u, C2582h6 c2582h6) {
        this.a = u;
        this.b = c2582h6;
    }

    public final X a(T5 t5) {
        throw new UnsupportedOperationException();
    }
}
