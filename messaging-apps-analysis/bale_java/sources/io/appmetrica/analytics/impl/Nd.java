package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* loaded from: classes3.dex */
public final class Nd implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2907ul fromModel(Md md) {
        C2907ul c2907ul = new C2907ul();
        c2907ul.a = md.a;
        c2907ul.b = md.b;
        return c2907ul;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C2907ul c2907ul = (C2907ul) obj;
        return new Md(c2907ul.a, c2907ul.b);
    }

    public final Md a(C2907ul c2907ul) {
        return new Md(c2907ul.a, c2907ul.b);
    }
}
