package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;

/* loaded from: classes3.dex */
public final class Bk implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2410a6 fromModel(Ck ck) {
        C2410a6 c2410a6 = new C2410a6();
        c2410a6.a = (String) WrapUtils.getOrDefault(ck.a, c2410a6.a);
        c2410a6.b = (String) WrapUtils.getOrDefault(ck.b, c2410a6.b);
        c2410a6.c = ((Integer) WrapUtils.getOrDefault(ck.c, Integer.valueOf(c2410a6.c))).intValue();
        c2410a6.f = ((Integer) WrapUtils.getOrDefault(ck.d, Integer.valueOf(c2410a6.f))).intValue();
        c2410a6.d = (String) WrapUtils.getOrDefault(ck.e, c2410a6.d);
        c2410a6.e = ((Boolean) WrapUtils.getOrDefault(ck.f, Boolean.valueOf(c2410a6.e))).booleanValue();
        return c2410a6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Ck a(C2410a6 c2410a6) {
        throw new UnsupportedOperationException();
    }
}
