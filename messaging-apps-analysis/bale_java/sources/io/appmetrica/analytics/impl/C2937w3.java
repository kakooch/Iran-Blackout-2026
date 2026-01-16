package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* renamed from: io.appmetrica.analytics.impl.w3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2937w3 implements ProtobufConverter {
    public final C2788pl a(C2889u3 c2889u3) {
        C2788pl c2788pl = new C2788pl();
        c2788pl.a = c2889u3.a;
        return c2788pl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        C2788pl c2788pl = new C2788pl();
        c2788pl.a = ((C2889u3) obj).a;
        return c2788pl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C2889u3(((C2788pl) obj).a);
    }

    public final C2889u3 a(C2788pl c2788pl) {
        return new C2889u3(c2788pl.a);
    }
}
