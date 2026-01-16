package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* loaded from: classes3.dex */
public final class El implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2931vl fromModel(Dl dl) {
        C2931vl c2931vl = new C2931vl();
        c2931vl.a = dl.a;
        return c2931vl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Dl(((C2931vl) obj).a);
    }

    public final Dl a(C2931vl c2931vl) {
        return new Dl(c2931vl.a);
    }
}
