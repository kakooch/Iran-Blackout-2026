package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* renamed from: io.appmetrica.analytics.impl.k9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2656k9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2609i9 fromModel(C2632j9 c2632j9) {
        C2609i9 c2609i9 = new C2609i9();
        String str = c2632j9.a;
        if (str != null) {
            c2609i9.a = str.getBytes();
        }
        return c2609i9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2632j9 toModel(C2609i9 c2609i9) {
        return new C2632j9(new String(c2609i9.a));
    }
}
