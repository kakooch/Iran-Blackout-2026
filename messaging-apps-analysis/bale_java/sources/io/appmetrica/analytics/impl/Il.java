package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* loaded from: classes3.dex */
public final class Il implements ProtobufConverter {
    public final C2955wl a(Hl hl) {
        C2955wl c2955wl = new C2955wl();
        c2955wl.a = hl.a;
        return c2955wl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C2955wl c2955wl = new C2955wl();
        c2955wl.a = ((Hl) obj).a;
        return c2955wl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Hl(((C2955wl) obj).a);
    }

    public final Hl a(C2955wl c2955wl) {
        return new Hl(c2955wl.a);
    }
}
